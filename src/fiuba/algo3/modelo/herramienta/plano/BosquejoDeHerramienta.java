package fiuba.algo3.modelo.herramienta.plano;

import fiuba.algo3.modelo.grilla.Posicionable;

public class BosquejoDeHerramienta extends PlanoDeHerramienta {

	public void posicionar(Posicionable posicionable, int x, int y) {
		this.grilla.posicionar(posicionable, x, y);
	}

	public Posicionable remover(int x, int y) {
		return this.grilla.remover(x, y);
	}

	public void vaciar() {
		this.grilla = new GrillaDeMateriales();
	}

}
