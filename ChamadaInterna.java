package chamadaExtenaEIntern;

public class ChamadaInterna extends Chamada {

    int nivelDeUrgenciaExterna;
    int nivelDeUrgenciaInterna;
    String descricaoTecnica;

    ChamadaInterna(ChamadaExterna origem, int nivelInterno, String descricao) {
        super(origem.cliente, origem.id);
        this.urgencias = origem.urgencias;
        this.nivelDeUrgenciaExterna = origem.getNivel();
        this.nivelDeUrgenciaInterna = nivelInterno;
        this.descricaoTecnica = descricao;
    }



    int getNivelInterno() {
        return this.nivelDeUrgenciaInterna;
    }



    void printDetalhes() {
        super.printDetalhes();
        System.out.println("Nivel (cliente): " + nivelDeUrgenciaExterna);
        System.out.println("Nivel (tecnico): " + nivelDeUrgenciaInterna);
        System.out.println("Descricao tecnica: " + descricaoTecnica);
    }

}
