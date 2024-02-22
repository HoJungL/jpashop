package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;
    private String name;
    @Embedded
    private Address address;

    // 사실 아래의 코드는 비즈니스상 불필요한 코드지만,
    // 연습이기 때문에 넣은 코드임.
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); //관례야 관례


    // GETTER SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
