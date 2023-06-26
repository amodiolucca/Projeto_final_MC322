package projeto.classes;

import java.util.ArrayList;

public class Membro extends Pessoa {
	
    private ArrayList<String> areasDeInteresse;

    //Construtor
    public Membro(String ra, String nome, String telefone, String senha) {
        super(ra, nome, telefone, senha);
        this.areasDeInteresse = new ArrayList<>();
    }

    //getters e setters
    public ArrayList<String> getAreasDeInteresse(){
        return areasDeInteresse;
    }
    public void setAreasDeInteresse(ArrayList<String> lista) {
        this.areasDeInteresse = lista;
    }
}
