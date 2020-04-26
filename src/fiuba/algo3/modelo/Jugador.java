package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.mapa.Orientable;

public class Jugador implements Orientable{
	private String nombre;
	private Herramienta herramienta;
	private Inventario inventario;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		this.herramienta = new HachaDeMadera();
		this.inventario = new Inventario();
	}
	
	public Jugador(String nombre, ArrayList<Posicionable> posicionablesIniciales) {
		this.nombre = nombre;
		this.herramienta = new HachaDeMadera();
		this.inventario = new Inventario(posicionablesIniciales);
	}

	public void setName(String nuevoNombre) {
		this.nombre = nuevoNombre;	
	}
	
	public String getNombre() {
		return nombre;
	}

	public Herramienta getHerramienta() {
		return herramienta;
	}
	
	public void setHerramienta(Herramienta unaHerramienta) {
		this.herramienta = unaHerramienta;
	}

	public void guardar(Herramienta herramientaActual) throws AlmacenamientoLlenoException {
		this.inventario.almacenar(herramientaActual);
		this.setHerramienta(null);
	}

//	public void equiparse(Herramienta unaHerramienta) {
//		if(this.inventario.contiene(unaHerramienta)) {
//			this.inventario.remover(unaHerramienta);
//			this.setHerramienta(unaHerramienta);
//		}
//	}
	

	public Inventario getInventario() {
		return inventario;
	}
	
}