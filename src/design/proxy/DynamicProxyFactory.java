package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 生成动态代理对象的工厂
 */
public class DynamicProxyFactory {

	// 客户类调用此工厂方法获得代理对象。 对客户类来说，其并不知道返回的是代理类对象还是委托类对象。
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
