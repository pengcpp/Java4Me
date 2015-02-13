package reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Reflection 是Java被视为动态(或准动态)语言的一个关键性质 这个机制允许程序在运行时透过Reflection
 * APIs取得任何一个已知名称的class的内部信息 如 Modifier(public, static...) Superclass(Object)
 * Interface(Cloneable) Field(...) Method(...) 可于运行时改变fields内容或唤起methods
 * 
 * @author Three 12/15/2014
 */
public class ReflectionMain {

	/** Constructor */
	public ReflectionMain() {
	}

	public ReflectionMain(int i) {
		System.out.println("i = " + i);
	}

	/** Filed */
	private double d = 0.2;
	public static final int i = 12;
	String s = "Testing";

	/** Method */
	public static void main(String args[]) {

		// getMethod();
		// getNewInstance();
		// getConstructor();
		// getInterface();
		// getField();
		// getFieldValue();

		// doMethodWithName();
		// doCreateNewObjWithConstructor();
		// doChangeTheFieldValue();
		// doSthWithArray();

		// getMethodDetail();

		new ReflectionMain().doClassCheck();
	}

	public static void getMethod() {
		try {
			// 三种获取 Class方式
			Class<?> c = Class.forName("java.lang.Integer");
			// Class<?> d = int.class;
			// Class<?> e = Integer.TYPE;
			Method m[] = c.getDeclaredMethods();

			for (int i = 0; i < m.length; i++)
				System.out.println(m[i].toString());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getNewInstance() {
		Bean a = new Bean();
		try {
			Class<?> cls = Class.forName("reflection.Bean");
			boolean b1 = cls.isInstance(new Integer(1));
			System.out.println(b1);
			boolean b2 = cls.isInstance(a); // a是Bean的一个实例
			System.out.println(b2);
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getConstructor() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Constructor<?> ctorlist[] = cls.getDeclaredConstructors();
			for (int i = 0; i < ctorlist.length; i++) {
				Constructor<?> ct = ctorlist[i];
				System.out.println("name = " + ct.getName());
				System.out.println("decl class = " + ct.getDeclaringClass());
				Class<?> pvec[] = ct.getParameterTypes();
				for (int j = 0; j < pvec.length; j++)
					System.out.println("param #" + j + " " + pvec[j]);
				Class<?> evec[] = ct.getExceptionTypes();
				for (int j = 0; j < evec.length; j++)
					System.out.println("exc #" + j + " " + evec[j]);
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getInterface() {
		try {
			Class<?> cls = Class.forName("java.lang.Boolean");
			Class<?>[] ctorlist = cls.getInterfaces();
			for (int i = 0; i < ctorlist.length; i++) {
				Class<?> ct = ctorlist[i];
				System.out.println("name = " + ct.getName());
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getField() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Field fieldList[] = cls.getDeclaredFields();
			// Field fieldList[] = cls.getFields();
			for (int i = 0; i < fieldList.length; i++) {
				Field field = fieldList[i];
				System.out.println("name = " + field.getName());
				System.out.println("decl class = " + field.getDeclaringClass());
				System.out.println("type = " + field.getType());
				int mod = field.getModifiers();
				System.out.println("modifiers = " + Modifier.toString(mod));
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	public static void getFieldValue() {
		try {
			ReflectionMain clsObj = new ReflectionMain();
			Field f1 = clsObj.getClass().getDeclaredField("d");
			f1.setAccessible(true); // get private
			double dou = (Double) f1.get(clsObj);
			System.out.println("Field d = " + dou);

			Field f2 = clsObj.getClass().getDeclaredField("i");
			int i = (Integer) f2.get(clsObj);
			System.out.println("Field i = " + i);

			Field f3 = clsObj.getClass().getDeclaredField("s");
			f3.setAccessible(true);
			String str = (String) f3.get(clsObj);
			System.out.println("Field s = " + str);
		} catch (Throwable e) {

		}
	}

	public static void getMethodDetail() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Method methlist[] = cls.getDeclaredMethods();
			for (int i = 0; i < methlist.length; i++) {
				Method m = methlist[i];
				System.out.println("name = " + m.getName());
				System.out
						.println("declaring class = " + m.getDeclaringClass());
				Class<?> param[] = m.getParameterTypes();
				for (int j = 0; j < param.length; j++)
					System.out.println("parameterType # " + j + " " + param[j]);

				Class<?> evec[] = m.getExceptionTypes();
				for (int j = 0; j < evec.length; j++)
					System.out.println("exceptionType # " + j + " " + evec[j]);
				System.out.println("return type = " + m.getReturnType());
				System.out.println("-----");
			}
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	/**
	 * {@link Method#invoke(Object obj, Object... args)} 执行方法
	 */
	public static void doMethodWithName() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Class<?> paraTypes[] = new Class[2];
			paraTypes[0] = Integer.TYPE;
			paraTypes[1] = Integer.TYPE;

			Method method = cls.getMethod("add", paraTypes);
			ReflectionMain methObj = new ReflectionMain();
			Object argList[] = new Object[2];
			argList[0] = new Integer(14);
			argList[1] = new Integer(41);
			Object retObj = method.invoke(methObj, argList);
			Integer retval = (Integer) retObj;
			System.out.println(retval.intValue());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	/**
	 * 根据指定的参数类型找到相应的构造函数并执行它，以创建一个新的对象实例。 使用这种方法可以在程序运行时动态地创建对象，而不是在编译的时候创建对象
	 */
	public static void doCreateNewObjWithConstructor() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Class<?> paraTypes[] = new Class[1];
			paraTypes[0] = Integer.TYPE;
			Constructor<?> ct = cls.getConstructor(paraTypes);
			Object argList[] = new Object[1];
			argList[0] = new Integer(7);
			Object retObj = ct.newInstance(argList);
			System.out.println(retObj.getClass().getName());
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	/**
	 * 改变对象数据字段的值
	 */
	public static void doChangeTheFieldValue() {
		try {
			Class<?> cls = Class.forName("reflection.refMain");
			Field field = cls.getDeclaredField("d");
			// Field field = cls.getFields("d"); 不能读取private
			ReflectionMain clsObj = new ReflectionMain();
			System.out.println("d = " + clsObj.d);
			field.setDouble(clsObj, 12.34);
			System.out.println("d = " + clsObj.d);
		} catch (Throwable e) {
			System.err.println(e);
		}
	}

	/**
	 * 数组操作
	 */
	public static void doSthWithArray() {
		try {
			Class<?> cls = Class.forName("java.lang.String");
			Object array = Array.newInstance(cls, 10);
			Array.set(array, 5, "it's a test");
			String str = (String) Array.get(array, 5);
			System.out.println(str);
		} catch (Throwable e) {
			System.err.println(e);
		}

		{
			int dims[] = new int[] { 5, 10, 15 };
			Object array = Array.newInstance(Integer.TYPE, dims); // Array.multiNewArray()...native
			Object arrayObj = Array.get(array, 3);
			Class<?> cls = arrayObj.getClass().getComponentType();
			System.out.println(cls); // [I
			arrayObj = Array.get(arrayObj, 5);
			Array.setInt(arrayObj, 10, 37);
			int arrcast[][][] = (int[][][]) array;
			System.out.println(arrcast[3][5][10]);
		}
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public boolean doClassCheck() {
		try {
			System.out.println("第一种，通过类本身获得对象");
			Class<?> UserClass = this.getClass();
			System.out.println("第一种方式成功！类名：" + UserClass.toString() + "\n");

			System.out.println("第二种，通过子类实例获取父类");
			UserInfo ui = new UserInfo();
			UserClass = ui.getClass();
			Class<?> SubUserClass = UserClass.getSuperclass();
			System.out.println("第二种方式成功！类名：" + SubUserClass.toString() + "\n");

			System.out.println("第三种，通过类名加.class获得对象");
			Class<UserInfo> ForClass = UserInfo.class;
			System.out.println("第三种方式成功！类名：" + ForClass.toString() + "\n");

			System.out.println("第四种，通过类名的字符串获得对象");
			Class<?> ForName = Class.forName("reflection.UserInfo");
			System.out.println("第四种方式成功！类名：" + ForName.toString() + "\n");

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

// Just test, has nothing...
class Bean {
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
