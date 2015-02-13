package enumsay;

/**
 * remove the interface and the method, then cmd javap EnumType, you can see
 * 
 *$ javap EnumType
	Compiled from "EnumType.java"
	public final class enumSay.EnumType extends java.lang.Enum{
    	public static final enumSay.EnumType MON;
    	public static final enumSay.EnumType TUE;
    	public static final enumSay.EnumType WED;
    	public static final enumSay.EnumType THU;
    	public static final enumSay.EnumType FRI;
    	public static final enumSay.EnumType SAT;
    	public static final enumSay.EnumType SUN;
    	public static enumSay.EnumType[] values();
    	public static enumSay.EnumType valueOf(java.lang.String);
    	static {};
 *	}
 *
 *	enum is a class
 *	Method "values()" and "valueOf()" added by java compiler.
 */
public enum EnumType implements EnumInterface {
	MON, TUE, WED, THU, FRI, SAT, SUN;

	@Override
	public void printToday() {
		System.out.print(name() + "-->" + ordinal() + "\n");
	}

	@Override
	public String getToday() {
		return super.name();
	}
}
