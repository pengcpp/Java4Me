package design.proxy;

/*
 * �ͻ�����ô˹���������ô�����󣬶Կͻ�����˵���䲢��֪�����ص��Ǵ����������ί�������  
 */
public class StaticSubjectFactory {

	public static StaticSubject getInstance() {
		return new StaticProxy(new StaticRealSubject());
	}
}
