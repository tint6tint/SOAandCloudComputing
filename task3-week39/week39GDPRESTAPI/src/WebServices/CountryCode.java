package WebServices;

import GeocodingAPI.GeocodingService;

public class CountryCode {
	private String countryCode;
	
	public CountryCode(){
		this.setCountryCode("ZERO_RESULTS");
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public void CalculateCountryCode(Location loc){
		String CC = GeocodingService.httpGetCC(loc.getLat(), loc.getLng());
		this.setCountryCode(CC);
	}
}
