package projeto.classes;

public class Diretor extends Pessoa {
	
    private String area;

    //Construtor
    public Diretor(String ra, String nome, String telefone, String area, String senha) {
        super(ra, nome, telefone, senha);
        this.area = area;
    }

    //getters e setters
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    
}
