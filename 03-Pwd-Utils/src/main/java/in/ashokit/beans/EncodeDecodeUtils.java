package in.ashokit.beans;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodeDecodeUtils {

	public static String encode(String text) {
		Encoder encoder = Base64.getEncoder();
		String encodedString = encoder.encodeToString(text.getBytes());
		return encodedString;
	}

	public static String decode(String encodedStr) {
		Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(encodedStr);
		return new String(decode); // converting byte[] to string
	}

	public static void main(String[] args) {
		String encodedStr = encode("ashokit@123");
		System.out.println("Encoded String :: " + encodedStr);
		String decodedStr = decode(encodedStr);
		System.out.println("Decoded String :: " + decodedStr);
	}

}
