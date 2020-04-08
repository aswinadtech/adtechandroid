package twc.Automation.General;

import io.appium.java_client.MobileElement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.appium.java_client.TouchAction;
import junit.framework.ComparisonFailure;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import twc.Automation.HandleWithCharles.CharlesFunctions;
import twc.Automation.Driver.Drivers;
import twc.Automation.ReadDataFromFile.read_excel_data;
import twc.Automation.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Automation.RetryAnalyzer.RetryAnalyzer;


public class Functions extends Drivers{
	static int startY;
	static int endY;
	public static String AdzoneValue=null;
	public static String AdzoneValueVideo=null;
	public static String Validation="Ad_iu";
	public static SoftAssert softAssert = new SoftAssert();
	//Verify Animated Branded Background ad presented //naresh
	public static void Verify_Animated_BB() throws Exception{
		Thread.sleep(2000);
		try{
			if(Ad.findElementById("com.weather.Weather:id/background_ad_clickable").isDisplayed()){
				System.out.println("Animated BB ad present");
			}
		}catch(Exception e){
			System.out.println("Animated BB ad not presented");
			Assert.fail("Animated BB ad not presented");
		}
	}


	//Verify Saved addresslist  and select one Address   //by naresh
	public static void verifySavedAddressList_SelectOne(String AddressName) throws Exception{

		logStep("Select Locations From Location Manager ");
		logStep("Tap On Manage Location");
		logStep("Choose Locations Examples: 1) NewYork 2) Atlanta 3) Chicago");

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		/* --- Start For Android Device --- */
		if(Cap == 2){
			String[][] addressdata = read_excel_data.exceldataread("AddressPage");

			WebDriverWait wait4 = new WebDriverWait(Ad, 10);
			wait4.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));

			//Root Location Element
			Ad.findElementById(addressdata[4][Cap]).click();

