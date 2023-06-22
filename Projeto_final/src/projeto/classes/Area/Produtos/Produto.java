package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Produto {
	
	private String nome;
	private int ID;
	private double precoCompra;
	private double precoVenda;
	private ArrayList<Item> estoque;
	private ArrayList<Encomenda> encomenda;
	private LocalDate anoProducao;
	private int quantidadeVendida = 0;
	private double lucro = 0.0;
	
	public Produto(String nome, int ID, double precoCompra, double precoVenda, String anoProducao) {
		this.nome = nome;
		this.ID = ID;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.estoque = new ArrayList<>();
		this.encomenda = new ArrayList<>();
		this.anoProducao = LocalDate.parse(anoProducao);
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
	public LocalDate getAnoProducao() {
		return anoProducao;
	}
	public void setAnoProducao(String anoProducao) {
		this.anoProducao = LocalDate.parse(anoProducao);
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
	
	public boolean venderProduto(Item item) {
		if(estoque.contains(item)) {
			item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()-1);
			atualizarEstoque(item);
			Caixa.gerarMovimentacao(precoVenda, "Venda do produto: "+this.getNome(), null , null); //ALTERAR!!!
			//depois da implementação de Produtos, colocar Produtos no primeiro null e a Pessoa buscada pelo RA na lista de Pessoas no segundo null
			//Fiz um getRA no Menu pra pegar o RA do usuario e buscar na lista de Pessoas
			return true;
		}
		return false;
	}
	
	private void atualizarEstoque(Item item) {
		if(item.getQuantidadeDisponivel()==0) {
			estoque.remove(item);
		}
	}
	
	public boolean criarProduto(String nome,int id, double precoCompra, double precoVenda, String anoProducao, String path) {
		String linha = "";
		String separador = ";";
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(!dados[0].equals("AAAECA")) {
					encomenda.add(new Encomenda(dados[0], dados [1], new Item(dados[3])));
				} else {
					Item item = new Item(dados[3]);
					item.setQuantidadeDisponivel(Integer.parseInt(dados[4]));
					estoque.add(item);
				}
			}
			in.close();
			return true;
		} catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

}
