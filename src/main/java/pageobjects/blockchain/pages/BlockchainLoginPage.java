package pageobjects.blockchain.pages;

import driver.DriverBase;
import environment.EnvironmentConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.base.AbstractPage;
import utils.TestReporter;

public class BlockchainLoginPage extends AbstractPage {

  private static final int TIMEOUT_TO_CLICKABLE = 5;

  // Selectors
  private static final By blockChainImageBy = By.cssSelector("a[href]>img");
  private static final By walletIdInputBy = By.cssSelector("input[data-e2e='loginGuid']");
  private static final By passwordInputBy = By.cssSelector("input[data-e2e='loginPassword']");
  private static final By submitButtonBy = By.cssSelector("button[data-e2e='loginButton']");
  private static final By signUpLinkBy = By.cssSelector("a[data-e2e='signupLink']");

  private URL blockchainLoginPageUrl;

  /**
   * Constructor of the BlockChainLoginPage class.
   */
  public BlockchainLoginPage() {
    super();
    logger.debug("Initializing Blockchain login Page");
    try {
      blockchainLoginPageUrl = new URL(EnvironmentConfig.getBlockchainLoginUrl());
    } catch (MalformedURLException e) {
      logger.error("The URL format '{}' is not correct.",
          EnvironmentConfig.getBlockchainLoginUrl(), e);
      throwNotLoadedException("The blockchain login page could not be opened", e);
    }
    logger.debug("Set blockchain login page url to: '{}'", blockchainLoginPageUrl);
  }

  /**
   * Enters Wallet id into the walletId input field.
   *
   * @param walletId String
   * @return BlockchainLoginPage
   */
  public BlockchainLoginPage enterWalletId(String walletId) {
    TestReporter.addInfoToReport("Enter walletId: " + walletId);
    driver.findElement(walletIdInputBy).sendKeys(walletId);
    return this;
  }

  /**
   * Enters password into the password input field.
   *
   * @param password String
   * @return BlockchainLoginPage
   */
  public BlockchainLoginPage enterPassword(String password) {
    TestReporter.addInfoToReport("Enter password: " + password);
    driver.findElement(passwordInputBy).sendKeys(password);
    return this;
  }

  /**
   * Clicks on the login button to confirm Login.
   *
   * @return BlockChainHomePage
   */
  public BlockchainHomePage clickLoginButton() {
    TestReporter.addInfoToReport("Click on Log In button");
    WebDriverWait wait = new WebDriverWait(DriverBase.getDriver(),
        TIMEOUT_TO_CLICKABLE);
    wait.until(ExpectedConditions.elementToBeClickable(submitButtonBy)).click();
    BlockchainHomePage blockchainHomePage = new BlockchainHomePage();
    blockchainHomePage.get();
    return blockchainHomePage;
  }



  /**
   * load() is called when BlockchainLoginPage.get() is called. Opens the login page defined by the
   * configuration selected.
   */
  @Override
  protected void load() {
    TestReporter.addInfoToReport("Opening Blockchain login Page: " + blockchainLoginPageUrl);
    driver.get(blockchainLoginPageUrl.toString());
  }

  @Override
  protected void isLoaded() throws Error {
    final Instant start = Instant.now();
    try {
      driver.findElement(blockChainImageBy);
      logger.debug("Blockchain image is displayed");
      driver.findElement(walletIdInputBy);
      logger.debug("Wallet ID input field is displayed");
      driver.findElement(passwordInputBy);
      logger.debug("Password input field is displayed");
      driver.findElement(submitButtonBy);
      logger.debug("Submit button is displayed");
      driver.findElement(signUpLinkBy);
      logger.debug("Sign Up link is displayed");


    } catch (Exception e) {
      throwNotLoadedException("The Blockchain login page was not loaded correctly", e);
    }
    final Instant finish = Instant.now();
    final long timeElapsed = Duration.between(start, finish).toMillis();
    TestReporter.addScreenshotToReport("The Blockchain Login page was loaded correctly in "
        + timeElapsed + " milliseconds.");

  }
}
