package enumsay;

import java.util.EnumMap;

import enumsay.RoShamBo.Outcome;

/**
 * EnumMap 多路分发
 * 
 */
public enum RoShamBoMap {

	PAPER, SCISSORS, ROCK;

	static EnumMap<RoShamBoMap, EnumMap<RoShamBoMap, Outcome>> table = new EnumMap<RoShamBoMap, EnumMap<RoShamBoMap, Outcome>>(
			RoShamBoMap.class);

	static {
		for (RoShamBoMap it : RoShamBoMap.values())
			table.put(it, new EnumMap<RoShamBoMap, Outcome>(RoShamBoMap.class));
		initRow(PAPER, Outcome.DRAW, Outcome.LOSE, Outcome.WIN);
		initRow(SCISSORS, Outcome.WIN, Outcome.DRAW, Outcome.LOSE);
		initRow(ROCK, Outcome.LOSE, Outcome.WIN, Outcome.DRAW);
	}

	static void initRow(RoShamBoMap it, Outcome vPAPER, Outcome vSCISSORS,
			Outcome vROCK) {
		EnumMap<RoShamBoMap, Outcome> row = RoShamBoMap.table.get(it);
		row.put(RoShamBoMap.PAPER, vPAPER);
		row.put(RoShamBoMap.SCISSORS, vSCISSORS);
		row.put(RoShamBoMap.ROCK, vROCK);
	}

	public Outcome compete(RoShamBoMap it) {
		return table.get(this).get(it);
	}

	public static void play(Class<RoShamBoMap> rsbClass, int size) {
		for (int i = 0; i < size; i++)
			match(EnumsUtil.random(rsbClass), EnumsUtil.random(rsbClass));
	}

	public static void match(RoShamBoMap a, RoShamBoMap b) {
		System.out.println(a + " vs. " + b + ": " + a.compete(b));
	}

	public static void main(String[] args) {
		play(RoShamBoMap.class, 10);
	}

}
