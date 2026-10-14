package chamadaExtenaEIntern;

public class Chamada {

    int id;
    Cliente cliente;
    lista urgencias = new lista();

    Chamada(Cliente cliente, int id) {
        this.cliente = cliente;
        this.id = id;
    }

    void addUrgencias(String urgencia) {
        urgencias.addData("* " + urgencia);
    }

    void dadosCliente() {
        cliente.printDados();
    }

    void printUrgencias() {

        int tamanho = urgencias.retornarTamanho();
        Node aux = urgencias.begin;

        for (int i = 0; i < tamanho; i++) {

            String txt = (String) aux.data;
            System.out.println(txt);

            aux = aux.next;

        }
    }

    void printDetalhes() {
        System.out.println("Chamada #" + id);
        dadosCliente();
        System.out.println("Urgencias:");
        printUrgencias();
    }

}
