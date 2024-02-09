package service;

import entity.Contatti;
import entity.HR;
import java.util.List;


public interface ContattiService {
    List<Contatti> getContattiByHR(HR hr);

    void salvaContatto(Contatti contatto);

    Contatti getContattiById(Long contattiId);

    void eliminaContatto(Long id);
}
