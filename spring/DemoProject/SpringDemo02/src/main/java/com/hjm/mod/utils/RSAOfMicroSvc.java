package com.hjm.mod.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAOfMicroSvc {
	private static final String PUBLIC_KEY_GTJA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWIMQW1As/6COSY9pyTMr3mnxbbP49FmD7/Iv0++rTYlHhRpfwVb0tk2ZcNyZowo0mgETG+/hAPwOsFuzvSwhEXHx5KTkM4jkGB+3DAr3nRdJqfPfgn9lSagNHmUNe6yv+PR+RHrM27Pm8lES2zl2Z8WblqDpHZmBCOKG72WFAGwIDAQAB";
	private static final String PRIVATE_KEY_GTJA = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJYgxBbUCz/oI5Jj2nJMyveafFts/j0WYPv8i/T76tNiUeFGl/BVvS2TZlw3JmjCjSaARMb7+EA/A6wW7O9LCERcfHkpOQziOQYH7cMCvedF0mp89+Cf2VJqA0eZQ17rK/49H5Eeszbs+byURLbOXZnxZuWoOkdmYEI4obvZYUAbAgMBAAECgYEAiMCcHndVMAeTr5vJtuiA0n8k3FsyVA74lVF9Y9G+HIOpNl4JtWFEjCmCymlqUW83CGU7QU7w2gUMoUvY1Dky8zmLHej5NqmqQ90XJk6q8vGUuOj8CBw0SjVSWwq7AVaDWTeSezKaX2kmXNtSNtBiw8k7/E9gGs7rZjwh/0WwNNECQQDjIn0YJ5S/EXXymMUkwqfCn6Y3wiqDrD/9XE50/feTmHAZ+IehdUYseWGl73z17iBU/kSwq9gtrgx9dz7JeXs9AkEAqTT4hjFVIgKIESsFVokzDqC/5/qss1xlNNwTzSaa7Fma3pWrrvHS7MhoB1Zf58fWh18cXlOq4A6d4ttmCRs+NwJBAK36IeWZk9cSscyj9gXlUAjErtXw1Q3Mp6sSxEnaqoOUdPF/q6whnyG7y+8FVSsvPfa8WLMWvdynf4uvBhnfAmUCQAGCqIlCHXltPluw355TITKLOstOUIZVV83t/PtC0fU0I47DFUI9hF16uHsASWDfRsn0jmNFKexQFRa2UKXaKWcCQHEE1D5304NeLKghycQQSC94QRYQv73n1ttLjUgvM303x+2uyw56swANUumzr6uxegnm7J5VmPuoOX2z/dpa4xk=";
	private static final String PUBLIC_KEY_SN = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCSZpjNwP8zwqj2SBpMs6KpaSuhsxab4TVcFN9CKBINkfMfoff+5xHnM2EPcY7Rb4oHmX5oC5NZOqt6LYAVjcU3FrF5NWCOlR6l09VIGypxDGCC6rAFCTkA1Vj36Qr6VnH7JG1V21a14vQNynaXAMn1ov37hD9XmhJUOQbkZqA7jwIDAQAB";
	private static final String PRIVATE_KEY_SN= "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJJmmM3A/zPCqPZIGkyzoqlpK6GzFpvhNVwU30IoEg2R8x+h9/7nEeczYQ9xjtFvigeZfmgLk1k6q3otgBWNxTcWsXk1YI6VHqXT1UgbKnEMYILqsAUJOQDVWPfpCvpWcfskbVXbVrXi9A3KdpcAyfWi/fuEP1eaElQ5BuRmoDuPAgMBAAECgYBt5kC87C1ngLBvuO6tN4hbHk0XpKXLPINe7XgvZH8w2qgkzeSp4HIrGgG5oyhwBgga7lna5x2ktQs2u2NUSsmJDb07/XCbhWgznSzR87Fedf+i3IF2PI/6I4OaQe2iTdpmiYt8/mSv7pbHtbRyPr+A8LMqGcOFA6U3lajX8bansQJBANgvb1f99NaM2B6rkQuEQHRDHTYzQZG9WjEBwNLMaUDNgqufLbLGb+XZe8IKyVcUq9jva2IHkAHRiXoV0opegSkCQQCtXQGSbgnISo+126Pbd1NfeTW04ZLZgw6jT80hCYPgFr/VfGaaFheGSsz/Sbxhf+FjlnCNtxdiqmBcClh291X3AkEAok+zBFiq2+8xUI21v/TSw7ekFg6Tu010ivjrAhnxKHNkGWDQ2bn9R5BrR7v7gQMHJ0BS2m4dJBBjbKM3ySW9SQJAfujfBbrYHm+21IJ9aWPo/LNWxZt8TQ7L4HHC0LSOfbUpqbbvxUz227BWcWwhI57h+G1g591omSnwcHCCYlSd8QJBAL37w2/OwPCfFDIKl5fNC+GXYtxc/bHkrXvdmk5HR+q1+6h1UepPLo7EH/ai8TMeDS1bLBg/xzPrta4LrGAQEKU=";
	public static void initKey() throws Exception {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println("publicKey>>");
		System.out.println(new String(Base64.encodeBase64(publicKey.getEncoded())));
		System.out.println("privateKey>>");
		System.out.println(new String(Base64.encodeBase64(privateKey.getEncoded())));
	}
	public static String decryptByPrivateKeyGTJA(String base64) throws Exception {
		return new String(decryptByPrivateKey(Base64.decodeBase64(base64),PRIVATE_KEY_GTJA));
	}


	public static String encryptByPublicKeyGTJA(String str) throws Exception {
		return Base64.encodeBase64String(encryptByPublicKey(str.getBytes("utf-8"),PUBLIC_KEY_GTJA));
	}
	public static String decryptByPrivateKeySN(String base64) throws Exception {
		return new String(decryptByPrivateKey(Base64.decodeBase64(base64),PRIVATE_KEY_SN));
	}


	public static String encryptByPublicKeySN(String str) throws Exception {
		return Base64.encodeBase64String(encryptByPublicKey(str.getBytes("utf-8"),PUBLIC_KEY_SN));
	}
	public static byte[] decryptByPrivateKey(byte[] encryptedData,String key) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(key);
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(2, privateK);
		int inputLen = encryptedData.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		int i = 0;
		byte[] var11;
		try {
			while(inputLen - offSet > 0) {
				byte[] cache;
				if (inputLen - offSet > 128) {
					cache = cipher.doFinal(encryptedData, offSet, 128);
				} else {
					cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
				}
				out.write(cache, 0, cache.length);
				++i;
				offSet = i * 128;
			}
			var11 = out.toByteArray();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		return var11;
	}


	public static byte[] encryptByPublicKey(byte[] data,String key) throws Exception {
		byte[] keyBytes = Base64.decodeBase64(key);
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		Key publicK = keyFactory.generatePublic(x509KeySpec);
		Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
		cipher.init(1, publicK);
		int inputLen = data.length;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int offSet = 0;
		for(int i = 0; inputLen - offSet > 0; offSet = i * 117) {
			byte[] cache = null;
			if (inputLen - offSet > 117) {
				cache = cipher.doFinal(data, offSet, 117);
			} else {
				cache = cipher.doFinal(data, offSet, inputLen - offSet);
			}
			out.write(cache, 0, cache.length);
			++i;
		}
		byte[] encryptedData = out.toByteArray();
		out.close();
		return encryptedData;
	}
	public static void main(String[] args) throws Exception {
		String enc = encryptByPublicKeySN("APPID-XXXXX-XXXXXXXX");
		System.out.println("甲方公钥加密串:" + enc);
		System.out.println("result=" + URLEncoder.encode(enc, "utf-8"));
		String dec = decryptByPrivateKeySN(enc);
		System.out.println("甲方私钥解密串:" + dec);

		enc = encryptByPublicKeyGTJA(dec);
		System.out.println("公司公钥加密串:" + enc);
		System.out.println("result=" + URLEncoder.encode(enc, "utf-8"));
		dec = decryptByPrivateKeyGTJA(enc);
		System.out.println("公司私钥解密串:" + dec);
	}
//	public static void main(String[] args) throws Exception {
//		initKey();
//	}
}
