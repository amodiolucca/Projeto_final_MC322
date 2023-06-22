package projeto.classes;

public class Encomenda {
	private boolean retirada;
	private String nomeCliente;
	private String telefoneCliente;
	private Item pedido;
	
	public Encomenda(String nomeCliente, String telefoneCliente, Item pedido) {
		this.nomeCliente = nomeCliente;
		this.telefoneCliente = telefoneCliente;
		this.pedido = pedido;
		this.retirada = false;
	}

	public boolean getRetirada() {
		return retirada;
	}

	public void setRetirada(boolean retirada) {
		this.retirada = retirada;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public Item getPedido() {
		return pedido;
	}

	public void setPedido(Item pedido) {
		this.pedido = pedido;
	}
	
	public boolean registrarRetirada() {
		if(retirada == false) {
			retirada = true;
			return true;
		}
		return false;
	}
	
	
}
