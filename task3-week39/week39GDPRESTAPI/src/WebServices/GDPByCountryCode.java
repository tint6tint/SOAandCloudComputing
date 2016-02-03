package WebServices;

import GDPServices.GDP;
import GDPServices.GDPService;
import GDPServices.NoSuchCountryException_Exception;

public class GDPByCountryCode {
	private double gdp;
	
	public GDPByCountryCode(){
		this.setGdp(0.0);
	}

	public double getGdp() {
		return gdp;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}
	
	public void calculateGDPByCountryCode(CountryCode CC){
		if(!CC.getCountryCode().equals("ZERO_RESULTS")){
			GDPService service = new GDPService();
			GDP gdpPort = service.getGDPPort();
			
			try {
				double d = gdpPort.getGDP(CC.getCountryCode());
				this.setGdp(d);
			} catch (NoSuchCountryException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
