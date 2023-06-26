package projeto.classes;

import java.util.ArrayList;

public abstract class Area {
    
    private Atletica atletica;
    private String nome;
    private ArrayList<Diretor> diretores;
    private ArrayList<Conselheiro> conselheiros;
    private ArrayList<Membro> membrosInteressados;
    private Double saldoFinanceiro;

    //Construtor
    public Area(Atletica atletica, String nome) {
        this.atletica = atletica;
        this.nome = nome;
        diretores = new ArrayList<>();
        conselheiros = new ArrayList<>();
        membrosInteressados = new ArrayList<>();
        saldoFinanceiro = 0.0; //inicializa o saldo da área como 0
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Atletica getAtletica() {
        return atletica;
    }
    
    public void setAtletica(Atletica atletica) {
        this.atletica = atletica;
    }
    
    public ArrayList<Diretor> getDiretores(){
        return diretores;
    }
    
    public void setDiretores(ArrayList<Diretor> lista) {
        this.diretores = lista;
    }
    
    public ArrayList<Conselheiro> getConselheiros(){
        return conselheiros;
    }
    
    public void setConselheiros(ArrayList<Conselheiro> lista) {
        this.conselheiros = lista;
    }
    
    public ArrayList<Membro> getMembrosInteressados(){
        return membrosInteressados;
    }
    
    public void setMembrosInteressados(ArrayList<Membro> lista) {
        this.membrosInteressados = lista;
    }

    public Double getSaldoFinanceiro() {
        return saldoFinanceiro;
    }
    
    public void setSaldoFinanceiro(Double saldo) {
        this.saldoFinanceiro = saldo;
    }

    public boolean adicionarMembro(Membro membro) {
        if(!membrosInteressados.contains(membro)) {
            return membrosInteressados.add(membro);
        }
        return false;
    }
    
    public boolean adicionarDiretor(Diretor diretor) {
        if(!diretores.contains(diretor)) {
            return diretores.add(diretor);
        }
        return false;
    }
    
    public boolean adicionarConselheiro(Conselheiro conselheiro) {
        if(!conselheiros.contains(conselheiro)) {
            return conselheiros.add(conselheiro);
        }
        return false;
    }
    
    public boolean removerMembro(Membro membro) {
        if(membrosInteressados.contains(membro)) {
            return membrosInteressados.remove(membro);
        }
        return false;
    }
    
    public int quantidadeInteressados() {
        return membrosInteressados.size() + diretores.size() + conselheiros.size();
    }
    
    public void atualizaSaldoFinanceiro(Double valorMovimentacao) {
        saldoFinanceiro += valorMovimentacao;
    }
}