			WebDriverWait wait5 = new WebDriverWait(Ad, 20);
			wait5.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[6][Cap])));

			//List Location Element
			@SuppressWarnings("unchecked")
			List<MobileElement> loclist = Ad.findElements(By.id(addressdata[6][Cap]));

			int loc_size = loclist.size() -1;

			String loc_length = Integer.toString(loc_size);

			System.out.println("Total Saved Address List :::::" + loc_length);

			Thread.sleep(2000);

			System.out.println("Start Select Address List");

			String firsteleXpath = addressdata[5][Cap];
			String[] parts = firsteleXpath.split("Count");
			/* --- Start For Loop For Location Click --- */
			int addcount = 1;
			for(int i=2;i<= loclist.size();i++){

				String element = null;


				try {

					element = parts[0]+i+parts[1];


					MobileElement ele = (MobileElement) Ad.findElementByXPath(element);
					Thread.sleep(2000);
					System.out.println("For This Location ====>"+ele.getText());
					if(ele.getText().contains((AddressName))){

						WebDriverWait wait9 = new WebDriverWait(Ad, 20);
						wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

						Ad.findElementByXPath(element).click();

						//						WebDriverWait wait10 = new WebDriverWait(Ad, 20);
						//						wait10.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));
						//						
						//						Ad.findElementById(addressdata[4][Cap]).click();
						addcount=i;
						break;
					}else{
						System.out.println("Verifying wanted address in the list :-"+ i );
					}
				} catch (Exception e) {
					logStep("Locations Are Not Found From Location List");
					System.out.println(element+" is not found in the location list");
				}
			}/* --- End For Loop For Location Click --- */

			Thread.sleep(8000);
			//				
			//				WebDriverWait wait12 = new WebDriverWait(Ad, 10);
			//				wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parts[0]+addcount+parts[1])));
			//				
			//				Ad.findElementByXPath(parts[0]+addcount+parts[1]).click();
		}/* --- End For Android Device --- */
		System.out.println("End Select Address List");
	}


	public static void validate_API_Call_With_PubAds_Call(String excel_sheet_name) throws Exception{

		String apicall_results=null;
		String pubadscall_results=null;

		Map<String, String> api_call_results = read_API_Call_Data(excel_sheet_name);
		Map<String, String> pubads_call_results = read_Pub_Ad_Call_Data(excel_sheet_name);
		//System.out.println(api_call_results);
		//System.out.println(pubads_call_results);
		if(api_call_results.keySet().size() == 1){

			logStep("Verify Lotame Call Should Be Made With http://ad.crwdcntrl.net");

			for (String key : api_call_results.keySet()) {
				//System.out.println("key: " + key + " value: " + api_call_results.get(key));
				apicall_results = api_call_results.get(key).toString().replace("[", "").replace("]", "");
				//System.out.println(apicall_results);
			}
			for (String pubkey : pubads_call_results.keySet()) {
				//System.out.println("key: " + pubkey + " value: " + pubads_call_results.get(pubkey));
				pubadscall_results = pubads_call_results.get(pubkey).toString().replace("[", "").replace("]", "");
				//System.out.println(pubadscall_results);
			}

			logStep("Verify Every PubAd Call SG Keyword Values Should Match With ID Values From Lotame API Response");
			logStep("SG Keyword values Are Matched With Lotame API Response");
			String[] pubadsresults = pubadscall_results.split(",");
			for(int i=0;i<pubadsresults.length;i++){
				if(apicall_results.contains(pubadsresults[i])){
					System.out.println("Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
				else{
					logStep("SG Keyword values Are Not Matched With Lotame API Response");
					System.out.println("Does Not Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
			}

		}
		else{
			logStep("Verify Factual API Call Should Made With Url https://location.wfxtriggers.com");
			logStep("Verify Every PubAd Call FAUD Keyword Values Should Match With Group Values From Factual API Response");
			logStep("Verify Every PubAd Call FGEO Keyword Values Should Match With Index Values From Factual API Response");
			logStep("Faud And Fgeo Keyword Values Are Matched With Factual API Response");
			for (String key : api_call_results.keySet()) {
				//System.out.println("key: " + key + " value: " + api_call_results.get(key));
				apicall_results = api_call_results.get(key).toString().replace("[", "").replace("]", "");
				//ystem.out.println(apicall_results);
			}
			for (String pubkey : pubads_call_results.keySet()) {
				//System.out.println("key: " + pubkey + " value: " + pubads_call_results.get(pubkey));
				pubadscall_results = pubads_call_results.get(pubkey).toString().replace("[", "").replace("]", "");
				//System.out.println(pubadscall_results);

				String[] pubadsresults = pubadscall_results.split(",");
				//////////////////////////////////////////

				for(int i=0;i<pubadsresults.length;i++){
					if(!pubads_call_results.get(pubkey).equals("nl")){
						if(api_call_results.get(pubkey).contains(pubadsresults[i])){
							System.out.println("Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
						}
						else{
							System.out.println("Does Not Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
							Assert.fail("Does Not Matched With "+ pubads_call_results.get(pubkey) +" :::: " + pubadsresults[i]);
						}
					}
					else{
						logStep("Getting nl Value For "+pubkey+" From PubAd Call");
						System.out.println("Getting nl value for "+pubkey+" from pubads call");
					}
				}
			}
		}
	}

	public static void validate_Wfxtg_Value_With_Pubads_Call(String excel_sheet_name) throws Exception{

		logStep("Every PubAd Call WFXTG Keyword Values Should  Matche With WeatherFx API Call Response");

		String apicall_results=null;
		String pubadscall_results=null;
		Thread.sleep(4000);
		//Map<String, String> api_call_results = 
		Map<String, String> wfxtg_val = get_Wfxtg_values(excel_sheet_name);
		Map<String, String> pubads_call_results = read_Pub_Ad_Call_Data(excel_sheet_name);
		pubadscall_results = pubads_call_results.get("wfxtg");
		apicall_results = wfxtg_val.get("current").toString().replace("[", "").replace("]", "");
		System.out.println("Wfxtgcall_results"+apicall_results);
		System.out.println("pubadscall_results"+pubadscall_results);
		if(apicall_results.contains(pubadscall_results)){
			System.out.println("Matched With "+ pubadscall_results +" :::: " + apicall_results);
			logStep("WFXTG Keyword Values Matched");

		}
		else{
			logStep("WFXTG Keyword Values Not Matched");
			System.out.println("Does Not Matched With "+ pubadscall_results +" :::: " + apicall_results);
			Assert.fail("Does Not Matched With "+ pubadscall_results +" :::: " + apicall_results);
		}
	}
	public static Map<String , String>  read_API_Call_Data(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_map_results = new HashMap<String, String>();
		ArrayList<String> expected_Values_List = new ArrayList<String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[11][Cap];
		String[] validate_Values = validateValues.split(",");


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap]));
			String expectedValues = expected_data.toString();

			if(validate_Values.length == 1){

				if(expected_data.toString().contains(exceldata[11][Cap])){

					String expecteddata = expected_data.substring(expected_data.indexOf("[")+1,expected_data.indexOf("]")-1);
					System.out.println("Expected Data ::"+expecteddata);

					String[] expecteddata_into_arrays = expecteddata.split("},");
					String[] expectedValue = null;
					for(String dataKeys:expecteddata_into_arrays)
					{

						expectedValue =dataKeys.split(",");

						for(String ExpectedValuesKey:expectedValue)
						{
							if(ExpectedValuesKey.contains(exceldata[12][Cap]))
							{
								String replaceWith = ExpectedValuesKey.toString().replace("{", "").trim();

								String[] contentkey = replaceWith.toString().split(",");
								String expected_key = contentkey[0].replaceAll("^\"|\"$","");
								String[] contentvalue = expected_key.split(":");
								String expected_results =contentvalue[1].replaceFirst("^\"|\"$","");
								expected_Values_List.add(expected_results);
								if(expected_key.contains(""))
								{
									Assert.assertNotNull(expected_key);
								}
							}
						}
					}
				}
				expected_map_results.put(exceldata[12][Cap], expected_Values_List.toString());
			}
			else{

				String validateSecondValues = exceldata[12][Cap];
				String[] validate_Second_Values = validateSecondValues.split(",");
				List<String> fgeo_res = new ArrayList<String>();
				List<String> faud_res = new ArrayList<String>();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(expectedValues);
				JSONObject jsonObject = (JSONObject) obj;

				JSONArray fgeoval = (JSONArray) jsonObject.get(validate_Values[0]);
				for(int i=0;i< fgeoval.size();i++){

					JSONObject filter = (JSONObject) fgeoval.get(i);
					if(filter.containsKey(validate_Second_Values[0])){
						fgeo_res.add(filter.get(validate_Second_Values[0]).toString());
					}
				}

				JSONArray faudval = (JSONArray) jsonObject.get(validate_Values[1]);
				for(int i=0;i< faudval.size();i++){

					JSONObject filter = (JSONObject) faudval.get(i);
					if(filter.containsKey(validate_Second_Values[1])){
						faud_res.add(filter.get(validate_Second_Values[1]).toString());
					}
				}

				expected_map_results.put("fgeo", fgeo_res.toString());
				expected_map_results.put("faud", faud_res.toString());
			}
		} catch (Exception e) {
			System.out.println(exceldata[1][Cap] +" Call Not Generated");
			Assert.fail(exceldata[1][Cap] +" Call Not Generated");
		}

		return expected_map_results;
	}

	public static Map<String , String> read_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));

		required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
		required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");

		required_info = required_info.substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));


		String pubad_cust_params_data = required_info.toString();

		String[] pubadvalue = pubad_cust_params_data.split(exceldata[13][Cap]);

		for(String pubadkey:pubadvalue){

			String[] key = pubadkey.split("=");

			for(int i=0;i<validate_Values.length;i++){	

				if(key[0].equals(validate_Values[i])){
					expected_results.put(validate_Values[i], key[1].toString());
				}
			}
		}
		return expected_results;
	}

	public static void clean_App_Launch(String excel_sheet_name) throws Exception{

		logStep("Scroll Down To End Of The App And Verifying That Up To Feed_5 Ad Calls Made");

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();


		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String feedVal=exceldata[3][Cap].toString().trim();

		System.out.println("Feeds Val are :"+feedVal.trim());

		int feedcount=Integer.parseInt(feedVal);

		List<String> pubads_not_match = new ArrayList<String>();

		boolean isExceptionOccered = false;

		for(int Feed=0;Feed<=feedcount;Feed++){

			String pubadcal;

			if(Feed==0){

				try {
					pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[1][Cap]));
					if(pubadcal.toString().contains(exceldata[1][Cap])){
						System.out.println("BB Ad Call Generated");
					}
				} catch (Exception e) {
					pubads_not_match.add(Integer.toString(Feed));
					isExceptionOccered=true;
				}
			}
			else
			{
				String feedcall = exceldata[2][Cap]+Feed;
				try {
					pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]+Feed));
					if(pubadcal.toString().contains(feedcall)){
						System.out.println("Feed_"+Feed +" Ad Call Generated");
					}
				} catch (Exception e) {
					pubads_not_match.add(Integer.toString(Feed));
					isExceptionOccered=true;
				}
			}
		}
		for(int Feed=0;Feed<=feedcount;Feed++){
			if(isExceptionOccered){
				logStep("Feed_"+pubads_not_match + " Ad Call Not Generated");
				Assert.fail("Feed_"+pubads_not_match + " Ad Call Not Generated");
			}
		}


	}

	public static void bb_call_validation(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[17][Cap]));

			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
			String expectedValues = expected_data.toString();

			//System.out.println("BB Call Value is : "+expectedValues);

			if(excel_sheet_name.equalsIgnoreCase("PreRollVideo"))
			{
				if(expectedValues.contains(exceldata[17][Cap])){
					logStep("Video Ad Call Generated");
					System.out.println("Video ad call Value is : "+expectedValues);
					System.out.println("Video ad call generated");
					RetryAnalyzer.count=0;
				}

			}
			else if(excel_sheet_name.equalsIgnoreCase("Pulltorefresh"))
			{
				if(expectedValues.contains(exceldata[14][Cap])){
					logStep("BB Ad Call Generated");
					System.out.println("BB Call Value is : "+expectedValues);
					System.out.println("BB Call generated");
					System.out.println("pull to refresh passed");
					RetryAnalyzer.count=0;
				}

			}
			else if(excel_sheet_name.equalsIgnoreCase("TestMode")){
				if(expectedValues.contains(exceldata[17][Cap])){
					logStep("BB Call Generated Successfully");
					System.out.println("BB Call Value is : "+expectedValues);
					System.out.println("BB Call generated");
					RetryAnalyzer.count=0;
				}
			}
		}catch (Exception e) {
			logStep("Ad call should be genrated");
			System.out.println(" Call not generated");
			Assert.fail(" Call not generated. ");

		}
	}

	//	@SuppressWarnings("unchecked")
	//	public static void beacons_validation(String excel_sheet_name) throws Exception{
	//		
	//		logStep("Verify BB Ad Presented On Home page ");
	//		if(excel_sheet_name.contains("ThirdpartyBecon")){
	//			logStep("Verify BB Ad Call Response Should Contains The Urls 1) CreativeId 2) ThirdPartyBeacon 3) ThirdPartySurvey ");
	//		}
	//		else{
	//			logStep("Verify BB Ad Call Response Should Contains The Urls 1) CreativeId 2) Video URL 3) FourthPartyBeacon ");
	//		}
	//		DeviceStatus device_status = new DeviceStatus();
	//		int Cap = device_status.Device_Status();
	//		
	//		Thread.sleep(4000);
	//		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
	//		
	//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//		
	//		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
	//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][Cap]));
	//		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][Cap]),required_info.indexOf(exceldata[3][Cap]));
	//		String expectedValues = expected_data.toString();
	//		
	//		@SuppressWarnings("rawtypes")
	//		Map map = new HashMap();
	//		String[] keypairs = expectedValues.split(exceldata[4][Cap]);
	//		try {
	//			for (String keyvalue : keypairs)
	//			{
	//			    String[] key_value = keyvalue.split(exceldata[5][Cap],2);
	//			    map.put(key_value[0], key_value[1]);
	//			}
	//			
	//			if(!empty(map.get(exceldata[6][Cap])) && !empty(map.get(exceldata[7][Cap])) && !empty(map.get(exceldata[8][Cap]))){
	//				
	//				logStep("After Getting BB Ad Call,Verified ThirdPartyBeacon Values From BB Ad Call Response");
	//				logStep(exceldata[6][Cap]+" Value Is "+map.get(exceldata[6][Cap]));
	//				logStep(exceldata[7][Cap]+" Value Is "+map.get(exceldata[7][Cap]));
	//				logStep(exceldata[8][Cap]+" Value Is "+map.get(exceldata[8][Cap]));
	//				
	//				System.out.println(exceldata[6][Cap]+" Value is "+map.get(exceldata[6][Cap]));
	//				System.out.println(exceldata[7][Cap]+" Value is "+map.get(exceldata[7][Cap]));
	//				System.out.println(exceldata[8][Cap]+" Value is "+map.get(exceldata[8][Cap]));
	//			}
	//		} catch (Exception e) {
	//			logStep("After Getting BB Ad Call, Verified ThirdPartyBeacon Values Not Presented");
	//			System.out.println(exceldata[1][Cap] +" not available.");
	//			Assert.fail(exceldata[1][Cap] +" not available.");
	//		}
	//	}

	@SuppressWarnings("unchecked")
	public static void beacons_validation(String excel_sheet_name) throws Exception{

		logStep("Verify BB Ad Presented On Home page ");
		if(excel_sheet_name.contains("ThirdpartyBecon")){
			logStep("Verify BB Ad Call Response Should Contains The Urls 1) CreativeId 2) ThirdPartyBeacon 3) ThirdPartySurvey ");
		}
		else{
			logStep("Verify BB Ad Call Response Should Contains The Urls 1) CreativeId 2) Video URL 3) FourthPartyBeacon ");
		}
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][Cap]));
		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][Cap]),required_info.indexOf(exceldata[3][Cap]));
		String expectedValues = expected_data.toString();

		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		String[] keypairs = expectedValues.split(exceldata[4][Cap]);

		try {
			for (String keyvalue : keypairs)
			{
				String[] key_value = keyvalue.split(exceldata[5][Cap],2);
				if(key_value[0].trim().equals(exceldata[8][Cap].trim())){
					if(!empty(key_value[1])){
						if(Read_API_Call_Data.contains("fourthPartyBeacon")){
							String fourthPartyBeaconURL = key_value[1].trim();

							String[] y = Read_API_Call_Data.toString().split("fourthPartyBeacon: ",2);

							String str = y[1];
							String findStr = fourthPartyBeaconURL;
							findStr=findStr.substring(findStr.indexOf("gampad"), findStr.length());



							//int index = 0;
							int count = 0;

							int p = 0;
							while(p != -1){
								p = str.indexOf(findStr,p);
								if(p != -1){
									count ++;
									p =p+findStr.length();
								}
							}


							if(count>=2){
								logStep("FourthPartyBeacon call getting fired");
								System.out.println("FourthPartyBeacon call getting fired");
								RetryAnalyzer.count=0;
							}
							else{
								logStep("FourthPartyBeacon call not getting fired");	
								System.out.println("FourthPartyBeacon call not getting fired");
								Assert.fail("FourthPartyBeacon call not getting fired");

							}
						}

					}

				}
				map.put(key_value[0], key_value[1]);
			}


			if(!empty(map.get(exceldata[6][Cap])) && !empty(map.get(exceldata[7][Cap])) && !empty(map.get(exceldata[8][Cap]))){

				logStep("After Getting BB Ad Call,Verified ThirdPartyBeacon Values From BB Ad Call Response");
				logStep(exceldata[6][Cap]+" Value Is "+map.get(exceldata[6][Cap]));
				logStep(exceldata[7][Cap]+" Value Is "+map.get(exceldata[7][Cap]));
				logStep(exceldata[8][Cap]+" Value Is "+map.get(exceldata[8][Cap]));

				System.out.println(exceldata[6][Cap]+" Value is "+map.get(exceldata[6][Cap]));
				System.out.println(exceldata[7][Cap]+" Value is "+map.get(exceldata[7][Cap]));
				System.out.println(exceldata[8][Cap]+" Value is "+map.get(exceldata[8][Cap]));
				RetryAnalyzer.count=0;
			}
		} catch (Exception e) {
			logStep("After Getting BB Ad Call, Verified ThirdPartyBeacon Values Not Presented");
			System.out.println(exceldata[1][Cap] +" not available.");
			Assert.fail(exceldata[1][Cap] +" not available.");
		}
	}





	private static boolean empty(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public static String get_pub_ad_call(int feed) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String expectedValues =null;
		String[][] exceldata = read_excel_data.exceldataread("AllFeeds");
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		for(int i=0;i<=10;i++){
			if(sb.toString().contains(exceldata[17][Cap]+feed)){

				String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]+feed));
				String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));
				required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
				required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
				required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");

				String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
				expectedValues = expected_data.toString();
			}
		}
		return expectedValues;
	}

	public static void validate_CXTG_values(String excel_sheet_name) throws Exception{

		logStep("Verify WeatherFX API Call Should Made In Charles");
		logStep("Verify CXTG Values From WeatherFX API Call Response");
		logStep("PubAd Call CXTG Keyword Values Are Matched With Weather FX API Call CXTG Values Based On Locations");
		Map<String, String> cxtg_res = get_wfxtriggers_call(excel_sheet_name);
		Map<String, String> pubad_res = null;
		List<String> cxtg_not_match = new ArrayList<String>();
		String finalval=null;
		boolean isExceptionOccered = false;
		Set<String> keys = cxtg_res.keySet();
		for (String key : keys) {
			pubad_res = get_pubad_call_by_zip(excel_sheet_name,"%26zip%3D"+key);
			finalval = cxtg_res.get(key).substring(1, cxtg_res.get(key).length() -1);
			System.out.println("CXTG Zip:::"+key+" CXTG Value :::"+finalval);
			System.out.println("Pub Zip:::"+pubad_res.get("zip")+" CXTG Value :::"+pubad_res.get("cxtg"));
			try {
				if(pubad_res.get("cxtg").equals("nl")){
					finalval=pubad_res.get("cxtg");
					Assert.assertEquals(pubad_res.get("cxtg"),finalval);
					RetryAnalyzer.count=0;
					break;
				}else
				{
					Assert.assertEquals(pubad_res.get("cxtg"),finalval);
					RetryAnalyzer.count=0;
					break;
				}

			} catch (ComparisonFailure e) {
				System.out.println(key + " Doesn't Match");
				cxtg_not_match.add(key);
				isExceptionOccered= true;
			}
			if(isExceptionOccered){
				logStep("WeatherFX Call Is Not Made.");
				logStep("Response From WeatherFX Should Be In JSON");
				System.out.println(cxtg_not_match);
				Assert.fail(cxtg_not_match + " are not matched");
			}
		}
	}


	public static Map<String, String> get_Wfxtg_values(String excel_sheet_name) throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		try {
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap]));
			wxtgValues = expected_data.toString();

			
			JSONParser parser = new JSONParser();
			Object obj = null;
			try{
			obj = parser.parse(wxtgValues);
			}catch(Exception e) {

				expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap])-2);
				wxtgValues = expected_data.toString();
				obj = parser.parse(wxtgValues);
			}
			//JSONParser parser = new JSONParser();
			//Object obj = parser.parse(wxtgValues);
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject wfxtgval = (JSONObject) jsonObject.get("wfxtg");
			wfxtriggers_values.put("current", wfxtgval.get("current").toString());
		} catch (Exception e) {
			System.out.println(exceldata[1][Cap] +" Call Not Generated");
			Assert.fail(exceldata[1][Cap] +" Call Not Generated");
		}	

		return wfxtriggers_values;

	}
	public static Map<String, String> get_wfxtriggers_call(String excel_sheet_name) throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String jsonValues = exceldata[11][Cap];
		String[] json_Values = jsonValues.split(",");

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		String expected_data=null;
		try {
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
			if(Read_API_Call_Data.contains("exceldata[2][Cap]"))
			{
				System.out.println("triggers.wfxtriggers.com was triggered");
			}
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

			expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+15,required_info.indexOf(exceldata[5][Cap]));
			wxtgValues = expected_data.toString();

			JSONParser parser = new JSONParser();
			Object obj = null;
			try{
			obj = parser.parse(wxtgValues);
			}catch(Exception e) {

				expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+15,required_info.indexOf(exceldata[5][Cap])-2);
				wxtgValues = expected_data.toString();
				obj = parser.parse(wxtgValues);
			}
			JSONObject jsonObject = (JSONObject) obj;
			JSONObject wfxtgval = (JSONObject) jsonObject.get(json_Values[0]);
			JSONArray scatterSegsVal = (JSONArray) wfxtgval.get(json_Values[1]); 

			/* --- Start For Loop Main JSON Parser --- */
			for(int i=0;i< scatterSegsVal.size();i++){

				JSONObject zcsVal = (JSONObject) scatterSegsVal.get(i);
				/* --- Start Key Pair Contains ZCS --- */
				if(zcsVal.containsKey(exceldata[12][Cap])){
					JSONArray jsonArray = (JSONArray) zcsVal.get(exceldata[12][Cap]);
					/* --- Start ZCS contains multipul ZIP Values --- */
					for(int j=0;j<jsonArray.size();j++){
						JSONObject zipval = (JSONObject) jsonArray.get(j);
						/* --- Start Key Pair Contains ZIP --- */
						if(zipval.containsKey(validate_Values[0])){
							wfxtriggers_values.put(zipval.get(validate_Values[0]).toString(), zipval.get(validate_Values[1]).toString());
						}/* --- End Key Pair Contains ZIP --- */

					}/* --- End ZCS contains multipul ZIP Values --- */

				}/* --- End Key Pair Contains ZCS --- */

			}/* --- End For Loop Main JSON Parser --- */
		} catch (Exception e) {
			System.out.println(exceldata[1][Cap] +" Call Not Generated");
			Assert.fail(exceldata[1][Cap] +" Call Not Generated");
		}

		return wfxtriggers_values;
	}

	public static Map<String, String> get_pubad_call_by_zip(String excel_sheet_name,String Zip) throws Exception{

		Map<String , String> cxtg_values = new HashMap<String, String>();
		String cxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String Bbcall =exceldata[17][Cap];
		String[] validate_Values = validateValues.split(",");
		/* --- Start JSON Parser for wfxtg Values --- */

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(Bbcall));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(Zip));
			String expected_data = required_info.toString().substring(required_info.indexOf(Zip),required_info.indexOf(exceldata[15][Cap]));
			expected_data= expected_data.toString().replaceAll(exceldata[8][Cap], "=");
			expected_data= expected_data.toString().replaceAll(exceldata[9][Cap], "&");
			expected_data= expected_data.toString().replaceAll(exceldata[10][Cap], ",");
			expected_data= expected_data.toString().replaceAll("%22%7D%5D%7D", "");
			cxtgValues = expected_data.toString();

			String[] arrays = cxtgValues.split("&");
			for(String keys : arrays){
				if(keys.contains("=")){
					String[] key = keys.split("=");
					if(key[0].equals(validate_Values[0])){
						cxtg_values.put(key[0], key[1]);
					}
					if(key[0].equals(validate_Values[1])){
						cxtg_values.put(key[0], key[1]);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Pub Ad Call Not Generated");
			Assert.fail("Pub Ad Call Not Generated");
		}
		return cxtg_values;
	}


	public static void verifySavedAddressList(int SelectAddress) throws Exception{

		logStep("Select Locations From Location Manager ");
		logStep("Tap On Manage Location");
		logStep("Choose Locations Examples: 1) NewYork 2) Atlanta 3) Chicago");

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		/* --- Start For Android Device --- */
		if(Cap == 2){
			String[][] addressdata = read_excel_data.exceldataread("AddressPage");

			Thread.sleep(3000);

			WebDriverWait wait4 = new WebDriverWait(Ad, 60);
			wait4.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));
			try {
			//Root Location Element
				Ad.findElement(By.id("com.weather.Weather:id/search_icon")).click();
			//Ad.findElementById(addressdata[4][Cap]).click();
			Thread.sleep(1000);
				}
				catch(Exception e) {
					Ad.findElementByAccessibilityId("Search").click();
					Thread.sleep(1000);
				}
			try{
				Thread.sleep(8000);
				Ad.hideKeyboard();
			}catch(Exception e){
				//Thread.sleep(6000);
				System.out.println("Keyboard not present");
			}
			
			WebDriverWait wait5 = new WebDriverWait(Ad, 40);
			wait5.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[6][Cap])));
			
			//List Location Element
			@SuppressWarnings("unchecked")
			List<MobileElement> loclist = Ad.findElements(By.id(addressdata[6][Cap]));
			int loc_size = loclist.size() -1;

			String loc_length = Integer.toString(loc_size);

			System.out.println("Total Saved Address List :::::" + loc_length);

			Thread.sleep(2000);

			System.out.println("Start Select Address List");

			String firsteleXpath = addressdata[5][Cap];
			String[] parts = firsteleXpath.split("Count");
			/* --- Start For Loop For Location Click --- */
			for(int i=1;i<= SelectAddress;i++){
				
				if(SelectAddress>1){
					
					wait4.until(ExpectedConditions.presenceOfElementLocated(By.name(addressdata[4][Cap])));
					
					//Root Location Element
					Ad.findElementByName(addressdata[4][Cap]).click();
					try{
						Thread.sleep(8000);
						Ad.hideKeyboard();
					}catch(Exception e){
						//Thread.sleep(6000);
						System.out.println("Keyboard not present");
					}
				}
				String element = null;

				try {

					element = parts[0]+i+parts[1];
					System.out.println(element);
					MobileElement ele=null;
					try{
					ele = (MobileElement) Ad.findElementByXPath(element);
					}catch(Exception e){
						List <MobileElement> Titles = Ad.findElementsById("com.weather.Weather:id/search_item_container");
						for(int j=0;j<=Titles.size();j++){
							if(j==i){
								//System.out.println("Address Name is :"+Titles.get(j).getText());
								Titles.get(j).click();
								ele=Titles.get(j);
							}
						}
					}
					Thread.sleep(2000);
					System.out.println("For This Location ====>"+ele.getText());

					WebDriverWait wait9 = new WebDriverWait(Ad, 40);
					wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

					Ad.findElementByXPath(element).click();

//					WebDriverWait wait10 = new WebDriverWait(Ad, 40);
//					wait10.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));
					Thread.sleep(6000);
					//Root Location Element
					if(i==SelectAddress){
						System.out.println("location selection end");
					}else{
					Ad.findElementByName(addressdata[4][Cap]).click();
					Thread.sleep(6000);
					Ad.hideKeyboard();
					}

				} catch (Exception e) {
					logStep("Locations Are Not Found From Location List");
					System.out.println(element+" is not found in the location list");
				}
			}
			/* --- End For Loop For Location Click --- */

