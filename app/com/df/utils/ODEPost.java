package com.df.utils;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;

import play.libs.F;
import play.libs.WS;
import play.libs.F.Promise;

public class ODEPost {

	private static final String targetURL = ":9080/ODE/Analyse";

	
	
	@SuppressWarnings("deprecation")
	public static String getVersion(String ipAddress) throws ConnectException
	{
		Promise<WS.Response> response = WS.url("http://"+ipAddress+":9080/ODE/Version")
				.setContentType("application/json")
				.get().map(
 				new F.Function<WS.Response, WS.Response>() {
		        public WS.Response apply(WS.Response response) {
		           return response;
		        }
		    });
		
		return response.get().toString();

	}
	public static String makeConnection(String ipAddress, String data) throws IOException {
		
		
		BufferedReader responseBuffer = null;
		try {

			
			URL targetUrl = new URL("http://"+ipAddress+targetURL);

			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");

			String input = data;
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes(Charset.forName("UTF-8")));
			outputStream.flush();

			/*if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ httpConnection.getResponseCode());
			}*/

			responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream()),
							Charset.forName("UTF-8")));
			String output;
			StringBuilder result= new StringBuilder();
			//System.out.println("Output from Server:\n");
			while ((output = responseBuffer.readLine()) != null) {
				result.append(output);
				//System.out.println(output);
			}
			responseBuffer.close();
			httpConnection.disconnect();
			return result.toString();

		  } catch (MalformedURLException e) {
			  
			e.printStackTrace();

		  } catch (IOException e) {
			e.printStackTrace();

		 }
		finally {
			
			if (responseBuffer != null) {
				responseBuffer.close();
		    }
			
		}
	
		return null;

	}
	/*public static String makeConnection(String ipAddress, String data)throws IOException {

		BufferedReader responseBuffer = null;
		try {

			
			URL targetUrl = new URL("http://"+ipAddress+targetURL);

			HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setDoOutput(true);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");

			String input = data;
			OutputStream outputStream = httpConnection.getOutputStream();
			outputStream.write(input.getBytes(Charset.forName("UTF-8")));
			outputStream.flush();

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ httpConnection.getResponseCode());
			}

			responseBuffer = new BufferedReader(new InputStreamReader(
					(httpConnection.getInputStream())));
			String output;
			String result="";
			//System.out.println("Output from Server:\n");
			while ((output = responseBuffer.readLine()) != null) {
				result;
				//System.out.println(output);
			}

			responseBuffer.close();
			httpConnection.disconnect();
			return result.toString();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }
		return null;

		}*/	 
	 /*public static String readFile(String fileName) {
		 String jsonData = "";
		 try {
	         File file = new File(fileName);
	         Scanner scanner = new Scanner(file);
	        
	         while (scanner.hasNextLine()) {
	           jsonData +=scanner.nextLine();
	         }
	         scanner.close();
	       } catch (FileNotFoundException e) {
	         e.printStackTrace();
	       }
		 return jsonData;
	     }*/
	 public static String readFile(String fileName) {
		 StringBuilder jsonData = new StringBuilder();
		 try {
	         File file = new File(fileName);
	         Scanner scanner = new Scanner(file, "UTF-8");
	        
	         while (scanner.hasNextLine()) {
	           jsonData.append(scanner.nextLine());
	         }
	         scanner.close();
	       } catch (FileNotFoundException e) {
	         e.printStackTrace();
	       }
		 return jsonData.toString();
	     }
}
