package br.com.adatech.moviebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adatech.moviebattle.entities.Jogo;

import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    Optional<Jogo> findByUsuarioUsernameAndIsFinalizadoFalse(String usuario);

}
