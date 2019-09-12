import java.util.ArrayList;

public class GrauerGeist extends Geist {
	ArrayList<Integer> richtungen;

	public GrauerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	@Override

	void planen() {

		int futureX = 0;
		int futureY = 0;
		if (abstand(geistX, geistY, zielX, zielY) > 5) {
			int[] vx = { -1, 0, +1, 0, 0 };
			int[] vy = { 0, -1, 0, +1, 0 };
			futureX = vx[Game.feld.pac_richtung];
			futureY = vy[Game.feld.pac_richtung];
			futureX *= 5;
			futureY *= 5;
		}

		zielY = Game.feld.pac_y + futureY;
		zielX = Game.feld.pac_x + futureX;
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

		if (xBewegung > 0)
			move(RECHTS);
		if (xBewegung < 0)
			move(LINKS);
		if (yBewegung > 0)
			move(UNTEN);
		if (yBewegung < 0)
			move(OBEN);
		tunnel_teleport();

	}

}
