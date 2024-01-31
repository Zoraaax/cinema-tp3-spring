package antoine.cda.cinemacda4.film;

import antoine.cda.cinemacda4.realisateur.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.util.Optional;

public interface FilmRepository extends  JpaRepository<Film, Integer>{
    Optional<Film> findByTitre(String titre);
    Optional<Film> findByDateSortieAfter(LocalDate date);

    Optional<Film> findByRealisateurId(Integer id);
}
