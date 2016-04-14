import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Example of Base64 encoding with java8
 * <p>
 * 
 * @see <a href=
 *      "https://dzone.com/articles/java-8-base64-encoding-decoding?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava">
 *      artical</a>
 * 
 * @author Glen
 *
 */
public class Base64Sample {

	public static void main(String args[]) {
		String str = "Welcome to see java.util.Base64";
		Base64.Encoder base64Encoder = Base64.getEncoder();
		// encoding byte array into base 64
		byte[] byteArray = null;
		try {
			byteArray = base64Encoder.encode(str.getBytes("UTF-8"));
			System.out.println("Base64 Encoded String : " + new String(byteArray, "UTF-8"));
			// decoding byte array into base64
			Base64.Decoder base64Decoder = Base64.getDecoder();
			byte[] strdec = base64Decoder.decode(byteArray);
			System.out.println("Base64 Decoded String : " + new String(strdec, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}