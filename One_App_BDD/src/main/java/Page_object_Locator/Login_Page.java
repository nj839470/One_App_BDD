package Page_object_Locator;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import Utility_file.Baseclass;
import io.appium.java_client.android.AndroidDriver;

@Listeners(Utility_file.Listner.class)
public class Login_Page extends Baseclass {

	public Login_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Cancel']")
	private WebElement close;
	@FindBy(id = "com.customerapp.hero:id/text_input_editext")
	private WebElement mobile_No;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_title']")
	private WebElement registerd_message;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/textMessage']")
	private WebElement registerd_message_1;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[1]")
	private WebElement cancel_button;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id='com.customerapp.hero:id/iv_cross']")
	private WebElement cancel_button_r;
	@FindBy(xpath = "//android.widget.Button[@resource-id = 'com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
	private WebElement While_using_the_app;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='com.android.permissioncontroller:id/permission_deny_button']")
	private WebElement deny;
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	private WebElement ok;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement process_require_notification;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='com.android.settings:id/button1']")
	private WebElement open;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='android:id/button1']")
	private WebElement allow;
	@FindBy(xpath = "//android.widget.Button[@resource-id ='com.android.permissioncontroller:id/permission_allow_button']")
	private WebElement Allow;
	@FindBy(id = "com.customerapp.hero:id/cus_orange_button_lay")
	private WebElement continue_button;
	@FindBy(className = "android.widget.EditText")
	private List<WebElement> OTP;
	@FindBy(xpath = "//android.widget.TextView[@text ='Resend']")
	private WebElement resend_button;
	@FindBy(xpath = "//android.widget.TextView[@text = 'Verify']")
	private WebElement verify_button;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/tv_title']")
	private WebElement Wrong_mobile_message;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[1]")
	private WebElement Cancel_pop;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/user_no_lbl']")
	private WebElement registered_mobile_no;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/term_nd_cond_lbl']")
	private WebElement Terms_of_Use;
	@FindBy(xpath = "(//android.view.View[@text])[23]")
	private WebElement Terms_of_Use_condition;
	@FindBy(xpath = "(//android.widget.TextView[@text])[3]")
	private WebElement Terms_of_Use_condition_for_real_device;
	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/pp_lbl']")
	private WebElement Privacy_Policy;
	@FindBy(xpath = "(//android.view.View[@text])[16]")
	private WebElement Privacy_Policy_condition;
	@FindBy(xpath = "(//android.widget.TextView[@text])[5]")
	private WebElement Privacy_of_Use_condition_for_real_device;
	@FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.customerapp.hero:id/contact_us_lbl']")
	private WebElement contact_us;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/fb_text'])[1]")
	private WebElement contact_us_message;
	@FindBy(xpath = "//android.widget.ImageView[@resource-id = 'com.customerapp.hero:id/back_btn']")
	private WebElement back_page;
	@FindBy(id = "com.customerapp.hero:id/edit_phn_no_btn")
	private WebElement edit_moble_button;

	public WebElement close() {
		return close;
	}

	public WebElement While_using_the_app() {
		return While_using_the_app;
	}

	public WebElement open() {
		return open;
	}

	public WebElement registerd_message() {
		return registerd_message;
	}

	public WebElement process_require_notification() {
		return process_require_notification;
	}

	public WebElement registerd_message_1() {
		return registerd_message_1;
	}

	public WebElement Cancel_not_registered() {
		return cancel_button;
	}

	public WebElement cancel_button_r() {
		return cancel_button_r;
	}

	public WebElement ok() {
		return ok;
	}

	public WebElement allow() {
		return allow;
	}

	public WebElement Allow() {
		return Allow;
	}

	public WebElement deny() {
		return deny;
	}

	public WebElement mobile_No() {
		return mobile_No;
	}

	public WebElement Cancel_pop() {
		return Cancel_pop;
	}

	public WebElement continue_button() {
		return continue_button;
	}

	public void enter_Valid_OTP() {
		for (int i = 0; i < OTP.size(); i++) {
			custom_sendkeys(OTP.get(i), "" + (i + 1), "enterOTP =" + (i + 1));
		}
	}

	public void enter_Valid_OTP_prod() {
		custom_sendkeys(OTP.get(0), "" + 2, "enterOTP =" + 2);
		custom_sendkeys(OTP.get(1), "" + 3, "enterOTP =" + 3);
		custom_sendkeys(OTP.get(2), "" + 4, "enterOTP =" + 4);
		custom_sendkeys(OTP.get(3), "" + 6, "enterOTP =" + 6);
		custom_sendkeys(OTP.get(4), "" + 5, "enterOTP =" + 5);
		custom_sendkeys(OTP.get(5), "" + 1, "enterOTP =" + 1);
	}

	public void enter_inavalid_OTP() {
		for (int i = 0, j = 3; i < OTP.size(); i++, j++) {
			custom_sendkeys(OTP.get(i), "" + (j + 1), "OTP is " + (j + 1));
		}
	}

	public WebElement resend_button() {
		return resend_button;
	}

	public WebElement verify_button() {
		return verify_button;
	}

	public WebElement Wrong_mobile_message() {
		return Wrong_mobile_message;
	}

	public WebElement registered_mobile_no() {
		return registered_mobile_no;
	}

	public WebElement Terms_of_Use() {
		return Terms_of_Use;
	}

	public WebElement Terms_of_Use_condition() {
		return Terms_of_Use_condition;
	}

	public WebElement Terms_of_Use_condition_for_real_device() {
		return Terms_of_Use_condition_for_real_device;
	}

	public WebElement Privacy_Policy() {
		return Privacy_Policy;
	}

	public WebElement Privacy_Policy_condition() {
		return Privacy_Policy_condition;
	}

	public WebElement Privacy_of_Use_condition_for_real_device() {
		return Privacy_of_Use_condition_for_real_device;
	}

	public WebElement contact_us_message() {
		return contact_us_message;
	}

	public WebElement contact_us() {
		return contact_us;
	}

	public WebElement back_page() {
		return back_page;
	}

	public WebElement edit_moble_button() {
		return edit_moble_button;
	}

	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[2]")
	private WebElement Continue_as_guest;

	public WebElement Continue_as_guest() {
		return Continue_as_guest;
	}

	@FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.customerapp.hero:id/')]")
	private List<WebElement> guest_page_info;

	public void guest_page_info() {
		for (int i = 1; i < guest_page_info.size(); i++) {
			Message(guest_page_info.get(i).getText());
		}
	}

	@FindBy(xpath = "//android.widget.ImageView[@resource-id ='com.customerapp.hero:id/bannerImg']")
	private WebElement Hero_Product_getNow_btn;

	public WebElement Hero_Product_getNow_btn() {
		return Hero_Product_getNow_btn;
	}

	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/action_lbl'])[1]")
	private WebElement nearby_dealer;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/action_lbl'])[2]")
	private WebElement vehicle_exchange;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/action_lbl'])[3]")
	private WebElement View_Challans;

	public WebElement nearby_dealer() {
		return nearby_dealer;
	}

	public WebElement vehicle_exchange() {
		return vehicle_exchange;
	}

	public WebElement View_Challans() {
		return View_Challans;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/numUpdate1']")
	private WebElement update_mobile_number;

	public WebElement update_mobile_number() {
		return update_mobile_number;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/checkLbl']")
	private WebElement Check_now_btn;

	public WebElement Check_now_btn() {
		return Check_now_btn;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_upload_lbl']")
	private WebElement upload_from_photo_gallery;

	public WebElement upload_from_photo_gallery() {
		return upload_from_photo_gallery;
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Cancel']")
	private WebElement cancel_btn;

	public WebElement cancel_btn() {
		return cancel_btn;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl']")
	private WebElement Contact_Us;

	public WebElement Contact_Us() {
		return Contact_Us;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl']")
	private WebElement login_page;

	public WebElement login_page() {
		return login_page;
	}

	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[1]")
	private WebElement update_number;
	@FindBy(xpath = "(//android.widget.TextView[@resource-id ='com.customerapp.hero:id/btn_lbl'])[2]")
	private WebElement Continue_guest_btn;

	public WebElement update_number() {
		return update_number;
	}

	public WebElement Continue_guest_btn() {
		return Continue_guest_btn;
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id ='com.customerapp.hero:id/lbl']")
	private List<WebElement> details_verify;

	public void details_verify() {
		for (int i = 0; i < details_verify.size(); i++) {
			Message(details_verify.get(i).getText());
		}
	}

}
