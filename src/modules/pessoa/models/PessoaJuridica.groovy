package modules.pessoa.models

import groovy.transform.ToString
import modules.vaga.models.Vaga

@ToString(includeSuperFields = true, includeFields = true, includeNames = true)
class PessoaJuridica extends Pessoa{

    PessoaJuridica(int uid, int idade, String nome, String email, String estado, String cep, String descricao, String cnpj, List<Vaga> vagas) {
        super(uid, idade, nome, email, estado, cep, descricao)
        this.cnpj = cnpj
        this.vagas = vagas
    }
    String cnpj
    List<Vaga> vagas
}
