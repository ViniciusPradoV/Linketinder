package modules.pessoa.models

import groovy.transform.ToString
import modules.match.models.Match

@ToString(includeSuperFields = true, includeFields = true, includeNames = true)
class PessoaFisica extends Pessoa{

    String cpf
    List<String> competencias
    List<Match> matches

    PessoaFisica(int uid, int idade, String nome, String email, String estado, String cep, String descricao, String cpf, List<String> competencias, List<Match> matches) {
        super(uid, idade, nome, email, estado, cep, descricao)
        this.cpf = cpf
        this.competencias = competencias
        this.matches = matches
    }


}
