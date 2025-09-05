package com.service;

import org.springframework.stereotype.Service;

@Service
public class OtpGeneratorService {

	public String generateOtp(int length) {

		String seed = "QWERTYUIOPLKJHGFDSAZXCVBNMmnbvcxzasdfghjklpoiuytrewq0987654321";

		String otp = "";
		for (int i = 1; i <= length; i++) {
			int x = (int) (Math.random() * seed.length());
			otp = otp + seed.charAt(x);
		}

		return otp;
	}
}
