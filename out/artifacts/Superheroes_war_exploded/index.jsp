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
      <script src="js/duplicateFormFields.js"></script>
      <script src="js/postSuperhero.js"></script>
      <script src="js/getSuperheroFromName.js"></script>
      <script src="js/bootstrap.min.js"></script>
  </head>
  <body>
  <div class="jumbotron vertical-center">
      <div class="container-fluid text-center">
            <h3>Welcome to the Superheroes Database Manager</h3>
            <p>Here you can save and load your favourite superheroes.</p>
            <div class="btn-group" role="group" aria-label="...">
                <button type="button" class="btn btn-default" onclick="location.href='/rest/resources/superheroes';">Get All Superheroes</button>
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#findSuperheroModal">Find Superhero</button>
                <button type="button" class="btn btn-default" data-toggle="modal" data-target="#addSuperheroModal">Add Superhero</button>
            </div>

              <div class="modal fade" id="addSuperheroModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <!-- Modal Header -->
                          <div class="modal-header">
                              <button type="button" class="close"
                                      data-dismiss="modal">
                                  <span aria-hidden="true">&times;</span>
                                  <span class="sr-only">Close</span>
                              </button>
                              <h4 class="modal-title" id="addSuperheroModalLabel">
                                  Add a new superhero
                              </h4>
                          </div>

                          <!-- Modal Body -->
                          <div class="modal-body">
                              <form class="form-horizontal" role="form" id="saveSuperhero" action="/rest/resources/superheroes" method="post">
                                  <div class="form-group">
                                      <label  class="col-sm-4 control-label" for="addSuperheroName">Name:</label>
                                      <div class="col-sm-8">
                                          <input type="text" class="form-control" id="addSuperheroName" name="superheroName"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-sm-4 control-label" for="addSuperheroPseudonym">Pseudonym:</label>
                                      <div class="col-sm-8">
                                          <input type="text" class="form-control" id="addSuperheroPseudonym" name="superheroPseudonym"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-sm-4 control-label" for="addSuperheroPublisher">Publisher:</label>
                                      <div class="col-sm-8">
                                          <input type="text" class="form-control" id="addSuperheroPublisher" name="superheroPublisher"/>
                                      </div>
                                  </div>
                                  <div class="form-group">
                                      <label  class="col-sm-4 control-label" for="addSuperheroDateOfFirstAppearance">Date of first appearance:</label>
                                      <div class="col-sm-8">
                                          <input type="date" class="form-control" id="addSuperheroDateOfFirstAppearance" name="superheroDateOfFirstAppearance"/>
                                      </div>
                                  </div>
                                  <div id="allies">
                                      <div class="form-group">
                                          <label  class="col-sm-4 control-label" for="addSuperheroAllies">Ally:</label>
                                          <div class="allies">
                                              <div class="col-sm-8">
                                                 <div class="input-group">
                                                      <input type="text" class="form-control" id="addSuperheroAllies" name="superheroAllies">
                                                      <span class = "input-group-btn">
                                                        <button class="btn btn-default remove">x</button>
                                                      </span>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                                  <div id="powers">
                                      <div class="form-group">
                                          <label  class="col-sm-4 control-label" for="addSuperheroPowers">Power:</label>
                                          <div class="powers">
                                              <div class="col-sm-8">
                                                <div class="input-group">
                                                    <input type="text" class="form-control" id="addSuperheroPowers" name="superheroPowers">
                                                    <span class = "input-group-btn">
                                                        <button class="btn btn-default remove">x</button>
                                                    </span>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>

                                  <!-- Modal Footer -->
                                  <div class="modal-footer">
                                      <div class="btn-group" role="group">
                                          <button class="btn btn-default" id="addAlly">Add Ally</button>
                                          <button class="btn btn-default" id="addPower">Add Power</button>
                                      </div>
                                      <input type="submit" class="btn btn-primary" value="Save Superhero">
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>
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
                              <h4 class="modal-title" id="findSuperheroModalLabel">
                                  Find your favourite superhero
                              </h4>
                          </div>

                          <!-- Modal Body -->
                          <div class="modal-body">
                              <form class="form-inline" role="form" id ="getSuperhero" action="/rest/resources/superheroes/" method="get">
                                  <div class="form-group">
                                      <label  class="col-sm-2 control-label" for="superheroName">Name:</label>
                                  </div>
                                  <div class="form-group">
                                      <div class="col-sm-10">
                                          <input type="text" class="form-control required" id="superheroName" placeholder="Type superhero's name" name="superheroName"/>
                                      </div>
                                  </div>
                              </form>
                          </div>

                          <!-- Modal Body -->
                          <div class="modal-footer">
                              <button class="btn btn-primary" id="getSuperheroButton" onclick="getSuperheroFromName()">Find Superhero</button>
                          </div>
                      </div>
                  </div>
              </div>
        </div>
      </div>
      <div class="alert alert-success" id="addSuperheroSuccess" style="display: none;">
          <button type="button" class="close" data-dismiss="alert">x</button>
          <strong>Success! </strong>
          Superhero correctly saved.
      </div>
        <div class="alert alert-danger" id="addSuperheroError" style="display: none;">
          <button type="button" class="close" data-dismiss="alert">x</button>
          <strong>Error! </strong>
          Something went wrong.
      </div>
  </body>
</html>
