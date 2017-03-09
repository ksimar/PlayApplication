package controllers

import org.scalatest.mock.MockitoSugar
import org.scalatestplus.play.PlaySpec
import play.api.mvc.Results
import play.api.test.FakeRequest
import services.DataServer
import play.api.test.Helpers._


class LogInControllerSpec extends PlaySpec with MockitoSugar with Results{

  "LogInController" should {
    "render page" in {
      val dataServer = mock[DataServer]
      val mappingWithForm = mock[LogInMapping]
      val logInController = new LogInController(mappingWithForm, dataServer)
      val result = logInController.logIn(FakeRequest(POST,"/login").withFormUrlEncodedBody())
      contentType(result) mustBe Some("text/html")
      status(result) mustBe 200
      contentAsString(result) must include ("Play LogIn Page")
    }
  }

}
