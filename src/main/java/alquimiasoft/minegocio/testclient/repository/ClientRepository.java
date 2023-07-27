package alquimiasoft.minegocio.testclient.repository;

import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.domain.enumeration.StatusType;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(
            "select case when (count(c) > 0)  then true else false end  \n" +
                    "from Client c where c.identificationNumber = :identificationNumber"
    )
    Boolean existsClientByIdentificationNumber(
            @Param("identificationNumber") String identificationNumber
    );

    @Query(
            " select new alquimiasoft.minegocio.testclient.service.dto.ClientDTO(c.id, c.identificationType, c.identificationNumber, c.names, c.email, c.cellphone, c.province, c.city, c.address)  " +
                    "from Client c " +
                    " where (c.identificationNumber ilike %:findWord% or c.names ilike %:findWord%) and c.statusType = :status "
    )
    List<ClientDTO> findClientsByIdentificationNumberAndNames(
            @Param("findWord") String findWord,
            @Param("status") StatusType status
    );
}
