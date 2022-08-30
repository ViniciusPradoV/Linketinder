package modules.vaga.services

import modules.vaga.models.Vaga

interface IVagaService {

    List<Vaga> getVagas(int empresaUid)
}
