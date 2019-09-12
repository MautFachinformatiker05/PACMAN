public class RoterGeist extends Geist {

	public RoterGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void planen() {
		int zufall = 0;
		zielX = Game.feld.pac_x;
		zielY = Game.feld.pac_y;
		checkFrightened();
		boolean geraderWegGefunden = false;
		int vyAchse = Integer.signum(zielY - geistY);
		int vxAchse = Integer.signum(zielX - geistX);
		// Gerader Weg

		if (vyAchse != 0) {

			if (vyAchse < 0 && isWall(geistY - 1, geistX)) {
				richtung = OBEN;
				geraderWegGefunden = true;
			}
			else if (vyAchse > 0 && isWall(geistY + 1, geistX)) {
				richtung = UNTEN;
				geraderWegGefunden = true;
			} 
		}
		else {

			if (vxAchse < 0 && isWall(geistY, geistX - 1)) {
				richtung = LINKS;
				geraderWegGefunden = true;
			}
			else if (vxAchse > 0 && isWall(geistY, geistX + 1)) {
				richtung = RECHTS;
				geraderWegGefunden = true;
			}

		}

		// Wenn kein gerader Weg gefunden ausprobieren	
		
		while (!geraderWegGefunden) {
			zufall = (int) (Math.random() * 4 + 1);

			if (zufall == 1 && isWall(geistY - 1, geistX)) {
				richtung = OBEN;
				geraderWegGefunden = true;
			} else if (zufall == 2 && isWall(geistY + 1, geistX)) {
				richtung = UNTEN;
				geraderWegGefunden = true;
			} else if (zufall == 3 && isWall(geistY, geistX - 1)) {
				richtung = LINKS;
				geraderWegGefunden = true;
			} else if (zufall == 4 && isWall(geistY, geistX + 1)) {
				richtung = RECHTS;
				geraderWegGefunden = true;
			}

		}
		move(richtung);
		tunnel_teleport();
	}

}
