package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPoint is a Querydsl query type for Point
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPoint extends EntityPathBase<Point> {

    private static final long serialVersionUID = 1935511640L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPoint point = new QPoint("point");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath pointContent = createString("pointContent");

    public final QMember pointMember;

    public final QOrders pointOrders;

    public final NumberPath<Integer> usePoint = createNumber("usePoint", Integer.class);

    public QPoint(String variable) {
        this(Point.class, forVariable(variable), INITS);
    }

    public QPoint(Path<? extends Point> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPoint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPoint(PathMetadata metadata, PathInits inits) {
        this(Point.class, metadata, inits);
    }

    public QPoint(Class<? extends Point> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pointMember = inits.isInitialized("pointMember") ? new QMember(forProperty("pointMember")) : null;
        this.pointOrders = inits.isInitialized("pointOrders") ? new QOrders(forProperty("pointOrders"), inits.get("pointOrders")) : null;
    }

}

