
/* Assignment: CS1120 LA7 Course Registration System
 * Author: Jennifer N. Smith
 * Date: 4/14/18
 * Reference: LA7_Spring2018.docx (LA7 Instructions)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * Manages courses and student requests
 * 
 * @author Jennifer Smith
 *
 */

public class Controller implements IController {

	PriorityQueue<Request> requestQueue;
	ArrayList<Course> courses;
	BufferedReader fileIn;
	BufferedReader fileIn1;

	/**
	 * Constructs a controller
	 * 
	 * @param requestQueue
	 *            priority queue to be populated with student requests
	 * @param courses
	 *            list of courses
	 * @param fileIn
	 *            buffered reader for student request
	 * @param fileIn1
	 *            buffered reader for courses
	 */
	public Controller(PriorityQueue<Request> requestQueue,
			ArrayList<Course> courses, BufferedReader fileIn,
			BufferedReader fileIn1) {

		this.requestQueue = requestQueue;
		this.courses = courses;
		this.fileIn = fileIn;
		this.fileIn1 = fileIn1;
	}

	/**
	 * Read courses from input file and add each course to an arraylist of
	 * courses. Close file.
	 */

	@Override
	public void readCourseFile() {

		String thisLine;

		try {
			while ((thisLine = fileIn1.readLine()) != null) {
				String fields[] = thisLine.split(",");

				if (fields.length == 5) {
					int num = Integer.parseInt(fields[4]);
					Request req = new Request(fields[0], fields[2], fields[1],
							fields[3], num);
					addRequest(req);
				} else {
					System.out.println("Error parsing line " + thisLine);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Read each request from the request input file and use it to create a
	 * Request object.
	 */

	@Override
	public void readRequestFile() {
		String thisLine;

		try {
			while ((thisLine = fileIn.readLine()) != null) {
				System.out.println(thisLine);
				String fields[] = thisLine.split(",");

				if (fields.length == 3) {
					int cap = Integer.parseInt(fields[2]);
					int num = Integer.parseInt(fields[1]);

					Course course = new Course(fields[0], num, cap);
					courses.add(course);

				} else {
					System.out.println("Error parsing line " + thisLine);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Store the request object in the requests priority queue.
	 */

	@Override
	public void addRequest(Request req) {
		requestQueue.enqueue(req);

	}

	/**
	 * Process all the requests as follows: if request can be granted, update
	 * the relevant classlist, update the class/course capacity, print out a
	 * message that the student who made that request has been successfully
	 * registered for that course. Else, print out a message that student could
	 * not be registered.
	 */

	@Override
	public void processRequests() {

		while (!requestQueue.isEmpty()) {
			Request req = requestQueue.dequeue();
			System.out.println(req + " processed.");
			Course course = getCourse(req.courseDept, req.courseNumber);
			if (course == null) {
				System.out.println("Requested course not found");

			} else {
				if (course.isFull()) {
					System.out.println(req.studentName + " cannot register for "
							+ req.courseDept + " " + req.courseNumber);
				} else {
					course.addStudent(req.studentName);
					System.out.println(
							req.studentName + " successfully registered "
									+ req.courseDept + " " + req.courseNumber);
				}
			}

		}
	}

	@Override
	/**
	 * Return the course object with data values that match the parameters
	 * received.
	 * @param courseDept course department
	 * @param courseNumber course number
	 * @return course object with data values that match the parameters
	 * received.
	 */
	public Course getCourse(String courseDept, int courseNumber) {

		for (Course oneCourse : courses) {
			if (courseDept.equals(oneCourse.courseDept)
					&& courseNumber == oneCourse.courseNumber) {

				return oneCourse;
			}
		}
		return null;
	}

	@Override
	/**
	 * Print classlists for all courses.
	 */
	public void printClassList() {

		for (Course oneCourse : courses) {
			oneCourse.printClassList();
		}

	}

}
