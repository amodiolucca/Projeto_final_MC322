package projeto.classes;

import java.util.ArrayList;

public class Eventos extends Area {
    private ArrayList<Evento> listaEventos;

    public Eventos(Atletica atletica){
        super(atletica, "Eventos");
        listaEventos = new ArrayList<>();
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
    
    public boolean resultadoEvento(String nome, double lucro, Evento e) {
        e.setLucro(lucro);
        return super.getAtletica().getCaixa().gerarMovimentacao(lucro, "Lucro da festa: "+e.getNome(), this , e.getResponsavel()); 
    }

    public Evento getEvento(String nome) {
        for(Evento e:listaEventos) {
                if (e.getNome().equals(nome)){
                        return e;
                }
        }
        return null;
    }
}
