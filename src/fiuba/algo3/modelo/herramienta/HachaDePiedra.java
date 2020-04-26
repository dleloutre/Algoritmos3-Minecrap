package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Piedra;

public class HachaDePiedra extends Hacha {
	
	private static int DURABILIDAD_HACHA_DE_PIEDRA=200;
	
	public HachaDePiedra() {
		this.fuerza = 5;
		this.desgaste = new DesgasteLineal(DURABILIDAD_HACHA_DE_PIEDRA, this.fuerza);
	}

	@Override
	public void aplicarReduccion(Material material) {
		
	}
	
	public static PlanoDeHerramienta plano() {
		return new PlanoDeHerramienta() {
			@Override
			public void inicializarPlano(GrillaDeMateriales grilla) {
				grilla.posicionar(new Piedra(), 0, 0);
		    	grilla.posicionar(new Piedra(), 0, 1);
		    	grilla.posicionar(new Piedra(), 1, 0);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);   
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new HachaDePiedra();
			}
		};
	}
	
}