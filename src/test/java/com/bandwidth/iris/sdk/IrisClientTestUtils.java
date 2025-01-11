package com.bandwidth.iris.sdk;

public class IrisClientTestUtils {

    public static final String listAeuis = "<AlternateEndUserIdentifiersResponse>\n" +
            "    <TotalCount>2</TotalCount>\n" +
            "    <Links>\n" +
            "        <first>Link=&lt;http://localhost:8080/iris/accounts/14/aeuis?page=1&amp;size=500&gt;;rel=\"first\";</first>\n" +
            "    </Links>\n" +
            "    <AlternateEndUserIdentifiers>\n" +
            "        <AlternateEndUserIdentifier>\n" +
            "            <Identifier>DavidAcid</Identifier>\n" +
            "            <CallbackNumber>8042105760</CallbackNumber>\n" +
            "            <EmergencyNotificationGroup>\n" +
            "                <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "                <Description>Building 5, 5th Floor.</Description>\n" +
            "            </EmergencyNotificationGroup>\n" +
            "        </AlternateEndUserIdentifier>\n" +
            "        <AlternateEndUserIdentifier>\n" +
            "            <Identifier>JohnAcid</Identifier>\n" +
            "            <CallbackNumber>8042105618</CallbackNumber>\n" +
            "        </AlternateEndUserIdentifier>\n" +
            "    </AlternateEndUserIdentifiers>\n" +
            "</AlternateEndUserIdentifiersResponse>";

    public static final String getAeuis = "<AlternateEndUserIdentifierResponse>\n" +
            "    <AlternateEndUserIdentifier>\n" +
            "        <Identifier>DavidAcid</Identifier>\n" +
            "        <CallbackNumber>8042105760</CallbackNumber>\n" +
            "        <E911>\n" +
            "            <CallerName>David</CallerName>\n" +
            "            <Address>\n" +
            "                <HouseNumber>900</HouseNumber>\n" +
            "                <HouseSuffix></HouseSuffix>\n" +
            "                <PreDirectional></PreDirectional>\n" +
            "                <StreetName>MAIN CAMPUS</StreetName>\n" +
            "                <StreetSuffix>DR</StreetSuffix>\n" +
            "                <AddressLine2></AddressLine2>\n" +
            "                <City>RALEIGH</City>\n" +
            "                <StateCode>NC</StateCode>\n" +
            "                <Zip>27606</Zip>\n" +
            "                <PlusFour>5214</PlusFour>\n" +
            "                <Country>United States</Country>\n" +
            "                <AddressType>Billing</AddressType>\n" +
            "            </Address>\n" +
            "            <EmergencyNotificationGroup>\n" +
            "                <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "                <Description>Building 5, 5th Floor.</Description>\n" +
            "            </EmergencyNotificationGroup>\n" +
            "        </E911>\n" +
            "    </AlternateEndUserIdentifier>\n" +
            "</AlternateEndUserIdentifierResponse>";

    public static final String listEmNotEndpointOrders = "<EmergencyNotificationEndpointOrderResponse>\n" +
            "    <Links>\n" +
            "        <first> -- link to first page of results -- </first>\n" +
            "        <next> -- link to next page of results -- </next>\n" +
            "    </Links>\n" +
            "    <EmergencyNotificationEndpointOrders>\n" +
            "        <EmergencyNotificationEndpointOrder>\n" +
            "            <OrderId>3e9a852e-2d1d-4e2d-84c3-87223a78cb70</OrderId>\n" +
            "            <OrderCreatedDate>2020-01-23T18:34:17.284Z</OrderCreatedDate>\n" +
            "            <CreatedBy>jgilmore</CreatedBy>\n" +
            "            <ProcessingStatus>COMPLETED</ProcessingStatus>\n" +
            "            <CustomerOrderId>ALG-31233884</CustomerOrderId>\n" +
            "            <EmergencyNotificationEndpointAssociations>\n" +
            "                <EmergencyNotificationGroup>\n" +
            "                    <Identifier>3e9a852e-2d1d-4e2d-84c3-04595ba2eb93</Identifier>\n" +
            "                </EmergencyNotificationGroup>\n" +
            "                <AddedAssociations>\n" +
            "                    <EepToEngAssociations>\n" +
            "                        <EepTns>\n" +
            "                            <TelephoneNumber>2248838829</TelephoneNumber>\n" +
            "                            <TelephoneNumber>4052397735</TelephoneNumber>\n" +
            "                        </EepTns>\n" +
            "                        <EepAeuiIds>\n" +
            "                            <Identifier>Fred992834</Identifier>\n" +
            "                            <Identifier>Bob00359</Identifier>\n" +
            "                        </EepAeuiIds>\n" +
            "                    </EepToEngAssociations>\n" +
            "                    <ErrorList />\n" +
            "                </AddedAssociations>\n" +
            "            </EmergencyNotificationEndpointAssociations>\n" +
            "        </EmergencyNotificationEndpointOrder>\n" +
            "        <EmergencyNotificationEndpointOrder>\n" +
            "        </EmergencyNotificationEndpointOrder>\n" +
            "        <EmergencyNotificationEndpointOrder>\n" +
            "        </EmergencyNotificationEndpointOrder>\n" +
            "    </EmergencyNotificationEndpointOrders>\n" +
            "</EmergencyNotificationEndpointOrderResponse>";

    public static final String getEmNotEndpointOrderResponse = "<EmergencyNotificationEndpointOrderResponse>\n" +
            "    <EmergencyNotificationEndpointOrder>\n" +
            "        <OrderId>3e9a852e-2d1d-4e2d-84c3-87223a78cb70</OrderId>\n" +
            "        <OrderCreatedDate>2020-01-23T18:34:17.284Z</OrderCreatedDate>\n" +
            "        <CreatedBy>jgilmore</CreatedBy>\n" +
            "        <ProcessingStatus>COMPLETED</ProcessingStatus>\n" +
            "        <CustomerOrderId>ALG-31233884</CustomerOrderId>\n" +
            "        <EmergencyNotificationEndpointAssociations>\n" +
            "            <EmergencyNotificationGroup>\n" +
            "                <Identifier>3e9a852e-2d1d-4e2d-84c3-04595ba2eb93</Identifier>\n" +
            "            </EmergencyNotificationGroup>\n" +
            "            <!-- If the order created emergency endpoint to emergency notification group associations -->\n" +
            "            <AddedAssociations>\n" +
            "                <EepToEngAssociations>\n" +
            "                    <EepTns>\n" +
            "                        <TelephoneNumber>2248838829</TelephoneNumber>\n" +
            "                        <TelephoneNumber>4052397735</TelephoneNumber>\n" +
            "                    </EepTns>\n" +
            "                    <EepAeuiIds>\n" +
            "                        <Identifier>Fred992834</Identifier>\n" +
            "                        <Identifier>Bob00359</Identifier>\n" +
            "                    </EepAeuiIds>\n" +
            "                </EepToEngAssociations>\n" +
            "                <ErrorList />\n" +
            "            </AddedAssociations>\n" +
            "        </EmergencyNotificationEndpointAssociations>\n" +
            "    </EmergencyNotificationEndpointOrder>\n" +
            "</EmergencyNotificationEndpointOrderResponse>";

    public static final String getEmNotGroup = "<EmergencyNotificationGroupsResponse>\n" +
            "    <EmergencyNotificationGroup>\n" +
            "        <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "        <CreatedDate>2020-01-23T18:34:17.284Z</CreatedDate>\n" +
            "        <ModifiedBy>jgilmore</ModifiedBy>\n" +
            "        <ModifiedDate>2020-01-23T18:34:17.284Z</ModifiedDate>\n" +
            "        <Description>This is a description of the emergency notification group.</Description>\n" +
            "        <EmergencyNotificationRecipients>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>ef47eb61-e3b1-449d-834b-0fbc5a11da30</Identifier>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "        </EmergencyNotificationRecipients>\n" +
            "    </EmergencyNotificationGroup>\n" +
            "</EmergencyNotificationGroupsResponse>";

    public static final String getListEmergencyNotificationGroups = "<EmergencyNotificationGroupsResponse>\n" +
            "    <Links>\n" +
            "        <!-- The 'first' link always gets the most recent results. -->\n" +
            "        <first> -- link to first page of results -- </first>\n" +
            "        <!-- If the 'next' link is present, there are more than 'size' results. -->\n" +
            "        <!-- Use the 'next' link to fetch the next set of results. -->\n" +
            "        <next> -- link to next page of results -- </next>\n" +
            "    </Links>\n" +
            "    <EmergencyNotificationGroups>\n" +
            "        <EmergencyNotificationGroup>\n" +
            "            <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "            <CreatedDate>2020-01-23T18:34:17.284Z</CreatedDate>\n" +
            "            <ModifiedBy>jgilmore</ModifiedBy>\n" +
            "            <ModifiedDate>2020-01-23T18:34:17.284Z</ModifiedDate>\n" +
            "            <Description>This is a description of the emergency notification group.</Description>\n" +
            "            <EmergencyNotificationRecipients>\n" +
            "                <!-- Specify the 'EnrDetails' query parameter to see full details for the emergency notification recipients -->\n" +
            "                <EmergencyNotificationRecipient>\n" +
            "                    <Identifier>63865500-0904-46b1-9b4f-7bd237a26363</Identifier>\n" +
            "                </EmergencyNotificationRecipient>\n" +
            "                <EmergencyNotificationRecipient>\n" +
            "                    <Identifier>ef47eb61-e3b1-449d-834b-0fbc5a11da30</Identifier>\n" +
            "                </EmergencyNotificationRecipient>\n" +
            "            </EmergencyNotificationRecipients>\n" +
            "        </EmergencyNotificationGroup>\n" +
            "        <EmergencyNotificationGroup>\n" +
            "            <Identifier>29477382-23947-23c-2349-aa8238b22743</Identifier>\n" +
            "            <CreatedDate>2020-01-23T18:36:51.987Z</CreatedDate>\n" +
            "            <ModifiedBy>jgilmore</ModifiedBy>\n" +
            "            <ModifiedDate>2020-01-23T18:36:51.987Z</ModifiedDate>\n" +
            "            <Description>This is a description of the emergency notification group.</Description>\n" +
            "            <EmergencyNotificationRecipients>\n" +
            "                <!-- Specify the 'EnrDetails' query parameter to see full details for the emergency notification recipients -->\n" +
            "                <EmergencyNotificationRecipient>\n" +
            "                    <Identifier>37742335-8722-3abc-8722-e2434f123a4d</Identifier>\n" +
            "                </EmergencyNotificationRecipient>\n" +
            "            </EmergencyNotificationRecipients>\n" +
            "        </EmergencyNotificationGroup>\n" +
            "    </EmergencyNotificationGroups>\n" +
            "</EmergencyNotificationGroupsResponse>";

