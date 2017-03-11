$(document).ready(function(){

   $('#logout').on("click",function(){
                console.log("clicked at LogOut")
                jsRoutes.controllers.WelcomeController.welcome().ajax({
                            success: function(data){
                              $('#body').html(data);
                            },
                            error: function(){
                            $('#body').html("Oops.... Something went wrong. Please try again later");
                            alert("fail")
                          }
                })
   })
});