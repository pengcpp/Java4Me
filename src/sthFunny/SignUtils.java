package sthFunny;

import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Iterator;
import java.util.Map;

public class SignUtils {

	private static final String ALGORITHM = "RSA";

	private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

	private static final String DEFAULT_CHARSET = "UTF-8";

	public static String sign(String content, String privateKey) {
		try {
			PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
					Base64.decode(privateKey));
			KeyFactory keyf = KeyFactory.getInstance(ALGORITHM);
			PrivateKey priKey = keyf.generatePrivate(priPKCS8);

			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initSign(priKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));

			byte[] signed = signature.sign();

			return Base64.encode(signed);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static boolean doCheck(String content, String sign, String publicKey) {
		try {
			KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
			byte[] encodedKey = Base64.decode(publicKey);
			PublicKey pubKey = keyFactory
					.generatePublic(new X509EncodedKeySpec(encodedKey));
			java.security.Signature signature = java.security.Signature
					.getInstance(SIGN_ALGORITHMS);

			signature.initVerify(pubKey);
			signature.update(content.getBytes(DEFAULT_CHARSET));
			boolean bverify = signature.verify(Base64.decode(sign));
			return bverify;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean verify(String content, String publicKey, String sign)
			throws Exception {
		byte[] keyBytes = Base64.decode(publicKey);
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		java.security.Signature signature = java.security.Signature
				.getInstance(SIGN_ALGORITHMS);
		signature.initVerify(publicK);
		signature.update(content.getBytes(DEFAULT_CHARSET));
		return signature.verify(Base64.decode(sign));
	}

	public static String buildMD5Sign(String url, Map<String, String> params) {
		System.out.print("getParam: " + getParam(params) + "\n");
		System.out.print("PrivateKey: " + "9545a111d414cdb6016357a5b443cca3" + "\n");
		String str2Sign = getParam(params) + "9545a111d414cdb6016357a5b443cca3";
		System.out.print("MD5: "+ md5(str2Sign));
		return md5(str2Sign);
	}

	public static String md5(String string) {
		byte[] hash;
		try {
			hash = MessageDigest.getInstance("MD5").digest(
					string.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Huh, MD5 should be supported?", e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Huh, UTF-8 should be supported?", e);
		}

		StringBuilder hex = new StringBuilder(hash.length * 2);
		for (byte b : hash) {
			if ((b & 0xFF) < 0x10)
				hex.append("0");
			hex.append(Integer.toHexString(b & 0xFF));
		}
		return hex.toString();
	}

	/*
	 * public static JSONObject string2JSON(String str, String split) {
	 * JSONObject json = new JSONObject(); try { String[] arrStr =
	 * str.split(split); for (int i = 0; i < arrStr.length; i++) { String[]
	 * arrKeyValue = arrStr[i].split("="); json.put(arrKeyValue[0],
	 * arrStr[i].substring(arrKeyValue[0].length() + 1)); } } catch (Exception
	 * e) { e.printStackTrace(); } return json; }
	 */

	public static String getParam(Map<String, String> params) {
		String strParam = "";

		Iterator<Map.Entry<String, String>> iterator = params.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			strParam = strParam
					+ String.format("%s=%s&", entry.getKey(), entry.getValue());
		}
		strParam = strParam.substring(0, strParam.length() - 1);
		return strParam;
	}
}
