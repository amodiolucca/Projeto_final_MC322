package projeto.classes;

import java.util.ArrayList;

public class Esportes extends Area {
    private ArrayList<Evento> listaCopas;
	
    public Esportes(Atletica atletica) {
    	super(atletica, "Esportes");
    	listaCopas = new ArrayList<>();
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
                copa.setLucro(saldo);
                super.getAtletica().getCaixa().gerarMovimentacao(saldo, "Lucro da copa: "+copa.getNome(), this , responsavel);
                //depois da implementação de Produtos, colocar Produtos no primeiro null e a Pessoa buscada pelo RA na lista de Pessoas no segundo null
                //Fiz um getRA no Menu pra pegar o RA do usuario e buscar na lista de Pessoas

                return true;
            }
        }
        return false;
    }
}
