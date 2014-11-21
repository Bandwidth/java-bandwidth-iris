package com.bandwidth.iris.sdk.model;

import com.bandwidth.iris.sdk.IrisClient;
import com.bandwidth.iris.sdk.IrisConstants;
import com.bandwidth.iris.sdk.IrisResponse;
import com.bandwidth.iris.sdk.utils.XmlUtils;
import org.apache.log4j.Logger;
import org.mortbay.jetty.HttpStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sbarstow on 11/14/14.
 */
@XmlRootElement(name = "Reservation")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reservation extends BaseModel {

    private static final Logger LOG = Logger.getLogger(Site.class);
    @XmlElement(name = "ReservationId")
    private String reservationId;
    @XmlElement(name = "AccountId")
    private String accountId;
    @XmlElement(name = "ReservationExpires")
    private String reservationExpires;
    @XmlElement(name = "ReservedTn")
    private List<String> reservedTn = new ArrayList<String>();

    public static Reservation create(IrisClient client, Reservation reservation) throws Exception {
        Reservation result = null;
        IrisResponse response = client.post(client.buildUserModelUri(new String[] { IrisConstants.RESERVATIONS_URI_PATH }),
                reservation);
        String id = client.getIdFromLocationHeader(response.getHeaders().get("Location"));
        result = get(client, id);
        if (response.getStatusCode() == HttpStatus.ORDINAL_400_Bad_Request) {
            ReservationResponse reservationResponse =
                    XmlUtils.fromXml(response.getResponseBody(), ReservationResponse.class);
            client.checkResponse(reservationResponse);
        }
        return result;
    }

    public static Reservation get(IrisClient client, String reservationId) throws Exception {
        ReservationResponse reservationResponse = client.get(client.buildUserModelUri(
                new String[] { IrisConstants.RESERVATIONS_URI_PATH, reservationId }), ReservationResponse.class);
        Reservation reservation = reservationResponse.getReservation();
        reservation.setClient(client);
        return reservation;
    }

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

    public void delete() throws Exception {
        client.delete(client.buildUserModelUri(new String[] { IrisConstants.RESERVATIONS_URI_PATH, reservationId }));
    }
}