package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.exception.BadRequestAlertException;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class ClientResource {
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private static final String ENTITY_NAME = "CLIENT";

    public ClientResource(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            ClientDTO result = clientService.save(clientDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @PutMapping("client/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable(value = "id", required = false) final Long id, @RequestBody ClientDTO clientDTO) {
        if (!clientRepository.existsById(id)) {
            throw new BadRequestAlertException("Invalid ID, that client does not exist.", ENTITY_NAME, "ID Not Exist");
        }
        if (clientDTO.getId() == null) {
            throw new BadRequestAlertException("ID null, that client does not exist.", ENTITY_NAME, "ID is null");
        }
        if (!Objects.equals(id, clientDTO.getId())) {
            throw new BadRequestAlertException("IDs not equal", ENTITY_NAME, "ID find different to Client Update");
        }
        try {
            ClientDTO result = clientService.update(clientDTO);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Long id) {
        if (!clientRepository.existsById(id)) {
            throw new BadRequestAlertException("Invalid ID, that client does not exist.", ENTITY_NAME, "not found");
        }
        try {
            clientService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @GetMapping("/clients/{findWord}")
    public ResponseEntity<List<ClientDTO>> getAllClientsByFindWord(@PathVariable String findWord) {
        if (findWord == null) {
            throw new BadRequestAlertException("The find Word is null, that client does not exist.", ENTITY_NAME, "Word is null");
        }
        try {
            List<ClientDTO> clientDTOS = clientService.getAllClientsByFindWord(findWord);
            return new ResponseEntity<>(clientDTOS, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }
}
