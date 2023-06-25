package projeto.classes;

import java.util.ArrayList;

public class Produto {
	private Atletica atletica;
	private String nome;
	private int ID;
	private double precoCompra;
	private double precoVenda;
	private ArrayList<Item> estoque;
	private ArrayList<Encomenda> encomenda;
	private String anoProducao;
	private int quantidadeVendida = 0;
	private double lucro = 0.0;
	
	public Produto(Atletica atletica, String nome, int ID, double precoCompra, double precoVenda, String anoProducao) {
		this.nome = nome;
		this.ID = ID;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.estoque = new ArrayList<>();
		this.encomenda = new ArrayList<>();
		this.anoProducao = anoProducao;
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
	public ArrayList<Encomenda> getEncomenda() {
		return encomenda;
	}
	public void setEncomenda(ArrayList<Encomenda> encomenda) {
		this.encomenda = encomenda;
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
	
	public boolean criarProduto(String path) {
		ArquivoEncomenda arquivo = new ArquivoEncomenda(this);
		return arquivo.lerArquivo(path);
	}
	

}
