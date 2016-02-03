package exercise1;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class PersonalData {
	//public static PersonalData buildFromXml(InputSource is) throws Exception {
	
		
	//}
	/*public static PersonalData buildFromXml(InputSource is) throws Exception {
		XPathFactory factory = XPathFactory.newInstance();
	    XPath path = factory.newXPath();
	    PersonalData result = new PersonalData();
	    result.email = path.evaluate("/response/user_info/email", is);
	    //result.displayName = path.evaluate("/response/user_info/display_name", is);
	    // result.firstName = path.evaluate("/response/user_info/first_name", is);
	    return result;
	}
	public static PersonalData buildFromXml2(InputSource is) throws Exception {
		XPathFactory factory = XPathFactory.newInstance();
	    XPath path = factory.newXPath();
	    PersonalData result2 = new PersonalData();
	    result2.firstName = path.evaluate("/response/user_info/first_name", is);
	    return result2;
	}
	public static PersonalData buildFromXml3(InputSource is) throws Exception {
		XPathFactory factory = XPathFactory.newInstance();
	    XPath path = factory.newXPath();
	    PersonalData result3 = new PersonalData();
	    result3.gender = path.evaluate("/response/user_info/gender", is);
	    return result3;
	}*/
//	System.out.println("Personal data: email: " + email);
	
	@Override
	public String toString() {
		return "Personal data: email: " + email + "\n Displayed name is " + displayName +"\n birthDate is " + birthDate 
				+"\n gender " + gender +"\n First Name is " + firstName +"\n Last name is " + lastName ; 
	}

		private String birthDate;
		private String displayName;
		private String email;
		private String firstName;
		private String gender;
		private String lastName;
		private String premium;	
		

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getPremium() {
			return premium;
		}

		public void setPremium(String premium) {
			this.premium = premium;
		}

		public void setBirthDate(String birthDate) {
			this.birthDate = birthDate;
		}
		
		public static PersonalData buildFromXml(Content content) throws Exception {
			PersonalData result = new PersonalData();
		    result.email = fetchField(content,"email");
		    result.birthDate = fetchField(content, "birth_date");
		    result.displayName = fetchField(content, "display_name");
		    result.gender = fetchField(content, "gender");
		    result.firstName = fetchField(content, "first_name");
		    result.lastName = fetchField(content, "last_name");
		    result.premium = fetchField(content, "premium");
		    return result;
		}
		
		
		public static String fetchField(Content content, String field) throws XPathExpressionException {
			
			InputSource source = new InputSource(content.asStream());
			XPathFactory factory = XPathFactory.newInstance();
		    XPath path = factory.newXPath();
		    return path.evaluate("/response/user_info/"+field, source);
		}
		
}
