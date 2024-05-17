package br.com.adatech.moviebattle.service.impl;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.adatech.moviebattle.entities.Usuario;
import br.com.adatech.moviebattle.repository.UsuarioRepository;
import br.com.adatech.moviebattle.service.interfaces.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario getUsuario(String usuario) {
        return usuarioRepository.findByUsername(usuario).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public List<Usuario> getScoreBoard() {
        return usuarioRepository.getScoreBoard();
    }

    @Override
    public String getUsernameUsuarioLogado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var userDetails = (UserDetails) authentication.getPrincipal();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userDetails.getUsername();
        }
        throw new RuntimeException("Não há ninguém logado");
    }

}
