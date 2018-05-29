$(document).ready(function() {
  $(".animsition").animsition();
});

$("#login-button").click(function(event) {
  event.preventDefault();

  var username = $("#username").val();

  if (username.length === 0) {
    shake();
    return false;
  }

  initiateLoading();

  $.ajax({
    url: "/api/register",
    method: "POST",
    data: JSON.stringify({
      username: username
    }),
    contentType: "application/json",
    success: function(result) {
      stopLoading();
      if (typeof result.id != 'undefined') {
        sessionStorage.setItem("userId", result.id);
        $("form").fadeOut(500);
        $(".wrapper").addClass("form-success");
        setTimeout(function() {
          $(".animsition-link").trigger("click");
        }, 1000);
      } else {
        iziToast.error({
          title: "Error!",
          message: "The username already exists",
          position: "topRight"
        });
      }
    }
  });
});

function shake() {
  $("#username").effect("shake");
}

function initiateLoading() {
  $("#login-button").html('Login <i class="fas fa-circle-notch fa-spin"></i>');
}

function stopLoading() {
  $("#login-button").html("Login");
}
