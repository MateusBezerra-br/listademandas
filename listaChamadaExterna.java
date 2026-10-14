package chamadaExtenaEIntern;

public class listaChamadaExterna extends lista {

    void adicionar(ChamadaExterna nova) {

        if (isEmpty()) {
            addData(nova);
            return;
        }

        Node aux = begin;

        do {

            ChamadaExterna atual = (ChamadaExterna) aux.data;

            if (nova.getNivel() > atual.getNivel()) {
                addBefore(aux, nova);
                return;
            }

            aux = aux.next;

        } while (aux != begin);

        addData(nova);

    }

    ChamadaExterna buscar(int index) {
        return (ChamadaExterna) procurarData(index);
    }

    void listar() {

        int tamanho = retornarTamanho();
        Node aux = begin;

        for (int i = 0; i < tamanho; i++) {

            ChamadaExterna c = (ChamadaExterna) aux.data;
            System.out.println(i + " - #" + c.id + " | " + c.cliente.getNome() + " | nivel: " + c.getNivel());

            aux = aux.next;

        }

    }

}
