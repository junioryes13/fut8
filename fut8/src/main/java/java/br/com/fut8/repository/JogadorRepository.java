package java.br.com.fut8.repository;

import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.br.com.fut8.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador,Long> {
}
