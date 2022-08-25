package modules.pessoa.services

import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.vaga.services.VagaService
import services.PrintAndGetService

class PessoaService {

     static List<PessoaJuridica> getEmpresas(){

        List<PessoaJuridica> listaEmpresas = [
                new PessoaJuridica(1,1,"FromSoftware", "fkaokdfo@email.com", "SP", "11111-111", "Fazemos software", "1111111111",[]),
                new PessoaJuridica(2,2,"BSoftware", "fkaokdfo@email.com", "GO", "11111-111", "Fazemos software", "1111111111",[]),
                new PessoaJuridica(3,3,"CSoftware", "fkaokdfo@email.com", "SC", "11111-111", "Fazemos software", "1111111111",[]),
                new PessoaJuridica(4,4,"DSoftware", "fkaokdfo@email.com", "MG", "11111-111", "Fazemos software", "1111111111",[]),
                new PessoaJuridica(5,5,"FSoftware", "fkaokdfo@email.com", "PB", "11111-111", "Fazemos software", "11111111SS11",[]),
        ]

         listaEmpresas.forEach{it.vagas = VagaService.getVagas(it.uid)}


         return listaEmpresas

    }

    static List<PessoaFisica> getCandidatos(){

        List<PessoaFisica> listaCandidatos = [
                new PessoaFisica(1, 1, "Beltrano", "fkaokdfo@email.com", "SP", "11111-111", "Desenvolvo software", "1111111111", ["Python", "Java"], []),
                new PessoaFisica(2, 2, "Fulano", "fkaokdfo@email.com", "SP", "11111-111", "Desenvolvo software", "1111111111", ["C++", "Java"], []),
                new PessoaFisica(3, 3, "Ciclano", "fkaokdfo@email.com", "SP", "11111-111", "Desenvolvo software", "1111111111", ["C#", "Groovy"], []),
                new PessoaFisica(4, 4, "Maria", "fkaokdfo@email.com", "SP", "11111-111", "Desenvolvo software", "1111111111", ["Kotlin", "Java"], []),
                new PessoaFisica(5, 5, "Joaquina", "fkaokdfo@email.com", "SP", "11111-111", "Desenvolvo software", "1111111111", ["C++", "C"], []),
        ]

        return listaCandidatos

    }

    static PessoaFisica cadastrarCandidato(List<PessoaFisica> listaCandidatos) {

        int uid = listaCandidatos.size() + 1

        int idade = Integer.parseInt(PrintAndGetService.printAndGet("Digite sua idade:\n"))
        String nome = PrintAndGetService.printAndGet("Digite seu nome completo:\n")
        String email = PrintAndGetService.printAndGet("Digite seu email de contato:\n")
        String estado = PrintAndGetService.printAndGet("Digite estado de residencia:\n")
        String cep = PrintAndGetService.printAndGet("Digite o seu CEP atual:\n")
        String descricao = PrintAndGetService.printAndGet("Digite uma descricao para o seu perfil:z\n")
        String cpf = PrintAndGetService.printAndGet("Digite seu CPF: ")
        String competencias = PrintAndGetService.printAndGet("Digite suas competencias separadas por virgula: \n")

        return new PessoaFisica(uid, idade, nome, email, estado, cep, descricao, cpf, competencias.split(',').toList(), [])

    }

    static PessoaJuridica cadastrarEmpresa(List<PessoaJuridica> listaEmpresas) {

        int uid = listaEmpresas.size() + 1

        String nome = PrintAndGetService.printAndGet("Digite o nome da empresa:\n")
        String email = PrintAndGetService.printAndGet("Digite o email de contato:\n")
        String estado = PrintAndGetService.printAndGet("Digite estado do escritorio da empresa:\n")
        String cep = PrintAndGetService.printAndGet("Digite o seu CEP atual:\n")
        String descricao = PrintAndGetService.printAndGet("Digite uma descricao para o perfil da empresa:\n")
        String cnpj = PrintAndGetService.printAndGet("Digite seu CNPJ: ")

        return new PessoaJuridica(uid, nome, email, estado, cep, descricao, cnpj, VagaService.getVagas(uid), [])
    }

    static def void listarCandidatos(List<PessoaFisica> listaCandidatos) {

        listaCandidatos.forEach{println(it.toString())}
    }

    static def void listarEmpresas(List<PessoaJuridica> listaEmpresas) {

        listaEmpresas.forEach{println(it.toString())}
    }
}
