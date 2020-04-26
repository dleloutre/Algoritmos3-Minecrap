package fiuba.algo3.modelo.herramienta;

import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.herramienta.plano.GrillaDeMateriales;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;

public class HachaDeMetal extends Hacha {
	
	private static int DURABILIDAD_HACHA_DE_METAL=400;
	private static int COEFICIENTE_HACHA_DE_METAL=2;
	
	public HachaDeMetal() {
		this.fuerza = 10;
		int reductor = this.fuerza/COEFICIENTE_HACHA_DE_METAL;
		this.desgaste = new DesgasteLineal(DURABILIDAD_HACHA_DE_METAL, reductor);
	}

	@Override
	public void aplicarReduccion(Material material) {
		// TODO Auto-generated method stub
		
	}
	
	public static PlanoDeHerramienta plano() {
		return new PlanoDeHerramienta() {
			@Override
			public void inicializarPlano(GrillaDeMateriales grilla) {
				grilla.posicionar(new Metal(), 0, 0);
				grilla.posicionar(new Metal(), 0, 1);
		    	grilla.posicionar(new Metal(), 1, 0);
		    	grilla.posicionar(new Madera(), 1, 1);
		    	grilla.posicionar(new Madera(), 1, 2);  
			}

			@Override
			public Herramienta fabricarHerramienta() {
				return new HachaDeMetal();
			}
			
		};
	}
}