    public static final String listEmergencyNotificationGroupOrders = "<EmergencyNotificationGroupOrderResponse>\n" +
            "    <Links>\n" +
            "        <first>Link=&lt;http://localhost:8080/v1.0/accounts/12346371/emergencyNotificationGroupOrders&gt;;rel=\"first\";</first>\n" +
            "    </Links>\n" +
            "    <EmergencyNotificationGroupOrders>\n" +
            "        <EmergencyNotificationGroupOrder>\n" +
            "            <OrderId>092815dc-9ced-4d67-a070-a80eb243b914</OrderId>\n" +
            "            <OrderCreatedDate>2020-04-29T15:40:01.449Z</OrderCreatedDate>\n" +
            "            <CreatedBy>systemUser</CreatedBy>\n" +
            "            <ProcessingStatus>COMPLETED</ProcessingStatus>\n" +
            "            <CustomerOrderId>QTWeKMys</CustomerOrderId>\n" +
            "            <AddedEmergencyNotificationGroup>\n" +
            "                <Identifier>6daa55e1-e499-4cf0-9f3d-9524215f1bee</Identifier>\n" +
            "                <Description>enr test description 3</Description>\n" +
            "                <AddedEmergencyNotificationRecipients>\n" +
            "                    <EmergencyNotificationRecipient>\n" +
            "                        <Identifier>44f203915ca249b7b69bbc084af09a</Identifier>\n" +
            "                        <Description>TestDesc SEHsbDMM</Description>\n" +
            "                        <Type>SMS</Type>\n" +
            "                        <Sms>\n" +
            "                            <TelephoneNumber>15638765448</TelephoneNumber>\n" +
            "                        </Sms>\n" +
            "                    </EmergencyNotificationRecipient>\n" +
            "                </AddedEmergencyNotificationRecipients>\n" +
            "            </AddedEmergencyNotificationGroup>\n" +
            "        </EmergencyNotificationGroupOrder>\n" +
            "        <EmergencyNotificationGroupOrder>\n" +
            "            <OrderId>89b4e0a1-2789-43fb-b948-38d368159142</OrderId>\n" +
            "            <OrderCreatedDate>2020-04-29T15:39:59.325Z</OrderCreatedDate>\n" +
            "            <CreatedBy>systemUser</CreatedBy>\n" +
            "            <ProcessingStatus>COMPLETED</ProcessingStatus>\n" +
            "            <CustomerOrderId>SDWupQpf</CustomerOrderId>\n" +
            "            <AddedEmergencyNotificationGroup>\n" +
            "                <Identifier>b49fa543-5bb3-4b9d-9213-96c8b63e77f5</Identifier>\n" +
            "                <Description>enr test description 2</Description>\n" +
            "                <AddedEmergencyNotificationRecipients>\n" +
            "                    <EmergencyNotificationRecipient>\n" +
            "                        <Identifier>c719e060a6ba4212a2c0642b87a784</Identifier>\n" +
            "                        <Description>TestDesc zscxcAGG</Description>\n" +
            "                        <Type>SMS</Type>\n" +
            "                        <Sms>\n" +
            "                            <TelephoneNumber>15678765448</TelephoneNumber>\n" +
            "                        </Sms>\n" +
            "                    </EmergencyNotificationRecipient>\n" +
            "                    <EmergencyNotificationRecipient>\n" +
            "                        <Identifier>93ad72dfe59c4992be6f8aa625466d</Identifier>\n" +
            "                        <Description>TestDesc RTflsKBz</Description>\n" +
            "                        <Type>TTS</Type>\n" +
            "                        <Tts>\n" +
            "                            <TelephoneNumber>17678765449</TelephoneNumber>\n" +
            "                        </Tts>\n" +
            "                    </EmergencyNotificationRecipient>\n" +
            "                </AddedEmergencyNotificationRecipients>\n" +
            "            </AddedEmergencyNotificationGroup>\n" +
            "        </EmergencyNotificationGroupOrder>\n" +
            "        <EmergencyNotificationGroupOrder>\n" +
            "            <OrderId>247d1425-4247-4b27-99d8-83ce30038b14</OrderId>\n" +
            "            <OrderCreatedDate>2020-04-29T15:39:57.058Z</OrderCreatedDate>\n" +
            "            <CreatedBy>systemUser</CreatedBy>\n" +
            "            <ProcessingStatus>COMPLETED</ProcessingStatus>\n" +
            "            <CustomerOrderId>vgshuNMB</CustomerOrderId>\n" +
            "            <AddedEmergencyNotificationGroup>\n" +
            "                <Identifier>69a3d588-f314-42ca-8726-faa824bdf4be</Identifier>\n" +
            "                <Description>eng test description</Description>\n" +
            "                <AddedEmergencyNotificationRecipients>\n" +
            "                    <EmergencyNotificationRecipient>\n" +
            "                        <Identifier>aab78f87074940f1aaaf1c9658be4b</Identifier>\n" +
            "                        <Description>enr test description</Description>\n" +
            "                        <Type>EMAIL</Type>\n" +
            "                        <EmailAddress>testEmail@gmail.com</EmailAddress>\n" +
            "                    </EmergencyNotificationRecipient>\n" +
            "                    <EmergencyNotificationRecipient>\n" +
            "                        <Identifier>852e9eee161b4da6823c91173b05c4</Identifier>\n" +
            "                        <Description>TestDesc WkHqpnNH</Description>\n" +
            "                        <Type>TTS</Type>\n" +
            "                        <Tts>\n" +
            "                            <TelephoneNumber>15678765449</TelephoneNumber>\n" +
            "                        </Tts>\n" +
            "                    </EmergencyNotificationRecipient>\n" +
            "                </AddedEmergencyNotificationRecipients>\n" +
            "            </AddedEmergencyNotificationGroup>\n" +
            "        </EmergencyNotificationGroupOrder>\n" +
            "    </EmergencyNotificationGroupOrders>\n" +
            "</EmergencyNotificationGroupOrderResponse>";

    public static final String modifiedEmergencyNotificationGroupOrdersResponse = "<EmergencyNotificationGroupOrderResponse>\n" +
            "    <OrderId>31e4be80-e816-432e-a554-1219ed4fc5e9</OrderId>\n" +
            "    <OrderCreatedDate>2020-04-29T15:34:32.799</OrderCreatedDate>\n" +
            "    <CreatedBy>systemUser</CreatedBy>\n" +
            "    <ProcessingStatus>PROCESSING</ProcessingStatus>\n" +
            "    <ModifiedEmergencyNotificationGroup>\n" +
            "        <Identifier>5da0859b-2af8-42a3-85dd-dad4ba5f7503</Identifier>\n" +
            "        <Description>oXHGGVKwmd</Description>\n" +
            "        <AddedEmergencyNotificationRecipients>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>f2eaa7be771241af9b031584875a60</Identifier>>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "        </AddedEmergencyNotificationRecipients>\n" +
            "    </ModifiedEmergencyNotificationGroup>\n" +
            "</EmergencyNotificationGroupOrderResponse>";

    public static final String addedEmergencyNotificationGroupsResponse = "<EmergencyNotificationGroupOrderResponse>\n" +
            "    <OrderId>900b3646-18df-4626-b237-3a8de648ebf6</OrderId>\n" +
            "    <OrderCreatedDate>2020-04-29T15:27:16.151</OrderCreatedDate>\n" +
            "    <CreatedBy>systemUser</CreatedBy>\n" +
            "    <ProcessingStatus>PROCESSING</ProcessingStatus>\n" +
            "    <CustomerOrderId>UbOxhMnp</CustomerOrderId>\n" +
            "    <AddedEmergencyNotificationGroup>\n" +
            "        <Identifier>52897b97-3592-43fe-aa3f-857cf96671ee</Identifier>\n" +
            "        <Description>JgHzUzIchD</Description>\n" +
            "        <AddedEmergencyNotificationRecipients>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>c7f74671edd8410d9a4c0f8e985e0a</Identifier>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>74ac30535b414d29bc36d50572f553</Identifier>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "            <EmergencyNotificationRecipient>\n" +
            "                <Identifier>b910df3245ce4192aee052f583259f</Identifier>\n" +
            "            </EmergencyNotificationRecipient>\n" +
            "        </AddedEmergencyNotificationRecipients>\n" +
            "    </AddedEmergencyNotificationGroup>\n" +
            "</EmergencyNotificationGroupOrderResponse>";

    public static final String listEmergencyNotificationRecipientsResponse = "<EmergencyNotificationRecipientsResponse>\n" +
            "    <Links>\n" +
            "        <first> -- link to first page of results -- </first>\n" +
            "        <next> -- link to next page of results -- </next>\n" +
            "    </Links>\n" +
            "    <EmergencyNotificationRecipients>\n" +
            "        <EmergencyNotificationRecipient>\n" +
            "            <Identifier> 63865500-0904-46b1-9b4f-7bd237a26363 </Identifier>\n" +
            "            <CreatedDate>2020-03-18T21:26:47.403Z</CreatedDate>\n" +
            "            <LastModifiedDate>2020-03-18T21:26:47.403Z</LastModifiedDate>\n" +
            "            <ModifiedByUser>jgilmore</ModifiedByUser>\n" +
            "            <Description> This is a description of the emergency notification recipient. </Description>\n" +
            "            <Type>CALLBACK</Type>\n" +
            "            <Callback>\n" +
            "                <Url>https://foo.bar/baz</Url>\n" +
            "                <Credentials>\n" +
            "                    <Username>jgilmore</Username>\n" +
            "                    <!-- CallbackPassword is omitted for security -->\n" +
            "                </Credentials>\n" +
            "            </Callback>\n" +
            "        </EmergencyNotificationRecipient>\n" +
            "        <EmergencyNotificationRecipient>\n" +
            "            <Identifier> 63865500-0904-46b1-9b4f-7bd237a26363 </Identifier>\n" +
            "            <CreatedDate>2020-03-22T12:13:25.782Z</CreatedDate>\n" +
            "            <LastModifiedDate>2020-03-22T12:13:25.782Z</LastModifiedDate>\n" +
            "            <ModifiedByUser>gfranklin</ModifiedByUser>\n" +
            "            <Description> This is a description of the emergency notification recipient. </Description>\n" +
            "            <Type>EMAIL</Type>\n" +
            "            <EmailAddress>fred@gmail.com</EmailAddress>\n" +
            "        </EmergencyNotificationRecipient>\n" +
            "    </EmergencyNotificationRecipients>\n" +
            "</EmergencyNotificationRecipientsResponse>";

