package createaddress;

import io.restassured.response.Response;
import model.Address;
import org.junit.Assert;
import org.junit.Test;
import utils.BaseTest;

import static utils.RandomGenerator.createRandomString;
import static utils.PropertiesReader.getProrerty;

public class CreateAddressPositiveTests extends BaseTest {

  @Test
  public void checkGenerateNewAddressWithGivenLabel() {
    String uniqueLabel = createRandomString();
    String apiKey = getProrerty("apiKey");
    Response response = walletController.getNewAddressWithGivenLabel(apiKey, uniqueLabel);
    response.then().statusCode(200);
    Address createdAddress = response.as(Address.class);
    Assert.assertEquals(createdAddress.getData().getLabel(), uniqueLabel);
  }
}