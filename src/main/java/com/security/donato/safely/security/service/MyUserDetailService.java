package com.security.donato.safely.security.service;

import com.security.donato.safely.domain.Contexto;
import com.security.donato.safely.domain.Usuario;
import com.security.donato.safely.repository.ContextoRepository;
import com.security.donato.safely.repository.UsuarioRepository;
import com.security.donato.safely.security.UsuarioSistema;
import com.security.donato.safely.service.serviceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private ContextoRepository contextoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioServiceImpl.findUsuarioByLogin(username);
        return new UsuarioSistema(usuario.getLogin(), usuario.getSenha(), authorities(usuario));
    }

    public Collection<? extends GrantedAuthority> authorities(Usuario usuario) {
        Collection<GrantedAuthority> auths = new ArrayList<>();
        List<Contexto> contextoList = contextoRepository.findContextoByIdUsuario(usuario.getUsuarioId());
        contextoList.forEach(contexto -> {
            auths.add(new SimpleGrantedAuthority("ROLE_" + contexto.getDescricao()));
        });
        return auths;
    }

}

