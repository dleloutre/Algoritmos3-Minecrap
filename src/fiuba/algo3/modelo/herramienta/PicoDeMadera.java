package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDeMadera extends Pico {
	
	private static int DURABILIDAD_PICO_DE_MADERA=100;

	public PicoDeMadera() {
		this.fuerza = 2;
		this.desgaste = new DesgasteLineal(DURABILIDAD_PICO_DE_MADERA, this.fuerza);
	}

	@Override
	public void golpear(Golpeable unGolpeable) {
		unGolpeable.recibirGolpe(this);
	}
	
	@Override
	public void aplicarReduccion(Piedra piedra) {
		piedra.reducirDurabilidad(this.fuerza);
	}

	public static PlanoDeHerramienta plano() {
		return new PlanoDeHerramienta() {
			@Override
			public void inicializarPlano(GrillaDeMateriales grilla) {
				grilla.posicionar(new Madera(), 0, 0);
		    	grilla.posicionar(new Madera(), 1, 0);
		    	grilla.posicionar(new Madera(), 2, 0);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);   
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new PicoDeMadera();
			}
		};
	}

}