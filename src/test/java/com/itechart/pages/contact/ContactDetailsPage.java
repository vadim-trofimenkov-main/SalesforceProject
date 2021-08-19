package com.itechart.pages.contact;

import com.itechart.pages.BasePage;
import com.itechart.models.Contact;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ContactDetailsPage extends BasePage {
    private static final By TITLE_CONTACT_LOCATOR = By.xpath("//div[@class='entityNameTitle slds-line-height--reset']");
    private static final By TAB_CONTACT_DETAILS_LOCATOR = By.xpath("//a[@data-label='Details']");
    private static final By EDIT_DETAILS_BUTTON_LOCATOR = By.xpath("//button[@name='Edit']");
    private final By DELETE_BUTTON = By.xpath("//button[@name ='Delete']");
    private final By DELETE_MODAL_TITLE = By.xpath("//div[@class='modal-container slds-modal__container']//h2");
    private final By DELETE_MODAL_BUTTON = By.xpath("//div[@class='modal-container slds-modal__container']//button[@title= 'Delete']");

    @Step("Click Edit button")
    public ContactModalPage clickEditDetailsButton() {
        WebElement element = new WebDriverWait(driver, 5).until(ExpectedConditions
                .presenceOfElementLocated(EDIT_DETAILS_BUTTON_LOCATOR));
        driver.findElement(EDIT_DETAILS_BUTTON_LOCATOR).click();
        return new ContactModalPage(driver);
    }

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check that Contact Details page was opened")
    @Override
    public boolean isPageOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(TITLE_CONTACT_LOCATOR));
        return getTitle().contains("Contact");
    }

    public String getTitle() {
        return driver.findElement(TITLE_CONTACT_LOCATOR).getText();
    }

    @Step("Open Details tab")
    public ContactDetailsPage openDetails() {
        driver.findElement(TAB_CONTACT_DETAILS_LOCATOR).click();
        return this;
    }

    @Step("Validation of entered data")
    public ContactDetailsPage validate(Contact contact) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        validateInput("Name", contact.getName());
        validateInput("Account Name", contact.getAccountName());
        validateInput("Reports To", contact.getReportsTo());
        validateInput("Title", contact.getTitle());
        validateInput("Department", contact.getDepartment());
        validateInput("Email", contact.getEmail());
        validateInput("Phone", contact.getPhone());
        validateInput("Fax", contact.getFax());
        validateInput("Mobile", contact.getMobile());
        return this;
    }

    @Step("Click on Delete button")
    public ContactDetailsPage clickDeleteButton() {
        try {
            driver.findElement(DELETE_BUTTON).click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            driver.findElement(DELETE_BUTTON).click();
        }
        wait.until(ExpectedConditions.presenceOfElementLocated(DELETE_MODAL_TITLE));
        return this;
    }

    public boolean isModalOpened() {
        wait.until(ExpectedConditions.presenceOfElementLocated(DELETE_MODAL_TITLE));
        return driver.findElement(DELETE_MODAL_TITLE).getText().contains("Delete");
    }

    @Step("Confirm deletion of an contact")
    public ContactListViewPage delete() {
        if (!isModalOpened()) throw new RuntimeException("Delete modal is not opened");
        driver.findElement(DELETE_MODAL_BUTTON).click();
        return new ContactListViewPage(driver);
    }
}
