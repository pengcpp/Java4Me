package design.proxy;

public class StaticProxy implements StaticSubject {

	// ���������һ��ί����Ķ�������
	private StaticSubject delegate;

	public StaticProxy(StaticSubject delegate) {
		this.delegate = delegate;
	}

	@Override
	public void dealTask(String taskName) {

		long startTime = System.currentTimeMillis();
		delegate.dealTask(taskName);
		long finishTime = System.currentTimeMillis();

		System.out.println("ִ������:" + taskName + "��ʱ" + (finishTime - startTime)
				+ "����");
	}

}
