package fiuba.algo3.modelo.herramienta;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fiuba.algo3.modelo.material.Diamante;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Material;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class HachaDeMaderaTest {
	
	private static int DURABILIDAD_HACHA_DE_MADERA=100;
	private static int FUERZA_HACHA_DE_MADERA=2;
	
	@Test 
	public void test01SeCreaHachaDeMaderaConDurabilidad100() {
		Herramienta hachaDeMadera = new HachaDeMadera();		
		int durabilidad = hachaDeMadera.getDurabilidad();
		assertEquals(durabilidad, DURABILIDAD_HACHA_DE_MADERA);
	}
	
	@Test
	public void test02SeCreaHachaDeMaderaConFuerza2() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int fuerza = hachaDeMadera.getFuerza();		
		assertEquals (fuerza, FUERZA_HACHA_DE_MADERA);
	}
	
	@Test
	public void test03UsarHachaDeMaderaUnaVezReduceDurabilidadEn2Unidades() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		hachaDeMadera.desgastar();
		assertEquals (durabilidadInicial-FUERZA_HACHA_DE_MADERA, hachaDeMadera.getDurabilidad());
	}

	@Test
	public void test04UsarHachaDeMadera5VecesReduceDurabilidadEn10Unidades() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		
		for (int i=0; i<5; i++) {
			hachaDeMadera.desgastar();
		}
		
		assertEquals (durabilidadInicial-(FUERZA_HACHA_DE_MADERA*5), hachaDeMadera.getDurabilidad());
	}
	
	@Test
	public void test05UsarHachaDeMadera10VecesReduceDurabilidadEn20Unidades() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		
		for (int i=0; i<10; i++) {
			hachaDeMadera.desgastar();
		}
		
		assertEquals (durabilidadInicial-(FUERZA_HACHA_DE_MADERA*10), hachaDeMadera.getDurabilidad());
	}
	
	@Test
	public void test06UsarHachaDeMaderaContraMaderaReduceSuDurabilidad(){
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		Material madera = new Madera();
		hachaDeMadera.golpear(madera);
		assertEquals (hachaDeMadera.getDurabilidad(), durabilidadInicial-FUERZA_HACHA_DE_MADERA);
	}
	
	@Test
	public void test07UsarHachaDeMaderaContraPiedraNoReduceSuDurabilidad() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		Material piedra = new Piedra();
		hachaDeMadera.golpear(piedra);
		assertEquals (hachaDeMadera.getDurabilidad(), durabilidadInicial);
	}
	
	@Test 
	public void test08UsarHachaDeMaderaContraMetalNoReduceSuDurabilidad() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		Material metal = new Metal();
		hachaDeMadera.golpear(metal);
		assertEquals (hachaDeMadera.getDurabilidad(), durabilidadInicial);
	}
	
	@Test
	public void test09UsarHachaDeMaderaContraDiamanteNoReduceSuDurabilidad() {
		Herramienta hachaDeMadera = new HachaDeMadera();
		int durabilidadInicial = hachaDeMadera.getDurabilidad();
		Material diamante = new Diamante();
		hachaDeMadera.golpear(diamante);
		assertEquals (hachaDeMadera.getDurabilidad(), durabilidadInicial);
	}


}
