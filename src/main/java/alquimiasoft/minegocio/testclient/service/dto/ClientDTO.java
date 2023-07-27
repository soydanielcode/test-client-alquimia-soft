package alquimiasoft.minegocio.testclient.service.dto;

import alquimiasoft.minegocio.testclient.domain.enumeration.IdentificationType;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private Long id;
    private IdentificationType identificationType;
    private String identificationNumber;
    private String names;
    private String email;
    private String cellphone;
    private String province;
    private String city;
    private String address;

    public ClientDTO() {
    }

    public ClientDTO(Long id, IdentificationType identificationType, String identificationNumber, String names, String email, String cellphone, String province, String city, String address) {
        this.id = id;
        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.names = names;
        this.email = email;
        this.cellphone = cellphone;
        this.province = province;
        this.city = city;
        this.address = address;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
