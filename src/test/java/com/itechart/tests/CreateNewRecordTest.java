package com.itechart.tests;

import com.itechart.pages.AppLauncherSearchResultPage;
import com.itechart.pages.RecordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewRecordTest extends BaseTest {

    @Test
    public void createNewRecord() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        appLauncherSearchResultPage.clickNewButton();
        appLauncherSearchResultPage.enterDataInNewRecordModalFields("testNewRecord", true,
                "test1@test.com", "123", "test1");
        RecordPage recordPage = appLauncherSearchResultPage.clickSaveButton();
        Assert.assertTrue(recordPage.isRecordCreated(), "Record is not created!");
    }

    @Test
    public void createNewRecordThroughSaveAndNewButton() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        appLauncherSearchResultPage.clickNewButton();
        appLauncherSearchResultPage.enterDataInNewRecordModalFields("testNewRecordThroughSaveAndNewButton",
                true, "test1@test.com", "123", "test1");
        RecordPage recordPage = appLauncherSearchResultPage.clickSaveAndNewButton();
        Assert.assertTrue(recordPage.isRecordCreated(), "Record is not created!");
        Assert.assertTrue(appLauncherSearchResultPage.isNewRecordModalOpened(),
                "New Record Modal is opened");
    }

    @Test
    public void createNewRecordWithRequiredFieldsEmpty() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        appLauncherSearchResultPage.clickNewButton();
        RecordPage recordPage = appLauncherSearchResultPage.clickSaveButton();
        Assert.assertTrue(appLauncherSearchResultPage.isEmptyRequiredFieldsValidationError(),
                "Validation Message is not displayed");
    }

    @Test
    public void cancelCreatingOFNewRecord() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        appLauncherSearchResultPage.clickNewButton();
        appLauncherSearchResultPage.clickCancelButton();
        Assert.assertFalse(appLauncherSearchResultPage.isNewRecordModalOpened(),
                "New Record Modal is opened");
    }

    @Test
    public void cancelCreatingOFNewRecordThroughCrossButton() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        appLauncherSearchResultPage.clickNewButton();
        appLauncherSearchResultPage.clickCrossButton();
        Assert.assertFalse(appLauncherSearchResultPage.isNewRecordModalOpened(),
                "New Record Modal is opened");
    }
}
