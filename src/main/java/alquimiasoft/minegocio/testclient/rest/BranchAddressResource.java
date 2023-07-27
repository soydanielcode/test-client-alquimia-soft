package alquimiasoft.minegocio.testclient.rest;

import alquimiasoft.minegocio.testclient.repository.BranchAddressRepository;
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

    public BranchAddressResource(BranchAddressService branchAddressService) {
        this.branchAddressService = branchAddressService;
    }

    @PostMapping("/branch_address/{id_client}")
    public ResponseEntity<BranchAddressDTO> createBranchAddress(@PathVariable(value = "id_client", required = false) final Long id_client, @RequestBody BranchAddressDTO branchAddressDTO) {
        BranchAddressDTO result = branchAddressService.save(branchAddressDTO, id_client);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/branch_address/{id_client}")
    public ResponseEntity<List<BranchAddressDTO>> getAllBranchAddressByClientId(@PathVariable Long id_client) {
        List<BranchAddressDTO> branchAddressDTOS = branchAddressService.getAllBranchAddressesByClient_Id(id_client);
        return new ResponseEntity<>(branchAddressDTOS, HttpStatus.OK);
    }
}
