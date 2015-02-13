package enumsay;

import static enumsay.FSMState.*;

/**
 * �Զ��ۻ��� Machine
 */
public class FSMMachine {

	// ��ǰ����״̬
	private static State state = State.RESTING;
	// ��ǰ���
	private static int amount = 0;
	// ��ǰѡ����Ʒ
	private static FSMInput selection = null;

	/** ����״̬���������������� **/
	enum StateDuration {
		TRANSIENT
	}

	/**
	 * ����״̬
	 */
	enum State {
		/** ��ʼ���� **/
		RESTING {
			void next(FSMInput input) {
				switch (FSMState.categorize(input)) {
				case MONEY:
					amount += input.amount();
					System.out.println("�����" + input.amount() + "����");
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
					break;
				default:
					state = RESTING;
					break;
				}
			}
		},
		/** ѡ����Ʒ **/
		ADDING_MONEY {
			void next(FSMInput input) {
				switch (FSMState.categorize(input)) {
				case MONEY:
					amount += input.amount();
					System.out.println("�ٴη����" + input.amount() + "���֣���������ǣ�"
							+ amount + "����");
					break;
				case ITEM_SELECTION:
					selection = input;
					System.out.println("ѡ����Ʒ��" + input);
					if (amount < input.amount()) {
						System.out.println("�������������Ʒ��" + input);
						state = ADDING_MONEY;
					} else
						state = DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = GIVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
					break;
				default:
					state = ADDING_MONEY;
					break;
				}
			}
		},
		/** ������Ʒ�����׳ɹ� **/
		DISPENSING(StateDuration.TRANSIENT) {
			void next() {
				System.out.println("���׳ɹ������ú�������Ʒ��" + selection);
				// �۳�������Ʒ�Ľ��
				amount -= selection.amount();
				state = GIVING_CHANGE;
			}
		},
		/** ���� **/
		GIVING_CHANGE(StateDuration.TRANSIENT) {
			void next() {
				if (amount > 0) {
					System.out.println("���ú��������㣺" + amount + "����");
					amount = 0;
				}
				state = TERMINAL;
			}
		},
		/** ������ֹ **/
		TERMINAL {
			void output() {
				System.out.println("���׽���");
			}
		};

		private boolean isTransient = false;

		/** ��ǰ�Ƿ���˲ʱ״̬���������������������� **/
		public boolean isTransient() {
			return this.isTransient;
		}

		State() {
		}

		State(StateDuration stateDuration) {
			this.isTransient = true;
		}

		// Ĭ�Ϸ�������˲ʱ״̬ʱ����������ʱ�����ã�
		void next(FSMInput input) {
			System.out.println("��״̬����������������");
		}

		// Ĭ�Ϸ������ڷ�˲ʱ״̬ʱ��������ʱ�����ã�
		void next() {
			System.out.println("��ѡ��һ��������");
		}

		// Ĭ�Ϸ������鿴��
		void output() {
			System.out.println("������ʣ��" + amount + "����");
		}
	}

	// ִ��һ������
	public static void run(FSMInput gen) {
		if (state != State.TERMINAL) {
			if (state.isTransient()) {
				state.next();
			} else {
				state.next(gen);
			}

		} else {
			state.output();
		}

	}

	/**
	 * ����
	 */
	public static void main(String[] args) {

		int i = 0;
		while (true) {
			switch (state) {
			case RESTING:
				run(EnumsUtil.random(MONEY.getValues()));
				break;
			case ADDING_MONEY:
				// �������
				if (i > 0) {
					run(EnumsUtil.random(MONEY.getValues()));
					i = 0;
				} else {
					run(EnumsUtil.random(ITEM_SELECTION.getValues()));
					i++;
				}
				break;
			case TERMINAL:
				run(FSMInput.STOP);
				return;
			default:
				run(null);
				break;
			}
		}
	}

}
