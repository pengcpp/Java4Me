package design.proxy;

public class DynamicRealSubject implements DynamicSubject{

	@Override
	public void dealTask(String taskName) {
		System.out.println("正在执行任务：" + taskName);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
