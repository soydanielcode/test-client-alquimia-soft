package alquimiasoft.minegocio.testclient.service.impl;

import alquimiasoft.minegocio.testclient.domain.Client;
import alquimiasoft.minegocio.testclient.domain.enumeration.IdentificationType;
import alquimiasoft.minegocio.testclient.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

class ClientServiceImplTest {

    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientServiceImpl clientService;
    private Client client;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        client = new Client();
        client.setId(1L);
        client.setIdentificationNumber("0107460761");
        client.setIdentificationType(IdentificationType.DNI);
        client.setNames("Daniel Guambana");
        client.setCellphone("0960103746");
        client.setEmail("daniel@gmail.com");
        client.setProvince("Pichincha");
        client.setCity("Quito");
        client.setAddress("Av. 12 de Diciembre");
    }

    @Test
    void save() {
    Mockito.when(clientRepository.save(ArgumentMatchers.any(Client.class))).thenReturn(client);
    }
}