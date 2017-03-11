 $(document).ready(function(){

 $('#signUp').on("click",function(){
                console.log($('#fname').val())
                console.log("clicked at signUp")
                jsRoutes.controllers.SignUpController.addPerson($('#fname').val(),$('#uname').val(),
                                $('#password').val(),$('#mbNumber').val(),$('#age').val()).ajax({
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
