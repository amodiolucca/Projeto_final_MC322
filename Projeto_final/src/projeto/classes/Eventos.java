package projeto.classes;

import java.util.ArrayList;

public class Eventos extends Area {
	private static ArrayList<Evento> listaEventos;
	
	public Eventos(){
		super("Eventos");
		new ArrayList<Eventos>();
	}
	
	public boolean registrarEvento(String nome, String data, Pessoa responsavel) {
		for(Evento e: listaEventos) {
			if(e.getNome().equals(nome)) {
				return false;
			}
		}
		listaEventos.add(new Evento(nome, data, responsavel));
		return true;
	}
	public boolean resultadoEvento(String nome, double lucro, Pessoa responsavel){
		for(Evento e: listaEventos) {
			if(e.getNome().equals(nome)) {
				e.setLucro(lucro);
				Caixa.gerarMovimentacao(lucro, "Lucro da festa: "+e.getNome(),  , responsavel.getNome()); //ALTERAR!!!
				//depois da implementação de Produtos, colocar Produtos no primeiro null e a Pessoa buscada pelo RA na lista de Pessoas no segundo null
				//Fiz um getRA no Menu pra pegar o RA do usuario e buscar na lista de Pessoas
				
				return true;
		}
				return true;
			}
		}
		return false;
	}
}
