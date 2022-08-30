package Application

import modules.match.services.MatchService
import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.pessoa.services.PessoaService
import modules.vaga.services.VagaService
import services.PrintAndGetService

class Application {

    static List<PessoaJuridica> listaEmpresas = PessoaService.getEmpresas()
    static List<PessoaFisica> listaCandidatos = PessoaService.getCandidatos()


    static void appStart() {

        boolean continueLoop = true;

        while (continueLoop) {

            String userSelection = PrintAndGetService.printAndGet("Selecione uma opcao:\n" +
                    "1 - Cadastrar como candidato\n" +
                    "2 - Cadastrar como empresa\n" +
                    "3 - Listar candidatos\n" +
                    "4 - Listar empresas\n" +
                    "5 - Listar matches\n" +
                    "6 - Fazer match\n" +
                    "0 - Sair")

            switch (userSelection) {
                case "1"-> {
                    def(uid, idade, nome, email, estado, cep, descricao, cpf, competencias) =
                    PessoaService.recolheDadosCandidato(listaCandidatos)
                    listaCandidatos.add(PessoaService.cadastrarCandidato(uid, idade, nome, email, estado, cep, descricao, cpf, competencias))
                    continueLoop = true;
                }
                case "2" -> {
                    def(uid, nome, email, estado, cep, descricao, cnpj) =
                    PessoaService.recolheDadosEmpresa(listaEmpresas)
                    listaEmpresas.add(PessoaService.cadastrarEmpresa(uid, nome, email, estado, cep, descricao, cnpj))
                    continueLoop = true;
                }
                case "3" -> {
                    PessoaService.listarCandidatos(listaCandidatos)
                    continueLoop = true;
            }
                case "4" -> {
                    PessoaService.listarEmpresas(listaEmpresas)
                    continueLoop = true;
                }
                case "5" -> {
                    MatchService.listarMatches(listaEmpresas)
                    continueLoop = true;
                }
                case "6" -> {
                    MatchService.fazerMatch(listaEmpresas, listaCandidatos)
                    continueLoop = true;
                }
                case "7" -> {
                    MatchService.getAllMatches(listaEmpresas)
                    continueLoop = true;
                }
                case "0" -> continueLoop = false;
                default -> {
                    println("Nenhuma opcao valida foi selecionada")
                    continueLoop = true
                };
            }
        }
    }
}
