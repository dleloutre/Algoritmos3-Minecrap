package fiuba.algo3.vista;

import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.PicoDeMadera;
import fiuba.algo3.modelo.herramienta.PicoDeMetal;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;
import fiuba.algo3.modelo.mapa.orientacion.Orientacion;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionAbajo;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionArriba;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionDerecha;
import fiuba.algo3.modelo.mapa.orientacion.OrientacionIzquierda;
import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;
import fiuba.algo3.vista.posicionable.VistaPosicionable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProveedorDeImagenes {
	
	private Image madera;
	private Image piedra;
	private Image diamante;
	private Image metal;
	private Image jugadorFrente;
	private Image jugadorBack;
	private Image jugadorIzquierda;
	private Image jugadorDerecha;
	private Image tablero;
	private Image pasto;
	private Image hachaDeMadera;
	private Image hachaDePiedra;
	private Image hachaDeMetal;
	private Image picoDePiedra;
	private Image picoDeMetal;
	private Image picoDeMadera;
	private Image picoFino;
	private Image inventario;
	private Image flecha;
	private static ProveedorDeImagenes instance;
	private static int DIMENSION = 50;
	
	private ProveedorDeImagenes() {
		madera = new Image("madera.png", DIMENSION, DIMENSION, false, false);
		piedra = new Image("piedra3.png", DIMENSION, DIMENSION, false, false);
		diamante = new Image("diamante3.png", DIMENSION, DIMENSION, false, false);
		metal = new Image("metal2.png",DIMENSION,DIMENSION,false, false);
		jugadorFrente = new Image("player3.png",DIMENSION,DIMENSION,false,false);
		tablero = new Image("tablero.jpg",DIMENSION,DIMENSION,false,false);
		pasto = new Image("grass4.png",DIMENSION,DIMENSION,false,false);
		jugadorBack = new Image ("playerBack2.png",DIMENSION,DIMENSION,false,false);
		jugadorIzquierda = new Image ("playerLeftSide.png",DIMENSION,DIMENSION,false,false);
		jugadorDerecha = new Image ("playerRightSide.png",DIMENSION,DIMENSION,false,false);
		hachaDeMadera = new Image("hachaDeMadera.jpg", DIMENSION, DIMENSION, false, false);
		hachaDePiedra = new Image("hachaDePiedra2.png", DIMENSION, DIMENSION, false, false);
		hachaDeMetal = new Image("hachaDeMetal2.jpg", DIMENSION, DIMENSION, false, false);
		picoDeMadera = new Image("picoDeMadera.png", DIMENSION, DIMENSION, false, false);
		picoDePiedra = new Image("picoDePiedra.png", DIMENSION, DIMENSION, false, false);
		picoDeMetal = new Image("picoDeMetal.png", DIMENSION, DIMENSION, false, false);
		picoFino = new Image("picoMetalYPiedra.png", DIMENSION, DIMENSION, false, false);
		inventario = new Image ("mesa.jpg", DIMENSION, DIMENSION, false, false);
		flecha = new Image ("arrow.png", 80, 80, false, false);
		
	}
	
	public static ProveedorDeImagenes getInstance() {
		if( instance == null ) {
			instance = new ProveedorDeImagenes();
		}
		return instance;
	}

	public void proveerImagen(VistaPosicionable vistaPosicionable){
		if(vistaPosicionable.getPosicionable() instanceof Madera) {
			vistaPosicionable.setImage(madera);
			vistaPosicionable.setId("material");
		} else if (vistaPosicionable.getPosicionable() instanceof Piedra) {
			vistaPosicionable.setImage(piedra);
			vistaPosicionable.setId("material");
		} else if (vistaPosicionable.getPosicionable() instanceof Metal) {
			vistaPosicionable.setImage(metal);
			vistaPosicionable.setId("material");
		} else if (vistaPosicionable.getPosicionable() instanceof Diamante) {
			vistaPosicionable.setImage(diamante);
			vistaPosicionable.setId("material");
		}else if (vistaPosicionable.getPosicionable() instanceof HachaDeMadera) {
			vistaPosicionable.setImage(hachaDeMadera);
			vistaPosicionable.setId("herramienta");
		}else if (vistaPosicionable.getPosicionable() instanceof HachaDePiedra) {
			vistaPosicionable.setImage(hachaDePiedra);
			vistaPosicionable.setId("herramienta");
		}else if(vistaPosicionable.getPosicionable() instanceof HachaDeMetal) {
			vistaPosicionable.setImage(hachaDeMetal);
			vistaPosicionable.setId("herramienta");
		}else if (vistaPosicionable.getPosicionable() instanceof PicoDeMadera) {
			vistaPosicionable.setImage(picoDeMadera);
			vistaPosicionable.setId("herramienta");
		}else if (vistaPosicionable.getPosicionable() instanceof PicoDePiedra) {
			vistaPosicionable.setImage(picoDePiedra);
			vistaPosicionable.setId("herramienta");
		}else if (vistaPosicionable.getPosicionable() instanceof PicoDeMetal) {
			vistaPosicionable.setImage(picoDeMetal);
			vistaPosicionable.setId("herramienta");
		}else if (vistaPosicionable.getPosicionable() instanceof PicoFinoDeMetalYPiedra) {
			vistaPosicionable.setImage(picoFino);
			vistaPosicionable.setId("herramienta");
		} else {
			vistaPosicionable.setImage(pasto);
			vistaPosicionable.setId("vacio");				
		}
	}

	public VistaPosicionable getImagenJugador(VistaPosicionable vistaPosicionable, Orientacion orientacion) {
		if (orientacion instanceof OrientacionArriba) {
			vistaPosicionable.setImage(jugadorBack);
		} else if (orientacion instanceof OrientacionAbajo) {
			vistaPosicionable.setImage(jugadorFrente);
		} else if (orientacion instanceof OrientacionDerecha) {
			vistaPosicionable.setImage(jugadorDerecha);
		} else if (orientacion instanceof OrientacionIzquierda) {
			vistaPosicionable.setImage(jugadorIzquierda);
		} 
		return vistaPosicionable;
	}
	
	public ImageView getImagen(String nombre, int dimension) {
		ImageView image = new ImageView();
		if(nombre == "madera") {
			image.setImage(madera);
			image.setId("material");
		} else if (nombre == "piedra") {
			image.setImage(piedra);
			image.setId("material");
		} else if (nombre == "metal") {
			image.setImage(metal);
			image.setId("material");
		} else if (nombre == "diamante") {
			image.setImage(diamante);
			image.setId("material");
		} else if (nombre == "tablero") {
			image.setImage(tablero);
			image.setId("tablero");
		} else if (nombre == "pasto") {
			image.setImage(pasto);
			image.setId("vacio");		
		} else if (nombre == "inventario") {
			image.setImage(inventario);
			image.setId("inventario");
		}else if( nombre == "flecha") {
			image.setImage(flecha);
		}
		image.setFitHeight(dimension);
		image.setFitWidth(dimension);
		return image;
	}
	
}
