package antoine.cda.cinemacda4.film;

import antoine.cda.cinemacda4.acteur.Acteur;
import antoine.cda.cinemacda4.acteur.ActeurService;
import antoine.cda.cinemacda4.realisateur.Realisateur;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class FilmService {
    private final FilmRepository filmRepository;
    private final ActeurService acteurService;

    public FilmService(FilmRepository filmRepository, ActeurService acteurService) {
        this.filmRepository = (FilmRepository) filmRepository;
        this.acteurService = acteurService;
    }

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Film Non trouvé"
                        )
                );
    }

    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }

    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le titre : " + titre
                        )
                );
    }

    public List<Acteur> findActeurByFilm(Integer id) {
        Film film = this.findById(id);

        return film.getActeurs();
    }

    public Realisateur findRealisateurByFilm(Integer id) {
        Film film = this.findById(id);

        return film.getRealisateur();
    }

    public Film findFilmByRealisateurId(Integer id) {
        return filmRepository.findByRealisateurId(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le realisateur : " + id
                        )
                );
    }

    public Film addActeurToFilm(Integer idFilm, Integer idActeur) {
        Film film = this.findById(idFilm);
        Acteur acteur = acteurService.findActeurById(idActeur);

        film.getActeurs().add(acteur);

        return filmRepository.save(film);
    }
}
