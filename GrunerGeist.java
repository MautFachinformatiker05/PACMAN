import java.util.ArrayList;

public class GrunerGeist extends Geist {
	ArrayList<Integer[]> astern = new ArrayList<Integer[]>();
	int ziel_x = Game.feld.pac_x;
	int ziel_y = Game.feld.pac_y;

	public GrunerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);
	
	}

	void planen() {
		

		astern.add(new Integer[]{geistX,geistY,0,bewertung_ziel(geistX, geistY),1});		// x, y, Kosten von Start, Kosten zu Ziel, Bearbeitet ja/nein
		astern_rekursion(astern.get(0));

		tunnel_teleport ();		// 0->21		22->1

	}

	public void astern_rekursion(Integer[] kachel) {

		int x = kachel[0];
		int y = kachel[1];
		
		for(int xi = -1; xi<=1;xi++)
		{
			for(int yi = -1; yi<=1;yi++)
			{
				if(true)
				{
					astern.add(bewertung(xi,yi));
				}
			}
		}

	}

	public Integer[] bewertung(int x, int y) {		// x, y, Kosten von Start, Kosten zu Ziel

		return new Integer[]{x,y,bewertung_start(x, y),bewertung_ziel(x, y),0};
	}

	public int bewertung_start(int x, int y) {

		int x_wert = (int)Math.sqrt(((geistX-x)*(geistX-x)));
		int y_wert = (int)Math.sqrt(((geistY-y)*(geistY-y)));
		return x_wert+y_wert;
	}

	public int bewertung_ziel(int x, int y) {

		int x_wert = (int)Math.sqrt(((ziel_x-x)*(ziel_x-x)));
		int y_wert = (int)Math.sqrt(((ziel_y-y)*(ziel_y-y)));
		return x_wert+y_wert;
	}
}
