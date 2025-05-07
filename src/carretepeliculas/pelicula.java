package carretepeliculas;
public class pelicula {
private String idPelicula;
private String titulo;
private String director;
private String fechade_Estreno;
private String sinopsis;
private String nombreGenero;

public pelicula(String idPelicula, String titulo, String director, String fechade_Estreno, String sinopsis, String nombreGenero) {
  this.idPelicula = idPelicula;
  this.titulo = titulo;
  this.director = director;
  this.fechade_Estreno = fechade_Estreno;
  this.sinopsis = sinopsis;
  this.nombreGenero = nombreGenero; }

    public String getIdPelicula() {
    return idPelicula; }

    public String getTitulo() {
    return titulo; }

    public String getDirector() {
    return director;}

    public String getfechade_Estreno() {
    return fechade_Estreno; }

    public String getSinopsis() {
    return sinopsis; }

    public String getNombreGenero() {
    return nombreGenero; }
    
    @Override
    public String toString(){return "ID: "+idPelicula+", Título: '"+titulo+'\''+", Director: '"+director+'\''+", Año: "+fechade_Estreno+", Género: '"+nombreGenero+'\''+", Sinopsis: '"+sinopsis+'\'';}
}