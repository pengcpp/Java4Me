package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * ���ɶ�̬�������Ĺ���
 */
public class DynamicProxyFactory {

	// �ͻ�����ô˹���������ô������ �Կͻ�����˵���䲢��֪�����ص��Ǵ����������ί�������
	public static DynamicSubject getInstance() {

		DynamicSubject delegate = new DynamicRealSubject();
		InvocationHandler handler = new DynamicInvocationHandler(delegate);
		DynamicSubject proxy = null;
		
		proxy = (DynamicSubject) Proxy
				.newProxyInstance(delegate.getClass().getClassLoader(),
						delegate.getClass().getInterfaces(), handler);
		return proxy;
	}
}
