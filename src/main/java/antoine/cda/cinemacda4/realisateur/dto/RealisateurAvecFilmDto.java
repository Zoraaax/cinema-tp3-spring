package antoine.cda.cinemacda4.realisateur.dto;

import antoine.cda.cinemacda4.film.Film;
import antoine.cda.cinemacda4.film.dto.FilmReduitPourRealisateurDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RealisateurAvecFilmDto {
    private String nom;
    private String prenom;
    private List<FilmReduitPourRealisateurDto> films = new ArrayList<>();
}
