package utils;

import controller.AddressController;
import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Before;

import static utils.PropertiesReader.getProrerty;
public class BaseTest {
  public AddressController walletController;

  @Before
  public void testSettings(){
    RestAssured.baseURI = getProrerty("baseUrl");
    RestAssured.filters(new ResponseLoggingFilter(), new ResponseLoggingFilter());
    walletController = new AddressController();
  }
}
