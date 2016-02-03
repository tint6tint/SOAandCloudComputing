package GeocodingAPI;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GeocodingService {

	public static String httpGetCC(String urlStr) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}

		InputSource source = new InputSource(conn.getInputStream());

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		DocumentBuilder db = null;
		Document document = null;
		String status = "";
		String CC = "ZERO_RESULTS";

		try {
			db = dbf.newDocumentBuilder();
			document = db.parse(source);
			XPathExpression expr = xpath
					.compile("/GeocodeResponse/status/text()");
			status = (String) expr.evaluate(document, XPathConstants.STRING);
			if (status.equals("OK")) {
				expr = xpath
						.compile("/GeocodeResponse/result/address_component[type='country']/short_name/text()");
				CC = (String) expr.evaluate(document, XPathConstants.STRING);
			}
		} catch (ParserConfigurationException | SAXException | IOException
				| XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		conn.disconnect();

		return CC;
	}

	public static String httpGetCC(double lat, double lng) {
		// Made the URL for The Geocoding API
		String url = "http://maps.googleapis.com/maps/api/geocode/xml?latlng=";
		url = url + lat + "," + lng + "&sensor=false";

		String CC = "ZERO_RESULTS";

		try {
			CC = httpGetCC(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return CC;
	}
}
