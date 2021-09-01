package com.itechart.tests.api;

import com.itechart.tests.adapters.AccountAdapter;
import com.itechart.tests.adapters.ContactAdapter;
import com.itechart.tests.adapters.LeadAdapter;
import com.itechart.tests.configurations.TestListener;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Log4j2
@Listeners(TestListener.class)
public class BaseApiTest {
    protected WebDriver driver;
    protected AccountAdapter accountAdapter = new AccountAdapter();
    protected ContactAdapter contactAdapter = new ContactAdapter();
    protected LeadAdapter leadAdapter = new LeadAdapter();
}
