package design.proxy;

/**
 * ¾²Ì¬´úÀí Demo
 *
 */
public class StaticProxyMain {

	public static void main(String[] args) {
		StaticSubject proxy = StaticSubjectFactory.getInstance();

		proxy.dealTask("StaticProxyTask");
	}

}
