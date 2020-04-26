package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDeMaderaTest {
	
	private static int DURABILIDAD_PICO_DE_MADERA=100;
	private static int FUERZA_PICO_DE_MADERA=2;
	
	@Test 
	public void test01SeCreaPicoDeMaderaConDurabilidad100() {
		Herramienta picoDeMadera = new PicoDeMadera();		
		int durabilidad = picoDeMadera.getDurabilidad();
		assertEquals(durabilidad, DURABILIDAD_PICO_DE_MADERA);
	};
	
	
	@Test
	public void test02SeCreaPicoDeMaderaConFuerza2() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int fuerza = picoDeMadera.getFuerza();		
		assertEquals (fuerza, FUERZA_PICO_DE_MADERA);
	}
	
	
	@Test
	public void test03UsarPicoDeMaderaUnaVezReduceDurabilidadEn2Unidades() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		picoDeMadera.desgastar();
		assertEquals (durabilidadInicial-FUERZA_PICO_DE_MADERA, picoDeMadera.getDurabilidad());
	}
	
	
	@Test
	public void test04UsarPicoDeMadera5VecesReduceDurabilidadEn10Unidades() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		
		for (int i=0; i<5; i++) {
			picoDeMadera.desgastar();
		}
		
		assertEquals (durabilidadInicial-(FUERZA_PICO_DE_MADERA*5), picoDeMadera.getDurabilidad());
	}
	
	
	@Test
	public void test05UsarPicoDeMaderaContraPiedraReduceSuDurabilidad() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		Material piedra = new Piedra();
		picoDeMadera.golpear(piedra);
		assertEquals (picoDeMadera.getDurabilidad(), durabilidadInicial-FUERZA_PICO_DE_MADERA);
	}

	
	@Test
	public void test06UsarPicoDeMaderaContraMaderaNoReduceSuDurabilidad() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		Material madera = new Madera();
		picoDeMadera.golpear(madera);
		assertEquals (picoDeMadera.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test 
	public void test07UsarPicoDeMaderaContraMetalNoReduceSuDurabilidad() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		Material metal = new Metal();
		picoDeMadera.golpear(metal);
		assertEquals (picoDeMadera.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test08UsarPicoDeMaderaContraDiamanteNoReduceSuDurabilidad() {
		Herramienta picoDeMadera = new PicoDeMadera();
		int durabilidadInicial = picoDeMadera.getDurabilidad();
		Material diamante = new Diamante();
		picoDeMadera.golpear(diamante);
		assertEquals (picoDeMadera.getDurabilidad(), durabilidadInicial);
	}

}