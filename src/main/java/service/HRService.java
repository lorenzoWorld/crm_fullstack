package service;


import entity.Contatti;
import entity.HR;

import java.util.List;

public interface HRService {
    HR getHRById(Long id);

    boolean getContattiByHR(HR loggedHR);

    List<Contatti> getContattiByHRWithPagination(HR loggedHR, int i, int i1);

    void salvaHR(HR nuovoHR);

    void eliminaHR(Long id);
}


