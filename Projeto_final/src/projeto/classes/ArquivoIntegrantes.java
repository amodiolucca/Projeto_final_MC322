package projeto.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArquivoIntegrantes implements leituraDados {
    
    private Atletica atletica;

    public ArquivoIntegrantes(Atletica atletica) {
        this.atletica = atletica;
    }

    public boolean lerArquivo(String path) {
        String linha = "";
        String separador = ",";
        // Variáveis para a leitura de cada linha de dadosIntegrantes.csv
        String cargoIntegrante, raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante, senhaIntegrante;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
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
                        
                        atletica.insereMembroArea(areaIntegrante, membro);
                        atletica.getIntegrantes().put(raIntegrante, membro);
                        break;
                    case "Diretor":
                        Diretor diretor = new Diretor(raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante,senhaIntegrante);
                        atletica.insereDiretorArea(areaIntegrante, diretor);
                        atletica.getIntegrantes().put(raIntegrante,diretor);
                        break;
                    case "Presidente":
                        Presidente presidente = new Presidente(raIntegrante, nomeIntegrante, telefoneIntegrante, true, senhaIntegrante);
                        atletica.getIntegrantes().put(raIntegrante,presidente);
                        break;
                    case "Vice-Presidente":
                        Presidente vicePresidente = new Presidente(raIntegrante, nomeIntegrante, telefoneIntegrante, false, senhaIntegrante);
                        atletica.getIntegrantes().put(raIntegrante,vicePresidente);
                        break;
                    case "Conselheiro":
                        Conselheiro conselheiro = new Conselheiro(raIntegrante, nomeIntegrante, telefoneIntegrante, areaIntegrante,senhaIntegrante);
                        conselheiro.setAreaAnterior(areaIntegrante);
                        atletica.getIntegrantes().put(raIntegrante,conselheiro);
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
