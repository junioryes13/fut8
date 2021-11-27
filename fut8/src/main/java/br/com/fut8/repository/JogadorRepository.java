package br.com.fut8.repository;

import br.com.fut8.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador,Long> {
    Optional<Jogador> findByCPF(String id);
}
