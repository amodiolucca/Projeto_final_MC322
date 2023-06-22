package projeto.classes;

import java.util.ArrayList;


public class Caixa {
	private static Double saldoAtual;
	private static ArrayList<Movimentacao> movimentacoes;
	
	public static Double getSaldoAtual() {
		return saldoAtual;
	}
	public static void setSaldoAtual(Double saldoAtual) {
		Caixa.saldoAtual = saldoAtual;
	}
	public static ArrayList<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}
	public static void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
		Caixa.movimentacoes = movimentacoes;
	}
	
	public static boolean gerarMovimentacao(Double valor, String descricao, Area area, Pessoa solicitante) {
		return movimentacoes.add(new Movimentacao(valor, descricao, area, solicitante));
	}
	
	
}
