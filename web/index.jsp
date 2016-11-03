<%--Created by IntelliJ IDEA.
  User: Maik
  Date: 29/10/16
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Superheroes Database Manager</title>
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <script src="js/jquery-3.1.1.min.js"></script>
      <script src="js/duplicate.js"></script>
      <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
      <div class="container-fluid">
        <h1>Welcome!</h1>
        <input type="button" onclick="location.href='/rest/resources/superheroes';" value="Get All Superheroes" />
        <form id="getSuperhero3423423423423" action="/rest/resources/superhero" method="get">
            Superhero to find:
            <input type="text" name="superheroName">
            <input type="submit" value="Find Superhero">
        </form>
        <form id="saveSuperhero" action="/rest/resources/save" method="post">
            Name:
            <input type="text" name="superheroName"><br>
            Pseudonym:
            <input type="text" name="superheroPseudonym"><br>
            Publisher:
            <input type="text" name="superheroPublisher"><br>
            Date of first appearance:
            <input type="date" name="superheroDateOfFirstAppearance"><br>
            <div id="allies">
                Allies:
                <div class="allies">
                    <input type="text" name="superheroAllies"><button class="remove">x</button><br>
                </div>
            </div>
            <button id="addAlly">Add Ally</button><br>
            <div id="powers">
                Powers:
                <div class="powers">
                    <input type="text" name="superheroPowers"><button class="remove">x</button><br>
                </div>
            </div>
            <button id="addPower">Add Power</button><br>
            <input type="submit" value="Save Superhero">
        </form>

        <div class="btn-group" role="group" aria-label="...">
            <button type="button" class="btn btn-default" onclick="location.href='/rest/resources/superheroes';">Get All Superheroes</button>
            <button type="button" class="btn btn-default" data-toggle="modal" data-target="#findSuperheroModal">Find Superhero</button>
            <button type="button" class="btn btn-default">Add Superhero</button>
        </div>

      <div class="modal fade" id="findSuperheroModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-dialog">
              <div class="modal-content">
                  <!-- Modal Header -->
                  <div class="modal-header">
                      <button type="button" class="close"
                              data-dismiss="modal">
                          <span aria-hidden="true">&times;</span>
                          <span class="sr-only">Close</span>
                      </button>
                      <h4 class="modal-title" id="myModalLabel">
                          Find your favourite superhero
                      </h4>
                  </div>

                  <!-- Modal Body -->
                  <div class="modal-body">
                      <form class="form-inline" role="form" id ="getSuperhero" action="/rest/resources/superhero" method="get">
                          <div class="form-group">
                              <label  class="col-sm-2 control-label" for="superheroName">Name:</label>
                          </div>
                          <div class="form-group">
                              <div class="col-sm-10">
                                  <input type="text" class="form-control" id="superheroName" placeholder="Type superhero's name" name="superheroName"/>
                              </div>
                          </div>
                          <input type="submit" class="btn btn-primary" value="Find Superhero">
                      </form>
                  </div>
              </div>
          </div>
      </div>
    </div>

  <script>
      $('#saveSuperhero').submit(function() {
          $.ajax({
              url: $('#saveSuperhero').attr('action'),
              type: "POST",
              data : $('#saveSuperhero').serialize(),
              success: function() {
                  alert("Superhero correctly saved");
              },
              error: function() {
                  alert("Error saving the superhero");
              }
          });
          return false;
      });
  </script>
  </body>
</html>
