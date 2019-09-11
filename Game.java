import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JFrame implements ActionListener{
	
	public static Spielfeld feld ;
	public static boolean running=true;
	public static boolean frightened=false;
	public static int counter = 0;
	
	public Game() {
		setTitle("PACMAN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(600,600));
		this.pack();
		setLocationRelativeTo(null);
		setResizable(false);
		Timer timer = new Timer(250,this);
		timer.start(); 
	}

	public static void main(String[] args) {
		
		Game spiel = new Game();
		feld = new Spielfeld();
		spiel.add(feld);
		spiel.getContentPane().setPreferredSize(new Dimension(feld.breite,feld.hoehe));
		spiel.pack();
		spiel.setVisible(true);
		spiel.addKeyListener(new Steuerung ());
		
		System.out.println("TEST ABGESCHLOSSEN");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(running && feld.pac_leben!=0) {
			feld.update();
			this.setTitle("PACMAN     Score: "+feld.score);
		}
	}
}
