package design.proxy;

public class StaticRealSubject implements StaticSubject {

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
