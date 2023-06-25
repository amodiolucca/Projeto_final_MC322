package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ArquivoEncomenda implements leituraDados {
	private Produto produto;
	
	public ArquivoEncomenda(Produto produto) {
		this.produto = produto;
	}
	
	public boolean lerArquivo(String path) {
		String linha = "";
		String separador = ";";
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(!dados[0].equals("AAAECA")) {
					produto.getAtletica().getCaixa().gerarMovimentacao(-produto.getPrecoCompra(), "Compra do produto: "+produto.getNome(), null , null);
					produto.getEncomenda().add(new Encomenda(dados[0], dados [1], new Item(dados[2])));
				} else {
					// TODO Repeticao de itens
					Item item = new Item(dados[2]);
					item.setQuantidadeDisponivel(Integer.parseInt(dados[3]));
					produto.getEstoque().add(item);
					produto.getAtletica().getCaixa().gerarMovimentacao(-produto.getPrecoCompra()*Integer.parseInt(dados[3]), "Venda do produto: "+ produto.getNome(), null , null);
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
