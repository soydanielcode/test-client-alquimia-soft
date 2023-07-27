package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.exception.BadRequestAlertException;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ClientResource {
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private static final String ENTITY_NAME = "Client";

    public ClientResource(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        ClientDTO result = clientService.save(clientDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("client/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable(value = "id", required = false) final Long id, @RequestBody ClientDTO clientDTO) throws URISyntaxException {
        if(!clientRepository.existsById(id)){
            throw new BadRequestAlertException("Invalid ID.", ENTITY_NAME, "not found");
        }
        if (clientDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, clientDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }
        ClientDTO result = clientService.update(clientDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
