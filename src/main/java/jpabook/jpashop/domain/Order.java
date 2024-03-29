package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;


    //    @Column(name="MEMBER_ID")
    //    private Long memberId;
    // 이제 위의 코드 대신 아래의 코드를 통해 join을 시키는겨
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING) //ordinary쓰면 난리남.나중에 순서 다꼬임
    private OrderStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem); //주문 내역 넣고
        orderItem.setOrder(this); // 현재 나의 오더 넣기 --> 이렇게 하면 양방향 참조

    }
}
