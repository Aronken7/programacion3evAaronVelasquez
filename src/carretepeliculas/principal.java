package carretepeliculas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

public class principal {
private static final String URL = "jdbc:mysql://localhost:3307/cine_aaronvelasquez";
private static final String USUARIO = "root";
private static final String CONTRASENA = " ";

private static Scanner scanner = new Scanner(System.in);
public static void main(String[] args) {
int opcion;
do {
mostrarMenu();
while (!scanner.hasNextInt()) {
System.out.println("Introduce solo numeros");
scanner.next();
System.out.print("Elige una de las opciones: "); }
opcion = scanner.nextInt();
scanner.nextLine();

switch (opcion) {
case 1: verPeliculas();
break;
case 2: System.out.println("hasta luego programador");
break;
default: System.out.println("Esta opcion no vale no funciona por ahora, intentalo de nuevo"); }
System.out.println(); } 
while (opcion != 2);
scanner.close(); }

private static void mostrarMenu() {
System.out.println("Menu del cine");
System.out.println("1 | Ver peliculas");
System.out.println("2 | Salir");
System.out.print("Elige una de las opciones: "); }

private static void verPeliculas() {
System.out.println("Catalogo de peliculas");
List<pelicula> peliculas = new ArrayList<>();
String sql = "SELECT p.id_pelicula, p.titulo, p.director, p.fechade_Estreno, p.sinopsis, g.nombre_genero " + "FROM Peliculas p " + "JOIN Generos g ON p.id_genero = g.id_genero";

try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
PreparedStatement ps = conexion.prepareStatement(sql);
ResultSet rs = ps.executeQuery()) {

while (rs.next()) {
String idPelicula = rs.getString("id_pelicula");
String titulo = rs.getString("titulo");
String director = rs.getString("director");
String fechaDeEstreno = rs.getString("fechade_Estreno");
String sinopsis = rs.getString("sinopsis");
String nombreGenero = rs.getString("nombre_genero");
peliculas.add(new pelicula(idPelicula, titulo, director, fechaDeEstreno, sinopsis, nombreGenero)); }
} catch (SQLException e) {
  System.err.println("Error al buscar las peliculas: " + e.getMessage()); }

   if (peliculas.isEmpty()) {
   System.out.println("Hoy no hay nada en la cartelera"); } 
   else {
   System.out.printf("%-10s | %-40s | %-25s | %-15s | %-15s | %s\n", "ID", "TITULO", "DIRECTOR", "FECHA DE ESTRENO", "GENERO", "SINOPSIS");
   System.out.println(String.join("", Collections.nCopies(150, "-")));

   for (pelicula pelicula : peliculas) {
   System.out.printf("%-10s | %-40.40s | %-25.25s | %-15s | %-15.15s | %s\n",
     pelicula.getIdPelicula(),
     pelicula.getTitulo(),
     pelicula.getDirector() != null ? pelicula.getDirector() : "N/A",
     pelicula.getfechade_Estreno() != null ? pelicula.getfechade_Estreno() : "N/A",
     pelicula.getNombreGenero(),
     pelicula.getSinopsis() != null ? pelicula.getSinopsis() : "N/A"); }
   System.out.println(String.join("", Collections.nCopies(150, "-")));
}
}
}