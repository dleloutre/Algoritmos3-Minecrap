package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;

public abstract class Hacha extends Herramienta {
	
	@Override
	public void golpear(Golpeable unGolpeable) {
		unGolpeable.recibirGolpe(this);
	}
	
	@Override
	public void aplicarReduccion(Madera madera){
		madera.reducirDurabilidad(this.fuerza);
	}
}