    public static final String emergencyNotificationRecipientsResponse = "<EmergencyNotificationRecipientsResponse>\n" +
            "    <EmergencyNotificationRecipient>\n" +
            "        <Identifier> 63865500-0904-46b1-9b4f-7bd237a26363 </Identifier>\n" +
            "        <CreatedDate>2020-03-18T21:26:47.403Z</CreatedDate>\n" +
            "        <LastModifiedDate>2020-03-18T21:26:47.403Z</LastModifiedDate>\n" +
            "        <ModifiedByUser>jgilmore</ModifiedByUser>\n" +
            "        <Description> This is a description of the emergency notification recipient. </Description>\n" +
            "        <Type>CALLBACK</Type>\n" +
            "        <Callback>\n" +
            "            <Url>https://foo.bar/baz</Url>\n" +
            "            <Credentials>\n" +
            "                <Username>jgilmore</Username>\n" +
            "            </Credentials>\n" +
            "        </Callback>\n" +
            "    </EmergencyNotificationRecipient>\n" +
            "</EmergencyNotificationRecipientsResponse>";

    public static final String fileListLoas = "<fileListResponse>\n" +
            "    <fileCount>2</fileCount>\n" +
            "    <fileNames>803f3cc5-beae-469e-bd65-e9891ccdffb9-1092874634747.pdf</fileNames>\n" +
            "    <fileNames>803f3cc5-beae-469e-bd65-e9891ccdffb9-1430814967669.pdf</fileNames>\n" +
            "    <resultCode>0</resultCode>\n" +
            "    <resultMessage>LOA file list successfully returned</resultMessage>\n" +
            "</fileListResponse>";

    public static final String callbackSubscription = "<SubscriptionsResponse><Subscriptions><Subscription>\n" +
            "    <EventType>MESSAGING_LOST</EventType>\n" +
            "    <CallbackSubscription>\n" +
            "        <URL>http://yourhost:8080/path/to/resource</URL>\n" +
            "        <User>bandwidth-dashboard-user-id</User>\n" +
            "        <Expiry>12000</Expiry>\n" +
            "        <CallbackCredentials>\n" +
            "            <BasicAuthentication>\n" +
            "                <Username>superuser</Username>\n" +
            "                <Password>s3cure</Password>\n" +
            "            </BasicAuthentication>\n" +
            "            <PublicKey>LS0tLS1CRUdJTiBDRVJUSkQgQ0VSVElGSUNBVEUtLS0tLQ0K</PublicKey>\n" +
            "        </CallbackCredentials>\n" +
            "    </CallbackSubscription>\n" +
            "</Subscription></Subscriptions></SubscriptionsResponse>";

    public static final String csrResponse = "<CsrResponse>\n" +
            "    <CustomerOrderId>someValue</CustomerOrderId>\n" +
            "    <LastModifiedBy>systemUser</LastModifiedBy>\n" +
            "    <OrderCreateDate>2019-10-25T09:51:17Z</OrderCreateDate>\n" +
            "    <AccountId>1</AccountId>\n" +
            "    <OrderId>a2f55ebe-782a-4242-983b-6ae6cfa97833</OrderId>\n" +
            "    <LastModifiedDate>2019-10-25T12:51:22.139Z</LastModifiedDate>\n" +
            "    <Status>COMPLETE</Status>\n" +
            "    <AccountNumber>987654321</AccountNumber>\n" +
            "    <AccountTelephoneNumber>9196194444</AccountTelephoneNumber>\n" +
            "    <EndUserName>bandwidthGuy</EndUserName>\n" +
            "    <AuthorizingUserName>importantAuthGuy</AuthorizingUserName>\n" +
            "    <CustomerCode>123</CustomerCode>\n" +
            "    <EndUserPIN>12345</EndUserPIN>\n" +
            "    <EndUserPassword>enduserpassword123</EndUserPassword>\n" +
            "    <AddressLine1>900 Main Campus Dr</AddressLine1>\n" +
            "    <City>Raleigh</City>\n" +
            "    <State>NC</State>\n" +
            "    <ZIPCode>27612</ZIPCode>\n" +
            "    <TypeOfService>residential</TypeOfService>\n" +
            "    <CsrData>\n" +
            "        <AccountNumber>123456789</AccountNumber>\n" +
            "        <CustomerName>JOHN SMITH</CustomerName>\n" +
            "        <ServiceAddress>\n" +
            "            <UnparsedAddress>900 MAIN CAMPUS DR</UnparsedAddress>\n" +
            "            <City>RALEIGH</City>\n" +
            "            <State>NC</State>\n" +
            "            <Zip>27616</Zip>\n" +
            "        </ServiceAddress>\n" +
            "        <WorkingTelephoneNumber>9196191211</WorkingTelephoneNumber>\n" +
            "        <WorkingTelephoneNumbersOnAccount>\n" +
            "            <TelephoneNumber>9196191211</TelephoneNumber>\n" +
            "        </WorkingTelephoneNumbersOnAccount>\n" +
            "    </CsrData>\n" +
            "    <Errors>\n" +
            "        <Error>\n" +
            "            <Code>26500</Code>\n" +
            "            <Description>CSR is not available for this TN</Description>\n" +
            "        </Error>\n" +
            "    </Errors>\n" +
            "</CsrResponse>";

    /**
     * ImportTnChecker
     */
    public static String importTnCheckerResponse = "<ImportTnCheckerResponse>\n" +
            "    <ImportTnCheckerPayload>\n" +
            "        <TelephoneNumbers>\n" +
            "            <TelephoneNumber>3032281000</TelephoneNumber>\n" +
            "        </TelephoneNumbers>\n" +
            "        <ImportTnErrors>\n" +
            "            <ImportTnError>\n" +
            "                <Code>19006</Code>\n" +
            "                <Description>Bandwidth numbers cannot be imported by this account at this time.</Description>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>4109235436</TelephoneNumber>\n" +
            "                    <TelephoneNumber>4104685864</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </ImportTnError>\n" +
            "        </ImportTnErrors>\n" +
            "    </ImportTnCheckerPayload>\n" +
            "</ImportTnCheckerResponse>";

    /**
     * RemoveImportedTnOrders
     */
    public static String removeImportedTnOrder = "<RemoveImportedTnOrder><CustomerOrderId>custom string</CustomerOrderId><OrderCreateDate>2020-02-03T18:08:44.199Z</OrderCreateDate><AccountId>9900778</AccountId><CreatedByUser>jmulford-api</CreatedByUser><OrderId>5bb3b642-cbbb-4438-9a44-56069550d603</OrderId><LastModifiedDate>2020-02-03T18:08:44.256Z</LastModifiedDate><TelephoneNumbers><TelephoneNumber>5554443333</TelephoneNumber><TelephoneNumber>5553332222</TelephoneNumber></TelephoneNumbers><ProcessingStatus>FAILED</ProcessingStatus><Errors><Error><Code>5158</Code><Description>Telephone number hasn't been previously imported.</Description><TelephoneNumbers><TelephoneNumber>5554443333</TelephoneNumber><TelephoneNumber>5553332222</TelephoneNumber></TelephoneNumbers></Error></Errors></RemoveImportedTnOrder>";
    public static String removeImportedTnOrderResponse = "<RemoveImportedTnOrdersResponse>" + removeImportedTnOrder + "</RemoveImportedTnOrdersResponse>";
    public static String removeImportedTnorders = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><RemoveImportedTnOrders><TotalCount>9</TotalCount><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb</userId><lastModifiedDate>2020-02-04T18:01:54.786Z</lastModifiedDate><OrderDate>2020-02-04T18:01:54.434Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>COMPLETE</OrderStatus><OrderId>7a992c85-d164-46df-97c4-dac6030ec952</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb</userId><lastModifiedDate>2020-02-04T17:48:45.340Z</lastModifiedDate><OrderDate>2020-02-04T17:48:45.033Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>COMPLETE</OrderStatus><OrderId>0053a536-f3fb-4ac9-aa08-6fc22abe8c49</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:08:44.256Z</lastModifiedDate><OrderDate>2020-02-03T18:08:44.199Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>5bb3b642-cbbb-4438-9a44-56069550d603</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:08:19.955Z</lastModifiedDate><OrderDate>2020-02-03T18:08:19.927Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>384ff500-ff33-4580-a910-45eff3d51f0d</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T15:51:14.496Z</lastModifiedDate><OrderDate>2020-02-03T15:51:14.471Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>20943d4a-600c-44e0-ac97-dd3d6f1f2af5</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T15:48:28.440Z</lastModifiedDate><OrderDate>2020-02-03T15:48:28.418Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>d3ed8a2e-7927-4fbc-8e6c-9c8408d443d5</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-01-31T21:12:23.731Z</lastModifiedDate><OrderDate>2020-01-31T21:12:23.707Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>6ddec230-ca5f-4502-8273-15ba8968dc8c</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-01-31T21:12:08.200Z</lastModifiedDate><OrderDate>2020-01-31T21:12:08.183Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>dc2ae1c7-b7db-44e7-bbb2-eb2b17e18413</OrderId></RemoveImportedTnOrderSummary><RemoveImportedTnOrderSummary><accountId>9900778</accountId><CountOfTNs>2</CountOfTNs><CustomerOrderId>custom string</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-01-31T21:11:46.368Z</lastModifiedDate><OrderDate>2020-01-31T21:11:46.343Z</OrderDate><OrderType>remove_imported_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>1bcfe0bd-6998-4198-b734-abd1fffe346a</OrderId></RemoveImportedTnOrderSummary></RemoveImportedTnOrders>";


