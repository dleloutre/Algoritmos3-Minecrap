package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.Desgaste;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public abstract class Herramienta implements Posicionable{
	
	protected Desgaste desgaste;
	protected int fuerza;
	
	public int getDurabilidad() {
		return this.desgaste.getDurabilidad();
	}

	public int getFuerza() {
		return this.fuerza;
	}
	
	public void desgastar() {
		this.desgaste.usar();
	}
	
	public boolean estaRota(){
		return this.desgaste.estaRoto();
	}
	
	public abstract void golpear(Golpeable unGolpeable);
	
	public void aplicarReduccion(Material material) {}
	public void aplicarReduccion(Madera madera) {}
	public void aplicarReduccion(Metal metal) {}
	public void aplicarReduccion(Piedra piedra) {}
	public void aplicarReduccion(Diamante diamante) {}
	
}
