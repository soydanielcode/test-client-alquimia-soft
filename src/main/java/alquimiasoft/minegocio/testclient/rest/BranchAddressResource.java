package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.exception.BadRequestAlertException;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import alquimiasoft.minegocio.testclient.service.BranchAddressService;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchAddressResource {
    private final BranchAddressService branchAddressService;
    private final ClientRepository clientRepository;
    private static final String ENTITY_NAME = "BRANCH_ADDRESS";

    public BranchAddressResource(BranchAddressService branchAddressService, ClientRepository clientRepository) {
        this.branchAddressService = branchAddressService;
        this.clientRepository = clientRepository;
    }

    @PostMapping("/branch_address/{id_client}")
    public ResponseEntity<BranchAddressDTO> createBranchAddress(@PathVariable(value = "id_client", required = false) final Long id_client, @RequestBody BranchAddressDTO branchAddressDTO) {
        if (!clientRepository.existsById(id_client)) {
            throw new BadRequestAlertException("Invalid ID, that client does not exist.", ENTITY_NAME, "ID Not Exist");
        }
        try {
            BranchAddressDTO result = branchAddressService.save(branchAddressDTO, id_client);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }

    @GetMapping("/branch_address/{id_client}")
    public ResponseEntity<List<BranchAddressDTO>> getAllBranchAddressByClientId(@PathVariable Long id_client) {
        if (!clientRepository.existsById(id_client)) {
            throw new BadRequestAlertException("Invalid ID, that client does not exist.", ENTITY_NAME, "ID Not Exist");
        }
        try {
            List<BranchAddressDTO> branchAddressDTOS = branchAddressService.getAllBranchAddressesByClient_Id(id_client);
            return new ResponseEntity<>(branchAddressDTOS, HttpStatus.OK);
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "Error");
        }
    }
}
