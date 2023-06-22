package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Atletica {
    
    private static String nome;
    private static String AnoGestao;
    private static ArrayList<Pessoa> integrantes = new ArrayList<>();
    //ArrayList<Area> areas = new ArrayList<>(Arrays.asList(Esportes,Eventos,Financeiro, Social, Produtos));
    //private static Caixa caixa;
    
    public static String getNome() {
        return nome;
    }
    public static void setNome(String nome) {
    	Atletica.nome = nome;
    }
    public static String getAnoGestao() {
        return AnoGestao;
    }
    public static void setAnoGestao(String anoGestao) {
        Atletica.AnoGestao = anoGestao;
    }
    public static ArrayList<Pessoa> getIntegrantes() {
        return integrantes;
    }
    public void setIntegrantes(ArrayList<Pessoa> integrantes) {
        this.integrantes = integrantes;
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
    public static boolean autorizarOperacao(String cargoNecessario, Pessoa operador){
        if (cargoNecessario.equals("presidente")){
            return (operador instanceof Presidente);
        }
        else if (cargoNecessario.equals("diretor")){
            return (operador instanceof Diretor);
        }
        return false;
    }
    
    public static boolean leituraIntegrantes(String path) {
    	String linha = "";
		String separador = ";";
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			while((linha = in.readLine())!= null) {
				String[] dados = linha.split(separador);
				if(dados[0].equals("Membro")) {
					Membro membro = new Membro(dados[1], dados[2], dados[3]);
					membro.getAreasDeInteresse().add(dados[4]);
				} /*else if (dados[0].equals("Diretor")) {
					
				}*/
			}
			in.close();
			return true;
		} catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
