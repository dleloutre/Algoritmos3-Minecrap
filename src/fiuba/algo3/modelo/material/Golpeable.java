package fiuba.algo3.modelo.material;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.Hacha;
import fiuba.algo3.modelo.herramienta.Pico;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;

public interface Golpeable extends Posicionable{
	
	public boolean estaRoto();
	public void recibirGolpe(Pico unPico);
	public void recibirGolpe(PicoDePiedra unPico);
	public void recibirGolpe(PicoFinoDeMetalYPiedra unPico);
	public void recibirGolpe(Hacha unHacha);
}
