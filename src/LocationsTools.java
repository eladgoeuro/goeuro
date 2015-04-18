import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class LocationsTools {

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String CSV_FILE_HEADER = "_type, _id, name, type, latitude, longitude";

	public static Location[] requestLocations(String url, String query) {
		Location[] locations = null;
		HttpResponse result = null;
		try (CloseableHttpClient httpClient = HttpClientBuilder.create()
				.build()) {
			HttpGet request = new HttpGet(url + query);
			result = httpClient.execute(request);
			int code = result.getStatusLine().getStatusCode();
			if (code == HttpStatus.SC_OK) {
				String json = EntityUtils.toString(result.getEntity(), "UTF-8");
				com.google.gson.Gson gson = new com.google.gson.Gson();
				locations = gson.fromJson(json, Location[].class);
			} else {
				System.out
						.println("Error while trying to get a response from server. "
								+ result.getStatusLine());
				return null;
			}

		} catch (UnknownHostException ex) {
			System.out.println("Unknown Host");
			return locations;
		}

		catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		return locations;
	}

	public static void locationsToCsv(String fileName, Location[] locations) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(fileName);
			// Write the CSV file header
			fileWriter.append(CSV_FILE_HEADER.toString());
			// Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			// Write a new student object list to the CSV file
			for (Location location : locations) {
				fileWriter.append(String.valueOf(location.get_type()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(location.get_id()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(location.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(location.getType());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(location.getGeo_position()
						.getLatitude()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(String.valueOf(location.getGeo_position()
						.getLongitude()));
				fileWriter.append(NEW_LINE_SEPARATOR);
			}
			System.out.println("Results where saved to file: " + fileName
					+ " successfully.");
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter!");
			System.out.println(e.getMessage());
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (Exception e) {
				System.out.println("Error while flushing/closing fileWriter!");
				System.out.println(e.getMessage());
			}
		}
	}
}
