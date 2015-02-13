package enumsay;

import java.util.*;

public class EnumsUtil {
	
	private static Random rand = new Random(System.nanoTime());

	public static <T extends Enum<T>> T random(Class<T> ec) {
		return random(ec.getEnumConstants());
	}

	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}