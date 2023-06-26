package projeto.classes;

import java.util.ArrayList;

public class Produtos extends Area {
    
    private ArrayList<Produto> listaProdutos;
    
    public Produtos(Atletica atletica) {
        super(atletica, "Produtos");
        listaProdutos = new ArrayList<>();
    }
    
    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }
    
    public void setListaProdutos(ArrayList<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    
    //O ID do produto será o número de produtos anterior. Ou seja, o ID é sequencial iniciando em 0
    public boolean novoProduto(MenuOperacoes menu, String nome, double precoCompra, double precoVenda, String anoProducao, String path) {
        Produto p = new Produto(super.getAtletica(), nome, listaProdutos.size(), precoCompra, precoVenda, anoProducao, path);
        for (Produto produto: listaProdutos) {
            if(produto.getPathEncomendas().equals(path)) {
            	return false;
            }
        }
        listaProdutos.add(p);
        return p.receberEncomendas(menu);
    }
    
    public boolean encomendaRetirada(String nomeProduto, String telefone) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equals(nomeProduto)) {
                for (Encomenda e : p.getListaEncomendas()) {
                    if (e.getTelefoneCliente().equals(telefone)) {
                        return e.registrarRetirada();
                    }
                }
            }
        }    
        return false;
    }
    
    public Produto buscaProdutoPeloNome(String nomeProduto) {
        for (Produto p : listaProdutos) {
            if (p.getNome().equals(nomeProduto)) {
                return p;
            }
        }    
        return null;
    }
}
