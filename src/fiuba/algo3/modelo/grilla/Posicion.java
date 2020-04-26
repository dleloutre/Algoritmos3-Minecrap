package fiuba.algo3.modelo.grilla;

public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Posicion otraPosicion = (Posicion) obj;
		return this.x == otraPosicion.getX() &&
				this.y == otraPosicion.getY();
	}
}
