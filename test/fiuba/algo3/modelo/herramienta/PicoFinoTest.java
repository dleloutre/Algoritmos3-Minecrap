package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoFinoTest {
	
	private static int DURABILIDAD_PICO_FINO=1000;
	private static int FUERZA_PICO_FINO=20;
	private static int DESGASTE_PICO_FINO=(DURABILIDAD_PICO_FINO/10);
	
	@Test
	public void test01SeCreaUnPicoFinoDeMetalYPiedraConDurabilidad1000() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidad = picoFino.getDurabilidad();
		assertEquals(durabilidad,DURABILIDAD_PICO_FINO);
	}
	
	
	@Test
	public void test02SeCreaUnPicoFinoConFuerza20() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int fuerza = picoFino.getFuerza();
		assertEquals(fuerza,FUERZA_PICO_FINO);
	}

	
	@Test
	public void test03UsarPicoFinoUnaVezReduceDurabilidadEn100Unidades() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		picoFino.desgastar();
		assertEquals (durabilidadInicial-DESGASTE_PICO_FINO, picoFino.getDurabilidad());
	}

	
	@Test
	public void test04UsarPicoFino5VecesReduceDurabilidadEn10Unidades() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		
		for (int i=0; i<5; i++) {
			picoFino.desgastar();
		}
		
		assertEquals (durabilidadInicial-(DESGASTE_PICO_FINO*5), picoFino.getDurabilidad());
	}
	
	
	@Test
	public void test05UsarPicoFinoContraMaderaNoReduceSuDurabilidad() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		Material madera = new Madera();
		picoFino.golpear(madera);
		assertEquals (picoFino.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test06UsarPicoFinoContraPiedraNoReduceSuDurabilidad() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		Material piedra = new Piedra();
		picoFino.golpear(piedra);
		assertEquals (picoFino.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test07UsarPicoFinoContraMetalNoReduceSuDurabilidad() {
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		Material metal = new Metal();
		picoFino.golpear(metal);
		assertEquals (picoFino.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test08UsarPicoFinoContraDiamanteReduceSuDurabilidad(){
		Herramienta picoFino = new PicoFinoDeMetalYPiedra();
		int durabilidadInicial = picoFino.getDurabilidad();
		Material diamante = new Diamante();
		picoFino.golpear(diamante);
		assertEquals (picoFino.getDurabilidad(), durabilidadInicial-DESGASTE_PICO_FINO);
	}

}
