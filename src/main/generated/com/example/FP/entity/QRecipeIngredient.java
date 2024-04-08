package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipeIngredient is a Querydsl query type for RecipeIngredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipeIngredient extends EntityPathBase<RecipeIngredient> {

    private static final long serialVersionUID = -1453243849L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecipeIngredient recipeIngredient = new QRecipeIngredient("recipeIngredient");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QIngredient recipe_ingredient_ingredient;

    public final StringPath recipe_ingredient_need = createString("recipe_ingredient_need");

    public final NumberPath<Integer> recipe_ingredient_qty = createNumber("recipe_ingredient_qty", Integer.class);

    public final QRecipe recipe_ingredient_recipe;

    public QRecipeIngredient(String variable) {
        this(RecipeIngredient.class, forVariable(variable), INITS);
    }

    public QRecipeIngredient(Path<? extends RecipeIngredient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecipeIngredient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecipeIngredient(PathMetadata metadata, PathInits inits) {
        this(RecipeIngredient.class, metadata, inits);
    }

    public QRecipeIngredient(Class<? extends RecipeIngredient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recipe_ingredient_ingredient = inits.isInitialized("recipe_ingredient_ingredient") ? new QIngredient(forProperty("recipe_ingredient_ingredient"), inits.get("recipe_ingredient_ingredient")) : null;
        this.recipe_ingredient_recipe = inits.isInitialized("recipe_ingredient_recipe") ? new QRecipe(forProperty("recipe_ingredient_recipe"), inits.get("recipe_ingredient_recipe")) : null;
    }

}

