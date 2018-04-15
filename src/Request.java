/* Assignment: CS1120 LA7 Course Registration System
 * Author: Jennifer N. Smith
 * Date: 4/14/18
 * Reference: LA7_Spring2018.docx (LA7 Instructions)
 */

/**
 * 
 * @author jennifersmith
 *
 */

public class Request implements Comparable<Request> {
	String studentName;
	String studentMajor;
	String studentLevel;
	String courseDept;
	int courseNumber;

	/**
	 * Constructs a request
	 * 
	 * @param studentName
	 *            Students name
	 * @param studentMajor
	 *            Students major
	 * @param studentLevel
	 *            Students level
	 * @param courseDept
	 *            Course department
	 * @param courseNumber
	 *            Course number
	 */
	public Request(String studentName, String studentMajor, String studentLevel,
			String courseDept, int courseNumber) {

		this.studentName = studentName;
		this.studentMajor = studentMajor;
		this.studentLevel = studentLevel.trim();
		this.courseDept = courseDept;
		this.courseNumber = courseNumber;
	}

	/**
	 * Ranks students requests
	 * 
	 * @return number of years to graduation (0 for seniors, 1 for juniors
	 *         etc.). This is determined from the student’s level – senior,
	 *         junior, etc. Favors computer science majors for computer science
	 *         classes.
	 * 
	 */

	public int yearsFromGraduation() {

		//jeremy A has 2 outputs but not in the example needs to rank non majors?
		if (studentLevel.equals("Senior")) {
			if (studentMajor.equals("CS")) {
				return 0;	
			}
			else {
				return 4; 
			}

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
		System.out.println("Invalid student level" + studentLevel);
		return -1;

	}

	/**
	 * 
	 */
	
	@Override
	public int compareTo(Request o) {
		int rank = Integer.compare(this.yearsFromGraduation(),
				((Request) o).yearsFromGraduation());
		return rank;
	}

}
