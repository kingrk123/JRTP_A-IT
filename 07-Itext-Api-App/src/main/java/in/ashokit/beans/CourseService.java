package in.ashokit.beans;

import java.util.ArrayList;
import java.util.List;

public class CourseService {

	public List<Course> getCourses() {

		Course c1 = new Course("10-SBMS", "6:30 AM IST");
		Course c2 = new Course("09-SBMS", "7:45 AM IST");
		Course c3 = new Course("15-JRTP", "10:15 AM IST");
		Course c4 = new Course("16-JRTP", "11:45 AM IST");

		List<Course> courses = new ArrayList<>();
		courses.add(c1);
		courses.add(c2);
		courses.add(c3);
		courses.add(c4);

		return courses;

	}
}
