package controlador;

import conexion.Conexion;
import dao.PersonaDao;
import ventanas.VentanaPrincipal;
import vo.PersonaVo;

public class Relaciones {

    public void iniciar() {
        VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
        Coordinador miCoordinador = new Coordinador();
        PersonaDao miPersonaDAO = new PersonaDao();
        PersonaVo miPersonaVo = new PersonaVo();
        Conexion miConexion = Conexion.getInstance();


        ventanaPrincipal.setMiCoordinador(miCoordinador);
        miCoordinador.setVentanaPrincipal(ventanaPrincipal);
        miCoordinador.setMiPersonaDao(miPersonaDAO);
        miCoordinador.setMiPersonaVo(miPersonaVo);
        miCoordinador.setMiConexion(miConexion);

        miConexion.setCoordinador(miCoordinador);
        miPersonaDAO.setCoordinador(miCoordinador);
        miPersonaVo.setCoordinador(miCoordinador);

        miCoordinador.cargarRegistros();
        ventanaPrincipal.setVisible(true);
    }
}
