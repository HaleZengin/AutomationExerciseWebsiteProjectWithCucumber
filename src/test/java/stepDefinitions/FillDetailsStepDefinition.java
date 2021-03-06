package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.FillDetailsPage;
import utilities.Driver;

public class FillDetailsStepDefinition {

    FillDetailsPage fillDetailsPage = new FillDetailsPage();

    Faker faker = new Faker();

    @Then("kullanici birinci bolum icin Email, Password, Date of birth kisimlarini doldurur")
    public void kullanici_birinci_bolum_icin_email_password_date_of_birth_kisimlarini_doldurur() {
        fillDetailsPage.genderBox.click();
        fillDetailsPage.passwordBox.sendKeys("123456");
        Select select1 = new Select(fillDetailsPage.dayDropdown);
        select1.selectByValue("3");
        Select select2 = new Select(fillDetailsPage.monthDropdown);
        select2.selectByValue("5");
        Select select3 = new Select(fillDetailsPage.yearDropdown);
        select3.selectByValue("1991");

    }
    @Then("kullanici Sign up for our newsletter! checkbox' ini secer")
    public void kullanici_sign_up_for_our_newsletter_checkbox_ini_secer() {
        fillDetailsPage.newsletterSignupBox.click();
    }
    @Then("kullanici Receive special offers from our partners! checkbox' ini secer")
    public void kullanici_receive_special_offers_from_our_partners_checkbox_ini_secer() {
        fillDetailsPage.specialOfferBox.click();
    }
    @Then("kullanici ikinci bolum icin gerekli kisimlari doldurur")
    public void kullanici_ikinci_bolum_icin_gerekli_kisimlari_doldurur() {
        fillDetailsPage.firstNameBox.sendKeys("hale");
        Faker faker = new Faker();
        fillDetailsPage.lastNameBox.sendKeys(faker.name().lastName());
        fillDetailsPage.companyBox.sendKeys(faker.company().name());
        fillDetailsPage.addressBox.sendKeys(faker.address().fullAddress());
        Select select = new Select(fillDetailsPage.countryDropdown);
        select.selectByValue("Canada");
        fillDetailsPage.stateBox.sendKeys(faker.address().state());
        fillDetailsPage.cityBox.sendKeys(faker.address().city());
        fillDetailsPage.zipcodeBox.sendKeys(faker.address().zipCode());
        fillDetailsPage.mobileNumberBox.sendKeys(faker.phoneNumber().phoneNumber());

    }
    @Then("kullnici Creat Account butonuna tiklar")
    public void kullnici_creat_account_butonuna_tiklar() {
        fillDetailsPage.createAccountButton.click();
    }
    @Then("kullanici hesabin olustugunu dogrular")
    public void kullanici_hesabin_olustugunu_dogrular() {
        Assert.assertTrue(fillDetailsPage.accountCreatedText.isDisplayed());
    }

    //US006

    @When("kullanici name, email, subject ve message kisimlarini doldurur")
    public void kullanici_name_email_subject_ve_message_kisimlarini_doldurur() {
        fillDetailsPage.name.sendKeys(faker.name().firstName());
        fillDetailsPage.email.sendKeys(faker.internet().emailAddress());
        fillDetailsPage.subject.sendKeys(faker.funnyName().name());
        fillDetailsPage.message.sendKeys(faker.internet().avatar());
    }
    @Then("kullanici dosyayi yukler")
    public void kullanici_dosyayi_yukler() {

    }
    @Then("kullanici Submit butonuna tiklar")
    public void kullanici_submit_butonuna_tiklar() {
        fillDetailsPage.submit.click();

    }
    @Then("cikan alert te OK tusuna basar")
    public void cikan_alert_te_ok_tusuna_basar() {
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("Success! Your details have been submitted successfully. yazisini gorur")
    public void success_your_details_have_been_submitted_successfully_yazisini_gorur() {
        Assert.assertTrue(fillDetailsPage.successText.isDisplayed());
    }
    @Then("kullanici Home butonuna basar")
    public void kullanici_home_butonuna_basar() {

        fillDetailsPage.home.click();
    }

    @Then("kullanici anasayfaya gittigini test eder")
    public void kullanici_anasayfaya_gittigini_test_eder() {
        Assert.assertEquals("https://www.automationexercise.com/",Driver.getDriver().getTitle() );

    }


    @And("{int} saniye bekler")
    public void saniyeBekler(int saniye) throws InterruptedException {
        Thread.sleep(saniye*1000);
    }








}
