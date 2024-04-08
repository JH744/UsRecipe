package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipe is a Querydsl query type for Recipe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipe extends EntityPathBase<Recipe> {

    private static final long serialVersionUID = -80841786L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipe recipe = new QRecipe("recipe");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Alarm, QAlarm> recipeAlarm = this.<Alarm, QAlarm>createList("recipeAlarm", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final ListPath<Cart, QCart> recipeCartList = this.<Cart, QCart>createList("recipeCartList", Cart.class, QCart.class, PathInits.DIRECT2);

    public final QRecipeCategory recipeCategory;

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipeIngredientList = this.<RecipeIngredient, QRecipeIngredient>createList("recipeIngredientList", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public final QMember recipeMember;

    public final ListPath<RecipeOrder, QRecipeOrder> recipeRecipeOrderList = this.<RecipeOrder, QRecipeOrder>createList("recipeRecipeOrderList", RecipeOrder.class, QRecipeOrder.class, PathInits.DIRECT2);

    public final ListPath<Reply, QReply> recipeReplyList = this.<Reply, QReply>createList("recipeReplyList", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath recipeThumbnail = createString("recipeThumbnail");

    public final StringPath recipeTitle = createString("recipeTitle");

    public final StringPath recipeUrl = createString("recipeUrl");

    public final NumberPath<Integer> recipeViews = createNumber("recipeViews", Integer.class);

    public final StringPath recipeWriter = createString("recipeWriter");

    public final ListPath<WishList, QWishList> wishlistList = this.<WishList, QWishList>createList("wishlistList", WishList.class, QWishList.class, PathInits.DIRECT2);

    public QRecipe(String variable) {
        this(Recipe.class, forVariable(variable), INITS);
    }

    public QRecipe(Path<? extends Recipe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecipe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecipe(PathMetadata metadata, PathInits inits) {
        this(Recipe.class, metadata, inits);
    }

    public QRecipe(Class<? extends Recipe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recipeCategory = inits.isInitialized("recipeCategory") ? new QRecipeCategory(forProperty("recipeCategory")) : null;
        this.recipeMember = inits.isInitialized("recipeMember") ? new QMember(forProperty("recipeMember")) : null;
    }

}

