public class ExtendedLocation extends Location {

	String key;
	String fullName;
	String iata_airport_code;
	String country;
	int location_id;
	boolean inEurope;
	String countryCode;
	boolean coreCountry;
	Integer distance;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIata_airport_code() {
		return iata_airport_code;
	}

	public void setIata_airport_code(String iata_airport_code) {
		this.iata_airport_code = iata_airport_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	public boolean isInEurope() {
		return inEurope;
	}

	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public boolean isCoreCountry() {
		return coreCountry;
	}

	public void setCoreCountry(boolean coreCountry) {
		this.coreCountry = coreCountry;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Response [_type=" + _type + ", _id=" + _id + ", key=" + key
				+ ", name=" + name + ", fullName=" + fullName
				+ ", iata_airport_code=" + iata_airport_code + ", type=" + type
				+ ", country=" + country + ", geo_position=" + geo_position
				+ ", location_id=" + location_id + ", inEurope=" + inEurope
				+ ", countryCode=" + countryCode + ", coreCountry="
				+ coreCountry + ", distance=" + distance + "]";
	}

}