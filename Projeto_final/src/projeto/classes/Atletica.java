package projeto.classes;

import java.util.ArrayList;

public class Atletica {
    
    private String nome;
    private String AnoGestao;
    private ArrayList<Pessoa> integrantes;
    private ArrayList<Area> areas;
    private Caixa caixa;
    
    public Atletica(String nome, String anoGestao, ArrayList<Pessoa> integrantes, ArrayList<Area> areas, Caixa caixa) {
        this.nome = nome;
        AnoGestao = anoGestao;
        this.integrantes = integrantes;
        this.areas = areas;
        this.caixa = caixa;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAnoGestao() {
        return AnoGestao;
    }
    public void setAnoGestao(String anoGestao) {
        AnoGestao = anoGestao;
    }
    public ArrayList<Pessoa> getIntegrantes() {
        return integrantes;
    }
    public void setIntegrantes(ArrayList<Pessoa> integrantes) {
        this.integrantes = integrantes;
    }
    public ArrayList<Area> getAreas() {
        return areas;
    }
    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }
    public Caixa getCaixa() {
        return caixa;
    }
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public boolean autorizarOperacao(String cargoNecessario, Pessoa operador){
        if (cargoNecessario.equals("presidente")){
            return (operador instanceof Presidente);
        }
        else if (cargoNecessario.equals("diretor")){
            return (operador instanceof Diretor);
        }
        return false;
    }    
}
