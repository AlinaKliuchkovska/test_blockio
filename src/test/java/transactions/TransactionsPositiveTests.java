package transactions;

import io.restassured.response.Response;
import model.Address;
import model.Balance;
import model.PrepareTransaction;
import model.Transaction;
import model.data.Amounts;
import org.junit.Assert;
import org.junit.Test;
import utils.BaseTest;

import static utils.PropertiesReader.getProrerty;
import static utils.RandomGenerator.createRandomString;

public class TransactionsPositiveTests extends BaseTest {
  //hardcoded values, that was prepared manually
  private String transactionId = "f103f62d8b9a4ef156e8e7f214f070f17de3b1eddeb7dc1424dfc00729cfc88b";
  private String transactionRecipient = "2NBUh2G8fo4tojswZi8R8LTLv9nmwuTwjSh";
  String transactionAmount = getProrerty("transactionAmount");
  String apiKey = getProrerty("apiKey");

  @Test
  public void checkThatCorrectBalanceReturnedForCreatedAddress() {
    Response newAddressResponse = walletController.getNewAddressWithGivenLabel(apiKey, createRandomString());
    newAddressResponse.then().statusCode(200);
    Address createdAddress = newAddressResponse.as(Address.class);
    Response prepareTransactionResponse = walletController.prepareTransactionCustomNetworkFee(apiKey, "custom", createdAddress.getData().getAddress(),
            transactionAmount, getProrerty("customFeeAmount"));
    prepareTransactionResponse.then().statusCode(200);
    PrepareTransaction prepareTransaction = prepareTransactionResponse.as(PrepareTransaction.class);
    //commented because transaction did manually
    //    transactionId = prepareTransaction.getData().getTransactionId();
    //    transactionRecipient = prepareTransaction.getData().getOutputs().get(0).getTransactionRecipient();

    //todo: submitTransaction method
    //Map<String, Integer> body;
    //Response submitTransaction = walletController.submitTransaction(body);
    //submitTransaction.then().statusCode(200);
    Response verifyBalance = walletController.getAddressBalance(apiKey, transactionRecipient);
    Balance verifyBalanceBody = verifyBalance.as(Balance.class);
    Assert.assertEquals(verifyBalanceBody.getData().getBalances().get(0).getAvailableBalance(), transactionAmount);
  }

  @Test
  public void checkThatResentTransactionExist() {
    Response resentTransactions = walletController.getTransactions(apiKey, "received");
    Transaction transactions = resentTransactions.as(Transaction.class);
    Amounts amount = transactions.getData().getTxs().stream().filter(tx -> tx.getTxid().equals(transactionId)).findFirst().get().getAmountsReceived()
            .stream().filter(amounts -> amounts.getRecipient().equals(transactionRecipient)).findFirst().get();
    Assert.assertEquals(amount.getAmount(), transactionAmount);
  }
}
