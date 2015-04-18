public class GoEuroTest {

	public static void main(String[] args) {
		final String SERVICE_URL = "http://www.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/";
		final String LOCATIONS_FILE = "locations.csv";
		String query = "";
		if (query == null && args.length == 1) {
			query = args[0];
		}
		if (query == null) {
			System.out.println("Search string is missing.");
			return;
		}
		Location[] locations = LocationsTools.requestLocations(SERVICE_URL,
				query);
		if (locations == null) {

			return;
		} else {
			int resultsSize = locations.length;
			if (resultsSize == 0) {
				System.out
						.println("No results where found for query: " + query);
			} else {
				System.out.println(resultsSize
						+ " results where fonund for query: " + query);
				// System.out.println(Arrays.toString(locations));
				LocationsTools.locationsToCsv(LOCATIONS_FILE, locations);
			}
		}
	}
}
