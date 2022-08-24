import java.util.Date;

public class CourseFromJavaClass {

	private long id;
	private String name;
	private Date birthDate;

	public CourseFromJavaClass(long id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "CourseFromJavaClass [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