    /**
     * ImportTnOrders
     */
    public static String importTnOrder = "<ImportTnOrder><CustomerOrderId>id</CustomerOrderId><OrderCreateDate>2020-02-04T14:09:07.824Z</OrderCreateDate><AccountId>9900778</AccountId><CreatedByUser>jmulford-api</CreatedByUser><OrderId>fbd17609-be44-48e7-a301-90bd6cf42248</OrderId><LastModifiedDate>2020-02-04T14:09:08.937Z</LastModifiedDate><SiteId>12345</SiteId><Subscriber><Name>Bandwidth</Name><ServiceAddress><HouseNumber>900</HouseNumber><StreetName>Main Campus Drive</StreetName><City>Raleigh</City><StateCode>NC</StateCode><Zip>27606</Zip><County>Wake</County><Country>United States</Country><AddressType>Service</AddressType></ServiceAddress></Subscriber><LoaAuthorizingPerson>Test Person</LoaAuthorizingPerson><TelephoneNumbers><TelephoneNumber>9193039169</TelephoneNumber></TelephoneNumbers><ProcessingStatus>FAILED</ProcessingStatus><Errors><Error><Code>5016</Code><Description>The SiteId submitted is invalid.</Description><TelephoneNumbers><TelephoneNumber>9193039169</TelephoneNumber></TelephoneNumbers></Error></Errors></ImportTnOrder>";
    public static String importTnOrderResponse = "<ImportTnOrderResponse>" + importTnOrder + "</ImportTnOrderResponse>";
    public static String importTnOrdersResponse = "<ImportTnOrdersResponse>" + importTnOrder + "</ImportTnOrdersResponse>";
    public static String importTnOrders = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ImportTnOrders><TotalCount>19</TotalCount><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb-API</userId><lastModifiedDate>2020-02-04T17:58:41.033Z</lastModifiedDate><OrderDate>2020-02-04T17:58:39.980Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>COMPLETE</OrderStatus><OrderId>021a94f5-5c55-401f-9cdc-8dca059ad7c1</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb-API</userId><lastModifiedDate>2020-02-04T17:47:10.363Z</lastModifiedDate><OrderDate>2020-02-04T17:47:09.992Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>COMPLETE</OrderStatus><OrderId>aa2a361f-05d3-49f0-a588-8d8f9c2e3c5b</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb-API</userId><lastModifiedDate>2020-02-04T17:47:00.178Z</lastModifiedDate><OrderDate>2020-02-04T17:47:00.136Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>a3eb1191-e6f1-49e5-8062-cc22ad060d0c</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb-API</userId><lastModifiedDate>2020-02-04T17:45:55.584Z</lastModifiedDate><OrderDate>2020-02-04T17:45:55.539Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>413b0c4b-98c5-4e99-be82-fc42c6bb211d</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><userId>dtolb-API</userId><lastModifiedDate>2020-02-04T17:36:27.051Z</lastModifiedDate><OrderDate>2020-02-04T17:36:26.986Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>80c2c718-57c2-43dc-9edb-7889b5575327</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-04T14:09:08.937Z</lastModifiedDate><OrderDate>2020-02-04T14:09:07.824Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>fbd17609-be44-48e7-a301-90bd6cf42248</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:08:43.246Z</lastModifiedDate><OrderDate>2020-02-03T18:08:43.220Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>03012d35-f4ef-495d-9d2b-f05f60a98995</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:08:18.968Z</lastModifiedDate><OrderDate>2020-02-03T18:08:18.941Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>dde545c2-fab7-4f09-ba05-94270dc846c6</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:07:33.833Z</lastModifiedDate><OrderDate>2020-02-03T18:07:33.783Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>b6ce414c-efec-4cb7-878f-e55c5a1bb60a</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:07:09.875Z</lastModifiedDate><OrderDate>2020-02-03T18:07:09.831Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>a49cf67e-70d1-4239-8de8-47e5071c0f5a</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:06:31.635Z</lastModifiedDate><OrderDate>2020-02-03T18:06:31.595Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>589aecb2-e25e-42ca-94b6-3b6095ab0e24</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:06:11.904Z</lastModifiedDate><OrderDate>2020-02-03T18:06:11.866Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>2f6fdf1f-2288-4a6e-b7fa-d9900902059e</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:05:58.826Z</lastModifiedDate><OrderDate>2020-02-03T18:05:58.796Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>1691c7c0-53a5-4196-b46a-02b92f278bc5</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:05:31.226Z</lastModifiedDate><OrderDate>2020-02-03T18:05:31.189Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>5ab5ef80-f14d-47c9-b612-764120ccdcb0</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:04:19.615Z</lastModifiedDate><OrderDate>2020-02-03T18:04:19.569Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>d0574c61-368a-49e9-91df-e95fcec6216a</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:03:20.888Z</lastModifiedDate><OrderDate>2020-02-03T18:03:20.852Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>c3de02b3-9215-408f-870f-ceff2ce7bdc8</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-02-03T18:01:42.214Z</lastModifiedDate><OrderDate>2020-02-03T18:01:42.152Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>9796b4f6-90c7-4265-9919-e0bbaa42453b</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>id</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-01-31T21:04:03.284Z</lastModifiedDate><OrderDate>2020-01-31T21:04:03.244Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>3cfcc5c3-230e-4ef6-9aec-64d5066dbaae</OrderId></ImportTnOrderSummary><ImportTnOrderSummary><accountId>9900778</accountId><CountOfTNs>1</CountOfTNs><CustomerOrderId>jmulford</CustomerOrderId><userId>jmulford-api</userId><lastModifiedDate>2020-01-31T20:49:54.560Z</lastModifiedDate><OrderDate>2020-01-31T20:49:54.511Z</OrderDate><OrderType>import_tn_orders</OrderType><OrderStatus>FAILED</OrderStatus><OrderId>e5d2cd6d-664d-40ac-8c45-ff9916fcb8e0</OrderId></ImportTnOrderSummary></ImportTnOrders>";
    public static String importTnOrderHistory = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderHistoryWrapper><OrderHistory><OrderDate>2020-02-04T14:09:07.824Z</OrderDate><Note>Import TN order has been received by the system.</Note><Author>jmulford-api</Author><Status>received</Status></OrderHistory><OrderHistory><OrderDate>2020-02-04T14:09:08.937Z</OrderDate><Note>Import TN order has failed.</Note><Author>jmulford-api</Author><Status>failed</Status></OrderHistory></OrderHistoryWrapper>";
    public static String removeTnOrderHistory = importTnOrderHistory;

    /**
     * Number search Xmls
     */
    public static String localAreaSearchResultXml = "<SearchResult><ResultCount>2</ResultCount><TelephoneNumberDetailList><TelephoneNumberDetail><City>JERSEY CITY</City><LATA>224</LATA><RateCenter>JERSEYCITY</RateCenter><State>NJ</State><TelephoneNumber>2012001555</TelephoneNumber></TelephoneNumberDetail><TelephoneNumberDetail><City>JERSEY CITY</City><LATA>224</LATA><RateCenter>JERSEYCITY</RateCenter><State>NJ</State><TelephoneNumber>123123123</TelephoneNumber></TelephoneNumberDetail></TelephoneNumberDetailList></SearchResult>";
    public static String availableNpaNxxSearchResultXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchResultForAvailableNpaNxx><AvailableNpaNxxList><AvailableNpaNxx><City>RALEIGH</City><Npa>919</Npa><Nxx>555</Nxx><Quantity>52</Quantity><State>NC</State></AvailableNpaNxx><AvailableNpaNxx><City>CARY</City><Npa>919</Npa><Nxx>556</Nxx><Quantity>168</Quantity><State>NC</State></AvailableNpaNxx></AvailableNpaNxxList></SearchResultForAvailableNpaNxx>";
    public static String availableNpaNxxSearchResultExceptionXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SearchResultForAvailableNpaNxx><ResponseStatus><ErrorCode>12016</ErrorCode><Description>Site '5001' does not exist</Description></ResponseStatus><AvailableNpaNxxList><AvailableNpaNxx><City>RALEIGH</City><Npa>919</Npa><Nxx>555</Nxx><Quantity>52</Quantity><State>NC</State></AvailableNpaNxx><AvailableNpaNxx><City>CARY</City><Npa>919</Npa><Nxx>556</Nxx><Quantity>168</Quantity><State>NC</State></AvailableNpaNxx></AvailableNpaNxxList></SearchResultForAvailableNpaNxx>";
    /**
     * Sites Xmls
     */
    public static String validSitesResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SitesResponse><Sites><Site><Id>2858</Id><Name>Test Site</Name><Description>A site description</Description></Site></Sites></SitesResponse>";
    public static String validSiteResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SiteResponse><Site><Id>2858</Id><Name>Test Site</Name><Description>A Site Description</Description><Address><HouseNumber>900</HouseNumber><StreetName>Main Campus Drive</StreetName><City>Raleigh</City><StateCode>NC</StateCode><Zip>27615</Zip><Country>United States</Country><AddressType>Service</AddressType></Address></Site></SiteResponse>";
    public static String invalidSiteDeleteResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SiteResponse><ResponseStatus><ErrorCode>12016</ErrorCode><Description>Site '5001' does not exist</Description></ResponseStatus></SiteResponse>";

    /**
     * Sip Peer Xmls
     */
    public static String validSipPeersResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TNSipPeersResponse><SipPeers><SipPeer xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:type=\"SipPeer\"><PeerId>12345</PeerId><PeerName>SIP Peer 1</PeerName><Description>Sip Peer 1 description</Description><IsDefaultPeer>true</IsDefaultPeer><ShortMessagingProtocol>SIP</ShortMessagingProtocol><VoiceHosts><Host><HostName>70.62.112.156</HostName></Host></VoiceHosts><VoiceHostGroups/><SmsHosts><Host><HostName>70.62.112.156</HostName></Host></SmsHosts><TerminationHosts><TerminationHost><HostName>70.62.112.156</HostName><Port>5060</Port><CustomerTrafficAllowed>DOMESTIC</CustomerTrafficAllowed><DataAllowed>true</DataAllowed></TerminationHost></TerminationHosts><CallingName><Display>true</Display><Enforced>false</Enforced></CallingName></SipPeer></SipPeers></TNSipPeersResponse>";
    public static String validSipPeerResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerResponse><SipPeer><PeerId>5678</PeerId><PeerName>SIP Peer 1</PeerName><Description>Sip Peer 1 description</Description><IsDefaultPeer>true</IsDefaultPeer><ShortMessagingProtocol>SIP</ShortMessagingProtocol><VoiceHosts/><VoiceHostGroups/><SmsHosts/><TerminationHosts/><CallingName><Display>true</Display><Enforced>false</Enforced></CallingName></SipPeer></SipPeerResponse>";
    public static String invalidIdSipPeerResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerResponse><ResponseStatus><ErrorCode>13563</ErrorCode><Description>Sip Peer '5555' account 'accountId' and site '1234' does not exist</Description></ResponseStatus></SipPeerResponse>";
    public static String validSipPeerTnResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerTelephoneNumberResponse><SipPeerTelephoneNumber><FullNumber>9195551212</FullNumber></SipPeerTelephoneNumber></SipPeerTelephoneNumberResponse>";
    public static String invalidSipPeerTnResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerTelephoneNumberResponse><ResponseStatus><ErrorCode>13536</ErrorCode><Description>Telephone number 9195551213 does not exist on Account accountId, Site 1234, and Sip Peer 5678</Description></ResponseStatus></SipPeerTelephoneNumberResponse>";
    public static String validSipPeerTnsResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeerTelephoneNumbersResponse><SipPeerTelephoneNumbers><SipPeerTelephoneNumber><FullNumber>9195551212</FullNumber></SipPeerTelephoneNumber><SipPeerTelephoneNumber><FullNumber>9195551213</FullNumber></SipPeerTelephoneNumber></SipPeerTelephoneNumbers></SipPeerTelephoneNumbersResponse>";

