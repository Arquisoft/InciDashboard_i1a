package gatlingTests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ChangeStatusTests extends Simulation {

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

	val scn = scenario("ChangeStatusTests")
		.exec(http("request_0")
			.get("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_2")
			.post("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.formParam("incStatus", "IN_PROCESS")
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
		.pause(7)
		.exec(http("request_8")
			.get("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.resources(http("request_9")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_10")
			.post("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.formParam("incStatus", "CLOSED")
			.resources(http("request_11")
			.get("/dashboard")
			.headers(headers_0),
            http("request_12")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_13")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_14")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_15")
			.get(uri2 + "")
			.headers(headers_6)))
		.pause(6)
		.exec(http("request_16")
			.get("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.resources(http("request_17")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_18")
			.post("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.formParam("incStatus", "CANCELLED")
			.resources(http("request_19")
			.get("/dashboard")
			.headers(headers_0),
            http("request_20")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_21")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_22")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_23")
			.get(uri2 + "")
			.headers(headers_6)))
		.pause(3)
		.exec(http("request_24")
			.get("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.resources(http("request_25")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(3)
		.exec(http("request_26")
			.post("/incident/edit/5ae88a1968f0470004ccf0da")
			.headers(headers_0)
			.formParam("incStatus", "IN_PROCESS")
			.resources(http("request_27")
			.get("/dashboard")
			.headers(headers_0),
            http("request_28")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_29")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_30")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_31")
			.get(uri2 + "")
			.headers(headers_6)))
		.pause(5)
		.exec(http("request_32")
			.get("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.resources(http("request_33")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(4)
		.exec(http("request_34")
			.post("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.formParam("incStatus", "CLOSED")
			.resources(http("request_35")
			.get("/dashboard")
			.headers(headers_0),
            http("request_36")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_37")
			.get("/img/inc_light_icon.png")
			.headers(headers_5)))
		.pause(7)
		.exec(http("request_38")
			.get("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.resources(http("request_39")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(1)
		.exec(http("request_40")
			.post("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.formParam("incStatus", "OPEN")
			.resources(http("request_41")
			.get("/dashboard")
			.headers(headers_0),
            http("request_42")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_43")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_44")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_45")
			.get(uri2 + "")
			.headers(headers_6)))
		.pause(9)
		.exec(http("request_46")
			.get("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.resources(http("request_47")
			.get("/css/custom-dashboard.css")
			.headers(headers_1)))
		.pause(2)
		.exec(http("request_48")
			.post("/incident/edit/5ae88a1968f0470004ccf0d8")
			.headers(headers_0)
			.formParam("incStatus", "CANCELLED")
			.resources(http("request_49")
			.get("/dashboard")
			.headers(headers_0),
            http("request_50")
			.get("/css/custom-dashboard.css")
			.headers(headers_1),
            http("request_51")
			.get("/img/inc_light_icon.png")
			.headers(headers_5),
            http("request_52")
			.get(uri2 + "")
			.headers(headers_6),
            http("request_53")
			.get(uri2 + "")
			.headers(headers_6)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}