import java.awt.Graphics;
import java.util.ArrayList;

public class GrunerGeist extends Geist {
	ArrayList<Integer[]> astern = new ArrayList<Integer[]>();
	int ziel_x ;
	int ziel_y ;
	int neue_richtung = 4;
	int vorheriges_x = geistX;
	int vorheriges_y = geistY;
	int zahl = 0;
	int zahl2 = 0;

	public GrunerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void planen() {			
		astern.clear();
		zahl = 0;
		ziel_x = Game.feld.pac_x;
		ziel_y = Game.feld.pac_y;
		astern.add(new Integer[]{geistX,geistY,0,bewertung_ziel(geistX, geistY),1});		// x, y, Kosten von Start, Kosten zu Ziel, Bearbeitet ja/nein
		neue_richtung = astern_rekursion(astern.get(0));
		System.out.println("Anzahl Aufrufe: "+zahl+"\t Listenobjekte: "+astern.size());
		move(neue_richtung);
		tunnel_teleport ();		// 0->21		22->1

	}

	public int astern_rekursion(Integer[] kachel) {

		zahl++;
		if(kachel[3]==0)	// Kosten zum Ziel
		{
			return richtung_bestimmen(kachel);
		}

		else {
			int x = kachel[0];
			int y = kachel[1];

			for(int xi = -1; xi<=1;xi++)
			{
				for(int yi = -1; yi<=1;yi++)
				{
					if(!(xi==0 && yi==0) && !isWall(y+yi,x+xi))		// die kachel wird natürlich ausgelassen
					{
						Integer[] dieses_element = suche_nach_nicht_bearbeitet(x+xi,y+yi);
						for(int i=0;i<100;i++)
							astern.remove(dieses_element);
						if(dieses_element[4]==0 || dieses_element[2]==10000)	// falls ein nicht bearbeitetes Element gefunden wurde ODER die Suche abgebrochen worden ist
						{
							Integer[] vergleich = bewertung(x+xi,y+yi,kachel);
							if(dieses_element[2]==10000) {
								astern.add(bewertung(x+xi,y+yi,kachel));
							}
						}
					}
				}   
			}
			kachel[4] = 1;
			Integer[] nächstes_element = suche_kleinste_Fcost();
			if (nächstes_element[4]==0)
				astern_rekursion(nächstes_element);	// mache mit kleinster Fcost weiter

			return richtung_bestimmen(kachel);
		}
	}

	public int richtung_bestimmen(Integer[] kachel) {
		if (kachel[2]<1)	// Direkt daneben?
		{
			if(kachel[0]<geistX)
				return LINKS;
			else if(kachel[0]>geistX)
				return RECHTS;
			else if(kachel[1]<geistY)
				return OBEN;
			else
				return UNTEN;
		}
		else return 4;			// keine Richtung, der nächste Funktionsaufruf wird das dann immer überschreiben
	}

	public Integer[] bewertung(int x, int y, Integer[] kachel) {		// x, y, Kosten von Start, Kosten zu Ziel, Bearbeitet ja/nein

		return new Integer[]{x,y,bewertung_start(x, y,kachel),bewertung_ziel(x, y),0};
	}

	public int bewertung_start(int x, int y, Integer[] kachel) {

		int wert = 0;
		wert += (int)Math.sqrt(((kachel[0]-x)*(kachel[0]-x)));
		wert += (int)Math.sqrt(((kachel[1]-y)*(kachel[1]-y)));
		return wert;
	}

	public int bewertung_ziel(int x, int y) {

		int x_wert = (int)Math.sqrt(((ziel_x-x)*(ziel_x-x)));
		int y_wert = (int)Math.sqrt(((ziel_y-y)*(ziel_y-y)));
		return x_wert+y_wert;
	}

	public Integer[] suche_nach_nicht_bearbeitet(int x_liste, int y_liste) {	// x, y, Kosten von Start, Kosten zu Ziel, Bearbeitet ja/nein

		for (Integer[] integers : astern) {

			if (integers[0]==x_liste && integers[1]==y_liste && integers[4]==0)
			{
				return integers;
			}
		}
		return new Integer[] {x_liste,y_liste,10000,10000,1};
	}

	public Integer[] suche_kleinste_Fcost() {	// x, y, Kosten von Start, Kosten zu Ziel, Bearbeitet ja/nein

		Integer[] gewinner = new Integer[] {0,0,10000,10000,1};
		for (Integer[] integers : astern) {
			if(integers[4]==0 && (integers[2]+integers[3])<(gewinner[2]+gewinner[3]) ) {
				gewinner = integers;
			}
		}
		return gewinner;
	}
}
