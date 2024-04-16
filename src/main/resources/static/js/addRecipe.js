var ingredientIndex = 1

// 재료 그룹들의 정보를 모아 list 형태로 반환
function ingeredientData() {
    var ingredientGroupList = [];
    ingredientGroupList = $("#ingredientInfo").find(".ingredientGroup");
    var isnull = false;
    var ingredientDataList = [];
    $.each(ingredientGroupList, function () {
        var recipeIngredientNeed = $(this).find(".ingredientName").val()
        var recipeIngredientQty = $(this).find(".ingredientQty").val()
        var recipeIngredientUnit = $(this).find(".ingredientUnit").val()
        var recipeIngredientId = $(this).find(".ingredientId").val()
        if (recipeIngredientNeed === "" || recipeIngredientQty === "" ||
            recipeIngredientUnit === "") {
            isnull = true;
            return false;
        }
        var ingredientDataListItem = {
            'recipeIngredientNeed': recipeIngredientNeed,
            'recipeIngredientQty': recipeIngredientQty,
            'recipeIngredientUnit': recipeIngredientUnit,
            'recipeIngredientId': recipeIngredientId
        }
        ingredientDataList.push(ingredientDataListItem)
    })
    if (isnull) {
        return null;
    } else {
        return ingredientDataList;
    }
}

// 요리순서 그룹들의 정보를 모아 list 형태로 반환
function stepData() {
    var recipeStepList = [];
    var isnull = false;
    recipeStepList = $("#divStepArea").find(".step");
    var stepDataList = [];
    $.each(recipeStepList, function () {
        var recipeDetail = $(this).find(".step_text").val()
        var recipePhoto = $(this).find(".step_photo_url").val()
        if (recipeDetail === "" || recipePhoto === "") {
            isnull = true;
            return false;
        }
        var stepDataListItem = {
            'recipeDetail': recipeDetail,
            'recipePhoto': recipePhoto
        }
        stepDataList.push(stepDataListItem)
    })
    if (isnull) {
        return null;
    } else {
        return stepDataList;
    }
}

// 재료 목록 추가
function addIngredient() {
    var ingredientFrame =
        "<li class='ingredientGroup' id='ingredientGroup_" + ingredientIndex + "'>" +
        "<button type='button' class='btn btn-primary' data-bs-toggle='modal' data-bs-target='#exampleModal' id='ingredientModalBtn'>" +
        "재료 선택" +
        "</button>" +
        "<input name=\"ingredientCategory\" class=\"ingredientCategory\" readonly='' value='-분류-' style='color:#898989'>" +
        "<input name=\"ingredientName\" class=\"ingredientName\" value='-재료명-' readonly='' style='color:#898989'>\n" +
        "<input type=\"number\" class=\"ingredientQty form-control\" style=\"width:100px;\" placeholder=\"10(수량)\"/>\n" +
        "<input type=\"text\" class=\"ingredientUnit form-control\" style=\"width:140px;\" placeholder=\"예) g,ml(단위)\"/>\n" +
        "<input type='hidden' name='ingredientId' class='ingredientId'>" +
        "<a  href='javascript:delIngredient(" + ingredientIndex + ")' class=\"btn-del\" style=''></a></li>"

    $("#ingredientInfo").append(ingredientFrame)
    ingredientIndex = ingredientIndex + 1
}

var stepIndex = 2

// 요리 순서 추가
function addStep() {
    var stepFrame =
        '<div id="divStepItem_' + stepIndex + '" class="step">' +
        '    <p class="cont_tit2_1 ui-sortable-handle" style="cursor:pointer"' +
        '        data-original-title="" title="">Step' + stepIndex + '</p>' +
        '    <div style="display:inline-block">' +
        '        <textarea name="step_text" class="step_text form-control step_cont"' +
        '            placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요."' +
        '            style="height:160px; width:430px; resize:none;"></textarea>' +
        '    </div>' +
        '    <div id="divStepUpload_' + stepIndex + '" class="divStepUpload" style="display:inline-block">' +
        '        <input type="hidden" class="step_photo_url" name="step_photo_url_" id="step_photo_url_' + stepIndex + '" value="">' +
        '        <div class="step_photo_file_div" style="position:absolute;left:-3000px">' +
        '           <input type="file"' +
        '            name="step_photo_file_' + stepIndex + '"' +
        '            id="step_photo_file_' + stepIndex + '"' +
        '            file_gubun="step"' +
        '            accept="jpeg,png,gif"' +
        '            style="display:none;width:0px;height:0px;font-size:0px;"' +
        '           text="">' +
        '       </div>' +
        '        <div is_over="0" class="step_thumbnail_div">' +
        '            <img id="stepPhotoHolder_' + stepIndex + '" class="stepPhotoHolder" onclick="browseStepFile(' + stepIndex + ')"' +
        '                src="../static/images/pic_none2.gif" width="160"' +
        '                height="160"' +
        '            style="cursor:pointer">' +
        '        </div>' +
        '   </div>' +
        '   <div id="divStepBtn_' + stepIndex + '" class="step_btn" style="display:">' +
        '        <a href="javascript:delStep(' + stepIndex + ')"><span class="glyphicon glyphicon-remove"></span></a>' +
        '   </div>' +
        '</div>'

    $("#divStepArea").append(stepFrame)
    stepIndex = stepIndex + 1
}