//			Thread.sleep(8000);
//
//			WebDriverWait wait12 = new WebDriverWait(Ad, 10);
//			wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parts[0]+1+parts[1])));
//
//			Ad.findElementByXPath(parts[0]+1+parts[1]).click();
		}/* --- End For Android Device --- */
		System.out.println("End Select Address List");
	}

	public static void maplocal_bbcall_validation(String excel_sheet_name, String mode) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {
			String pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[1][Cap]));

			if(pubadcal.toString().contains(exceldata[1][Cap])){
				System.out.println("BB Ad Call Generated");
				if(mode.equals("severe2") || mode.equals("withalert")){
					System.out.println("BB Ad Call Should Not Been Generated");
					Assert.fail("BB Ad Call Should Not Been Generated");
				}
			}
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("BB Ad Call Not Generated");
		}
	}

	public static Map<String , String> readAdzone__Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		Thread.sleep(10000);
		String Read_API_Call_Data=null;
		try{
			//Validation="Ad_iu";
			if(Validation.equals("Ad_iu")){

				Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
			}else{
				Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[18][Cap]));
			}
		}catch(Exception e){
			//Validation="Video_iu";
			//Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[18][Cap]));
			System.out.println("Ad call is not presented");
		}
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));

		required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
		required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");
		required_info= required_info.toString().replaceAll("%2F", "/");
		required_info = required_info.substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
		System.out.println("required_info is :"+required_info);
		required_info= required_info.toString().replaceAll("iu=/7646/app_android_us/", "");
		required_info= required_info.toString().replaceAll("/","");
		//		if(required_info.toString().equals("HOUSE_AD_BANNER")){
		//			required_info="displaydetailsarticles";
		//		}
		if(Validation.contains("Ad_iu"))
		{		AdzoneValue= required_info.toString();
		System.out.println("Adzone value"+ AdzoneValue);

		}else if( Validation.contains("Video_iu")){
			AdzoneValueVideo=required_info.toString();
			System.out.println("Adzone video value"+AdzoneValueVideo);
		}
		return expected_results;
	}
	public static void Drag_alerts_from_Notificationsbar() throws Exception
	{
		MobileElement statusBar = (MobileElement) Ad
				.findElementById("android:id/statusBarBackground");
		System.out.println("Dragging from status bar");
		Thread.sleep(3000);
		MobileElement videoTile = (MobileElement) Ad
				.findElement(By
						.xpath("//*[@class='android.widget.TextView' and @text='Airlock']"));
		System.out.println("Dragging till " + videoTile.getText());

		TouchAction action = new TouchAction(Ad);
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY = (double) dimensions.getHeight();
		Double startX = (double) dimensions.getWidth();
		System.out.println("StartX :" + startX + "startY" + startY);
		action.longPress(statusBar).moveTo(videoTile).release().perform();
	}

	public static Map<String , String> readPushalerts_breakingnews_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		Map<String , String> expected_results = new HashMap<String, String>();
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		Thread.sleep(10000);
		String Read_API_Call_Data=null;
		String Cust_params=null;
		try{
			Thread.sleep(6000);
			//Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[40][Cap]));
			Read_API_Call_Data = sb.toString().substring(sb.toString().indexOf(exceldata[40][Cap]));
			Thread.sleep(6000);	
		}
		catch(Exception e){	
			Thread.sleep(6000);
			System.out.println("Ad call is not presented");
			Thread.sleep(6000);
		}

		//String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));
		//String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));	
		required_info = required_info.substring(required_info.indexOf(exceldata[42][Cap]),required_info.indexOf(exceldata[43][Cap]));
		/*required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");*/
		//required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("required_info is :"+required_info);
		required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("iu of breaking news alert  ::: "  + required_info);	
		String required_info1 = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[44][Cap]));
		required_info1 = required_info1.substring(required_info1.indexOf(exceldata[45][Cap]),required_info1.indexOf(exceldata[46][Cap]));
		System.out.println(required_info1);
		required_info1= required_info1.toString().replaceAll("%3D", "=");
		required_info1= required_info1.toString().replaceAll("%26", "");
		System.out.println(required_info1);
		if(required_info1.contains("breaking")){
			System.out.println("alert param contains breking");
		}else
		{
			softAssert.fail("alert param does't contains breaking");
		}

		//}

		return expected_results;
	}
	public static Map<String , String> readPushalerts_lightingnews_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();



		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		Thread.sleep(10000);
		String Read_API_Call_Data=null;
		String Cust_params=null;
		try{

        Read_API_Call_Data = sb.toString().substring(sb.toString().indexOf(exceldata[40][Cap]));
			//Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[40][Cap]));
		}

		catch(Exception e){		
			System.out.println("Ad call is not presented");
		}
		//String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));
		required_info = required_info.substring(required_info.indexOf(exceldata[42][Cap]),required_info.indexOf(exceldata[43][Cap]));
		/*required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");*/
		//required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("required_info is :"+required_info);
		required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("iu Value is  ::: "  + required_info);	
		String required_info1 = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[44][Cap]));
		required_info1 = required_info1.substring(required_info1.indexOf(exceldata[45][Cap]),required_info1.indexOf(exceldata[46][Cap]));
		System.out.println(required_info1);
		required_info1= required_info1.toString().replaceAll("%3D", "=");
		required_info1= required_info1.toString().replaceAll("%26", "");
		System.out.println(required_info1);
		if(required_info1.contains("lghtng")){
			System.out.println("alert param contains lghtng");
		}else
		{
			softAssert.fail("alert param does't contains lghtng");
		}

		//}

		return expected_results;
	}

	public static Map<String , String> readPushalerts_realtimerain_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		Map<String , String> expected_results = new HashMap<String, String>();
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");	
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		Thread.sleep(10000);
		String Read_API_Call_Data=null;
		String Cust_params=null;
		try{
			Thread.sleep(6000);
			//Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[40][Cap]));
			Read_API_Call_Data = sb.toString().substring(sb.toString().indexOf(exceldata[40][Cap]));
			Thread.sleep(6000);
		}
		catch(Exception e){		
			System.out.println("Ad call is not presented");
		}
		Thread.sleep(6000);
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));	
		Thread.sleep(6000);
		required_info = required_info.substring(required_info.indexOf(exceldata[42][Cap]),required_info.indexOf(exceldata[43][Cap]));
		/*required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");*/
		//required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("required_info is :"+required_info);
		required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("iu value is  ::: "  + required_info);	
		String required_info1 = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[44][Cap]));
		required_info1 = required_info1.substring(required_info1.indexOf(exceldata[45][Cap]),required_info1.indexOf(exceldata[46][Cap]));
		System.out.println(required_info1);
		required_info1= required_info1.toString().replaceAll("%3D", "=");
		required_info1= required_info1.toString().replaceAll("%26", "");
		System.out.println(required_info1);
		if(required_info1.contains("rain")){
			System.out.println("alert param contains real time rain");
		}else
		{

			//Assert.fail("alert param does't contains breaking");
			softAssert.fail("alert param does't contains rain");

		}
		System.out.println("/");

		/*int i=0;
	if(i==0){
		if(required_info1.contains("rtrain")){
			System.out.println("alert param contains real time rain");
		}else
		{
			softAssert.fail("alert param does't contains breaking");

		}
		i=i+1;
		System.out.println("i is :"+i);
	}
	if(i==1)
	{
		if(required_info1.contains("breaking")){
			System.out.println("alert param contains breking");
		}else
		{
			softAssert.fail("alert param does't contains breaking");
		}
		i=i+1;
		System.out.println("i is :"+i);
	}
	if(i==2)
	{
		if(required_info1.contains("lghtng")){
			System.out.println("alert param contains breking");
		}else
		{
			softAssert.fail("alert param does't contains breaking");
		}
		i=i+1;
		System.out.println("i is :"+i);

	}
	if(i==3)
	{
		if(required_info1.contains("severe")){
			System.out.println("alert param contains severe");
		}else
		{
			softAssert.fail("alert param does't contains breaking");

		}	
		i=i+1;
		System.out.println("i is :"+i);
	}*/


		//}

		return expected_results;
	}
	public static Map<String , String> readPushalerts_severe_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		Map<String , String> expected_results = new HashMap<String, String>();
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");	
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		Thread.sleep(10000);
		String Read_API_Call_Data=null;
		String Cust_params=null;
		try{
			Thread.sleep(6000);
			//Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[40][Cap]));
			Read_API_Call_Data = sb.toString().substring(sb.toString().indexOf(exceldata[40][Cap]));
			Thread.sleep(6000);
		}
		catch(Exception e){		
			System.out.println("Ad call is not presented");
		}
		//String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));	
		String required_info=null;
		try{
			Thread.sleep(6000);
			required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[41][Cap]));
			Thread.sleep(6000);
		}catch(Exception e){
			Thread.sleep(6000);
			required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().lastIndexOf(exceldata[41][Cap]));	
			Thread.sleep(6000);
		}
		Thread.sleep(6000);
		required_info = required_info.substring(required_info.indexOf(exceldata[42][Cap]),required_info.indexOf(exceldata[43][Cap]));
		Thread.sleep(6000);
		/*required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");*/
		//required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("required_info is :"+required_info);
		required_info= required_info.toString().replaceAll("%2F", "/");
		System.out.println("iu value is  ::: "  + required_info);	
		Thread.sleep(6000);
		String required_info1 = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[44][Cap]));
		Thread.sleep(6000);
		required_info1 = required_info1.substring(required_info1.indexOf(exceldata[45][Cap]),required_info1.indexOf(exceldata[46][Cap]));
		Thread.sleep(6000);
		System.out.println(required_info1);
		required_info1= required_info1.toString().replaceAll("%3D", "=");
		required_info1= required_info1.toString().replaceAll("%26", "");
		System.out.println(required_info1);
		if(required_info1.contains("severe")){
			System.out.println("alert param contains severe");
		}else
		{
			softAssert.fail("alert param does't contains breaking");

		}

		//}

		return expected_results;
	}

	public static void validate_CXTG_values1(String excel_sheet_name) throws Exception
	{
		logStep("Verify WeatherFX API Call Should Made In Charles");
		logStep("Verify CXTG Values From WeatherFX API Call Response");
		logStep("PubAd Call CXTG Keyword Values Are Matched With Weather FX API Call CXTG Values Based On Locations");
		Map<String, String> cxtg_res = get_wfxtriggers_call1(excel_sheet_name);
	}
	
	public static Map<String, String> get_wfxtriggers_call1(String excel_sheet_name) throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String jsonValues = exceldata[11][Cap];
		String[] json_Values = jsonValues.split(",");

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("triggers.wfxtriggers.com")) {
	System.out.println("triggers.wfxtriggers.com was trigred");
}
return wfxtriggers_values;
	}
	
	public static void validate_CXTG_values2(String excel_sheet_name) throws Exception
	{
		logStep("Verify WeatherFX API Call Should Made In Charles");
		logStep("Verify CXTG Values From WeatherFX API Call Response");
		logStep("PubAd Call CXTG Keyword Values Are Matched With Weather FX API Call CXTG Values Based On Locations");
	//	Map<String, String> cxtg_res = get_wfxtriggers_call2(excel_sheet_name);
	}
	
	public static Map<String, String> get_tileadcalls() throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

	//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//		String jsonValues = exceldata[11][Cap];
