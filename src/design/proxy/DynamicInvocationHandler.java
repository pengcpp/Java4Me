package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * ��̬�������Ӧ�ĵ��ô�������� 
 */ 
public class DynamicInvocationHandler implements InvocationHandler {

	// ���������һ��ί����Ķ�������
	private Object delegate;

	public DynamicInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		long startTime = System.currentTimeMillis();
		// ���÷�����ƽ�������ɸ�ί���ദ��Method��invoke����Object������Ϊ����ִ�н����
		method.invoke(delegate, args);
		long finishTime = System.currentTimeMillis();

		System.out.println("ִ�������ʱ" + (finishTime - startTime) + "����");

		return null;
	}

}
