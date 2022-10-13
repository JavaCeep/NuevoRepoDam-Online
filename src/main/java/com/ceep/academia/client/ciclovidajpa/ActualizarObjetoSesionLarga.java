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
public class ActualizarObjetoSesionLarga {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Paso 1. Iniciamos una transacción
        tx.begin();

        // Paso 2. Ejecutamos el SQL de tipo Select para recuperar el objeto
        Persona persona1 = em.find(Persona.class, 1);
        
        log.debug("Objeto encontrado: " + persona1);
        
        // Paso 3. setValue(nuevoValor)
        persona1.setEmail("lmenendez@gmail.com");
        
        // Si todavía estamos dentro de la transacción podríamos hacer más modific.
        persona1.setEmail("l.menendez@gmail.com");

        // No necesitamos hacer un merge ya que cuando termina la transacción
        // actualiza las modificaciones realizadas
        
        // Paso 4. Termina la transacción
        tx.commit();
        
        log.debug("Objeto modificado: " + persona1);
        
        // Cerramos el EntityManager
        em.close();

    }
}