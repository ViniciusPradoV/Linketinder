package modules.pessoa.services

import modules.pessoa.models.PessoaFisica
import modules.pessoa.models.PessoaJuridica
import modules.vaga.mocks.MockVagaService
import modules.vaga.services.IVagaService
import org.junit.Ignore
import org.junit.Test
import org.junit.Assert

class PessoaServiceTest {

    @Test
    void cadastrarCandidato() {
        PessoaService pessoaService = new PessoaService(new MockVagaService())

        def pessoaTeste = pessoaService.cadastrarCandidato(
                1,
                1,
                "Joao",
                "joao@joao.com",
                "GO",
                "11111-111",
                "Desenvolvo software",
                "11111111",
                "Python,C#,Groovy")

        def objetoComparacao = new PessoaFisica(
                1,
                1,
                "Joao",
                "joao@joao.com",
                "GO",
                "11111-111",
                "Desenvolvo software",
                "11111111",
                "Python,C#,Groovy".split(',').toList(),
                [])

        Assert.assertEquals(objetoComparacao.toString(), pessoaTeste.toString())
    }

    @Test
    void cadastrarEmpresa() {

        PessoaService pessoaService = new PessoaService(new MockVagaService())

        def empresaTeste = pessoaService.cadastrarEmpresa(
                1,
                "JoaoSoft",
                "joaosoft@joaosoft.com",
                "GO",
                "11111-111",
                "Desenvolvemos software",
                "11111111")

        def objetoComparacao = new PessoaJuridica(
                1,
                "JoaoSoft",
                "joaosoft@joaosoft.com",
                "GO",
                "11111-111",
                "Desenvolvemos software",
                "11111111",
        [],
        [])

        Assert.assertEquals(objetoComparacao.toString(), empresaTeste.toString())
    }
}