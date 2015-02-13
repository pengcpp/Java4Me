package enumsay;

import java.util.EnumMap;

import static enumsay.FSMInput.*;

/**
 * 自动售货机State
 */
public enum FSMState {

	/** 放入钞票 **/
	MONEY(NICKEL, DIME, QUARTER, DOLLAR),

	/** 选择商品 **/
	ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),

	/** 退出 **/
	QUIT_TRANSACTION(ABORT_TRANSACTION),

	/** 关机 **/
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

	/** 初始化自动售货机状态集合**/
	static {
		for (FSMState c : FSMState.class.getEnumConstants()) {
			for (FSMInput input : c.values) {
				categories.put(input, c);
			}
		}
	}

	/** 返回该操作项所属状态 **/
	public static FSMState categorize(FSMInput input) {
		return categories.get(input);
	}
}
