package Controller;

import entity.Contatti;
import entity.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.HRService;
import java.util.*;


@RestController
@RequestMapping("/hr")
public class HRController {

    @Autowired
    private HRService hrService;

    public HRController(HRService hrService) {
        this.hrService = hrService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HR> getHRById(@PathVariable Long id) {
        HR hr = hrService.getHRById(id);
        return ResponseEntity.ok(hr);
    }

    @GetMapping("/contatti")
    public ResponseEntity<List<Contatti>> getContatti() {
        try {
            // ottieni HR attualmente autenticato;
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/aggiungi")
    public ResponseEntity<Void> aggiungiHR(@RequestBody HR nuovoHR) {
        hrService.salvaHR(nuovoHR);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Void> modificaHR(@PathVariable Long id, @RequestBody HR hrModificato) {
        HR hrDaModificare = hrService.getHRById(id);

        hrService.salvaHR(hrDaModificare);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<Void> eliminaHR(@PathVariable Long id) {
        hrService.eliminaHR(id);
        return ResponseEntity.ok().build();
    }
}


