
/**
 * 
 * @author Three
 * 
 * volatile note...
 * 
 * ȷ��ָ�������������Ż���ʡ�ԣ���Ҫ��ÿ��ֱ�Ӷ�ֵ����ֹ�������Դ�������Ż�...
 *
 */
public class VolatileSay {
	
	public static void main(String[] args) {
		System.out.println("VolatileSay...");
	}

	
	/*
	 * int a;
	 * a = 1;
	 * a = 2;
	 * a = 3;
	 * a = 4;
	 * ���ⲿӲ�����ԣ������������ֱ��ʾ��ͬ�Ĳ�������������ֲ�ͬ�Ķ��������Ǳ�����ȴ������������������Ż� ��Ϊa=4��
	 * volatile���κ� �Ż������õ��������ʱ����ÿ�ζ�С�ĵ����¶�ȡ���������ֵ��������ʹ�ñ����ڼĴ�����ı���
	 * 
	 */
	
	/*
	 * һ�������ȿ�����const��������volatile - ֻ����״̬�Ĵ���
	 * һ��ָ�������volatile - ��һ���жϷ����ӳ����޸�һ��ָ��һ��buffer��ָ��ʱ
	 * 
	 * for(int i=0;i<100000;i++); 
	 * ���Կ�ѭ�����ٶȵ�, ���Ǳ������϶�Ҫ�����Ż����������Ͳ�ִ��
	 * for(volatile int i=0;i<100000;i++);
	 * 
	 */
	
	/*
	 * һ��˵����volatile�������µļ����ط���
	 * 1���жϷ���������޸ĵĹ�����������ı�����Ҫ��volatile��
	 * 2�������񻷾��¸�����乲���ı�־Ӧ�ü�volatile��
	 * 3���洢��ӳ���Ӳ���Ĵ���ͨ��ҲҪ��volatile˵������Ϊÿ�ζ����Ķ�д�������в�ͬ���壻
	 * ���⣬�����⼸�����������Ҫͬʱ�������ݵ������ԣ��໥�����ļ�����־����һ�뱻�������д����
	 * ��1�п���ͨ�����ж���ʵ�֣�2 �п��Խ�ֹ������ȣ�3����ֻ������Ӳ������������ˡ� 
	 * 
	 * ������ȣ�Volatile������һ�ַǳ��򵥵�ͬʱ�ַǳ�������ͬ�����ƣ�����ĳЩ����½��ṩ�����������ܺ������ԡ�
	 * ����ϸ���ѭ volatile ��ʹ������   ���������������������������Լ���ǰ��ֵ 
	 * ��ĳЩ����¿���ʹ�� volatile ���� synchronized ���򻯴��롣
	 */
	
	/*	
	 * 
    int square(volatile int *ptr){
		return *ptr * *ptr;
	}
	����ʱ��
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
