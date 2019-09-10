public class GelberGeist extends RoterGeist {

	public GelberGeist(int _startX, int _startY) {
		super(_startX, _startY);

	}
	void move(){
		int best_score=0;
		int temp_score=0;
		int best_sektor=0;
		int zielX=0;
		int zielY=0;
		
		final int ylength=27;
		final int xlength=23;
		
		for (int i=0;i <4;i++){
			temp_score=bewertung(0);
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
			zielX=xlength/4;
			break;
		
		case 0:
			zielY=ylength/4;
			zielX=xlength/4;
			break;
		case 0:
			zielY=ylength/4;
			zielX=xlength/4;
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
				if (aktuellesFeld != 1) {
					score += aktuellesFeld;
				}
			}
		}

		return score;

	}

}
