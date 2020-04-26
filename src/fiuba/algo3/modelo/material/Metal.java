package fiuba.algo3.modelo.material;

import fiuba.algo3.modelo.herramienta.PicoDePiedra;


public class Metal extends Material {
	
	private static int DURABILIDAD_METAL=50;
	
	public Metal() {
		super(DURABILIDAD_METAL);	
	}
	
	@Override
	public void recibirGolpe(PicoDePiedra unPico) {
		unPico.aplicarReduccion(this);
		unPico.desgastar();
	}

	
}
