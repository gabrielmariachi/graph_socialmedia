/**
 * Created by ico_gabriel on 16/11/2015.
 */
public class Pessoa {
    int id = 0;
    String nome;
    int idade;

    public Pessoa(int id, String nome, int idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    //to show the itens from each element
    //public String toString() {
    //    return id + ", " + nome + ", " + idade;
    //}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
