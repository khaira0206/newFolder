package sec1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

/*The RSA algorithm involves four steps: key generation, key distribution, encryption and decryption. */
public class RSAServer {

	private static RSAPublicKey server_public_key;
	private static RSAPrivateKey server_private_key;

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
		server_public_key = (RSAPublicKey) keyPair.getPublic();
		server_private_key = (RSAPrivateKey) keyPair.getPrivate();

	}

	public static void main(String[] args) throws Exception {

		generationofKeys();

		// sharing server's public key via File
		File f = new File("server_public_key.txt");
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(server_public_key);

		int port = 7999;
		ServerSocket s = new ServerSocket(port);
		Socket client = s.accept();
		System.out.println("Waiting for connections at 127.0.0.1:7999");
		System.out.println("The client is connected:"+client);
		ObjectInputStream client_output_stream = new ObjectInputStream(client.getInputStream());

		/* Get Alice's public key */
		File sf = new File("client_public_key.txt");
		FileInputStream fin = new FileInputStream(sf);
		ObjectInputStream ois = new ObjectInputStream(fin);
		RSAPublicKey client_public_key = (RSAPublicKey) ois.readObject();

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		Thread.sleep(1000);
		int choice = client_output_stream.readInt();

		switch (choice) {
		case 1:
			System.out.println("Decrypting the client text");
			byte[] in1 = (byte[]) client_output_stream.readObject();
			cipher.init(Cipher.DECRYPT_MODE, server_private_key);
			byte[] plaintText1 = cipher.doFinal(in1);
			System.out.println("The client_text is: " + new String(plaintText1));
			break;

		case 2:
			/*
			 * Achieve Integrity/Authentication by using client's public key to
			 * decipher
			 */
			System.out.println("Achieve Integrity/Authentication:");
			byte[] in2 = (byte[]) client_output_stream.readObject();
			System.out.println(new String(in2));
			cipher.init(Cipher.DECRYPT_MODE, client_public_key);
			byte[] plaintText2 = cipher.doFinal(in2);
			System.out.println("The client_text is: " + new String(plaintText2));
			break;

		}

	}
}