//		String[] json_Values = jsonValues.split(",");
//
//		String validateValues = exceldata[16][Cap];
//		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Ftoday")) {
	System.out.println("/7646/app_android_us/db_display/home_screen/today was trigred");
}
else {
	System.out.println("/7646/app_android_us/db_display/home_screen/today was not trigred");
}

return wfxtriggers_values;
	}
	public static Map<String, String> get_tileadcalls_hourly() throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

	//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//		String jsonValues = exceldata[11][Cap];
//		String[] json_Values = jsonValues.split(",");
//
//		String validateValues = exceldata[16][Cap];
//		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")) {
	System.out.println("/7646/app_android_us/db_display/home_screen/hourly was trigred");
}
else {
	System.out.println("/7646/app_android_us/db_display/home_screen/hourly was not trigred");
}

return wfxtriggers_values;
	}
	public static Map<String, String> get_tileadcalls_daily() throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

	//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//		String jsonValues = exceldata[11][Cap];
//		String[] json_Values = jsonValues.split(",");
//
//		String validateValues = exceldata[16][Cap];
//		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fdaily")) {
	System.out.println("/7646/app_android_us/db_display/home_screen/daily was trigred");
}
else {
	System.out.println("/7646/app_android_us/db_display/home_screen/daily was not trigred");
}

return wfxtriggers_values;
	}
	public static void gettileElemennts() {
		WebElement element=Ad.findElementByClassName("android.widget.HorizontalScrollView");
		List<WebElement> tiles=element.findElements(By.className("android.support.v7.app.ActionBar$Tab"));
	for(int i=0;i<tiles.size();i++) {
		tiles.get(i).click();
	}
	}
	
	public static void validate_CXTG_values3(String excel_sheet_name) throws Exception
	{
		logStep("Verify WeatherFX API Call Should Made In Charles");
		logStep("Verify CXTG Values From WeatherFX API Call Response");
		logStep("PubAd Call CXTG Keyword Values Are Matched With Weather FX API Call CXTG Values Based On Locations");
		Map<String, String> cxtg_res = get_wfxtriggers_call3(excel_sheet_name);
	}
	
	public static Map<String, String> get_wfxtriggers_call3(String excel_sheet_name) throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String jsonValues = exceldata[11][Cap];
		String[] json_Values = jsonValues.split(",");

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		/* --- Start JSON Parser for wfxtg Values --- */


		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("ad.crwdcntrl.net")) {
	System.out.println("ad.crwdcntrl.net was trigred");
}
else {
	Assert.fail("ad.crwdcntrl.net call not trigred");
}
return wfxtriggers_values;
	}



public static void validate_CXTG_values4(String excel_sheet_name) throws Exception
{
	logStep("Verify WeatherFX API Call Should Made In Charles");
	logStep("Verify CXTG Values From WeatherFX API Call Response");
	logStep("PubAd Call CXTG Keyword Values Are Matched With Weather FX API Call CXTG Values Based On Locations");
	Map<String, String> cxtg_res = get_wfxtriggers_call4(excel_sheet_name);
}

