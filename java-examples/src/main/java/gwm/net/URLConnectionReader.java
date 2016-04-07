package gwm.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Read url response to test proxy settings
 * 
 * @see <a href=
 *      "http://stackoverflow.com/questions/1359689/how-to-send-http-request-in-java>stack
 *      overflow</a>
 * 
 * @see <a href=
 *      "http://docs.oracle.com/javase/8/docs/technotes/guides/net/proxies.html">
 *      java 8 http proxy</a>
 * 
 * @see <a href=
 *      "https://docs.oracle.com/javase/8/docs/api/java/net/doc-files/net-properties.html">
 *      java 8 Networking Properties</a>
 * 
 * @author gwmccort
 *
 */
public class URLConnectionReader {
	public static void main(String[] args) throws Exception {

		// HTTP/HTTPS Proxy
		// System.setProperty("http.proxyHost", "proxy");
		// System.setProperty("http.proxyPort", "9090");
		// System.setProperty("http.proxySet", "true");
		// System.setProperty("proxySet", "true");

		URL yahoo = new URL("http://www.yahoo.com/");
		URLConnection yc = yahoo.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null)
			System.out.println(inputLine);
		in.close();
	}
}