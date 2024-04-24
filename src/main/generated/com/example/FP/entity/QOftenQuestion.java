package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOftenQuestion is a Querydsl query type for OftenQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOftenQuestion extends EntityPathBase<OftenQuestion> {

    private static final long serialVersionUID = 479370164L;

    public static final QOftenQuestion oftenQuestion = new QOftenQuestion("oftenQuestion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath oftenQuestionAnswer = createString("oftenQuestionAnswer");

    public final StringPath oftenQuestionTitle = createString("oftenQuestionTitle");

    public QOftenQuestion(String variable) {
        super(OftenQuestion.class, forVariable(variable));
    }

    public QOftenQuestion(Path<? extends OftenQuestion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOftenQuestion(PathMetadata metadata) {
        super(OftenQuestion.class, metadata);
    }

}