    /**
     * Order Xmls
     */
    public static String validOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><Order><Name>A New Order</Name><OrderCreateDate>2014-10-14T17:58:15.299Z</OrderCreateDate><BackOrderRequested>false</BackOrderRequested><id>someid</id><ExistingTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2052865046</TelephoneNumber></TelephoneNumberList></ExistingTelephoneNumberOrderType><PartialAllowed>false</PartialAllowed><SiteId>2858</SiteId></Order></OrderResponse>";
    public static String validCombinedOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><Order><Name>Test CombinedSearchAndOrderType Order</Name><OrderCreateDate>2014-10-14T17:58:15.299Z</OrderCreateDate><BackOrderRequested>false</BackOrderRequested><id>someid</id><CombinedSearchAndOrderType><EnableLCA>false</EnableLCA><Quantity>1</Quantity><RateCenter>DOVER</RateCenter><State>NH</State></CombinedSearchAndOrderType><PartialAllowed>false</PartialAllowed><SiteId>2858</SiteId></Order></OrderResponse>";
    public static String validRateCenterOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><Order><Name>Test RateCenterSearchAndOrderType Order</Name><OrderCreateDate>2014-10-14T17:58:15.299Z</OrderCreateDate><BackOrderRequested>false</BackOrderRequested><id>someid</id><RateCenterSearchAndOrderType><EnableLCA>false</EnableLCA><Quantity>1</Quantity><RateCenter>DOVER</RateCenter><State>NH</State></RateCenterSearchAndOrderType><PartialAllowed>false</PartialAllowed><SiteId>2858</SiteId></Order></OrderResponse>";
    public static String validOrderResponseErrorXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><CompletedQuantity>0</CompletedQuantity><CreatedByUser>testapi</CreatedByUser><ErrorList><Error><Code>5018</Code><Description>The entire quantity of telephone numbers ordered is unavailable</Description></Error></ErrorList><LastModifiedDate>2022-02-17T15:28:24.152Z</LastModifiedDate><OrderCompleteDate>2022-02-17T15:28:24.152Z</OrderCompleteDate><Order><id>errorid</id><CustomerOrderId>MyTestOrderId</CustomerOrderId><OrderCreateDate>2022-02-17T15:28:24.026Z</OrderCreateDate><PeerId>223787</PeerId><BackOrderRequested>false</BackOrderRequested><RateCenterSearchAndOrderType><EnableLCA>true</EnableLCA><Quantity>1</Quantity><RateCenter>DOVER</RateCenter><State>NH</State></RateCenterSearchAndOrderType><PartialAllowed>true</PartialAllowed><SiteId>56984</SiteId><TnAttributes/></Order><OrderStatus>FAILED</OrderStatus><CompletedNumbers/><Summary>1 number requested</Summary><FailedQuantity>1</FailedQuantity></OrderResponse>";
    public static String validOrderNotesResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Notes><Note><Id>178468</Id><UserId>user</UserId><Description>Adding a note</Description><LastDateModifier>2014-11-19T21:02:26.000Z</LastDateModifier></Note></Notes>";
    public static String validCreateDisconnectTelephoneNumberOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DisconnectTelephoneNumberOrderResponse><orderRequest><Name>Disconnect</Name><OrderCreateDate>2014-10-17T15:02:46.077Z</OrderCreateDate><id>disconnectId</id><DisconnectTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></TelephoneNumberList><DisconnectMode>normal</DisconnectMode></DisconnectTelephoneNumberOrderType></orderRequest></DisconnectTelephoneNumberOrderResponse>";
    public static String validCreateDisconnectTelephoneNumberOrderResponseWithErrorsXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DisconnectTelephoneNumberOrderResponse><ErrorList><Error><Code>5006</Code><Description>The telephone number 2055551212 could not be disconnected since it is not associated with your account</Description><TelephoneNumber>2055551212</TelephoneNumber></Error></ErrorList><orderRequest><Name>Disconnect</Name><OrderCreateDate>2014-10-17T15:02:46.077Z</OrderCreateDate><id>disconnectId</id><DisconnectTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></TelephoneNumberList><DisconnectMode>normal</DisconnectMode></DisconnectTelephoneNumberOrderType></orderRequest><OrderStatus>FAILED</OrderStatus></DisconnectTelephoneNumberOrderResponse>";
    public static String validCreateDisconnectTelephoneNumberOrderResponseSuccess = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DisconnectTelephoneNumberOrderResponse><DisconnectedTelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></DisconnectedTelephoneNumberList><orderRequest><OrderCreateDate>2019-08-09T01:51:36.034Z</OrderCreateDate><id>003e006b-c278-4ee4-89a2-c4ed334632d3</id><DisconnectTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber></TelephoneNumberList><DisconnectMode>normal</DisconnectMode></DisconnectTelephoneNumberOrderType></orderRequest><OrderStatus>COMPLETE</OrderStatus></DisconnectTelephoneNumberOrderResponse>";

    /**
     * Order Status Xmls
     */
    public static String validPartialOrderStatusXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><OrderResponse><CompletedQuantity>1</CompletedQuantity><CreatedByUser>aUser</CreatedByUser><ErrorList><Error><Code>5005</Code><Description>The telephone number is unavailable for ordering</Description><TelephoneNumber>2055551212</TelephoneNumber></Error></ErrorList><FailedNumbers><FullNumber>2055551212</FullNumber></FailedNumbers><LastModifiedDate>2019-08-08T19:39:35.537Z</LastModifiedDate><OrderCompleteDate>2019-08-08T19:39:35.537Z</OrderCompleteDate><Order><OrderCreateDate>2019-08-08T19:39:35.472Z</OrderCreateDate><PeerId>12345</PeerId><BackOrderRequested>false</BackOrderRequested><ExistingTelephoneNumberOrderType><TelephoneNumberList><TelephoneNumber>2055551212</TelephoneNumber><TelephoneNumber>2055551213</TelephoneNumber></TelephoneNumberList></ExistingTelephoneNumberOrderType><PartialAllowed>true</PartialAllowed><SiteId>2858</SiteId></Order><OrderStatus>PARTIAL</OrderStatus><CompletedNumbers><TelephoneNumber><FullNumber>2055551213</FullNumber></TelephoneNumber></CompletedNumbers><Summary>1 out of 2 numbers ordered in (833)</Summary><FailedQuantity>1</FailedQuantity></OrderResponse>";

    /**
     * Reservation Xmls
     */

    public static String validReservationResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ReservationResponse><Reservation><ReservationId>1234</ReservationId><AccountId>accountId</AccountId><ReservationExpires>30</ReservationExpires><ReservedTn>9195551212</ReservedTn></Reservation></ReservationResponse>";
    public static String invalidReservationResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ReservationResponse><ResponseStatus><ErrorCode>5041</ErrorCode><Description>Reservation failed: telephone number 9195551212 is not available.</Description></ResponseStatus></ReservationResponse>";

    /**
     * Number Portability Xmls
     */

    public static String validNumberPortabilityResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><NumberPortabilityResponse><PortableNumbers><Tn>9195551212</Tn></PortableNumbers><SupportedRateCenters><RateCenterGroup><RateCenter>RALEIGH</RateCenter><City>RALEIGH</City><State>NC</State><LATA>426</LATA><Tiers><Tier>0</Tier></Tiers><TnList><Tn>9195551212</Tn></TnList></RateCenterGroup></SupportedRateCenters><UnsupportedRateCenters/><SupportedLosingCarriers><LosingCarrierTnList><LosingCarrierSPID>6214</LosingCarrierSPID><LosingCarrierName>Cingular</LosingCarrierName><TnList><Tn>9195551212</Tn></TnList></LosingCarrierTnList></SupportedLosingCarriers><UnsupportedLosingCarriers/></NumberPortabilityResponse>";
    public static String validNumberPortabilityResponseXmlWithErrors = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><NumberPortabilityResponse><Errors><Code>7201</Code><Description>Telephone number is invalid</Description><TelephoneNumbers><Tn>919</Tn></TelephoneNumbers></Errors></NumberPortabilityResponse>";

    /**
     * LnpOrder Xmls
     */

    public static String validLnpOrderCreateResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><LnpOrderResponse><OrderId>1234</OrderId><Status><Code>201</Code><Description>Order request received. Please use the order id to check the status of your order later.</Description></Status><ProcessingStatus>PENDING_DOCUMENTS</ProcessingStatus><LoaAuthorizingPerson>John Doe</LoaAuthorizingPerson><Subscriber><SubscriberType>BUSINESS</SubscriberType><BusinessName>Acme Corporation</BusinessName><ServiceAddress><HouseNumber>1623</HouseNumber><StreetName>Brockton Ave #1</StreetName><City>Los Angeles</City><StateCode>CA</StateCode><Zip>90025</Zip><Country>USA</Country></ServiceAddress></Subscriber><BillingTelephoneNumber>6882015002</BillingTelephoneNumber><ListOfPhoneNumbers><PhoneNumber>6882015025</PhoneNumber><PhoneNumber>6882015026</PhoneNumber></ListOfPhoneNumbers><Triggered>false</Triggered><BillingType>PORTIN</BillingType></LnpOrderResponse>";
    public static String validLnpOrderGetResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><LnpOrderResponse><Status><Code>201</Code><Description>Order request received. Please use the order id to check the status of your order later.</Description></Status><ProcessingStatus>PENDING_DOCUMENTS</ProcessingStatus><LoaAuthorizingPerson>John Doe</LoaAuthorizingPerson><Subscriber><SubscriberType>BUSINESS</SubscriberType><BusinessName>Acme Corporation</BusinessName><ServiceAddress><HouseNumber>1623</HouseNumber><StreetName>Brockton Ave #1</StreetName><City>Los Angeles</City><StateCode>CA</StateCode><Zip>90025</Zip><Country>USA</Country></ServiceAddress></Subscriber><BillingTelephoneNumber>6882015002</BillingTelephoneNumber><ListOfPhoneNumbers><PhoneNumber>6882015025</PhoneNumber><PhoneNumber>6882015026</PhoneNumber></ListOfPhoneNumbers><Triggered>false</Triggered><BillingType>PORTIN</BillingType></LnpOrderResponse>";
    public static String validLnpSuppOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><LnpOrderResponse><OrderId>1234</OrderId><Status><Code>201</Code><Description>Order request received. Please use the order id to check the status of your order later.</Description></Status><ProcessingStatus>REQUESTED_SUPP</ProcessingStatus><LoaAuthorizingPerson>Jane Doe</LoaAuthorizingPerson><Subscriber><SubscriberType>BUSINESS</SubscriberType><BusinessName>Acme Corporation</BusinessName><ServiceAddress><HouseNumber>1623</HouseNumber><StreetName>Brockton Ave #1</StreetName><City>Los Angeles</City><StateCode>CA</StateCode><Zip>90025</Zip><Country>USA</Country></ServiceAddress></Subscriber><BillingTelephoneNumber>6882015002</BillingTelephoneNumber><ListOfPhoneNumbers><PhoneNumber>6882015025</PhoneNumber><PhoneNumber>6882015026</PhoneNumber></ListOfPhoneNumbers><Triggered>false</Triggered><BillingType>PORTIN</BillingType></LnpOrderResponse>";
    public static String validFileMetaDataResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><FileMetaData><DocumentName>file.pdf</DocumentName><DocumentType>PDF</DocumentType></FileMetaData>";
    public static String validActivationStatusResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <ActivationStatusResponse><ActivationStatus> <AutoActivationDate>2014-10-20T23:30:00Z</AutoActivationDate> <ActivatedTelephoneNumbersList><TelephoneNumber>9199918388</TelephoneNumber> </ActivatedTelephoneNumbersList> <NotYetActivatedTelephoneNumbersList/></ActivationStatus> </ActivationStatusResponse>";

