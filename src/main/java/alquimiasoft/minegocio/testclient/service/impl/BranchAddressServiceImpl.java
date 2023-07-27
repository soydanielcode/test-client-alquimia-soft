package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import alquimiasoft.minegocio.testclient.service.mapper.BranchAddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class BranchAddressServiceImpl implements BranchAddressService {

    private final BranchAddressMapper branchAddressMapper;
    private final BranchAddressRepository branchAddressRepository;

    public BranchAddressServiceImpl(BranchAddressMapper branchAddressMapper, BranchAddressRepository branchAddressRepository) {
        this.branchAddressMapper = branchAddressMapper;
        this.branchAddressRepository = branchAddressRepository;
    }

    @Override
    public BranchAddressDTO save(BranchAddressDTO branchAddressDTO) {
        BranchAddress branchAddress = branchAddressMapper.toEntity(branchAddressDTO);
        branchAddress = branchAddressRepository.save(branchAddress);
        return branchAddressMapper.toDTO(branchAddress);
    }

    @Override
    public BranchAddressDTO update(BranchAddressDTO branchAddressDTO) {
        return null;
    }

    @Override
    public Optional<BranchAddressDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
