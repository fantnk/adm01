package top.fedoseev.adm01.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name = "traffic", uniqueConstraints = {@UniqueConstraint(columnNames = "id", name = "id_UNIQUE")})
//???
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public class Subscriber {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    @NotEmpty
    @Column(name = "account_number", nullable = false)
    protected long accountNumber;

    @OneToMany(mappedBy = "subscriber", cascade = CascadeType.ALL)
    protected List<Traffic> trafficList;

    public Subscriber() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<Traffic> getTrafficList() {
        return trafficList;
    }

    public void setTrafficList(List<Traffic> trafficList) {
        this.trafficList = trafficList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Subscriber that = (Subscriber) o;
        if (id == null || that.id == null) {
            return false;
        }
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return (id == null) ? 0 : id;
    }

}
