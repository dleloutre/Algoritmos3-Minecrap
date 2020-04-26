package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDeMetalTest {
	
	private static int DURABILIDAD_PICO_DE_METAL=400;
	private static int FUERZA_PICO_DE_METAL=12;
	
	@Test 
	public void test01SeCreaPicoDeMetalConDurabilidad1400() {
		Herramienta picoDeMetal = new PicoDeMetal();		
		int durabilidad = picoDeMetal.getDurabilidad();
		assertEquals(durabilidad, DURABILIDAD_PICO_DE_METAL);
	};
	

	@Test
	public void test02SeCreaPicoDeMetalConFuerza12() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int fuerza = picoDeMetal.getFuerza();		
		assertEquals (fuerza, FUERZA_PICO_DE_METAL);
	}
	

	@Test
	public void test03UsarPicoDeMetalUnaVezNoReduceDurabilidad() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		picoDeMetal.desgastar();
		assertEquals (durabilidadInicial, picoDeMetal.getDurabilidad());
	}
	
	
	@Test
	public void test04UsarPicoDeMetal9VecesNoReduceDurabilidad() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		
		for (int i = 0; i < 9; i++) {
			picoDeMetal.desgastar();
		}
		assertEquals (durabilidadInicial, picoDeMetal.getDurabilidad());
	}

	
	@Test
	public void test05UsarPicoDeMetal10VecesReduceDurabilidadA0() {
		Herramienta picoDeMetal = new PicoDeMetal();
		
		for (int i = 0; i < 10; i++) {
			picoDeMetal.desgastar();
		}
		assertEquals (0, picoDeMetal.getDurabilidad());
	}
	
	
	@Test
	public void test06UsarPicoDeMetalContraPiedraUnaVezNoReduceSuDurabilidad(){
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		Material piedra = new Piedra();
		picoDeMetal.golpear(piedra);
		assertEquals (picoDeMetal.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test07UsarPicoDeMetalContraMaderaNoReduceSuDurabilidad() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		Material madera = new Madera();
		picoDeMetal.golpear(madera);
		assertEquals (picoDeMetal.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test 
	public void test08UsarPicoDeMetalContraMetalNoReduceSuDurabilidad() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		Material metal = new Metal();
		picoDeMetal.golpear(metal);
		assertEquals (picoDeMetal.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test09UsarPicoDeMetalContraDiamanteNoReduceSuDurabilidad() {
		Herramienta picoDeMetal = new PicoDeMetal();
		int durabilidadInicial = picoDeMetal.getDurabilidad();
		Material diamante = new Diamante();
		picoDeMetal.golpear(diamante);
		assertEquals (picoDeMetal.getDurabilidad(), durabilidadInicial);
	}

}