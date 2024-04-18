package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderState is a Querydsl query type for OrderState
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderState extends EntityPathBase<OrderState> {

    private static final long serialVersionUID = 1428877339L;

    public static final QOrderState orderState = new QOrderState("orderState");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Orders, QOrders> ordersStateList = this.<Orders, QOrders>createList("ordersStateList", Orders.class, QOrders.class, PathInits.DIRECT2);

    public final StringPath state = createString("state");

    public QOrderState(String variable) {
        super(OrderState.class, forVariable(variable));
    }

    public QOrderState(Path<? extends OrderState> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrderState(PathMetadata metadata) {
        super(OrderState.class, metadata);
    }

}

