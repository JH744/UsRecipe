package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = -185617136L;

    public static final QNotice notice = new QNotice("notice");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath notice_content = createString("notice_content");

    public final DateTimePath<java.time.LocalDateTime> notice_submit_date = createDateTime("notice_submit_date", java.time.LocalDateTime.class);

    public final StringPath notice_title = createString("notice_title");

    public QNotice(String variable) {
        super(Notice.class, forVariable(variable));
    }

    public QNotice(Path<? extends Notice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotice(PathMetadata metadata) {
        super(Notice.class, metadata);
    }

}