    /**
     * Subscription Xmls
     */

    public static String validSubscriptionsResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SubscriptionsResponse><Subscriptions><Subscription><SubscriptionId>subscriptionId</SubscriptionId><OrderType>orders</OrderType><OrderId>someid</OrderId><EmailSubscription><Email>test@test.com</Email><DigestRequested>NONE</DigestRequested></EmailSubscription></Subscription></Subscriptions></SubscriptionsResponse>";

    /**
     * Cities Xmls
     */

    public static String validCitiesReponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CityResponse><ResultCount>2</ResultCount><Cities><City><RcAbbreviation>PINEHURST</RcAbbreviation><Name>ABERDEEN</Name></City><City><RcAbbreviation>WINSTN SAL</RcAbbreviation><Name>ADVANCE</Name></City></Cities></CityResponse>";

    /**
     * RateCenters Xmls
     */

    public static String validRateCentersResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><RateCenterResponse><ResultCount>2</ResultCount><RateCenters><RateCenter><Abbreviation>ACME</Abbreviation><Name>ACME</Name></RateCenter><RateCenter><Abbreviation>AHOSKIE</Abbreviation><Name>AHOSKIE</Name></RateCenter></RateCenters></RateCenterResponse>";

    /**
     * Tns Xmls
     */

    public static String e911TnDetails = "<TelephoneNumberResponse>\n" +
            "    <TelephoneNumberDetails>\n" +
            "        <City>JERSEY CITY</City>\n" +
            "        <Lata>224</Lata>\n" +
            "        <State>NJ</State>\n" +
            "        <FullNumber>2018981023</FullNumber>\n" +
            "        <Tier>0</Tier>\n" +
            "        <VendorId>49</VendorId>\n" +
            "        <VendorName>Bandwidth CLEC</VendorName>\n" +
            "        <RateCenter>JERSEYCITY</RateCenter>\n" +
            "        <Status>Inservice</Status>\n" +
            "        <AccountId>14</AccountId>\n" +
            "        <Site>\n" +
            "            <Id>479</Id>\n" +
            "            <Name>site_9b08f</Name>\n" +
            "        </Site>\n" +
            "        <SipPeer>\n" +
            "            <PeerId>500014</PeerId>\n" +
            "            <PeerName>a2750fad-3</PeerName>\n" +
            "        </SipPeer>\n" +
            "        <ServiceTypes>\n" +
            "            <ServiceType>Voice</ServiceType>\n" +
            "        </ServiceTypes>\n" +
            "        <LastModified>2014-07-30T11:29:37.000Z</LastModified>\n" +
            "        <InServiceDate>2014-07-30T11:29:37.000Z</InServiceDate>\n" +
            "        <Features>\n" +
            "            <E911>\n" +
            "                <LastE911OrderOutcome>SUCCESS</LastE911OrderOutcome>\n" +
            "                <SipPeerAddress>false</SipPeerAddress>\n" +
            "                <CallerName>Test CallerName</CallerName>\n" +
            "                <Address>\n" +
            "                    <HouseNumber>901</HouseNumber>\n" +
            "                    <StreetName>MAIN CAMPUS</StreetName>\n" +
            "                    <StreetSuffix>DR</StreetSuffix>\n" +
            "                    <City>RALEIGH</City>\n" +
            "                    <StateCode>NC</StateCode>\n" +
            "                    <Zip>27606</Zip>\n" +
            "                    <PlusFour>5244</PlusFour>\n" +
            "                    <Country>United States</Country>\n" +
            "                </Address>\n" +
            "                <EmergencyNotificationGroup>\n" +
            "                    <Identifier>625e3ad9-c95e-4148-b2f7-d47a8dbdd0d9</Identifier>\n" +
            "                    <Description>Building A</Description>\n" +
            "                </EmergencyNotificationGroup>\n" +
            "            </E911>\n" +
            "            <Lidb>\n" +
            "                <Status>Pending</Status>\n" +
            "                <SubscriberInformation>Fred</SubscriberInformation>\n" +
            "                <UseType>BUSINESS</UseType>\n" +
            "                <Visibility>PUBLIC</Visibility>\n" +
            "            </Lidb>\n" +
            "            <Dlda>\n" +
            "                <Status>Success</Status>\n" +
            "                <SubscriberType>BUSINESS</SubscriberType>\n" +
            "                <ListingType>LISTED</ListingType>\n" +
            "                <ListingName>\n" +
            "                    <FirstName>Joe</FirstName>\n" +
            "                    <LastName>Smith</LastName>\n" +
            "                </ListingName>\n" +
            "                <ListAddress>true</ListAddress>\n" +
            "                <Address>\n" +
            "                    <HouseNumber>12</HouseNumber>\n" +
            "                    <StreetName>ELM</StreetName>\n" +
            "                    <City>New York</City>\n" +
            "                    <StateCode>NY</StateCode>\n" +
            "                    <Zip>10007</Zip>\n" +
            "                    <Country>United States</Country>\n" +
            "                    <AddressType>Dlda</AddressType>\n" +
            "                </Address>\n" +
            "            </Dlda>\n" +
            "        </Features>\n" +
            "        <TnAttributes>\n" +
            "            <TnAttribute>Hosted</TnAttribute>\n" +
            "        </TnAttributes>\n" +
            "        <HostedTelephoneNumberDetails>\n" +
            "            <HostedTelephoneNumberDetail>\n" +
            "                <AccountId>12346160</AccountId>\n" +
            "                <Site>\n" +
            "                    <Id>487</Id>\n" +
            "                    <Name>site_Mw4FX</Name>\n" +
            "                </Site>\n" +
            "                <SipPeer>\n" +
            "                    <PeerId>500026</PeerId>\n" +
            "                    <PeerName>sippeeremhlO</PeerName>\n" +
            "                    <IsDefaultPeer>true</IsDefaultPeer>\n" +
            "                </SipPeer>\n" +
            "                <ServiceTypes>\n" +
            "                    <ServiceType>Hosted Messaging</ServiceType>\n" +
            "                </ServiceTypes>\n" +
            "                <MessagingSettings>\n" +
            "                    <SmsEnabled>true</SmsEnabled>\n" +
            "                    <CampaignId>fYtaiwCESO7Z7sgnc3smfMOg1JgMZ16FCQ1FtFosjHRUSkJVNWYW5p70gdVWGTGe</CampaignId>\n" +
            "                    <MessageClass>V4578Qab0yppj6E4xumcMbmE5d6IPY9FWT37xI9gHt6AGoiEihurpYLNuV5EfbTn </MessageClass>\n" +
            "                    <A2pState>overridden</A2pState>\n" +
            "                    <AssignedNnRoute>\n" +
            "                        <Nnid>2183991</Nnid>\n" +
            "                        <Name>7ae5LXMn</Name>\n" +
            "                    </AssignedNnRoute>\n" +
            "                </MessagingSettings>\n" +
            "                <TnAttributes>\n" +
            "                    <TnAttribute>Hosted</TnAttribute>\n" +
            "                </TnAttributes>\n" +
            "            </HostedTelephoneNumberDetail>\n" +
            "        </HostedTelephoneNumberDetails>\n" +
            "    </TelephoneNumberDetails>\n" +
            "</TelephoneNumberResponse>";

    public static String validTnDetailsResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TelephoneNumberResponse><TelephoneNumberDetails><City>MOUNT OLIVE</City><Lata>426</Lata><State>NC</State><FullNumber>9195551212</FullNumber><Tier>0</Tier><VendorId>49</VendorId><VendorName>Bandwidth CLEC</VendorName><RateCenter>MOUNTOLIVE</RateCenter><Status>Inservice</Status><AccountId>9900096</AccountId><LastModified>2014-10-14T20:01:53.000Z</LastModified><MessagingSettings><SmsEnabled>true</SmsEnabled><MessageClass>UNREGISTERED</MessageClass><A2pState>system_default</A2pState><AssignedNnRoute><Nnid>103775</Nnid><Name>BW A2P - SVR - E151 (103775)</Name></AssignedNnRoute></MessagingSettings></TelephoneNumberDetails></TelephoneNumberResponse>";
    public static String validTnRateCenterResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TelephoneNumberResponse><TelephoneNumberDetails><State>NC</State><RateCenter>MOUNTOLIVE</RateCenter></TelephoneNumberDetails></TelephoneNumberResponse>";
    public static String validTnLataResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TelephoneNumberResponse><TelephoneNumberDetails><Lata>426</Lata></TelephoneNumberDetails></TelephoneNumberResponse>";
    public static String validTnSiteResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Site><Id>2858</Id><Name>Test Site</Name></Site>";
    public static String validTnSipPeerResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SipPeer><Id>507567</Id><Name>SIP Peer 1</Name></SipPeer>";
    public static String validTnListResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TelephoneNumbersResponse><TelephoneNumberCount>2</TelephoneNumberCount><Links><first>Link=&lt;https://dashboard.bandwidth.com/api/tns?state=NC&amp;size=500&amp;page=1&gt;;rel=\"first\";</first></Links><TelephoneNumbers><TelephoneNumber><City>RALEIGH</City><Lata>426</Lata><State>NC</State><FullNumber>9193491234</FullNumber><Tier>0</Tier><VendorId>49</VendorId><VendorName>Bandwidth CLEC</VendorName><RateCenter>RALEIGH   </RateCenter><Status>PortInPendingFoc</Status><AccountId>9500249</AccountId><LastModified>2015-06-03T15:06:35.000Z</LastModified></TelephoneNumber><TelephoneNumber><City>RALEIGH</City><Lata>426</Lata><State>NC</State><FullNumber>9193499473</FullNumber><Tier>0</Tier><VendorId>49</VendorId><VendorName>Bandwidth CLEC</VendorName><RateCenter>RALEIGH   </RateCenter><Status>PortInPendingFoc</Status><AccountId>9500249</AccountId><LastModified>2015-06-03T14:59:20.000Z</LastModified></TelephoneNumber></TelephoneNumbers></TelephoneNumbersResponse>";

