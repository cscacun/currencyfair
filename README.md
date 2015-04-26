currencyfair project
=========

## Setup

This project is using spring boot, no need to download any other application servers.

## Endpoints

Project contains 1 endpoint that accepts GET and POST request:
  -- localhost:8889/trademessages

A POST request to the endpoint will create/store the Trade Message passed in the request body:

```javascript
{
	"userId": "85886",
 	"currencyFrom": "EUR",
  	"currencyTo": "GBP",
  	"amountSell": 10.89,
  	"amountBuy": 747.10,
  	"rate": 0.7471,
  	"timePlaced" : "24-JAN-15 10:27:44",
  	"originatingCountry" : "FR"
}
```

A GET request ot the endpoint will return all Trade Messages stored starting wiht the application restart.

Please find examples in the Postman library collection under the `postman_library` folder.

## Scripts

```bash
# to find available gradle tasks
./gradlew tasks

# to build project
./gradlew clean build

# to create idea project
./gradlew idea

# to run the project
./gradlew bootRun