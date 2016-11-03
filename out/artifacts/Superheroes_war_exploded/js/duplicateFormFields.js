$(function() {
    $("#addAlly").on("click", function () {
        $("#allies").last().clone(true, true).find("input:text").val("").end().insertAfter("#allies");
        return false;
    });
    $("#addPower").on("click", function () {
        $("#powers").last().clone(true, true).find("input:text").val("").end().insertAfter("#powers");
        return false;
    });

    $("#allies").on("click", ".remove", function () {
        if ($(".allies").length > 1) {
            $(this).parent().parent().parent().parent().parent().parent().remove();
        }
        return false;
    });
    $("#powers").on("click", ".remove", function () {
        if ($(".powers").length > 1) {
            $(this).parent().parent().parent().parent().parent().parent().remove();
        }
        return false;
    });
});