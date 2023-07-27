package alquimiasoft.minegocio.testclient.service.dto;

public class BranchAddressDTO {
    private Long id;
    private String province;
    private String city;
    private String address;
    public BranchAddressDTO() {
    }

    public BranchAddressDTO(Long id, String province, String city, String address) {
        this.id = id;
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
