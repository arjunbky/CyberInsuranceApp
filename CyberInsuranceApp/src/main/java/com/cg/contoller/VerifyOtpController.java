package com.cg.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.TempOtp;
import com.cg.service.OtpService;
@RestController
public class VerifyOtpController {
	@Autowired
	private OtpService otpService;
	
	
	@PostMapping("/otp")
	public String verifyOtp(@RequestBody TempOtp sms) {
		
		if(sms.getOtp()==otpService.getOtp(sms.getPhoneNo())) {
			otpService.clearOTP(sms.getPhoneNo());
			return "Correct OTP";
		}
			
		else 
			return "OTP not correct";
		
	}

}
