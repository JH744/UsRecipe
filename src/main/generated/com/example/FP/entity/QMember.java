package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -223696686L;

    public static final QMember member = new QMember("member1");

    public final StringPath addr = createString("addr");

    public final StringPath birth = createString("birth");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<Alarm, QAlarm> memberAlarmList = this.<Alarm, QAlarm>createList("memberAlarmList", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final ListPath<Cart, QCart> memberCartList = this.<Cart, QCart>createList("memberCartList", Cart.class, QCart.class, PathInits.DIRECT2);

    public final ListPath<Orders, QOrders> memberOrdersList = this.<Orders, QOrders>createList("memberOrdersList", Orders.class, QOrders.class, PathInits.DIRECT2);

    public final ListPath<Point, QPoint> memberPointList = this.<Point, QPoint>createList("memberPointList", Point.class, QPoint.class, PathInits.DIRECT2);

    public final ListPath<Reply, QReply> memberReplyList = this.<Reply, QReply>createList("memberReplyList", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<OrderDetails, QOrderDetails> orderDetailsMemberList = this.<OrderDetails, QOrderDetails>createList("orderDetailsMemberList", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Recipe, QRecipe> recipeList = this.<Recipe, QRecipe>createList("recipeList", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final EnumPath<MemberRole> role = createEnum("role", MemberRole.class);

    public final StringPath userid = createString("userid");

    public final ListPath<WishList, QWishList> wishlistList = this.<WishList, QWishList>createList("wishlistList", WishList.class, QWishList.class, PathInits.DIRECT2);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

