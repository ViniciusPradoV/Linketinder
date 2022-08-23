package models

import groovy.transform.ToString

@ToString
class PessoaJuridica extends Pessoa{

    String cnpj
    List<Vaga> vagas
}
