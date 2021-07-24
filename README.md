# JinHw
 
 CoinDesk CRUD
 * all : GET http://localhost:8080/coinDesks
 * one : GET http://localhost:8080//coinDesks/{coinCode} { "coinCode":"USD" }
 * add : POST http://localhost:8080/coinDesk/{coinCode} { CoinDeskBean obj }
 * update : PUT http://localhost:8080/coinDesk/{coinCode} { "coinCode":"GBP", CoinDeskBean obj }
 * delete : DELETE http://localhost:8080/coinDesk/{coinCode} { "coinCode":"USD" }
 
 CoinDesk JsonObject API
 * GET http://localhost:8080/coinDesk
 * Data Cove: GET http://localhost:8080/coinDesk/dataConversion
