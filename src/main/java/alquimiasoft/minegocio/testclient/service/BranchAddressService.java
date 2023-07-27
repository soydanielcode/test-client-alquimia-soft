package alquimiasoft.minegocio.testclient.service;

import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;

import java.util.Optional;

public interface BranchAddressService {
    BranchAddressDTO save(BranchAddressDTO branchAddressDTO);
    BranchAddressDTO update(BranchAddressDTO branchAddressDTO);
    Optional<BranchAddressDTO> findOne(Long id);
    void delete(Long id);
}
