package com.xworkz.vaccine.utility;

import java.util.Random;

public class RandomOTPGenerator {

	public static Integer generateOTP(int length) {
		// TODO Auto-generated method stub

		String numbers = "1234567890";
		Random random = new Random();
		Integer otp = new Integer(length);
		for (int i = 0; i < length; i++) {
			otp  =  (int) numbers.charAt(random.nextInt(numbers.length()));
		}
		return otp;
	}
}
