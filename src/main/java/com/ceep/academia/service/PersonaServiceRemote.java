package com.ceep.academia.service;

import com.ceep.academia.domain.Persona;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author SaMa
 */
@Remote
public interface PersonaServiceRemote {

    // Ahora añadimos los métodos para poder trabajar con Persona
    // y poder desde Acceso a datos acceder a la información de esta entidad
    
    public List<Persona> listarPersonas();
    
    public Persona encontrarPersonaPorID(Persona persona);
    
    public Persona econtrarPersonaPorEmail(Persona persona);
    
    public void registrarPersona(Persona persona);
    
    public void modificarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
    
}
