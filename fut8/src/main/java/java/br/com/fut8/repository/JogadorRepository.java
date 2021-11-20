package java.br.com.fut8.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.br.com.fut8.model.Jogador;
import java.util.Optional;

public interface JogadorRepository extends JpaRepository<Jogador,Long> {
    Optional<Jogador> findByDocumento(Long id);
}
