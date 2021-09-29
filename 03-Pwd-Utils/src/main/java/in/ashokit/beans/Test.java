package in.ashokit.beans;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Test {
	public static void main(String[] args) throws Exception {

		String pwd = "abc@123";

		MessageDigest msgDigest = MessageDigest.getInstance("SHA-1");

		msgDigest.reset(); // clearing data

		msgDigest.update(pwd.getBytes()); // setting the data to encrypt

		byte[] digest = msgDigest.digest();

		String digestedPwd = new String(digest);
		System.out.println("Digested Pwd :: " + digestedPwd);

		Encoder encoder = Base64.getEncoder();
		String encodeToString = encoder.encodeToString(digest);
		System.out.println("Digested + Encoded Val :: " + encodeToString);

	}
}
