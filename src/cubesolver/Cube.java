package cubesolver;



/**
 * Class to hold state of cube. Also to provide methods to alter the cube, and
 * to help display it correctly.
 * 
 * @author Andrew
 * 
 */
public class Cube {
	/**
	 * Stores the state of the cube. Top face is 0, 1 through 4 are side faces
	 * going round clockwise looking from the top, and 5 is the bottom face.
	 * Face 1 is the front face. The squares on each face are numbered from left
	 * to right and top to bottom.
	 */
	public cubeColor[][] cubeState;
	private static final int CUBE_FACES = 6;
	private static final int CUBE_SQUARES = 9;

	/**
	 * Default constructor.
	 */
	public Cube() {
		// 6 faces and 9 squares on each face
		cubeState = new cubeColor[Cube.CUBE_FACES][Cube.CUBE_SQUARES];
		setColors();
	}

	/**
	 * Helper method to return a deep copy of the cubestate array. Makes
	 * makeNewCube into a public method effectively.
	 * 
	 * @return copyCubeState
	 */
	public cubeColor[][] getCubeStateDeepCopy() {
		cubeColor[][] copyCubeState = makeNewCube(this.cubeState);
		return copyCubeState;
	}

	/**
	 * Method to move the cube. To change the cube, allow methods to turn one of
	 * the slices on the top face either direction or the front face left or
	 * right. This fully describes available moves.
	 * 
	 * @throws IllegalArgumentException
	 *             Either checks must be made the parameters are valid or this
	 *             exception must be caught.
	 * 
	 * @param direction
	 *            Either 0 for "left" or 1 for "right". For slices 1 to 3 0 is
	 *            frontwards and 1 is backwards.
	 * @param slice
	 *            Range 1 to 9, 1 is left slice, 3 is right slice; 4 is front, 6
	 *            is back; 7 is top of front face, 9 is bottom of front face.
	 */
	public void changeCube(int direction, int slice) {
		// Here we change the state of the cube by moving colors from one state
		// to the next.

		if (direction != 0 && direction != 1) {
			throw new IllegalArgumentException("Invalid move.");
		}
		cubeColor[][] newCubeState = makeNewCube(this.cubeState);
		switch (slice) {
		case 1:
			if (direction == 0) {
				move_1_0(newCubeState);
			} else {
				move_1_1(newCubeState);
			}
			break;
		case 2:
			if (direction == 0) {
				move_2_0(newCubeState);
			} else {
				move_2_1(newCubeState);
			}
			break;
		case 3:
			if (direction == 0) {
				move_3_0(newCubeState);
			} else {
				move_3_1(newCubeState);
			}
			break;
		case 4:
			if (direction == 0) {
				move_4_0(newCubeState);
			} else {
				move_4_1(newCubeState);
			}
			break;
		case 5:
			if (direction == 0) {
				move_5_0(newCubeState);
			} else {
				move_5_1(newCubeState);
			}
			break;
		case 6:
			if (direction == 0) {
				move_6_0(newCubeState);
			} else {
				move_6_1(newCubeState);
			}
			break;
		case 7:
			if (direction == 0) {
				move_7_0(newCubeState);
			} else {
				move_7_1(newCubeState);
			}
			break;
		case 8:
			if (direction == 0) {
				move_8_0(newCubeState);
			} else {
				move_8_1(newCubeState);
			}
			break;
		case 9:
			if (direction == 0) {
				move_9_0(newCubeState);
			} else {
				move_9_1(newCubeState);
			}
			break;
		default:
			throw new IllegalArgumentException("Invalid move.");
		}
		this.cubeState = newCubeState;
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_9_1(cubeColor[][] newCubeColor) {
		newCubeColor[4][6] = this.cubeState[1][6];
		newCubeColor[4][7] = this.cubeState[1][7];
		newCubeColor[4][8] = this.cubeState[1][8];

		newCubeColor[3][6] = this.cubeState[4][6];
		newCubeColor[3][7] = this.cubeState[4][7];
		newCubeColor[3][8] = this.cubeState[4][8];

		newCubeColor[2][6] = this.cubeState[3][6];
		newCubeColor[2][7] = this.cubeState[3][7];
		newCubeColor[2][8] = this.cubeState[3][8];

		newCubeColor[1][6] = this.cubeState[2][6];
		newCubeColor[1][7] = this.cubeState[2][7];
		newCubeColor[1][8] = this.cubeState[2][8];

		newCubeColor[5][2] = this.cubeState[5][0];
		newCubeColor[5][5] = this.cubeState[5][1];
		newCubeColor[5][8] = this.cubeState[5][2];
		newCubeColor[5][1] = this.cubeState[5][3];
		newCubeColor[5][7] = this.cubeState[5][5];
		newCubeColor[5][0] = this.cubeState[5][6];
		newCubeColor[5][3] = this.cubeState[5][7];
		newCubeColor[5][6] = this.cubeState[5][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_9_0(cubeColor[][] newCubeColor) {
		newCubeColor[2][6] = this.cubeState[1][6];
		newCubeColor[2][7] = this.cubeState[1][7];
		newCubeColor[2][8] = this.cubeState[1][8];

		newCubeColor[3][6] = this.cubeState[2][6];
		newCubeColor[3][7] = this.cubeState[2][7];
		newCubeColor[3][8] = this.cubeState[2][8];

		newCubeColor[4][6] = this.cubeState[3][6];
		newCubeColor[4][7] = this.cubeState[3][7];
		newCubeColor[4][8] = this.cubeState[3][8];

		newCubeColor[1][6] = this.cubeState[4][6];
		newCubeColor[1][7] = this.cubeState[4][7];
		newCubeColor[1][8] = this.cubeState[4][8];

		newCubeColor[5][6] = this.cubeState[5][0];
		newCubeColor[5][3] = this.cubeState[5][1];
		newCubeColor[5][0] = this.cubeState[5][2];
		newCubeColor[5][7] = this.cubeState[5][3];
		newCubeColor[5][1] = this.cubeState[5][5];
		newCubeColor[5][8] = this.cubeState[5][6];
		newCubeColor[5][5] = this.cubeState[5][7];
		newCubeColor[5][2] = this.cubeState[5][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_8_1(cubeColor[][] newCubeColor) {
		newCubeColor[4][3] = this.cubeState[1][3];
		newCubeColor[4][4] = this.cubeState[1][4];
		newCubeColor[4][5] = this.cubeState[1][5];

		newCubeColor[3][3] = this.cubeState[4][3];
		newCubeColor[3][4] = this.cubeState[4][4];
		newCubeColor[3][5] = this.cubeState[4][5];

		newCubeColor[2][3] = this.cubeState[3][3];
		newCubeColor[2][4] = this.cubeState[3][4];
		newCubeColor[2][5] = this.cubeState[3][5];

		newCubeColor[1][3] = this.cubeState[2][3];
		newCubeColor[1][4] = this.cubeState[2][4];
		newCubeColor[1][5] = this.cubeState[2][5];

	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_8_0(cubeColor[][] newCubeColor) {
		newCubeColor[2][3] = this.cubeState[1][3];
		newCubeColor[2][4] = this.cubeState[1][4];
		newCubeColor[2][5] = this.cubeState[1][5];

		newCubeColor[3][3] = this.cubeState[2][3];
		newCubeColor[3][4] = this.cubeState[2][4];
		newCubeColor[3][5] = this.cubeState[2][5];

		newCubeColor[4][3] = this.cubeState[3][3];
		newCubeColor[4][4] = this.cubeState[3][4];
		newCubeColor[4][5] = this.cubeState[3][5];

		newCubeColor[1][3] = this.cubeState[4][3];
		newCubeColor[1][4] = this.cubeState[4][4];
		newCubeColor[1][5] = this.cubeState[4][5];

	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_7_1(cubeColor[][] newCubeColor) {
		newCubeColor[4][0] = this.cubeState[1][0];
		newCubeColor[4][1] = this.cubeState[1][1];
		newCubeColor[4][2] = this.cubeState[1][2];

		newCubeColor[3][0] = this.cubeState[4][0];
		newCubeColor[3][1] = this.cubeState[4][1];
		newCubeColor[3][2] = this.cubeState[4][2];

		newCubeColor[2][0] = this.cubeState[3][0];
		newCubeColor[2][1] = this.cubeState[3][1];
		newCubeColor[2][2] = this.cubeState[3][2];

		newCubeColor[1][0] = this.cubeState[2][0];
		newCubeColor[1][1] = this.cubeState[2][1];
		newCubeColor[1][2] = this.cubeState[2][2];

		newCubeColor[0][6] = this.cubeState[0][0];
		newCubeColor[0][3] = this.cubeState[0][1];
		newCubeColor[0][0] = this.cubeState[0][2];
		newCubeColor[0][7] = this.cubeState[0][3];
		newCubeColor[0][1] = this.cubeState[0][5];
		newCubeColor[0][8] = this.cubeState[0][6];
		newCubeColor[0][5] = this.cubeState[0][7];
		newCubeColor[0][2] = this.cubeState[0][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_7_0(cubeColor[][] newCubeColor) {
		newCubeColor[2][0] = this.cubeState[1][0];
		newCubeColor[2][1] = this.cubeState[1][1];
		newCubeColor[2][2] = this.cubeState[1][2];

		newCubeColor[3][0] = this.cubeState[2][0];
		newCubeColor[3][1] = this.cubeState[2][1];
		newCubeColor[3][2] = this.cubeState[2][2];

		newCubeColor[4][0] = this.cubeState[3][0];
		newCubeColor[4][1] = this.cubeState[3][1];
		newCubeColor[4][2] = this.cubeState[3][2];

		newCubeColor[1][0] = this.cubeState[4][0];
		newCubeColor[1][1] = this.cubeState[4][1];
		newCubeColor[1][2] = this.cubeState[4][2];

		newCubeColor[0][2] = this.cubeState[0][0];
		newCubeColor[0][5] = this.cubeState[0][1];
		newCubeColor[0][8] = this.cubeState[0][2];
		newCubeColor[0][1] = this.cubeState[0][3];
		newCubeColor[0][7] = this.cubeState[0][5];
		newCubeColor[0][0] = this.cubeState[0][6];
		newCubeColor[0][3] = this.cubeState[0][7];
		newCubeColor[0][6] = this.cubeState[0][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_6_1(cubeColor[][] newCubeColor) {
		newCubeColor[0][6] = this.cubeState[2][8];
		newCubeColor[0][7] = this.cubeState[2][5];
		newCubeColor[0][8] = this.cubeState[2][2];

		newCubeColor[4][0] = this.cubeState[0][6];
		newCubeColor[4][3] = this.cubeState[0][7];
		newCubeColor[4][6] = this.cubeState[0][8];

		newCubeColor[5][2] = this.cubeState[4][0];
		newCubeColor[5][1] = this.cubeState[4][3];
		newCubeColor[5][0] = this.cubeState[4][6];

		newCubeColor[2][8] = this.cubeState[5][2];
		newCubeColor[2][5] = this.cubeState[5][1];
		newCubeColor[2][2] = this.cubeState[5][0];

		newCubeColor[1][2] = this.cubeState[1][0];
		newCubeColor[1][5] = this.cubeState[1][1];
		newCubeColor[1][8] = this.cubeState[1][2];
		newCubeColor[1][1] = this.cubeState[1][3];
		newCubeColor[1][7] = this.cubeState[1][5];
		newCubeColor[1][0] = this.cubeState[1][6];
		newCubeColor[1][3] = this.cubeState[1][7];
		newCubeColor[1][6] = this.cubeState[1][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_6_0(cubeColor[][] newCubeColor) {
		newCubeColor[5][2] = this.cubeState[2][8];
		newCubeColor[5][1] = this.cubeState[2][5];
		newCubeColor[5][0] = this.cubeState[2][2];

		newCubeColor[2][8] = this.cubeState[0][6];
		newCubeColor[2][5] = this.cubeState[0][7];
		newCubeColor[2][2] = this.cubeState[0][8];

		newCubeColor[0][6] = this.cubeState[4][0];
		newCubeColor[0][7] = this.cubeState[4][3];
		newCubeColor[0][8] = this.cubeState[4][6];

		newCubeColor[4][0] = this.cubeState[5][2];
		newCubeColor[4][3] = this.cubeState[5][1];
		newCubeColor[4][6] = this.cubeState[5][0];

		newCubeColor[1][6] = this.cubeState[1][0];
		newCubeColor[1][3] = this.cubeState[1][1];
		newCubeColor[1][0] = this.cubeState[1][2];
		newCubeColor[1][7] = this.cubeState[1][3];
		newCubeColor[1][1] = this.cubeState[1][5];
		newCubeColor[1][8] = this.cubeState[1][6];
		newCubeColor[1][5] = this.cubeState[1][7];
		newCubeColor[1][2] = this.cubeState[1][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_5_1(cubeColor[][] newCubeColor) {
		newCubeColor[0][3] = this.cubeState[2][7];
		newCubeColor[0][4] = this.cubeState[2][4];
		newCubeColor[0][5] = this.cubeState[2][1];

		newCubeColor[4][1] = this.cubeState[0][3];
		newCubeColor[4][4] = this.cubeState[0][4];
		newCubeColor[4][7] = this.cubeState[0][5];

		newCubeColor[5][5] = this.cubeState[4][1];
		newCubeColor[5][4] = this.cubeState[4][4];
		newCubeColor[5][3] = this.cubeState[4][7];

		newCubeColor[2][7] = this.cubeState[5][5];
		newCubeColor[2][4] = this.cubeState[5][4];
		newCubeColor[2][1] = this.cubeState[5][3];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_5_0(cubeColor[][] newCubeColor) {
		newCubeColor[5][5] = this.cubeState[2][7];
		newCubeColor[5][4] = this.cubeState[2][4];
		newCubeColor[5][3] = this.cubeState[2][1];

		newCubeColor[2][7] = this.cubeState[0][3];
		newCubeColor[2][4] = this.cubeState[0][4];
		newCubeColor[2][1] = this.cubeState[0][5];

		newCubeColor[0][3] = this.cubeState[4][1];
		newCubeColor[0][4] = this.cubeState[4][4];
		newCubeColor[0][5] = this.cubeState[4][7];

		newCubeColor[4][1] = this.cubeState[5][5];
		newCubeColor[4][4] = this.cubeState[5][4];
		newCubeColor[4][7] = this.cubeState[5][3];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_4_1(cubeColor[][] newCubeColor) {
		newCubeColor[0][0] = this.cubeState[2][6];
		newCubeColor[0][1] = this.cubeState[2][3];
		newCubeColor[0][2] = this.cubeState[2][0];

		newCubeColor[4][2] = this.cubeState[0][0];
		newCubeColor[4][5] = this.cubeState[0][1];
		newCubeColor[4][8] = this.cubeState[0][2];

		newCubeColor[5][8] = this.cubeState[4][2];
		newCubeColor[5][7] = this.cubeState[4][5];
		newCubeColor[5][6] = this.cubeState[4][8];

		newCubeColor[2][6] = this.cubeState[5][8];
		newCubeColor[2][3] = this.cubeState[5][7];
		newCubeColor[2][0] = this.cubeState[5][6];

		newCubeColor[3][6] = this.cubeState[3][0];
		newCubeColor[3][3] = this.cubeState[3][1];
		newCubeColor[3][0] = this.cubeState[3][2];
		newCubeColor[3][7] = this.cubeState[3][3];
		newCubeColor[3][1] = this.cubeState[3][5];
		newCubeColor[3][8] = this.cubeState[3][6];
		newCubeColor[3][5] = this.cubeState[3][7];
		newCubeColor[3][2] = this.cubeState[3][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_4_0(cubeColor[][] newCubeColor) {
		newCubeColor[5][8] = this.cubeState[2][6];
		newCubeColor[5][7] = this.cubeState[2][3];
		newCubeColor[5][6] = this.cubeState[2][0];

		newCubeColor[2][6] = this.cubeState[0][0];
		newCubeColor[2][3] = this.cubeState[0][1];
		newCubeColor[2][0] = this.cubeState[0][2];

		newCubeColor[0][0] = this.cubeState[4][2];
		newCubeColor[0][1] = this.cubeState[4][5];
		newCubeColor[0][2] = this.cubeState[4][8];

		newCubeColor[4][2] = this.cubeState[5][8];
		newCubeColor[4][5] = this.cubeState[5][7];
		newCubeColor[4][8] = this.cubeState[5][6];

		newCubeColor[3][2] = this.cubeState[3][0];
		newCubeColor[3][5] = this.cubeState[3][1];
		newCubeColor[3][8] = this.cubeState[3][2];
		newCubeColor[3][1] = this.cubeState[3][3];
		newCubeColor[3][7] = this.cubeState[3][5];
		newCubeColor[3][0] = this.cubeState[3][6];
		newCubeColor[3][3] = this.cubeState[3][7];
		newCubeColor[3][6] = this.cubeState[3][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_3_1(cubeColor[][] newCubeColor) {
		newCubeColor[3][6] = this.cubeState[0][2];
		newCubeColor[3][3] = this.cubeState[0][5];
		newCubeColor[3][0] = this.cubeState[0][8];

		newCubeColor[0][2] = this.cubeState[1][2];
		newCubeColor[0][5] = this.cubeState[1][5];
		newCubeColor[0][8] = this.cubeState[1][8];

		newCubeColor[1][2] = this.cubeState[5][2];
		newCubeColor[1][5] = this.cubeState[5][5];
		newCubeColor[1][8] = this.cubeState[5][8];

		newCubeColor[5][2] = this.cubeState[3][6];
		newCubeColor[5][5] = this.cubeState[3][3];
		newCubeColor[5][8] = this.cubeState[3][0];

		newCubeColor[4][2] = this.cubeState[4][0];
		newCubeColor[4][5] = this.cubeState[4][1];
		newCubeColor[4][8] = this.cubeState[4][2];
		newCubeColor[4][1] = this.cubeState[4][3];
		newCubeColor[4][7] = this.cubeState[4][5];
		newCubeColor[4][0] = this.cubeState[4][6];
		newCubeColor[4][3] = this.cubeState[4][7];
		newCubeColor[4][6] = this.cubeState[4][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_3_0(cubeColor[][] newCubeColor) {
		newCubeColor[1][2] = this.cubeState[0][2];
		newCubeColor[1][5] = this.cubeState[0][5];
		newCubeColor[1][8] = this.cubeState[0][8];

		newCubeColor[5][2] = this.cubeState[1][2];
		newCubeColor[5][5] = this.cubeState[1][5];
		newCubeColor[5][8] = this.cubeState[1][8];

		newCubeColor[3][6] = this.cubeState[5][2];
		newCubeColor[3][3] = this.cubeState[5][5];
		newCubeColor[3][0] = this.cubeState[5][8];

		newCubeColor[0][2] = this.cubeState[3][6];
		newCubeColor[0][5] = this.cubeState[3][3];
		newCubeColor[0][8] = this.cubeState[3][0];

		newCubeColor[4][6] = this.cubeState[4][0];
		newCubeColor[4][3] = this.cubeState[4][1];
		newCubeColor[4][0] = this.cubeState[4][2];
		newCubeColor[4][7] = this.cubeState[4][3];
		newCubeColor[4][1] = this.cubeState[4][5];
		newCubeColor[4][8] = this.cubeState[4][6];
		newCubeColor[4][5] = this.cubeState[4][7];
		newCubeColor[4][2] = this.cubeState[4][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_2_1(cubeColor[][] newCubeColor) {
		newCubeColor[3][1] = this.cubeState[0][1];
		newCubeColor[3][4] = this.cubeState[0][4];
		newCubeColor[3][7] = this.cubeState[0][7];

		newCubeColor[5][1] = this.cubeState[3][1];
		newCubeColor[5][4] = this.cubeState[3][4];
		newCubeColor[5][7] = this.cubeState[3][7];

		newCubeColor[1][1] = this.cubeState[5][1];
		newCubeColor[1][4] = this.cubeState[5][4];
		newCubeColor[1][7] = this.cubeState[5][7];

		newCubeColor[0][1] = this.cubeState[1][1];
		newCubeColor[0][4] = this.cubeState[1][4];
		newCubeColor[0][7] = this.cubeState[1][7];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_2_0(cubeColor[][] newCubeColor) {
		newCubeColor[1][1] = this.cubeState[0][1];
		newCubeColor[1][4] = this.cubeState[0][4];
		newCubeColor[1][7] = this.cubeState[0][7];

		newCubeColor[0][1] = this.cubeState[3][1];
		newCubeColor[0][4] = this.cubeState[3][4];
		newCubeColor[0][7] = this.cubeState[3][7];

		newCubeColor[3][1] = this.cubeState[5][1];
		newCubeColor[3][4] = this.cubeState[5][4];
		newCubeColor[3][7] = this.cubeState[5][7];

		newCubeColor[5][1] = this.cubeState[1][1];
		newCubeColor[5][4] = this.cubeState[1][4];
		newCubeColor[5][7] = this.cubeState[1][7];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_1_1(cubeColor[][] newCubeColor) {
		newCubeColor[3][8] = this.cubeState[0][0];
		newCubeColor[3][5] = this.cubeState[0][3];
		newCubeColor[3][2] = this.cubeState[0][6];

		newCubeColor[5][0] = this.cubeState[3][8];
		newCubeColor[5][3] = this.cubeState[3][5];
		newCubeColor[5][6] = this.cubeState[3][2];

		newCubeColor[1][0] = this.cubeState[5][0];
		newCubeColor[1][3] = this.cubeState[5][3];
		newCubeColor[1][6] = this.cubeState[5][6];

		newCubeColor[0][0] = this.cubeState[1][0];
		newCubeColor[0][3] = this.cubeState[1][3];
		newCubeColor[0][6] = this.cubeState[1][6];

		newCubeColor[1][6] = this.cubeState[2][0];
		newCubeColor[1][3] = this.cubeState[2][1];
		newCubeColor[1][0] = this.cubeState[2][2];
		newCubeColor[1][7] = this.cubeState[2][3];
		newCubeColor[1][1] = this.cubeState[2][5];
		newCubeColor[1][8] = this.cubeState[2][6];
		newCubeColor[1][5] = this.cubeState[2][7];
		newCubeColor[1][2] = this.cubeState[2][8];
	}

	/**
	 * Hard coded method to move colors around for a given move.
	 * 
	 * @param newCubeColor
	 */
	private void move_1_0(cubeColor[][] newCubeColor) {
		newCubeColor[1][0] = this.cubeState[0][0];
		newCubeColor[1][3] = this.cubeState[0][3];
		newCubeColor[1][6] = this.cubeState[0][6];

		newCubeColor[5][0] = this.cubeState[1][0];
		newCubeColor[5][3] = this.cubeState[1][3];
		newCubeColor[5][6] = this.cubeState[1][6];

		newCubeColor[3][8] = this.cubeState[5][0];
		newCubeColor[3][5] = this.cubeState[5][3];
		newCubeColor[3][2] = this.cubeState[5][6];

		newCubeColor[0][0] = this.cubeState[3][8];
		newCubeColor[0][3] = this.cubeState[3][5];
		newCubeColor[0][6] = this.cubeState[3][2];

		newCubeColor[2][2] = this.cubeState[2][0];
		newCubeColor[2][5] = this.cubeState[2][1];
		newCubeColor[2][8] = this.cubeState[2][2];
		newCubeColor[2][1] = this.cubeState[2][3];
		newCubeColor[2][7] = this.cubeState[2][5];
		newCubeColor[2][0] = this.cubeState[2][6];
		newCubeColor[2][3] = this.cubeState[2][7];
		newCubeColor[2][6] = this.cubeState[2][8];
	}

	/**
	 * Copies a cube's state and returns the new cube state array.
	 * 
	 * @param currentCubeState
	 * @return The new cube state array.
	 */
	private cubeColor[][] makeNewCube(cubeColor[][] currentCubeState) {
		cubeColor[][] newCubeState = new cubeColor[Cube.CUBE_FACES][Cube.CUBE_SQUARES];
		for (int i = 0; i < currentCubeState.length; i++) {
			for (int j = 0; j < currentCubeState[i].length; j++) {
				newCubeState[i][j] = currentCubeState[i][j];
			}
		}
		return newCubeState;
	}

	/**
	 * Initialises the cube.
	 */
	private void setColors() {
		for (int i = 0; i < cubeState.length; i++) {
			cubeColor state = getColor(i);
			for (int j = 0; j < cubeState[i].length; j++) {
				cubeState[i][j] = state;
			}
		}
	}

	/**
	 * Helper method to match the color for the face of the cube.
	 * 
	 * @param i
	 *            The face we need the color for.
	 * @return The color that face should have in the default state of the cube.
	 */
	private cubeColor getColor(int i) {
		cubeColor state = null;
		switch (i) {
		case 0:
			state = cubeColor.WHITE;
			break;
		case 1:
			state = cubeColor.RED;
			break;
		case 2:
			state = cubeColor.BLUE;
			break;
		case 3:
			state = cubeColor.ORANGE;
			break;
		case 4:
			state = cubeColor.GREEN;
			break;
		case 5:
			state = cubeColor.YELLOW;
			break;
		default:
			break;
		}
		return state;
	}

	/**
	 * Method to scramble the cube. Make a series of moves with random
	 * parameters.
	 */
	public void scramble() {
		int numOfMoves = 100;
		for (int i = 0; i < numOfMoves; i++) {
			int nextDirection = (int) (Math.random() * 2);
			if (nextDirection != 0 && nextDirection != 1) {
				//System.out.println("bad direction: " + nextDirection);
				continue;
			}
			int nextSlice = (int) (Math.random() * 9 + 1);
			if (nextSlice < 1 || nextSlice > 9) {
				//System.out.println("bad slice number: " + nextSlice);
				continue;
			}
			changeCube(nextDirection, nextSlice);
		}
		//System.out.println("end of scramble");
	}

	/**
	 * Method to determine if the cube is in a solved state. Check each face
	 * matches the centre color.
	 */
	public boolean isSolved() {
		for (int i = 0; i < cubeState.length; i++) {
			// Need the centre color, the (i,4) square.
			cubeColor state = cubeState[i][4];
			for (int j = 0; j < cubeState[i].length; j++) {
				if (cubeState[i][j] != state) {
					return false;
				}
			}
		}
		// If this is reached, all faces are the correct color.
		return true;
	}

	/**
	 * Prints the cube. Helper method to assist in debugging. Returns a string
	 * to avoid console printing which might not be appropriate.
	 * 
	 * @return returnString the printed representation of the cube state.
	 */
	public String printCube() {
		String returnString = new String("");
		if (cubeState == null) {
			return returnString;
		}
		for (int i = 0; i < cubeState.length; i++) {
			returnString = returnString.concat("The " + i + "th side:\n");
			// System.out.println();
			for (int j = 0; j < cubeState[i].length; j++) {
				returnString = returnString
						.concat(cubeState[i][j].toString() + '\n');
				// System.out.println();
			}
		}
		return returnString;
	}
}
