package com.itechart.tests;

import com.itechart.pages.AppLauncherSearchResultPage;
import com.itechart.pages.RecordPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewRecordTest extends BaseTest {

    @Test
    public void createNewRecord() {
        AppLauncherSearchResultPage appLauncherSearchResultPage = homePage.goToTabFromAppLauncher("Apples");
        RecordPage recordPage = appLauncherSearchResultPage.createNewRecord("test", true,
                "test1@test.com", "123", "test1");
        Assert.assertTrue(recordPage.isRecordCreated(), "Record is not created!");
    }
}
