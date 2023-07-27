package alquimiasoft.minegocio.testclient.service;

import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;

import java.util.List;
import java.util.Optional;

public interface BranchAddressService {
    BranchAddressDTO save(BranchAddressDTO branchAddressDTO, Long client_id);
    List<BranchAddressDTO> getAllBranchAddressesByClient_Id(Long id);
}
