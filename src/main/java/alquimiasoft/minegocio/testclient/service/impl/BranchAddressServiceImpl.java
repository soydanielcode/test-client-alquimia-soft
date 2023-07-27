package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.domain.enumeration.StatusType;
import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import alquimiasoft.minegocio.testclient.service.mapper.BranchAddressMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BranchAddressServiceImpl implements BranchAddressService {

    private final BranchAddressMapper branchAddressMapper;
    private final BranchAddressRepository branchAddressRepository;
    private final ClientRepository clientRepository;

    public BranchAddressServiceImpl(BranchAddressMapper branchAddressMapper, BranchAddressRepository branchAddressRepository, ClientRepository clientRepository) {
        this.branchAddressMapper = branchAddressMapper;
        this.branchAddressRepository = branchAddressRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public BranchAddressDTO save(BranchAddressDTO branchAddressDTO, Long client_id) {
        BranchAddress branchAddress = branchAddressMapper.toEntity(branchAddressDTO);
        branchAddress.setClient(clientRepository.getReferenceById(client_id));
        branchAddress = branchAddressRepository.save(branchAddress);
        return branchAddressMapper.toDTO(branchAddress);
    }

    @Override
    public List<BranchAddressDTO> getAllBranchAddressesByClient_Id(Long id) {
        return branchAddressRepository.findBranchAddressesByClient_Id(id, StatusType.CREATED);
    }
}
