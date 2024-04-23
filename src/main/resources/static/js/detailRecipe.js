function insertReply() {
    var gradeStar = $("input[name=gradeStar]:checked").val()
    var replyContent = $(".replyContent").val()
    var recipeId = $(".recipeId").val()
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
            ingredientId: 0
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

function allCheck(allCheckBoxId, allStatClass, checkBoxClass) {
    if ($('.' + allStatClass).is(":checked")) {
        $('.' + checkBoxClass).prop('checked', false);
        $('.' + allStatClass).prop('checked', false);
        $('#' + allCheckBoxId).val("모두 선택").css("background", "#ffffff");
    } else {
        $('.' + checkBoxClass).prop('checked', true);
        $('.' + allStatClass).prop('checked', true);
        $('#' + allCheckBoxId).val("선택 해제").css("background", "#f5f5f5");
    }
}

// url에 따라 modal에 내용을 담을지, 장바구니에 완전하게 추가할지를 고른다
function addCart(checkBoxClass, url) {
    var checkList = [];
    $('.' + checkBoxClass).each(function (index) {
        if ($(this).is(":checked") == true) {
            checkList.push($(this).val());
        }
    })
    if (url === '/addCartList') {
        Swal.fire({
            title: "장바구니 추가",
            text: "해당 상품들을 추가하시겠습니까?",
            imageUrl: "../../static/images/image_11.png",
            imageAlt: "Custom image",
            showCancelButton: true,
            confirmButtonText: '추가',
            cancelButtonText: '취소'
        }).then((result) => {
            if (result.isConfirmed) {
                $.ajax({
                    contentType: 'application/json',
                    data: JSON.stringify(checkList),
                    type: 'POST',
                    url: url,
                    success: function () {
                        Swal.fire({
                            title: "장바구니 추가 완료!!",
                            text: "장바구니로 이동하시겠습니까?",
                            imageUrl: "../../static/images/image_11.png",
                            imageAlt: "Custom image",
                            showCancelButton: true,
                            confirmButtonText: '이동',
                            cancelButtonText: '취소'
                        }).then((result) => {
                            if(result.isConfirmed) {
                                location.replace("/cart")
                            }
                        })
                    }
                })
            } else {
            }
        });
    }else{
        $.ajax({
            contentType: 'application/json',
            data: JSON.stringify(checkList),
            type: 'POST',
            url: url,
            success: function (list) {
                listAddToModal(list)
            }
        })
    }
}


function listAddToModal(list) {
    $("#modal_tbody").empty();
    $.each(list, function () {
        var ingredientImage = $("<td class='modalListTd'><img src='../../static/ingredientImages/" + this.ingredientImage + "' style='width:50px;height: 50px'></td>");
        var ingredientName = $("<td class='modalListTd'>" + this.ingredientName + "</td>");
        var ingredientPrice = $("<td class='modalListTd'>" + this.ingredientPrice + "</td>");
        var ingredientAmountAndIngredientUnit = $("<td class='modalListTd'>" + this.ingredientAmount + this.ingredientUnit + "</td>");
        var check = $("<td class='modalListTd'><input type='checkbox' class='modalCheckBox' checked value='" + this.id + "'></td>");
        var tr = $("<tr></tr>");
        tr.append(ingredientImage)
        tr.append(ingredientName)
        tr.append(ingredientPrice)
        tr.append(ingredientAmountAndIngredientUnit)
        tr.append(check)
        $("#modal_tbody").append(tr)
    });
}

var kakaoinit = '80a967748d2aab3a8cd782d8f47b8589'

$(document).on("click",".ytp-large-play-button",function(){
    $(".centeredcrop").css("display","relative").css("z-index","1")
})

function wishCheck(){
    var $this = $(this); // 현재 요소를 $this에 저장
    var recipeItemInfo= $(this).closest('.recipeItem_info');
    var recipeId = $(".recipeId").val();
    $.ajax({
        url: '/addWish', // 요청을 보낼 서버의 URL
        type: 'POST', // HTTP 요청 방식
        data: { Id: recipeId }, // 서버로 보낼 데이터
        success: function(response) {
            // 요청이 성공했을 때 실행될 함수
            if(response ==='저장함'){
                $('.heartIcon').attr('src', '../../static/images/btn_delWish.png'); // 절대 경로 사용
            }else if(response ==='삭제함'){
                //삭제
                $('.heartIcon').attr('src', '../../static/images/btn_addWish.png'); // 절대 경로 사용
            }
        },
        error: function(xhr, status, error) {
            // 요청이 실패했을 때 실행될 함수
        }
    });
};


// 찜한 상품들은 붉은 하트를 보여줌
$(document).ready(function() {
    var id= $(".recipeId").val()
    $.ajax({
        url: '/checkWish',
        type: 'POST',
        data: { Id: id },
        success: function(response) {
            // 요청이 성공했을 때 실행될 함수
            if(response ==='저장됨') {
                //찜목록에 담겨있다면 나타낼 UI
                $(".heartIcon").attr('src', '../../static/images/btn_delWish.png');
            } else {
            }
        },
        error: function (xhr, status, error) {
        }
    });
})