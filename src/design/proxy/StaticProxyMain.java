package design.proxy;

/**
 * ��̬���� Demo
 *
 */
public class StaticProxyMain {

	public static void main(String[] args) {
		StaticSubject proxy = StaticSubjectFactory.getInstance();

		proxy.dealTask("StaticProxyTask");
	}

}
