import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@ToString
@EqualsAndHashCode
class Person {
	String name
	int age

	static main(args) {
		println 'in main'
		println new Person()
		println new Person(name: 'glen', age: 54)
	}
}
