package gatlingTests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class OpenGoogleMapsTests extends Simulation {

	val httpProtocol = http
		.baseURL("http://maps.google.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map("Pragma" -> "no-cache")

	val headers_13 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

    val uri1 = "http://maps.google.com/maps"
    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("OpenGoogleMapsTests")
		.exec(http("request_0")
			.get(uri2 + "")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_2")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_3")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_4")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_5")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_6")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_7")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_8")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_9")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_10")
			.get(uri2 + "")
			.headers(headers_0),
            http("request_11")
			.get(uri2 + "")
			.headers(headers_0)))
		.pause(1)
		.exec(http("request_12")
			.get(uri2 + "")
			.headers(headers_0))
		.pause(4)
		.exec(http("request_13")
			.get("/maps?q=37.790540190252216,0.36694588086760405")
			.headers(headers_13))
		.pause(4)
		.exec(http("request_14")
			.get("/maps?q=41.99164486394591,-1.7890378318286553")
			.headers(headers_13))
		.pause(4)
		.exec(http("request_15")
			.get("/maps?q=38.05222807385176,-5.207964501096763")
			.headers(headers_13))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}