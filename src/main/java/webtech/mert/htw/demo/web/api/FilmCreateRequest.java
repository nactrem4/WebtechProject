package webtech.mert.htw.demo.web.api;

public class FilmCreateRequest {
    private String filmName;
    private String filmBeschreibung;

    public FilmCreateRequest( String filmname, String filmBeschreibung) {
        this.filmBeschreibung = filmBeschreibung;
        this.filmName = filmname;
    }

    public FilmCreateRequest() {}

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
