package fiuba.algo3.modelo.desgaste;

public class DesgasteAbrupto extends Desgaste {
	int usos;
	
	public DesgasteAbrupto (int unaDurabilidad, int cantidadUsos) {
		super(unaDurabilidad);
		this.usos = cantidadUsos;
	}

	public void usar() {
		this.usos --;
		if (usos <= 0) {
			this.durabilidad = 0;
		}
	}

	@Override
	public void usar(int valor) {
		
	}

}
