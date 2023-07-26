package alquimiasoft.minegocio.testclient.repository;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.service.impl.BranchAddressServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchAddressRepository extends JpaRepository<BranchAddress, Long> {
}
