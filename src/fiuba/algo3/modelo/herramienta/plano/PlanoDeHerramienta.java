package fiuba.algo3.modelo.herramienta.plano;

import java.util.function.BiConsumer;

import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.Herramienta;

public abstract class PlanoDeHerramienta implements Plano{
	
	protected GrillaDeMateriales grilla;
	
	public PlanoDeHerramienta() {
		this.grilla = new GrillaDeMateriales();
		inicializarPlano(this.grilla);
	}

	@Override
	public boolean equals(Object otroPlano) {
		return ((PlanoDeHerramienta)otroPlano).igualGrilla(this.grilla);
	}
	
	public boolean igualGrilla(GrillaDeMateriales grilla) {
		return this.grilla.equals(grilla);
	}
	
	public void inicializarPlano(GrillaDeMateriales grilla) {
		
	}
	public Herramienta fabricarHerramienta() throws PlanoInexistenteException {
		throw new PlanoInexistenteException();
	}
	
	public void paraCadaPosicionable(BiConsumer<Posicionable, Posicion> consumer) {
		grilla.paraCadaPosicionable(consumer);
	}
	
}
