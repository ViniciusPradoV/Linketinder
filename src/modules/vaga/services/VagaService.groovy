package modules.vaga.services

import modules.vaga.models.Vaga

class VagaService {

     static List<Vaga> getVagas(){

        List<Vaga> listaVagas = [
                new Vaga("Dev","Desenvolvedor", "Python", "Sao Paulo", "SP"),
                new Vaga("Dev","Desenvolvedor", "Java", "Belo Horizonte", "MG"),
                new Vaga("Dev","Desenvolvedor", "Groovy", "Goias", "GO")
        ]
    }

}
