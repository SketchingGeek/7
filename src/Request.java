/* Assignment: CS1120 LA7 Course Registration System
 * Author: Jennifer N. Smith
 * Date: 4/14/18
 * Reference: LA7_Spring2018.docx (LA7 Instructions)
 */

public class Request implements Comparable <Request> {
	String studentName;
	String studentDept;
	String studentLevel;
	String courseDept;
	int courseNumber;
	
	// Constructor
	public Request(String studentName, String studentDept, String studentLevel,
				String courseDept, int courseNumber) {
		
		this.studentName = studentName;
		this.studentDept = studentDept;
		this.studentLevel = studentLevel.trim();
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
	}
	
	// Returns number of years to graduation (0 for seniors, 1 for juniors etc.). This is determined from the 
	// student’s level – senior, junior, etc.
	public int yearsFromGraduation() {
		if (studentLevel.equals("Senior")) {
			return 0;
			
		}
		if (studentLevel.equals("Junior")) {
			return 1;
			
		}
		if (studentLevel.equals("Sophmore")) {
			return 2;
			
		}
		if (studentLevel.equals("Freshman")) {
			return 3;
			
		}
		System.out.println("Invalid student level"+studentLevel);
		return -1;
		
	}

	@Override
	public int compareTo(Request o) {
		int rank = Integer.compare(this.yearsFromGraduation(),((Request)o).yearsFromGraduation());
		return rank;
	}



}
