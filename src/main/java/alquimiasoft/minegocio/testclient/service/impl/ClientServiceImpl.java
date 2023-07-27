package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.exception.BadRequestAlertException;
import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import alquimiasoft.minegocio.testclient.service.mapper.BranchAddressMapper;
import alquimiasoft.minegocio.testclient.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.net.URISyntaxException;

import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final BranchAddressMapper branchAddressMapper;
    private final BranchAddressService branchAddressService;
    private final BranchAddressRepository branchAddressRepository;
    private static final String ENTITY_NAME = "Client";

    public ClientServiceImpl(
            ClientMapper clientMapper,
            ClientRepository clientRepository,
            BranchAddressMapper branchAddressMapper, BranchAddressService branchAddressService, BranchAddressRepository branchAddressRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
        this.branchAddressMapper = branchAddressMapper;
        this.branchAddressService = branchAddressService;
        this.branchAddressRepository = branchAddressRepository;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) throws URISyntaxException {
        if(clientRepository.existsClientByIdentificationNumber(clientDTO.getIdentificationNumber())){
            throw new BadRequestAlertException("There is already a person with this identification number.", ENTITY_NAME, "Alquimia Mi negocio");
        }
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setProvince(clientDTO.getProvince());
        branchAddress.setCity(clientDTO.getCity());
        branchAddress.setAddress(clientDTO.getAddress());
        branchAddress.setClient(client);
        branchAddress = branchAddressRepository.save(branchAddress);
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {

//        if (clientRepository.findById(clientDTO.getId()).isEmpty() == false){
//
//        }

//        if(clientRepository.existsClientByIdentificationNumber(clientDTO.getIdentificationNumber())){
//            throw new BadRequestAlertException("There is already a person with this identification number.", ENTITY_NAME, "Alquimia Mi negocio");
//        }
    return null;
    }

    @Override
    public Optional<ClientDTO> partialUpdate(ClientDTO clientDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientDTO> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }
}
