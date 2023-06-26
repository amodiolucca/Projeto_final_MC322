package projeto.classes;
public class AppMain {
    
    public static void main(String args[]) {
        // Instancia um objeto da classe Altletica referente a gestão que terá o sistema de gerenciamento simulado
        Atletica atleticaECA23 = new Atletica("AAAECA", "2023",".//src/projeto/classes/dadosIntegrantes.csv", 5000.0);
        
        // Chamamos as GUI do sistema de gerenciamento para a instância de Atletica
        Login loginFrame = new Login(atleticaECA23);
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
}
