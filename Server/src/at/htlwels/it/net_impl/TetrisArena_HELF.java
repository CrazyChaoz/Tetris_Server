package at.htlwels.it.net_impl;

import java.util.Random;

public class TetrisArena_HELF {
	public final static int ARENA_WIDTH = 10;
	public final static int ARENA_HEIGHT = 20;

	private int arena[][];
	private int width;
	private int height;

	public TetrisArena_HELF(int w, int h) {
		this.arena = new int[h][w];
		this.width = w;
		this.height = h;

		reset();
	}

	public void reset() {
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				arena[j][i] = 0;
	}

	public int getArenaContent(int x, int y) {
		return arena[y][x];
	}

	private void eliminateLine(int y) {
		int x = 0;

		while (y > 0) {
			// kopieren der zeile darüber in die aktuelle
			x = 0;
			while (x < width) {
				arena[y][x] = arena[y - 1][x];
				x++;
			}
			y--;
		}
		x = 0;
		while (x < width) {
			arena[0][x] = 0;
			x++;
		}
	}

	public void setLines(int y) {
		int x = 0;
		while (x < width) {
			arena[y][x] = 1;
			x++;
		}
	}

	// Überprüft auf ganze Linien und entfernt diese
	// Rückgabewert: Anzahl an vollen Linien
	public int checkLines() {
		int y = height - 1;
		int x = 0;
		boolean full = true;
		int lines = 0;

		while (y >= 0) {
			x = 0;
			full = true;
			while (x < width) {
				if (arena[y][x] == 0)
					full = false;
				x++;
			}
			if (full) // volle Linie gefunden
			{
				eliminateLine(y);
				lines++;
			} else
				// sonst wird diese Zeile übersprungen
				y--;
		}
		return lines;
	}

	// prüft, ob eine Kollision vorliegt - in dem Fall wird false retourniert
	public boolean checkTetronimo(Tetronimo_HELF t, int x_new, int y_new) {
		boolean check = true;
		int x = 0, y = 0;

		// überprüfen des Tetronimos auf Kollisionen mit Steinen

		while (check && x < t.getWidth()) {
			y = 0;
			while (check && y < t.getHeight()) {
				// nur wenn ein Tetronimostein
				if (t.toArray()[y][x] != 0) {
					// steht links was raus?
					if ((x + x_new < 0) ||
					// oder rechts?
							(x + x_new > width - 1) ||
							// oder unten?
							(y + y_new > height - 1) ||
							// oder oben?
							(y + y_new < 0)) {
						check = false;
					}
					// oder liegt ein Stein dort? - dann sollte vorher geprüft
					// werden, ob wir grad ausserhalb sind
					else if (arena[y_new + y][x_new + x] != 0)
						check = false;
				}
				y++;
			}
			x++;
		}
		return check;
	}

	// Tetronimo wird in Arena übernommen und kann nicht mehr bewegt werden
	public boolean setTetronimo(Tetronimo_HELF t, int x, int y) {
		int tetronimo[][] = t.toArray();
		boolean set = true;

		if (checkTetronimo(t, x, y)) // nur übernehmen, wenn Plätze auch frei
		{
			for (int i = 0; i < t.getWidth(); i++)
				for (int j = 0; j < t.getHeight(); j++)
					if ((tetronimo[j][i] != 0) && (x + i >= 0) && (y + j >= 0)
							&& (x + i < width) && (y + j < height))
						arena[y + j][x + i] = tetronimo[j][i];
			// t.setPosX(x);
			// t.setPosY(y);
		} else
			set = false;
		return set;
	}

	public String toString() {
		String s = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				s = s + arena[y][x];
			}
			s = s + "\n";
		}
		return s;
	}

	public boolean addLines(int lines) {
		int x = 0;
		int y = 0;
		boolean success = true;

		Random r = new Random();

		// prüfen, ob in oberster Reihe Steine liegen
		y = 0;
		while (success && y < lines) {
			x = 0;
			while (success && x < width) {
				if (arena[y][x] != 0)
					success = false;
				x++;
			}
			y++;
		}

		y = lines;
		while (y < height) {
			// kopieren der zeile darüber in die aktuelle
			x = 0;
			while (x < width) {
				arena[y - lines][x] = arena[y][x];
				x++;
			}
			y++;
		}
		// AUFFÜLLEN MIT RANDOM WERTEN
		x = 0;
		y = height - lines;
		while (y < height) {
			x = 0;
			while (x < width) {
				arena[y][x] = r.nextInt(8);
				x++;
			}
			// garantiert 1 freies:
			arena[y][r.nextInt(width)] = 0;

			y++;
		}
		return success;
	}

	/**
	 * @return the arena
	 */
	public int[][] toArray() {
		// copy values from original arena to arena to be sent
		int[][] tempArena = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				tempArena[i][j] = arena[i][j];
			}
		}
		return tempArena;
	}

}
