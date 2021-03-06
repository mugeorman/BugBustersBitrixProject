package com.automation.bitrix.pages.activityStream;
import com.automation.bitrix.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DateTimeUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class WorkflowTabPage extends AbstractPageBase {


    @FindBy(xpath = "//*[@id=\"bx-lists-popup\"]/span")
    private WebElement closeSymbol;

     @FindBy(xpath = "(//input[@class='bx-lists-input-calendar'])[1]")
    private WebElement startDate;

    @FindBy(xpath = "(//a[@class='bx-calendar-cell bx-calendar-weekend'])[4]")
    private WebElement startDateClick;

    @FindBy(xpath = "(//input[@class='bx-lists-input-calendar'])[2]")
    private WebElement endDate;

    @FindBy(xpath = "(//a[@class='bx-calendar-cell bx-calendar-weekend'])[5]")
    private WebElement endDateClick;

    @FindBy(xpath = "//select[@name='PROPERTY_88']/option")
    private List<WebElement> absenceType;

    @FindBy(xpath = "//select[@name='PROPERTY_88']")
    private WebElement absenceTypeSelect;

    @FindBy(xpath = "//*[@id='bx-lists-div-list-23']/table/tbody/tr[6]/td[2]/textarea")
    private WebElement textArea;

    @FindBy(xpath = "//*[@id='blog-submit-button-save' and contains(text(),'Send')]")
    private WebElement sendBtn;

    @FindBy(className = "bx-lists-table-first-td")
    private WebElement randomClick;

    @FindBy(xpath = "//span[@class='feed-add-post-micro-title']")
    private WebElement approvalTitle;

    @FindBy(id = "bx-lists-block-errors")
    private WebElement errorMessage;



    public void navigateToSubModule(String workflowModule) {
        BrowserUtils.wait(2);
        String subModuleXPath = "//span[@class='menu-popup-item-text' and contains(text(),'" + workflowModule + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(subModuleXPath))).click();
    }

    public void clickCloseSymbol() {
        BrowserUtils.wait(3);
        closeSymbol.click();
    }

    public void enterStartDate(){
        BrowserUtils.wait(2);
        startDate.click();
        BrowserUtils.wait(1);
        startDateClick.click();

        }

    public void enterEndDate() {
        BrowserUtils.wait(2);
        endDate.click();
        BrowserUtils.wait(1);
        endDateClick.click();
    }

    public void chooseAbsenceType() {
        BrowserUtils.wait(3);
        absenceTypeSelect.click();
        Random random = new Random();
        int ran = random.nextInt(absenceType.size());
        absenceType.get(ran).click();
        BrowserUtils.wait(1);
    }

    public void reasonForLeave() {
        BrowserUtils.wait(3);
        textArea.sendKeys("For DEMO meeting in California");
    }

    public void clickSendBtn() {
        BrowserUtils.wait(3);
        wait.until(ExpectedConditions.elementToBeClickable(sendBtn)).click();
    }

    public String approveMessage(){
        BrowserUtils.wait(3);
        return wait.until(ExpectedConditions.visibilityOf(errorMessage)).getText();
    }

}
