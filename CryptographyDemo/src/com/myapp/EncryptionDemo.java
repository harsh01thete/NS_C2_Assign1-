package com.myapp;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.io.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptionDemo {

	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, java.security.NoSuchAlgorithmException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException {
		// TODO Auto-generated method stub
KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
key.initialize(2048);
KeyPair pair = key.generateKeyPair();
Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
Scanner in = new Scanner(System.in);
System.out.println("Enter Plain Text : ");
String message = in.next();
byte[] input = message.getBytes();
cipher.update(input);
byte[] cipherText = cipher.doFinal();
System.out.println("Encrypted Cipher Text Message :"+new String(cipherText,"UTF-8"));
OutputStream os = new FileOutputStream("encrypt.txt");
os.write(cipherText);
System.out.println("Encryption is implemented successfully");
	}

}
