public class BlauerGeist extends Geist {

	public BlauerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void planen() {
		zielY = Game.feld.pac_y;
		zielX = Game.feld.pac_x;
		checkFrightened();
		int xBewegung = -1;
		int yBewegung = 0;

		// 1. Fall X-Kor -1
		double distance = abstand(geistX - 1, geistY, zielX, zielY);
		if (isWall(geistY, geistX - 1)) {
			xBewegung = 0;
		}

		// 2. Fall X-Kor +1
		double tempDistance = abstand(geistX + 1, geistY, zielX, zielY);

		if (tempDistance < distance && !isWall(geistY, geistX + 1)) {
			distance = tempDistance;
			xBewegung = 1;
		}

		// 3. Fall Y-Kor +1
		tempDistance = abstand(geistX, geistY + 1, zielX, zielY);
		if (tempDistance < distance && !isWall(geistY + 1, geistX)) {
			distance = tempDistance;
			xBewegung = 0;
			yBewegung = 1;
		}

		// 4. Fall X-Kor -1
		tempDistance = abstand(geistX, geistY - 1, zielX, zielY);
		if (tempDistance < distance && !isWall(geistY - 1, geistX)) {
			distance = tempDistance;
			xBewegung = 0;
			yBewegung = -1;
		}
//		geistX += xBewegung;
//		geistY += yBewegung;
		
		if(xBewegung>0)
			move(RECHTS);
		if(xBewegung<0)
			move(LINKS);
		if(yBewegung>0)
			move(UNTEN);
		if(yBewegung<0)
			move(OBEN);
		tunnel_teleport ();

	}

}
