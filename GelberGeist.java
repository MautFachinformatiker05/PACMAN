public class GelberGeist extends RoterGeist {

	public GelberGeist(int _startX, int _startY) {
		super(_startX, _startY);

	}
	void move(){
		
		int [] zielYX;
		int _zielX=Game.feld.pac_x;
		int _zielY=Game.feld.pac_y;
		
		if (abstand(geistX, geistY, _zielX, _zielY)>6){
			zielYX=sektorenVerteidiger();
			_zielY=zielYX[0];
			_zielX=zielYX[1];
		}
		
		
		int xBewegung=-1;
		int yBewegung=0;
		
		// 1. Fall X-Kor -1
		double distance = abstand(geistX-1, geistY, _zielX, _zielY);
		if (isWall(geistY, geistX-1)){
			xBewegung=0;
		}
		
		// 2. Fall X-Kor +1
		double tempDistance=abstand(geistX+1, geistY, _zielX, _zielY);
		
		if (tempDistance<distance && !isWall(geistY, geistX+1)){
			distance=tempDistance;
			xBewegung=1;
		}
		
		// 3. Fall Y-Kor +1
		tempDistance=abstand(geistX, geistY+1, _zielX, _zielY);
		if (tempDistance<distance && !isWall(geistY+1, geistX)){
			distance=tempDistance;
			xBewegung=0;
			yBewegung=1;
		}
		
		// 4. Fall X-Kor -1
		tempDistance=abstand(geistX, geistY-1, _zielX, _zielY);
		if (tempDistance<distance && !isWall(geistY-1, geistX)){
			distance=tempDistance;
			xBewegung=0;
			yBewegung=-1;
		}
		
		System.out.println("Der Abstand ist " + distance);
		System.out.println("X : " +xBewegung);
		System.out.println("Y : " +yBewegung);
		
		geistX +=xBewegung;
		geistY+=yBewegung;
		
		
		
		
		
		
	}

	int [] sektorenVerteidiger(){
		int zielX=0;
		int zielY=0;
		
		int best_score=0;
		int temp_score=0;
		int best_sektor=0;
		
		final int ylength=27;
		final int xlength=23;
		
		
		for (int i=0;i <4;i++){
			temp_score=bewertung(0);
			if (temp_score>best_score){
				best_score=temp_score;
				best_sektor=i;
			}
			
		}
		int [] koord=new int [2];
		
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
		koord[0]=zielY;
		koord[1]=zielX;
		
		return koord;
		
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
