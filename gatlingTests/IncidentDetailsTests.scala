package gatlingTests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class IncidentDetailsTests extends Simulation {

	val httpProtocol = http
		.baseURL("http://detectportal.firefox.com")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map("Pragma" -> "no-cache")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map("Accept" -> "text/css,*/*;q=0.1")

    val uri1 = "http://192.168.99.100:8082"
    val uri2 = "http://detectportal.firefox.com/success.txt"

	val scn = scenario("IncidentDetailsTests")
		.exec(http("request_0")
			.get("/success.txt")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_1")
			.get(uri1 + "/incident/details/5aec332c9202f72bbe835605")
			.headers(headers_1)
			.resources(http("request_2")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_3")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(3)
		.exec(http("request_4")
			.get(uri1 + "/dashboard")
			.headers(headers_1)
			.resources(http("request_5")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_6")
			.get(uri1 + "/img/inc_light_icon.png"),
            http("request_7")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(4)
		.exec(http("request_8")
			.get(uri1 + "/incident/details/5ae88a1968f0470004ccf0d3")
			.headers(headers_1)
			.resources(http("request_9")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_10")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(2)
		.exec(http("request_11")
			.get(uri1 + "/dashboard")
			.headers(headers_1)
			.resources(http("request_12")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_13")
			.get(uri1 + "/img/inc_light_icon.png"),
            http("request_14")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(1)
		.exec(http("request_15")
			.get("/success.txt")
			.headers(headers_0)
			.resources(http("request_16")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(3)
		.exec(http("request_17")
			.get("/success.txt")
			.headers(headers_0))
		.pause(5)
		.exec(http("request_18")
			.get(uri1 + "/incident/details/5ae88a1968f0470004ccf0d6")
			.headers(headers_1)
			.resources(http("request_19")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_20")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(1)
		.exec(http("request_21")
			.get(uri1 + "/dashboard")
			.headers(headers_1)
			.resources(http("request_22")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_23")
			.get(uri1 + "/img/inc_light_icon.png"),
            http("request_24")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(4)
		.exec(http("request_25")
			.get("/success.txt")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_26")
			.get("/success.txt")
			.headers(headers_0))
		.pause(12)
		.exec(http("request_27")
			.get(uri1 + "/incident/details/5ae88a1968f0470004ccf0d5")
			.headers(headers_1)
			.resources(http("request_28")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_29")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(1)
		.exec(http("request_30")
			.get(uri1 + "/dashboard")
			.headers(headers_1)
			.resources(http("request_31")
			.get(uri1 + "/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_32")
			.get(uri1 + "/img/inc_light_icon.png"),
            http("request_33")
			.get("/success.txt")
			.headers(headers_0),
            http("request_34")
			.get("/success.txt")
			.headers(headers_0)))
		.pause(1)
		.exec(http("request_35")
			.get("/success.txt")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_36")
			.get("/success.txt")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_37")
			.get("/success.txt")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_38")
			.get("/success.txt")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}