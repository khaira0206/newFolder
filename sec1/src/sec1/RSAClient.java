package sec1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


/*The RSA algorithm involves four steps: key generation, key distribution, encryption and decryption. */
public class RSAClient {

	private static RSAPublicKey client_public_key;
	private static RSAPrivateKey client_private_key;

	static void generationofKeys() {

		KeyPairGenerator genKeyPair = null;
		try {
			genKeyPair = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		genKeyPair.initialize(1024, new SecureRandom());
		KeyPair keyPair = genKeyPair.genKeyPair();
		client_public_key = (RSAPublicKey) keyPair.getPublic();
		client_private_key = (RSAPrivateKey) keyPair.getPrivate();

	}

	public static void main(String[] args)
			throws UnknownHostException, IOException, InvalidKeyException, ClassNotFoundException,
			NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		// generate public and private key
		generationofKeys();

		System.out.println("keys generated");
		// sharing client's public key via File
		File f = new File("client_public_key.txt");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(client_public_key);

		Scanner in = new Scanner(System.in);
		String host = "127.0.0.1";
		int port = 7999;
		Socket s = new Socket(host, port);
		ObjectOutputStream serverStream = new ObjectOutputStream(s.getOutputStream());
		System.out.println("Connected");

		// Get Server's public key
		File sf = new File("server_public_key.txt");
		FileInputStream fin = new FileInputStream(sf);
		ObjectInputStream ois = new ObjectInputStream(fin);
		RSAPublicKey server_public_key = (RSAPublicKey) ois.readObject();

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

		System.out.println(
				"Enter 1 for Achieveing confidentiality \n 2 for Achieving integrity and confidentiality using client's public key ");
		int c = in.nextInt();

		switch (c) {
		case 1:
			String text_to_encrypt = "Achieveing confidentiality using server's public key";
			cipher.init(Cipher.ENCRYPT_MODE, server_public_key);
			byte[] cipherText1 = cipher.doFinal(text_to_encrypt.getBytes());
			System.out.println("The ciphertext is: " + cipherText1);
			serverStream.writeInt(1);
			serverStream.writeObject(cipherText1);
			serverStream.flush();
			serverStream.close();
			break;

		case 2:
			String in2 = "Achieving integrity and confidentiality using client's public key";
			cipher.init(Cipher.ENCRYPT_MODE, client_private_key);
			byte[] cipherText2 = cipher.doFinal(in2.getBytes());
			System.out.println("The ciphertext is: " + cipherText2);
			serverStream.writeInt(2);
			serverStream.writeObject(cipherText2);
			serverStream.flush();
			serverStream.close();
			break;

		}
		s.close();
		in.close();

	}

}

