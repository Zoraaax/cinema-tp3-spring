package antoine.cda.cinemacda4.realisateur;

import antoine.cda.cinemacda4.film.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class RealisateurService {
    private final RealisateurRepository realisateurRepository;
    private final FilmService filmService;

    public RealisateurService(RealisateurRepository realisateurRepository, FilmService filmService) {
        this.realisateurRepository = realisateurRepository;
        this.filmService = filmService;
    }

    public List<Realisateur> findAll() {
        return realisateurRepository.findAll();
    }

    public Realisateur saveRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public Realisateur findRealisateurById(Integer id) {
        return realisateurRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Realisateur Non trouvé"
                        )
                );
    }

    public void deleteRealisateurById(Integer id) {
        Realisateur realisateur = this.findRealisateurById(id);
        realisateurRepository.delete(realisateur);
    }

    public Realisateur updateRealisateur(Realisateur realisateur) {
        return realisateurRepository.save(realisateur);
    }

    public Realisateur findRealisateurByNom(String nom) {
        return realisateurRepository.findByNom(nom)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun réalisateur avec le nom : " + nom
                        )
                );
    }

    public List<Realisateur> findAllRealisateur() {
        return realisateurRepository.findAll();
    }
}