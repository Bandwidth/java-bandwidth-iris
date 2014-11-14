package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisClientException;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.log4j.Logger;
import org.mortbay.jetty.HttpStatus;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name="Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation extends BaseModel {

    private static final Logger LOG = Logger.getLogger(Site.class);

    public static Reservation create(IrisClient client, Reservation reservation) throws IrisClientException {
        Reservation result = null;
        try {
            IrisResponse response = client.post(client.buildModelUri(new String[]{IrisConstants.RESERVATIONS_URI_PATH}),
                    reservation);
            if(response.isOK()){
                String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
                result = get(client, id);
            }else if(response.getStatusCode() == HttpStatus.ORDINAL_400_Bad_Request) {
                ReservationResponse reservationResponse = (ReservationResponse)
                        XmlUtils.fromXml(response.getResponseBody(), ReservationResponse.class);
                client.checkResponse(reservationResponse);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Reservation get(IrisClient client, String reservationId) throws IrisClientException {
        Reservation reservation = null;
        try {
            IrisResponse response = client.get(client.buildModelUri(
                    new String[] {IrisConstants.RESERVATIONS_URI_PATH, reservationId}));
            if(response.isOK()){
                ReservationResponse reservationResponse = (ReservationResponse) XmlUtils.fromXml(response.getResponseBody(),
                        ReservationResponse.class);
                client.checkResponse(reservationResponse);
                reservation = reservationResponse.getReservation();
                reservation.setClient(client);
            }
        }catch(Exception e){
            LOG.error("Could not retrieve reservation: " + e.getMessage());
            throw new IrisClientException(e);
        }
        return reservation;
    }

    @XmlElement(name="ReservationId")
    private String reservationId;

    @XmlElement(name="AccountId")
    private String accountId;

    @XmlElement(name="ReservationExpires")
    private String reservationExpires;


    @XmlElement(name="ReservedTn")
    private List<String> reservedTn = new ArrayList<String>();

    public List<String> getReservedTn() {
        return reservedTn;
    }

    public void setReservedTn(List<String> reservedTn) {
        this.reservedTn = reservedTn;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getReservationExpires() {
        return reservationExpires;
    }

    public void setReservationExpires(String reservationExpires) {
        this.reservationExpires = reservationExpires;
    }

    public void delete() throws IrisClientException{
        try {
            client.delete(client.buildModelUri(new String[]{IrisConstants.RESERVATIONS_URI_PATH, reservationId}));
        }catch(Exception e){
            LOG.error("Error deleting Reservation: " + e.getMessage());
            throw new IrisClientException(e);
        }
    }
}
