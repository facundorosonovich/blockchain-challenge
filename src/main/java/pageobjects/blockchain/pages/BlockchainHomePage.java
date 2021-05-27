package pageobjects.blockchain.pages;

import java.time.Duration;
import java.time.Instant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import pageobjects.base.AbstractPage;
import utils.TestReporter;

public class BlockchainHomePage extends AbstractPage {

  // Selectors
  private static final By homeLinkBy = By.cssSelector("[data-e2e='homeLink']");
  private static final By totalBalanceBy = By.cssSelector("[data-e2e='topBalanceTotal']");
  private static final By dashboardLinkBy = By.cssSelector("[data-e2e='dashboardLink']");
  private static final By homePageBy = By.cssSelector("[data-e2e='page-home']");

  /**
   * Container of the Blockchain Home page.
   */
  public BlockchainHomePage() {
    super();
    logger.debug("Initializing Blockchain Home Page");
  }

  /**
   * Checks if HomePage is displayed.
   *
   * @return True if Home page is displayed, false otherwise.
   */
  public boolean isHomePage() {
    logger.debug("Validating if HomePage is displayed:");
    try {
      return driver.findElement(homePageBy).isDisplayed();
    } catch (NoSuchElementException e) {
      logger.debug("Home Page was not found ", e);
      return false;
    }
  }

  @Override
  protected void isLoaded() throws Error {
    final Instant start = Instant.now();
    try {
      driver.findElement(homeLinkBy);
      logger.debug("Home link is displayed");
      driver.findElement(totalBalanceBy);
      logger.debug("Total Balance is displayed");
      driver.findElement(dashboardLinkBy);
      logger.debug("Dashboard link is displayed");
      driver.findElement(homePageBy);
      logger.debug("Page Home is displayed");

    } catch (Exception e) {
      throwNotLoadedException("The Blockchain home page was not loaded correctly", e);
    }
    final Instant finish = Instant.now();
    final long timeElapsed = Duration.between(start, finish).toMillis();
    TestReporter.addScreenshotToReport("The Blockchain Home page was loaded correctly in "
        + timeElapsed + " milliseconds.");

  }

}
