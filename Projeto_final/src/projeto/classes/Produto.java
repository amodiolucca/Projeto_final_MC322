package projeto.classes;

import java.util.ArrayList;

public class Produto {
    
    private Atletica atletica;
    private String nome;
    private int ID;
    private double precoCompra;
    private double precoVenda;
    private ArrayList<Item> estoque;
    private ArrayList<Encomenda> listaEncomendas;
    private String anoProducao;
    private String pathEncomendas;
    private int quantidadeVendida = 0;
    private double lucro = 0.0;

    public Produto(Atletica atletica, String nome, int ID, double precoCompra, double precoVenda, String anoProducao, String pathEncomendas) {
        this.nome = nome;
        this.ID = ID;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoque = new ArrayList<>();
        this.listaEncomendas = new ArrayList<>();
        this.anoProducao = anoProducao;
        this.pathEncomendas = pathEncomendas;
        this.quantidadeVendida = 0;
        this.lucro = 0.0;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int iD) {
        ID = iD;
    }
    
    public double getPrecoCompra() {
        return precoCompra;
    }
    
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }
    
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    public ArrayList<Item> getEstoque() {
        return estoque;
    }
    
    public void setEstoque(ArrayList<Item> estoque) {
        this.estoque = estoque;
    }
    
    public ArrayList<Encomenda> getListaEncomendas() {
        return listaEncomendas;
    }
    
    public void setListaEncomendas(ArrayList<Encomenda> listaEncomendas) {
        this.listaEncomendas = listaEncomendas;
    }
    
    public String getAnoProducao() {
        return anoProducao;
    }
    
    public void setAnoProducao(String anoProducao) {
        this.anoProducao = anoProducao;
    }
    
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    
    public double getLucro() {
        return lucro;
    }
    
    public void setLucro(double lucro) {
        this.lucro = lucro;
    }
    
    public Atletica getAtletica() {
        return atletica;
    }
    
    public void setAtletica(Atletica atletica) {
            this.atletica = atletica;
    }
    
    public String getPathEncomendas() {
        return pathEncomendas;
    }
    
    public void setPathEncomendas(String pathEncomendas) {
            this.pathEncomendas = pathEncomendas;
    }

    public boolean venderProduto(Item item, Pessoa pessoa) {
        if(estoque.contains(item)) {
            item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()-1);
            atualizarEstoque(item);
            atletica.getCaixa().gerarMovimentacao(precoVenda, "Venda do produto: "+this.getNome(), atletica.getArea("Produtos"), pessoa); 
            return true;
        }
        return false;
    }

    private void atualizarEstoque(Item item) {
        if(item.getQuantidadeDisponivel()==0) {
            estoque.remove(item);
        }
    }

    public boolean receberEncomendas(MenuOperacoes menu) {
        ArquivoEncomenda arquivo = new ArquivoEncomenda(this , menu);
        return arquivo.lerArquivo(pathEncomendas);
    }

    public Item buscarItem(String tamanho) {
        for (Item i : estoque) {
            if (i.getTamanho().equals(tamanho)) {
                return i;
            }
        }
        return null;
    }
}
