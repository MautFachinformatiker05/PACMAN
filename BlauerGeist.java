public class BlauerGeist extends Geist {

	public BlauerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void planen() {
		zielY = Game.feld.pac_y;
		zielX = Game.feld.pac_x;
		checkFrightened();
		// 1. Fall X-Kor -1
		richtung=NEUTRAL;
		double distance = abstand(geistX - 1, geistY, zielX, zielY);
		if (!isWall(geistY, geistX - 1)) {
			richtung=LINKS;
		}

		// 2. Fall X-Kor +1
		double tempDistance = abstand(geistX + 1, geistY, zielX, zielY);

		if (tempDistance < distance && !isWall(geistY, geistX + 1)) {
			distance = tempDistance;
			richtung= RECHTS;
		}

		// 3. Fall Y-Kor +1
		tempDistance = abstand(geistX, geistY + 1, zielX, zielY);
		if (tempDistance < distance && !isWall(geistY + 1, geistX)) {
			distance = tempDistance;
			richtung=UNTEN;
		}

		// 4. Fall X-Kor -1
		tempDistance = abstand(geistX, geistY - 1, zielX, zielY);
		if (tempDistance < distance && !isWall(geistY - 1, geistX)) {
			distance = tempDistance;
			richtung=OBEN;
		}

		
		move(richtung);
		tunnel_teleport ();

	}

}
