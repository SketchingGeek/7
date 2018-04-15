/* Assignment: CS1120 LA7 Course Registration System
 * Author: Jennifer N. Smith
 * Date: 4/14/18
 * Reference: LA7_Spring2018.docx (LA7 Instructions)
 */

/**
 * Class that models a student request
 * 
 * @author Jennifer Smith
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
	 * Returns number of years to graduation (0 for seniors, 1 for juniors
	 * etc.). This is determined from the student’s level – senior, junior, etc.
	 * 
	 * @return number of years to graduation (0 for seniors, 1 for juniors
	 *         etc.). This is determined from the student’s level – senior,
	 *         junior, etc.
	 * 
	 */

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
		System.out.println("Invalid student level" + studentLevel);
		return -1;

	}

	/**
	 * Compares the instance with the parameter. If instance and parameter have
	 * same major, return a comparison of the years from graduation. If the
	 * parameter has the same major as the course then return +5. If the
	 * instance has the same major as the course then return - 5. Otherwise
	 * return a comparison of the years to graduation.
	 * 
	 * @param o
	 *            request that this instance is being compared to
	 * @return negative numbers mean the instance is a higher priority then the
	 *         param
	 */

	@Override
	public int compareTo(Request o) {
		if (this.studentMajor.equals(o.studentMajor)) {
			int rank = Integer.compare(this.yearsFromGraduation(),
					((Request) o).yearsFromGraduation());

			return rank;

		}
		if (this.studentMajor.equals(this.courseDept)) {
			return -5;
		}
		if (o.studentMajor.equals(o.courseDept)) {
			return +5;
		}
		int rank = Integer.compare(this.yearsFromGraduation(),
				((Request) o).yearsFromGraduation());

		return rank;
	}

}
