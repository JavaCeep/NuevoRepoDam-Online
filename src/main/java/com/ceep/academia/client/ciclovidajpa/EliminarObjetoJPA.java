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
public class EliminarObjetoJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademiaPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        
        // Con esto podemos iniciar una transacción a la base de datos.
        

        // Paso 1. Iniciamos la transacción
        tx.begin();
        
        
        // Paso 2. Recuperamos un Objeto de tipo persona con Select en estado Detached
        Persona persona1 = em.find(Persona.class, 7);
        
        // Si estuvíeramos dentro de la misma transacción podríamos hacer remove
        // directamete
                                
        // Paso 3. Borramos
        //em.remove(persona1); // En estado Removed
        // log.debug("Objeto persistido - aún sin commit:" + persona1);
        
        // Pero lo normal sería 1 recuperar el objeto
       
        
        // Paso 3. commit/rollback
        tx.commit(); // Recuperamos el objeto.
                        
        // Objeto en estado de detached
        log.debug("Objeto encontrado - estado detached:" + persona1);
        
        // Paso 4. Transacción 2
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        // Paso 5. Ejectuamos el SQL delete
        em.remove(em.merge(persona1));
        // Actualizamos el en la BD el objeto que tenemos en memoría por si 
        // hubiéramos hecho algún cambio
        
        // Paso 6. Termina la transacción 2
        tx2.commit();
        
        // Objeto en estado detached y eliminado
        log.debug("Objeto eliminado - estado detached: " + persona1);
        
        
        // Cerramos el EntityManager
        em.close();
    }    
    
}
