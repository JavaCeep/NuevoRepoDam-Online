
package com.ceep.academia.service;

import com.ceep.academia.domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author SaMa
 */
@Local
public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public Usuario encontrarUsuarioPorID(Usuario usuario);
    
    public Usuario econtrarUsuarioPorUsername(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void modificarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
}
