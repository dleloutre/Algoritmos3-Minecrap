package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoFinoDeMetalYPiedra extends Pico {

	private static int DURABILIDAD_PICO_FINO=1000;
	private static double COEFICIENTE_PICO_FINO = 0.1;
	
	
	public PicoFinoDeMetalYPiedra(){
		int reductor = (int) (DURABILIDAD_PICO_FINO*COEFICIENTE_PICO_FINO);
		this.desgaste = new DesgasteLineal(DURABILIDAD_PICO_FINO, reductor);
		this.fuerza = 20;
	}
	
	@Override
	public void golpear(Golpeable unGolpeable) {
		unGolpeable.recibirGolpe(this);
	}
	
	@Override
	public void aplicarReduccion(Diamante diamante) {
		diamante.reducirDurabilidad(this.fuerza);
	}
	

	public static PlanoDeHerramienta plano() {
		return new PlanoDeHerramienta() {
			@Override
			public void inicializarPlano(GrillaDeMateriales grilla) {
		    	grilla.posicionar(new Metal(), 0, 0);
		    	grilla.posicionar(new Metal(), 1, 0);
		    	grilla.posicionar(new Metal(), 2, 0);
		    	grilla.posicionar(new Piedra(), 0, 1);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);   
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new PicoFinoDeMetalYPiedra();
			}
		};
	}
}
