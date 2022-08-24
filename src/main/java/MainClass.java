import java.io.IOException;

public class MainClass {

	public static void main(String abc[]) {

		CourseFromJavaClass courseFromJavaClass = new CourseFromJavaClass(4, "vaisul", "James");

		RestAPI restAPI = new RestAPI();
		try {
			restAPI.submitRestAPIRequest(courseFromJavaClass);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
