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
```Javascript
iris.CoveredRateCenter.list({"zip":"27601"}, callback);
```

## Disconnected Numbers
Retrieves a list of disconnected numbers for an account
```Javascript
iris.DiscNumber.list({"areaCode":"919"}, callback);
```

## Disconnect Numbers 
The Disconnect object is used to disconnect numbers from an account.  Creates a disconnect order that can be tracked

### Create Disconnect
```Javascript
iris.Disconnect.create("Disconnect Order Name", ["9195551212", "9195551213"], callback);
```

### Get Disconnect
```Javascript
iris.Disconnect.get("orderId", {tnDetail:true}, callback);
```

### Add Note to Disconnect
```Javascript
var note = {userId: "my id", description: "Test"};
iris.Disconnect.get("orderId", {tnDetail:true}, function(err,order){
  order.addNote(note, callback);
});
```

### Get Notes for Disconnect
```Javascript
iris.Disconnect.get("orderId", {tnDetail:true}, function(err,order){
  order.getNotes(callback);
});
```

## Dlda

### Create Ddla
```Javascript
var dlda = {
  customerOrderId:"Your Order Id",
  dldaTnGroups: [
    dldaTnGroup: {
      telephoneNumbers: ["9195551212"],
      subscriberType: "RESIDENTIAL",
      listingType: "LISTED",
      listingName:{
        firstName:"John",
        lastName:"Smith"
      },
      listAddress:true,
      address:{
        houseNumber: "123",
        streetName: "Elm",
        streetSuffix: "Ave",
        city: "Carpinteria",
        stateCode:"CA",
        zip:"93013",
        addressType: "DLDA"
      }
    }
  ]
}

iris.Dlda.create(dlda, callback);
```

### Get Dlda
```Javascript
iris.Dlda.get(id, callback);
```

### Get Dlda History
```Javascript
iris.Dlda.get(id, function(err,dlda){
  dlda.getHistory(callback);
});
```

### List Dldas
```Javascript
iris.Dlda.list({telephoneNumber:"9195551212"}, callback);
```

## Import To Account
This path is generally not available to Bandwidth accounts, and as such is not documented in this API

## In Service Numbers

### List InService Numbers
```Javascript
iris.InServiceNumber.list({"areaCode":"919"}, callback);
```

### Get InService Number Detail
```Javascript
iris.InServiceNumber.get("9195551212", callback);
```

## Lidb

### Create
```Javascript
var data = {
  customerOrderId:"A test order",
  lidbTnGroups:{
    lidbTnGroup:{
      telephoneNumbers:["8048030097", "8045030098"],
      subscriberInformation:"Joes Grarage",
      useType: "RESIDENTIAL",
      visibility: "PUBLIC"
    }
  }
}
iris.Lidbs.create(data, callback);
```
### Get Lidb
```Javascript
iris.Lidbs.get(id, callback);
```
### List Lidbs
```Javascript
iris.Lidbs.list({telephoneNumber:"9195551212"}, callback);
```

## LNP Checker
### Check LNP
```Javascript
var numbers = ["9195551212", "9195551213"];
var fullCheck = true;
iris.LnpChecker.check(numbers, fullCheck, callback);
```

## LSR Orders
### Create LSR Order
```Javascript
var data = {
  pon:"Some Pon",
  customerOrderId: "MyId5",
  sPID:"123C",
  billingTelephoneNumber:"9192381468",
  requestedFocDate: "2015-11-15",
  authorizingPerson: "Jim Hopkins",
  subscriber:{
    subscriberType:"BUSINESS",
    businessName:"BusinessName",
    serviceAddress: {
      houseNumber:"11",
      streetName: "Park",
      streetSuffix: "Ave",
      city:"New York",
      stateCode: "NY",
      zip: "90025"
    },
    accountNumber:"123463",
    pinNumber:"1231"
  },
  listOfTelephoneNumbers: {
    telephoneNumber:["9192381848", "9192381467"]
  }
};

iris.LsrOrder.create(data, callback);
```
### Get LSR Order
```Javascript
iris.LsrOrder.get(id, callback);
```
### List LSR Orders
```Javascript
iris.LsrOrder.list({pon:"Some Pon"}, callback);
```
### Update LSR Order
```Javascript
iris.LsrOrder.get("id", function(err, order){
  order.requestedFocDate = "2015-11-16";
  iris.LsrOrder.update(order, callback);
})
```
### Get LSR Order History
```Javascript
iris.LsrOrder.get("id", function(err, order){
  order.getHistory(callback);
});
```
### Get LSR Order Notes
```Javascript
iris.LsrOrder.get("id", function(err,order){
  order.getNotes(callback);
});
```
### Add LSR Order Note
```Javascript
var note = {userId: "my id", description: "Test"};
iris.LsrOrder.get("id", function(err, order){
  order.addNote(note, callback);
});
```

