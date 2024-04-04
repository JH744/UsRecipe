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

    private int use_point;
    private String point_content;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member point_member;
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders point_orders;

    public Point(int use_point, String point_content, Member point_member, Orders point_orders) {
        this.use_point = use_point;
        this.point_content = point_content;
        this.point_member = point_member;
        this.point_orders = point_orders;
    }
}
