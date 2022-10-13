/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.academia.data;

import com.ceep.academia.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author SaMa
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao {
    
    // El EJB se encarga de forma automática de hacer las transacciones.
    
    // Ahora inyectamos la unidad de persistencia a través del API de JPA
    // Simplemente tenemos que usar la anotación e indicar el nombre de nuestra
    // unidad de persistencia
    @PersistenceContext(unitName="AcademiaPU")
    EntityManager em;
    
    // Con este objeto de em ya podemos interactuar con nuestra BD
    

    @Override
    public List<Persona> findAllPersonas() {
        // Creamos un NamedQuery, y el listado lo leemos con getResultList
        // Por lo que estamos escribiendo menos código
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaByID(Persona persona) {
        // Especificamos la clase que queremos buscar y luego el campo por el 
        // que queremos buscar
        return em.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        // En este caso no vamos a usar un NamedQuery, que podríamos haber 
        // agregado en la Entidad de Persona sino que vamos a incluirlo directamente.
        Query query = em.createQuery("from Persona p where p.email = :email");
        query.setParameter("email", persona.getEmail());
        // Y ahroa sólo esperamos un resultado, porque el email debe de ser único
        // sino lo hemos definido así lo modificamos en nuestra tabla como unique
        return (Persona) query.getSingleResult();
    }

    @Override
    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona){
        // Sincroniza cualquier modificamos que hayamos hecho de la persona en la BD
        em.merge(persona);
    }
    
    @Override
    public void deletePersona(Persona persona) {
        // 1. actualizamos el estado del objeto en la base de datos => se borra.
        em.remove(em.merge(persona));
    }
    
}
