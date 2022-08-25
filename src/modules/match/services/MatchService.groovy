package modules.match.services

import modules.match.models.Match
import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.vaga.models.Vaga
import services.PrintAndGetService

class MatchService {

    static void curtidaCandidato(PessoaFisica candidato, Vaga vaga, List<PessoaJuridica> listaEmpresas) {

        PessoaJuridica empresaContratante = listaEmpresas.find{it.uid == vaga.empresaUid}

        int matchIndexEmpresa = empresaContratante.matches.findIndexOf {it.candidatoUid == candidato.uid && vaga.uid == it.vagaUid}

        if(matchIndexEmpresa != -1){
            empresaContratante.matches[matchIndexEmpresa].candidatoCurtiu = true
            int matchIndexCandidato = candidato.matches.findIndexOf {empresaContratante.uid == it.empresaUid && vaga.uid == it.vagaUid}
            candidato.matches[matchIndexCandidato].candidatoCurtiu = true
            
            return
        }
        Match match = new Match()

        match.matchUid = getAllMatches(listaEmpresas).toList().size() + 1
        match.vagaUid = vaga.uid
        match.candidatoCurtiu = true
        match.candidatoUid = candidato.uid
        match.empresaUid = empresaContratante.uid

        println(empresaContratante)
        println(candidato)


        empresaContratante.matches.add(match)
        candidato.matches.add(match)
    }

    static void curtidaEmpresa(PessoaFisica candidatoCurtido, Vaga vaga, List<PessoaJuridica> listaEmpresas) {


        PessoaJuridica empresaContratante = listaEmpresas.find{it.uid == vaga.empresaUid}
        int matchIndexCandidato = candidatoCurtido.matches.findIndexOf {it.empresaUid == vaga.empresaUid && vaga.uid == it.vagaUid}
        int matchIndexEmpresa = empresaContratante.matches.findIndexOf {it.candidatoUid == candidatoCurtido.uid && vaga.uid == it.vagaUid}

        if(matchIndexCandidato != -1){
            candidatoCurtido.matches[matchIndexCandidato].empresaCurtiu = true
            empresaContratante.matches[matchIndexEmpresa].empresaCurtiu = true
            return
        }

        Match match = new Match()

        match.matchUid = getAllMatches(listaEmpresas).toList().size() + 1
        match.empresaCurtiu = true
        match.candidatoUid = candidatoCurtido.uid
        match.empresaUid = vaga.empresaUid
        match.vagaUid = vaga.uid

        empresaContratante.matches.add(match)
        candidatoCurtido.matches.add(match)
    }

    static void fazerMatch(List<PessoaJuridica> listaEmpresas, List<PessoaFisica> listaCandidatos){

        int candidatoUid = Integer.parseInt(PrintAndGetService.printAndGet("Digite a uid do candidato a dar match:\n"))
        int empresaUid = Integer.parseInt(PrintAndGetService.printAndGet("Digite a uid da empresa a dar match:\n"))
        int vagaUid = Integer.parseInt(PrintAndGetService.printAndGet("Digite a uid da vaga a dar match:\n"))

        PessoaFisica candidato = listaCandidatos.find{it.uid == candidatoUid}
        PessoaJuridica empresaContratante = listaEmpresas.find{it.uid == empresaUid}
        Vaga vaga = empresaContratante.vagas.find{
            if(it != null) it.uid == vagaUid
        }

        if(candidato != null && empresaContratante != null && vaga != null) {
            curtidaCandidato(candidato, vaga, listaEmpresas)
            curtidaEmpresa(candidato, vaga, listaEmpresas)
        }
        else println("Empresa, candidato ou vaga nao existentes!")

    }

    static void listarMatches(List<PessoaJuridica> listaEmpresas){

        listaEmpresas.forEach{
            if(it.matches) it.matches.forEach{
                println(it.toString())
            }
        }
    }

    static List<Match> getAllMatches(List<PessoaJuridica> listaEmpresas){

        List<Match> listaMatches = []

        println(listaEmpresas.forEach{if(it.matches) it.matches.forEach{
            listaMatches.add(it)
        }})
        return listaMatches
    }
}
