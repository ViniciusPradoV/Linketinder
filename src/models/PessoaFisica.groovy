package models

import groovy.transform.ToString

@ToString
class PessoaFisica extends Pessoa{

    String cpf
    List<String> competencias
}
