package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        return null;
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
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
