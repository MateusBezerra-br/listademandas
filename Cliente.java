package chamadaExtenaEIntern;

public class Cliente {

    private String nome;
    private String gmail;

    Cliente(String nome, String gmail) {
        this.nome = nome;
        this.gmail = gmail;
    }

    public String getNome() {
        return nome;
    }

    public String getGmail() {
        return gmail;
    }

    void printDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Gmail: " + gmail);
    }

}
