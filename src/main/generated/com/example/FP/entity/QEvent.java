package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = 1925557602L;

    public static final QEvent event = new QEvent("event");

    public final StringPath event_content = createString("event_content");

    public final DateTimePath<java.time.LocalDateTime> event_end_date = createDateTime("event_end_date", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> event_start_date = createDateTime("event_start_date", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> event_submit_date = createDateTime("event_submit_date", java.time.LocalDateTime.class);

    public final StringPath event_thumbnail = createString("event_thumbnail");

    public final StringPath event_title = createString("event_title");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

