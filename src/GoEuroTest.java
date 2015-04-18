public class GoEuroTest {

	public static void main(String[] args) {
		final String SERVICE_URL = "http://www.goeuro.com/GoEuroAPI/rest/api/v2/position/suggest/en/";
		final String LOCATIONS_FILE = "locations.csv";
		if (args.length == 0) {
			System.out.println("Error: Search string is missing.");
			return;
		}
		String query = args[0].trim();
		if (query.length() == 0) {
			System.out.println("Error: Search string is empty.");
			return;
		}
		Location[] locations = LocationsTools.requestLocations(SERVICE_URL, query);
		if (locations == null) {
			System.out.println("Error occured while trying to search for " + query);
			return;
		} else {
			int resultsSize = locations.length;
			if (resultsSize == 0) {
				System.out.println("No results where found for search: " + query);
			} else {
				System.out.println(resultsSize + " results where fonund for search: " + query);
				LocationsTools.locationsToCsv(LOCATIONS_FILE, locations);
			}
		}
	}
}
