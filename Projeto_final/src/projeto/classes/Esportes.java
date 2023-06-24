package projeto.classes;

import java.util.ArrayList;

public class Esportes extends Area {
    private static ArrayList<Evento> listaCopas;
	
	public Esportes(){
		super("Esportes");
		new ArrayList<>();
	}
	
	public boolean registrarEvento(String nome, String data, Pessoa responsavel) {
		for(Evento e: listaCopas) {
			if(e.getNome().equals(nome)) {
				return false;
			}
		}
		listaCopas.add(new Evento(nome, data, responsavel));
		return true;
	}
	public boolean resultadoEvento(String nome, Double saldo, Pessoa responsavel){
		for(Evento copa: listaCopas) {
			if(copa.getNome().equals(nome)) {
				copa.setSaldo(saldo);
				Caixa.gerarMovimentacao(saldo, "Lucro da festa: "+e.getNome(), Atletica.areaByName("Eventos") , responsavel); //ALTERAR!!!
				//depois da implementação de Produtos, colocar Produtos no primeiro null e a Pessoa buscada pelo RA na lista de Pessoas no segundo null
				//Fiz um getRA no Menu pra pegar o RA do usuario e buscar na lista de Pessoas
				
				return true;
				}
			}
		return false;
	}



    
}
