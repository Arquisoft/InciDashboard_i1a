package gatlingTests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ChangeStatusFromOpenToClosedTests extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.99.100:8082")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map("Accept" -> "text/css,*/*;q=0.1")

	val headers_5 = Map("Accept" -> "*/*")

	val headers_6 = Map(
		"Accept" -> "*/*",
		"Pragma" -> "no-cache")

    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("ChangeStatusFromOpenToClosedTests")
		.exec(http("request_0")
			.get("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_2")
			.post("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.formParam("incStatus", "CLOSED")
			.resources(http("request_3")
			.get("/dashboard")
			.headers(headers_0),
            http("request_4")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_5")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_6")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_7")
			.get(uri2 + "")
			.headers(headers_6)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}