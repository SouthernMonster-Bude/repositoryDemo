import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAOfMicroSvc {
	private static final String PUBLIC_KEY_GTJA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQLAHiWDJvLGQREqGXtdOmQ1EUnz3p0JHOdcVAz/tFbp7dJSM9BufeUckBhmrcUepY5cLwNehELEkezUOpsh6i5zahlJZWZ0YkHaD6K0n0/UNPTWgv/B9yPil2jooFTxbru1xiWDap3oEqiGTudz4i9NLzoB3d7F3XsK+UpbLBwQIDAQAB";
	private static final String PRIVATE_KEY_GTJA = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJAsAeJYMm8sZBESoZe106ZDURSfPenQkc51xUDP+0Vunt0lIz0G595RyQGGatxR6ljlwvA16EQsSR7NQ6myHqLnNqGUllZnRiQdoPorSfT9Q09NaC/8H3I+KXaOigVPFuu7XGJYNqnegSqIZO53PiL00vOgHd3sXdewr5SlssHBAgMBAAECgYBTpbTSJmncptzIKw8mfpB1/sikNmAtsJ1oNFxl5kXbWvtBQ7LWTZNqIfmFsP9/JOfa/DPGOwCvzSH/hQilBHtRGfTueS0eWndXSuPaAOjhB/PTKKRkPw2eCG8l4gwpkALWlsozinTR5cZnGDN1Da1fab7Gf1WXjyaSKn2OaJSYAQJBAMHdkj8jGfsbdP4zaPtOkemVRRv7LulyHVH3xruNNY1YZ99jn3YELrIMeXlZaM+spdGV0EwIwwd9jsO23FYGPFECQQC+YSLYF5F4rY3EmP/yZldiLROI5gzYYyGbQqoNkwE6ChdRpu5fJtFjH1ftve1h9sQ9X5tzWRWxBVUJhQVmAYJxAkAn31Ff6PFEAx6p1ZsG7N73wrqnCZ9ZZh3/qM1X77AO9RrQCCZY2H1eI1Csk6YJ6IFmPMDNkpPCK6G8QRTKIJgxAkBjtVQegRl7bspVMRy7w8X4cUtN487Odfzf6CZQPbHix+42oYsu4pG/rGbM6TAuoqNc0XoFC59Eu1oyRizxo9DBAkEAt8jdcNsd2G1T9cR+2TiJqeKf8gXEjnR2xlaCnq8v6TfdIpY8UB8az8M6vMT+tThWHTJyC2ukXmJLaIVeoLm7Cg==";
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
		System.out.println("苏宁公钥加密串:" + enc);
		System.out.println("result=" + URLEncoder.encode(enc, "utf-8"));
		String dec = decryptByPrivateKeySN(enc);
		System.out.println("苏宁私钥解密串:" + dec);

		enc = encryptByPublicKeyGTJA(dec);
		System.out.println("国泰公钥加密串:" + enc);
		System.out.println("result=" + URLEncoder.encode(enc, "utf-8"));
		dec = decryptByPrivateKeyGTJA(enc);
		System.out.println("国泰私钥解密串:" + dec);
	}
	public static void _main(String[] args) throws Exception {
		initKey();
	}
}
