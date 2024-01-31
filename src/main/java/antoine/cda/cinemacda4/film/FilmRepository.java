package antoine.cda.cinemacda4.film;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface FilmRepository extends  JpaRepository<Film, Integer>{
    Optional<Film> findByTitre(String titre);

    Optional<Film> findByDateSortieAfter(LocalDate date);
}
