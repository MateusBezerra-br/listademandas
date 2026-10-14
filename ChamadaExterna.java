package chamadaExtenaEIntern;

public class ChamadaExterna extends Chamada {

    int nivelDeUrgenciaExterna;

    ChamadaExterna(Cliente cliente, int id, int nivel) {
        super(cliente, id);
        this.nivelDeUrgenciaExterna = nivel;
    }

    int getNivel() {
        return this.nivelDeUrgenciaExterna;
    }

    void printDetalhes() {
        super.printDetalhes();
        System.out.println("Nivel (cliente): " + nivelDeUrgenciaExterna);
    }

}
