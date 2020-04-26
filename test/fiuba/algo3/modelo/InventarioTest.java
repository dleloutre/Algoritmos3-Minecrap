package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.grilla.Posicionable;
import fiuba.algo3.modelo.grilla.celda.EspacioVacio;
import fiuba.algo3.modelo.herramienta.plano.BosquejoDeHerramienta;
import fiuba.algo3.modelo.material.Madera;

public class InventarioTest {
	
	@Test
	public void test01InventarioSeInstanciaConAlmacenamientoVacio() {
		Inventario inventario = new Inventario();
		
		inventario.paraCadaPosicionableDelAlmacenamiento((posicionable, posicion)-> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
	}
	
	@Test
	public void test01InventarioSeInstanciaConBosquejoVacio() {
		Inventario inventario = new Inventario();
		
		inventario.paraCadaPosicionableDelBosquejo((posicionable, posicion)-> {
			assertTrue(posicionable instanceof EspacioVacio);
		});
	}
	
	@Test
	public void test02AlmacenarSinEspecificarPosicionSeAlmacenaEnLaPrimerPosicion() throws Exception {
		Inventario inventario = new Inventario();
		
		inventario.almacenar(new Madera());
		Posicionable posicionable = inventario.obtener(0,0);
		
		assertTrue(posicionable instanceof Madera);
	}
	
	@Test
	public void test03AlmacenarEnPosicionEspecificaSeAlmacenaCorrectamente() throws Exception {
		Inventario inventario = new Inventario();
		
		inventario.almacenarEn(new Madera(), 1, 1);
		
		Posicionable posicionable = inventario.obtener(1,1);
		
		assertTrue(posicionable instanceof Madera);
	}
	
	@Test(expected = AlmacenamientoLlenoException.class)
	public void test04InsertarCuandoEstaLlenaArrojaExcepcion() throws Exception {
		Inventario inventario = new Inventario();
		
		for(int i = 0; i < 75 ; i++ )
			inventario.almacenar(new Madera());
		
		inventario.almacenar(new Madera());
	}
	
	@Test
	public void test01InventarioSeInstanciaConUnBosquejoInicializado() {
		Inventario inventario = new Inventario();
		
		assertTrue(inventario.getBosquejo() instanceof BosquejoDeHerramienta);
	}
}