package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoEncomenda implements leituraDados { 
    
    private final Produto produto;
    MenuOperacoes menu;
    
    public ArquivoEncomenda(Produto produto, MenuOperacoes menu) {
        this.produto = produto;
        this.menu = menu;
    }

    public boolean lerArquivo(String path) {
        String linha = "";
        String separador = ",";
        String nomeCliente, telefoneCliente, tamanho, quantidade;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while((linha = in.readLine())!= null) {
                String[] dados = linha.split(separador);
                
                nomeCliente = dados[0];
                telefoneCliente = dados[1];
                tamanho = dados[2];
                
                if(!nomeCliente.equals("AAAECA")) {
                	produto.getAtletica().getCaixa().gerarMovimentacao(produto.getPrecoVenda(), "Venda do produto: " + produto.getNome(), produto.getAtletica().getArea("Produtos"), menu.getUsuarioLogado());
                	produto.getAtletica().getCaixa().gerarMovimentacao(-produto.getPrecoCompra(), "Compra do produto: " + produto.getNome(), produto.getAtletica().getArea("Produtos"), menu.getUsuarioLogado());
                    produto.getListaEncomendas().add(new Encomenda(nomeCliente, telefoneCliente, new Item(tamanho)));
                } else {
                    Item item = produto.buscarItem(tamanho);
                    quantidade = dados[3];
                    if (item != null) {
                        item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()+ Integer.parseInt(quantidade));
                    } else {
                        item = new Item(tamanho);
                        item.setQuantidadeDisponivel(Integer.parseInt(quantidade));
                        produto.getEstoque().add(item);
                    }
                    if(produto.getAtletica().getCaixa().getSaldoAtual()<produto.getPrecoCompra()*Integer.parseInt(quantidade)) {
                    	System.out.println("Saldo inválido para a compra em estoque");
                    }else {
                    	produto.getAtletica().getCaixa().gerarMovimentacao(-produto.getPrecoCompra() * Integer.parseInt(quantidade), "Compra do produto: " + produto.getNome(), produto.getAtletica().getArea("Produtos") , menu.getUsuarioLogado());
                    }
                    
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
