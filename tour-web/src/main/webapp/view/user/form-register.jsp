
<head>
	
	<link rel="stylesheet" type="text/css" href="resource/css/form-register-css.css">
	
</head>

<div class="register">
    <div class="top_register">
    <a class="btn btn-link" href="#" role="button">
    <!-- Trigger/Open The Modal -->
        <button id="my_register" class="">Register</button>
    </a>
</div>
    <!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    
    <div class="box">
                <span class="close">×</span>
                    <div class="login">
                                <div class="name-login">
                                     <h3>JOIN TOURSTUDENT NOW</h3>
                                </div>
                        <br>
                        <hr>
                        <form >

                            <div class="username">
                                <input type="text" name="username" placeholder="Full Name">
                            </div>

                            <input type="email" name="email" placeholder="Email">
                            <div class="phone-css">
                                <input class="text" type="text" name="phone" placeholder="Phone">
                            </div>
                                <input type="password" name="password" placeholder="Password">
                            <div class="form-date">
                                    <span>
                                        <div class="row">
                                        <div class="col-md-4" id="day-form-date">
                                            <select aria-label="Day" name="birthday_day" id="day" title="Day" class="_5dba">
                                                <option value="0" selected="1">Day</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                                <option value="11">11</option>
                                                <option value="12">12</option>
                                                <option value="13">13</option>
                                                <option value="14">14</option>
                                                <option value="15">15</option>
                                            </select>
                                        </div>
                                        <div class="col-md-4" id="month-form-date">
                                            <select aria-label="month" name="birthday_month" id="month" title="Month" class="_5dba">
                                                <option value="0" selected="1">Month</option>
                                                <option value="1">Month 1</option>
                                                <option value="2">Month 2</option>
                                                <option value="3">Month 3</option>
                                                <option value="4">Month 4</option>
                                                <option value="5">Month 5</option>
                                                <option value="6">Month 6</option>
                                            </select>
                                        </div>
                                        <div class="col-md-4" id="year-form-date">
                                            <select aria-label="year" name="birthday_year" id="year" title="Year" class="_5dba">
                                                <option value="0" selected="1">Year</option>
                                                <option value="2016">2016</option>
                                                <option value="2015">2015</option>
                                                <option value="2014">2014</option>
                                            </select>
                                        </div>
                                        </div>
                                    </span>
                            </div>

                                    <!--<label for="birthDate" class="col-sm-4 control-label">Date of Birth</label>-->
                                    <!--<div class="col-sm-7">-->
                                        <!--<input type="date" id="birthDate" class="form-control">-->
                                    <!--</div>-->
                                    <!--<div class="col-md-1"></div>-->
                                <div class="row">
                                    <!--<div class="col-md-4">-->
                                        <!--<form id="form-birthday">-->
                                            <!--<input type="date" name="bday">-->
                                        <!--</form>-->
                                    <!--</div>-->

                                    <div class="col-md-6">
                                        <label class="checkbox-inline">
                                             <input type="checkbox" id="choose-male" value="option1"> Male
                                         </label>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="checkbox-inline">
                                             <input type="checkbox" id="choose-female" value="option1"> Female
                                         </label>
                                    </div>
                                </div>
                                    <p class="role">
                                        By clicking Create an account, you agree to our Terms and <br>
                                        that you have read our Data Policy, including our Cookie Use.
                                    </p>

                                        <button type="button" id="join"  class="btn btn-info btn-xs">JOIN TOURSTUDENT</button>






                        </form>
                    </div>
            </div>
</div>
</div>
</div>
</div>

<script>
// Get the modal
var modal = document.getElementById('myModal');

// Get the button that opens the modal
var btn = document.getElementById("my_register");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

