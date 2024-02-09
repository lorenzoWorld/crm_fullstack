package Controller;
import entity.Contatti;
import entity.HR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ContattiService;
import java.util.*;

@RestController
@RequestMapping("/contatti")
public class ContattiController {

    @Autowired
    private ContattiService contattiService;

    public ContattiController(ContattiService contattiService) {
        this.contattiService = contattiService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contatti> getContattiById(@PathVariable Long id) {
        Contatti contatto = contattiService.getContattiById(id);
        return ResponseEntity.ok(contatto);
    }

    @GetMapping("/hr/{hrId}")
    public ResponseEntity<List<Contatti>> getContattiByHR(@PathVariable Long hrId) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/cambia-stato/{contattiId}")
    public ResponseEntity<Void> cambiaStatoContatto(@PathVariable Long contattiId, @RequestParam String nuovoStato) {
        Contatti contatto = contattiService.getContattiById(contattiId);
        contatto.setStato(nuovoStato);
        contattiService.salvaContatto(contatto);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/aggiungi")
    public ResponseEntity<Void> aggiungiContatto(@RequestBody Contatti nuovoContatto) {
        contattiService.salvaContatto(nuovoContatto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Void> modificaContatto(@PathVariable Long id, @RequestBody Contatti contattoModificato) {
        Contatti contattoDaModificare = contattiService.getContattiById(id);

        contattiService.salvaContatto(contattoDaModificare);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<Void> eliminaContatto(@PathVariable Long id) {
        contattiService.eliminaContatto(id);
        return ResponseEntity.ok().build();
    }
}
