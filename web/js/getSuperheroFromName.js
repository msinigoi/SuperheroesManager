function getSuperheroFromName() {
    var superheroName = $("#superheroName");
    if (!superheroName.val()) {
        superheroName.closest('.form-group').removeClass('has-success').addClass('has-error');
        return false;
    } else {
        superheroName.closest('.form-group').removeClass('has-error').addClass('has-success');
        location.href = "/rest/resources/superheroes/" + superheroName.val();
    }
}