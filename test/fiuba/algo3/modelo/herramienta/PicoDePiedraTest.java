package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class PicoDePiedraTest {
	
	private static int DURABILIDAD_PICO_DE_PIEDRA=200;
	private static int FUERZA_PICO_DE_PIEDRA=4;

	@Test
	public void test01SeCreaUnPicoDePiedraConDurabilidad200() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidad = picoDePiedra.getDurabilidad();
		assertEquals (durabilidad,DURABILIDAD_PICO_DE_PIEDRA);
	}

	
	@Test
	public void test02SeCreaUnPicoDePiedraConFuerza4() {
		Herramienta picoDePiedra = new PicoDePiedra();
		
		int fuerza = picoDePiedra.getFuerza();
		assertEquals (fuerza,FUERZA_PICO_DE_PIEDRA); 
	}
	

	@Test
	public void test03UsarPicoDePiedra5VecesReduceDurabilidadEn10Unidades() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidadInicial = picoDePiedra.getDurabilidad();
		
		for (int i=0; i<5; i++) {
			picoDePiedra.desgastar();
		}
		
		assertEquals (durabilidadInicial-15, picoDePiedra.getDurabilidad());
	}
	
	
	@Test 
	public void test04UsarPicoDePiedraContraMetalReduceSuDurabilidad() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidadInicial = picoDePiedra.getDurabilidad();
		Material metal = new Metal();
		picoDePiedra.golpear(metal);
		assertEquals (picoDePiedra.getDurabilidad(), durabilidadInicial-3);
	}
	
	
	@Test 
	public void test05UsarPicoDePiedraContraPiedraReduceSuDurabilidad() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidadInicial = picoDePiedra.getDurabilidad();
		Material piedra = new Piedra();
		picoDePiedra.golpear(piedra);
		assertEquals (durabilidadInicial-3, picoDePiedra.getDurabilidad());
	}
	
	
	@Test
	public void test06UsarPicoDePiedraContraMaderaNoReduceSuDurabilidad() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidadInicial = picoDePiedra.getDurabilidad();
		Material madera = new Madera();
		picoDePiedra.golpear(madera);
		assertEquals (picoDePiedra.getDurabilidad(), durabilidadInicial);
	}
	
	
	@Test
	public void test07UsarPicoDePiedraContraDiamanteNoReduceSuDurabilidad() {
		Herramienta picoDePiedra = new PicoDePiedra();
		int durabilidadInicial = picoDePiedra.getDurabilidad();
		Material diamante = new Diamante();
		picoDePiedra.golpear(diamante);
		assertEquals (picoDePiedra.getDurabilidad(), durabilidadInicial);
	}
	
}