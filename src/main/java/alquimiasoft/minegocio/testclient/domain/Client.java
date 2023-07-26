package alquimiasoft.minegocio.testclient.domain;

import alquimiasoft.minegocio.testclient.domain.enumeration.IdentificationType;
import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
//import javax.validation.constraints.Size;
//import org.intellij.lang.annotations.Pattern;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "identification_type", length = 50)
    private IdentificationType identificationType;

    //    @Pattern(regexp = Constans.CI_REGEX)
    @NotNull
//    @Size(min = 10, max = 13)
    @Column(name = "identification_number", length = 50)
    private String identificationNumber;
    @NotNull
    @Column(name = "names", length = 200)
    private String names;
    @NotNull
    @Column(name = "email")
    private String email;
    @NotNull
    @Column(name = "cellphone")
    private String cellphone;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name = "address")
    private String address;
    public Client() {
    }
    public Client(IdentificationType identificationType, String identificationNumber, String names, String email, String cellphone, String province, String city, String address) {
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", identificationType=" + identificationType +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", names='" + names + '\'' +
                ", email='" + email + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
