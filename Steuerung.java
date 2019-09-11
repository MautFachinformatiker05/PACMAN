

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Steuerung extends KeyAdapter {


	public void keyTyped(KeyEvent e) {
		
		
	}
	
	
	int lastPressedKeyId = 0; 
	
	public void keyReleased(KeyEvent e) {

		super.keyReleased(e);
		
		int key_id = e.getKeyCode();
		
		if (key_id == lastPressedKeyId) {
			Game.feld.pac_richtung=4;
		}
		
	}

	@Override 
	public void keyPressed(KeyEvent e){

		lastPressedKeyId = e.getKeyCode();
				
		if (Game.running) {
			switch (lastPressedKeyId){

			case KeyEvent.VK_LEFT: 
				//			System.out.println("L");
				Game.feld.pac_richtung = 0;
				break; 
			case KeyEvent.VK_UP: 
				Game.feld.pac_richtung = 1; 
				//			System.out.println("U");
				break; 
			case KeyEvent.VK_RIGHT: 
				Game.feld.pac_richtung = 2; 
				//			System.out.println("R");
				break; 
			case KeyEvent.VK_DOWN:
				//			System.out.println("D");
				Game.feld.pac_richtung = 3; 
				break;
			}

		}

		//Schnittstelle (Bewegungsrichtung von Pacman wird geändert): 
		//spielfeldObjekt.posPacmanX += vx[dir]
		//spielfeldObjekt.posPacmanY += vy[dir]
	}


}

