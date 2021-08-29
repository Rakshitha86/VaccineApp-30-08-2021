package com.xworkz.vaccine.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class EmailValidater {

	public static boolean isValidEmailAddress(String email) {
		List<String> list = new ArrayList<String>();
		list.add(".com");
		list.add(".in");
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		for (String mail : list) {
			pattern.matcher(mail);
		}
		return false;

	}

}
