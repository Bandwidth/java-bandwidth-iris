# node-bandwidth-iris

Java Client library for IRIS / BBS API

## Installing

Bandwidth Java IRIS SDK uses Maven. The jars are available from a public Maven repository

Use the following dependency in your project:
```
<dependency>
  <groupId>com.bandwidth.sdk</groupId>
  <artifactId>bandwidth-java-iris-sdk</artifactId>
  <version>1.0</version>
  <scope>compile</scope>
</dependency>
```

If you want to compile it yourself, here's how:
```bash
$ git clone git@github.com:bandwidthcom/java-bandwidth-iris.git
$ cd java-bandwidth-iris
$ mvn install
```

## Usage

Creating the client
```Java
IrisClient client = new IrisClient(accountId, username, password);

// You can then use the client to call a particular object's methods, e.g.
Site s = new Site();
Site returnSite = Site.create(client, s);

```

## Examples
There is an 'examples' folder in the source tree that shows how each of the API objects work with simple example code.
To run each of the examples, set them as run targets in your IDE, then set the following system environment variables:

```
export BANDWIDTH_IRIS_ACCOUNTID=<youraccountid>
export BANDWIDTH_IRIS_USERNAME=<yourusername>
export BANDWIDTH_IRIS_PASSWORD=<yourpassword>
export BANDWIDTH_IRIS_URL=https://api.inetwork.com //OR https://api.test.inetwork.com if you are working on test network
```


## API Objects 
### General principles
When fetching objects from the API, it will always return an object that has the client
instantiated so that you can call dependent methods as well as update, delete.

Example:
```Java
Site newSite = new Site();
newSite.setName("My New Site");

Site s = Site.create(client, newSite);
s.setName("Some Other Name");
s.update();
//then
s.delete();// etc
```

Each entity, where appropriate has a get, list, create, update and delete method

## Available Numbers
```
Map<String, Object> query = new HashMap<String, Object>();
query.put("areaCode", "205");
query.put("enableTNDetail", true);
query.put("quantity", 2);

List<TelephoneNumberDetail> numbers = (List<TelephoneNumberDetail>) AvailableNumbers.search(getClient(), query);
for (TelephoneNumberDetail number : numbers)
{
    System.out.println(String.format("Full number: %s : Rate Center: %s", number.getFullNumber(), number.getRateCenter()));
}
```

## Available NpaNxx
```Java
Map<String, Object> query = new HashMap<String, Object>();
query.put("areaCode", "805");
query.put("quantity", 2);
List<AvailableNpaNxx> availableNpaNxxList = AvailableNpaNxx.list(getClient(), query);
for(AvailableNpaNxx npaNxx : availableNpaNxxList){
    System.out.println(
      String.format("City: %s | Npa: %s | Nxx: %s | State: %s ", npaNxx.getCity(), npaNxx.getNpa(),
              npaNxx.getNxx(), npaNxx.getState())
    );
}


```

## Cities
```Java
Map<String, Object> query = new HashMap<String, Object>();
query.put("state", "NC");

List<City> cities = City.list(getClient(), query);
for(City c : cities){
    System.out.println(String.format("Name: %s | RcAbbreviation: %s", c.getName(), c.getRcAbbreviation()));
}
```

## Covered Rate Centers
```Java

```

## Disconnected Numbers
Retrieves a list of disconnected numbers for an account
```Java

```

## Disconnect Numbers 
The Disconnect object is used to disconnect numbers from an account.  Creates a disconnect order that can be tracked

### Create Disconnect
```Javascript
```

### Get Disconnect
```Javascript
```

### Add Note to Disconnect
```Javascript
```

### Get Notes for Disconnect
```Javascript
```

## Dlda

### Create Ddla
```Javascript
```

### Get Dlda
```Javascript
```

### Get Dlda History
```Javascript
```

### List Dldas
```Javascript
```

## Import To Account
This path is generally not available to Bandwidth accounts, and as such is not documented in this API

## In Service Numbers

### List InService Numbers
```Javascript
```

### Get InService Number Detail
```Javascript
```

## Lidb

### Create
```Javascript
```
### Get Lidb
```Javascript
```
### List Lidbs
```Javascript
```

## LNP Checker
### Check LNP
```Javascript
```

## LSR Orders
### Create LSR Order
```Javascript
```
### Get LSR Order
```Javascript
```
### List LSR Orders
```Javascript
```
### Update LSR Order
```Javascript
```
### Get LSR Order History
```Javascript
```
### Get LSR Order Notes
```Javascript
```
### Add LSR Order Note
```Javascript
```

## Orders
### Create Order
```Javascript
```
### Get Order
```Javascript
```
### List Orders
```Javascript
```
### List Area Codes for Order
```Javascript
```
### Order Instance Methods 
```Javascript
```

## Port Ins
### Create PortIn
```Javascript
```
## Get PortIn
```Javascript
```

## List PortIns
``` Javascript
```
### PortIn Instance methods
```Javascript
```
### PortIn File Management
```Javascript

```

## Port Out
### List PortOuts
```Javascript
```
### Get PortOut
```Javascript
```

## Rate Centers
### List Ratecenters
```Javascript
```

## SIP Peers
### Create SIP Peer
```Javascript
```
### Get SIP Peer
```Javascript
```
### List SIP Peers
```Javascript
```
### Delete SIP Peer
```Javascript
```
### SipPeer TN Methods
```Javascript
});
```

## Sites

### Create A Site
A site is what is called Location in the web UI. 
```Javascript
```

### Updating a Site
```Javascript
```
### Deleting a Site
```Javascript
```
### Listing All Sites
```Javascript
```
### Site Instance Methods
```Javascript
```
### Site SipPeer Methods
```Javascript
```

## Subscriptions
### Create Subscription
```Javascript
```
### Get Subscription
```Javascript
```
### List Subscriptions
```Javascript
```
### Subscription Instance Methods
```Javascript
```

## TNs
### Get TN
```Javascript
```
### List TNs
```Javascript
```
### TN Instance Methods
```Javascript
```

## TN Reservation
### Create TN Reservation
```Javascript
```
### Get TN Reservation
```Javascript
```
### Delete TN Reservation
```Javascript
```