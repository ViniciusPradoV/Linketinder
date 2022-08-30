package modules.vaga.services


import modules.vaga.models.Vaga

class VagaService implements IVagaService {


    @Override
    List<Vaga> getVagas(int empresaUid){
        List<Vaga> listaVagas = [
                new Vaga(1,"Dev","Desenvolvedor", "Python", "Sao Paulo", "SP", empresaUid),
                new Vaga(2,"Dev","Desenvolvedor", "Java", "Belo Horizonte", "MG", empresaUid),
                new Vaga(3,"Dev","Desenvolvedor", "Groovy", "Goias", "GO", empresaUid)
        ]

         return listaVagas
    }

}
