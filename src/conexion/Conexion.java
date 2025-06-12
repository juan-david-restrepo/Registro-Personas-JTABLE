package conexion;

import controlador.Coordinador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instancia; // Singleton
    private Coordinador coordinador;
    private final String nombreBd = "EjemploJava";
    private final String usuario = "root";
    private final String password = "";
    private final String url = "jdbc:mysql://localhost:3306/" + nombreBd;
    private Connection conn = null;


    private Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usuario, password);

            if (conn == null) {
                System.err.println("Conexión fallida a la BD " + nombreBd);
            }else if{
                System.out.println("Conexión exitosa a " + nombreBd);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Clase no encontrada: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error de conexión SQL: " + e.getMessage());
        }
    }

    public static Conexion getInstance() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                instancia = null; // Reinicia la instancia si se cierra la conexion (creo)
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}

