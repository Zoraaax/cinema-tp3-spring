package antoine.cda.cinemacda4.realisateur;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {
    private final RealisateurService realisateurService;

    public RealisateurController(RealisateurService realisateurService) {
        this.realisateurService = realisateurService;
    }

    @GetMapping
    public List<Realisateur> findAllrealisateur() {
        return realisateurService.findAllRealisateur();
    }

    @PostMapping
    public Realisateur saveRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.saveRealisateur(realisateur);
    }

    @GetMapping("/{id}")
    public Realisateur findRealisateurById(@PathVariable Integer id) {
        return realisateurService.findRealisateurById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateurById(@PathVariable Integer id) {
        realisateurService.deleteRealisateurById(id);
    }

    @PutMapping
    public Realisateur updateRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.updateRealisateur(realisateur);
    }

    @GetMapping("/search")
    public Realisateur findRealisateurByNom(@RequestParam String nom) {
        return realisateurService.findRealisateurByNom(nom);
    }

}

