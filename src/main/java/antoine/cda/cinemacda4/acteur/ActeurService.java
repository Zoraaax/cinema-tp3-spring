package antoine.cda.cinemacda4.acteur;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ActeurService {
    private final ActeurRepository acteurRepository;

    public ActeurService(ActeurRepository acteurRepository) {
        this.acteurRepository = (ActeurRepository) acteurRepository;
    }

    public List<Acteur> findAllActeur() {
        return acteurRepository.findAll();
    }

    public Acteur saveActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public void deleteActeurById(Integer id) {
        Acteur acteur = this.findActeurById(id);
        acteurRepository.delete(acteur);
    }

    Acteur findActeurById(Integer id) {
        return (Acteur) acteurRepository.findActeurById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Acteur non trouvé"
                        )
                );
    }

    public Acteur updateActeur(Acteur acteur) {
        return acteurRepository.save(acteur);
    }

    public Acteur findActeurByNom(String nom) {
        return acteurRepository.findActeurByNom(nom)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun acteur avec le nom : " + nom
                        )
                );
    }
}

