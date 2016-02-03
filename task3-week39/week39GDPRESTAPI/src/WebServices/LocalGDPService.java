package WebServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Plain old Java Object it does not extend as class or implements 
//an interface

//The class registers its methods for the HTTP GET request using the @GET annotation. 
//Using the @Produces annotation, it defines that it can deliver several MIME types,
//text, XML and HTML. 

//The browser requests per default the HTML MIME type.

//Sets the path to base URL + /localGDP/latValue/lngValue
//URL -> http://localhost:8000/week39GDPRESTAPI/rest/localGDP.[txt|xml|html|json]/latValue/lngValue

@Path("/")
public class LocalGDPService {

	// This method is called if TEXT_PLAIN is request
	@GET
	@Path("localGDP.txt/{lat}/{lng}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getGDPByLatLngTXT(@PathParam("lat") double lat,
			@PathParam("lng") double lng) {

		String gdpStr = "";
		Location loc = new Location(lat, lng);
		if (loc.isValidLocation()) {
			CountryCode CC = new CountryCode();
			CC.CalculateCountryCode(loc);
			gdpStr = gdpStr + "CountryCode = " + CC.getCountryCode();
			GDPByCountryCode gdp = new GDPByCountryCode();
			gdp.calculateGDPByCountryCode(CC);
			gdpStr = gdpStr + "\nGDP = " + gdp.getGdp();
		} else
			gdpStr = gdpStr + "Lat = " + lat + "\nLng = " + lng
					+ "\nAre Not Valid";

		return gdpStr;
	}

	// This method is called if TEXT_XML is request
	@GET
	@Path("localGDP.xml/{lat}/{lng}")
	@Produces(MediaType.TEXT_XML)
	public String getGDPByLatLngXML(@PathParam("lat") double lat,
			@PathParam("lng") double lng) {

		String gdpStr = "";
		Location loc = new Location(lat, lng);
		if (loc.isValidLocation()) {
			CountryCode CC = new CountryCode();
			CC.CalculateCountryCode(loc);
			GDPByCountryCode gdp = new GDPByCountryCode();
			gdp.calculateGDPByCountryCode(CC);
			gdpStr = gdpStr + "<?xml version=\"1.0\"?>\n";
			gdpStr = gdpStr + "<LocalGDP>\n";
			gdpStr = gdpStr + "<CountryCode>" + CC.getCountryCode()
					+ "</CountryCode>\n";
			gdpStr = gdpStr + "<GDP>" + gdp.getGdp() + "</GDP>\n";
			gdpStr = gdpStr + "</LocalGDP>";
		} else {
			gdpStr = gdpStr + "<?xml version=\"1.0\"?>\n";
			gdpStr = gdpStr + "<LocalGDP>\n";
			gdpStr = gdpStr + "<CountryCode>ZERO_RESULTS</CountryCode>\n";
			gdpStr = gdpStr + "<GDP>ZERO_RESULTS</GDP>\n";
			gdpStr = gdpStr + "</LocalGDP>";
		}

		return gdpStr;
	}

	// This method is called if TEXT_HTML is request
	@GET
	@Path("localGDP.html/{lat}/{lng}")
	@Produces(MediaType.TEXT_HTML)
	public String getGDPByLatLngHTML(@PathParam("lat") double lat,
			@PathParam("lng") double lng) {

		String gdpStr = "";
		Location loc = new Location(lat, lng);
		if (loc.isValidLocation()) {
			CountryCode CC = new CountryCode();
			CC.CalculateCountryCode(loc);
			GDPByCountryCode gdp = new GDPByCountryCode();
			gdp.calculateGDPByCountryCode(CC);
			gdpStr = gdpStr + "<html>\n";
			gdpStr = gdpStr + "<title>LocalGDP</title>\n";
			gdpStr = gdpStr + "<body>\n";
			gdpStr = gdpStr + "<p>\n";
			gdpStr = gdpStr + "CountryCode = " + CC.getCountryCode() + "\n";
			gdpStr = gdpStr + "</p>\n";
			gdpStr = gdpStr + "<p>\n";
			gdpStr = gdpStr + "GDP = " + gdp.getGdp() + "\n";
			gdpStr = gdpStr + "</p>";
			gdpStr = gdpStr + "</body>";
			gdpStr = gdpStr + "</html>";
		} else {
			gdpStr = gdpStr + "<html>\n";
			gdpStr = gdpStr + "<title>LocalGDP</title>\n";
			gdpStr = gdpStr + "<body>\n";
			gdpStr = gdpStr + "<p>\n";
			gdpStr = gdpStr + "CountryCode = ZERO_RESULTS\n";
			gdpStr = gdpStr + "</p>";
			gdpStr = gdpStr + "<p>\n";
			gdpStr = gdpStr + "GDP = ZERO_RESULTS\n";
			gdpStr = gdpStr + "</p>";
			gdpStr = gdpStr + "</body>";
			gdpStr = gdpStr + "</html>";
		}

		return gdpStr;
	}

	// This method is called if TEXT_JSON is request
	@GET
	@Path("localGDP.json/{lat}/{lng}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getGDPByLatLngJSON(@PathParam("lat") double lat,
			@PathParam("lng") double lng) {

		String gdpStr = "";
		Location loc = new Location(lat, lng);
		if (loc.isValidLocation()) {
			CountryCode CC = new CountryCode();
			CC.CalculateCountryCode(loc);
			GDPByCountryCode gdp = new GDPByCountryCode();
			gdp.calculateGDPByCountryCode(CC);
			gdpStr = gdpStr + "{\n";
			gdpStr = gdpStr + "\t\"LocalGDP\" : {\n";
			gdpStr = gdpStr + "\t\t\"CountryCode\" : \"" + CC.getCountryCode() + "\",\n";
			gdpStr = gdpStr + "\t\t\"GDP\" : " + gdp.getGdp() + "\n";
			gdpStr = gdpStr + "\t}\n";
			gdpStr = gdpStr + "}\n";
		} else {
			gdpStr = gdpStr + "{\n";
			gdpStr = gdpStr + "\t\"LocalGDP\" : {\n";
			gdpStr = gdpStr + "\t\t\"CountryCode\" : \"" + "ZERO_RESULTS" + "\",\n";
			gdpStr = gdpStr + "\t\t\"GDP\" : " + "ZERO_RESULTS" + "\n";
			gdpStr = gdpStr + "\t}\n";
			gdpStr = gdpStr + "}\n";
		}

		return gdpStr;
	}
}
