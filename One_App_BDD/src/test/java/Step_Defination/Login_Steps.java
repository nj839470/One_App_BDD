package Step_Defination;

import java.net.MalformedURLException;
import org.testng.annotations.Listeners;

import Page_object_Locator.Login_Page;
import Utility_file.Baseclass;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@Listeners(Utility_file.Listner.class)
public class Login_Steps extends Baseclass {
	public Login_Page ob;

	@Given("Should be install and open the app")
	public void should_be_install_and_open_the_app() throws MalformedURLException {
		driver = OPEN_AND_INSTALL_APP();
		ob = new Login_Page(driver);

		Message("Installing the app");
	}

	@Given("Give allow all rquire access")
	public void give_allow_all_rquire_access() {
		Custom_click(ob.ok(), "OK");
		Custom_click(ob.process_require_notification(), "Process button require notification access");
		Custom_click(ob.Allow(), ob.Allow().getText() + "Allow Hero App to send you notifications");

	}

	@When("Enter unregisterd mobile number")
	public void enter_unregisterd_mobile_number() {
		custom_sendkeys(ob.mobile_No(), config_getdata("invalidmobileno"), "Login with unregisterd mobile number");
		driver.navigate().back();
	}

	@When("Coninue button tap after unregistered mobile number")
	public void coninue_button_tap_after_unregistered_mobile_number() {

		Custom_click(ob.continue_button(), "Coninue button enter after unregistered mobile number");
	}

	@Then("Registerd info pop should be come")
	public void registerd_info_pop_should_be_come() {

		msg(ob.registerd_message(), "Registerd info =");
		msg(ob.registerd_message_1(), "Registerd info =");
	}

	@Then("Close pop message")
	public void close_pop_message() {
		Custom_click(ob.cancel_button_r(), "Close not registered pop message");
	}

	@When("Tap Coninue button enter after unregistered mobile number")
	public void Tap_Coninue_button_enter_after_unregistered_mobile_number() throws InterruptedException {
		Custom_click(ob.continue_button(), "Coninue button enter after unregistered mobile number");
		Thread.sleep(3000);
	}

	@When("Tap Update number button")
	public void Tap_Update_number_button() {
		Custom_click(ob.update_number(), "Update number button");
	}

	@Then("Verify all detail given on this page")
	public void Verify_all_detail_given_on_this_page() {
		ob.details_verify();
	}

	@Then("Tap on Back from details verify")
	public void Tap_on_Back_from_details_verify() {
		Custom_click(ob.back_page(), "Back from details verify ");
		Custom_click(ob.continue_button(), "Coninue button enter after unregistered mobile number");
	}

	@Then("Tap Continue as gest button")
	public void Tap_Continue_as_gest_button() throws InterruptedException {
		Thread.sleep(2000);
		Custom_click(ob.Continue_guest_btn(), "Continue as gest button");
	}

	@Then("Tap Back from Welcome! page")
	public void Tap_Back_from_Welcome_page() {
		Custom_click(ob.back_page(), "Back from Welcome! page ");
	}
}
