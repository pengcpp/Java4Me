package a;

/**
 * data structure...
 * 
 * @author Three 2/27/2015
 * 
 */
public class NoteDataStructure {
	
	/*
	 * Before Java 2...
	 * 
	 * --- ---
	 * BitSet - 实现了一组可以单独设置和清除的位或标志
	 * 
	 * 一个Bitset类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。
	 * 该类在处理一组布尔值的时候非常有用，你只需要给每个值赋值一"位"，然后对位进行适当的设置或清除，就可以对布尔值进行操作了。
	 * 
	 * --- ---
	 * Vector - 实现了一个动态数组。
	 * 
	 * Vector -> AbstractList -> AbstractCollection
	 * 和ArrayList和相似，但是两者是不同的：
	 * 		ArrayList会比Vector快，但他是非同步的，Vector是同步访问的，如果设计涉及到多线程，还是用Vector比较好一些; 
	 * 		Vector包含了许多传统的方法，这些方法不属于集合框架。
	 * 
	 * --- ---
	 * Stack - 是Vector的一个子类，LIFO。
	 * 
	 * 除了由Vector定义的所有方法，自己也定义了一些方法：
	 * 		boolean empty()  测试堆栈是否为空。
	 * 		Object peek()	查看堆栈顶部的对象，但不从堆栈中移除它。
	 * 		Object pop()	移除堆栈顶部的对象，并作为此函数的值返回该对象。
	 * 		Object push(Object element)	把项压入堆栈顶部。
	 * 		int search(Object element)	返回对象在堆栈中的位置，以 1 为基数。
	 * 
	 * --- ---
	 * Dictionary - 是一个抽象类，用来存储键/值对，作用和Map类相似。
	 * 
	 * Dictionary类已经过时了。在实际开发中，你可以实现Map接口来获取key/value的存储功能。
	 * 
	 * --- ---
	 * Hashtable - Dictionary具体的实现，synchronized。
	 * 
	 * Hashtable -> Dictionary
	 * Hashtable是原始的java.util的一部分， 是一个Dictionary具体的实现 。键/值对都不能为空，为空可用HashMap。
	 * 
	 * --- ---
	 * Properties 
	 *  
	 * Properties -> Hashtable -> Dictionary
	 * 表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
	 * Properties类被许多Java类使用。例如，在获取环境变量时它就作为System.getProperties()方法的返回值。
	 * 
	 */
	
	/*
	 * Java 集合框架
	 * 
	 * @see SetClass.png SetInterface.png
	 * 
	 * TODO...
	 * 
	 */

}
