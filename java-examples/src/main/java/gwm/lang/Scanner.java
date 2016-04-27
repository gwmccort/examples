package gwm.lang;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.stream.Stream;

import com.google.common.reflect.ClassPath;

/**
 * 
 * @see <a href=
 *      "https://www.javacodegeeks.com/2016/04/parameterless-generic-method-antipattern.html">
 *      The Parameterless Generic Method Antipattern</a>
 * @see <a href=
 *      "http://stackoverflow.com/questions/36402646/generic-return-type-upper-bound-interface-vs-class-surprisingly-valid-code">
 *      stackoverflow generic return type</a>
 * 
 * @author Glen
 *
 */
public class Scanner {

	public static void main(String[] args) throws Exception {
		ClassPath.from(Thread.currentThread().getContextClassLoader()).getTopLevelClasses().stream().filter(
				info -> !info.getPackageName().startsWith("slick") && !info.getPackageName().startsWith("scala"))
				.flatMap(info -> {
					try {
						return Stream.of(info.load());
					} catch (Throwable ignore) {
						return Stream.empty();
					}
				}).flatMap(c -> {
					try {
						return Stream.of(c.getMethods());
					} catch (Throwable ignore) {
						return Stream.<Method> of();
					}
				}).filter(m -> m.getTypeParameters().length > 0 && m.getParameterCount() == 0)
				.sorted(Comparator.comparing(Method::toString)).map(Method::toGenericString)
				.forEach(System.out::println);
	}
}