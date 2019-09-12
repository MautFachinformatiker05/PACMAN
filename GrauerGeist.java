import java.util.ArrayList;

public class GrauerGeist extends Geist {
	int tunnelCounter;
	

	public GrauerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);
		tunnelCounter=0;

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
		
		if (isTunnel() && tunnelCounter==0){
			
			if (gespeicherteRichtung==LINKS){
				tunnelCounter=lengthHorizTunnelLeft();
			}
			else if (gespeicherteRichtung==RECHTS){
				tunnelCounter=lengthHorizTunnelRight();
			}
			else if ( gespeicherteRichtung==OBEN){
				tunnelCounter=lengthVertTunnelUp();
			}
			else if (gespeicherteRichtung==UNTEN){
				tunnelCounter=lengthVertTunnelDown();
			}
			System.out.println("Erhöhe Tunnelzähler jetzt bei " +tunnelCounter);
		}
		
		if (tunnelCounter>0){
			move(gespeicherteRichtung);
			System.out.println("Denke ich bin im Tunnel, Länge " +tunnelCounter);
			tunnelCounter--;
		}
		else {
		
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
		
		}
		tunnel_teleport();

	}
	
	boolean isTunnel(){
		
		System.out.println(gespeicherteRichtung);
		if ((gespeicherteRichtung==RECHTS || gespeicherteRichtung==LINKS) && isUpDownDoubleWall(geistY, geistX) ){
			System.out.println("Oben Unten Mauer isTunnel");
			return true;
			
			
		}
		else if ((gespeicherteRichtung==OBEN || gespeicherteRichtung==UNTEN) && isLeftRightDoubleWall(geistY, geistX)){
			System.out.println("Links Rechts Mauer isTunnel");
			return true;
		}
		
		
		return false;
	}
	
	int lengthVertTunnelDown(){
		int tunnelLength=0;
		for (int i=0;i<10;i++){
			if (geistY+i>26){
				break;
			}
			if (!isWall(geistY+i, geistX) && isLeftRightDoubleWall(geistY+i, geistX)){
				tunnelLength=i;
			}
		}
		return tunnelLength;
	}
	
	int lengthVertTunnelUp(){
		int tunnelLength=0;
		for (int i=0;i<10;i++){
			if (geistY-i<0){
				break;
			}
			if (!isWall(geistY-i, geistX)&& !isLeftRightDoubleWall(geistY-i, geistX)){
				tunnelLength=i;
			}
		}
		return tunnelLength;
	}
	
	int lengthHorizTunnelRight(){
		int tunnelLength=0;
		for (int i=0;i<10;i++){
			if (geistX+i>23){
				break;
			}
			if (!isWall(geistY, geistX+i) &&  isUpDownDoubleWall(geistY, geistX+i)){
				tunnelLength=i;
			}
		}
		return tunnelLength;
	}
	int lengthHorizTunnelLeft(){
		int tunnelLength=0;
		for (int i=0;i<10;i++){
			if (geistX-i<0){
				break;
			}
			if (!isWall(geistY, geistX-i)&&  isUpDownDoubleWall(geistY, geistX-i)){
				tunnelLength=i;
			}
		}
		return tunnelLength;
	}
	
	
	
	boolean isUpDownDoubleWall(int _y , int _x ){
		if (isWall(_y-1, _x)&&isWall(_y+1, _x)){
			System.out.println("Oben Unten");
			return true;
		}
		System.out.println("isUpDownDoubleWall");
		return false;
	}
	boolean isLeftRightDoubleWall(int _y , int _x ){
		if (isWall(_y, _x -1)&&isWall(_y, _x +1)){
			System.out.println("Links Rechts");
			return true;
		}
		System.out.println("isLeftRightDoubleWall");
		return false;
	}

}
