package modules.match.models

import groovy.transform.ToString
import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.vaga.models.Vaga

@ToString(includeNames = true)
class Match {

    int matchUid
    int candidatoUid
    int empresaUid
    int vagaUid

    boolean candidatoCurtiu = false;
    boolean empresaCurtiu = false;


}
