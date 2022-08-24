import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

public class RestAPI {

	public String submitRestAPIRequest(CourseFromJavaClass course) throws IOException {

		String iteratorResponse = "";
		String scheduleResponse = new String();
		String restEndPointURI = null;

		try {

			restEndPointURI = "";

			URL url = new URL(restEndPointURI);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");

			connection.setReadTimeout(300000);
			connection.setConnectTimeout(300000);

			Gson gson = new Gson();
			String jsonObject = gson.toJson(course);

			int responsecode = 0;

			try (DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream())) {
				dataOutputStream.write(jsonObject.getBytes());
			}

			responsecode = connection.getResponseCode();

			try (InputStream ins = responsecode >= 400 ? connection.getErrorStream() : connection.getInputStream();
					BufferedReader in = new BufferedReader(new InputStreamReader(ins))) {

				if (responsecode == 200) {

					while ((iteratorResponse = in.readLine()) != null) {
						iteratorResponse.toString();
						scheduleResponse += iteratorResponse;
					}

				}
				if (responsecode != 200) {
					throw new Exception();
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} finally {
		}

		return scheduleResponse;
	}

}
