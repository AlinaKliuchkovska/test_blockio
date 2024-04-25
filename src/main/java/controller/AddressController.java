package controller;

import io.restassured.*;
import io.restassured.response.Response;

import java.util.Map;

public class AddressController {
  public Response getNewAddressWithGivenLabel(String apiKey, String label){
    return RestAssured.given()
            .queryParam("api_key", apiKey)
            .queryParam("label", label)
            .get("/get_new_address");
  }

  public Response prepareTransactionCustomNetworkFee(String apiKey, String priority, String toAddress, String amount, String customFeeAmount){
    return RestAssured.given()
            .queryParam("api_key", apiKey)
            .queryParam("priority", priority)
            .queryParam("custom_network_fee", customFeeAmount)
            .queryParam("amounts", amount)
            .queryParam("to_addresses", toAddress)
            .post("/prepare_transaction");
  }

  public Response submitTransaction (Map<String, Integer> body){
    return RestAssured.given()
            .header("Content-Type" ,"application/json")
            .body(body)
            .post("/submit_transaction");
  }

  public Response getAddressBalance(String apiKey, String address){
    return RestAssured.given()
            .queryParam("api_key", apiKey)
            .queryParam("address", address)
            .get("/get_address_balance");
  }

  public Response getTransactions(String apiKey, String type){
    return RestAssured.given()
            .queryParam("api_key", apiKey)
            .queryParam("type", type)
            .get("/get_transactions");
  }
}
