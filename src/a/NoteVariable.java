package a;

/**
 * 
 * Variable 变量
 * 
 * @author Three 2/25/2015
 * 
 */
public class NoteVariable {

	/*
	 * Java语言支持的变量类型有： 局部变量、实例变量、类变量
	 * 
	 * 局部变量: 访问修饰符不能用于局部变量;局部变量是在栈上分配的;局部变量没有默认值，声明后必须经过初始化，才可以使用
	 * 
	 * 实例变量: 储存在堆区中;生命周期取决于实例的生命周期;在对象创建的时候创建，在对象被销毁的时候销毁;访问修饰符可以修饰实例变量;量具有默认值
	 * 
	 * 类变量(静态变量): 储存在静态存储区;生命周期取决于类的生命周期;无论一个类创建了多少个对象，类只拥有类变量的一份拷贝;
	 * 
	 * Notes:
	 * 	成员变量 = 实例变量 + 静态变量
	 * 
	 * 
	 * Java中，可以使用访问控制符来保护对类、变量、方法和构造方法的访问。Java支持4种不同的访问权限。
	 * 
	 * 默认的，也称为default，在同一包内可见，不使用任何修饰符。
	 * 
	 * 私有的，以private修饰符指定，在同一类内可见。
	 * 
	 * 共有的，以public修饰符指定，对所有类可见。
	 * 
	 * 受保护的，以protected修饰符指定，对同一包内的类和所有子类可见。
	 * 
	 * Notes: 
	 * 	父类中声明为protected的方法在子类中要么声明为protected，要么声明为public，不能声明为private。
	 * 	父类中默认修饰符声明的方法，能够在子类中声明为private。
	 * 
	 * 
	 */

	public static void main(String args[]) {

		int a = 0;
		System.out.println("NoteVariable..." + " a=" + a);
	}
}
