package fiuba.algo3.modelo.herramienta.plano;

import fiuba.algo3.modelo.grilla.GrillaCuadrada;
import fiuba.algo3.modelo.material.Material;

public class GrillaDeMateriales extends GrillaCuadrada {
	
	private static final int TAMANIO = 3;

	public GrillaDeMateriales() {
		super(TAMANIO);
	}
	
	public void posicionar(Material material, int x, int y) {
		super.posicionar(material, x, y);
	}

}
