package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDePiedra extends Pico {
	
	private static int DURABILIDAD_PICO_DE_PIEDRA=200;
	private static double COEFICIENTE_PICO_DE_PIEDRA=1.5;
	
	public PicoDePiedra() {
		this.fuerza = 4;
		int reductor = (int) Math.round((double)this.fuerza/COEFICIENTE_PICO_DE_PIEDRA);
		this.desgaste = new DesgasteLineal(DURABILIDAD_PICO_DE_PIEDRA, reductor);
	}
	
	@Override
	public void golpear(Golpeable unGolpeable) {
		unGolpeable.recibirGolpe(this);
	}
	
	@Override
	public void aplicarReduccion(Metal metal) {
		metal.reducirDurabilidad(fuerza);
	}
	
	@Override
	public void aplicarReduccion(Piedra piedra) {
		piedra.reducirDurabilidad(fuerza);
	}

	public static PlanoDeHerramienta plano() {
		return new PlanoDeHerramienta() {
			@Override
			public void inicializarPlano(GrillaDeMateriales grilla) {
				grilla.posicionar(new Piedra(), 0, 0);
		    	grilla.posicionar(new Piedra(), 1, 0);
		    	grilla.posicionar(new Piedra(), 2, 0);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);   
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new PicoDePiedra();
			}
		};
	}
}