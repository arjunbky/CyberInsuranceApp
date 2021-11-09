package com.cg.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

import com.cg.dto.SmsPojo;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
@Component
public class SmsService {
     private final String ACCOUNT_SID ="AC49aa4963661afd2cb1c5a79de2677a04";

    private final String AUTH_TOKEN = "e4761d351203bf623b1923ae03943046";

    private final String FROM_NUMBER = "+19282952342";
    @Autowired
	private OtpService otpService;
	
	

    public void send(SmsPojo sms) throws ParseException {
    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      
    	
        
        int number=otpService.generateOTP(sms.getPhoneNo());
      
        
        String msg ="Your OTP - "+number+ " please verify this OTP in your Application ARJUN";
       
        
        Message message = Message.creator(new PhoneNumber(sms.getPhoneNo()), new PhoneNumber(FROM_NUMBER), msg)
                .create();
       
      StoreOtp.setOtp(number);
    }

    public void receive(MultiValueMap<String, String> smscallback) {
   
    }

}