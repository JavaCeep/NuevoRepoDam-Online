package com.ceep.academia.web;

import com.ceep.academia.domain.Usuario;
import com.ceep.academia.service.UsuarioService;
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
@WebServlet("/usuarios")
public class UsuarioServelt extends HttpServlet{
    
    // Ahora hacemos la inyección del componente EJB local al servlet
    @Inject
    // Ahora definimos nuestra variable
    UsuarioService usuarioService; // Cremos una instancia de nuestra if local
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse respose)
    throws ServletException, IOException {
        
        /** Ahora este método va acceder al listado de usuarios por medio
         * de la instancia que estamos recibiendo el EJB         
         */
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        System.out.println("usuarios: " + usuarios);
        
        // Ponemos usuarios en un alcance
        request.setAttribute("usuarios", usuarios);
        
        // Redirigimos al JSP
        request.getRequestDispatcher("/listadoUsuarios.jsp").forward(request, 
                respose);
    }
}
