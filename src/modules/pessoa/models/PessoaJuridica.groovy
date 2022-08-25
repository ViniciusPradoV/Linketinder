package modules.pessoa.models

import groovy.transform.ToString
import modules.match.models.Match
import modules.vaga.models.Vaga

@ToString(includeSuperFields = true, includeFields = true, includeNames = true)
class PessoaJuridica extends Pessoa{

    String cnpj
    List<Vaga> vagas
    List<Match> matches

    PessoaJuridica(int uid, String nome, String email, String estado, String cep, String descricao, String cnpj, List<Vaga> vagas, List<Match> matches) {
        super(uid, nome, email, estado, cep, descricao)
        this.cnpj = cnpj
        this.vagas = vagas
        this.matches = matches
    }

    PessoaJuridica(int uid, int idade, String nome, String email, String estado, String cep, String descricao, String cnpj, List<Match> matches) {
        super(uid, idade, nome, email, estado, cep, descricao)
        this.cnpj = cnpj
        this.matches = matches
    }

}
