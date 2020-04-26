package fiuba.algo3.modelo.desgaste;

public class DesgasteVariable extends Desgaste {
	
	public DesgasteVariable(int durabilidad) {
		super(durabilidad);
	}

	@Override
	public void usar(int valor) {
		this.durabilidad -= valor;
	}

	@Override
	public void usar() {
		
	}

}
