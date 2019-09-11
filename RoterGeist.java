public class RoterGeist extends Geist {

	public RoterGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void move() {
		zielX = Game.feld.pac_x;
		zielY = Game.feld.pac_y;
		checkFrightened();
		int vxAchse = 0;
		int vyAchse = 0;
		int xTemp = 0;
		int yTemp = 0;
		int xWhile = 0;
		int yWhile = 0;
		int zufall = 0;
		xTemp = geistX;
		yTemp = geistY;
		vyAchse = Integer.signum(zielY - geistY);
		vxAchse = Integer.signum(zielX - geistX);
		// Gerader Weg
		if (vyAchse != 0) {
			geistY += vyAchse;
		} else {
			geistX += vxAchse;
		}

		// Wenn kein gerader Weg zum Ziel gefunden, ausprobieren
		while (Game.feld.feld[geistY][geistX] == 1) {

			zufall = (int) (Math.random() * 4 + 1);
			xWhile = xTemp;
			yWhile = yTemp;

			if (zufall == 1) {
				xWhile--;
			} else if (zufall == 2) {
				xWhile++;
			} else if (zufall == 3) {
				yWhile--;
			} else {
				yWhile++;
			}
			geistX = xWhile;
			geistY = yWhile;
			tunnel_teleport ();
		}

	}

}
