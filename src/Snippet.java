/* Assignment: 
 * Author: Jennifer N. Smith
 * Date:
 * Reference: 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Snippet {
	public static void main(String[] args) throws IOException {
			PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
			ArrayList<Course> courses = new ArrayList<Course>();
			BufferedReader fileIn = new BufferedReader(new FileReader("course.txt"));
			BufferedReader fileIn1 = new BufferedReader(new FileReader("request.txt"));
			IController control = new Controller(requestQueue, courses, fileIn, fileIn1);
			control.readCourseFile();
			control.readRequestFile();
			control.processRequests();
			control.printClassList();
	}
	
	
}
