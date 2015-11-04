package design.com.hamzeen.singleton;

/**
 * from: https://dzone.com/articles/singleton-explained?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 * @author gwmccort
 *
 */
public class LazySingleton {
	private static LazySingleton ins;

	public static LazySingleton getInstance() {
		if (ins == null) {
			ins = new LazySingleton();
		}
		return ins;
	}

	private LazySingleton() {
	}
}