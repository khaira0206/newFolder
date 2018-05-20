package sec1;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MD5_Hash {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		System.out.println("Enter a String");
		String key = in.next();
		System.out.println("MD5 Digest:: " + MD5Hash(key));
		System.out.println("SHA-256 Digest:: " + SHAHash(key));
		in.close();

	}

	public static String MD5Hash(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(key.getBytes("UTF-8"));
		byte byteData[] = md.digest();
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			strbuf.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return strbuf.toString();

	}

	public static String SHAHash(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(key.getBytes("UTF-8"));
		byte byteData[] = md.digest();
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			strbuf.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		return strbuf.toString();
	}

}
