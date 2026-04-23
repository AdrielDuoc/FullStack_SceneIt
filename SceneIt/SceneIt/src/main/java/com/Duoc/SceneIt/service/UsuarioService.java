package com.Duoc.SceneIt.service;

import com.Duoc.SceneIt.modelo.Usuario;
import com.Duoc.SceneIt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public Usuario getUsuario () {
        return (Usuario) usuarioRepository.findAll();
    }

    public Usuario getUsuarioId (Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario saveUsuario (Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        if(!usuarioRepository.existsById(usuario.getId_usuario())){
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    public void EliminarUsuario (Integer id) {
        usuarioRepository.deleteById(id);
    }
}
