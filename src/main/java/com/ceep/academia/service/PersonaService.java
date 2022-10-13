
package com.ceep.academia.service;

import com.ceep.academia.domain.Persona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SaMa
 */
@Local
public interface PersonaService {
    
    public List<Persona> listarPersonas();
    
    public Persona encontrarPersonaPorID(Persona persona);
    
    public Persona econtrarPersonaPorEmail(Persona persona);
    
    public void registrarPersona(Persona persona);
    
    public void modificarPersona(Persona persona);
    
    public void eliminarPersona(Persona persona);
}
