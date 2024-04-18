package com.example.FP.repository;

import com.example.FP.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

    @Query(value = "select IFNULL(max(reply_id),0)+1 from reply", nativeQuery = true)
    Long nextReplyId();

    @Query(value = "select * from reply where ingredient_id=?1",nativeQuery = true)
    List<Reply> findAllByIngredientReply(Long ingredientId);
}
