var curVRPage = 1;
var totalVRcnt = 0;

function getViewRecipeList(page) {
    if ($("#rRecipContDivPage_" + page).length > 0) {
        $("[id^='rRecipContDivPage_']").hide();
        $("#rRecipContDivPage_" + page).show();
        curVRPage = page;
        return;
    }
    var rvArr = storageUtil.get('stRecentViewRecipe');
    if (!rvArr || rvArr == 'FAIL') {
        $("#recentRecipeDiv").hide();
        return;
    }
    totalVRcnt = rvArr.length;
    var scale = 6;
    var skip = (page - 1) * scale;
    var lastpage = Math.ceil(totalVRcnt / scale);
    var hstr = '';
    hstr += '<div id="rRecipContDivPage_' + page + '" class="row">';
    if (page > 1) hstr += '<a href="javascript:void(0);" class="list_btn_pre" onClick="getViewRecipeList(' + (page - 1) + ')"><img src="https://recipe1.ezmember.co.kr/img/btn_arrow1_l.png" alt="이전"></a>';
    if (page < lastpage) hstr += '<a href="javascript:void(0);" class="list_btn_next" onClick="getViewRecipeList(' + (page + 1) + ')"><img src="https://recipe1.ezmember.co.kr/img/btn_arrow1_r.png" alt="다음"></a>';
    for (var i = skip; i < skip + scale; i++) {
        var rvs = rvArr[i];
        if (!rvs) continue;
        hstr += '<div class="col-xs-2">';
        hstr += '<a class="thumbnail" href="https://www.10000recipe.com/recipe/' + rvs.seq + '"><img src="' + rvs.thumb + '" style="width:180px; height:180px;">';
        hstr += '<div class="caption elipsis_rrtitle"><b>' + rvs.title + '</b></div></a>';
        hstr += '</div>';
    }
    hstr += '</div>';
    if (page != 1 && curVRPage > page) $("#recentRecipeContDiv").prepend(hstr);
    else $("#recentRecipeContDiv").append(hstr);
    getViewRecipeList(page);
    $(".elipsis_rrtitle").ellipsis({row: 2});
}

$(document).ready(function () {
    getViewRecipeList(1);
})