public static Map<String, String> get_wfxtriggers_call4(String excel_sheet_name) throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

	String jsonValues = exceldata[11][Cap];
	String[] json_Values = jsonValues.split(",");

	String validateValues = exceldata[16][Cap];
	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("bcp.crwdcntrl.net")) {
System.out.println("bcp.crwdcntrl.net was trigred");
}
else
{
	Assert.fail("bcp.crwdcntrl.net call not trigred");
}
return wfxtriggers_values;
}
public static void get_hourly_ad_call() throws Exception{
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("/7646/app_android_us/display/details/hourly")) {
System.out.println("location.wfxtriggers.com was trigred");
}

}
public static void get_daily_ad_call() throws Exception{

	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2F10day")) {
System.out.println("location.wfxtriggers.com was trigred");
}
}
public static void get_Radar_ad_call() throws Exception{

read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2Fmaps")) {
System.out.println("location.wfxtriggers.com was trigred");
}
}
public static void get_video_ad_call( )throws Exception{
  read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("%2F7646%2Fapp_android_us%2Fvideo was trigred");
}

}
public static void adCallvalidations() throws Exception{

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	Thread.sleep(4000);
//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
}
public static Map<String, String> finding_Hourlycall(String excel_sheet_name) throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2Fhourly")) {
System.out.println("Hourly was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2Fhourly")) {
System.out.println("Hourly was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Dailycall(String excel_sheet_name) throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
//	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

	String jsonValues = exceldata[11][Cap];
	String[] json_Values = jsonValues.split(",");

	String validateValues = exceldata[16][Cap];
	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2F10day")) {
System.out.println("Daily was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2F10day")) {
System.out.println("Daily was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Videocall(String excel_sheet_name) throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("Video call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("Video call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Mapcall(String excel_sheet_name) throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2Fmaps")) {
System.out.println("Maps call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fdetails%2Fmaps")) {
System.out.println("Maps call was not trigred");
}
return wfxtriggers_values;
}
public static void clickonAllergy() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/allergyTitle").click();
	System.out.println("Allergy element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Allergy was not clicked");
	}
}
public static void clickonAllergy_Pollen() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/allergy_tab_pollen").click();
	System.out.println("Pollen element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Pollen was not clicked");
	}
}
public static Map<String, String> finding_allergyspotlightadcall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdisplay%2Fcontent%2Fallergy")) {
System.out.println("/7646/app_android_us/display/content/allergy call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdisplay%2Fcontent%2Fallergy")) {
System.out.println("/7646/app_android_us/display/content/allergy call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_allergybigbanneradcall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fallergy")) {
System.out.println("/7646/app_android_us/db_display/content/allergy call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fallergy")) {
System.out.println("/7646/app_android_us/display/content/allergy call was not trigred");
}
return wfxtriggers_values;
}

public static void clickonAllergy_Breathing() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/allergy_tab_breathing").click();
	System.out.println("Breathing element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Breathing was not clicked");
	}
}
public static void clickonAllergy_Mold() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/allergy_tab_mold").click();
	System.out.println("Mold element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Mold was not clicked");
	}
}
public static void clickoncoldflu() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/coldFluTitle").click();
	System.out.println("Cold & flu element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Cold & flu was not clicked");
	}
}
public static void clickoncoldflu_cold() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/cold_tab").click();
	System.out.println("cold tab element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("Cold tab was not clicked");
	}
}
public static Map<String, String> finding_cold_fluspotlight_bb_adcalls() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fflu")) {
System.out.println("/7646/app_android_us/db_display/content/flu call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fflu")) {
System.out.println("/7646/app_android_us/db_display/content/flu call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Runningspotlight_bb_adcalls() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Frunning")) {
System.out.println("/7646/app_android_us/db_display/content/running call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Frunning")) {
System.out.println("/7646/app_android_us/db_display/content/running call was not trigred");
}
return wfxtriggers_values;
}
public static void clickoncoldflu_flu() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/flu_tab").click();
	System.out.println("cold_flu tab was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e) {
		System.out.println("cold_flu tab was not clicked");
	}
}
public static void clickonskiing() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/skiingTitle").click();
	Thread.sleep(2000);
	System.out.println("skiing element was clicked");
	}
	catch(Exception e) {
		System.out.println("skiing element was not clicked");
	}
}
public static Map<String, String> finding_skiadcall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fski")) {
System.out.println("/7646/app_android_us/db_display/content/ski call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fski")) {
System.out.println("/7646/app_android_us/db_display/content/ski call was not trigred");
}
return wfxtriggers_values;
}
public static void clickonRunning() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/runningTitle").click();
	Thread.sleep(2000);
	System.out.println("Running element was clicked");
	}
	catch(Exception e) {
		System.out.println("Running element was not clicked");
	}
}
public static void clickonRunning_today() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/run_tab_today").click();
	Thread.sleep(2000);
	System.out.println("today element was clicked");
	}
	catch(Exception e) {
		System.out.println("today tab was not clicked");
	}
}
public static void clickonRunning_tomorrow() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/run_tab_tomorrow").click();
	Thread.sleep(2000);
	System.out.println("tomorrow element was clicked");
	}
	catch(Exception e) {
		System.out.println("tomorrow element was not clicked");
	}
}
public static void clickonRunning_thisweek() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/run_tab_this_week").click();
	Thread.sleep(2000);
	System.out.println("thisweek element was clicked");
	}
	catch(Exception e) {
		System.out.println("thisweek element was not clicked");
	}
}
public static void clickonboat_Beach() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/boatBeachTitle").click();
	Thread.sleep(2000);
	System.out.println("Boat&Beach element was clicked");
	}
	catch(Exception e) {
		System.out.println("boat&Beach element was not clicked");
	}
}
public static void clickonhcmodule() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/hurricane_central_view_more_button").click();
	Thread.sleep(2000);
	System.out.println("hc module element was clicked");
	}
	catch(Exception e) {
		System.out.println("hc module element  was not clicked");
	}
}
public static void clickonhc_maps() throws Exception{
	try {
	Ad.findElementByAccessibilityId("Storm track of nearest tropical storm").click();
	Thread.sleep(2000);
	System.out.println("hc maps element was clicked");
	}
	catch(Exception e) {
		System.out.println("hc maps element  was not clicked");
	}
}
public static void clickonhc_publicAdvisory() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/public_advisory_title_text").click();
	Thread.sleep(2000);
	System.out.println("publicAdvisory element was clicked");
	}
	catch(Exception e) {
		System.out.println("publicAdvisory element  was not clicked");
	}
}

