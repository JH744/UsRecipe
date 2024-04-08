package com.example.FP.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Point {

    @Id@GeneratedValue
    @Column(name = "point_id")
    private Long id;

    private int usePoint;
    private String pointContent;
    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member pointMember;
    @ManyToOne
    @JoinColumn(name = "ordersId")
    private Orders pointOrders;

    public Point(int usePoint, String pointContent, Member pointMember, Orders pointOrders) {
        this.usePoint = usePoint;
        this.pointContent = pointContent;
        this.pointMember = pointMember;
        this.pointOrders = pointOrders;
    }
}
