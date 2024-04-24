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

    public final ListPath<OrderDetails, QOrderDetails> orderOrdersdetailList = this.<OrderDetails, QOrderDetails>createList("orderOrdersdetailList", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final ListPath<Point, QPoint> orderPointList = this.<Point, QPoint>createList("orderPointList", Point.class, QPoint.class, PathInits.DIRECT2);

    public final StringPath ordersContent = createString("ordersContent");

    public final DateTimePath<java.time.LocalDateTime> ordersDate = createDateTime("ordersDate", java.time.LocalDateTime.class);

    public final QMember ordersMember;

    public final EnumPath<OrderState> ordersOrderState = createEnum("ordersOrderState", OrderState.class);

    public final StringPath ordersReceiver = createString("ordersReceiver");

    public final StringPath ordersReceiverAddr = createString("ordersReceiverAddr");

    public final StringPath ordersReceiverPhone = createString("ordersReceiverPhone");

    public final StringPath ordersRequest = createString("ordersRequest");

    public final NumberPath<Integer> ordersSalePrice = createNumber("ordersSalePrice", Integer.class);

    public final NumberPath<Integer> ordersTotalPrice = createNumber("ordersTotalPrice", Integer.class);

    public final NumberPath<Integer> ordersUsedPoint = createNumber("ordersUsedPoint", Integer.class);

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
        this.ordersMember = inits.isInitialized("ordersMember") ? new QMember(forProperty("ordersMember")) : null;
    }

}

