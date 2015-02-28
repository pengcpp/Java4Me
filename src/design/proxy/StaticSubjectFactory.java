package design.proxy;

/*
 * 客户类调用此工厂方法获得代理对象，对客户类来说，其并不知道返回的是代理类对象还是委托类对象。  
 */
public class StaticSubjectFactory {

	public static StaticSubject getInstance() {
		return new StaticProxy(new StaticRealSubject());
	}
}
