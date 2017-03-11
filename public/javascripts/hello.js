if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

$(document).ready(function(){


         $('#logIn').on("click",function(){
          console.log("clicked on LogIn")
         jsRoutes.controllers.WelcomeController.logIn().ajax({
                      success: function(data){
                       console.log("entered success")
                        $('#body').html(data);
                      },
                      error: function(){
                      console.log("entered error")
                      $('#body').html("Oops... Something went wrong. Please try again later");
                      alert("fail")
                    }
          })
      })

      $('#signUp').on("click",function(){
                jsRoutes.controllers.WelcomeController.signUp().ajax({
                            success: function(data){
                              $('#body').html(data);
                            },
                            error: function(){
                            $('#body').html("Oops... Something went wrong. Please try again later");
                            alert("fail")
                          }

                })
      })

 });


