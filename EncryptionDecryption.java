package com.xworkz.vaccine.utility;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class EncryptionDecryption {
	
	static Cipher cipher;
	final static String secretKeyString = "securedpasswords";
	String algorithm = "AES";
	Logger logger = Logger.getLogger(getClass());

	public EncryptionDecryption() {
		logger.info("created {}");
	}

	public String encrypt(String plainText) {
		SecretKey secretKey;
		try {
			secretKey = new SecretKeySpec(secretKeyString.getBytes("UTF-8"), algorithm);
			cipher = Cipher.getInstance(algorithm);
			byte[] plainTextBytes = plainText.getBytes();
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] encryptedByte = cipher.doFinal(plainTextBytes);
			Encoder encoder = Base64.getEncoder();
			String encodedText = encoder.encodeToString(encryptedByte);
			return encodedText;
		} catch (Exception e) {
			logger.error("exception in {} " + e.getMessage());
		}
		return null;
	}

	public String decrypt(String encryptedText) {
		SecretKey secretKey;
		try {
			secretKey = new SecretKeySpec(secretKeyString.getBytes("UTF-8"), algorithm);
			cipher = Cipher.getInstance(algorithm);
			Decoder decoder = Base64.getDecoder();
			byte[] encryptedTextByte = decoder.decode(encryptedText);
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
			String decodedText = new String(decryptedByte);
			return decodedText;
		} catch (Exception e) {

			logger.error("exception in {} " + e.getMessage());
		}
		return null;
	}
}
