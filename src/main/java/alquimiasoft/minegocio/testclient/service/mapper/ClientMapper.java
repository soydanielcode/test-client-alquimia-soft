package alquimiasoft.minegocio.testclient.service.mapper;
import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.service.dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ClientMapper.class })
public interface ClientMapper {

    ClientDTO toDto(Client c);
    @Mapping(target = "statusType", ignore = true)
    Client toEntity(ClientDTO clientDTO);
}