## Orders
### Create Order
```Javascript
var order = {
  name:"A Test Order",
  siteId: 1111,
  existingTelephoneNumberOrderType: {
    telephoneNumberList:[
      {
        telephoneNumber:"9195551212"
      }
    ]
  }
};

iris.Order.create(order, callback);
```
### Get Order
```Javascript
iris.Order.get(id, callback);
```
### List Orders
```Javascript
iris.Order.list(query, callback);
```
### List Area Codes for Order
```Javascript
iris.Order.get(id, function(err, order){
  order.getAreaCodes(callback);
});
```
### Order Instance Methods 
```Javascript
// get Area Codes
order.getAreaCodes(callback);

// add note to order
var note = {userId: "my id", description: "Test"};
order.addNote(note,callback);

//get Npa Nxxs
order.getNpaNxx(callback);

// get number totals
order.getTotals(callback);

// get all Tns for an order
order.getTns(callback)

// get order history
order.getHistory(callback);

// get order notes
order.getNotes(callback);
```

## Port Ins
### Create PortIn
```Javascript
var data = {
  siteId:1234,
  peerId:5678,
  billingTelephoneNumber: "9195551212",
  subscriber: {
    subscriberType: "BUSINESS",
    businessName: "Company",
    serviceAddress: {
      houseNumber: "123",
      streetName: "EZ Street",
      city: "Raleigh",
      stateCode: "NC",
      county: "Wake"
    }
  }, 
  loaAuthorizingPerson: "Joe Blow",
  listOfPhoneNumbers: {
    phoneNumber:["9195551212"]
  },
  billingType: "PORTIN"
};

iris.PortIn.create(data, callback);
```
## Get PortIn
```Javascript
iris.PortIn.get("id", callback)
```

## List PortIns
``` Javascript
var query = {pon:"a pon"};
iris.PortIn.list(query, function(err, list){
  console.log(JSON.stringify(list));
});
```
### PortIn Instance methods
```Javascript
// fetch instance using PortIn.get(callback, portIn)
portIn.update(data, callback);
portIn.delete(callback);
portIn.getAreaCodes(callback);
portIn.getNpaNxx(callback);
portIn.getTotals(callback);
portIn.getTns(callback);
portIn.getNotes(callback);
portIn.addNote(callback);
portIn.getActivationStatus(callback);
```
### PortIn File Management
```Javascript

iris.PortIn.get("id", function(err, portIn){
  // Add File
  portIn.createFile(fs.createReadStream("myFile.txt"), callback);

  // Update File
  portIn.updateFile("myFile.txt", fs.createReadStream("myFile.txt"), callback);

  // Get File
  portIn.getFile("myFile.txt", callback);

  // Get File Metadata
  portIn.getFileMetadata("myFile.txt", callback);

  // Get Files
  portIn.getFiles(callback);
});
```

## Port Out
### List PortOuts
```Javascript
var query = {"status":"complete"}
iris.PortOut.list(query, callback);
```
### Get PortOut
```Javascript
iris.PortOut.get(id, callback);
```

## Rate Centers
### List Ratecenters
```Javascript
var query = {"available":true, "state":"CA"}
iris.RateCenter.list(query, callback);
```

