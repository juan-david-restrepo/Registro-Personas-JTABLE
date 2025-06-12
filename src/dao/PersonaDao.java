package dao;

import conexion.Conexion;
import controlador.Coordinador;
import vo.PersonaVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonaDao {

    private Coordinador coordinador;

    public String registrarUsuario(PersonaVo miPersonaVo) {
        String resultado = "";
        Conexion conexion = Conexion.getInstance();
        Connection connection = conexion.getConnection();
        PreparedStatement preStatement = null;

        String consulta = "INSERT INTO persona (documento, nombre, direccion, telefono) VALUES(?, ?, ?, ?)";

        try {
            preStatement = connection.prepareStatement(consulta);
            preStatement.setString(1, miPersonaVo.getDocumento());
            preStatement.setString(2, miPersonaVo.getNombre());
            preStatement.setString(3, miPersonaVo.getDireccion());
            preStatement.setString(4, miPersonaVo.getTelefono());
            preStatement.execute();

            resultado = "ok";
        } catch (SQLException e) {
            System.err.println("No se pudo registrar el dato: " + e.getMessage());
            resultado = "No se pudo registrar el dato: " + e.getMessage();
        }

        return resultado;
    }

    public ArrayList<PersonaVo> consultarListaPersonas() {
        ArrayList<PersonaVo> listaPersona = new ArrayList<>();
        Conexion miConexion = Conexion.getInstance();
        Connection connection = miConexion.getConnection();
        PreparedStatement statement;
        ResultSet result;

        String consulta = "SELECT * FROM persona";

        try {
            statement = connection.prepareStatement(consulta);
            result = statement.executeQuery();

            while (result.next()) {
                PersonaVo miPersona = new PersonaVo();
                miPersona.setDocumento(result.getString("documento"));
                miPersona.setNombre(result.getString("nombre"));
                miPersona.setDireccion(result.getString("direccion"));
                miPersona.setTelefono(result.getString("telefono"));
                listaPersona.add(miPersona);
            }
        } catch (SQLException e) {
            System.err.println("Error en la consulta de usuarios: " + e.getMessage());
        }

        return listaPersona;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
}

