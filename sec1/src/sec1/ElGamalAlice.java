package sec1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.SecureRandom;

public class ElGamalAlice {
	private static BigInteger computeY(BigInteger p, BigInteger g, BigInteger d) {
		// IMPLEMENT THIS FUNCTION;

		return g.modPow(d, p);
	}

	private static BigInteger computeK(BigInteger p) {
		// IMPLEMENT THIS FUNCTION;

		BigInteger k;
		BigInteger one = BigInteger.valueOf(1);
		BigInteger P_one = p.subtract(one);
		do {
			k = new BigInteger(p.bitLength() - 1, new SecureRandom());
		} while (k.gcd(P_one).equals(one) == false);

		return k;
	}

	private static BigInteger computeA(BigInteger p, BigInteger g, BigInteger k) {
		// IMPLEMENT THIS FUNCTION;

		return g.modPow(k, p);

	}

	private static BigInteger computeB(String message, BigInteger d, BigInteger a, BigInteger k, BigInteger p)
			throws IOException {
		// IMPLEMENT THIS FUNCTION;
		ByteArrayOutputStream mout = new ByteArrayOutputStream();
		byte buf[] = message.getBytes();
		mout.write(buf);
		BigInteger m = new BigInteger(1, mout.toByteArray());
		BigInteger one = BigInteger.valueOf(1);
		BigInteger P_one = p.subtract(one);
		BigInteger top = m.subtract(d.multiply(a)).mod(P_one);
		BigInteger b = top.multiply(k.modPow(one.negate(), P_one)).mod(P_one);
		return b;

	}

	public static void main(String[] args) throws Exception {
		String message = "The quick brown fox jumps over the lazy dog.";

		String host = "localhost";
		int port = 7999;
		Socket s = new Socket(host, port);
		ObjectOutputStream os = new ObjectOutputStream(s.getOutputStream());

		// You should consult BigInteger class in Java API documentation to find
		// out what it is.
		BigInteger y, g, p; // public key
		BigInteger d; // private key

		int mStrength = 1024; // key bit length
		SecureRandom mSecureRandom = new SecureRandom(); // a cryptographically
															// strong
															// pseudo-random
															// number

		// Create a BigInterger with mStrength bit length that is highly likely
		// to be prime.
		// (The '16' determines the probability that p is prime. Refer to
		// BigInteger documentation.)
		p = new BigInteger(mStrength, 16, mSecureRandom);

		// Create a randomly generated BigInteger of length mStrength-1
		g = new BigInteger(mStrength - 1, mSecureRandom);
		d = new BigInteger(mStrength - 1, mSecureRandom);

		y = computeY(p, g, d);

		// At this point, you have both the public key and the private key. Now
		// compute the signature.

		BigInteger k = computeK(p);
		BigInteger a = computeA(p, g, k);
		BigInteger b = computeB(message, d, a, k, p);

		// send public key
		os.writeObject(y);
		os.writeObject(g);
		os.writeObject(p);

		// send message
		os.writeObject(message);

		// send signature
		os.writeObject(a);
		os.writeObject(b);
		s.close();
	}
}