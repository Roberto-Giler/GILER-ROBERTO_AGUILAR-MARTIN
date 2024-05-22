package dh.backend.test;

import dh.backend.dao.impl.OdontologoIDaoH2;
import dh.backend.dao.impl.OdontologosIDaoMemoria;
import dh.backend.model.Odontologo;
import dh.backend.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTestEnMemoria {

    private static Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);
    private static OdontologoService odontologoService = new OdontologoService(new OdontologosIDaoMemoria());

    @BeforeAll
    static void crearTabla(){
    odontologoService.regitrar(new Odontologo(1,1,"FEDERICO", "SANCHEZ"));
        odontologoService.regitrar(new Odontologo(2,2,"HOMERO", "SIMPSON"));


    }


    @Test
    @DisplayName("Testear que un odontologo fue guardado en memoria")

    void TestOdontologoGuardar(){
        Odontologo odontologo= new Odontologo(21,"Fulanito","Jaurez");

        Odontologo odontologoNuevo=odontologoService.regitrar(odontologo);

        assertNotNull(odontologoNuevo.getId());
    }
    @Test
    @DisplayName("Testear que Listar a todos los odontologos en memoria")

    void TestOdontologoTestear(){

        Odontologo odontologo= new Odontologo(21,"Fulanito","Jaurez");
        odontologoService.regitrar(odontologo);
        List<Odontologo> odontologos=odontologoService.listarTodos();

        assertEquals(3,odontologos.size());

    }


}