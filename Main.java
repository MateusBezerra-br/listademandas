package chamadaExtenaEIntern;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static listaChamadaExterna chamadasExternas = new listaChamadaExterna();
    static listaChamaInterna chamadasInternas = new listaChamaInterna();
    static int proximoId = 1;

    public static void main(String[] args) {

        int opcao = -1;

        while (opcao != 0) {

            opcoes();
            opcao = lerInt("Escolha: ");

            if (opcao == 1) {
                abrirChamadaExterna();
            } else if (opcao == 2) {
                listarExternas();
            } else if (opcao == 3) {
                analisarChamada();
            } else if (opcao == 4) {
                listarInternas();
            } else if (opcao != 0) {
                System.out.println("Opcao invalida.");
            }

        }

    }

    static void opcoes() {
        System.out.println();
        System.out.println("1- Sou o cliente");
        System.out.println("2- Tecnico: ver chamadas externas");
        System.out.println("3- Tecnico: analisar chamada externa");
        System.out.println("4- Tecnico: ver chamadas internas");
        System.out.println("0- Sair");
    }

    static void abrirChamadaExterna() {

        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Gmail: ");
        String gmail = input.nextLine();

        int nivel = lerNivel();

        ChamadaExterna chamada = new ChamadaExterna(new Cliente(nome, gmail), proximoId, nivel);
        proximoId++;

        System.out.println("Urgencias (linha vazia para terminar):");

        String txt = input.nextLine();

        while (!txt.isEmpty()) {
            chamada.addUrgencias(txt);
            txt = input.nextLine();
        }

        chamadasExternas.adicionar(chamada);
        System.out.println("Chamada #" + chamada.id + " registrada.");

    }

    static void listarExternas() {

        if (chamadasExternas.isEmpty()) {
            System.out.println("Nenhuma chamada externa.");
            return;
        }

        chamadasExternas.listar();

    }

    static void analisarChamada() {

        if (chamadasExternas.isEmpty()) {
            System.out.println("Nenhuma chamada externa.");
            return;
        }

        chamadasExternas.listar();

        int index = lerInt("Numero da chamada: ");

        if (index < 0 || index >= chamadasExternas.retornarTamanho()) {
            System.out.println("Numero invalido.");
            return;
        }

        ChamadaExterna externa = chamadasExternas.buscar(index);

        externa.printDetalhes();

        System.out.print("Aceitar? (s/n): ");
        String resposta = input.nextLine();

        if (!resposta.equals("s")) {
            return;
        }

        System.out.print("Descricao tecnica: ");
        String descricao = input.nextLine();

        int nivelTecnico = lerNivel();

        ChamadaInterna interna = new ChamadaInterna(externa, nivelTecnico, descricao);

        chamadasExternas.removeData(index);
        chamadasInternas.adicionar(interna);

        System.out.println("Chamada #" + interna.id + " agora e interna.");

    }

    static void listarInternas() {

        if (chamadasInternas.isEmpty()) {
            System.out.println("Nenhuma chamada interna.");
            return;
        }

        chamadasInternas.listar();

    }

    static int lerNivel() {

        int nivel = 0;

        while (nivel < 1 || nivel > 4) {
            nivel = lerInt("Nivel de urgencia (1-baixa 2-media 3-alta 4-critica): ");
        }

        return nivel;

    }

    static int lerInt(String msg) {

        System.out.print(msg);
        return Integer.parseInt(input.nextLine().trim());

    }

}
