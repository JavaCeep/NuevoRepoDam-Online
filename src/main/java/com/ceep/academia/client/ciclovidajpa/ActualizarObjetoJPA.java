/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.academia.client.ciclovidajpa;

import com.ceep.academia.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author SaMa
 */
public class ActualizarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // Paso 1. Iniciamos una transacción
        tx.begin();

        // Paso 2. Ejecutamos un SQL de tipo SELECT el id tiene que existir en la BD
        Persona persona1 = em.find(Persona.class, 1);
        
        // Paso 3. Termina la transacción 1
        tx.commit();
        
        // Imprimimos el Objeto en estado de Detached
        log.debug("Objeto recuperado con éxito: " + persona1);
        
        // Paso 4. Modificamos el Objeto
        persona1.setApellido("Menéndez");
        
        // Paso 5. Iniciamos una nueva transacción
        EntityTransaction tx2 = em.getTransaction();        
        tx2.begin();
        
        // Paso 6. Modificamos el objeto
        em.merge(persona1);
        
        em.flush(); // Vacía cualquier modificación pendiente sin terminar la trans.
        
        // Paso 7. Terminamos la transacción
        tx2.commit();
        
        
        // El Objeto pasa a estado de detached ya modificado
        log.debug("Objeto recuperado: " + persona1);
        
        // Cerramos el EntityManager
        em.close();
    }    
}
