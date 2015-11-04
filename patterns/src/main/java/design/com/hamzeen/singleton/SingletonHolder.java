package design.com.hamzeen.singleton;

/**
 * from: https://dzone.com/articles/singleton-explained?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 * @author gwmccort
 *
 */
public class SingletonHolder {
	public static SingletonHolder getInstance() {
		return Holder.ins;
	}

	private final static class Holder {
		private static final SingletonHolder ins = new SingletonHolder();
	}

	private SingletonHolder() {
	}
}