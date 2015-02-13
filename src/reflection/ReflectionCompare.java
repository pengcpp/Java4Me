package reflection;
import java.io.Serializable;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * 
 * @author Three 12/16/2014
 * 
 * From:
 * 		http://blog.csdn.net/alivetime/article/details/6079946
 *	
 * 反射调用 写一些Java框架的时候，经常需要通过反射get或者set某个bean的field，
 * 比较普通的做法是获取field后调用java.lang.reflect.Field.get(Object)
 * unsafe的getXXX方法提供更快的访问速度...
 *
 */
public class ReflectionCompare {

	private static final int count = 100000000;
	
	private static final Unsafe unsafe;

	public static void main(String[] args) {
		
		long duration = testIntCommon();
		System.out.println("int common test for  " + count
				+ " times, duration: " + duration + "ms");
		
		duration = testUnsafe();
		System.out.println("int unsafe test for  " + count
				+ " times, duration: " + duration + "ms");
		
		
	}

	private static long testUnsafe() {
		long start = System.currentTimeMillis();
		Unsafe unsafe = getUnsafe();
		int temp = count;
		Field field = getIntField();
		long offset = unsafe.objectFieldOffset(field);
		while (temp-- > 0) {
			unsafe.getInt(new TestBean(), offset);
		}
		return System.currentTimeMillis() - start;
	}

	private static long testIntCommon() {
		long start = System.currentTimeMillis();
		int temp = count;
		getIntField().setAccessible(true);
		while (temp-- > 0) {
			TestBean bean = new TestBean();
			try {
				getIntField().get(bean);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return System.currentTimeMillis() - start;
	}

	
	static {
		Unsafe value = null;
		try {
			Class<?> clazz = Class.forName("sun.misc.Unsafe");
			Field field = clazz.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			value = (Unsafe) field.get(null);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("error to get theUnsafe", e);
		}
		unsafe = value;
	}

	public static final Unsafe getUnsafe() {
		return unsafe;
	}

	private static final Field intField;
	private static final Field stringField;
	static {
		try {
			intField = TestBean.class.getDeclaredField("age");
			stringField = TestBean.class.getDeclaredField("name");
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("failed to init testbean field", e);
		}
	}

	public static final Field getIntField() {
		return intField;
	}

	public static final Field getStringField() {
		return stringField;
	}

	/**
	 * 普通的对象get/set方法
	 */
	static class TestBean implements Serializable {
		
		private static final long serialVersionUID = -5994966479456252766L;

		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
