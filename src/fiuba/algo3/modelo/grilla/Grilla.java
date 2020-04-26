package fiuba.algo3.modelo.grilla;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import fiuba.algo3.modelo.grilla.celda.Celda;


public class Grilla {

    protected Celda[][] celdas;
    protected HashMap<Posicionable, Posicion> posicionesPorPosicionable;
	private int ancho;
	private int largo;
	
	public Grilla (int ancho, int largo) {
		this.ancho = ancho;
    	this.largo = largo;
    	this.celdas = new Celda[ancho][largo];
    	this.posicionesPorPosicionable = new HashMap<Posicionable, Posicion>();
    	for (int x = 0; x < ancho; x++)
    		for (int y = 0; y < largo; y++)
    			this.celdas[x][y] = new Celda(x,y);  
	}
    
	public Grilla (int ancho, int largo, Map<Posicion, Posicionable> posicionesIniciales) {
		this.ancho = ancho;
    	this.largo = largo;
    	this.celdas = new Celda[ancho][largo];
    	this.posicionesPorPosicionable = new HashMap<Posicionable, Posicion>();
    	for (int x = 0; x < ancho; x++)
    		for (int y = 0; y < largo; y++)
    			this.celdas[x][y] = new Celda(x,y);  
    	
    	posicionesIniciales.forEach((posicion, posicionable) -> {
    		posicionar(posicionable, posicion.getX(), posicion.getY());
    	});
	}
	
    public Grilla (int ancho, int largo, List<Posicionable> posicionablesIniciales) {
    	this.ancho = ancho;
    	this.largo = largo;
    	this.celdas = new Celda[ancho][largo];
    	this.posicionesPorPosicionable = new HashMap<Posicionable, Posicion>();
    	
    	for (int x = 0; x < ancho; x++)
    		for (int y = 0; y < largo; y++)
    			this.celdas[x][y] = new Celda(x,y);  
    	
    	posicionablesIniciales.forEach((posicionable) -> {
    		Posicion posicion = primerPosicionLibre();
    		posicionar(posicionable, posicion.getX(), posicion.getY());
    	});
    }
    
    public Posicionable obtener(int x, int y) {
    	return celdas[x][y].getPosicionable();
    }
    
    public void posicionar(Posicionable posicionable, int x, int y) {
    	celdas[x][y].setPosicionable(posicionable);
    	posicionesPorPosicionable.put(posicionable, new Posicion(x, y));
    }
    
    public Posicionable remover(int x, int y) {
    	Posicionable posicionable = celdas[x][y].vaciar();
    	posicionesPorPosicionable.remove(posicionable);
    	return posicionable;
    }
    
    public void remover(Posicionable p) {
    	Posicion posicion = obtenerPosicion(p);
    	celdas[posicion.getX()][posicion.getY()].vaciar();
    	posicionesPorPosicionable.remove(p);
    }
    
    public Boolean estaOcupada(int x, int y) {
		return celdas[x][y].estaOcupada();
    }
 
	
	public Posicion obtenerPosicion(Posicionable posicionable) {
		return posicionesPorPosicionable.get(posicionable);
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Grilla)obj).celdasIguales(this.celdas);
	}
	
	public boolean celdasIguales(Celda[][] celdas) {
		boolean iguales = true;
        for (int x = 0; x < ancho; x++)
        	for (int y = 0; y < largo; y++)
        		iguales &= this.celdas[x][y].equals(celdas[x][y]);
        return iguales;
	}
	
	public Posicion primerPosicionLibre() {
		for(int x = 0; x < ancho ; x++)
			for(int y = 0; y < largo ; y++)
				if(!celdas[x][y].estaOcupada())
					return new Posicion(x, y);
		return null;
	}	
	
	public void paraCadaPosicionable(BiConsumer<Posicionable, Posicion> consumer) {
		for (int x = 0; x < ancho; x++)
        	for (int y = 0; y < largo; y++)
        		consumer.accept(celdas[x][y].getPosicionable(), new Posicion(x, y));
	}	
	
	public void mover(Posicion desde, Posicion hacia) {
		Posicionable posicionable = obtener(desde.getX(), desde.getY());
		boolean movido = this.celdas[hacia.getX()][hacia.getY()].moverContenidoDe(this.celdas[desde.getX()][desde.getY()]);
		if (movido) {
			posicionesPorPosicionable.put(posicionable, hacia);
		}
	}
	
}