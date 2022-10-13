package com.ceep.academia.service;

import com.ceep.academia.data.PersonaDao;
import com.ceep.academia.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author SaMa
 */
@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar personaDao
    @Inject    
    private PersonaDao personaDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Persona> listarPersonas() {       
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorID(Persona persona) {
        return personaDao.findPersonaByID(persona);
    }

    @Override
    public Persona econtrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
