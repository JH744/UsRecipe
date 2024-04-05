package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QOrderDetails is a Querydsl query type for OrderDetails
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOrderDetails extends EntityPathBase<OrderDetails> {

    private static final long serialVersionUID = -2078514356L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QOrderDetails orderDetails = new QOrderDetails("orderDetails");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> ingredient_price = createNumber("ingredient_price", Integer.class);

    public final QOrders orders_detail;

    public final QIngredient orders_ingredient;

    public final QMember orders_member;

    public QOrderDetails(String variable) {
        this(OrderDetails.class, forVariable(variable), INITS);
    }

    public QOrderDetails(Path<? extends OrderDetails> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QOrderDetails(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QOrderDetails(PathMetadata metadata, PathInits inits) {
        this(OrderDetails.class, metadata, inits);
    }

    public QOrderDetails(Class<? extends OrderDetails> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.orders_detail = inits.isInitialized("orders_detail") ? new QOrders(forProperty("orders_detail"), inits.get("orders_detail")) : null;
        this.orders_ingredient = inits.isInitialized("orders_ingredient") ? new QIngredient(forProperty("orders_ingredient"), inits.get("orders_ingredient")) : null;
        this.orders_member = inits.isInitialized("orders_member") ? new QMember(forProperty("orders_member")) : null;
    }

}

