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

    void setNivelInterno(int nivel) {
        this.nivelDeUrgenciaInterna = nivel;
    }

    int getNivelInterno() {
        return this.nivelDeUrgenciaInterna;
    }

    void setDescricaoTecnica(String descricao) {
        this.descricaoTecnica = descricao;
    }

    void printDetalhes() {
        super.printDetalhes();
        System.out.println("Nivel (cliente): " + nivelDeUrgenciaExterna);
        System.out.println("Nivel (tecnico): " + nivelDeUrgenciaInterna);
        System.out.println("Descricao tecnica: " + descricaoTecnica);
    }

}
