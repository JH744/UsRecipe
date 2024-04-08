package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrders is a Querydsl query type for Orders
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrders extends EntityPathBase<Orders> {

    private static final long serialVersionUID = -154697443L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrders orders = new QOrders("orders");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<OrderDetails, QOrderDetails> order_ordersdetail_list = this.<OrderDetails, QOrderDetails>createList("order_ordersdetail_list", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final ListPath<Point, QPoint> order_point_list = this.<Point, QPoint>createList("order_point_list", Point.class, QPoint.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> orders_date = createDateTime("orders_date", java.time.LocalDateTime.class);

    public final QMember orders_member;

    public final QOrderState orders_order_state;

    public final StringPath orders_receiver = createString("orders_receiver");

    public final StringPath orders_receiver_addr = createString("orders_receiver_addr");

    public final StringPath orders_receiver_phone = createString("orders_receiver_phone");

    public final StringPath orders_request = createString("orders_request");

    public final NumberPath<Integer> orders_sale_price = createNumber("orders_sale_price", Integer.class);

    public final NumberPath<Integer> orders_total_price = createNumber("orders_total_price", Integer.class);

    public final NumberPath<Integer> orders_used_point = createNumber("orders_used_point", Integer.class);

    public QOrders(String variable) {
        this(Orders.class, forVariable(variable), INITS);
    }

    public QOrders(Path<? extends Orders> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrders(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrders(PathMetadata metadata, PathInits inits) {
        this(Orders.class, metadata, inits);
    }

    public QOrders(Class<? extends Orders> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orders_member = inits.isInitialized("orders_member") ? new QMember(forProperty("orders_member")) : null;
        this.orders_order_state = inits.isInitialized("orders_order_state") ? new QOrderState(forProperty("orders_order_state")) : null;
    }

}

