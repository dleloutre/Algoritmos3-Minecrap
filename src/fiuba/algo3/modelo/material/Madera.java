package fiuba.algo3.modelo.material;

import fiuba.algo3.modelo.herramienta.Hacha;

public class Madera extends Material {
	
	private static int DURABILIDAD_MADERA=10;

	public Madera() {
		super(DURABILIDAD_MADERA);
	}
	
	@Override
	public void recibirGolpe(Hacha unHacha) {
		unHacha.aplicarReduccion(this);
		unHacha.desgastar();
	}
}
