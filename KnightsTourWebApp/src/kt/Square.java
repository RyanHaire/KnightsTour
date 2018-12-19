package kt;

class Square {
	private int moveNum;
	private boolean touched = false;
	private int[] position = new int[2];
	private int accessibility;
	private String name = "0";
	
	Square() {
		
	}
	
	int getAccessibility() {
		return accessibility;
	}

	void setAccessibility(int accessibility) {
		this.accessibility = accessibility;
	}
	
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int[] getPosition() {
		return position;
	}

	void setPosition(int row, int col) {
		this.position[0] = row;
		this.position[1] = col;
	}

	int getMoveNum() {
		return moveNum;
	}

	void setMoveNum(int moveNum) {
		this.moveNum = moveNum;
	}

	boolean isTouched() {
		return touched;
	}

	void setTouched(boolean touched) {
		this.touched = touched;
	}
	
}
