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

    public final ListPath<Alarm, QAlarm> recipe_alarm = this.<Alarm, QAlarm>createList("recipe_alarm", Alarm.class, QAlarm.class, PathInits.DIRECT2);

    public final ListPath<Cart, QCart> recipe_cart_list = this.<Cart, QCart>createList("recipe_cart_list", Cart.class, QCart.class, PathInits.DIRECT2);

    public final QRecipeCategory recipe_category;

    public final ListPath<RecipeIngredient, QRecipeIngredient> recipe_ingredient_list = this.<RecipeIngredient, QRecipeIngredient>createList("recipe_ingredient_list", RecipeIngredient.class, QRecipeIngredient.class, PathInits.DIRECT2);

    public final QMember recipe_member;

    public final ListPath<RecipeOrder, QRecipeOrder> recipe_recipe_order_list = this.<RecipeOrder, QRecipeOrder>createList("recipe_recipe_order_list", RecipeOrder.class, QRecipeOrder.class, PathInits.DIRECT2);

    public final ListPath<Reply, QReply> recipe_reply_list = this.<Reply, QReply>createList("recipe_reply_list", Reply.class, QReply.class, PathInits.DIRECT2);

    public final StringPath recipe_thumbnail = createString("recipe_thumbnail");

    public final StringPath recipe_title = createString("recipe_title");

    public final StringPath recipe_url = createString("recipe_url");

    public final NumberPath<Integer> recipe_views = createNumber("recipe_views", Integer.class);

    public final StringPath recipe_writer = createString("recipe_writer");

    public final ListPath<WishList, QWishList> wishlist_list = this.<WishList, QWishList>createList("wishlist_list", WishList.class, QWishList.class, PathInits.DIRECT2);

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
        this.recipe_category = inits.isInitialized("recipe_category") ? new QRecipeCategory(forProperty("recipe_category")) : null;
        this.recipe_member = inits.isInitialized("recipe_member") ? new QMember(forProperty("recipe_member")) : null;
    }

}

