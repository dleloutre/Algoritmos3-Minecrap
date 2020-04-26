package fiuba.algo3.modelo.desgaste;

public abstract class Desgaste {
	
	protected int durabilidad;
	
	public Desgaste(int durabilidad) {
		this.durabilidad = durabilidad;
	}
	
	public int getDurabilidad() {
		return this.durabilidad;
	}
	
	public abstract void usar();
	public abstract void usar(int valor);

	public boolean estaRoto() {
		return durabilidad <= 0;
	}
	
	
}
