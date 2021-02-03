package com.srm.smsgateway;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
	// Find your Account Sid and Auth Token at twilio.com/console
	  public static final String ACCOUNT_SID = "*******************************";
	  public static final String AUTH_TOKEN = "********************************";


	  public static void sendSMS(String toNumber, String fromNumber,  String msgBody) {
		    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		    Message message = Message.creator(new PhoneNumber(toNumber),
		        new PhoneNumber(fromNumber), 
		        msgBody).create();
		 
		    System.out.println(message.getSid());
		  }
}
