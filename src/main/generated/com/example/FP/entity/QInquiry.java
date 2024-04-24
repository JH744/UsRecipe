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

    public final StringPath inquiryAnswer = createString("inquiryAnswer");

    public final DateTimePath<java.time.LocalDateTime> inquiryAnswerDate = createDateTime("inquiryAnswerDate", java.time.LocalDateTime.class);

    public final StringPath inquiryCategory = createString("inquiryCategory");

    public final StringPath inquiryContent = createString("inquiryContent");

    public final DateTimePath<java.time.LocalDateTime> inquiryDate = createDateTime("inquiryDate", java.time.LocalDateTime.class);

    public final QMember inquiryMember;

    public final EnumPath<InquiryState> inquiryState = createEnum("inquiryState", InquiryState.class);

    public final StringPath inquiryTitle = createString("inquiryTitle");

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
        this.inquiryMember = inits.isInitialized("inquiryMember") ? new QMember(forProperty("inquiryMember")) : null;
    }

}

