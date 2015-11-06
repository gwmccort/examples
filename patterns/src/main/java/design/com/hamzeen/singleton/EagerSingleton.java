package design.com.hamzeen.singleton;

/**
 * from: https://dzone.com/articles/singleton-explained?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 * @author gwmccort
 *
 */
public class EagerSingleton {
	private static EagerSingleton ins = new EagerSingleton();

	public static EagerSingleton getInstance() {
		return ins;
	}

	private EagerSingleton() {
	}
}