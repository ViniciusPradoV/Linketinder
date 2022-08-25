package modules.vaga.models

import groovy.transform.ToString
import modules.pessoa.models.PessoaJuridica

@ToString(includeNames = true)
class Vaga {

    int uid, empresaUid
    String nome, descricao, competenciasExigidas, cidade, estado

    Vaga(int uid, String nome, String descricao, String competencias, String cidade, String estado) {
        this.uid = uid
        this.nome = nome
        this.descricao = descricao
        this.competenciasExigidas = competencias
        this.cidade = cidade
        this.estado = estado
    }

    Vaga(int uid, String nome, String descricao, String competencias, String cidade, String estado, int empresaUid) {
        this.uid = uid
        this.nome = nome
        this.descricao = descricao
        this.competenciasExigidas = competencias
        this.cidade = cidade
        this.estado = estado
        this.empresaUid = empresaUid
    }
}