    /**
     * Covered RateCenters Xmls
     */

    public static String validCoveredRateCentersResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <CoveredRateCenters><TotalCount>18</TotalCount><Links><first></first><next>Link=&lt;https://dashboard.bandwidth.com/api/coveredRateCenters?npa=310&amp;size=10&amp;embed=Cities&amp;embed=ZipCodes&amp;embed=NpaNxxX&amp; page=5&gt;;rel=\"next\";</next></Links> <CoveredRateCenter><Name>AVALON</Name><Abbreviation>AVALON</Abbreviation> <State>CA</State><Lata>730</Lata> <AvailableNumberCount>1</AvailableNumberCount> <ZipCodes><ZipCode>90731</ZipCode> </ZipCodes><Cities><City>SAN PEDRO</City> </Cities><Tiers> <Tier>0</Tier></Tiers> <NpaNxxXs><NpaNxxX>3105100</NpaNxxX> <NpaNxxX>3105101</NpaNxxX> <NpaNxxX>3109498</NpaNxxX> <NpaNxxX>3109499</NpaNxxX> <NpaNxxX>4242260</NpaNxxX></NpaNxxXs><Id>1</Id> </CoveredRateCenter><CoveredRateCenter><Name>AVALON</Name><Abbreviation>AVALON</Abbreviation> <State>CA</State><Lata>730</Lata> <AvailableNumberCount>1</AvailableNumberCount> <ZipCodes><ZipCode>90731</ZipCode> </ZipCodes><Cities><City>SAN PEDRO</City> </Cities><Tiers> <Tier>0</Tier></Tiers> <NpaNxxXs><NpaNxxX>3105100</NpaNxxX> <NpaNxxX>3105101</NpaNxxX> <NpaNxxX>3109498</NpaNxxX> <NpaNxxX>3109499</NpaNxxX> <NpaNxxX>4242260</NpaNxxX></NpaNxxXs><Id>1</Id> </CoveredRateCenter></CoveredRateCenters>";

    /**
     * Line Option Order Xmls
     */

    public static String validLineOptionOrderRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <LineOptionOrder><TnLineOptions> <TelephoneNumber>5209072451</TelephoneNumber> <CallingNameDisplay>off</CallingNameDisplay></TnLineOptions> <TnLineOptions><TelephoneNumber>5209072452</TelephoneNumber><CallingNameDisplay>on</CallingNameDisplay> </TnLineOptions><TnLineOptions><TelephoneNumber>2013223685</TelephoneNumber><CallingNameDisplay>on</CallingNameDisplay> </TnLineOptions></LineOptionOrder>";
    public static String validLineOptionOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <LineOptionOrderResponse><LineOptions> <CompletedNumbers><TelephoneNumber>2013223685</TelephoneNumber> </CompletedNumbers><Errors><Error><TelephoneNumber>5209072452</TelephoneNumber> <ErrorCode>5071</ErrorCode><Description>Telephone number is not available on the system.</Description></Error> <Error><TelephoneNumber>5209072451</TelephoneNumber> <ErrorCode>13518</ErrorCode><Description>CNAM for telephone number is applied at the Location level and it is not applicable at the TN level.</Description> </Error></Errors> </LineOptions></LineOptionOrderResponse>";

    /**
     * Lidb Order Xmls
     */

    public static String validLidbOrderRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <LidbOrder><LidbTnGroups> <LidbTnGroup><TelephoneNumbers> <TelephoneNumber>4352154856</TelephoneNumber></TelephoneNumbers> <SubscriberInformation>Steve</SubscriberInformation> <UseType>RESIDENTIAL</UseType> <Visibility>PUBLIC</Visibility></LidbTnGroup> <LidbTnGroup><TelephoneNumbers><TelephoneNumber>4352154855</TelephoneNumber> </TelephoneNumbers> <SubscriberInformation>Steve</SubscriberInformation> <UseType>RESIDENTIAL</UseType> <Visibility>PUBLIC</Visibility></LidbTnGroup> </LidbTnGroups></LidbOrder>";
    public static String validLidbOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <LidbOrder><id>2dda315b-e669-459b-940c-a76760d60906</id> <OrderCreateDate>2014-07-13T17:48:10.043Z</OrderCreateDate> <AccountId>12346099</AccountId> <CreatedByUser>jbm</CreatedByUser> <OrderId>2dda315b-e669-459b-940c-a76760d60906</OrderId> <LastModifiedDate>2014-07-13T17:48:10.043Z</LastModifiedDate> <ProcessingStatus>RECEIVED</ProcessingStatus><ErrorList/><LidbTnGroups><LidbTnGroup><TelephoneNumbers> <TelephoneNumber>4352169755</TelephoneNumber></TelephoneNumbers> <SubscriberInformation>Steve</SubscriberInformation> <UseType>RESIDENTIAL</UseType> <Visibility>PUBLIC</Visibility></LidbTnGroup> <LidbTnGroup><TelephoneNumbers> <TelephoneNumber>4352721843</TelephoneNumber></TelephoneNumbers> <SubscriberInformation>Steve</SubscriberInformation> <UseType>RESIDENTIAL</UseType> <Visibility>PUBLIC</Visibility></LidbTnGroup> </LidbTnGroups></LidbOrder>";

    /**
     * Dlda Order Xmls
     */

    public static String validDldaOrderRequestXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><DldaOrder> <CustomerOrderId>[String]</CustomerOrderId> <DLDATnGroups><DLDATnGroup> <TelephoneNumbers><TelephoneNumber>5202217754</TelephoneNumber> </TelephoneNumbers> <AccountType>RESIDENTIAL</AccountType> <ListingType>LISTED</ListingType><ListingName> <FirstName>John</FirstName> <FirstName2/> <LastName>Smith</LastName><Designation/> <TitleOfLineage/> <TitleOfAddress/> <TitleOfAddress2/> <TitleOfLineageName2/> <TitleOfAddressName2/> <TitleOfAddress2Name2/> <PlaceListingAs/></ListingName> <ListAddress>true</ListAddress> <Address><HousePrefix/> <HouseNumber>915</HouseNumber> <HouseSuffix/><PreDirectional/> <StreetName>Elm</StreetName> <StreetSuffix>Ave</StreetSuffix> <PostDirectional/><AddressLine2/> <City>Carpinteria</City> <StateCode>CA</StateCode> <Zip>93013</Zip><PlusFour/><County/> <AddressType>DLDA</AddressType></Address> </DLDATnGroup></DLDATnGroups> </DldaOrder>";
    public static String validDldaOrderResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <DldaOrderResponse><DldaOrder><CustomerOrderId>[String]</CustomerOrderId> <OrderCreateDate>2014-07-16T07:59:08.065Z</OrderCreateDate> <AccountId>14</AccountId> <CreatedByUser>team_ua</CreatedByUser> <OrderId>f2ac3343-5bff-424a-b8ca-975f5e7b159e</OrderId> <LastModifiedDate>2014-07-16T07:59:08.065Z</LastModifiedDate> <ErrorList/><ProcessingStatus>RECEIVED</ProcessingStatus> <DldaTnGroups><DldaTnGroup><TelephoneNumbers> <TelephoneNumber>5202217754</TelephoneNumber></TelephoneNumbers> <AccountType>RESIDENCE</AccountType> <ListingType>LISTED</ListingType> <ListingName><FirstName>John</FirstName> <FirstName2></FirstName2> <LastName>Smith</LastName> <Designation></Designation> <TitleOfLineage></TitleOfLineage> <TitleOfAddress></TitleOfAddress> <TitleOfAddress2></TitleOfAddress2> <TitleOfLineageName2></TitleOfLineageName2> <TitleOfAddressName2></TitleOfAddressName2> <TitleOfAddress2Name2></TitleOfAddress2Name2> <PlaceListingAs></PlaceListingAs></ListingName> <ListAddress>true</ListAddress> <Address><HousePrefix></HousePrefix> <HouseNumber>915</HouseNumber> <HouseSuffix></HouseSuffix> <PreDirectional></PreDirectional> <StreetName>Elm</StreetName> <StreetSuffix>Ave</StreetSuffix> <PostDirectional></PostDirectional><AddressLine2></AddressLine2> <City>Carpinteria</City> <StateCode>CA</StateCode> <Zip>93013</Zip> <PlusFour></PlusFour> <County></County> <Country>United States</Country> <AddressType>Dlda</AddressType></Address> </DldaTnGroup>￼</DldaTnGroups> </DldaOrder></DldaOrderResponse>";

    /**
     * Inservice Tns Xmls
     */

    public static String validInserviceTnsResponseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><TNs><TotalCount>59</TotalCount><Links><first> ( a link goes here ) </first></Links><TelephoneNumbers><Count>59</Count><TelephoneNumber>9195551212</TelephoneNumber></TelephoneNumbers></TNs>";
    public static String createTnOptionResponse = "<TnOptionOrderResponse>\n" +
            "    <TnOptionOrder>\n" +
            "        <OrderCreateDate>2016-01-15T12:01:14.324Z</OrderCreateDate>\n" +
            "        <AccountId>14</AccountId>\n" +
            "        <CreatedByUser>jbm</CreatedByUser>\n" +
            "        <OrderId>ddbdc72e-dc27-490c-904e-d0c11291b095</OrderId>\n" +
            "        <LastModifiedDate>2016-01-15T12:01:14.324Z</LastModifiedDate>\n" +
            "        <ProcessingStatus>RECEIVED</ProcessingStatus>\n" +
            "        <TnOptionGroups>\n" +
            "            <TnOptionGroup>\n" +
            "                <NumberFormat>10digit</NumberFormat>\n" +
            "                <RPIDFormat>10digit</RPIDFormat>\n" +
            "                <RewriteUser>testUser1</RewriteUser>\n" +
            "                <CallForward>6042661720</CallForward>\n" +
            "                <CallingNameDisplay>on</CallingNameDisplay>\n" +
            "                <Protected>true</Protected>\n" +
            "                <Sms>on</Sms>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2018551020</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "            <TnOptionGroup>\n" +
            "                <CallingNameDisplay>off</CallingNameDisplay>\n" +
            "                <Protected>false</Protected>\n" +
            "                <Sms>off</Sms>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2018551025</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "        </TnOptionGroups>\n" +
            "        <ErrorList/>\n" +
            "    </TnOptionOrder>\n" +
            "</TnOptionOrderResponse>";

