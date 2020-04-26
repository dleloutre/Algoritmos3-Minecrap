package fiuba.algo3.modelo.material;

import fiuba.algo3.modelo.herramienta.Pico;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;

public class Piedra extends Material {
	
	private static int DURABILIDAD_PIEDRA=30;
	
	public Piedra() {
		super(DURABILIDAD_PIEDRA);
	}

	@Override
	public void recibirGolpe(Pico unPico) {
		this.reducirDurabilidad(unPico.getFuerza());
		unPico.desgastar();
	}
	
	@Override
	public void recibirGolpe(PicoDePiedra unPico) {
		unPico.aplicarReduccion(this);
		unPico.desgastar();
	}
	
}
