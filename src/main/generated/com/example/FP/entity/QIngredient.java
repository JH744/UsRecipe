package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIngredient is a Querydsl query type for Ingredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIngredient extends EntityPathBase<Ingredient> {

    private static final long serialVersionUID = 477148169L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIngredient ingredient = new QIngredient("ingredient");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> ingredient_amount = createNumber("ingredient_amount", Integer.class);

    public final ListPath<Cart, QCart> ingredient_cart_list = this.<Cart, QCart>createList("ingredient_cart_list", Cart.class, QCart.class, PathInits.DIRECT2);

    public final QIngredientCategory ingredient_ingredient_category;

    public final StringPath ingredient_name = createString("ingredient_name");

    public final ListPath<OrderDetails, QOrderDetails> ingredient_orderdetail_list = this.<OrderDetails, QOrderDetails>createList("ingredient_orderdetail_list", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final StringPath ingredient_origin = createString("ingredient_origin");

    public final NumberPath<Integer> ingredient_qty = createNumber("ingredient_qty", Integer.class);

    public final ListPath<Reply, QReply> ingredient_reply_list = this.<Reply, QReply>createList("ingredient_reply_list", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath ingredient_unit = createString("ingredient_unit");

    public final NumberPath<Integer> ingredientPrice = createNumber("ingredientPrice", Integer.class);

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipe_ingredient_list = this.<RecipeIngredient, QRecipeIngredient>createList("recipe_ingredient_list", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public QIngredient(String variable) {
        this(Ingredient.class, forVariable(variable), INITS);
    }

    public QIngredient(Path<? extends Ingredient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIngredient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIngredient(PathMetadata metadata, PathInits inits) {
        this(Ingredient.class, metadata, inits);
    }

    public QIngredient(Class<? extends Ingredient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ingredient_ingredient_category = inits.isInitialized("ingredient_ingredient_category") ? new QIngredientCategory(forProperty("ingredient_ingredient_category")) : null;
    }

}

