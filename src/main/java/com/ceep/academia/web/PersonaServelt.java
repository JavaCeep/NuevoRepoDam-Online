package com.ceep.academia.web;

import com.ceep.academia.domain.Persona;
import com.ceep.academia.service.PersonaService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SaMa
 */
@WebServlet("/personas")
public class PersonaServelt extends HttpServlet{
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    PersonaService personaService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de personas por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Persona> personas = personaService.listarPersonas();
        System.out.println("personas: " + personas);
        
        // Ponemos personas en un alcance
        request.setAttribute("personas", personas);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoPersonas.jsp").forward(request, 
                respose);
    }
}
