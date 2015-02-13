package enumsay;

import java.util.Random;

/**
 * �Զ��ۻ��� Input 
 * 	���Խ��յĳ�Ʊ����������Ʒ�ļ۸�
 */
public enum FSMInput {

	/** ���Ӳ�� **/
	NICKEL(5),
	/** һ��Ӳ�� **/
	DIME(10),
	/** ������� **/
	QUARTER(25),
	/** һ������ **/
	DOLLAR(100),

	/** ҩ��2Ԫ **/
	TOOTHPASTE(200),
	/** ը����75���� **/
	CHIPS(75),
	/** �մ�ˮ1Ԫ **/
	SODA(100), //
	/** ����5ë **/
	SOAP(50),

	ABORT_TRANSACTION {
		public int amount() {
			throw new RuntimeException("�˳�ʱ���ܻ�ȡ��");
		}
	},
	STOP {
		public int amount() {
			throw new RuntimeException("�ػ�ʱ���ܻ�ȡ��");
		}
	};

	// ���
	private int value;

	private FSMInput(int value) {
		this.value = value;
	}

	private FSMInput() {
	}

	// ���ظò�����Ľ��
	int amount() {
		return value;
	}

	/**
	 * @return �����ȡ�Ĳ���
	 */
	public static FSMInput randomSelection() {
		return values()[new Random(System.nanoTime()).nextInt(values().length)];
	}
}
