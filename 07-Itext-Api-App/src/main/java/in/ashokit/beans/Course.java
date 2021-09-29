package in.ashokit.beans;

public class Course {

	private String courseName;
	private String courseTiming;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseName, String courseTiming) {
		super();
		this.courseName = courseName;
		this.courseTiming = courseTiming;
	}

	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseTiming=" + courseTiming + "]";
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseTiming() {
		return courseTiming;
	}

	public void setCourseTiming(String courseTiming) {
		this.courseTiming = courseTiming;
	}

}