public static void clickonhc_videoplaybutton() throws Exception{
	try {
	Ad.findElementById("com.weather.Weather:id/hurricane_video_play_button").click();
	Thread.sleep(2000);
	System.out.println("videoplaybutton element was clicked");
	}
	catch(Exception e) {
		System.out.println("videoplaybutton element  was not clicked");
	}
}
public static Map<String, String> finding_hcmap_adcall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%%2Fdetails%2Fhc_art")) {
System.out.println("/7646/app_android_us/db_display/details/hc_art call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%%2Fdetails%2Fhc_art")) {
System.out.println("/7646/app_android_us/db_display/details/hc_art call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_hcmap_videocall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fweather%2Fsevere%2Ftropical")) {
System.out.println("/7646/app_android_us/weather/severe/tropicalcall was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fweather%2Fsevere%2Ftropical")) {
System.out.println("/7646/app_android_us/weather/severe/tropical call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_adcalls() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
System.out.println("/7646/app_android_us/display/content/boat_beach call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
System.out.println("/7646/app_android_us/display/content/boat_beach call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_hcdetail_adcall() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("300x250") && sb.contains("300x25")  ) {
	System.out.println("big banner and spotlight ad calls are present");
}
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%%2Fdetails%2Fhurricane")) {
System.out.println("/7646/app_android_us/db_display/content/ski call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%%2Fdetails%2Fhurricane")) {
System.out.println("/7646/app_android_us/db_display/details/hurricane call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_maps_cardvalue() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
System.out.println("/7646/app_android_us/db_display/card/radar call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
System.out.println("/7646/app_android_us/db_display/card/radar call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_health_activities_card_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();



	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Flifestyle")) {
System.out.println("/7646/app_android_us/db_display/card/lifestyle call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Flifestyle")) {
System.out.println("/7646/app_android_us/db_display/card/lifestyle call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_boat_beachspotlight_bb_adcalls() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();

//	String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
//
//	String jsonValues = exceldata[11][Cap];
//	String[] json_Values = jsonValues.split(",");
//
//	String validateValues = exceldata[16][Cap];
//	String[] validate_Values = validateValues.split(",");

	/* --- Start JSON Parser for wfxtg Values --- */


	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
System.out.println("/7646/app_android_us/display/content/boat_beach call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
System.out.println("/7646/app_android_us/display/content/boat_beach call was not trigred");
}
return wfxtriggers_values;
}
public static void clickonBackbutton() throws Exception{
	try {
	Ad.findElementByAccessibilityId("Navigate up").click();	
	System.out.println("Back button element was clicked");
	Thread.sleep(2000);
	}
	catch(Exception e)
	{
		System.out.println("Back button element was not clicked");
	}
}
public static void SwipeUp_Counter(int Counter) throws Exception{

	int swipeup = Counter;
//System.out.println("swipeup");
	for(int i=1;i<=swipeup ;i++){

		Swipe();
		Thread.sleep(5000);
		//Swipe();
	}
}

public static void Swipe(){
	Dimension dimensions = Ad.manage().window().getSize();//throwing exception
	Double startY1 = dimensions.getHeight() * 0.8;  
	startY = startY1.intValue();
	Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
	endY = endY1.intValue();
	Ad.swipe(0, startY, 0, endY,2000);

}

public static Map<String, String> finding_Homescreen_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")) {
	System.out.println("/7646/app_android_us/db_display/home_screen/hourly call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")) {

	System.out.println("/7646/app_android_us/db_display/home_screen/hourly call was not trigred");
    Assert.fail("/7646/app_android_us/db_display/home_screen/hourly call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_VideoCard_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fvideo")) {
	System.out.println("/7646/app_android_us/video call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("/7646/app_android_us/video call was not trigred");
Assert.fail("7646/app_android_us/video call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_Radar_Map_card_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	System.out.println("/7646/app_android_us/db_display/details/maps call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
System.out.println("/7646/app_android_us/db_display/details/maps call was  trigred");
//Assert.fail("/7646/app_android_us/db_display/details/maps call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Radar_Map_feedcard_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
	System.out.println("/7646/app_android_us/db_display/card/radar call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
System.out.println("/7646/app_android_us/db_display/card/radar call was  trigred");
//Assert.fail("/7646/app_android_us/db_display/card/radar call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> finding_Today_detail_page_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Ftoday")) {
	System.out.println("/7646/app_android_us/db_display/details/today call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Ftoday")) {
System.out.println("/7646/app_android_us/db_display/details/today call was not trigred");
Assert.fail("/7646/app_android_us/db_display/details/today call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_H_C_adcalL_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Flifestyle")) {
	System.out.println("7646/app_android_us/db_display/card/lifestyle call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Flifestyle")) {
System.out.println("/7646/app_android_us/db_display/card/lifestyle call was not trigred");
Assert.fail("7646/app_android_us/db_display/card/lifestyle call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> finding_Seasonalhub_adcalL_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fseason")) {
	System.out.println("/7646/app_android_us/db_display/card/season call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fseason")) {
System.out.println("/7646/app_android_us/db_display/card/season call was not trigred");
Assert.fail("7646/app_android_us/db_display/card/season call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> health_and_activities_Running_detailspage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent/%2Frunning")) {
	System.out.println("/7646/app_android_us/db_display/content/running call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent/%2Frunning")) {
System.out.println("/7646/app_android_us/db_display/content/running call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_Running_spotlight_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Frunning")) {
	System.out.println("/7646/app_android_us/db_display/content/running call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Frunning")) {
System.out.println("/7646/app_android_us/db_display/content/running call was not trigred");
Assert.fail("/7646/app_android_us/db_display/content/running call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_Running_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent/%2Frunning")) {
	System.out.println("/7646/app_android_us/db_display/content/running call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent/%2Frunning")) {
System.out.println("/7646/app_android_us/db_display/content/running call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_Boat_beach_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
	System.out.println("/7646/app_android_us/db_display/content/boat_beach call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fboat_beach")) {
System.out.println("/7646/app_android_us/db_display/content/boat_beach call was not trigred");
Assert.fail("/7646/app_android_us/db_display/content/boat_beach call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_Allergy_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fallergy")) {
	System.out.println("/7646/app_android_us/db_display/content/allergy call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fallergy")) {
System.out.println("/7646/app_android_us/db_display/content/allergy call was not trigred");
Assert.fail("/7646/app_android_us/db_display/content/allergy call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_Cold_Flu_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fflu")) {
	System.out.println("/7646/app_android_us/db_display/content/flu call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcontent%2Fflu")) {
System.out.println("/7646/app_android_us/db_display/content/flu call was not trigred");
Assert.fail("/7646/app_android_us/db_display/content/flu call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> health_and_activities_AirQuality_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Faq")) {
	System.out.println("/7646/app_android_us/db_display/card/aq call was trigred");
}
if(!sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Faq")) {
System.out.println("/7646/app_android_us/db_display/content/aq call was not trigred");
Assert.fail("/7646/app_android_us/db_display/card/aq call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> Verify_Hurricane_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhurricane")) {
	System.out.println("/7646/app_android_us/db_display/details/hurricane call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhurricane")) {
System.out.println("/7646/app_android_us/db_display/details/hurricane call was not trigred");
Assert.fail("/7646/app_android_us/db_display/details/hurricane call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> Verify_News_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fweather")) {
	System.out.println("/7646/app_android_us/weather/severe/tropical call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fweather")) {
System.out.println("/7646/app_android_us/weather/severe/tropical call was not trigred");
Assert.fail("/7646/app_android_us/weather/severe/tropical call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> Verify_hourly_detailpage_adcall_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")) {
	System.out.println("/7646/app_android_us/db_display/details/hourly call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fhourly")) {
System.out.println("/7646/app_android_us/db_display/details/hourly call was not trigred");
Assert.fail("/7646/app_android_us/db_display/details/hourly call was not trigred");
}
return wfxtriggers_values;
}

public static Map<String, String> Verify_dailycard_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	 
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fdaily")) {
	System.out.println("7646/app_android_us/db_display/card/daily call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fdaily")) {
System.out.println("/7646/app_android_us/db_display/card/daily call was not trigred");
Assert.fail("7646/app_android_us/db_display/card/daily call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> Verify_snapshot_spotlight_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fsnapshot%2Fspotlight")) {
	System.out.println("/7646/app_android_us/db_display/snapshot/spotlight call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fsnapshot%2Fspotlight")) {
System.out.println("/7646/app_android_us/db_display/snapshot/spotlight call was not trigred");
Assert.fail("/7646/app_android_us/db_display/snapshot/spotlight call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> Verify_snapshot_spotlight_adcard_iu() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fsnapshot%2Fad_card")) {
	System.out.println("/7646/app_android_us/db_display/snapshot/ad_cardt call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fsnapshot%2Fad_card")) {
System.out.println("/7646/app_android_us/db_display/snapshot/ad_card call was not trigred");
Assert.fail("/7646/app_android_us/db_display/snapshot/ad_card call was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> validating_adcrw() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	//https://ad.crwdcntrl.net
	if(sb.contains("ad.crwdcntrl.net")) {
	System.out.println("https://ad.crwdcntrl.net/ url was trigred");
}
if(!sb.contains("ad.crwdcntrl.net")) {
System.out.println("https://ad.crwdcntrl.net/ url was not trigred");
Assert.fail("https://ad.crwdcntrl.net/ url was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> validating_bcp() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("https://bcp.crwdcntrl.net/")) {
	System.out.println("https://bcp.crwdcntrl.net/ url was trigred");
}
if(!sb.contains("https://bcp.crwdcntrl.net/")) {
System.out.println("https://bcp.crwdcntrl.net/ url was not trigred");
Assert.fail("https://bcp.crwdcntrl.net/ url was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> validating_WeatherFXAPI() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("triggers.wfxtriggers.com")) {
	System.out.println("https://triggers.wfxtriggers.com/ url was trigred");
}
if(!sb.contains("triggers.wfxtriggers.com")) {
	https://triggers.wfxtriggers.com
System.out.println("https://triggers.wfxtriggers.com/ url was not trigred");
Assert.fail("https://triggers.wfxtriggers.com/ url was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> validating_turbocallAPI() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("api.weather.com")) {
	System.out.println("https://api.weather.com/ url was trigred");
}
if(!sb.contains("api.weather.com/")) {
	https://triggers.wfxtriggers.com
System.out.println("https://api.weather.com/ url was not trigred");
Assert.fail("https://api.weather.com/ url was not trigred");
}
return wfxtriggers_values;
}
public static Map<String, String> validating_Fatual() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("location.wfxtriggers.com")) {
		//https://triggers.wfxtriggers.com
	System.out.println("https://location.wfxtriggers.com url was trigred");
}
if(!sb.contains("location.wfxtriggers.com")) {
System.out.println("https://location.wfxtriggers.com url was not trigred");
Assert.fail("https://location.wfxtriggers.com url was not trigred");
}
return wfxtriggers_values;
}
public static void get_aaxcal_homescreen_today() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("869c843c-7cf8-47ae-b6ed-088057e4bc8a")) {
	System.out.println("slotID 69c843c-7cf8-47ae-b6ed-088057e4bc8a is trigred for aax  call db_display/home_screen/today");
	}
	if(!sb.contains("869c843c-7cf8-47ae-b6ed-088057e4bc8a")) {
		System.out.println("slotID 69c843c-7cf8-47ae-b6ed-088057e4bc8a is not trigred for aax call db_display/home_screen/today");
		Assert.fail("slotID 69c843c-7cf8-47ae-b6ed-088057e4bc8a is not trigred for aax call db_display/home_screen/today");
		}
}
public static void get_aaxcal_AirQuality() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("9384272f-b27f-4686-935f-02e6c5763abd")) {
	System.out.println("slotID 9384272f-b27f-4686-935f-02e6c5763abd is trigred for aax  call db_display/card/aq");
	}
	if(!sb.contains("9384272f-b27f-4686-935f-02e6c5763abd")) {
		System.out.println("slotID 9384272f-b27f-4686-935f-02e6c5763abd is not trigred for aax call db_display/card/aq");
		Assert.fail("slotID 9384272f-b27f-4686-935f-02e6c5763abd is not trigred for aax calldb_display/card/aq");
		}
}
public static void get_aaxcal_radar() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
	System.out.println("752a96eb-3198-4991-b572-17ec04883b6c is trigred for aax  call db_display/card/radar");
	}
	if(!sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
		System.out.println("slotID 752a96eb-3198-4991-b572-17ec04883b6c is not trigred for aax call db_display/card/radar");
		Assert.fail("slotID 752a96eb-3198-4991-b572-17ec04883b6c is not trigred for aax call db_display/card/radar");
		}
}
public static void get_aaxcal_Hourly() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("9be28769-4207-4d51-8063-dc8e645383b2")) {
	System.out.println("9be28769-4207-4d51-8063-dc8e645383b2 is trigred for aax  call db_display/details/hourly");
	}
	if(!sb.contains("9be28769-4207-4d51-8063-dc8e645383b2")) {
		System.out.println("slotID 9be28769-4207-4d51-8063-dc8e645383b2 is not trigred for aax call db_display/details/hourly");
		Assert.fail("slotID 9be28769-4207-4d51-8063-dc8e645383b2 is not trigred for aax call db_display/details/hourly");
		}
}
public static void get_aaxcal_Daily() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("f063079f-11ac-45b5-b4fc-bb76d54b50b2")) {
	System.out.println("f063079f-11ac-45b5-b4fc-bb76d54b50b2 is trigred for aax  call db_display/details/10day");
	}
	if(!sb.contains("f063079f-11ac-45b5-b4fc-bb76d54b50b2")) {
		System.out.println("slotID f063079f-11ac-45b5-b4fc-bb76d54b50b2 is not trigred for aax call db_display/details/10day");
		Assert.fail("slotID f063079f-11ac-45b5-b4fc-bb76d54b50b2 is not trigred for aax call db_display/details/10day");
		}
}
public static void get_aaxcal_map_details() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/details/maps ");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/details/maps ");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/details/maps");
		}
}
public static void get_aaxcal_today_details() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("8d4e513d-9ae1-4b32-9468-9be0f434262f")) {
	System.out.println("8d4e513d-9ae1-4b32-9468-9be0f434262f is trigred for aax  call db_display/card/today");
	}
	if(!sb.contains("8d4e513d-9ae1-4b32-9468-9be0f434262f")) {
		System.out.println("slotID 8d4e513d-9ae1-4b32-9468-9be0f434262f is not trigred for aax call db_display/details/today");
		Assert.fail("slotID 8d4e513d-9ae1-4b32-9468-9be0f434262f is not trigred for aax call db_display/details/today");
		}
}

public static void get_aaxcal_allergy_spotlight() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/details/today");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/details/today");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/details/today");
		}
}
public static void get_aaxcal_running_spotlight() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/contents/running");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/running");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/running");
		}
}
public static void get_aaxcal_Boat_Beach_spotlight() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/contents/Boat&Beach");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/Boat&Beach");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/Boat&Beach");
		}
}

public static void get_aaxcal_Cold_Flu_Bigbanner() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("4ee58e70-1c8f-41c8-b7cc-ae8089f0c20b")) {
	System.out.println("4ee58e70-1c8f-41c8-b7cc-ae8089f0c20b is trigred for aax  call display/content/flu");
	}
	if(!sb.contains("4ee58e70-1c8f-41c8-b7cc-ae8089f0c20b")) {
		System.out.println("slotID 4ee58e70-1c8f-41c8-b7cc-ae8089f0c20b is not trigred for aax call display/content/flu");
		Assert.fail("slotID 4ee58e70-1c8f-41c8-b7cc-ae8089f0c20b is not trigred for aax call display/content/flu");
		}
}
public static void get_aaxcal_Boat_Beach_Bigbanner() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("58b652be-94ba-494d-8ac8-ac5e9ec00433")) {
	System.out.println("58b652be-94ba-494d-8ac8-ac5e9ec00433 is trigred for aax  call display/content/boat_beach");
	}
	if(!sb.contains("58b652be-94ba-494d-8ac8-ac5e9ec00433")) {
		System.out.println("slotID 58b652be-94ba-494d-8ac8-ac5e9ec00433 is not trigred for aax call display/content/boat_beach");
		Assert.fail("slotID 58b652be-94ba-494d-8ac8-ac5e9ec00433 is not trigred for aax call display/content/boat_beach");
		}
}
public static void get_aaxcal_AQ() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("9384272f-b27f-4686-935f-02e6c5763abd")) {
	System.out.println("9384272f-b27f-4686-935f-02e6c5763abd is trigred for aax  call db_display/card/aq");
	}
	if(!sb.contains("9384272f-b27f-4686-935f-02e6c5763abd")) {
		System.out.println("slotID 9384272f-b27f-4686-935f-02e6c5763abd is not trigred for aax call db_display/card/aq");
		Assert.fail("slotID 9384272f-b27f-4686-935f-02e6c5763abd is not trigred for aax call db_display/card/aq");
		}
}

public static void get_aaxcal_news() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("70f9c21a-f197-4776-9025-809d80b61c67")) {
	System.out.println("70f9c21a-f197-4776-9025-809d80b61c67 is trigred for aax  call db_display/card/newsarticle");
	}
	if(!sb.contains("70f9c21a-f197-4776-9025-809d80b61c67")) {
		System.out.println("slotID 70f9c21a-f197-4776-9025-809d80b61c67 is not trigred for aax call db_display/card/newarticle");
		Assert.fail("slotID 70f9c21a-f197-4776-9025-809d80b61c67 is not trigred for aax call db_display/card/newsarticle");
		}
}

