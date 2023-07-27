package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api")
public class BranchAddressResource {
    private final BranchAddressRepository branchAddressRepository;
    private final BranchAddressService branchAddressService;
    private final ClientRepository clientRepository;

    public BranchAddressResource(BranchAddressRepository branchAddressRepository, BranchAddressService branchAddressService, ClientRepository clientRepository) {
        this.branchAddressRepository = branchAddressRepository;
        this.branchAddressService = branchAddressService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/branch_address/{id_client}")
    public ResponseEntity<BranchAddressDTO> createBranchAddress(@PathVariable(value = "id_client", required = false) final Long id_client, @RequestBody BranchAddressDTO branchAddressDTO) {
        BranchAddressDTO result = branchAddressService.save(branchAddressDTO, id_client);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
