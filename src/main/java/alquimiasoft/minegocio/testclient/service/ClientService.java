package alquimiasoft.minegocio.testclient.service;

import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;

import java.net.URISyntaxException;
import java.util.Optional;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO) throws URISyntaxException;
    ClientDTO update(ClientDTO clientDTO);
    Optional<ClientDTO> partialUpdate(ClientDTO clientDTO);
    Optional<ClientDTO> findOne(Long id);
    void delete(Long id);
}
