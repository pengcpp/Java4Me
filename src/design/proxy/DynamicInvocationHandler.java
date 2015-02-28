package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/** 
 * 动态代理类对应的调用处理程序类 
 */ 
public class DynamicInvocationHandler implements InvocationHandler {

	// 代理类持有一个委托类的对象引用
	private Object delegate;

	public DynamicInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		long startTime = System.currentTimeMillis();
		// 利用反射机制将请求分派给委托类处理。Method的invoke返回Object对象作为方法执行结果。
		method.invoke(delegate, args);
		long finishTime = System.currentTimeMillis();

		System.out.println("执行任务耗时" + (finishTime - startTime) + "毫秒");

		return null;
	}

}
