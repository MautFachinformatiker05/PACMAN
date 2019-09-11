import java.util.ArrayList;

public class GrauerGeist extends Geist {
	ArrayList<Integer> richtungen;
	public GrauerGeist(int _startX, int _startY, String bildText) {
		super(_startX, _startY, bildText);

	}

	@Override
	void move() {
		richtungen=new ArrayList<>();
		zielY = Game.feld.pac_y;
		zielX = Game.feld.pac_x;
		checkFrightened();

		
		



	}

}
