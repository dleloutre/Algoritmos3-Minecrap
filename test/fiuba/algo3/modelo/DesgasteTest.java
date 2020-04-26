package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.desgaste.Desgaste;
import fiuba.algo3.modelo.desgaste.DesgasteAbrupto;
import fiuba.algo3.modelo.desgaste.DesgasteLineal;
import fiuba.algo3.modelo.desgaste.DesgasteVariable;

public class DesgasteTest {
	
	@Test
	public void test01DesgasteLinealSeInstanciaConDurabilidad100() {
		Desgaste desgaste = new DesgasteLineal(100,2);
		
		assertEquals (100, desgaste.getDurabilidad());
	}
	
	@Test
	public void test02DesgasteLinealDeDurabilidad100SeUsaYReduceDurabilidadConReduccion2() {
		Desgaste desgaste = new DesgasteLineal(100,2);
		int durabilidadInicial = desgaste.getDurabilidad(); 
		
		desgaste.usar();
		
		assertEquals (durabilidadInicial-2, desgaste.getDurabilidad());
	}
	
	@Test
	public void test03DesgasteLinealDeDurabilidad100SeUsaTresVecesYReduceDurabilidadConReduccion2() {
		Desgaste desgaste = new DesgasteLineal(100,2);
		int durabilidadInicial = desgaste.getDurabilidad(); 
		
		for(int i=0; i < 3; i++)
			desgaste.usar();

		assertEquals (durabilidadInicial-6, desgaste.getDurabilidad());
	}
	
	@Test
	public void test04DesgasteLinealDeDurabilidad10SeUsaCincoVecesYSeRompe() {
		Desgaste desgaste = new DesgasteLineal(10,2);
		
		for(int i=0; i < 5; i++)
			desgaste.usar();

		assertTrue(desgaste.estaRoto());
	}
	
	@Test
	public void test05DesgasteLinealNoSeReduceAlUsarConParametros() {
		Desgaste desgaste = new DesgasteLineal(10,3);
		int durabilidadInicial = desgaste.getDurabilidad();

		for(int i=0; i < 6; i++)
			desgaste.usar(3);

		assertEquals (desgaste.getDurabilidad(), durabilidadInicial);
	}
	
	@Test
	public void test06DesgasteAbruptoSeInstanciaConDurabilidad100() {
		Desgaste desgaste = new DesgasteAbrupto(100,10);
		
		assertEquals (100, desgaste.getDurabilidad());
	}
	
	@Test
	public void test07DesgasteAbruptoAnulaLaHerramientaLuegoDe10Usos() {
		Desgaste desgaste = new DesgasteAbrupto(400,10);
		
		for(int i=0; i < 10; i++)
			desgaste.usar();
		
		int durabilidadActual = desgaste.getDurabilidad();
		assertEquals (durabilidadActual,0);	
	}
	
	@Test
	public void test08DesgasteAbruptoNoAnulaLaHerramientaLuegoDe9Usos() {
		Desgaste desgaste = new DesgasteAbrupto(400,10);
		int durabilidadInicial = desgaste.getDurabilidad();

		for(int i=0; i < 9; i++)
			desgaste.usar();
		
		int durabilidadActual = desgaste.getDurabilidad();
		assertEquals (durabilidadActual, durabilidadInicial);	
	}
	
	@Test
	public void test09DesgasteAbruptoDe3UsosSeUsaTresVecesYSeRompe() {
		Desgaste desgaste = new DesgasteAbrupto(100,3);

		for(int i=0; i < 3; i++)
			desgaste.usar();

		assertTrue(desgaste.estaRoto());
	}
	
	@Test
	public void test10DesgasteAbruptoNoSeReduceAlUsarConParametros() {
		Desgaste desgaste = new DesgasteAbrupto(100,3);
		int durabilidadInicial = desgaste.getDurabilidad();

		for(int i=0; i < 6; i++)
			desgaste.usar(3);

		assertEquals (desgaste.getDurabilidad(), durabilidadInicial);
	}
	
	@Test
	public void test11DesgasteVariableSeInstanciaConDurabilidad100() {
		Desgaste desgaste = new DesgasteVariable(100);
		
		assertEquals (100, desgaste.getDurabilidad());
	}
	
	@Test
	public void test12DesgasteVariableDeDurabilidad100SeUsaYReduceDurabilidadConReduccion2() {
		Desgaste desgaste = new DesgasteVariable(100);
		int durabilidadInicial = desgaste.getDurabilidad(); 
		
		desgaste.usar(2);
		
		assertEquals (durabilidadInicial-2, desgaste.getDurabilidad());
	}
	
	@Test
	public void test13DesgasteVariableDeDurabilidad100SeUsaYReduceDurabilidadConReduccion2YLuego3() {
		Desgaste desgaste = new DesgasteVariable(100);
		int durabilidadInicial = desgaste.getDurabilidad(); 
		
		desgaste.usar(2);
		desgaste.usar(3);
		
		assertEquals (durabilidadInicial-5, desgaste.getDurabilidad());
	}
	
	@Test
	public void test14DesgasteVariableDeSeUsaUnaVezConValorMaximoYSeRompe() {
		Desgaste desgaste = new DesgasteVariable(100);		

		desgaste.usar(100);

		assertTrue(desgaste.estaRoto());
	}
	
	@Test
	public void test15DesgasteVariableNoSeReduceAlUsarSinParametros() {
		Desgaste desgaste = new DesgasteVariable(100);
		int durabilidadInicial = desgaste.getDurabilidad(); 
		
		desgaste.usar();

		assertEquals (durabilidadInicial, desgaste.getDurabilidad());
	}
	
}