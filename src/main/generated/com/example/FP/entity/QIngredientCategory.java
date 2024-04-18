package com.example.FP.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QIngredientCategory is a Querydsl query type for IngredientCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIngredientCategory extends EntityPathBase<IngredientCategory> {

    private static final long serialVersionUID = 130137127L;

    public static final QIngredientCategory ingredientCategory = new QIngredientCategory("ingredientCategory");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath ingredientCategoryName = createString("ingredientCategoryName");

    public QIngredientCategory(String variable) {
        super(IngredientCategory.class, forVariable(variable));
    }

    public QIngredientCategory(Path<? extends IngredientCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QIngredientCategory(PathMetadata metadata) {
        super(IngredientCategory.class, metadata);
    }

}

