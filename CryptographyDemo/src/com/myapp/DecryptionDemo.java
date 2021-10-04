package com.myapp;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.*;

public class DecryptionDemo  {
	
	public static void main(String args[]) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, java.security.NoSuchAlgorithmException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException{
	KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
	key.initialize(2048);
	KeyPair pair = key.generateKeyPair();
	PublicKey publickey = pair.getPublic();
	Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	cipher.init(Cipher.ENCRYPT_MODE, publickey);
	//Scanner in = new Scanner(System.in);
	//System.out.println("Enter Plain Text : ");
	//String message = in.next();
	byte[] input = "This is NS Assignment".getBytes();
	cipher.update(input);
	byte[] cipherText = cipher.doFinal();
	System.out.println("Encrypted Message : "+ new String(cipherText,"UTF-8"));
	cipher.init(Cipher.DECRYPT_MODE, pair.getPrivate());
	byte[] decipheredText = cipher.doFinal(cipherText);
	System.out.println("Decrypted Message : " + new String(decipheredText,"UTF-8"));
	}
}
