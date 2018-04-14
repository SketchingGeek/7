

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Course implements ICourse {
	// This is a comma-separated input file. 
	// Data stored in the file in order: courseDept, courseNumber, capacity (maximum number of students)
	String courseDept;
	int courseNumber;
	int capacity;
	//PriorityQueue<Request> requestQueue = new PriorityQueue<Request>();
	ArrayList <String> students = new ArrayList <String> ();
	
	public Course(String courseDept,int courseNumber,int capacity) { 
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
		this.capacity = capacity;
		
	}
	
	@Override
	public boolean isFull() {
		
		return (capacity == students.size());
	}

	@Override
	public void addStudent(String name) {
		students.add(name);
	}

	@Override
	public void printClassList() {
		System.out.println("\nClass List for "+courseDept+" "+courseNumber);
		for (String oneStudent:students) {
			System.out.println(oneStudent);
		}
	}

}
