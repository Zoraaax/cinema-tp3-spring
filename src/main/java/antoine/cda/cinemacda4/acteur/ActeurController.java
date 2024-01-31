package antoine.cda.cinemacda4.acteur;

import antoine.cda.cinemacda4.acteur.dto.ActeurReduitDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acteurs")
public class ActeurController {
    private final ActeurService acteurService;
    private final ObjectMapper objectMapper;

    public ActeurController(ActeurService acteurService, ObjectMapper objectMapper) {
        this.acteurService = acteurService;
        this.objectMapper = objectMapper;
    }

    @GetMapping
    public List<ActeurReduitDto> findAllActeur() {
        return acteurService.findAllActeur().stream().map(
                acteur -> objectMapper.convertValue(acteur, ActeurReduitDto.class)
        ).toList();
    }

    @PostMapping
    public Acteur saveActeur(@RequestBody Acteur acteur) {
        return acteurService.saveActeur(acteur);
    }

    @GetMapping("/{id}")

    public Acteur findActeurById(@PathVariable Integer id) {
        return acteurService.findActeurById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteActeurById(@PathVariable Integer id) {
        acteurService.deleteActeurById(id);
    }

    @PutMapping
    public Acteur updateActeur(@RequestBody Acteur acteur) {
        return acteurService.updateActeur(acteur);
    }

    @GetMapping("/search") 
    public Acteur findActeurByNom(@RequestParam String nom) {
        return acteurService.findActeurByNom(nom);
    }

}

