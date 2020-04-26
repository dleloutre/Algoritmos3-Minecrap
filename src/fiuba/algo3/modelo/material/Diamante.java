package fiuba.algo3.modelo.material;

import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;

public class Diamante extends Material {
	
	private static int DURABILIDAD_DIAMANTE=100;
	
	public Diamante() {
		super(DURABILIDAD_DIAMANTE);
	}
	
	@Override
	public void recibirGolpe(PicoFinoDeMetalYPiedra unPico) {
		unPico.aplicarReduccion(this);
		unPico.desgastar();
	}

}
