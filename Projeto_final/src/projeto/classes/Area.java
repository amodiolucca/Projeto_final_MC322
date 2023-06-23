package projeto.classes;

import java.util.ArrayList;

public abstract class Area {
	
	private static String nome;
	private static ArrayList<Pessoa> diretores;
	private static Double saldoFinanceiro;
	private static ArrayList<Pessoa> membrosInteressados;
	
	//Construtor
	/*public Area(String nome) {
		this.nome = nome;
		this.diretores = new ArrayList<>();
		this.saldoFinanceiro = 0.0; //inicializa o saldo da área como 0
		this.membrosInteressados = new ArrayList<>();
	}*/
	
	//getters e setters
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		Area.nome = nome;
	}
	
	public static ArrayList<Pessoa> getDiretores(){
		return diretores;
	}
	public static void setDiretores(ArrayList<Pessoa> lista) {
		Area.diretores = lista;
	}
	
	public static Double getSaldoFinanceiro() {
		return saldoFinanceiro;
	}
	public static void setSaldoFinanceiro(Double saldo) {
		Area.saldoFinanceiro = saldo;
	}
	
	public static ArrayList<Pessoa> getMembrosInteressados(){
		return membrosInteressados;
	}
	public static void setMembrosInteressados(ArrayList<Pessoa> lista) {
		Area.membrosInteressados = lista;
	}
	
	
	public static boolean adicionarMembro(Pessoa pessoa) {
		if(!membrosInteressados.contains(pessoa)) {
			return membrosInteressados.add(pessoa);
		}
		return false;
	}
	
	public static boolean removerMembro(Pessoa pessoa) {
		if(membrosInteressados.contains(pessoa)) {
			return membrosInteressados.remove(pessoa);
		}
		return false;
	}

}
