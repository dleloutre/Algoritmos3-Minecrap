package fiuba.algo3.modelo.desgaste;

public class DesgasteLineal extends Desgaste {
	
	private double reduccion;
	
	public DesgasteLineal (int unaDurabilidad, double unaReduccion) {
		super(unaDurabilidad);
		this.reduccion = unaReduccion;
	}
	
	
	@Override
	public void usar() {
		this.durabilidad -= reduccion;
	}

	@Override
	public void usar(int valor) {
		
		
	}

	

	
}
