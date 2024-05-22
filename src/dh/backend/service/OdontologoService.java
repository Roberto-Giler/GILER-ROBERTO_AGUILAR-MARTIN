package dh.backend.service;

import dh.backend.dao.IDao;
import dh.backend.model.Odontologo;

import java.util.List;

public class OdontologoService {
    private IDao odontologoIDao;

    public OdontologoService(IDao odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public Odontologo regitrar(Odontologo odontologo){
        return odontologoIDao.registrar(odontologo);
    }
    public List<Odontologo> listarTodos(){
        return odontologoIDao.listarTodos();
    }

}
