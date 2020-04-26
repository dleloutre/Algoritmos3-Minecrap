package fiuba.algo3.modelo.grilla.celda;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.Hacha;
import fiuba.algo3.modelo.herramienta.Pico;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;
import fiuba.algo3.modelo.material.Golpeable;

public class EspacioVacio implements Posicionable, Golpeable {

	@Override
	public boolean estaRoto() {
		return false;
	}
	
	@Override
	public void recibirGolpe(Pico unPico) {
		
	}

	@Override
	public void recibirGolpe(PicoDePiedra unPico) {
		
	}

	@Override
	public void recibirGolpe(PicoFinoDeMetalYPiedra unPico) {
		
	}

	@Override
	public void recibirGolpe(Hacha unHacha) {
		
	}
	
	
}
