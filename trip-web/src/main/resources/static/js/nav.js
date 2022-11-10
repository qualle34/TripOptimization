$(document).ready(function () {
    $("#prev-btn").click(function () {

        let page = parseInt(new URLSearchParams(window.location.search).get("page"));

        if (isNaN(page) || page === 0) {
            page = 1;
        }

        location.href= "http://localhost:8081" + window.location.pathname + "?page=" + (page - 1);
    });
});

$(document).ready(function () {
    $("#next-btn").click(function () {

        let page = parseInt(new URLSearchParams(window.location.search).get("page"));

        if (isNaN(page)) {
            page = 0;
        }

        location.href= "http://localhost:8081" + window.location.pathname + "?page=" + (page + 1);
    });
});
