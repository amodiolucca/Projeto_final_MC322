package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Atletica {
    
    private String nome;
    private String AnoGestao;
    private HashMap<String, Pessoa> integrantes;
    private ArrayList<Area> areas;
    private Caixa caixa;

    public Atletica(String nome, String anoGestao) {
        this.nome = nome;
        this.anoGestao = anoGestao;
        areas = new ArrayList<Area>(); // TODO Pensar em como já inicializar as areas no construtor para falicitar a instanciação
        integrantes = new HashMap<>();
        if (leituraIntegrantes()) {
            System.out.println("Registro de novos usuários realizado com sucesso!");
        } else {
            System.out.println("ERRO: Falha no registro de novos usuários!");
        }
    }

    public void iniciarAreas(){
        Eventos eventos = new Eventos();
        areas.add(eventos);
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
    	Atletica.nome = nome;
    }
    public String getAnoGestao() {
        return AnoGestao;
    }
    public void setAnoGestao(String anoGestao) {
        Atletica.AnoGestao = anoGestao;
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

    /*
    public ArrayList<Area> getAreas() {
        return areas;
    }
    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }
    
    public static Caixa getCaixa() {
        return caixa;
    }
    
    public static void setCaixa(Caixa caixa) {
        Atletica.caixa = caixa;
    }
    */

    // TODO Esse método só será chamado para uma movimentação de compra (Coloquei valores aleatórios, devemos mudar para adequar a realidade)
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

        // Presidente teoricamente deve possuir o direto de gerar uma movimentação de qualquer valor que tenha no caixar (TODO)
        return cargoDoUsuario.equals("Presidente") || (cargoDoUsuario.equals("Vice-Presidente") && valorMovimentacao <= 1000.0) ||
                (cargoDoUsuario.equals("Diretor") && valorMovimentacao <= 800.0) || (cargoDoUsuario.equals("Conselheiro") && valorMovimentacao <= 500.0) ||
                (cargoDoUsuario.equals("Membro") && valorMovimentacao <= 200.0);
    }

    private boolean leituraIntegrantes() {
        String linha = "";
        String separador = ",";
        // Variáveis para a leitura de cada linha de dadosIntegrantes.csv
        String cargoIntegrante, raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante, senhaIntegrante;
        try {
            BufferedReader in = new BufferedReader(new FileReader(".//src/projeto/classes/dadosIntegrantes.csv"));
            while((linha = in.readLine())!= null) {

                String[] dados = linha.split(separador);

                cargoIntegrante = dados[0];
                raIntegrante = dados[1];
                nomeIntegrante = dados[2];
                telefoneIntegrante = dados[3];
                areaIntegrante = dados[4];
                senhaIntegrante = dados[5];

                switch (cargoIntegrante) {
                    case "Membro":
                        Membro membro = new Membro(raIntegrante, nomeIntegrante, telefoneIntegrante, senhaIntegrante);
                        membro.getAreasDeInteresse().add(areaIntegrante);
                        integrantes.put(raIntegrante, membro);
                        break;
                    case "Diretor":
                        Diretor diretor = new Diretor(raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante,senhaIntegrante);
                        integrantes.put(raIntegrante,diretor);
                        break;
                    case "Presidente":
                        Presidente presidente = new Presidente(raIntegrante, nomeIntegrante, telefoneIntegrante, true, senhaIntegrante);
                        integrantes.put(raIntegrante,presidente);
                        break;
                    case "Vice-Presidente":
                        Presidente vicePresidente = new Presidente(raIntegrante, nomeIntegrante, telefoneIntegrante, false, senhaIntegrante);
                        integrantes.put(raIntegrante,vicePresidente);
                        break;
                    case "Conselheiro":
                        Conselheiro conselheiro = new Conselheiro(raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante,senhaIntegrante);
                        integrantes.put(raIntegrante,conselheiro);
                        break;
                    default:
                        break;
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
