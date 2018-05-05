package gatlingTests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class AdminTests extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.99.100:8082")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Pragma" -> "no-cache",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Pragma" -> "no-cache")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Pragma" -> "no-cache")

	val headers_9 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_11 = Map("Accept" -> "text/css,*/*;q=0.1")

    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("AdminTests")
		.exec(http("request_0")
			.get("/dashboard")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri2 + "")
			.headers(headers_1),
            http("request_2")
			.get("/css/custom-login.css")
			.headers(headers_2),
            http("request_3")
			.get(uri2 + "")
			.headers(headers_1),
            http("request_4")
			.get(uri2 + "")
			.headers(headers_1),
            http("request_5")
			.get("/img/inc_support_icon.png")
			.headers(headers_1),
            http("request_6")
			.get(uri2 + "")
			.headers(headers_1),
            http("request_7")
			.get(uri2 + "")
			.headers(headers_1)))
		.pause(3)
		.exec(http("request_8")
			.get(uri2 + "")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_9")
			.post("/login")
			.headers(headers_9)
			.formParam("username", "admin")
			.formParam("password", "noadmin")
			.formParam("${_csrf.parameterName}", "${_csrf.token}")
			.resources(http("request_10")
			.get("/login?error=true")
			.headers(headers_9),
            http("request_11")
			.get("/css/custom-login.css")
			.headers(headers_11),
            http("request_12")
			.get("/img/inc_support_icon.png")))
		.pause(6)
		.exec(http("request_13")
			.post("/login")
			.headers(headers_9)
			.formParam("username", "admin")
			.formParam("password", "admin")
			.formParam("${_csrf.parameterName}", "${_csrf.token}")
			.resources(http("request_14")
			.get("/dashboard")
			.headers(headers_9),
            http("request_15")
			.get("/css/custom-dashboard.css")
			.headers(headers_11),
            http("request_16")
			.get("/img/inc_light_icon.png"),
            http("request_17")
			.get(uri2 + "")
			.headers(headers_1)))
		.pause(4)
		.exec(http("request_18")
			.get(uri2 + "")
			.headers(headers_1))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}