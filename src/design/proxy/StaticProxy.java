package design.proxy;

public class StaticProxy implements StaticSubject {

	// 代理类持有一个委托类的对象引用
	private StaticSubject delegate;

	public StaticProxy(StaticSubject delegate) {
		this.delegate = delegate;
	}

	@Override
	public void dealTask(String taskName) {

		long startTime = System.currentTimeMillis();
		delegate.dealTask(taskName);
		long finishTime = System.currentTimeMillis();

		System.out.println("执行任务:" + taskName + "耗时" + (finishTime - startTime)
				+ "毫秒");
	}

}
