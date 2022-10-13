package com.ceep.academia.data;

import com.ceep.academia.domain.Persona;
import java.util.List;

/**
 *
 * @author SaMa
 */
public interface PersonaDao {
    
    public List<Persona> findAllPersonas();
    
    public Persona findPersonaByID(Persona persona);
    
    public Persona findPersonaByEmail(Persona persona);
    
    public void insertPersona(Persona persona);

    public void updatePersona(Persona persona);
    
    public void deletePersona(Persona persona);        
    
}
