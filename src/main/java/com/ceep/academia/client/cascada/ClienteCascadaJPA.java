/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.academia.client.cascada;

import com.ceep.academia.domain.Persona;
import com.ceep.academia.domain.Usuario;
import javax.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author SaMa
 */
public class ClienteCascadaJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        tx.begin();
        // Creamos un nuevo objeto
        Persona persona1 = new Persona("Luis", "Dies", "ldies@yahoo.com", "677519200");
        
        // Creamos también el objeto de usuario que va a depender de la persona
        // debemos de crear este nuevo constructor en Usuario
        Usuario usuario1 = new Usuario("ldies", "1234", persona1);
        
        // Con esto estamos relacionando el usuario con su persona correspondiente
        
        // Ahora persistimos el Objeto usuario y sólo el objeto usuario
        em.persist(usuario1);
        // De forma automática se persistirá también la persona nueva
        
        tx.commit();
        
        log.debug("Objeto persona persistada: " + persona1);
        log.debug("Objeto usuario persistada: " + usuario1);
        
        em.close();        
    }    
}
