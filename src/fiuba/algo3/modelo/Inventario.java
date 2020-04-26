package fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.function.BiConsumer;

import fiuba.algo3.modelo.grilla.Grilla;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.grilla.celda.Celda;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.herramienta.plano.BosquejoDeHerramienta;

public class Inventario {
	
	private Grilla almacenamiento;
	private BosquejoDeHerramienta bosquejo;
	private Celda herramientaFabricada; 
	
	public Inventario() {
		this.almacenamiento = new Grilla(15,5, new ArrayList<Posicionable>());
		this.bosquejo = new BosquejoDeHerramienta();
		this.herramientaFabricada = new Celda(1, 1);
	}
	
	public Inventario(ArrayList<Posicionable> posicionablesIniciales) {
		this.almacenamiento = new Grilla(15,5,posicionablesIniciales);
		this.bosquejo = new BosquejoDeHerramienta();
		this.herramientaFabricada = new Celda(1, 1);
	}

	public BosquejoDeHerramienta getBosquejo() {
		return bosquejo;
	}
	
	public void almacenar(Posicionable posicionable) throws AlmacenamientoLlenoException {
		Posicion posicion = almacenamiento.primerPosicionLibre();
		if(posicion == null)
			throw new AlmacenamientoLlenoException();
		
		almacenamiento.posicionar(posicionable, posicion.getX(), posicion.getY());
	}
	
	public void almacenarEn(Posicionable posicionable, int x, int y) {
		almacenamiento.posicionar(posicionable, x, y);
	}
	

	public Posicionable obtener(int x, int y) {
		return almacenamiento.obtener(x, y);
	}

	public Posicionable remover(int x, int y) {
		 return almacenamiento.remover(x, y);		
	}
	
	public void remover(Posicionable posicionable){
		this.almacenamiento.remover(posicionable);
	}
	
	public void paraCadaPosicionableDelAlmacenamiento(BiConsumer<Posicionable, Posicion> consumer) {
		almacenamiento.paraCadaPosicionable(consumer);
	}
	
	public void paraCadaPosicionableDelBosquejo(BiConsumer<Posicionable, Posicion> consumer) {
		bosquejo.paraCadaPosicionable(consumer);
	}


	public Posicion obtenerPosicion(Posicionable posicionable) {
		return almacenamiento.obtenerPosicion(posicionable);
	}
	
	public void setHerramientaFabricada(Herramienta herramienta) {
		this.herramientaFabricada.setPosicionable(herramienta);
	}

	public void removerHerramientaFabricada() {
		this.herramientaFabricada.vaciar();
	}

	public Posicionable getHerramientaFabricada() {
		return this.herramientaFabricada.getPosicionable();
	}
}