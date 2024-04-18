function insertReply() {
    var gradeStar = $("input[name=gradeStar]:checked").val()
    var replyContent = $(".replyContent").val()
    var recipeId = $(".recipeId").val()
    console.log(replyContent)
    if (gradeStar === undefined) {
        checkReply("별점을 입력해주세요!");
        return false;
    }
    if (replyContent === "") {
        checkReply("댓글 내용을 입력해주세요!");
        return false;
    }

    $.ajax({
        url: "/insertReply",
        data: {
            gradeStar: gradeStar,
            replyContent: replyContent,
            recipeId: recipeId,
            ingredientId:0
        },
        type: "POST",
        success: function () {
            location.replace("/detailRecipe?recipeNum=" + recipeId)
        }
    })
}

function checkReply(msg) {
    Swal.fire({
        title: msg,
        icon: "warning"
    })
}

function deleteReply(num) {
    Swal.fire({
        title: "댓글 삭제",
        text: "해당 댓글을 정말 삭제하시겠습니까?",
        imageUrl: "../static/images/image_11.png",
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "/deleteReply",
                type: "POST",
                data: {replyId: num},
                success: function () {
                    var prevCount = $("#recipeCommentListCount").text()
                    $("#replyDiv_" + num).remove();
                    $("#recipeCommentListCount").text(prevCount - 1)
                }
            })
        } else {
        }
    });
}

function deleteRecipe(num) {
    Swal.fire({
        title: "레시피 게시글 삭제",
        text: "해당 레시피를 정말 삭제하시겠습니까?",
        icon: "warning",
        showCancelButton: true,
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "/deleteRecipe?recipeId=" + num,
                type: "get",
                success: function () {
                    Swal.fire({
                        title: "삭제되었습니다.",
                        imageUrl: "../static/images/image_11.png",
                        imageAlt: "Custom image",
                    }).then((result) => {
                        location.replace("/listRecipe/1")
                    })
                }
            })
        } else {
        }
    });
}
