package alquimiasoft.minegocio.testclient.service;

import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;

import java.net.URISyntaxException;
import java.util.List;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO) throws URISyntaxException;

    ClientDTO update(ClientDTO clientDTO) throws URISyntaxException;

    List<ClientDTO> getAllClientsByFindWord(String findWord);

    void delete(Long id);
}
