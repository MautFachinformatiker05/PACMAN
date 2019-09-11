public class GelberGeist extends Geist {

	
	public GelberGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);
		
	}

	void move(){
		zielX=Game.feld.pac_x;
		zielY=Game.feld.pac_y;
		int vxAchse=0;
		int vyAchse=0;
		int xTemp=0;
		int yTemp=0;
		int xWhile=0;
		int yWhile=0;
		int zufall=0;
		int [] zielYX;
		xTemp=geistX;
		yTemp=geistY;
		
		
		if (abstand(geistX, geistY, zielX, zielY)>5){
			zielYX=sektorenVerteidiger();
			zielY=zielYX[0];
			zielX=zielYX[1];
			System.out.println("Gelber Geist");
			System.out.println("Der Abstand ist "+ abstand(geistX, geistY, zielX, zielY));
			System.out.println("Verteidige Sektor");
			System.out.println("Ziel X "+zielX);
			System.out.println("Ziel Y "+zielY);
		}
		
		
		xTemp=geistX;
		yTemp=geistY;
		
		
		vyAchse=Integer.signum(zielY-geistY);
		vxAchse=Integer.signum(zielX-geistX);
		// Gerader Weg
		if (vyAchse!=0){
			geistY+=vyAchse;
		}
		else{
			geistX+=vxAchse;
		}
		
		
		while (Game.feld.feld[geistY][geistX]==1){

		zufall=(int)(Math.random()*4+1);
		xWhile=xTemp;
		yWhile=yTemp;

		if(zufall==1){
			xWhile--;
		}
		else if (zufall==2){
			xWhile++;
		}
		else if (zufall==3){
			yWhile--;
		}
		else {
			yWhile++;
		}
		
		geistX=xWhile;
		geistY=yWhile;
		
		tunnel_teleport ();
		
	}
		
		
		
		
		
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
			temp_score=bewertung(i);
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
				if (aktuellesFeld != 1) {
					score += aktuellesFeld;
				}
			}
			
		}

		
		return score;

	}

}
