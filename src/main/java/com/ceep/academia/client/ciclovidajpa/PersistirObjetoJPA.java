/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.academia.client.ciclovidajpa;

import com.ceep.academia.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;




/**
 *
 * @author SaMa
 */
public class PersistirObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        // Con esto podemos iniciar una transacción a la base de datos.
        
        // Paso 1. Creamos un objeto
        // El Objeto está en estado transitivo, todavía no está vinculado a la BD
        Persona persona1 = new Persona("Carlos", "Ruiz", "cruiz@gmail.com", "648324135");
        
        // Paso 2. Iniciamos la transacción
        tx.begin();
        
        // Paso 3. Ejecutamos el SQL
        em.persist(persona1); // Todavía no está insertado en la BD
        log.debug("Objeto persistido - aún sin commit:" + persona1);
        
        // Paso 4. commit/rollback
        tx.commit(); // Aquí se guarda el objeto en la BD
        
        // Objeto en estado de detached
        log.debug("Objeto persistido - estado detached:" + persona1);
        
        // Cerramos el EntityManager
        em.close();
    }
}
