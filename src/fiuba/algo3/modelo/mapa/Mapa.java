package fiuba.algo3.modelo.mapa;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import fiuba.algo3.modelo.grilla.GrillaCuadrada;
import fiuba.algo3.modelo.grilla.Posicion;
import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.mapa.orientacion.Orientacion;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionAbajo;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionArriba;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionDerecha;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionIzquierda;

public class Mapa {
	
	private GrillaCuadrada grilla;
	private HashMap<Orientable, Orientacion> orientaciones;
	static int LIMITE_BORDE_SUPERIOR = -1;
	static int LIMITE_BORDE_INFERIOR = 20 ;
	static int LIMITE_BORDE_DERECHO = 20;
	static int LIMITE_BORDE_IZQUIERDO = -1;

	public Mapa(int tamanioMapa, Map<Posicion,Posicionable> posicionablesIniciales) {
    	this.orientaciones = new HashMap<Orientable, Orientacion>();
		this.grilla = new GrillaCuadrada(tamanioMapa, posicionablesIniciales);
		posicionablesIniciales.forEach((posicion, posicionable) -> {
			if(posicionable instanceof Orientable)
				orientaciones.put((Orientable) posicionable, new OrientacionAbajo());
		});
	}
	
	
    public Mapa(int tamanioMapa) {
    	this.orientaciones = new HashMap<Orientable, Orientacion>();
		this.grilla = new GrillaCuadrada(tamanioMapa);
	}

	public int getTamanio(){
    	return grilla.getTamanio();
    }
    
    public void posicionar(Posicionable posicionable, int x, int y) {
//    	if(grilla.estaOcupada(x, y))
//    		throw new CeldaOcupadaException();
    	grilla.posicionar(posicionable, x, y);
    	
    }
    
    public void posicionar(Orientable orientable, Orientacion orientacion, int x, int y) {
    	this.posicionar(orientable, x, y);
    	orientaciones.put(orientable, orientacion);
    }
    
    public Posicionable obtener(int x, int y) {
    	return grilla.obtener(x, y);
    }
    
    public void remover(Posicionable posicionable) {
    	grilla.remover(posicionable);
    }
    
	public void moverYOrientarHaciaArriba(Orientable orientable) {
    	orientaciones.put(orientable, new OrientacionArriba());
    	Posicion desde = grilla.obtenerPosicion(orientable);
    	Posicion hacia = new Posicion(desde.getX(), desde.getY()-1);
    	grilla.mover(desde, hacia);
    }
    
    public void moverYOrientarHaciaAbajo(Orientable orientable) {
    	orientaciones.put(orientable, new OrientacionAbajo());
    	Posicion desde = grilla.obtenerPosicion(orientable);
    	Posicion hacia = new Posicion(desde.getX(), desde.getY()+1);
    	grilla.mover(desde, hacia);
    }
    
    public void moverYOrientarHaciaLaDerecha(Orientable orientable) {
    	orientaciones.put(orientable, new OrientacionDerecha());
    	Posicion desde = grilla.obtenerPosicion(orientable);
    	Posicion hacia = new Posicion(desde.getX()+1, desde.getY());
    	grilla.mover(desde, hacia);
    }
    
    public void moverYOrientarHaciaLaIzquierda(Orientable orientable) {
    	orientaciones.put(orientable, new OrientacionIzquierda());
    	Posicion desde = grilla.obtenerPosicion(orientable);
    	Posicion hacia = new Posicion(desde.getX()-1, desde.getY());
    	grilla.mover(desde, hacia);
    }
    
    public Orientacion obtenerOrientacionDe(Orientable orientable) {
    	return orientaciones.get(orientable);
    }
    
	public boolean estaOcupada(int x, int y) {
		return grilla.estaOcupada(x, y);
	}
	
	public Posicion obtenerPosicion(Posicionable posicionable) {
		return grilla.obtenerPosicion(posicionable);
	}

	public Posicionable obtenerPosicionableAlFrenteDe(Orientable orientable) {
		Orientacion orientacion = obtenerOrientacionDe(orientable);
		Posicion posicion = orientacion.calcularPosicionAlFrenteDe(orientable, this);
		return grilla.obtener(posicion.getX(), posicion.getY());
	}

	public void paraCadaPosicionable(BiConsumer<Posicionable, Posicion> consumer) {
		grilla.paraCadaPosicionable(consumer);
	}
    
}
