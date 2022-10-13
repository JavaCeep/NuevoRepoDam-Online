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
public class EncontrarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // Paso 1. Iniciamos una transacción
        tx.begin();

        // Paso 2. Ejecutamos un SQL de tipo SELECT
        Persona persona1 = em.find(Persona.class, 1);
        
        // Paso 3. Termina la transacción
        tx.commit();

        // Imprimimos nuestro Objeto en estado de Detached
        log.debug("Objeto recuperado: " + persona1);
        
        // Cerramos el EntityManager
        em.close();
    }
}
