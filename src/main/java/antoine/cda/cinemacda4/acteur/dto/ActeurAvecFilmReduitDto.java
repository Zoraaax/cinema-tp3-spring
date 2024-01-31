package antoine.cda.cinemacda4.acteur.dto;

import antoine.cda.cinemacda4.film.dto.FilmReduitAvecRealisateurDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurAvecFilmReduitDto {
    private String nom;
    private String prenom;
    private List<FilmReduitAvecRealisateurDto> films;
}
