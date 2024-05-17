package br.com.adatech.moviebattle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.adatech.moviebattle.entities.Rodada;

import java.util.Optional;

public interface RodadaRepository extends JpaRepository<Rodada, Long> {

    Optional<Rodada> findByUsuarioUsernameAndIsFinalizadaFalse(String usuario);

}
