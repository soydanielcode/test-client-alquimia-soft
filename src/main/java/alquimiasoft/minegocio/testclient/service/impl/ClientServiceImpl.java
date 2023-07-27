package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.domain.enumeration.StatusType;
import alquimiasoft.minegocio.testclient.exception.BadRequestAlertException;
import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import alquimiasoft.minegocio.testclient.service.mapper.ClientMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URISyntaxException;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final BranchAddressRepository branchAddressRepository;
    private static final String ENTITY_NAME = "Client";

    public ClientServiceImpl(
            ClientMapper clientMapper,
            ClientRepository clientRepository,
            BranchAddressRepository branchAddressRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
        this.branchAddressRepository = branchAddressRepository;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) throws URISyntaxException {
        if (clientRepository.existsClientByIdentificationNumber(clientDTO.getIdentificationNumber())) {
            throw new BadRequestAlertException("There is already a person with this identification number.", ENTITY_NAME, "Alquimia Mi negocio");
        }
        Client client = clientMapper.toEntity(clientDTO);
        client.setStatusType(StatusType.CREATED);
        client = clientRepository.save(client);
        BranchAddress branchAddress = new BranchAddress();
        branchAddress.setProvince(clientDTO.getProvince());
        branchAddress.setCity(clientDTO.getCity());
        branchAddress.setAddress(clientDTO.getAddress());
        branchAddress.setClient(client);
        branchAddressRepository.save(branchAddress);
        return clientMapper.toDto(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) throws URISyntaxException {
        Client clientOld = clientRepository.getReferenceById(clientDTO.getId());
        Client client = clientMapper.toEntity(clientDTO);
        client.setProvince(clientOld.getProvince());
        client.setCity(clientOld.getCity());
        client.setAddress(clientOld.getAddress());
        client = clientRepository.save(client);
        return clientMapper.toDto(client);
    }

    @Override
    public List<ClientDTO> getAllClientsByFindWord(String findWord) {
        return clientRepository.findClientsByIdentificationNumberAndNames(findWord, StatusType.CREATED);
    }

    @Override
    public void delete(Long id) {
        Client client = clientRepository.getReferenceById(id);
        client.setStatusType(StatusType.DELETED);
    }
}
