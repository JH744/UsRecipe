package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QInquiry is a Querydsl query type for Inquiry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiry extends EntityPathBase<Inquiry> {

    private static final long serialVersionUID = -1632750961L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QInquiry inquiry = new QInquiry("inquiry");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath inquiry_answer = createString("inquiry_answer");

    public final DateTimePath<java.time.LocalDateTime> inquiry_answer_date = createDateTime("inquiry_answer_date", java.time.LocalDateTime.class);

    public final StringPath inquiry_category = createString("inquiry_category");

    public final StringPath inquiry_content = createString("inquiry_content");

    public final DateTimePath<java.time.LocalDateTime> inquiry_date = createDateTime("inquiry_date", java.time.LocalDateTime.class);

    public final QMember inquiry_member;

    public final EnumPath<InquiryState> inquiry_state = createEnum("inquiry_state", InquiryState.class);

    public final StringPath inquiry_title = createString("inquiry_title");

    public QInquiry(String variable) {
        this(Inquiry.class, forVariable(variable), INITS);
    }

    public QInquiry(Path<? extends Inquiry> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QInquiry(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QInquiry(PathMetadata metadata, PathInits inits) {
        this(Inquiry.class, metadata, inits);
    }

    public QInquiry(Class<? extends Inquiry> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.inquiry_member = inits.isInitialized("inquiry_member") ? new QMember(forProperty("inquiry_member")) : null;
    }

}

