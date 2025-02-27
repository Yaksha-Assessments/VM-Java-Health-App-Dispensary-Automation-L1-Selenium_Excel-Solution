package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class dispensary_Pages extends StartupPage {

//	TC1-Locators
	By usernameTextbox = By.xpath("//input[@id='username_id']");
	By passwordTextbox = By.xpath("//input[@id='password']");
	By signInButton = By.xpath("//button[@id='login']");
	By registeredPatientTextElement = By.xpath("//p[contains(text(), 'Registered Patient')]");
//	TC2-Locators
	By dispensaryModule = By.xpath("//span[.='Dispensary']");
//	TC3-Locators
	By dispensaryToggle = By.xpath("//span[@data-target='#Dispensary']");	
	By PrescriptionSubModule = By.xpath("//span[.='Prescription']");
	By saleSubModule = By.xpath("//span[.='Sale']");
	By stockSubModule = By.xpath("//span[.='Stock']");
	By counterSubModule = By.xpath("//span[.='Counter']");
	By reportsSubModule = By.xpath("//span[.='Reports']");
	By patientConsumptionSubModule = By.xpath("//span[.='Patient Consumption']");
//	TC4-Locators
	By morningCounter = By.xpath("(//div[@class='counter-item'])[1]");
	By creditLimitsAndBalancesTextElement = By.xpath("//b[contains(text() , 'Credit Limits and Balances')]");
	By printInvoiceButtonElement = By.xpath("//input[@value='Print Invoice']");
	By discardButtonElement = By.xpath("//button[contains(text() , 'Discard')]");
	By invoiceHistoryTextElement = By.xpath("//b[contains(text() , 'Invoice History')]");
//	TC5-Locators
	By addNewPatientPopup = By.xpath("//div[@class='modelbox-body p2']");	
	By addNewPatientPageTitle = By.xpath("//span[.='Add New Patient']");
//	TC6-Locators
	By addNewPatientFormOkButton = By.xpath("//button[.=' OK']");
	By errorMeesageInFirstNameTextField = By.xpath("//span[.=' First Name is required.']");
//	TC7-Locators
	By firstNameTextFieldInAddNewPatient = By.id("newPatFirstName");
	By middleNameTextFieldInAddNewPatient = By.id("newPatMiddleName");
	By lastNameTextFieldInAddNewPatient = By.id("newPatLastName");
	By ageTextFieldInAddNewPatient = By.id("Age");
	By contactNumberTextFieldInAddNewPatient = By.id("Contact");
//	TC8-Locators
	By xButton = By.xpath("//button[.='X']");
	By patientConsumptionTab = By.xpath("//a[.=' Patient Consumption ']");	
	By newConsumptionButton = By.xpath("//button[@class='btn green btn-success']");
	By saveConsumptionButton = By.id("btn-save");
	By newConsumptionEntryFormConfirmMessage = By.xpath("//p[.='Are you sure you want to Proceed ?']");
	
	String pageName = this.getClass().getSimpleName();
	public dispensary_Pages(WebDriver driver) {
		super(driver);
	}

	/**@Test1.1
	 * about this method loginTohealthAppByGivenValidCredetial() 
	 * @param : Map<String, String>
	 * @description : fill usernameTextbox & passwordTextbox and click on sign in button
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public boolean loginToHealthAppByGivenValidCredetial(Map<String, String> expectedData) throws Exception {
		Boolean textIsDisplayed = false;
		try {
			WebElement usernametextFieldWebElement = commonEvents.findElement(usernameTextbox);
			commonEvents.highlightElement(usernametextFieldWebElement);
			commonEvents.sendKeys(usernameTextbox,expectedData.get("username"));

			WebElement passwordtextFieldWebElement = commonEvents.findElement(passwordTextbox);
			commonEvents.highlightElement(passwordtextFieldWebElement);
			commonEvents.sendKeys(passwordTextbox,expectedData.get("password"));

			WebElement signinButtonWebElement = commonEvents.findElement(signInButton);
			commonEvents.highlightElement(signinButtonWebElement);
			commonEvents.click(signInButton);

			if(commonEvents.isDisplayed(registeredPatientTextElement))
			{   
				WebElement registeredPatientTextWebElement = commonEvents.findElement(registeredPatientTextElement);
				commonEvents.highlightElement(registeredPatientTextWebElement);
				textIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}
		return textIsDisplayed;
	}

	/**@Test1.2
	 * about this method verifyTitleOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the title of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyTitleOfThePage() throws Exception {
		String pageTitle = "";
		try {
			pageTitle = commonEvents.getTitle();
			System.out.println("title of the page is  :" + pageTitle );
		}catch(Exception e) {
			throw e;
		}	
		return pageTitle;
	}

	/**@Test1.3
	 * about this method verifyURLOfThePage() 
	 * @param : null
	 * @description : it will navigate to the URL and validate the URL of the current page.
	 * @return : String
	 * @author : Yaksha
	 */
	public String verifyURLOfThePage() throws Exception {
		String urlofThepage = "";
		try {
			urlofThepage = commonEvents.getCurrentUrl();
			System.out.println("URL of the page is  :" + urlofThepage );
		}catch(Exception e) {
			throw e;
		}	
		return urlofThepage;
	}


	/**@Test2
	 * about this method verifyDispensaryModuleIsPresentOrNot() 
	 * @param : null
	 * @description : vverify the Dispensary module is present or not
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyDispensaryModuleIsPresentOrNot() throws Exception {
		boolean dispensaryModuleIsDisplayed = false;
		try {
			commonEvents.isDisplayed(dispensaryModule);
			dispensaryModuleIsDisplayed=true;
		}catch(Exception e) {
			throw e;
		}	
		return dispensaryModuleIsDisplayed;
	}

	/**@Test3
	 * about this method verifyAllSubModulesArePresentAndClickOnDispensary() 
	 * @param : null
	 * @description : verify all sub-modules are displayed correctly after clicking on the expand icon of  "Dispensary" Module.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean verifyAllSubModulesArePresentAndClickOnDispensary() throws Exception {
		boolean patientConsumptionSubModuleisDisplayed = false;
		try {
			if(commonEvents.isDisplayed(dispensaryModule)){
				commonEvents.jsClick(dispensaryToggle);
				commonEvents.isDisplayed(PrescriptionSubModule);				
				commonEvents.isDisplayed(saleSubModule);
				commonEvents.isDisplayed(stockSubModule);
				commonEvents.isDisplayed(counterSubModule);
				commonEvents.isDisplayed(reportsSubModule);
				commonEvents.isDisplayed(patientConsumptionSubModule);
				commonEvents.click(dispensaryModule);
				patientConsumptionSubModuleisDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return patientConsumptionSubModuleisDisplayed;
	}


	/**@Test4
	 * about this method scrollToButtomAndVerifytheFields() 
	 * @param : null
	 * @description :scroll to the bottom of the "Sale" page and verify that "Print Invoice" button  , "Discard" button  ,"Invoice History" and  "Credit Limitis and Balance" text are peresent or not?
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public Boolean scrollToButtomAndVerifytheFields() throws Exception {
		boolean creditLimitsAndBalancesTextElementIsDisplayed = false;
		try {
			commonEvents.click(morningCounter);
			Thread.sleep(3000);
			WebElement creditLimitsAndBalancesTextElementWebElement=commonEvents.findElement(creditLimitsAndBalancesTextElement);
			commonEvents.scrollIntoView(creditLimitsAndBalancesTextElementWebElement);
			Thread.sleep(3000);
			if(commonEvents.isDisplayed(printInvoiceButtonElement) &&
					commonEvents.isDisplayed(discardButtonElement) &&
					commonEvents.isDisplayed(invoiceHistoryTextElement) &&
					commonEvents.isDisplayed(creditLimitsAndBalancesTextElement) ) {
				creditLimitsAndBalancesTextElementIsDisplayed=true;
			}
		}catch(Exception e) {
			throw e;
		}	
		return creditLimitsAndBalancesTextElementIsDisplayed;
	}



	/**@Test5
	 * about this method performTheKeyboardOperationToOpenthePopup() 
	 * @param : null
	 * @description :Perform the keyboard operation to open the "Add New Patient" popup Page  and verify that the popup is displayed or not.
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public String performTheKeyboardOperationToOpenthePopup() throws Exception {
		String pageName = "";
		try {
			commonEvents.performAltN();
			commonEvents.isDisplayed(addNewPatientPopup);
			pageName=commonEvents.getText(addNewPatientPageTitle);
			System.out.println("Add New Patient page title is :" + pageName);
		}catch(Exception e) {
			throw e;
		}	
		return pageName;
	}


	/**@Test6
	 * about this method validateErrorMessageInFirstnameTextfield() 
	 * @param : null
	 * @description : Validate the error message in "Add New Patient" form's  firstname textfield after clicking on "Ok" Button without filling any information in the form
	 * @return : String
	 * @author : Yaksha
	 */
	public String validateErrorMessageInFirstnameTextfield() throws Exception {
		String errorMessageText = "";
		try {
			if(commonEvents.isDisplayed(addNewPatientFormOkButton)) {
				commonEvents.click(addNewPatientFormOkButton);
				Thread.sleep(5000);
				errorMessageText = commonEvents.getText(errorMeesageInFirstNameTextField);
				System.out.println("Error Meesage is  :" + errorMessageText );
				return errorMessageText;	
			}
		}catch(Exception e) {
			throw e;
		}	
		return errorMessageText;
	}

	/**@Test7.1
	 * about this method fillfirstNameTextFieldVerifyTheFirstName() 
	 * @param : Map<String, String>
	 * @description : fill First Name TextField and Verify First name
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillfirstNameTextFieldVerifyTheFirstName(Map<String, String> expectedData) throws Exception {
		String firstNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(firstNameTextFieldInAddNewPatient))
			{
				commonEvents.click(firstNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(firstNameTextFieldInAddNewPatient,expectedData.get("firstName"));

				firstNameTextfieldValue = commonEvents.getAttribute(firstNameTextFieldInAddNewPatient, "value");
				System.out.println("FirstName : " + firstNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return firstNameTextfieldValue;
	}

	/**@Test7.2
	 * about this method fillmiddelNameTextFieldVerifyThemiddleName() 
	 * @param : Map<String, String>
	 * @description : fill Middle Name TextField and Verify middle name
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillmiddelNameTextFieldVerifyThemiddleName(Map<String, String> expectedData) throws Exception {
		String middleNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(middleNameTextFieldInAddNewPatient))
			{

				commonEvents.click(middleNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(middleNameTextFieldInAddNewPatient,expectedData.get("middleName"));

				middleNameTextfieldValue = commonEvents.getAttribute(middleNameTextFieldInAddNewPatient, "value");
				System.out.println("Middle name : " + middleNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return middleNameTextfieldValue;
	}

	/**@Test7.3
	 * about this method filllastNameTextfieldVerifylastName() 
	 * @param : Map<String, String>
	 * @description : fill Last Name TextField and Verify Last name
	 * @return : String
	 * @author : Yaksha
	 */
	public String filllastNameTextfieldVerifylastName(Map<String, String> expectedData) throws Exception {
		String lastNameTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(lastNameTextFieldInAddNewPatient))
			{

				commonEvents.click(lastNameTextFieldInAddNewPatient);
				commonEvents.sendKeys(lastNameTextFieldInAddNewPatient,expectedData.get("lastName"));

				lastNameTextfieldValue = commonEvents.getAttribute(lastNameTextFieldInAddNewPatient, "value");
				System.out.println("Last name : " + lastNameTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return lastNameTextfieldValue;
	}

	/**@Test7.4
	 * about this method fillAgeTextFieldVerifyTheAge() 
	 * @param : Map<String, String>
	 * @description : fill age and Verify the age.
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillAgeTextFieldVerifyTheAge(Map<String, String> expectedData) throws Exception {
		String ageTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(ageTextFieldInAddNewPatient))
			{

				commonEvents.click(ageTextFieldInAddNewPatient);
				commonEvents.sendKeys(ageTextFieldInAddNewPatient,expectedData.get("age"));

				ageTextfieldValue = commonEvents.getAttribute(ageTextFieldInAddNewPatient, "value");
				System.out.println("Age is : " + ageTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return ageTextfieldValue;
	}



	/**@Test7.5
	 * about this method fillContactNumberTextFieldVerifyContactNumber() 
	 * @param : Map<String, String>
	 * @description : fill Contact Number TextField and Verify Contact Number
	 * @return : String
	 * @author : Yaksha
	 */
	public String fillContactNumberTextFieldVerifyContactNumber(Map<String, String> expectedData) throws Exception {
		String contactNumberTextfieldValue= "";
		try {
			if(commonEvents.isDisplayed(contactNumberTextFieldInAddNewPatient))
			{

				commonEvents.click(contactNumberTextFieldInAddNewPatient);
				commonEvents.sendKeys(contactNumberTextFieldInAddNewPatient,expectedData.get("contact"));

				contactNumberTextfieldValue = commonEvents.getAttribute(contactNumberTextFieldInAddNewPatient, "value");
				System.out.println("Contact Number is : " + contactNumberTextfieldValue);

			}
		}catch(Exception e) {
			throw e;
		}
		return contactNumberTextfieldValue;
	}	

	/**@Test8
	 * about this method validateTheConfirmMessageOnTheNewConsumptionEntryPage() 
	 * @param : null
	 * @description : On the "New Consumption Entry's page, validate the confirm! Message that is "Are you sure you want to Proceed ?"
	 * @return : Boolean
	 * @author : Yaksha
	 */
	public String validateTheConfirmMessageOnTheNewConsumptionEntryPage() throws Exception {
		String confirmMessageText = "";
		try {
			commonEvents.click(xButton);
			commonEvents.click(patientConsumptionTab);
			commonEvents.click(newConsumptionButton);
			commonEvents.click(saveConsumptionButton);
			confirmMessageText=commonEvents.getText(newConsumptionEntryFormConfirmMessage);
			System.out.println("Confirmation message is :" +confirmMessageText);
		}catch(Exception e) {
			throw e;
		}	
		return confirmMessageText;
	}

}