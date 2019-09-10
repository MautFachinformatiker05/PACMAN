import java.awt.Dimension;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Game extends JFrame{
	
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
	}

	public static void main(String[] args) {
		
		Game spiel = new Game();
		feld = new Spielfeld();
		spiel.add(feld);
		spiel.getContentPane().setPreferredSize(new Dimension(feld.breite,feld.hoehe));
		spiel.pack();
		spiel.setVisible(true);
		spiel.addKeyListener(new Steuerung ());
		
		while(running && feld.pac_leben!=0) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			feld.update();
		}
		
	
		System.out.println("TEST ABGESCHLOSSEN");
	}
}
