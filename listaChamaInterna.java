package chamadaExtenaEIntern;

public class listaChamaInterna extends lista {

    void adicionar(ChamadaInterna nova) {

        if (isEmpty()) {
            addData(nova);
            return;
        }

        Node aux = begin;

        do {

            ChamadaInterna atual = (ChamadaInterna) aux.data;

            if (nova.getNivelInterno() > atual.getNivelInterno()) {
                addBefore(aux, nova);
                return;
            }

            aux = aux.next;

        } while (aux != begin);

        addData(nova);

    }
    

    void listar() {

        int tamanho = retornarTamanho();
        Node aux = begin;

        for (int i = 0; i < tamanho; i++) {

            ChamadaInterna c = (ChamadaInterna) aux.data;
            System.out.println(i + " - #" + c.id + " | " + c.cliente.getNome() + " | nivel tecnico: "
                    + c.getNivelInterno() + " | " + c.descricaoTecnica);

            aux = aux.next;

        }

    }

}
