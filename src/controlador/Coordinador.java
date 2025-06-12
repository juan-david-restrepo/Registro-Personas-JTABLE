package controlador;

import conexion.Conexion;
import dao.PersonaDao;
import ventanas.VentanaPrincipal;
import vo.PersonaVo;

import java.util.ArrayList;

public class Coordinador {

    private VentanaPrincipal ventanaPrincipal;
    private Conexion miConexion;
    private PersonaDao miPersonaDao;
    private PersonaVo miPersonaVo;

    public void setMiConexion(Conexion miConexion) {
        this.miConexion = miConexion;
    }

    public void setMiPersonaDao(PersonaDao miPersonaDao) {
        this.miPersonaDao = miPersonaDao;
    }

    public void setMiPersonaVo(PersonaVo miPersonaVo) {
        this.miPersonaVo = miPersonaVo;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public ArrayList<PersonaVo> consultarListaPersonas() {
        return miPersonaDao.consultarListaPersonas();
    }

    public void cargarRegistros() {
        ventanaPrincipal.cargarRegistros();
    }

    public String registrarPersona(PersonaVo persona) {
        return miPersonaDao.registrarUsuario(persona);
    }
}

