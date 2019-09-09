

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Steuerung extends KeyAdapter {

	@Override 
	public void keyPressed(KeyEvent e){

		System.out.println("IN KEYPRESSED");
		int key_id = e.getKeyCode(); 
		int dir; 

		//LEFT, UP, RIGHT, DOWN
		int [] vx =  {-1, 0, +1, 0}; 
		int [] vy =  {0, -1, 0, +1};

		switch (key_id){
		case KeyEvent.VK_LEFT: 
			System.out.println("L");
			dir = 0; 
			break; 
		case KeyEvent.VK_UP: 
			dir = 1; 
			System.out.println("U");
			break; 
		case KeyEvent.VK_RIGHT: 
			dir = 2; 
			System.out.println("R");
			break; 
		case KeyEvent.VK_DOWN:
			System.out.println("D");
			dir = 3; 
			break; 
		}

		//Schnittstelle (Bewegungsrichtung von Pacman wird geändert): 
		//spielfeldObjekt.posPacmanX += vx[dir]
		//spielfeldObjekt.posPacmanY += vy[dir]
	}


}

