
public class kakaO_p3 {
	public static void main(String args[]) {
		int[][] fk = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 1, } };
		int[][] fl = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		System.out.println(unlock(fk,fl));
	}

	public static int[][] turn_key(int[][] key) {
		int size = key.length;
		int[][] temp_key = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp_key[i][j] = key[size - j - 1][i];
			}
		}
		return temp_key;
	}

	public static boolean is_right(int[][] key, int[][] lock, int key_sx, int key_sy) {
		int bgsize = lock.length + (key.length - 1) * 2;
		int[][] bg = new int[bgsize][bgsize];
		int c_start = key.length - 1;

		for (int i = 0; i < key.length; i++)
			for (int j = 0; j < key.length; j++)
				bg[key_sy + i][key_sx + j] += key[i][j];

		for (int i = 0; i < lock.length; i++) {
			for (int j = 0; j < lock.length; j++) {
				bg[c_start + i][c_start + j] += lock[i][j];
				if (bg[c_start + i][c_start + j] != 1)
					return false;
			}
		}
		return true;

	}
	
	public static boolean unlock(int[][] key,int[][] lock) {
		for (int k = 0; k < 4; k++) {
			for (int i = 0; i < lock.length + key.length - 1; i++) {
				for (int j = 0; j < lock.length +key.length - 1; j++) {
					if (is_right(key, lock, j, i) == true) {
						return true;
					}
				}
			}
			key = turn_key(key);
		}
		return false;
	}
	
}
