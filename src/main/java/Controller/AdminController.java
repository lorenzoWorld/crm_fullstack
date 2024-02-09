package Controller;
import entity.Admin;
import entity.Contatti;
import entity.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.AdminService;
import service.HRService;

import java.util.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    private HRService hrService;

    public AdminController(AdminService adminService, HRService hrService) {
        this.adminService = adminService;
        this.hrService = hrService;
    }

    @GetMapping("/hr")
    public ResponseEntity<List<HR>> getAllHR() {
        List<HR> hrList = adminService.getAllHR();
        return ResponseEntity.ok(hrList);
    }

    @GetMapping("/contatti")
    public ResponseEntity<List<Contatti>> getAllContatti() {
        List<Contatti> contattiList = adminService.getAllContatti();
        return ResponseEntity.ok(contattiList);
    }


    @PostMapping("/aggiungi-hr")
    public ResponseEntity<Void> aggiungiHR(@RequestBody HR nuovoHR) {
        HRService hrService = null;
        hrService.salvaHR(nuovoHR);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modifica-hr/{id}")
    public ResponseEntity<Void> modificaHR(@PathVariable Long id, @RequestBody HR hrModificato) {
        HR hrDaModificare = hrService.getHRById(id);

        hrService.salvaHR(hrDaModificare);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/elimina-hr/{id}")
    public ResponseEntity<Void> eliminaHR(@PathVariable Long id) {
        hrService.eliminaHR(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/aggiungi-admin")
    public ResponseEntity<Void> aggiungiAdmin(@RequestBody Admin nuovoAdmin) {
        adminService.salvaAdmin(nuovoAdmin);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modifica-admin/{id}")
    public ResponseEntity<Void> modificaAdmin(@PathVariable Long id, @RequestBody Admin adminModificato) {
        Admin adminDaModificare = adminService.getAdminById(id);

        adminService.salvaAdmin(adminDaModificare);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/elimina-admin/{id}")
    public ResponseEntity<Void> eliminaAdmin(@PathVariable Long id) {
        adminService.eliminaAdmin(id);
        return ResponseEntity.ok().build();
    }
}

