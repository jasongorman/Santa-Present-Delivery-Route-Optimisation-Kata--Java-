package com.codemanship.santa;
import static java.lang.Math.acos;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;

public class Location {	

	static final double RADIUS = 6371;

	private final double latitude;
	private final double longitude;

	public Location(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double distance(Location location) {
		double lat1 = toRadians(latitude);
		double lat2 = toRadians(location.latitude);
		double deltaLong = toRadians(location.longitude - longitude);
		return acos((sin(lat1) * sin(lat2)) + (cos(lat1) * cos(lat2) * cos(deltaLong) )) * RADIUS; 
		
	}

}
