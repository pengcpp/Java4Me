package design.proxy;

/**
 * ¶¯Ì¬´úÀí Demo
 *
 */
public class DynamicProxyMain {

	public static void main(String[] args) {

		DynamicSubject proxy = DynamicProxyFactory.getInstance();
		proxy.dealTask("DynamicProxyTask");
	}

}
