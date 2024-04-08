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

    public final NumberPath<Integer> ingredientAmount = createNumber("ingredientAmount", Integer.class);

    public final ListPath<Cart, QCart> ingredientCartList = this.<Cart, QCart>createList("ingredientCartList", Cart.class, QCart.class, PathInits.DIRECT2);

    public final QIngredientCategory ingredientIngredientCategory;

    public final StringPath ingredientName = createString("ingredientName");

    public final ListPath<OrderDetails, QOrderDetails> ingredientOrderdetailList = this.<OrderDetails, QOrderDetails>createList("ingredientOrderdetailList", OrderDetails.class, QOrderDetails.class, PathInits.DIRECT2);

    public final StringPath ingredientOrigin = createString("ingredientOrigin");

    public final NumberPath<Integer> ingredientPrice = createNumber("ingredientPrice", Integer.class);

    public final NumberPath<Integer> ingredientQty = createNumber("ingredientQty", Integer.class);

    public final ListPath<Reply, QReply> ingredientReplyList = this.<Reply, QReply>createList("ingredientReplyList", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath ingredientUnit = createString("ingredientUnit");

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipeIngredientList = this.<RecipeIngredient, QRecipeIngredient>createList("recipeIngredientList", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

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
        this.ingredientIngredientCategory = inits.isInitialized("ingredientIngredientCategory") ? new QIngredientCategory(forProperty("ingredientIngredientCategory")) : null;
    }

}

