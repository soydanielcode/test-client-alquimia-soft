package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.ClientService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class ClientResource {
    private final ClientService clientService;
    private final ClientRepository clientRepository;

    public ClientResource(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientDTO>createClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        ClientDTO result = clientService.save(clientDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/test")
    public  String getAll(){return "getAll";}
}
