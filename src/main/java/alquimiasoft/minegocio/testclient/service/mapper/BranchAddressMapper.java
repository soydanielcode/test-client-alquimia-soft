package alquimiasoft.minegocio.testclient.service.mapper;
import alquimiasoft.minegocio.testclient.domain.BranchAddress;
import alquimiasoft.minegocio.testclient.service.dto.BranchAddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { BranchAddress.class })
public interface BranchAddressMapper {
    BranchAddressDTO toDTO(BranchAddress branchAddress);
    @Mapping(target = "client", ignore = true)
    BranchAddress toEntity(BranchAddressDTO branchAddressDTO);
}
