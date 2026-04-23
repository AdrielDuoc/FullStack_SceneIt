package com.Duoc.SceneIt.service;

import com.Duoc.SceneIt.modelo.Usuario;
import com.Duoc.SceneIt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario BuscarTodosLosUsuarios () {
        return (Usuario) usuarioRepository.findAll();
    }

    public Usuario BuscarUsuarioPorId (Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario GuardarUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean ExisteUsuario (Integer id) {
        return usuarioRepository.existsById(id);
    }

    public void EliminarUsuario (Integer id) {
        usuarioRepository.deleteById(id);
    }
}
