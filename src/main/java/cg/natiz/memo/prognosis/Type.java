package cg.natiz.memo.prognosis;

public enum Type {

	DOUBLE(2),
	TIERCE(3),
	QUARTE(4),
	QUINTE(5),
	QUINTE_PLUS(6),
	LOTO(6);
	
	private int cardinal;
	
	/**
	 * 
	 * @param cardinal size of 
	 */
	private Type(int cardinal) {
		this.cardinal = cardinal;
	}

	public int cardinal() {
		return this.cardinal;
	}
}
