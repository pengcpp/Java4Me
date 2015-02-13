package enumsay;

public enum EnumCustom {

	/**
	 * 可以为每一个枚举值定义方法 Mon.toString()会覆盖EnumCustom.toString()
	 * 
	 */
	Mon("星期一", 11, "Monday"){
		
		@Override
		public String toString(){
			return "星期一也不用上班";
		}
	}, 
	
	TUE("星期二", 12, "Tuesday"){
		
	},
	
	WED("星期三", 13,"Wednesday"){
		
	}, 
	
	THU("星期四", 14, "Thursday"){
		
	}, 
	FRI("星期五", 15, "Friday"),  SAT("星期六", 16, "Saturday"), SUN("星期日", 17, "Sunday");

	private String cName;
	private int cNum;
	private String eName;

	/** 
	 * 无法具体指定枚举的值，但可以有自己的构造参数，get/set方法，可以覆写toString()。
	 * public/protected not ok, illegal modifier for the enum constructor; only private is permitted.
	 * 可以保证客户代码没有办法新建一个enum的实例
	 */
	private EnumCustom(String name, int ordinal, String engName) {
		this.cName = name;
		this.cNum = ordinal;
		this.eName = engName;
	}

	// enum name(): Mon ordinal():0 cName:星期一 cNum:11 eName:Monday
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
