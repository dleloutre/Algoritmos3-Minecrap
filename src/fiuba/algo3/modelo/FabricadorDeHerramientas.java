package fiuba.algo3.modelo;

import java.util.ArrayList;

import fiuba.algo3.modelo.herramienta.Herramienta;
import fiuba.algo3.modelo.herramienta.plano.BosquejoDeHerramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoDeHerramienta;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistente;
import fiuba.algo3.modelo.herramienta.plano.PlanoInexistenteException;

public class FabricadorDeHerramientas {
	
	private ArrayList<PlanoDeHerramienta> planos;
	
	public FabricadorDeHerramientas(ArrayList<PlanoDeHerramienta> planos) {
		this.planos = planos;
		this.planos.add(new PlanoInexistente());
	}
	
	public boolean esFabricable(PlanoDeHerramienta plano) {
		return planos.contains(plano);
	}
	
	
	public PlanoDeHerramienta obtenerPlanoValidoEnBaseA(BosquejoDeHerramienta bosquejo) {
		PlanoDeHerramienta planoValido = null;
		for(PlanoDeHerramienta plano : planos) {
			if(plano.equals(bosquejo)) {
				planoValido = plano;
				break;
			}
		}
		return planoValido;
	}
	
	public Herramienta fabricarHerramientaEnBaseA(BosquejoDeHerramienta bosquejo) throws PlanoInexistenteException {
		return obtenerPlanoValidoEnBaseA(bosquejo).fabricarHerramienta();
	}
}