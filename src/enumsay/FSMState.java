package enumsay;

import java.util.EnumMap;

import static enumsay.FSMInput.*;

/**
 * �Զ��ۻ���State
 */
public enum FSMState {

	/** ���볮Ʊ **/
	MONEY(NICKEL, DIME, QUARTER, DOLLAR),

	/** ѡ����Ʒ **/
	ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),

	/** �˳� **/
	QUIT_TRANSACTION(ABORT_TRANSACTION),

	/** �ػ� **/
	SHUT_DOWN(STOP);

	private FSMInput[] values;

	private FSMState(FSMInput... types) {
		this.values = types;
	}

	public static EnumMap<FSMInput, FSMState> categories = new EnumMap<FSMInput, FSMState>(
			FSMInput.class);

	public FSMInput[] getValues() {
		return values;
	}

	/** ��ʼ���Զ��ۻ���״̬����**/
	static {
		for (FSMState c : FSMState.class.getEnumConstants()) {
			for (FSMInput input : c.values) {
				categories.put(input, c);
			}
		}
	}

	/** ���ظò���������״̬ **/
	public static FSMState categorize(FSMInput input) {
		return categories.get(input);
	}
}
