package a;

/**
 * 
 * 关键字 volatile note...
 * 
 * 确保指令不会因编译器的优化而省略，且要求每次直接读值，防止编译器对代码进行优化...
 * 
 * @author Three 12/15/2014
 *
 */
public class NoteVolatile {
	
	public static void main(String[] args) {
		System.out.println("NoteVolatile...");
	}

	
	/*
	 * int a;
	 * a = 1;
	 * a = 2;
	 * a = 3;
	 * a = 4;
	 * 对外部硬件而言，上述四条语句分别表示不同的操作，会产生四种不同的动作，但是编译器却会对上述四条语句进行优化 认为a=4。
	 * volatile修饰后 优化器在用到这个变量时必须每次都小心地重新读取这个变量的值，而不是使用保存在寄存器里的备份
	 * 
	 */
	
	/*
	 * 一个参数既可以是const还可以是volatile - 只读的状态寄存器
	 * 一个指针可以是volatile - 当一个中断服务子程序修改一个指向一个buffer的指针时
	 * 
	 * for(int i=0;i<100000;i++); 
	 * 测试空循环的速度的, 但是编译器肯定要把它优化掉，根本就不执行
	 * for(volatile int i=0;i<100000;i++);
	 * 
	 */
	
	/*
	 * 一般说来，volatile用在如下的几个地方：
	 * 1、中断服务程序中修改的供其它程序检测的变量需要加volatile；
	 * 2、多任务环境下各任务间共享的标志应该加volatile；
	 * 3、存储器映射的硬件寄存器通常也要加volatile说明，因为每次对它的读写都可能有不同意义；
	 * 另外，以上这几种情况经常还要同时考虑数据的完整性（相互关联的几个标志读了一半被打断了重写），
	 * 在1中可以通过关中断来实现，2 中可以禁止任务调度，3中则只能依靠硬件的良好设计了。 
	 * 
	 * 与锁相比，Volatile变量是一种非常简单但同时又非常脆弱的同步机制，它在某些情况下将提供优于锁的性能和伸缩性。
	 * 如果严格遵循 volatile 的使用条件   即变量真正独立于其他变量和自己以前的值 
	 * 在某些情况下可以使用 volatile 代替 synchronized 来简化代码。
	 */
	
	/*	
	 * 
    int square(volatile int *ptr){
		return *ptr * *ptr;
	}
	编译时：
	int square(volatile int *ptr){
		int a,b;
		a=*ptr;
		b=*ptr;
		return a*b;
	}
	We need:
	long square(volatile int*ptr){
		int a;
		a=*ptr;
		return a*a;
	}
	*/
	
}

