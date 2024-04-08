package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReply is a Querydsl query type for Reply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReply extends EntityPathBase<Reply> {

    private static final long serialVersionUID = 1937067442L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReply reply = new QReply("reply");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath replyContent = createString("replyContent");

    public final DateTimePath<java.time.LocalDateTime> replyDate = createDateTime("replyDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> replyGrade = createNumber("replyGrade", Integer.class);

    public final QIngredient replyIngredient;

    public final QMember replyMember;

    public final QRecipe replyRecipe;

    public QReply(String variable) {
        this(Reply.class, forVariable(variable), INITS);
    }

    public QReply(Path<? extends Reply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReply(PathMetadata metadata, PathInits inits) {
        this(Reply.class, metadata, inits);
    }

    public QReply(Class<? extends Reply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.replyIngredient = inits.isInitialized("replyIngredient") ? new QIngredient(forProperty("replyIngredient"), inits.get("replyIngredient")) : null;
        this.replyMember = inits.isInitialized("replyMember") ? new QMember(forProperty("replyMember")) : null;
        this.replyRecipe = inits.isInitialized("replyRecipe") ? new QRecipe(forProperty("replyRecipe"), inits.get("replyRecipe")) : null;
    }

}

