package service;


import entity.Admin;
import entity.Contatti;
import entity.HR;

import java.util.List;

public interface AdminService {
    List<HR> getAllHR();

    List<Contatti> getAllContatti();

    void salvaAdmin(Admin nuovoAdmin);

    Admin getAdminById(Long id);

    void eliminaAdmin(Long id);
}
