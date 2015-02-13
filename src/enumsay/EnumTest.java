package enumsay;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EnumTest {

	public static void main(String[] args) {

		enumTypePrint();
		enumSwitch();

		enumCustomTry();

		enumOperation();
	}

	private static void enumTypePrint() {
		System.out.println("EnumType.values().length..."
				+ EnumType.values().length);

		/**
		 * EnumType.values() values()�����Ǳ��������ɵ�static����, ����ֵ�Ƕ����enum���͵����顣
		 * ����Enumû����������� ����ǿת��ͻ��޷�ʹ�á� see {@link EnumType}...
		 */
		for (EnumType e : EnumType.values()) {
			e.printToday();
		}

		/**
		 * Class.getEnumConstants() Returns the elements of this enum class -
		 * T[]
		 */
		for (EnumType e : EnumType.class.getEnumConstants()) {
			e.printToday();
		}

		/**
		 * Class.getMethod()
		 */
		try {
			final Method values = EnumType.class.getMethod("values");
			// java.security.AccessController
			// .doPrivileged(new java.security.PrivilegedAction() {
			// public Object run() {
			// values.setAccessible(true);
			// return null;
			// }
			// });
			for (EnumType e : (EnumType[]) values.invoke(null)) {
				e.printToday();
			}
		} catch (IllegalArgumentException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
		}

	}

	/**
	 * switch()��������ʹ��enum
	 */
	private static void enumSwitch() {
		System.out.println("\n------");
		EnumType e = EnumType.SUN;
		switch (e) {
		case MON:
			System.out.println("����������һ���ϰ�...");
			break;
		case TUE:
			System.out.println("���������ڶ����ϰ�...");
			break;
		case WED:
			System.out.println("���������������ϰ�...");
			break;
		default:
			System.out.println("����ż٣�" + e.name());
			break;
		}
	}

	/**
	 * �Զ���enum
	 */
	private static void enumCustomTry() {
		for (EnumCustom e : EnumCustom.values()) {
			e.testNameMethod();
			System.out.println("\n" + e.toString());
		}
	}

	/**
	 * enum different behavior
	 */
	private static void enumOperation() {
		double x = Double.parseDouble("4");
		double y = Double.parseDouble("2");

		for (EnumOperation e : EnumOperation.values())
			System.out.printf("%f %s %f = %f%n", x, e, y, e.eval(x, y));
	}

}
