package com.ceep.academia.data;

import com.ceep.academia.domain.Usuario;
import java.util.List;

/**
 *
 * @author SaMa
 */
public interface UsuarioDao {
    
    public List<Usuario> findAllUsuarios();
    
    public Usuario findUsuarioByID(Usuario usuario);
    
    public Usuario findUsuarioByUsername(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);

    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);    
}
