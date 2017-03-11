$(document).ready(function(){
   $('#logIn').on("click", function(){
     val resultLogIn = jsRoutes.controllers.LogInController.logIn($('userName').val())
     resultLogIn.ajax(
     {
            success: function(result){
               $('#body').html(result);
            },
            error: function(){
               $('#body').html("Oops... Something went wrong. Please try again later");
               alert("fail")
            }
     })
   })
});
