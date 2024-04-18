function insertReply() {
    var gradeStar = $("input[name=gradeStar]:checked").val()
    var replyContent = $(".replyContent").val()
    var ingredientId = $(".ingredientId").val()
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
            recipeId: 0,
            ingredientId: ingredientId
        },
        type: "POST",
        success: function () {
            location.replace("/ingredientDetail?ingredientId=" + ingredientId)
        }
    })
}

function deleteReply(num) {
    Swal.fire({
        title: "후기 삭제",
        text: "해당 후기를 정말 삭제하시겠습니까?",
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

function cartAdd(ingredientId) {
    Swal.fire({
        title: "장바구니",
        text: "해당 상품을 장바구니에 추가하겠습니까?",
        imageUrl: "../static/images/image_11.png",
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonText: '추가',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url: "/insertCart",
                type: "POST",
                data: {ingredientId: ingredientId},
                success: function () {
                    Swal.fire({
                        title: "장바구니 추가 완료!!",
                        text: "장바구니로 이동하시겠습니까?",
                        imageUrl: "../static/images/image_11.png",
                        imageAlt: "Custom image",
                        showCancelButton: true,
                        confirmButtonText: '이동',
                        cancelButtonText: '취소'
                    }).then((result) => {

                    })
                }
            })
        } else {
        }
    });
}
