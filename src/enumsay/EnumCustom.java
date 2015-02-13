package enumsay;

public enum EnumCustom {

	/**
	 * ����Ϊÿһ��ö��ֵ���巽�� Mon.toString()�Ḳ��EnumCustom.toString()
	 * 
	 */
	Mon("����һ", 11, "Monday"){
		
		@Override
		public String toString(){
			return "����һҲ�����ϰ�";
		}
	}, 
	
	TUE("���ڶ�", 12, "Tuesday"){
		
	},
	
	WED("������", 13,"Wednesday"){
		
	}, 
	
	THU("������", 14, "Thursday"){
		
	}, 
	FRI("������", 15, "Friday"),  SAT("������", 16, "Saturday"), SUN("������", 17, "Sunday");

	private String cName;
	private int cNum;
	private String eName;

	/** 
	 * �޷�����ָ��ö�ٵ�ֵ�����������Լ��Ĺ��������get/set���������Ը�дtoString()��
	 * public/protected not ok, illegal modifier for the enum constructor; only private is permitted.
	 * ���Ա�֤�ͻ�����û�а취�½�һ��enum��ʵ��
	 */
	private EnumCustom(String name, int ordinal, String engName) {
		this.cName = name;
		this.cNum = ordinal;
		this.eName = engName;
	}

	// enum name(): Mon ordinal():0 cName:����һ cNum:11 eName:Monday
	public void testNameMethod() {
		System.out.print("\n enum name(): " + name() + " ordinal():" + ordinal()
				+ " cName:" + cName + " cNum:" + cNum + " eName:" + eName);
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return String.valueOf(this.cNum);
	}
}
