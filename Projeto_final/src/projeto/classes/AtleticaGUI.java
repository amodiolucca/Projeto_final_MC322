package projeto.classes;

public class AtleticaGUI {

    public static void main(String args[]) {
        // TODO Para conseguir acesso das informações da instancia Atletica na GUI precisamos passar como parametro no construtor (?)
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
    }
        
}
