package gwm.lang

/**
 * Using enum's for constant values
 *
 * @author gwmccort
 * @see <a href="https://tedvinke.wordpress.com/2016/04/14/2-rookie-java-constants-and-enums-pitfalls/">2 Rookie Java Constants and Enums Pitfalls</a>
 *
 */
class Person {
	/** gender constents using enum */
	enum Gender {
		/** male value */
		M,

		/** female value */
		F
	}

	String name
	Gender gender

	public static void main(String[] args) {
		Person p1 = new Person("glen", Gender.M)
		Person p2 = new Person("karen", Gender.F)
		println("p1:" + p1)
		println("p2:" + p2)
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + "]";
	}

	public Person(String name, Gender gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
}