import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame{
	
	public Game() {
		setTitle("PACMAN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(600,600));
		this.pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		
		Game spiel = new Game();
		Spielfeld feld = new Spielfeld();
		spiel.add(feld);
		spiel.getContentPane().setPreferredSize(new Dimension(feld.breite,feld.hoehe));
		spiel.pack();
		spiel.setVisible(true);
		
		feld.ausgabe_konsole();
		System.out.println("TEST ABGESCHLOSSEN");
	}
}
