package alquimiasoft.minegocio.testclient.repository;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.domain.enumeration.StatusType;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchAddressRepository extends JpaRepository<BranchAddress, Long> {
    @Query(
            " select new alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO(ba.id, ba.province, ba.city, ba.address) from BranchAddress ba " +
                    " inner join Client c on ba.client.id = c.id " +
                    " where c.id = :id and c.statusType = :status "
    )
    List<BranchAddressDTO> findBranchAddressesByClient_Id(
            @Param("id") Long id,
            @Param("status") StatusType status
    );
}
