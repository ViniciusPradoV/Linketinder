package modules.vaga.mocks

import modules.vaga.models.Vaga
import modules.vaga.services.IVagaService

class MockVagaService implements IVagaService{


    @Override
    List<Vaga> getVagas(int empresaUid) {
        return []
    }
}
