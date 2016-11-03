$(function() {

    $("#addAlly").on("click", function () {
        $(".allies").last().clone(true, true).insertAfter("#allies");
        return false; //prevent form submission
    });
    $("#addPower").on("click", function () {
        $(".powers").last().clone(true, true).insertAfter("#powers");
        return false; //prevent form submission
    });

    $(".allies").on("click", ".remove", function () {
        if ($(".allies").length > 1) {
            $(this).parent().remove();
        }
        return false; //prevent form submission
    });
    $(".powers").on("click", ".remove", function () {
        if ($(".powers").length > 1) {
            $(this).parent().remove();
        }
        return false; //prevent form submission
    });
});