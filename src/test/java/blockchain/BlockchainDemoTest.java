package blockchain;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.blockchain.pages.BlockchainHomePage;
import pageobjects.blockchain.pages.BlockchainLoginPage;
import utils.TestAccount;
import utils.TestAccountProvider;

@Test(groups = {"full-regression"})
public class BlockchainDemoTest extends TestBase {

  @Test(
      groups = {"demo"},
      description = "Login into Blockchain Wallet",
      retryAnalyzer = TestBase.RetryAnalyzer.class
  )
  public void blockchainDemoTest() {

    // Arrange
    TestAccount account = TestAccountProvider.getAccount();

    // Act
    BlockchainLoginPage blockchainLoginPage = new BlockchainLoginPage();
    blockchainLoginPage.get();

    BlockchainHomePage blockchainHomePage = blockchainLoginPage
        .enterWalletId(account.walletId())
        .enterPassword(account.password())
        .clickLoginButton();

    // Assert
    Assert.assertTrue(blockchainHomePage.isHomePage(), "Home page was not displayed");
  }




}
