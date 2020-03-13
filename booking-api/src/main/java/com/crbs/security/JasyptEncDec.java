package com.crbs.security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class JasyptEncDec {
	public JasyptEncDec() {} // Constructor

	public String encryptText(String text) { // Encrypting PlainText
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor();
		enc.setProvider(new BouncyCastleProvider());
		enc.setAlgorithm("PBEWithMD5AndDES");
		enc.setPassword("devops");
		String encryptedText = enc.encrypt(text);
		return encryptedText;
	}	
	
	public String decryptText(String enc) { // Decrypting EncryptedText 
		StandardPBEStringEncryptor dec = new StandardPBEStringEncryptor();
		dec.setProvider(new BouncyCastleProvider());
		dec.setAlgorithm("PBEWithMD5AndDES");
		dec.setPassword("devops");
		String decryptedText = dec.decrypt(enc);
		return decryptedText;
	}

	
	public static void main(String [] args) {
		StandardPBEStringEncryptor enc = new StandardPBEStringEncryptor(); 
		enc.setProvider(new BouncyCastleProvider());
		enc.setAlgorithm("PBEWithMD5AndDES");
		enc.setPassword("devops");
		
//		String username = "root";
		String password = "team2team2";
		
//		System.out.println("encrypted username : " + enc.encrypt(username));
		System.out.println("encrypted password : " + enc.encrypt(password));
		
	}
}