## SIP Peers
### Create SIP Peer
```Javascript
var data = {
  peerName:"A New SIP Peer",
  isDefaultPeer:false, 
  shortMessagingProtocol:"SMPP",
  siteId:selectedSite, 
  voiceHosts:[
    {
      host:{
        hostName:"1.1.1.1"
      }
    }
  ],
  smsHosts:[
    {
      host:{
        hostName:"1.1.1.1"
      }
    }
  ],
  terminationHosts:[
    {
      terminationHost:{
        hostName:"1.1.1.1",
        port:5060,
      }
    }
  ]
};

iris.SipPeer.create(data, callback);
```
### Get SIP Peer
```Javascript
iris.SipPeer.get("id", callback);
```
### List SIP Peers
```Javascript
iris.SipPeer.list(siteId, callback);
```
### Delete SIP Peer
```Javascript
iris.SipPeer.get(function(err, sipPeer){
  sipPeer.delete(callback);
});
```
### SipPeer TN Methods
```Javascript
iris.SipPeer.get(function(err,sipPeer){
  // get TN for this peer
  sipPeer.getTns(number, callback);  
  
  // get all TNs for this peer
  sipPeer.getTns(callback);

  // Update TNs for this peer
  var tns = {fullNumber: "123456", rewriteUser: "test"};
  sipPeer.updateTns(number, tns, callback);

  // Move Tns to new peer
  var numbersToMove = ["9195551212", "9195551213"];
  sipPeer.moveTns(numbersToMove, callback);
});
```

## Sites

### Create A Site
A site is what is called Location in the web UI. 
```Javascript
var site = {
  name:"A new site",
  description:"A new description",
  address:{
    houseNumber: "123",
    streetName: "Anywhere St",
    city: "Raleigh",
    stateCode:"NC",
    zip: "27609",
    addressType: "Service"
  }
};
iris.Site.create(site, callback);
```

### Updating a Site
```Javascript
site.name = "Some new name";
site.update(site, callback);
```
### Deleting a Site
```Javascript
site.delete(callback);
```
### Listing All Sites
```Javascript
iris.Site.list(callback);
```
### Site Instance Methods
```Javascript
iris.Site.get(id, function(err,site){
  // getInService numbers
  site.getInserviceNumbers(query, callback);

  // get Orders
  site.getOrders(query, callback);

  // get PortIns
  site.getPortIns(query, callback);

  // get Total Tns
  site.getTotalTns(query, callback); 
});
```
### Site SipPeer Methods
```Javascript
iris.Site.get(id, function(err,site){
  // get Sip Peers
  site.getSipPeers(callback);

  // get Sip Peer
  site.getSipPeer(id, callback);

  // create Sip Peer
  var sipPeer = {name:"SIP Peer"};
  site.createSipPeer(sipPeer, callback);
});
```

## Subscriptions
### Create Subscription
```Javascript
var subscription = {
  orderType:"orders",
  callbackSubcription: {
    url:"http://mycallbackurl.com",
    user:"userid",
    expiry: 12000
  }
};
iris.Subscription.create(subscription, callback);
```
### Get Subscription
```Javascript
iris.Subscription.get(id, callback);
```
### List Subscriptions
```Javascript
iris.Subscription.list(query, callback);
```
### Subscription Instance Methods
```Javascript
iris.Subscription.get(id, function(err, subscription){
  // update subscription
  var updatedData = {orderType:"portins"};
  subscription.update(updatedData, callback)

  // delete subscription
  subscription.delete(callback);
});
```

## TNs
### Get TN
```Javascript
iris.Tn.get(fullNumber, callback);
```
### List TNs
```Javascript
iris.Tn.list(query, callback);
```
### TN Instance Methods
```Javascript
iris.Tn.get(fullNumber, function(err, tn){
  // Get TN Details
  tn.getTnDetails(callback);

  // Get Sites
  tn.getSites(callback);

  // Get Sip Peers
  tn.getSipPeers(callback);

  // Get Rate Center
  tn.getRateCenter(callback)
});
```

## TN Reservation
### Create TN Reservation
```Javascript
iris.TnReservation.create({"reservedTn":"9195551212"}, callback);
```
### Get TN Reservation
```Javascript
iris.TnReservation.get(id, callback);
```
### Delete TN Reservation
```Javascript
iris.TnReservation.get(id, function(err, tn){
  tn.delete(callback);
});
```