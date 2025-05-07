package carretepeliculas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
private static final String URL = "jdbc:mysql://localhost:3307/cine_aaronvelasquez";
private static final String USUARIO = "root";
private static final String CONTRASENA = "";

public static Connection conectar() {
  Connection conexion = null;
  try {
  conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);} 
  catch (SQLException e) {
  System.err.println("Error al conectar a la base de datos: " + e.getMessage());
  e.printStackTrace(); }
  
  return conexion; }
  public static void desconectar(Connection conexion) {
  if (conexion != null) {
  try {
  conexion.close();}
  catch (SQLException e) {
  System.err.println("Error al cerrar la conexión: " + e.getMessage());
  e.printStackTrace();
}
}
}
}