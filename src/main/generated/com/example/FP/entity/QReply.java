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

    public final StringPath reply_content = createString("reply_content");

    public final DateTimePath<java.time.LocalDateTime> reply_date = createDateTime("reply_date", java.time.LocalDateTime.class);

    public final NumberPath<Integer> reply_grade = createNumber("reply_grade", Integer.class);

    public final QIngredient reply_ingredient;

    public final QRecipe reply_recipe;

    public final QMember replyMember;

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
        this.reply_ingredient = inits.isInitialized("reply_ingredient") ? new QIngredient(forProperty("reply_ingredient"), inits.get("reply_ingredient")) : null;
        this.reply_recipe = inits.isInitialized("reply_recipe") ? new QRecipe(forProperty("reply_recipe"), inits.get("reply_recipe")) : null;
        this.replyMember = inits.isInitialized("replyMember") ? new QMember(forProperty("replyMember")) : null;
    }

}

