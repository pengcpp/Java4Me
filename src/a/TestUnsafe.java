package a;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * Unsafe 
 * 
 * 	提供了硬件级别的原子操作，非堵塞原子方式来减少线程调度开销
 * 
 * 	demo cory from internet... 
 * 	use {@link sun.misc.Unsafe} to get the class-field-offset...
 * 
 * @author Three 12/15/2014
 * @see Unsafe.docx
 */
public class TestUnsafe {

	private static int apple = 10000;

	private int orange = 10000;
	private int tree = 10000;

	public static void main(String[] args) throws Exception {
		Unsafe unsafe = getUnsafeInstance();

		Field appleField = TestUnsafe.class.getDeclaredField("apple");
		System.out.println("Location of Apple: "
				+ unsafe.staticFieldOffset(appleField));

		Field orangeField = TestUnsafe.class.getDeclaredField("orange");
		System.out.println("Location of Orange: "
				+ unsafe.objectFieldOffset(orangeField));

		Field treeField = TestUnsafe.class.getDeclaredField("tree");
		System.out.println("Location of Tree: "
				+ unsafe.objectFieldOffset(treeField));
	}

	private static Unsafe getUnsafeInstance() throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
		theUnsafeInstance.setAccessible(true);
		return (Unsafe) theUnsafeInstance.get(Unsafe.class);
	}
}
