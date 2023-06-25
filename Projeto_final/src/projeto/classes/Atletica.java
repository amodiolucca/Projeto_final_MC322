package projeto.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Atletica {
    
    private String nome;
    private String anoGestao;
    private HashMap<String, Pessoa> integrantes;
    private ArrayList<Area> areas;
    private Caixa caixa;

    public Atletica(String nome, String anoGestao, String path, Double saldoInicioGestao) {
        this.nome = nome;
        this.anoGestao = anoGestao;
        areas = new ArrayList<Area>();
        iniciarAreas();
        integrantes = new HashMap<>();
        if (leituraIntegrantes(path)) {
            System.out.println("Registro de novos usuários realizado com sucesso!");
        } else {
            System.out.println("ERRO: Falha no registro de novos usuários!");
        }
        this.caixa = new Caixa(saldoInicioGestao);
    }

    public void iniciarAreas(){
        Eventos eventos = new Eventos(this);
        Esportes esportes = new Esportes(this);
        Social social = new Social(this);
        Financeiro financeiro = new Financeiro(this);
        Produtos produtos = new Produtos(this);
        areas.add(esportes);
        areas.add(eventos);
        areas.add(financeiro);
        areas.add(social);
        areas.add(produtos);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
    	this.nome = nome;
    }
    public String getAnoGestao() {
        return anoGestao;
    }
    public void setAnoGestao(String anoGestao) {
        this.anoGestao = anoGestao;
    }
    public HashMap<String, Pessoa> getIntegrantes() {
        return integrantes;
    }

    public boolean registraUsuario(Pessoa usuario) {
        if (!integrantes.containsKey(usuario.getRa())) {
            integrantes.put(usuario.getRa(), usuario);
            return true;
        }
        return false;
    }

    public boolean removeUsuario(String raUsuario) {
        if (integrantes.containsKey(raUsuario)) {
            integrantes.remove(raUsuario);
            return true;
        }
        return false;
    }

    public boolean verificaLoginSistema(String raUsuario, String senhaUsuario) {
        return integrantes.containsKey(raUsuario) && integrantes.get(raUsuario).getSenha().equals(senhaUsuario);
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }
    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }
    
    public Caixa getCaixa() {
        return caixa;
    }
    
    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public boolean validarMovimentacao(Pessoa usuario, Double valorMovimentacao){
        String cargoDoUsuario;
        if (usuario instanceof Presidente) {
            Presidente usuarioClassePresidente = (Presidente) usuario; // Downcast
            if (usuarioClassePresidente.getPosicao()) {
                cargoDoUsuario = "Presidente";
            } else {
                cargoDoUsuario = "Vice-Presidente";
            }
        } else {
            cargoDoUsuario = usuario.getClass().getSimpleName();
        }
        if (valorMovimentacao > this.getCaixa().getSaldoAtual()){
            return false;
        }
        return  (cargoDoUsuario.equals("Presidente") || (cargoDoUsuario.equals("Vice-Presidente"))) ||  // Presidente/vice podem retirar todo o valor
                (cargoDoUsuario.equals("Diretor") && valorMovimentacao <= 800.0) ||
                (cargoDoUsuario.equals("Conselheiro") && valorMovimentacao <= 500.0) ||
                (cargoDoUsuario.equals("Membro") && valorMovimentacao <= 200.0);
    }

    private boolean leituraIntegrantes(String path) {
    	ArquivoIntegrantes arquivo = new ArquivoIntegrantes(this);
		return arquivo.lerArquivo(path);
        
    }
    public Area getArea(String area) {
    	for(Area a: areas) {
    		if(a.getNome().equals(area)) {
    			return a;
    		}
    	}
    	return null;
    }
}

