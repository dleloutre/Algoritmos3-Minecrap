package fiuba.algo3.modelo.material;


import fiuba.algo3.modelo.desgaste.Desgaste;
import fiuba.algo3.modelo.desgaste.DesgasteVariable;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.Hacha;
import fiuba.algo3.modelo.herramienta.Pico;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;

public abstract class Material implements Posicionable, Golpeable{

	protected Desgaste desgaste;
	
	public Material(int durabilidad) {
		this.desgaste = new DesgasteVariable(durabilidad);
	}
	
	public int getDurabilidad() {
		return desgaste.getDurabilidad();
	}
	
	public boolean estaRoto() {
		return desgaste.estaRoto();
	}
	
	public void reducirDurabilidad(int valor) {
		desgaste.usar(valor);
	}
	
	public void recibirGolpe(Pico unPico) {
		
	}
	
	public void recibirGolpe(PicoDePiedra unPico) {
		
	}
	
	public void recibirGolpe(PicoFinoDeMetalYPiedra unPico){
		
	}
	
	public void recibirGolpe(Hacha unHacha) {
		
	}
}
