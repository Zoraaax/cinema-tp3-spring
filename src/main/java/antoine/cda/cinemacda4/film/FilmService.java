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

    /**
     * Trouve tous les films
     * @return tous les films
     */
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    /**
     * Ajoute un film
     * @param film
     * @return le film ajouté
     */
    public Film save(Film film) {
        return filmRepository.save(film);
    }

    /**
     * Trouve un film par son id
     * @param id
     * @return le film avec l'id
     */
    public Film findById(Integer id) {
        return filmRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Film Non trouvé"
                        )
                );
    }

    /**
     * Supprime un film
     * @param id
     */
    public void deleteById(Integer id) {
        Film film = this.findById(id);
        filmRepository.delete(film);
    }

    /**
     * Met à jour un film
     * @param film
     * @return le film mis à jour
     */
    public Film update(Film film) {
        return filmRepository.save(film);
    }

    /**
     * Trouve un film par son titre
     * @param titre
     * @return le film avec le titre
     */
    public Film findByTitre(String titre) {
        return filmRepository.findByTitre(titre)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le titre : " + titre
                        )
                );
    }

    /**
     * Trouve les acteurs d'un film
     * @param id
     * @return les acteurs du film
     */
    public List<Acteur> findActeurByFilm(Integer id) {
        Film film = this.findById(id);

        return film.getActeurs();
    }

    /**
     * Trouve le realisateur d'un film
     * @param id
     * @return le realisateur du film
     */
    public Realisateur findRealisateurByFilm(Integer id) {
        Film film = this.findById(id);

        return film.getRealisateur();
    }

    /**
     * Trouve un film par son realisateur
     * @param id
     * @return le film avec le realisateur
     */
    public Film findFilmByRealisateurId(Integer id) {
        return filmRepository.findByRealisateurId(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Aucun film avec le realisateur : " + id
                        )
                );
    }

    /**
     * Ajoute un acteur à un film
     * @param idFilm
     * @param idActeur
     * @return le film avec l'acteur ajouté
     */
    public Film addActeurToFilm(Integer idFilm, Integer idActeur) {
        Film film = this.findById(idFilm);
        Acteur acteur = acteurService.findActeurById(idActeur);

        film.getActeurs().add(acteur);

        return filmRepository.save(film);
    }
}
