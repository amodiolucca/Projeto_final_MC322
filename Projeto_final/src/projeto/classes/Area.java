package projeto.classes;

import java.util.ArrayList;

public abstract class Area {
	
    private Atletica atletica;
    private ArrayList<Pessoa> diretores;
    private Double saldoFinanceiro;
    private ArrayList<Pessoa> membrosInteressados;
    private String nome;

    //Construtor
    public Area(Atletica atletica, String nome) {
        this.atletica = atletica;
        diretores = new ArrayList<>();
        saldoFinanceiro = 0.0; //inicializa o saldo da área como 0
        membrosInteressados = new ArrayList<>();
        this.nome = nome;
    }

    //getters e setters
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public ArrayList<Pessoa> getDiretores(){
        return diretores;
    }
    
    public void setDiretores(ArrayList<Pessoa> lista) {
        this.diretores = lista;
    }

    public Double getSaldoFinanceiro() {
        return saldoFinanceiro;
    }
    
    public void setSaldoFinanceiro(Double saldo) {
        this.saldoFinanceiro = saldo;
    }

    public ArrayList<Pessoa> getMembrosInteressados(){
        return membrosInteressados;
    }
    
    public void setMembrosInteressados(ArrayList<Pessoa> lista) {
        this.membrosInteressados = lista;
    }
    
    public Atletica getAtletica() {
        return atletica;
    }
    
    public void setAtletica(Atletica atletica) {
        this.atletica = atletica;
    }

    public boolean adicionarMembro(Pessoa pessoa) {
        if(!membrosInteressados.contains(pessoa)) {
        	
            return membrosInteressados.add(pessoa);
        }
        return false;
    }
    public boolean adicionarDiretor(Pessoa pessoa) {
        if(!diretores.contains(pessoa)) {
        	
            return diretores.add(pessoa);
        }
        return false;
    }

    public boolean removerMembro(Pessoa pessoa) {
        if(membrosInteressados.contains(pessoa)) {
            return membrosInteressados.remove(pessoa);
        }
        return false;
    }
    
    public int quantidadeInteressados() {
        return membrosInteressados.size();
    }
    
    public void atualizaSaldoFinanceiro(Double valorMovimentacao) {
        saldoFinanceiro += valorMovimentacao;
    }
}
