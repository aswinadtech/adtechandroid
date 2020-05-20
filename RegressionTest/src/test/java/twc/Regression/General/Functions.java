package twc.Regression.General;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.net.ssl.HostnameVerifier;

import junit.framework.ComparisonFailure;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.Genaral.readExcelValues;
//import com.weather.excel.ExcelData;
//import com.weather.excel.Write_result;

import twc.Regression.General.DeviceStatus;
import twc.Regression.HandleWithAppium.AppiumFunctions;
import twc.Regression.Driver.Drivers;
import twc.Regression.ReadDataFromFile.read_excel_data;
import twc.Regression.ReadDataFromFile.read_xml_data_into_buffer;
import twc.Regression.ReadDataFromFile.write_excel_data;
import twc.Regression.utils.ReadExcelData;

public class Functions extends Drivers{

	static int startY;
	static int endY;
	MobileElement skiModule=null;
	MobileElement AllergyModule=null;
	static WebElement coldFluModule =null;
	public static ArrayList<String> aaxSlots = new ArrayList<String>();
	public static String[] homescreenfeedad;
	public static String[] Deatailpagead;
	public static String adType;


	public static void validate_API_Call_With_PubAds_Call(String excel_sheet_name) throws Exception{

		String apicall_results=null;
		String pubadscall_results=null;

		Map<String, String> api_call_results = read_API_Call_Data(excel_sheet_name);
		Map<String, String> pubads_call_results = read_Pub_Ad_Call_Data(excel_sheet_name);
		//System.out.println(api_call_results);
		//System.out.println(pubads_call_results);
		if(api_call_results.keySet().size() == 1){

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

			String[] pubadsresults = pubadscall_results.split(",");
			for(int i=0;i<pubadsresults.length;i++){
				if(apicall_results.contains(pubadsresults[i])){
					System.out.println("Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
				else{
					System.out.println("Does Not Matched With "+ pubadscall_results +" :::: " + pubadsresults[i]);
				}
			}

		}
		else{

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
						System.out.println("Getting nl value for "+pubkey+" from pubads call");
					}
				}
			}
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


		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

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
		return expected_map_results;
	}

	public static Map<String , String> read_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

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
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();


		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String feedVal=exceldata[3][Cap].toString().trim();

		System.out.println("Feeds Val are :"+feedVal.trim());

		int feedcount=Integer.parseInt(feedVal);

		for(int Feed=0;Feed<=feedcount;Feed++){

			String pubadcal;

			if(Feed==0){
				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[1][Cap]));

