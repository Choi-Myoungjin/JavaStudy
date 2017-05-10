package absrtact;

public class Game {
	Monster[] m = new Monster[] { new Orc(), new Elf() };

	public void attatk() {
		for (int i = 0; i < m.length; i++) {
			m[i].attack();
		}

	}

	public static void main(String[] args) {
		Game game = new Game();

		game.attatk();

	}
}