function delStep(idx) {
    Swal.fire({
        title: "요리순서 삭제",
        text: "해당 요리 순서를 정말 삭제하시겠습니까?",
        imageUrl: "../static/images/image_11.png",
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            var step_photo_url = "#step_photo_url_" + idx
            deletePhotoFiles($(step_photo_url).val())

            var divStep = $("#divStepItem_" + idx);
            var nextDivs = []
            nextDivs = divStep.nextAll()
            if (nextDivs.length === 0) {
                stepIndex = 2;
            }
            $.each(nextDivs, function (num) {
                var index = parseInt(idx) + parseInt(num)
                var divStepUpload = $(this).children(".divStepUpload")
                $(this).attr("id", "divStepItem_" + index)
                $(this).children("p").text("Step" + index)
                $(divStepUpload).attr("id", "divStepUpload_" + index)
                $(divStepUpload).children(".step_photo_url").attr("id", "step_photo_url_" + index)
                $(divStepUpload).children(".step_photo_file_div").children("input").attr("id", "step_photo_file_" + index).attr("name", "step_photo_file_" + index)
                $(divStepUpload).children(".step_thumbnail_div").children("img").attr("id", "stepPhotoHolder_" + index).attr("onclick", "browseStepFile('" + index + "')")
                $(this).children(".stepPhotoHolder").attr("id", "stepPhotoHolder_" + index)
                $(this).children(".step_btn").attr("id", "divStepBtn_" + index)
                $(this).children(".step_btn").children("a").attr('href', "javascript:delStep('" + index + "')")
                stepIndex = index + 1;
            })
            divStep.remove()
        } else {
        }
    });
}

// 재료 선택 버튼 누르면 해당 재료 목록 그룹의 div id를 가져와 ingredientGroup_id변수에 저장한다.
var ingredientGroup_id
$(document).on('click', "#ingredientModalBtn", function () {
    ingredientGroup_id = "#" + $(this).parent().attr('id')
})

// 재료 선택 후 저장을 누르면 해당 재료 그룹에 선택한 재료 정보가 입력된다.
$(document).on('click', "#ingredient_modal_save", function () {
    var ingredientName = $("input[name=ingredient_radio]:checked").prev().text()
    var ingredientCategory = $("input[name=ingredient_radio]:checked").prev().prev().text()
    var ingredient_id = $("input[name=ingredient_radio]:checked").next().val()
    $(ingredientGroup_id).children(".ingredientCategory").val(ingredientCategory).css('color', '').css('font-weight', 'bold')
    $(ingredientGroup_id).children(".ingredientName").val(ingredientName).css('color', '').css('font-weight', 'bold')
    $(ingredientGroup_id).children(".ingredientId").val(ingredient_id)
})

// 재료 목록 삭제
function delIngredient(index) {
    Swal.fire({
        title: "재료 목록 삭제",
        text: "해당 재료 목록을 정말 삭제하시겠습니까?",
        imageUrl: "../static/images/image_11.png",
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonText: '삭제',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            var ingredientGroup = "#ingredientGroup_" + index;
            $("li").remove(ingredientGroup);
        } else {
        }
    })
}

// 재료 목록에서 radio 버튼이 아니라 해당 radio 버튼의 라인을 눌러도 radio가 체크됨
$(document).on('click', '.modal_IngredientSelect', function () {
    var checkbox = $(this).find('input');
    $(this).find('input').prop('checked', true)
})

// divMainPhotoBox를 누르면 input태그가 눌린 효과를 넣음
function browseMainFile() {
    $("#q_main_file").click();
    $("#divMainPhotoUpload").off().on('change', "#q_main_file", {
        inputTagId: "#q_main_file",
        imgBoxTagId: '#mainPhotoHolder',
        imgUrlSaveTagId: "#recipe_thumbnail"
    }, handlePhotoFiles)
}

