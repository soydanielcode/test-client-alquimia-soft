package alquimiasoft.minegocio.testclient.repository;

import alquimiasoft.minegocio.testclient.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
