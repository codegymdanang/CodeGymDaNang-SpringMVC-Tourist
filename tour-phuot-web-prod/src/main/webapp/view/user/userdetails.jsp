

<div class="profile-content-center">
      <div class="row">
     
          <div class="panel panel-info">
            <div class="panel-body">
              <div class="row">
                <div class=" col-md-9 col-lg-9 "> 
                  <table class="table table-user-information">
                    <tbody>
                      <tr>
                        <td>Date of Birth</td>
                        <td>01/24/1995</td>
                      </tr>
                   
                         <tr>
                             <tr>
                        <td>Gender</td>
                        <td>Male</td>
                      </tr>
                        <tr>
                        <td> Address</td>
                        <td>${user.diadiem }
                        <div id="diadiem"></div>
                        </td>
                      </tr>
                      <tr>
                        <td>Email</td>
                        <td><a href="mailto:info@support.com">info@support.com</a></td>
                      </tr>
                      <tr>
                        <td>Phone Number</td>
                        <td>123-4567-890(Landline)<br><br><div id="phone"></div>(Mobile)
                        </td>
                           
                      </tr>
                     
                    </tbody>
                  </table>
                  
                  <a href="<%=request.getContextPath()%>/updateprofile" class="btn btn-primary">Update Profile</a> &nbsp;             
					                  
                  <a href="<%=request.getContextPath()%>/changepassword" class="btn btn-primary">Change Password</a>
                </div>
              </div>
            </div>
            
          </div>
        </div>
      </div>
      <script type="text/javascript" >
	 $("#diadiem").html($("#hiddendiadiem").val());
	  $("#phone").html($("#hiddenphone").val());
</script>