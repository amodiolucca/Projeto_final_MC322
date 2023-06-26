package projeto.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class ArquivoRelatorio {
    
    private final Caixa caixa;

    public ArquivoRelatorio(Caixa caixa) {
        this.caixa = caixa;
    }

    public boolean EscreverArquivo(String path) {

        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Header
            String header = "Valor,Descrição,Área,RA Solicitante,Nome Solicitante";
            bufferedWriter.write(header);
            bufferedWriter.newLine(); //Próxima linha

            // Write data to the CSV file
            for(Movimentacao m: caixa.getMovimentacoes()) {
                String[] dados = {Double.toString(m.getValor()), m.getDescricao(), m.getArea().getNome(), m.getSolicitante().getRa(), m.getSolicitante().getNome()};
                String dataLine = String.join(",", dados);
                bufferedWriter.write(dataLine);
                bufferedWriter.newLine();
            }

            bufferedWriter.flush();
            bufferedWriter.close();

            System.out.println("Arquivo relatorioMovimentacoes.csv criado com sucesso!");
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERRO: Não foi possível criar arquivo relatorioMovimentacoes.csv!");
            return false;
        }
    }
}
