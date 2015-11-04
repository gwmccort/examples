package design.com.hamzeen.singleton;

/**
 * from: https://dzone.com/articles/singleton-explained?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 * @author gwmccort
 *
 */
public abstract class Driver {
	public static void main(String[] args) {
		EagerSingleton a1 = EagerSingleton.getInstance();
		EagerSingleton a2 = EagerSingleton.getInstance();
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		LazySingleton b1 = LazySingleton.getInstance();
		LazySingleton b2 = LazySingleton.getInstance();
		System.out.println(b1.toString());
		System.out.println(b2.toString());
		SingletonHolder c1 = SingletonHolder.getInstance();
		SingletonHolder c2 = SingletonHolder.getInstance();
		System.out.println(c1.toString());
		System.out.println(c2.toString());
	}
}