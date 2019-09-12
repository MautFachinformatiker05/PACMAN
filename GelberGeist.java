public class GelberGeist extends Geist {


	public GelberGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	void planen(){
		
		zielX=Game.feld.pac_x;
		zielY=Game.feld.pac_y;
		checkFrightened();
		int zufall;
		int counterSektor=0;
		
		
		

		if (abstand(geistX, geistY, zielX, zielY)>5){
			sektorenVerteidiger();
			

		}
		
		
		boolean geraderWegGefunden = false;
		int vyAchse = Integer.signum(zielY - geistY);
		int vxAchse = Integer.signum(zielX - geistX);
		// Gerader Weg

		if (vyAchse != 0) {

			if (vyAchse < 0 && !isWall(geistY - 1, geistX)) {
				richtung = OBEN;
				geraderWegGefunden = true;
			}
			else if (vyAchse > 0 && !isWall(geistY + 1, geistX)) {
				richtung = UNTEN;
				geraderWegGefunden = true;
			} 
		}
		else {

			if (vxAchse < 0 && !isWall(geistY, geistX - 1)) {
				richtung = LINKS;
				geraderWegGefunden = true;
			}
			else if (vxAchse > 0 && !isWall(geistY, geistX + 1)) {
				richtung = RECHTS;
				geraderWegGefunden = true;
			}

		}

		// Wenn kein gerader Weg gefunden ausprobieren	
		
		while (!geraderWegGefunden) {
			zufall = (int) (Math.random() * 4 + 1);

			if (zufall == 1 && !isWall(geistY - 1, geistX)) {
				richtung = OBEN;
				geraderWegGefunden = true;
			} else if (zufall == 2 && !isWall(geistY + 1, geistX)) {
				richtung = UNTEN;
				geraderWegGefunden = true;
			} else if (zufall == 3 && !isWall(geistY, geistX - 1)) {
				richtung = LINKS;
				geraderWegGefunden = true;
			} else if (zufall == 4 && !isWall(geistY, geistX + 1)) {
				richtung = RECHTS;
				geraderWegGefunden = true;
			}

		}
		move(richtung);

		tunnel_teleport ();


	}

	void  sektorenVerteidiger(){
		

		int best_score=0;
		int temp_score=0;
		int best_sektor=0;

		final int ylength=27;
		final int xlength=23;


		for (int i=0;i <4;i++){
			temp_score=bewertung(i);
			if (temp_score>best_score){
				best_score=temp_score;
				best_sektor=i;
			}

		}
	

		switch (best_sektor){
		case 0:
			zielY=ylength/4;
			zielX=xlength/4;
			break;
		case 1:
			zielY=ylength/4;
			zielX=xlength/4*3;
			break;

		case 2:
			zielY=ylength/4*3;
			zielX=xlength/4;
			break;
		case 3:
			zielY=ylength/4*3;
			zielX=xlength/4*3;
			break;
		}
		

	}
	int bewertung(int sektor) {
		int score = 0;
		// 0=nix, 1=Wand, 2=Punkt; 3=Power ;4=Kirsche
		int ySektor = 26;
		int xSektor = 22;

		int yStart = 0;
		int xStart = 0;

		int aktuellesFeld = 0;

		switch (sektor) {
		case 0:
			ySektor = 14;
			xSektor = 11;
			break;
		case 1:
			xStart = 11;
			xSektor = 22;
			ySektor=14;
			break;
		case 2:
			yStart = 14;
			xSektor = 11;
			break;
		case 3:
			xStart = 11;
			yStart = 14;
			break;
		}
		for (int i = yStart; i < ySektor; i++) {
			for (int j = xStart; j < xSektor; j++) {
				aktuellesFeld = Game.feld.feld[i][j];
				if (aktuellesFeld != 1 || aktuellesFeld !=5) {
					score += aktuellesFeld;
				}
			}

		}


		return score;

	}

}
