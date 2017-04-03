<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.5.8/angular-messages.js"></script>
    <script src="resource/app.js"></script>
    <title>AA</title>
</head>

<body ng-app="myApp">
    <header>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Hello ${username}</a>
                </div>
            </div>
        </nav>
    </header>
    <section>
        <div class="container">
            <div class="col-md-8">
                <div ng-controller="mainController">
                    <form name="myForm" class="form-horizontal" action="https://www.google.com.vn/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8#q=input+bootstrap+3" enctype="multipart/form-data" autocomplete="off">
                        <label>
                            Enter text:
                            <textarea class="form-control" rows="5" cols="100" ng-model="field" name="myField" required minlength="10"></textarea>
                        </label>
                        <input type="file" id="file" name="file">
                        <span ng-messages="myForm.myField.$error">
                         <div ng-message="required" class="alert alert-danger" role="alert">
                             <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span> Enter content
                </div>
                <div ng-message="minlength" class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    <span class="sr-only">Error:</span> This field must be greater than 10 characters long.
                </div>
                </span>
                <button type="button" ng-disabled="!myForm.myField.$valid" class="btn btn-success">Submit</button>
                </form>

            </div>
        </div>
        <div class="col-md-4"></div>
        </div>
    </section>
</body>
</html>