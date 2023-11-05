package webtech.mert.htw.demo.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import webtech.mert.htw.demo.service.FilmService;
import webtech.mert.htw.demo.web.api.Film;
import webtech.mert.htw.demo.web.api.FilmCreateRequest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class FilmRestController {

    private final FilmService filmService;

    public FilmRestController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "/api/v1/films")
    public ResponseEntity<List<Film>> fetchFilm() {
        return ResponseEntity.ok(filmService.findAll());
    }

    @GetMapping(path = "/api/v1/films/{id}")
    public ResponseEntity<Film> fetchFilmById(@PathVariable Long id) {
        var film = filmService.findById(id);
        return film != null? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/films/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody FilmCreateRequest request) {
        var film = filmService.update(id, request);
        return film != null? ResponseEntity.ok(film) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/films")
    public ResponseEntity<Void> createFilm(@RequestBody FilmCreateRequest request) throws URISyntaxException {
        var film = filmService.createFilm(request);
        URI uri = new URI("/api/v1/films/" + film.getId());
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(path = "/api/v1/films/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        boolean successful = filmService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

