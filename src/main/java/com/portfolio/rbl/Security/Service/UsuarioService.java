
package com.portfolio.rbl.Security.Service;

import com.portfolio.rbl.Security.Entity.Usuario;
import com.portfolio.rbl.Security.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
    return iusuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario(String nombreUsuario){
    return iusuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    
    public boolean existsByEmail(String email){
    return iusuarioRepository.existsByNombreUsuario(email);
    }
    
    public void save(Usuario usuario){
    iusuarioRepository.save(usuario);
    }
}

