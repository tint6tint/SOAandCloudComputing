package WebServices;

public class Location {
	private double lat;
	private double lng;
	
	public Location(){
		this.setLat(0.0);
		this.setLng(0.0);
	}
	
	public Location(double latitude, double longitude){
		this.setLat(latitude);
		this.setLng(longitude);
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public boolean isValidLocation(){
		if(this.getLat() >= -90.0 && this.getLat() <= 90.0)
			if(this.getLng() >= -180.0 && this.getLng() < 180)
				return true;
		return false;
	}
}
