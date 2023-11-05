package webtech.mert.htw.demo.persistence;

import jakarta.persistence.*;
import webtech.mert.htw.demo.web.api.Film;

@Entity(name = "films")
public class FilmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "film_Name", nullable = false)
    private String filmName;

    @Column(name = "film_Beschreibung", nullable = false)
    private String filmBeschreibung;

    public FilmEntity(String filmName, String filmBeschreibung) {
        this.filmName = filmName;
        this.filmBeschreibung = filmBeschreibung;
    }

    protected FilmEntity(){}

    public long getId() {
        return id;
    }
    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmBeschreibung() {
        return filmBeschreibung;
    }

    public void setFilmBeschreibung(String filmBeschreibung) {
        this.filmBeschreibung = filmBeschreibung;
    }
}
