package exercise1;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.xml.sax.InputSource;


public class MediaFireConnector {
	private static final String APP_id="42653";
	private static final String API_key="i0ezfsnm0dh1gi9ynzv2qsytqdi3z4ax4j9sc959";
	private String email;
	private String password;
	
	public MediaFireConnector(String email, String password){	
		this.email=email;
		// is calling to the class email, not in the constructor
		this.password=password;
	}
	
	public String calculateSignature(){
		String signatureCombination = email + password + APP_id + API_key; 
		return DigestUtils.shaHex(signatureCombination);
			
	}
	public String getSessionToken() throws ClientProtocolException, IOException, XPathExpressionException {
		/*HttpPost httprequest = new HttpPost("https://www.mediafire.com/api/1.1/user/get_session_token.php");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("email", email));
		nvps.add(new BasicNameValuePair("password", password));
		nvps.add(new BasicNameValuePair("application_id", APP_id));
		nvps.add(new BasicNameValuePair("signature", calculateSignature()));
		httprequest.setEntity(new UrlEncodedFormEntity(nvps)*/
		InputStream response = Request.Post("https://www.mediafire.com/api/1.1/user/get_session_token.php")
	    .bodyForm(Form.form().add("email",  email).add("password",  password).add("application_id", APP_id).add("signature", calculateSignature()).build())
	    .execute().returnContent().asStream();
		return extractSessionToken(response);
	}
	private String extractSessionToken(InputStream is) throws XPathExpressionException{
		XPathFactory factory = XPathFactory.newInstance();
	    XPath path = factory.newXPath();
	    String token = path.evaluate("/response/session_token", new InputSource(is));
		return token;
	}
	public PersonalData getUserInfo() throws Exception {
		Content content = Request.Post("http://www.mediafire.com/api/1.1/user/get_info.php?")
	    .bodyForm(Form.form().add("session_token", getSessionToken()).build())
	    .execute().returnContent();
		
		return PersonalData.buildFromXml(content);
	}
	
	/*public String getUserInfo() throws Exception {
		String is = Request.Post("http://www.mediafire.com/api/1.1/user/get_info.php?")
	    .bodyForm(Form.form().add("session_token", getSessionToken()).build())
	    .execute().returnContent().asString();
		return is;
	}*/
}
	



