package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCart is a Querydsl query type for Cart
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCart extends EntityPathBase<Cart> {

    private static final long serialVersionUID = 477677400L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCart cart = new QCart("cart");

    public final QIngredient cart_ingredient;

    public final QMember cart_member;

    public final QRecipe cart_recipe;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QCart(String variable) {
        this(Cart.class, forVariable(variable), INITS);
    }

    public QCart(Path<? extends Cart> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCart(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCart(PathMetadata metadata, PathInits inits) {
        this(Cart.class, metadata, inits);
    }

    public QCart(Class<? extends Cart> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart_ingredient = inits.isInitialized("cart_ingredient") ? new QIngredient(forProperty("cart_ingredient"), inits.get("cart_ingredient")) : null;
        this.cart_member = inits.isInitialized("cart_member") ? new QMember(forProperty("cart_member")) : null;
        this.cart_recipe = inits.isInitialized("cart_recipe") ? new QRecipe(forProperty("cart_recipe"), inits.get("cart_recipe")) : null;
    }

}

