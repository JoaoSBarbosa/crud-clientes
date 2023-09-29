package br.com.joaosbarbosa.trabalho.repository;

import br.com.joaosbarbosa.trabalho.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
