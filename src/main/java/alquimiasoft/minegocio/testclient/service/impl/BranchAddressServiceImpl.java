package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BranchAddressServiceImpl implements BranchAddressService {

    @Override
    public BranchAddressDTO save(BranchAddressDTO branchAddressDTO) {
        return null;
    }

    @Override
    public BranchAddressDTO update(BranchAddressDTO branchAddressDTO) {
        return null;
    }

    @Override
    public Optional<BranchAddressDTO> partialUpdate(BranchAddressDTO branchAddressDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<BranchAddressDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
