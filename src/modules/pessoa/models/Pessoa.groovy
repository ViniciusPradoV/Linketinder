package modules.pessoa.models

import groovy.transform.ToString

@ToString
class Pessoa {

    Pessoa(int uid, int idade, String nome, String email, String estado, String cep, String descricao) {
        this.uid = uid
        this.idade = idade
        this.nome = nome
        this.email = email
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
    }
    int uid, idade
    String nome, email, estado,cep, descricao

    Pessoa(int uid,  String nome, String email, String estado, String cep, String descricao) {
        this.uid = uid
        this.nome = nome
        this.email = email
        this.estado = estado
        this.cep = cep
        this.descricao = descricao
    }
}
