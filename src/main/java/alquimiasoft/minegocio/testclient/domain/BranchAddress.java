package alquimiasoft.minegocio.testclient.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "branch_address")
public class BranchAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Client client;
    public BranchAddress() {
    }
    public BranchAddress(String province, String city, String address) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
