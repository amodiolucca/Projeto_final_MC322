package projeto.classes;

import java.util.ArrayList;

public class Produtos extends Area {
	private ArrayList<Produto> listaProdutos;
	public Produtos(Atletica atletica) {
		super(atletica, "Produtos");
		listaProdutos = new ArrayList<>();
	}
	//O ID do produto será o número de produtos anterior. Ou seja, o ID é sequencial iniciando em 0
	public boolean novoProduto(String nome, double precoCompra, double precoVenda, String anoProducao) {
		return listaProdutos.add(new Produto(super.getAtletica(), nome, listaProdutos.size(), precoCompra, precoVenda, anoProducao));
	}
	
}
