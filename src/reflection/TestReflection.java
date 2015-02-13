package reflection;
public class TestReflection {

	/**
	 * Reflection ����
	 */
	public static void main(String[] args) {
		TestReflection clazz = new TestReflection();
		clazz.ClassCheck();
	}

	public boolean ClassCheck() {
		try {

			System.out.println("��һ�֣�ͨ���౾���ö���");
			Class<?> UserClass = this.getClass();
			System.out.println("��һ�ַ�ʽ�ɹ���������" + UserClass.toString() + "\n");

			System.out.println("�ڶ��֣�ͨ������ʵ����ȡ����");
			UserInfo ui = new UserInfo();
			UserClass = ui.getClass();
			Class<?> SubUserClass = UserClass.getSuperclass();
			System.out.println("�ڶ��ַ�ʽ�ɹ���������" + SubUserClass.toString() + "\n");

			System.out.println("�����֣�ͨ��������.class��ö���");
			Class<UserInfo> ForClass = UserInfo.class;
			System.out.println("�����ַ�ʽ�ɹ���������" + ForClass.toString() + "\n");

			System.out.println("�����֣�ͨ���������ַ�����ö���");
			Class<?> ForName = Class.forName("UserInfo");
			System.out.println("�����ַ�ʽ�ɹ���������" + ForName.toString() + "\n");

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}

}

class UserInfo {

	public UserInfo() {
	}

	private String name;

	public String getUserName() {
		return name;
	}

	public void setUserName(String userName) {
		this.name = userName;
	}

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}