public static void get_aaxcal_hurricanedetails() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5e7f510687cc453388a9c8442f95dc65")) {
	System.out.println("5e7f510687cc453388a9c8442f95dc65 is trigred for aax  call db_display/details/hurricane");
	}
	if(!sb.contains("5e7f510687cc453388a9c8442f95dc65")) {
		System.out.println("slotID 5e7f510687cc453388a9c8442f95dc65 is not trigred for aax call db_display/details/hurricane");
		Assert.fail("slotID 5e7f510687cc453388a9c8442f95dc65 is not trigred for aax call db_display/details/hurricane");
		}
}
public static void get_aaxcal_Running_Bigbanner() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("27a25b19-0b5c-44c6-9051-bb859a7e0f66")) {
	System.out.println("27a25b19-0b5c-44c6-9051-bb859a7e0f66 is trigred for aax  call db_display/content/running");
	}
	if(!sb.contains("27a25b19-0b5c-44c6-9051-bb859a7e0f66")) {
		System.out.println("slotID 27a25b19-0b5c-44c6-9051-bb859a7e0f66 is not trigred for aax call db_display/content/running");
		Assert.fail("slotID 27a25b19-0b5c-44c6-9051-bb859a7e0f66 is not trigred for aax call db_display/content/running");
		}
}

public static void get_aaxcal_Allergy_Bigbanner() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/contents/Allergy");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/Allergy");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/contents/Allergy");
		}
}


public static void get_aaxcal_map_feedcard() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("1f61604c-bb3a-4e2e-a5e3-d9793ec078ed")) {
	System.out.println("1f61604c-bb3a-4e2e-a5e3-d9793ec078ed is trigred for aax  call db_display/contents/allergy ");
	}
	if(!sb.contains("1f61604c-bb3a-4e2e-a5e3-d9793ec078ed")) {
		System.out.println("slotID 1f61604c-bb3a-4e2e-a5e3-d9793ec078ed is not trigred for aax call db_display/contents/allergy");
		Assert.fail("slotID 1f61604c-bb3a-4e2e-a5e3-d9793ec078ed is not trigred for aax call db_display/details/contents/allergy");
		}
}
public static void get_aaxcal_preroll_video() throws Exception {
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
	System.out.println("5db1161b-b504-4640-9496-dfe6284f84ab is trigred for aax  call db_display/preroll/video ");
	}
	if(!sb.contains("5db1161b-b504-4640-9496-dfe6284f84ab")) {
		System.out.println("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/preroll/video");
		Assert.fail("slotID 5db1161b-b504-4640-9496-dfe6284f84ab is not trigred for aax call db_display/dpreroll/video");
		}
}

public static Map<String, String> finding_Homescreen_marquee_iu_value() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")) {
	System.out.println("/7646/app_android_us/db_display/home_screen/marquee call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fmarquee")) {

	System.out.println("/7646/app_android_us/db_display/home_screen/marquee call was not trigred");
    Assert.fail("/7646/app_android_us/db_display/home_screen/marquee call was not trigred");
}
return wfxtriggers_values;
}

public static  void Verify_Privacy_Card_onScreen() throws Exception{
	Thread.sleep(8000);
	System.out.println("Scroll the app till Privay card");
		Swipe_Conter(15);
		Thread.sleep(8000);
     
		String Module=Ad.findElementById("com.weather.Weather:id/header_title").getText();
		if(Module.contains("Privacy")) {
		System.out.println("Privacy Module Presented on the Screen");
	}
	if(!Module.contains("Privacy")) {
	System.out.println("Privacy Module not Presented on the Screen");
	Assert.fail("Privacy Module not Presented on the Screen");
	}
	
	}

//Swipe based on counter  //by naresh
	public static void Swipe_Conter(int Counter) throws Exception{

		int swipe = Counter;

		for(int i=1;i<=swipe ;i++){
			//Thread.sleep(2000);
			//Swipe();
			try{
				Thread.sleep(2000);
				if(Ad.findElementByName("Name any course, dish, or ingredient").isDisplayed()){
				//System.out.println("Watson ad presented");
					break;
				}
			}catch (Exception e){
				Swipe();
				//System.out.println("watson ad not present");
			}


			//Thread.sleep(2000);
		}
	
}

public static  void selecting_opt_out_mode() throws Exception{
		
		//Clicking privacy arrow button
		System.out.println("Clicking privacy arrow button");
	    Ad.findElementById("com.weather.Weather:id/privacy_card_personal_info_container").click();
	    Thread.sleep(8000);
		Swipe_Conter(3);
		 Thread.sleep(3000);
		 TouchAction ta=new TouchAction(Ad);
		 ta.tap(480, 1369).perform();
		//Selecting  Opt out  mode option in privacy card
		System.out.println("Selecting  Opt out  mode option in privacy card");
     		 CharlesFunctions.ClearSessions();
		 Thread.sleep(3000);		
	}

public static void click_video() throws Exception {
    SwipeUp_Counter(1);
    Thread.sleep(5000);
	Ad.findElementById("com.weather.Weather:id/ok_button").click();	
	Thread.sleep(3000);
	clickonBackbutton();
}


public static void scrollapp_maps() throws Exception {
	Swipe_Conter(2);
	Thread.sleep(5000);
}



public static void click_Mapsdetails_element() throws Exception
{
	try {
	Ad.findElementById("com.weather.Weather:id/details_button").click();
	Thread.sleep(3000);		
	}
	catch(Exception e) {
		Ad.findElementById("com.weather.Weather:id/mapBig").click();
		Thread.sleep(3000);
	}	
}
public static void Verify_video_ad_call_Optoutmode_( )throws Exception{
  read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("%2F7646%2Fapp_android_us%2Fvideo was trigred");
}

if(!sb.contains("%2F7646%2Fapp_android_us%2Fvideo")) {
System.out.println("%2F7646%2Fapp_android_us%2Fvideo was not trigred");
Assert.fail("%2F7646%2Fapp_android_us%2Fvideo was not trigred");

}

}

public static  void Verifying_gampadcalls_Optoutmode() throws Exception{
		
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
	System.out.println("/7646/app_android_us/db_display/card/radar call was trigred");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")) {
System.out.println("/7646/app_android_us/db_display/card/radar call was  trigred");

}
	}

public static void Verifying_detail_gampadcalls_Optoutmode() throws Exception{
	
read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//CharlesFunctions.ExportSession();
if(sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	
System.out.println("detail gampadcalls are trigred ");
}
if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")) {
	
System.out.println("detail gampadcalls are not trigred ");
Assert.fail("detail gampadcalls are not trigred");
}
}



public static Map<String, String> validating_bcp_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("https://bcp.crwdcntrl.net/")) {
	Assert.fail("https://bcp.crwdcntrl.net/ url was trigred");
	System.out.println("https://bcp.crwdcntrl.net/ url was trigred");
}
if(!sb.contains("bcp.crwdcntrl.net")) {
System.out.println("https://bcp.crwdcntrl.net/ url was not trigred");

}
return wfxtriggers_values;
}
	
public static Map<String, String> validating_adcrw_privacy_Optoutmode_scenarion()  throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	//https://ad.crwdcntrl.net
	if(sb.contains("ad.crwdcntrl.net")) {
		System.out.println("https://ad.crwdcntrl.net/ url was trigred");
		Assert.fail("https://ad.crwdcntrl.net/ url was trigred");
	
}
if(!sb.contains("ad.crwdcntrl.net")) {
	System.out.println("https://ad.crwdcntrl.net/ url was  not trigred");
}
return wfxtriggers_values;
}


public static Map<String, String> validating_Fatualcall_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("location.wfxtriggers.com")) {
		System.out.println("https://location.wfxtriggers.com url was  trigred");
		Assert.fail("https://location.wfxtriggers.com url was  trigred");
		}

if(!sb.contains("location.wfxtriggers.com")) {
System.out.println("https://location.wfxtriggers.com url was not trigred");

}
return wfxtriggers_values;
}
public static Map<String, String> validating_aax_privacy_Optoutmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("aax")) {
		System.out.println("amazon aax calls  was trigred");
		Assert.fail("amazon aax calls  was trigred");
		}

if(!sb.contains("aax")) {
System.out.println("amazon aax calls was not trigred");

}
return wfxtriggers_values;
}

public static Map<String, String> validating_bcp_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("bcp.crwdcntrl.net")) {
		System.out.println("https://bcp.crwdcntrl.net/ url was trigred");

}
if(!sb.contains("bcp.crwdcntrl.net")) {
	Assert.fail("https://bcp.crwdcntrl.net/ url was not trigred");
	System.out.println("https://bcp.crwdcntrl.net/ url was not trigred");

}
return wfxtriggers_values;
}
	
public static Map<String, String> validating_adcrw_privacy_Optinmode_scenarion()  throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	//https://ad.crwdcntrl.net
	if(sb.contains("ad.crwdcntrl.net")) {
		System.out.println("https://ad.crwdcntrl.net/ url was trigred");
	
}
if(!sb.contains("ad.crwdcntrl.net")) {
	System.out.println("https://ad.crwdcntrl.net/ url was not trigred");
	Assert.fail("https://ad.crwdcntrl.net/ url was not trigred");
	
}
return wfxtriggers_values;
}
public static Map<String, String> validating_Fatualcall_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("location.wfxtriggers.com")) {
		System.out.println("https://location.wfxtriggers.com url was trigred");
		}

if(!sb.contains("location.wfxtriggers.com")) {
	System.out.println("https://location.wfxtriggers.com url was not trigred");
	Assert.fail("https://location.wfxtriggers.com url was not trigred");


}
return wfxtriggers_values;
}
public static Map<String, String> validating_aax_privacy_Optinmode_scenarion() throws Exception{

	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
	if(sb.contains("aax")) {
		System.out.println("amazon aax calls was trigred");
		}

if(!sb.contains("aax")) {
	System.out.println("amazon aax calls  was not trigred");
	Assert.fail("amazon aax calls  were not trigred");


}
return wfxtriggers_values;
}
public static  void selecting_opt_in_mode() throws Exception{
	
	//Clicking privacy arrow button
	System.out.println("Clicking privacy arrow button");
    Ad.findElementById("com.weather.Weather:id/privacy_card_personal_information_view").click();
    Thread.sleep(8000);
	Swipe_Conter(3);
	 Thread.sleep(3000);
	 TouchAction ta=new TouchAction(Ad);
	 ta.tap(347, 1070).perform();
	 Ad.findElementById("com.weather.Weather:id/popup_positive_button").click();
	    Thread.sleep(8000);
	//Selecting  Opt out  mode option in privacy card
	System.out.println("Selecting  Opt in  mode option in privacy card");
   //Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.ListView/android.view.View[2]").click();
	 CharlesFunctions.ClearSessions();
	 Thread.sleep(3000);		
}

public static void nextgenim_adunit() throws Exception {
	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";

	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
if(sb.contains(exceldata[1][1])) {
	System.out.println(exceldata[1][1]+ "call was trigred");
}
if(!sb.contains(exceldata[1][1])) {

	System.out.println(exceldata[1][1]+ "call was not trigred");
    Assert.fail(exceldata[1][1]+ "call was not trigred");
}
}
public static void nextgenim_adcall_response() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	 
	if(sb.contains(exceldata[8][1])) {
		//bgEvent:'adBg'
		System.out.println("got the response for marquee ad call");
		Check_marquee_ad();
	}
	if(!sb.contains(exceldata[8][1]))	
	 {
		System.out.println("did't the response for marquee ad call");

		try {
		Check_marquee_ad();
		}
		finally {
	    Assert.fail("did't the response for marquee ad call");
		}
	}
	 
	 }

public static void Check_marquee_ad() throws Exception
{  
WebElement feedad=null;
try{
System.out.println("Checking for marquee ad on  home page");
feedad=Ad.findElementByClassName("android.webkit.WebView");
Thread.sleep(5000);
if(feedad.isDisplayed())
{
System.out.println("marquee ad present on home screen");
//ScreenShot("marquee ad","Passed");
//attachScreen();
System.out.println("took the passed marquee ad screen shot");
}    
}
catch(Exception e)
{	
//ScreenShot("marquee ad","Failed");
//attachScreen();
System.out.println("took the failed marquee ad screen shot");
Assert.fail("marquee ad is not present");
}	
} 

