package webtech.mert.htw.demo.service;

import org.springframework.stereotype.Service;
import webtech.mert.htw.demo.persistence.FilmEntity;
import webtech.mert.htw.demo.persistence.FilmRepository;
import webtech.mert.htw.demo.web.api.Film;
import webtech.mert.htw.demo.web.api.FilmCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> findAll() {
        List<FilmEntity> films = filmRepository.findAll();
        return films.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Film findById(Long id) {
        var filmEntity = filmRepository.findById(id);
        return filmEntity.map(this::transformEntity).orElse(null);
    }

    public Film update(Long id, FilmCreateRequest request) {
        var filmEntityOptional = filmRepository.findById(id);
        if (filmEntityOptional.isEmpty()) {
            return null;
        }
        var filmEntity = filmEntityOptional.get();
        filmEntity.setFilmName(request.getFilmName());
        filmEntity.setFilmBeschreibung(request.getFilmBeschreibung());
        filmEntity = filmRepository.save(filmEntity);

        return transformEntity(filmEntity);
    }

        public Film createFilm (FilmCreateRequest request){
            var filmEntity = new FilmEntity(request.getFilmName(), request.getFilmBeschreibung());
            filmRepository.save(filmEntity);
            return transformEntity(filmEntity);
        }
        private Film transformEntity (FilmEntity filmEntity){
            return new Film(
                    filmEntity.getId(),
                    filmEntity.getFilmName(),
                    filmEntity.getFilmBeschreibung());
        }
    public boolean deleteById(Long id) {
        if (!filmRepository.existsById(id)) {
            return false;
        }

        filmRepository.deleteById(id);
        return true;
    }
    }

