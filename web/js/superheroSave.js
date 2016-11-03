$(function() {
    $('#saveSuperhero').submit(function () {
        $.ajax({
            url: $('#saveSuperhero').attr('action'),
            type: "POST",
            data: $('#saveSuperhero').serialize(),
            success: function () {
                $("#addSuperheroModal").modal('toggle');
                $("#addSuperheroSuccess").fadeTo(2000, 500).slideUp(500, function () {
                    $("#addSuperheroSuccess").slideUp(500);
                });
            },
            error: function () {
                $("#addSuperheroModal").modal('toggle');
                $("#addSuperheroError").fadeTo(2000, 500).slideUp(500, function () {
                    $("#addSuperheroError").slideUp(500);
                });
            }
        });
        return false;
    });
});