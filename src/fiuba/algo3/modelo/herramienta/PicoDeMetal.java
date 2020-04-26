package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteAbrupto;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Golpeable;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDeMetal extends Pico {
	
	private static int DURABILIDAD_PICO_DE_METAL=400;
	private static int USOS_PICO_DE_METAL=10;

	public PicoDeMetal() {
		this.fuerza = 12;
		this.desgaste = new DesgasteAbrupto(DURABILIDAD_PICO_DE_METAL, USOS_PICO_DE_METAL);
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
				grilla.posicionar(new Metal(), 0, 0);
		    	grilla.posicionar(new Metal(), 1, 0);
		    	grilla.posicionar(new Metal(), 2, 0);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);    
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new PicoDeMetal();
			}
		};
	}

}