public static void validate_FG_BG_adcalls_NextGenIM() throws Exception {
	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	if(sb.contains(exceldata[6][1])) {		
		System.out.println("Foreground call was generated for NextGen Im ad call");		
	}
	if(sb.contains(exceldata[7][1])) {
		System.out.println("Background call was generated for NextGen Im ad call ");
	}	
	if(!sb.contains(exceldata[6][1])) {
		System.out.println("Foreground call is not generated for NextGen Im ad call");
		if(!sb.contains(exceldata[7][1]))
			System.out.println("Background call is not generated for NextGen Im ad call ");
		Assert.fail("Foreground and  Background calls are not trigred");
	}
	}


public static void validate_Size_NextGenIM() throws Exception {
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	if(sb.toString().contains(exceldata[1][1])){
		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[1][1]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][1]));
		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][1]),required_info.indexOf(exceldata[5][1]));
		String expectedValues = expected_data.toString();
		String marqueeadsize=expectedValues.replaceAll(exceldata[4][1], "");
		if(marqueeadsize.equalsIgnoreCase(exceldata[3][1])) {
			System.out.println("marquee ad call size is:::"  + marqueeadsize);
		}
		else {
			System.out.println("marqueeadsize is not matched with"     + exceldata[3][1]);
			Assert.fail("marqueeadsize is not matched with"+ exceldata[3][1]);
		}
		System.out.println(expectedValues);
		
	}
	}



public static void dailyIFCard_adcall_response() throws Exception {
	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
	
				if(sb.contains(exceldata[8][1])) {
					//bgEvent:'adBg'
					System.out.println("got the response for Daily IF card ad call");
					Check_DailyIFCard_ad();
				}
				if(!sb.contains(exceldata[8][1]))	
				 {

					System.out.println("did't the response for Daily IF card ad call");
					try {
						Check_DailyIFCard_ad();
					}
				   finally {
				    Assert.fail("did't the response for Daily IF card ad call");
				   }
				}
	 
	 }

public static void Check_DailyIFCard_ad() throws Exception
{  
WebElement feedad=null;
try{
System.out.println("Checking for Daily IF card Ad");
feedad=Ad.findElementByClassName("android.webkit.WebView");
Thread.sleep(5000);
if(feedad.isDisplayed())
{
System.out.println("Daily IF card is Displayed on the screen");
//ScreenShot("Daily IF ad","Passed");
//attachScreen();
System.out.println("took the failed  Daily IF ad screen shot");
}    
}
catch(Exception e)
{	
//ScreenShot("Daily IF","Failed");
//attachScreen();
System.out.println("took the failed Daily IF ad screen shot");
Assert.fail("Daily IF ad is not presented on the screen");
}	
} 

public static void validate_FG_BG_adcalls_DailyIFcards() throws Exception {
	Map<String , String> wfxtriggers_values = new HashMap<String, String>();
	String wxtgValues="";
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.contains(exceldata[15][1])) {		
			System.out.println("Foreground call was generated for NextGen Im ad call");		
		}
		if(sb.contains(exceldata[16][1])) {
			System.out.println("Background call was generated for NextGen Im ad call ");
		}	
		if(!sb.contains(exceldata[15][1])) {
			System.out.println("Foreground call is not generated for NextGen Im ad call");
			if(!sb.contains(exceldata[16][1]))
				System.out.println("Background call is not generated for NextGen Im ad call");
			Assert.fail("Foreground and  Background calls are not trigred");
		}
	}

public static void validating_aax_privacy_Optoutmode_scenario() throws Exception{

	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	
	//System.out.println("Slot Name is  : "+slotID);
	if(sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
	System.out.println("amazon aax is trigreed for privacy Optoutmode scenario");
	Assert.fail("amazon aax is  trigreed for privacy Optoutmode scenario");
	}
	if(!sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
		System.out.println("amazon aax is not trigreed for privacy Optoutmode scenario");
		
		}
	

}


public static void validating_aax_privacy_Optinmode_scenario() throws Exception{

		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
		
		//System.out.println("Slot Name is  : "+slotID);
		if(sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
		System.out.println("amazon aax is trigreed for privacy Optinmode scenario");
		
		}
		if(!sb.contains("752a96eb-3198-4991-b572-17ec04883b6c")) {
			System.out.println("amazon aax is not trigreed for privacy Optinmode scenario");
			Assert.fail("amazon aax is not   trigreed for privacy Optinmode scenario");
			
			}
		

	}



public static void validate_SOD_Cust_param_homescreen_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for home screen call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for home screen call is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for home screen call is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}


public static void validate_SOD_Cust_param_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for Feed call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for Feed call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for Feed call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_deatiledfeed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for Feed ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for deatiled Feed ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for deatiled Feed ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_video_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("&amp"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("no")) {
				System.out.println("SOD cust param value for video ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for video ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for video ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}
public static void validate_Size_DailyIFCard1() throws Exception {
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("sod"));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod"),required_info.indexOf("%"));
			String expectedValues = expected_data.toString();
			String marqueeadsize=expectedValues.replaceAll("sod=", "");
			if(marqueeadsize.equalsIgnoreCase("no")) {
				System.out.println("SOD cust param value for home screen call is " +marqueeadsize);
			}
			else {
				System.out.println("SOD cust param value for home screen call is not matchged with"     + "no");
				Assert.fail("Daily ad call size is not matched with"+ "no");
			}
			System.out.println(expectedValues);
			
		}
		}


public static void validate_SOD_Cust_param_homescreen_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for home screen call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for home screen call is not matchged with"     +SOD);
				Assert.fail("SOD cust param value for home screen call is not matchged with"     +SOD);
			}
			//System.out.println(expectedValues);
			
		}
}


public static void validate_SOD_Cust_param_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for Feed call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for Feed call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for Feed call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_deatiledfeed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("%26tmp%3D"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for Feed ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for deatiled Feed ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for deatiled Feed ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}

public static void validate_SOD_Cust_param_video_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf("cust_params="));
			String expected_data = required_info.toString().substring(required_info.indexOf("sod%3D"),required_info.indexOf("&amp"));
			
			//6sod%3Dno%
			String expectedValues = expected_data.toString();
			String SOD=expectedValues.replaceAll("%3D", "=");
			
			if(SOD.contains("yes")) {
				System.out.println("SOD cust param value for video ad call is " +SOD);
			}
			else {
				System.out.println("SOD cust param value for video ad call is not matchged with"     + SOD);
				Assert.fail("SOD cust param value for video ad call is not matchged with"     + SOD);
			}
			//System.out.println(expectedValues);
			
		}
}



public static void validate_RDP_homescreen_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP value for home screen call is " +"1");	
			}
		else {
				System.out.println("RDP  value for home screen call is not matchged with"     +"1");
				Assert.fail("RDP for home screen call  is not matchged with"     +"1");
			}
			
		}
}

public static void validate_RDP_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP value for feed ad call is " +"1");	
			}
		else {
				System.out.println("RDP  value for feed ad call is not matchged with"     +"1");
				Assert.fail("RDP for feed ad call call  is not matchged with"     +"1");
			}
			
		}
}

public static void validate_RDP_detailed_feed_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
		
		if(Read_API_Call_Data.contains("rdp")){
			System.out.println("RDP value for detailed feed ad call is " +"1");	
			}
		else {
				System.out.println("RDP  value for detailed feed ad call is not matchged with"     +"1");
				Assert.fail("RDP for detailed feed ad call  is not matched with"     +"1");
			}
			
		}
}

public static void validate_RDP_video_ad_Optoutmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP value for video ad call is " +"1");	
			}
		else {
				System.out.println("RDP  value for video ad call is not matchged with"     +"1");
				Assert.fail("RDP for video ad call  is not matchged with"     +"1");
			}
			
		}
}








public static void validate_RDP_homescreen_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fhome_screen%2Fhourly"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP key word preseted in home screen hourly call");	
			Assert.fail("RDP key word preseted in home screen hourly call");
			}
		else {
			System.out.println("RDP key word is not preseted in home screen hourly call");
			}
			
		}
}


public static void validate_RDP_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fradar"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP key word preseted in feed ad call");	
			Assert.fail("RDP key word preseted in feed ad call");
			}
		else {
				System.out.println("RDP key word is not preseted in feed ad call");
			
			}
			
		}
}

public static void validate_RDP_detailed_feed_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fmaps"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP key word preseted in detailed feed ad call");	
			Assert.fail("RDP key word preseted in detailed feed ad call");
			}
		else {
			System.out.println("RDP key word is not preseted in detailed feed ad call");
			}
			
		}
}


public static void validate_RDP_video_ad_Optinmode() throws Exception {
	
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains("iu=%2F7646%2Fapp_android_us%2Fvideo")){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf("iu=%2F7646%2Fapp_android_us%2Fvideo"));
		
		if	(Read_API_Call_Data.contains("rdp=1")){
			System.out.println("RDP key word preseted in video  ad call");	
			Assert.fail("RDP key word preseted in vidoe ad call");
			}
		else {
			System.out.println("RDP key word preseted in not presented video  ad call");	
			}
			
		}
}

public static void ExportSession_feed() throws Exception{

		String[][] charlesdata = read_excel_data.exceldataread("Charlesdeatils");

		Thread.sleep(3000);
		System.out.println("Exporting The Session Data Into XML File");
		driver.findElement(By.linkText(charlesdata[7][0])).click();
		Thread.sleep(20000);
		System.out.println("Exported Session");
	}


public static Map<String, String> Verify_SH_detailpage_adcall_iu() throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();	
		if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fseason")) {
		System.out.println("/7646/app_android_us/db_display/details/season call was trigred");
	}
	if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fdetails%2Fseason")) {
	System.out.println("/7646/app_android_us/db_display/details/season call was not trigred");
	Assert.fail("/7646/app_android_us/db_display/details/season call was not trigred");
	}
	return wfxtriggers_values;
	}
	
	public static Map<String, String> finding_watsonFlu_card_iu_value() throws Exception{

		Map<String , String> wfxtriggers_values = new HashMap<String, String>();
		String wxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	if(sb.contains("iu=%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fwm_flu")) {
		System.out.println("/7646/app_android_us/db_display/card/wm_flu call was trigred");
	}
	if(!sb.contains("%2F7646%2Fapp_android_us%2Fdb_display%2Fcard%2Fwm_flu")) {
	System.out.println("/7646/app_android_us/db_display/card/wm_flu call was  trigred");
	//Assert.fail("/7646/app_android_us/db_display/details/maps call was not trigred");
	}
	return wfxtriggers_values;
	}
	


public static void validate_Size_DailyIFCard() throws Exception {
	DeviceStatus device_status = new DeviceStatus();
	int Cap = device_status.Device_Status();
	read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	String[][] exceldata=read_excel_data.exceldataread("NextGenIM");
		if(sb.toString().contains(exceldata[18][1])){
			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[18][1]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][1]));
			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][1]),required_info.indexOf(exceldata[5][1]));
			String expectedValues = expected_data.toString();
			String marqueeadsize=expectedValues.replaceAll(exceldata[4][1], "");
			if(marqueeadsize.equalsIgnoreCase(exceldata[17][1])) {
				System.out.println("Daily ad call size is:::"  + marqueeadsize);
			}
			else {
				System.out.println("Daily ad call size is not matched with"     + exceldata[17][1]);
				Assert.fail("Daily ad call size is not matched with"+ exceldata[17][1]);
			}
			System.out.println(expectedValues);
			
		}
		}

}