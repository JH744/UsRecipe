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

    public final ListPath<Inquiry, QInquiry> inquiry_list = this.<Inquiry, QInquiry>createList("inquiry_list", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<Alarm, QAlarm> member_alarm_list = this.<Alarm, QAlarm>createList("member_alarm_list", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final ListPath<Cart, QCart> member_cart_list = this.<Cart, QCart>createList("member_cart_list", Cart.class, QCart.class, PathInits.DIRECT2);

    public final ListPath<Point, QPoint> member_point_list = this.<Point, QPoint>createList("member_point_list", Point.class, QPoint.class, PathInits.DIRECT2);

    public final ListPath<Reply, QReply> member_reply_list = this.<Reply, QReply>createList("member_reply_list", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final ListPath<OrderDetails, QOrderDetails> order_member_list = this.<OrderDetails, QOrderDetails>createList("order_member_list", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Recipe, QRecipe> recipe_list = this.<Recipe, QRecipe>createList("recipe_list", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public final EnumPath<MemberRole> role = createEnum("role", MemberRole.class);

    public final StringPath userid = createString("userid");

    public final ListPath<WishList, QWishList> wishlist_list = this.<WishList, QWishList>createList("wishlist_list", WishList.class, QWishList.class, PathInits.DIRECT2);

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

