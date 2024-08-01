package Utility_file;

import org.openqa.selenium.WebElement;

public interface Library {
	public void custom_sendkeys(WebElement element, String value, String fieldname);

	public void Custom_click(WebElement element, String fieldname);

	public void VerifyImagePresent(WebElement image, String fieldname);

	public void PageLoaded();

	public void VerifyElementPresent(WebElement ele, String fieldname);

	public void msg(WebElement ele, String filedname);

	public void Message(String message);

}
