package Application


import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.pessoa.services.PessoaService
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
                    "0 - Sair")

            switch (userSelection) {
                case "1"-> {
                    listaCandidatos.add(PessoaService.cadastrarCandidato(listaCandidatos))
                    continueLoop = true;
                }
                case "2" -> {
                    listaEmpresas.add(PessoaService.cadastrarEmpresa(listaEmpresas))
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
                case "0" -> continueLoop = false;
                default -> {
                    println("Nenhuma opcao valida foi selecionada")
                    continueLoop = true
                };
            }

        }
    }
}
