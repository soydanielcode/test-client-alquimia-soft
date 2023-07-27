package alquimiasoft.minegocio.testclient.service.mapper;
import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = { ClientMapper.class })
public interface ClientMapper {

//    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
/*    @Mapping(source = "branchAddress.province", target = "province")
    @Mapping(source = "branchAddress.city", target = "city")
    @Mapping(source = "branchAddress.address", target = "address")*/
    ClientDTO toDto(Client c);
   /* @Mapping(source = "province", target = "branchAddress.province")
    @Mapping(source = "city", target = "branchAddress.city")
    @Mapping(source = "address", target = "branchAddress.address")*/
    Client toEntity(ClientDTO clientDTO);
}
