public class Location {
	String _type;
	int _id;
	String name;
	Position geo_position;
	String type;

	public String get_type() {
		if (_type == null)
			return "";
		return _type;
	}

	public void set_type(String _type) {
		this._type = _type;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getName() {
		if (name == null)
			return "";
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		if (type == null)
			return "";
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Position getGeo_position() {
		return geo_position;
	}

	public void setGeo_position(Position geo_position) {
		this.geo_position = geo_position;
	}

	@Override
	public String toString() {
		return "Response [_type=" + _type + ", _id=" + _id + ", name=" + name
				+ ", geo_position=" + geo_position + ", type=" + type + "]";
	}

}