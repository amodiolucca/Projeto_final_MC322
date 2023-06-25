package projeto.classes;

public class AppMain {
    public static void main(String args[]) {
        // Instancia um objeto da classe Altletica referente a gestão que terá o sistema de gerenciamento simulado
        Atletica atleticaECA23 = new Atletica("AAAECA", "2023",".//src/projeto/classes/dadosIntegrantes.csv", 500.00);
        //TESTE - APAGAR
        System.out.println(atleticaECA23.getIntegrantes().size());
        Area eventos = atleticaECA23.getArea("Eventos");
        Eventos eventosE = ((Eventos) eventos);
        eventosE.registrarEvento("teste", "2023-07-07", atleticaECA23.getIntegrantes().get("121156"));
        eventosE.resultadoEvento("teste", 500.0, eventosE.getEvento("teste"));
        atleticaECA23.getCaixa().gerarRelatorio();
        // Chamamos as GUI do sistema de gerenciamento para a instância de Atletica
        Login loginFrame = new Login(atleticaECA23);
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}
