package modules.vaga.models

import groovy.transform.ToString

@ToString
class Vaga {

    Vaga(String nome, String descricao, String competencias, String cidade, String estado) {
        this.nome = nome
        this.descricao = descricao
        this.competenciasExigidas = competencias
        this.cidade = cidade
        this.estado = estado
    }
    String nome, descricao, competenciasExigidas, cidade, estado
}
