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
		 * EnumType.values() values()方法是编译器生成的static方法, 返回值是定义的enum类型的数组。
		 * 父类Enum没有这个方法， 类型强转后就会无法使用。 see {@link EnumType}...
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
	 * switch()参数可以使用enum
	 */
	private static void enumSwitch() {
		System.out.println("\n------");
		EnumType e = EnumType.SUN;
		switch (e) {
		case MON:
			System.out.println("今天是星期一，上班...");
			break;
		case TUE:
			System.out.println("今天是星期二，上班...");
			break;
		case WED:
			System.out.println("今天是星期三，上班...");
			break;
		default:
			System.out.println("今天放假！" + e.name());
			break;
		}
	}

	/**
	 * 自定义enum
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
