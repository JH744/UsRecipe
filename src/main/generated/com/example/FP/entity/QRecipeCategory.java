package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecipeCategory is a Querydsl query type for RecipeCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipeCategory extends EntityPathBase<RecipeCategory> {

    private static final long serialVersionUID = 1591111396L;

    public static final QRecipeCategory recipeCategory = new QRecipeCategory("recipeCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath recipeCategoryName = createString("recipeCategoryName");

    public final ListPath<Recipe, QRecipe> recipeList = this.<Recipe, QRecipe>createList("recipeList", Recipe.class, QRecipe.class, PathInits.DIRECT2);

    public QRecipeCategory(String variable) {
        super(RecipeCategory.class, forVariable(variable));
    }

    public QRecipeCategory(Path<? extends RecipeCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecipeCategory(PathMetadata metadata) {
        super(RecipeCategory.class, metadata);
    }

}

