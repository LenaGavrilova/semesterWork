function loadMore() {
    let amount = document.getElementsByClassName("product").length;
    $.ajax({
        url: "loadMore",
        type: "get",
        data: {
            exits: amount
        },
        success: function (data) {
            var row = document.getElementById("content");
            row.innerHTML += data;
        },
        error: function () {
            alert("Error");
        }
    });
}

function searchByName(param) {
    let txtSearch = param.value;
    $.ajax({
        url: "searchAjax",
        type: "get",
        data: {
            txt: txtSearch
        },
        success: function (data) {
            var row = document.getElementById("content");
            row.innerHTML = data;
        },
        error: function () {
            alert("Error");
        }
    });
}