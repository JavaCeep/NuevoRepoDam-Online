package com.ceep.academia.service;

import com.ceep.academia.data.UsuarioDao;
import com.ceep.academia.domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author SaMa
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService{

    // Gracias a que estamos en un entorno EE podemos usar CDI para inyectar usuarioDao
    @Inject    
    private UsuarioDao usuarioDao;
    
    // Ahora nos apoyamos de la interfaz para completar los servicios
    
    @Override
    public List<Usuario> listarUsuarios() {       
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorID(Usuario usuario) {
        return usuarioDao.findUsuarioByID(usuario);
    }

    @Override
    public Usuario econtrarUsuarioPorUsername(Usuario usuario) {
        return usuarioDao.findUsuarioByUsername(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
