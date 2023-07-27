package alquimiasoft.minegocio.testclient.repository;

import alquimiasoft.minegocio.testclient.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
/*    @Query(
            "Select new alquimiasoft.minegocio.testclient.service.dto.ClientDTO(c.identificationNumber) from Client c " +
                    " where c.identificationNumber = :identificationNumber "
    )
    Boolean existsClientByIdentificationNumber(
            @Param("identificationNumber") String identificationNumber
    );*/

    @Query(
            "select case when (count(c) > 0)  then true else false end  \n" +
                    "from Client c where c.identificationNumber = :identificationNumber"
    )
    Boolean existsClientByIdentificationNumber(
            @Param("identificationNumber") String identificationNumber
    );
}
