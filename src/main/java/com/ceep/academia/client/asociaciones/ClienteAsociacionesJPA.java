package com.ceep.academia.client.asociaciones;

import com.ceep.academia.domain.Persona;
import com.ceep.academia.domain.Usuario;
import java.util.List;
import javax.persistence.*;
import org.apache.logging.log4j.*;

/**
 *
 * @author SaMa
 */
public class ClienteAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        // Cerramos la conexión
        em.close();
        
        // Imprimos los objetos persona
        for(Persona persona: personas){
            log.debug("Persona: " + persona);            
        
            // Ahora recuperamos los usuarios de cada persona
            for(Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario: " + usuario);
            }
        
        }
        
        
        
    }
}