//stepPhotoHolder를 클릭하면 input태그가 눌린 효과를 넣음
function browseStepFile(idx) {
    var step_photo_file = "#step_photo_file_" + idx
    $(step_photo_file).click();
    var step_photo_url = "#step_photo_url_" + idx
    var stepPhotoHolder = "#stepPhotoHolder_" + idx
    $(".step").off().on('change', step_photo_file, {
        inputTagId: step_photo_file,
        imgBoxTagId: stepPhotoHolder,
        imgUrlSaveTagId: step_photo_url
    }, handlePhotoFiles)
}


// 이미지 파일 삭제
function deletePhotoFiles(fileName) {
    $.ajax({
        data: {fileName: fileName},
        type: "POST",
        url: "/deleteRecipePhoto"
    })
}

function handlePhotoFiles(tag) {
    var image = $(tag.data.inputTagId)[0].files
    data = new FormData();
    data.append("file", image[0]);
    var fileName = $(tag.data.imgUrlSaveTagId).val();
    if (fileName !== null && fileName !== "") {
        deletePhotoFiles(fileName);
    }

    $.ajax({
        data: data,
        type: "POST",
        url: "/uploadRecipePhoto",
        contentType: false,
        processData: false,
        success: function (data) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $(tag.data.imgBoxTagId).attr('src', e.target.result); // 이미지 미리보기 설정
            };
            reader.readAsDataURL(image[0]); // 파일을 읽어서 Data URL로 변환하여 이미지에 적용
            $(tag.data.imgUrlSaveTagId).val(data.url)
        }
    });
}

// 모달창에서 엔터 누르면 검색 되는 함수
$(document).on('keyup', '#keyword', function enter_search(e) {
    const code = e.keyCode;

    if (code === 13) {
        $("#ingredientSearchBtn").click();
    }
})

//재료 검색 ajax 통신 함수
function searchIngredient() {
    $("#ingredientList").empty()
    var keyword = $("#keyword").val()
    data = {keyword: keyword};
    $.ajax({
        data: data,
        type: 'POST',
        url: '/searchIngredient',
        success: function (list) {
            $.each(list, function () {
                var ingredientCategoryName = this.ingredientIngredientCategory.ingredientCategoryName
                var ingredientName = this.ingredientName
                var ingredient_id = this.id
                var li = '<li class="modal_IngredientSelect">' +
                    '<div class="cell">' + ingredientCategoryName + '</div>' +
                    '<div class="cell">' + ingredientName + '</div>' +
                    '<input type="radio" name="ingredient_radio" class="cell"/>' +
                    '<input type="hidden" name="ingredient_id" value="' + ingredient_id + '"/>' +
                    '</li>'
                $("#ingredientList").append($(li));
            });
        }
    })
}

// 레시피 게시글 저장
function doSubmit() {
    Swal.fire({
        title: "레시피 저장",
        text: "레시피를 저장하시겠습니까?",
        imageUrl: "../static/images/image_11.png",
        imageAlt: "Custom image",
        showCancelButton: true,
        confirmButtonText: '저장',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            var ingredientDataList = ingeredientData();
            var stepDataList = stepData();
            var recipeTitle = $("#recipe_title").val()
            var recipeCategory = $("#recipeCategory").val()
            var recipeThumbnail = $("#recipe_thumbnail").val()
            if (recipeTitle === "") {
                inputCheck("레시피 제목(을)")
                return false;
            }
            if (recipeThumbnail === "") {
                inputCheck("요리 대표 사진(을)")
                return false;
            }
            if (recipeCategory === "none") {
                inputCheck("레시피 카테고리")
                return false;
            }
            if (ingredientDataList === null) {
                inputCheck("재료 목록(을)")
                return false;
            }
            if (stepDataList === null) {
                inputCheck("요리 순서")
                return false;
            }
            var recipeData = {
                ingredientDataList: ingredientDataList,
                stepDataList: stepDataList,
                recipeTitle: recipeTitle,
                recipeCategory: recipeCategory,
                recipeThumbnail: recipeThumbnail
            }
            var recipeDataList = {
                "recipeDataList": JSON.stringify(recipeData)
            }
            $.ajax({
                url: '/saveRecipe',
                data: recipeDataList,
                type: "POST",
                success:function(){
                    Swal.fire({
                        title:"저장되었습니다.",
                        imageUrl: "../static/images/image_11.png",
                        imageAlt: "Custom image",
                    }).then((result)=>{
                        location.href="/"
                    })
                }
            })
        } else {
        }
    })
}

function inputCheck(msg) {
    Swal.fire({
        title: msg + "를 <br>제대로 입력해주세요!!",
        icon: "warning"
    })
}