				if(pubadcal.toString().contains(exceldata[1][Cap])){
					System.out.println("BB Ad call is pressent");
				}else{
					System.out.println("BB Ad call not presented");
					Assert.fail("BB Ad call not presented");
				}

			}
			else
			{
				String feedcall = exceldata[2][Cap]+Feed;

				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]+Feed));
				if(pubadcal.contains(feedcall)){
					System.out.println("Feed_"+Feed +" Ad call is pressent");
				}else{
					System.out.println("Feed_"+Feed +" Ad call is not pressent");
					Assert.fail();
				}

			}
		}
	}

	public static void bb_call_validation(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[17][Cap]));

		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
		String expectedValues = expected_data.toString();

		System.out.println("BB Call Value is : "+expectedValues);
		if(expectedValues.contains(exceldata[17][Cap])){
			System.out.println("BB Call generated");
		}
		else{
			System.out.println("BB Call not generated");
			Assert.fail("BB Call not generated ");
		}
	}

	@SuppressWarnings("unchecked")
	public static void thirdParty_beacons_validation(String excel_sheet_name) throws Exception{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[2][Cap]));
		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[2][Cap]),required_info.indexOf(exceldata[3][Cap]));
		String expectedValues = expected_data.toString();

		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		String[] keypairs = expectedValues.split(exceldata[4][Cap]);

		for (String keyvalue : keypairs)
		{
			String[] key_value = keyvalue.split(exceldata[5][Cap]);
			map.put(key_value[0], key_value[1]);
		}

		if(!empty(map.get(exceldata[6][Cap])) && !empty(map.get(exceldata[7][Cap])) && !empty(map.get(exceldata[8][Cap]))){
			System.out.println(exceldata[6][Cap]+" Value is "+map.get(exceldata[6][Cap]));
			System.out.println(exceldata[7][Cap]+" Value is "+map.get(exceldata[7][Cap]));
			System.out.println(exceldata[8][Cap]+" Value is "+map.get(exceldata[8][Cap]));
		}
		else{
			System.out.println(exceldata[1][Cap] +" not available.");
			Assert.fail(exceldata[1][Cap] +" not available.");
		}

	}
	private static boolean empty(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	//	public static String get_pub_ad_call(int feed) throws Exception{
	//		
	//		DeviceStatus device_status = new DeviceStatus();
	//		int Cap = device_status.Device_Status();
	//		
	//		String expectedValues =null;
	//		String[][] exceldata = read_excel_data.exceldataread("AllFeeds");
	//		
	////		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
	////		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();
	//		
	//		for(int i=0;i<=10;i++){
	//		if(sb.toString().contains(exceldata[17][Cap]+feed)){
	//			
	//		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[17][Cap]+feed));
	//		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));
	//		required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
	//		required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
	//		required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");
	//		
	//		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
	//		expectedValues = expected_data.toString();
	//		}
	//		}
	//		return expectedValues;
	//	}
	//	

	public static String get_pub_ad_call(int feed) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String expectedValues =null;
		String[][] exceldata = read_excel_data.exceldataread("AllFeeds");
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//xml_data_into_buffer.read_xml_file_into_buffer_string("normal");
		//for(int i=0;i<=10;i++){
		String pubad = null;
		if(adType.equalsIgnoreCase("DetailsPages")) {
			pubad = exceldata[18][Cap].toString();
			pubad=pubad+Deatailpagead[feed];
		}else if(adType.equalsIgnoreCase("HomeScreen")){
			pubad = exceldata[17][Cap].toString();
			pubad=pubad+homescreenfeedad[feed];
		}
		if(sb.toString().contains(pubad)){

			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(pubad));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[7][Cap]));
			required_info= required_info.toString().replaceAll(exceldata[8][Cap], "=");
			required_info= required_info.toString().replaceAll(exceldata[9][Cap], "&");
			required_info= required_info.toString().replaceAll(exceldata[10][Cap], ",");

			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[14][Cap]),required_info.indexOf(exceldata[15][Cap]));
			expectedValues = expected_data.toString();
		}
		//	}
		return expectedValues;
	}



	public static void validate_CXTG_values(String excel_sheet_name) throws Exception{

		Map<String, String> cxtg_res = get_wfxtriggers_call(excel_sheet_name);
		Map<String, String> pubad_res = null;
		List<String> cxtg_not_match = new ArrayList<String>();
		String finalval=null;
		boolean isExceptionOccered = false;
		Set<String> keys = cxtg_res.keySet();
		for (String key : keys) {
			pubad_res = get_pubad_call_by_zip(excel_sheet_name,"zip%3D"+key);
			finalval = cxtg_res.get(key).substring(1, cxtg_res.get(key).length() -1);
			System.out.println("CXTG Zip:::"+key+" CXTG Value :::"+finalval);
			System.out.println("Pub Zip:::"+pubad_res.get("zip")+" CXTG Value :::"+pubad_res.get("cxtg"));
			try {
				Assert.assertEquals(pubad_res.get("cxtg"),finalval);
			} catch (ComparisonFailure e) {
				System.out.println(key + " Doesn't Match");
				cxtg_not_match.add(key);
				isExceptionOccered= true;
			}
			if(isExceptionOccered){
				System.out.println(cxtg_not_match);
				Assert.fail(cxtg_not_match + " are not matched");
			}
		}
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


		//			read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//			String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[2][Cap]));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[3][Cap]));

		String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[4][Cap])+7,required_info.indexOf(exceldata[5][Cap]));
		wxtgValues = expected_data.toString();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(wxtgValues);
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
				for(int j=0;j< jsonArray.size();j++){
					JSONObject zipval = (JSONObject) jsonArray.get(j);
					/* --- Start Key Pair Contains ZIP --- */
					if(zipval.containsKey(validate_Values[0])){
						wfxtriggers_values.put(zipval.get(validate_Values[0]).toString(), zipval.get(validate_Values[1]).toString());
					}/* --- End Key Pair Contains ZIP --- */

				}/* --- End ZCS contains multipul ZIP Values --- */

			}/* --- End Key Pair Contains ZCS --- */

		}/* --- End For Loop Main JSON Parser --- */
		return wfxtriggers_values;
	}

	public static Map<String, String> get_pubad_call_by_zip(String excel_sheet_name,String Zip) throws Exception{

		Map<String , String> cxtg_values = new HashMap<String, String>();
		String cxtgValues="";

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");
		/* --- Start JSON Parser for wfxtg Values --- */
		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(Zip));
		String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(Zip));
		String expected_data = required_info.toString().substring(required_info.indexOf(Zip),required_info.indexOf(exceldata[15][Cap]));
		expected_data= expected_data.toString().replaceAll(exceldata[8][Cap], "=");
		expected_data= expected_data.toString().replaceAll(exceldata[9][Cap], "&");
		expected_data= expected_data.toString().replaceAll(exceldata[10][Cap], ",");
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
		return cxtg_values;
	}

	public static void verifySavedAddressList() throws Exception{

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
			for(int i=2;i<= loclist.size();i++){

				String element = null;

				try {

					element = parts[0]+i+parts[1];

					MobileElement ele = (MobileElement) Ad.findElementByXPath(element);
					System.out.println("For This Location ====>"+ele.getText());

					WebDriverWait wait9 = new WebDriverWait(Ad, 20);
					wait9.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));

					Ad.findElementByXPath(element).click();

					WebDriverWait wait10 = new WebDriverWait(Ad, 20);
					wait10.until(ExpectedConditions.presenceOfElementLocated(By.id(addressdata[4][Cap])));

					Ad.findElementById(addressdata[4][Cap]).click();
				} catch (Exception e) {

					System.out.println(element+" is not found in the location list");
				}
			}/* --- End For Loop For Location Click --- */

			Thread.sleep(8000);

			WebDriverWait wait12 = new WebDriverWait(Ad, 10);
			wait12.until(ExpectedConditions.presenceOfElementLocated(By.xpath(parts[0]+1+parts[1])));

			Ad.findElementByXPath(parts[0]+1+parts[1]).click();
		}/* --- End For Android Device --- */
		System.out.println("End Select Address List");
	}

	public static void CleanLaunch_launch(String excel_sheet_name) throws Exception
	{
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		for(int i=1;i<=2 ;i++){
			Thread.sleep(2000);
			Swipe();
			Thread.sleep(2000);
		}

		int MAX_SWIPES = 10;

		for (int j = 0; j < MAX_SWIPES; j++) {

			MobileElement module = null;

			try {

				WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				wait0.until(ExpectedConditions.visibilityOf(Ad.findElementByXPath(exceldata[1][Cap])));
				module = (MobileElement) Ad.findElementByXPath(exceldata[1][Cap]);


			} catch (Exception e) {
				// System.out.println(e);
			}


			if (module!=null && module.isDisplayed()) {
				System.out.println("Last module is present");
				Swipe();
				break;
			} 
			else {
				System.out.println("Last module is NOT present,scrolling down");
				Swipe();
			}
		}
	}

	public static void verify_Vedio_Module_Click_On_Forecast_Video(String excel_sheet_name) throws Exception{

		System.out.println("Searching for Video module");
		Thread.sleep(5000);
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		int swipe = 4;
		//Integer.parseInt(exceldata[2][Cap]);

		for(int i=1;i<=1 ;i++){
			Swipe();
			Thread.sleep(1000);
		}

		int MAX_SWIPES = 5;

		for (int i = 0; i<MAX_SWIPES; i++) {

			MobileElement video = null;

			try {
				Ad.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
				//WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				//wait0.until(ExpectedConditions.visibilityOf(Ad.findElementById(exceldata[5][Cap])));
				video = (MobileElement) Ad.findElementById(exceldata[5][Cap]);

			} catch (Exception e) {
				// System.out.println("Exception message :: "+e);	
			}

			if(video!=null && video.isDisplayed())
			{  
				System.out.println("Video module is present ");
				Ad.findElementById(exceldata[5][Cap]).click();
				Thread.sleep(5000);
				Ad.findElementByClassName(exceldata[6][Cap]).click();
				Thread.sleep(2000);
				break;
			}else
			{
				System.out.println("Video module is NOT present and scrolling down");
				Swipe();
			}
		}
	}






	public static Boolean verifyElement(By by) {
		try {
			// Get the element using the Unique identifier of the element
			Ad.findElement(by);
		} catch (NoSuchElementException e) {
			// Return false if element is not found
			return false;
		} catch (Exception e) {
			return false;
		}
		// Return true if element is found
		return true;
	}



	/*public static void Swipe(){
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = dimensions.getHeight() * 0.7;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		Ad.swipe(0, startY, 0, endY,2000);
	}*/
	public static void Swipe() throws Exception{
		Dimension dimensions = Ad.manage().window().getSize();//throwing exception

		Double startY1 = dimensions.getHeight() * 0.8;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		Thread.sleep(5000);
		Ad.swipe(0, startY, 0, endY,2000);
		//Ad.swipe(startx, starty, endx, endy, duration);

	}

	public static Map<String , String> read_Video_Pub_Ad_Call_Data(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		String validateValues = exceldata[16][Cap];
		String[] validate_Values = validateValues.split(",");

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			if(sb.toString().contains(exceldata[17][Cap])){
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
				expected_results.put("iu",exceldata[17][Cap]);
			}
		} catch (Exception e) {
			System.out.println("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
			Assert.fail("Video Pub Ad Call Not Generated. Ex : "+exceldata[17][Cap]);
		}

		return expected_results;
	}

	public static void verify_Road_Conditions(String excel_sheet_name) throws Exception{

		System.out.println("Searching for Road Conditions");

		Thread.sleep(5000);
		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		int swipe = Integer.parseInt(exceldata[2][Cap]);

		for(int i=1;i<=swipe ;i++){
			Swipe();
			Thread.sleep(1000);
		}

		int MAX_SWIPES = 5;

		for (int i = 0; i<MAX_SWIPES; i++) {

			MobileElement roads = null;

			try {
				WebDriverWait wait0 = new WebDriverWait(Ad, 10);
				wait0.until(ExpectedConditions.visibilityOf(Ad.findElementByName(exceldata[1][Cap])));
				roads = (MobileElement) Ad.findElementByName(exceldata[1][Cap]);


			} catch (Exception e) {
				// System.out.println("Exception message :: "+e);	
			}

			if(roads!=null && roads.isDisplayed())
			{  
				System.out.println("Road Conditions module is present ");
				Ad.findElementByName(exceldata[1][Cap]).click();
				Thread.sleep(2000);
				if(Ad.findElementByXPath(exceldata[5][Cap]).isDisplayed()){
					Thread.sleep(2000);
					Ad.findElementByXPath(exceldata[5][Cap]).click();
				}
				Thread.sleep(2000);
				Ad.findElementByClassName(exceldata[3][Cap]).click();
				Thread.sleep(2000);
				break;
			}else
			{
				System.out.println("Road Conditions is NOT present and scrolling down");
				Swipe();
			}
		}
	}

	public static Map<String , String> ddi_validation(String excel_sheet_name) throws Exception{

		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		Map<String , String> expected_results = new HashMap<String, String>();

		Thread.sleep(4000);
		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);
		@SuppressWarnings("unused")
		Map<String, String> map = new HashMap<String, String>();

		//		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		//		String sb = xml_data_into_buffer.read_xml_file_into_buffer_string();

		try {

			String Read_API_Call_Data = sb.toString().substring(sb.toString().lastIndexOf(exceldata[15][Cap]));
			String required_info = Read_API_Call_Data.toString().substring(Read_API_Call_Data.toString().indexOf(exceldata[15][Cap]));
			String expected_data = required_info.toString().substring(required_info.indexOf(exceldata[13][Cap]),required_info.indexOf(exceldata[14][Cap]));
			expected_data= expected_data.toString().replaceAll(exceldata[7][Cap], "=");
			expected_data= expected_data.toString().replaceAll(exceldata[8][Cap], "&");
			expected_data= expected_data.toString().replaceAll(exceldata[9][Cap], ",");

			String expectedValues = expected_data.toString();

			String[] keypairs = expectedValues.split(exceldata[12][Cap]);

			for (String keyvalue : keypairs)
			{
				if(keyvalue.contains("=")){
					String[] key_value = keyvalue.split(exceldata[11][Cap]);
					if(key_value[0].contains(exceldata[16][Cap])){
						expected_results.put(key_value[0], key_value[1]);
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println(exceldata[15][Cap] + " Value Not Generated");
			Assert.fail(exceldata[15][Cap] + " Value Not Generated");
		}

		return expected_results;

	}
	public static void SwipeUp_Counter_lifestyle_coldflumodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/combo_item_container"));
			//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
			//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
			//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
			if(b==true)
			{
				try {
					Ad.findElementById("com.weather.Weather:id/combo_item_container").click();
					Thread.sleep(1000);
					for(int j=1;j<=3 ;j++){

						Swipe();
					}
				}
				catch(Exception e)
				{					
					Ad.findElementById("Ccom.weather.Weather:id/combo_module_arrow_text").click();
					Thread.sleep(4000);
					for(int j=1;j<=3 ;j++){
						Swipe();
					}
				}

				//AppiumFunctions.Check_Lifestyle_Module_ad();
				//Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_lifestyle_allergymodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}

			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void SwipeUp_Counter_lifestyle_boatBeachmodule() throws Exception{
		System.out.println("Searching for Boat&beach module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout"));

		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
	public static void SwipeUp_Counter_lifestyle_goRunmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
				for(int j=1;j<=3 ;j++){

					Swipe();
				}
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
	public static void SwipeUp_Counter_lifestyle_skimodule() throws Exception{
		System.out.println("Searching for cold&flumodule  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void Clickon_Back_Button() throws Exception 
	{
		try{
			logStep("Clicking on backbuton");
			Ad.findElementByClassName("android.widget.ImageButton").click();
			Thread.sleep(3000);
		}
		catch(Exception e )
		{
			logStep("Clicking on backbuton");
			Ad.findElementByClassName("android.widget.ImageButton").click();
			Thread.sleep(3000);
		}
	}

	public static void SwipeUp_Counter_hourly_submodules() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();


			Boolean b=verifyElement(By.id("com.weather.Weather:id/hourly_more"));
			if(b==true)
			{
				logStep("Hourly page is presented on the screen");		
				Ad.findElementById("com.weather.Weather:id/hourly_more").click();
				logStep("clicked the hourly page link");
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);


				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_Daily_submodule() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/daily_more"));
			if(b==true)
			{
				logStep("Daily page is presented on the screen");
				Ad.findElementById("com.weather.Weather:id/daily_more").click();
				logStep("clicked the Daily page link");
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}


		}
	}

	public static void SwipeUp_Counter_Maps_submodule() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=7 ;i++){

			//Swipe();

			Boolean b=verifyElement(By.id("com.weather.Weather:id/map_module_title"));

			if(b==true)
			{
				logStep("Maps page is presented on the screen");
				try
				{

					Ad.findElementById("com.weather.Weather:id/map_module_thumbnail").click();
					logStep("clicked the Daily page link");
				}
				catch(Exception e)
				{
					Ad.findElementById("com.weather.Weather:id/map_module_more").click();
					logStep("clicked the Daily page link");
				}
				Ad.findElementByClassName("android.widget.ImageButton").click();
				Thread.sleep(5000);				
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}
	public static void SwipeUp_Counter_news_submodules() throws Exception{

		//int swipeup = Counter;

		for(int i=1;i<=12 ;i++){

			Swipe();


			Boolean b=verifyElement(By.id("com.weather.Weather:id/news_title"));
			if(b==true)
			{
				Ad.findElementById("com.weather.Weather:id/news_grid_item_0").click();
				Thread.sleep(5000);
				//Ad.findElementByClassName("android.widget.ImageButton").click();
				//Thread.sleep(5000);
				break;
			}
			else
			{
				System.out.println("Module is not present scroll down");
			}



		}
	}

	public static void Change_to_Test_Mode(String excel_sheet_name) throws Exception{

		logStep("Make Ads As Test From Test Mode Settings In Order To Get BB Ad Call");
		logStep("TestMode Settings: 1) Click On Menu Button 2) Click On Settings 3) Click On About This App 4) Click 10 Times On App Version 5) TestMode Setting Enabled 6) Click On TestMode Settings 7) Click On Ads");


		DeviceStatus device_status = new DeviceStatus();
		int Cap = device_status.Device_Status();

		String[][] exceldata = read_excel_data.exceldataread(excel_sheet_name);

		WebDriverWait wait = new WebDriverWait(Ad, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(exceldata[2][Cap])));//settings button

		MobileElement menu = (MobileElement) Ad.findElement(By.className(exceldata[2][Cap]));
		menu.click();
		System.out.println("clicking on Menu option");
		Thread.sleep(4000);
		try {
			Ad.findElementByName(exceldata[5][Cap]).click(); 
		}
		catch(Exception e)
		{
			List<MobileElement> sett=	Ad.findElementsById("com.weather.Weather:id/design_menu_item_text");
			sett.get(1).click();
		}
		System.out.println("clicking on settings option");
		Thread.sleep(4000);
		try {
			//Ad.findElementByName(exceldata[6][Cap]).click();;//about this app
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[6]/android.widget.RelativeLayout/android.widget.TextView").click();
		}

		catch(Exception e)
		{
			List<MobileElement> aboutelem = Ad.findElementsById("android:id/title");
			System.out.println("elements in setting page"+aboutelem);
			aboutelem.get(1).click();
		}
		//aboutThisAPP.click();
		System.out.println("clicking on about this app option");
		System.out.println("tapping continously to get test mode option");	
		for (int i=1; i<=8; i++){
			Ad.findElementById(exceldata[18][Cap]).click();
		}
		Thread.sleep(4000);
		try {
			Ad.findElementByName(exceldata[19][Cap]).click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]").click();
		}
		System.out.println("clicking on test mode settings");	


		try {
			Ad.findElementByName("Airlock").click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[7]/android.widget.RelativeLayout/android.widget.TextView").click();
		}
		try {
			Ad.findElementByName("User Groups").click();
		}
		catch(Exception e)
		{
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[1]").click();
		}
		Ad.findElementById("com.weather.Weather:id/search_bar").sendKeys("11089");
		Thread.sleep(4000);
		try {
			Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.CheckedTextView[1]").click();
		}
		catch(Exception e)
		{
			Ad.findElementById("android:id/text1").click();
		}
		Thread.sleep(5000);
		///hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ListView/android.widget.CheckedTextView[1]
	}
	public static void Kill_launch() throws Exception{
		try{
		
			Ad.closeApp();		
			Ad.launchApp();
			After_launch();
		}catch(Exception e){

			try {

				Ad.closeApp();		
				Ad.launchApp();
				After_launch();
			}
			catch(Exception e1) {
				
			}
		}
	}

	public static void After_launch(){
		try{
			
        	AppiumFunctions.clickONNext();
        	AppiumFunctions.ClickonIUnderstand();
        	AppiumFunctions.clickOnAllow();
		}catch(Exception e){
			
		}

	}
	public static void scroll_onelement_to_otherelement() throws Exception{
		TouchAction touchAction = new TouchAction(Ad);

		MobileElement ColdFlu=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
		MobileElement BoatBeach=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout");
		Point ColdFluPoint = ColdFlu.getLocation();
		Point BoatBeachPoint =BoatBeach.getLocation();

		int ColdFluX=ColdFluPoint.getX();
		int ColdFluY=ColdFluPoint.getY();
		ColdFluX=ColdFluX+40;
		int BoatBeachX=BoatBeachPoint.getX();
		int BoatBeachY=BoatBeachPoint.getY();

		Ad.swipe(BoatBeachX, BoatBeachY, ColdFluX, ColdFluY, 4000);


	}
	public static void scroll_onelement_to_otherelement1() throws Exception{


		MobileElement ColdFlu=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout");
		MobileElement BoatBeach=(MobileElement) Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout");
		Point ColdFluPoint = ColdFlu.getLocation();
		Point BoatBeachPoint =BoatBeach.getLocation();

		int ColdFluX=ColdFluPoint.getX();
		int ColdFluY=ColdFluPoint.getY();
		ColdFluX=ColdFluX+40;
		int BoatBeachX=BoatBeachPoint.getX();
		int BoatBeachY=BoatBeachPoint.getY();

		Ad.swipe(BoatBeachX, BoatBeachY, ColdFluX, ColdFluY, 4000);


	}
	public static void get_aaxcals() throws Exception {
		read_xml_data_into_buffer xml_data_into_buffer = new read_xml_data_into_buffer();
		xml_data_into_buffer.read_xml_file_into_buffer_string("aax");
		String slotID =null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM");  
		LocalDateTime now = LocalDateTime.now();  
		String date = dtf.format(now);
		System.out.println("date is : "+date);
		//Write_result wrResult2 = new Write_result();
		write_excel_data wrResult2= new write_excel_data();
		read_excel_data.exceldataread_Custom_Parameters("aaxCals","Ad Slots_Android");
		try {

			for(int j=1;j<=read_excel_data.rowCount;j++) {
				wrResult2.writeResult("Ad Slots_Android","-",j,9);
			}
			for(String aaxSlot : aaxSlots) {
				//				aaxSlot=aaxSlot.toString().trim().replaceAll("<body><![CDATA[", "");
				//				aaxSlot=aaxSlot.toString().trim().replaceAll("]]></body></request>", "");
				aaxSlot = aaxSlot.toString().substring(aaxSlot.indexOf("[CDATA")+7,aaxSlot.indexOf("]]></body></request>"));
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new String(aaxSlot.toString()));
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray jArray = (JSONArray) jsonObject.get("slots");
				jsonObject =(JSONObject) jArray.get(0);
				slotID=jsonObject.get("slot").toString();
				//System.out.println("Slot Name is  : "+slotID);

				//readExcelValues.excelValues("AdUnits","Ad Slots_iPhone");
				String[][] exceldata = read_excel_data.exceldataread_Custom_Parameters("aaxCals", "Ad Slots_Android");

				for(int i=1;i<=read_excel_data.rowCount;i++) {
					if(slotID.equals(exceldata[i][8].toString().trim())) {
						System.out.println("slot id mached from for"+exceldata[i][5] +" is : "+exceldata[i][8] + "----"+slotID);
						wrResult2.writeResult("Ad Slots_Android","Passed"+date,i,9);

						break;
					}else {
						if(i==read_excel_data.rowCount) {
							System.out.println("Slot Id not Matched "+slotID );

						}
					}
				}

			}

		}catch(Exception e) {

		}
	}

	public static void SwipeUp_Counter_lifestyle_skidetailßmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}

	public static void SwipeUp_Counter_lifestyle_skiresortsmodule() throws Exception{
		System.out.println("Searching for GoRun module  ");
		Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout"));
		//Ad.findElementByName("HEALTH & ACTIVITIES").getAttribute("")
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		//Boolean b=verifyElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView"));
		if(b==true)
		{
			try {
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
			catch(Exception e)
			{					
				Ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout").click();
				Thread.sleep(5000);	
			}
		}


		else
		{
			System.out.println("Module is not present scroll down");
		}


	}
}