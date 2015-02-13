import sun.misc.Unsafe;
import java.lang.reflect.Field;

public class ObjectLocation {
	
	private static int apple = 10000;
	private int orange = 10000;
	private int tree = 10000;

	public static void main(String[] args) throws Exception {
		Unsafe unsafe = getUnsafeInstance();

		Field appleField = ObjectLocation.class.getDeclaredField("apple");
		System.out.println("Location of Apple: "
				+ unsafe.staticFieldOffset(appleField));

		Field orangeField = ObjectLocation.class.getDeclaredField("orange");
		System.out.println("Location of Orange: "
				+ unsafe.objectFieldOffset(orangeField));
		
		Field treeField = ObjectLocation.class.getDeclaredField("tree");
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