    public static String listTnOptions = "<TnOptionOrders>\n" +
            "    <TotalCount>2</TotalCount>\n" +
            "    <TnOptionOrder>\n" +
            "        <OrderCreateDate>2016-01-15T12:01:14.324Z</OrderCreateDate>\n" +
            "        <AccountId>14</AccountId>\n" +
            "        <CreatedByUser>jbm</CreatedByUser>\n" +
            "        <OrderId>ddbdc72e-dc27-490c-904e-d0c11291b095</OrderId>\n" +
            "        <LastModifiedDate>2016-01-15T12:01:14.363Z</LastModifiedDate>\n" +
            "        <ProcessingStatus>FAILED</ProcessingStatus>\n" +
            "        <TnOptionGroups>\n" +
            "            <TnOptionGroup>\n" +
            "                <NumberFormat>10digit</NumberFormat>\n" +
            "                <RPIDFormat>10digit</RPIDFormat>\n" +
            "                <RewriteUser>testUser1</RewriteUser>\n" +
            "                <CallForward>6042661720</CallForward>\n" +
            "                <CallingNameDisplay>on</CallingNameDisplay>\n" +
            "                <Protected>true</Protected>\n" +
            "                <Sms>on</Sms>\n" +
            "                <FinalDestinationURI>sip:+12345678901@1.2.3.4:5060</FinalDestinationURI>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2018551020</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "            <TnOptionGroup>\n" +
            "                <CallingNameDisplay>off</CallingNameDisplay>\n" +
            "                <Protected>false</Protected>\n" +
            "                <Sms>off</Sms>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2018551025</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "        </TnOptionGroups>\n" +
            "    </TnOptionOrder>\n" +
            "    <TnOptionOrder>\n" +
            "        <OrderCreateDate>2016-01-15T11:22:58.789Z</OrderCreateDate>\n" +
            "        <AccountId>14</AccountId>\n" +
            "        <CreatedByUser>jbm</CreatedByUser>\n" +
            "        <OrderId>409033ee-88ec-43e3-85f3-538f30733963</OrderId>\n" +
            "        <LastModifiedDate>2016-01-15T11:22:58.969Z</LastModifiedDate>\n" +
            "        <ProcessingStatus>COMPLETE</ProcessingStatus>\n" +
            "        <TnOptionGroups>\n" +
            "            <TnOptionGroup>\n" +
            "                <CallingNameDisplay>on</CallingNameDisplay>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2174101601</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "            <TnOptionGroup>\n" +
            "                <CallingNameDisplay>off</CallingNameDisplay>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2174101602</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "            <TnOptionGroup>\n" +
            "                <CallingNameDisplay>systemdefault</CallingNameDisplay>\n" +
            "                <TelephoneNumbers>\n" +
            "                    <TelephoneNumber>2174101603</TelephoneNumber>\n" +
            "                </TelephoneNumbers>\n" +
            "            </TnOptionGroup>\n" +
            "        </TnOptionGroups>\n" +
            "    </TnOptionOrder>\n" +
            "</TnOptionOrders>";
    public static String listTnOptionsWithSummary = "<TnOptionOrders>\n" +
            "    <TotalCount>2</TotalCount>\n" +
            "    <TnOptionOrderSummary>\n" +
            "        <accountId>14</accountId>\n" +
            "        <CountOfTNs>2</CountOfTNs>\n" +
            "        <userId>jbm</userId>\n" +
            "        <lastModifiedDate>2016-01-15T12:01:14.363Z</lastModifiedDate>\n" +
            "        <OrderDate>2016-01-15T12:01:14.324Z</OrderDate>\n" +
            "        <OrderType>tn_option</OrderType>\n" +
            "        <OrderStatus>FAILED</OrderStatus>\n" +
            "        <OrderId>ddbdc72e-dc27-490c-904e-d0c11291b095</OrderId>\n" +
            "    </TnOptionOrderSummary>\n" +
            "    <TnOptionOrderSummary>\n" +
            "        <accountId>14</accountId>\n" +
            "        <CountOfTNs>3</CountOfTNs>\n" +
            "        <userId>jbm</userId>\n" +
            "        <lastModifiedDate>2016-01-15T11:22:58.969Z</lastModifiedDate>\n" +
            "        <OrderDate>2016-01-15T11:22:58.789Z</OrderDate>\n" +
            "        <OrderType>tn_option</OrderType>\n" +
            "        <OrderStatus>COMPLETE</OrderStatus>\n" +
            "        <OrderId>409033ee-88ec-43e3-85f3-538f30733963</OrderId>\n" +
            "    </TnOptionOrderSummary>\n" +
            "</TnOptionOrders>";
    public static String getTnOption = "<TnOptionOrder>\n" +
            "    <OrderCreateDate>2016-01-15T11:22:58.789Z</OrderCreateDate>\n" +
            "    <AccountId>14</AccountId>\n" +
            "    <CreatedByUser>jbm</CreatedByUser>\n" +
            "    <OrderId>409033ee-88ec-43e3-85f3-538f30733963</OrderId>\n" +
            "    <LastModifiedDate>2016-01-15T11:22:58.969Z</LastModifiedDate>\n" +
            "    <ProcessingStatus>COMPLETE</ProcessingStatus>\n" +
            "    <TnOptionGroups>\n" +
            "        <TnOptionGroup>\n" +
            "            <CallingNameDisplay>on</CallingNameDisplay>\n" +
            "            <Sms>on</Sms>\n" +
            "            <TelephoneNumbers>\n" +
            "                <TelephoneNumber>2174101601</TelephoneNumber>\n" +
            "            </TelephoneNumbers>\n" +
            "        </TnOptionGroup>\n" +
            "        <TnOptionGroup>\n" +
            "            <CallingNameDisplay>off</CallingNameDisplay>\n" +
            "            <TelephoneNumbers>\n" +
            "                <TelephoneNumber>2174101602</TelephoneNumber>\n" +
            "            </TelephoneNumbers>\n" +
            "        </TnOptionGroup>\n" +
            "        <TnOptionGroup>\n" +
            "            <CallingNameDisplay>systemdefault</CallingNameDisplay>\n" +
            "            <FinalDestinationURI>sip:+12345678901@1.2.3.4:5060</FinalDestinationURI>\n" +
            "            <TelephoneNumbers>\n" +
            "                <TelephoneNumber>2174101603</TelephoneNumber>\n" +
            "            </TelephoneNumbers>\n" +
            "        </TnOptionGroup>\n" +
            "    </TnOptionGroups>\n" +
            "    <ErrorList/>\n" +
            "    <Warnings>\n" +
            "        <Warning>\n" +
            "            <TelephoneNumber>2174101601</TelephoneNumber>\n" +
            "            <Description>SMS is already Enabled or number is in processing.</Description>\n" +
            "        </Warning>\n" +
            "    </Warnings>\n" +
            "</TnOptionOrder>";
    public static String getTnOptionsWithError = "<TnOptionOrder>\n" +
            "    <OrderCreateDate>2016-01-15T12:01:14.324Z</OrderCreateDate>\n" +
            "    <AccountId>14</AccountId>\n" +
            "    <CreatedByUser>jbm</CreatedByUser>\n" +
            "    <OrderId>ddbdc72e-dc27-490c-904e-d0c11291b095</OrderId>\n" +
            "    <LastModifiedDate>2016-01-15T12:01:14.363Z</LastModifiedDate>\n" +
            "    <ProcessingStatus>FAILED</ProcessingStatus>\n" +
            "    <TnOptionGroups>\n" +
            "        <TnOptionGroup>\n" +
            "            <NumberFormat>10digit</NumberFormat>\n" +
            "            <RPIDFormat>10digit</RPIDFormat>\n" +
            "            <RewriteUser>testUser1</RewriteUser>\n" +
            "            <CallForward>6042661720</CallForward>\n" +
            "            <CallingNameDisplay>on</CallingNameDisplay>\n" +
            "            <Protected>true</Protected>\n" +
            "            <Sms>on</Sms>\n" +
            "            <FinalDestinationURI>sip:+12345678901@1.2.3.4:5060</FinalDestinationURI>\n" +
            "            <TelephoneNumbers>\n" +
            "                <TelephoneNumber>2018551020</TelephoneNumber>\n" +
            "            </TelephoneNumbers>\n" +
            "        </TnOptionGroup>\n" +
            "        <TnOptionGroup>\n" +
            "            <CallingNameDisplay>off</CallingNameDisplay>\n" +
            "            <Protected>false</Protected>\n" +
            "            <Sms>off</Sms>\n" +
            "            <TelephoneNumbers>\n" +
            "                <TelephoneNumber>2018551025</TelephoneNumber>\n" +
            "            </TelephoneNumbers>\n" +
            "        </TnOptionGroup>\n" +
            "    </TnOptionGroups>\n" +
            "    <ErrorList>\n" +
            "        <Error>\n" +
            "            <Code>5076</Code>\n" +
            "            <Description>Telephone number is not available.</Description>\n" +
            "            <TelephoneNumber>2018551025</TelephoneNumber>\n" +
            "        </Error>\n" +
            "        <Error>\n" +
            "            <Code>5076</Code>\n" +
            "            <Description>Telephone number is not available.</Description>\n" +
            "            <TelephoneNumber>2018551020</TelephoneNumber>\n" +
            "        </Error>\n" +
            "    </ErrorList>\n" +
            "</TnOptionOrder>";

    public static String updateSipPeerSmsSetting = "";

    public static String updateSipPeerMmsSetting = "<MmsFeatureResponse>\n" +
            "    <MmsFeature>\n" +
            "        <MmsSettings>\n" +
            "            <Protocol>HTTP</Protocol>\n" +
            "        </MmsSettings>\n" +
            "        <Protocols>\n" +
            "            <HTTP>\n" +
            "                <HttpSettings>\n" +
            "                    <ProxyPeerId>569238</ProxyPeerId>\n" +
            "                </HttpSettings>\n" +
            "            </HTTP>\n" +
            "        </Protocols>\n" +
            "    </MmsFeature>\n" +
            "</MmsFeatureResponse>";

    public static String updateSipPeerApplicationSetting = "";

}
