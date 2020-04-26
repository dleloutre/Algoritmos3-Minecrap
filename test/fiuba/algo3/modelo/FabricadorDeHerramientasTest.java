package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.modelo.herramienta.HachaDeMadera;
import fiuba.algo3.modelo.herramienta.HachaDeMetal;
import fiuba.algo3.modelo.herramienta.HachaDePiedra;
import fiuba.algo3.modelo.herramienta.PicoDeMadera;
import fiuba.algo3.modelo.herramienta.PicoDeMetal;
import fiuba.algo3.modelo.herramienta.PicoDePiedra;
import fiuba.algo3.modelo.herramienta.PicoFinoDeMetalYPiedra;
import fiuba.algo3.modelo.herramienta.plano.BosquejoDeHerramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistenteException;
import fiuba.algo3.modelo.material.Madera;
import fiuba.algo3.modelo.material.Metal;
import fiuba.algo3.modelo.material.Piedra;

public class FabricadorDeHerramientasTest {

	@Test(expected = PlanoInexistenteException.class )
	public void test01fabricarHerramientaConUnBocetoInvalidoDevuelveNull() throws Exception {
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(new ArrayList<PlanoDeHerramienta>());
		
		fabricador.fabricarHerramientaEnBaseA(new BosquejoDeHerramienta());
	}
	
	@Test
	public void test02fabricarHerramientaConUnBocetoDeHachaDeMaderaDevuelveHachaDeMadera() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(HachaDeMadera.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Madera(), 0, 0);
		bosquejo.posicionar(new Madera(), 0, 1);
		bosquejo.posicionar(new Madera(), 1, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof HachaDeMadera);
		
	}
	
	@Test
	public void test03fabricarHerramientaConUnBocetoDeHachaDeMetalDevuelveHachaDeMetal() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(HachaDeMetal.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Metal(), 0, 0);
		bosquejo.posicionar(new Metal(), 0, 1);
		bosquejo.posicionar(new Metal(), 1, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof HachaDeMetal);
		
	}
	
	@Test
	public void test04fabricarHerramientaConUnBocetoDeHachaDePiedraDevuelveHachaDePiedra() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(HachaDePiedra.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Piedra(), 0, 0);
		bosquejo.posicionar(new Piedra(), 0, 1);
		bosquejo.posicionar(new Piedra(), 1, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof HachaDePiedra);
		
	}
	
	
	@Test
	public void test05fabricarHerramientaConUnBocetoDePicoDeMaderaDevuelvePicoDeMadera() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(PicoDeMadera.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Madera(), 0, 0);
		bosquejo.posicionar(new Madera(), 1, 0);
		bosquejo.posicionar(new Madera(), 2, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof PicoDeMadera);
		
	}
	
	@Test
	public void test06fabricarHerramientaConUnBocetoDePicoDeMetalDevuelvePicoDeMetal() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(PicoDeMetal.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Metal(), 0, 0);
		bosquejo.posicionar(new Metal(), 1, 0);
		bosquejo.posicionar(new Metal(), 2, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof PicoDeMetal);
		
	}
	
	@Test
	public void test07fabricarHerramientaConUnBocetoDePicoDePiedraDevuelvePicoDePiedra() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(PicoDePiedra.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Piedra(), 0, 0);
		bosquejo.posicionar(new Piedra(), 1, 0);
		bosquejo.posicionar(new Piedra(), 2, 0);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof PicoDePiedra);
		
	}
	
	@Test
	public void test08fabricarHerramientaConUnBocetoDePicoFinoDevuelvePicoFino() throws Exception {
		ArrayList<PlanoDeHerramienta> planos = new ArrayList<PlanoDeHerramienta>();
		planos.add(PicoFinoDeMetalYPiedra.plano());
		
		FabricadorDeHerramientas fabricador = new FabricadorDeHerramientas(planos);
		
		BosquejoDeHerramienta bosquejo = new BosquejoDeHerramienta();
		
		bosquejo.posicionar(new Metal(), 0, 0);
		bosquejo.posicionar(new Metal(), 1, 0);
		bosquejo.posicionar(new Metal(), 2, 0);
		bosquejo.posicionar(new Piedra(), 0, 1);
		bosquejo.posicionar(new Madera(), 1, 1);
		bosquejo.posicionar(new Madera(), 1, 2);
		
		assertTrue(fabricador.fabricarHerramientaEnBaseA(bosquejo) instanceof PicoFinoDeMetalYPiedra);
		
	}
}
