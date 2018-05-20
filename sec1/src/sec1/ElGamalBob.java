package sec1;

import java.io.*;
import java.net.*;
import java.security.*;
import java.math.BigInteger;

public class ElGamalBob {
	private static boolean verifySignature(BigInteger y, BigInteger g, BigInteger p, BigInteger a, BigInteger b,
			String message) throws IOException {
		// IMPLEMENT THIS FUNCTION;
		ByteArrayOutputStream mout = new ByteArrayOutputStream();
		byte buf[] = message.getBytes();
		mout.write(buf);
		BigInteger first = y.modPow(a, p).multiply(a.modPow(b, p)).mod(p);
		BigInteger m = new BigInteger(1, mout.toByteArray());
		BigInteger second = g.modPow(m, p);

		return first.equals(second);
	}

	public static void main(String[] args) throws Exception {
		int port = 7999;
		ServerSocket s = new ServerSocket(port);
		Socket client = s.accept();
		ObjectInputStream is = new ObjectInputStream(client.getInputStream());

		// read public key
		BigInteger y = (BigInteger) is.readObject();
		BigInteger g = (BigInteger) is.readObject();
		BigInteger p = (BigInteger) is.readObject();

		// read message
		String message = (String) is.readObject();

		// read signature
		BigInteger a = (BigInteger) is.readObject();
		BigInteger b = (BigInteger) is.readObject();

		boolean result = verifySignature(y, g, p, a, b, message);

		System.out.println(message);

		if (result == true)
			System.out.println("Signature verified.");
		else
			System.out.println("Signature verification failed.");

		s.close();
	}
}