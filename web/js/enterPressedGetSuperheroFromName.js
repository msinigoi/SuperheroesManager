$(document).on("keyup", "#superheroName", function () {
    if (event.keyCode == 13) {
        $("#getSuperheroButton").click();
    }
});