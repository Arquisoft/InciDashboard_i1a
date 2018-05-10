
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class FirefoxSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.99.100:8082")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Encoding" -> "gzip, deflate")

	val headers_3 = Map("Accept-Encoding" -> "gzip, deflate")

	val headers_4 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Origin" -> "http://192.168.99.100:8082")

	val headers_5 = Map("Origin" -> "http://192.168.99.100:8082")

	val headers_69 = Map("Accept" -> "text/css,*/*;q=0.1")

    val uri1 = "https://maps.googleapis.com"
    val uri2 = "https://code.jquery.com/jquery-3.2.1.slim.min.js"
    val uri3 = "https://cdnjs.cloudflare.com/ajax/libs"
    val uri4 = "https://maps.gstatic.com/mapfiles"
    val uri5 = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0"
    val uri7 = "https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"
    val uri8 = "https://fonts.googleapis.com/css"

	val scn = scenario("FirefoxSimulation")
		.exec(http("request_0")
			.get("/css/custom-dashboard.css")
			.headers(headers_0))
		.pause(11)
		.exec(http("request_1")
			.get("/dashboard")
			.headers(headers_1)
			.resources(http("request_2")
			.get("/css/custom-login.css")
			.headers(headers_2),
            http("request_3")
			.get("/img/inc_support_icon.png")
			.headers(headers_3),
            http("request_4")
			.get(uri5 + "/css/bootstrap.min.css")
			.headers(headers_4),
            http("request_5")
			.get(uri2 + "")
			.headers(headers_5),
            http("request_6")
			.get(uri3 + "/popper.js/1.12.9/umd/popper.min.js")
			.headers(headers_5),
            http("request_7")
			.get(uri5 + "/js/bootstrap.min.js")
			.headers(headers_5)))
		.pause(2)
		.exec(http("request_8")
			.post("/login")
			.headers(headers_1)
			.formParam("username", "admin")
			.formParam("password", "admin")
			.formParam("${_csrf.parameterName}", "${_csrf.token}")
			.resources(http("request_9")
			.get("/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_10")
			.get(uri5 + "/css/bootstrap.min.css")
			.headers(headers_4),
            http("request_11")
			.get(uri2 + "")
			.headers(headers_5),
            http("request_12")
			.get(uri3 + "/popper.js/1.12.9/umd/popper.min.js")
			.headers(headers_5),
            http("request_13")
			.get(uri5 + "/js/bootstrap.min.js")
			.headers(headers_5),
            http("request_14")
			.get(uri3 + "/Chart.js/2.6.0/Chart.min.js"),
            http("request_15")
			.get("/img/inc_light_icon.png")
			.headers(headers_3),
            http("request_16")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/common.js"),
            http("request_17")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/util.js"),
            http("request_18")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/map.js"),
            http("request_19")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/marker.js"),
            http("request_20")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/overlay.js"),
            http("request_21")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/infowindow.js"),
            http("request_22")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/onion.js"),
            http("request_23")
			.get(uri1 + "/maps/api/js/ViewportInfoService.GetViewportInfo?1m6&1m2&1d24.161969076714772&2d-45.303692018840195&2m2&1d55.37117913413802&2d35.23620490354233&2u6&4ses-ES&5e0&6sm%40421000000&7b0&8e0&callback=_xdc_._8cst9c&token=9946"),
            http("request_24")
			.get(uri4 + "/transparent.png"),
            http("request_25")
			.get(uri4 + "/api-3/images/spotlight-poi-dotless2.png"),
            http("request_26")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i31!3i25!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=126888"),
            http("request_27")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i30!3i25!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=64926"),
            http("request_28")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i29!3i25!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=51009"),
            http("request_29")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i29!3i24!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=46188"),
            http("request_30")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i29!3i23!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=41367"),
            http("request_31")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i33!3i23!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=110099"),
            http("request_32")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i33!3i24!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=114920"),
            http("request_33")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i33!3i25!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=119741"),
            http("request_34")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i28!3i25!4i256!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=120118"),
            http("request_35")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i28!3i24!4i256!2m3!1e0!2sm!3i421121928!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=7571"),
            http("request_36")
			.get(uri1 + "/maps/vt?pb=!1m5!1m4!1i6!2i28!3i23!4i256!2m3!1e0!2sm!3i421121652!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=72328"),
            http("request_37")
			.get(uri1 + "/maps/vt?pb=!1m4!1m3!1i6!2i28!3i23!1m4!1m3!1i6!2i29!3i23!1m4!1m3!1i6!2i30!3i23!1m4!1m3!1i6!2i31!3i23!1m4!1m3!1i6!2i28!3i24!1m4!1m3!1i6!2i28!3i25!1m4!1m3!1i6!2i29!3i24!1m4!1m3!1i6!2i29!3i25!1m4!1m3!1i6!2i30!3i24!1m4!1m3!1i6!2i30!3i25!1m4!1m3!1i6!2i31!3i24!1m4!1m3!1i6!2i31!3i25!1m4!1m3!1i6!2i32!3i23!1m4!1m3!1i6!2i33!3i23!1m4!1m3!1i6!2i32!3i24!1m4!1m3!1i6!2i32!3i25!1m4!1m3!1i6!2i33!3i24!1m4!1m3!1i6!2i33!3i25!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e3!12m1!5b1!23i1301875&callback=_xdc_._1mx5du&token=74433"),
            http("request_38")
			.get(uri1 + "/maps/api/js/AuthenticationService.Authenticate?1shttp%3A%2F%2F192.168.99.100%3A8082%2Fdashboard&4sAIzaSyCwARKHHxXQPny7hJNwu1xxJKoUP-l6O7Q&callback=_xdc_._xpb2t8&token=92761"),
            http("request_39")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/controls.js"),
            http("request_40")
			.get(uri4 + "/mv/imgs8.png"),
            http("request_41")
			.get("/incident/details/5ae88a1968f0470004ccf0d2")
			.headers(headers_1),
            http("request_42")
			.get("/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_43")
			.get(uri5 + "/css/bootstrap.min.css")
			.headers(headers_4),
            http("request_44")
			.get(uri2 + "")
			.headers(headers_5),
            http("request_45")
			.get(uri3 + "/popper.js/1.12.9/umd/popper.min.js")
			.headers(headers_5),
            http("request_46")
			.get(uri5 + "/js/bootstrap.min.js")
			.headers(headers_5),
            http("request_47")
			.get(uri1 + "/maps/api/staticmap?center=41.99164486394591,-1.7890378318286553&zoom=8&scale=1&size=800x300&maptype=hybrid&key=AIzaSyCuTSKiLsy3L3BL4yWfmaW1Ovs-qgRc6yY&format=png&visual_refresh=true&markers=size:large%7Ccolor:0x0080ff%7Clabel:%7C41.99164486394591,-1.7890378318286553")))
		.pause(2)
		.exec(http("request_48")
			.get("/dashboard")
			.headers(headers_1)
			.resources(http("request_49")
			.get("/css/custom-dashboard.css")
			.headers(headers_2),
            http("request_50")
			.get(uri5 + "/css/bootstrap.min.css")
			.headers(headers_4),
            http("request_51")
			.get(uri2 + "")
			.headers(headers_5),
            http("request_52")
			.get(uri3 + "/popper.js/1.12.9/umd/popper.min.js")
			.headers(headers_5),
            http("request_53")
			.get(uri5 + "/js/bootstrap.min.js")
			.headers(headers_5),
            http("request_54")
			.get(uri3 + "/Chart.js/2.6.0/Chart.min.js"),
            http("request_55")
			.get(uri1 + "/maps/api/js?key=AIzaSyCwARKHHxXQPny7hJNwu1xxJKoUP-l6O7Q&callback=initMap"),
            http("request_56")
			.get(uri7 + ""),
            http("request_57")
			.get("/img/inc_light_icon.png")
			.headers(headers_3),
            http("request_58")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/common.js"),
            http("request_59")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/util.js"),
            http("request_60")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/map.js"),
            http("request_61")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/marker.js"),
            http("request_62")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/overlay.js"),
            http("request_63")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/onion.js"),
            http("request_64")
			.get(uri1 + "/maps/api/js/ViewportInfoService.GetViewportInfo?1m6&1m2&1d24.161969076714772&2d-45.303692018840195&2m2&1d55.37117913413802&2d35.23620490354233&2u6&4ses-ES&5e0&6sm%40421000000&7b0&8e0&callback=_xdc_._8cst9c&token=9946"),
            http("request_65")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/infowindow.js"),
            http("request_66")
			.get(uri1 + "/maps/vt?pb=!1m4!1m3!1i6!2i28!3i23!1m4!1m3!1i6!2i29!3i23!1m4!1m3!1i6!2i30!3i23!1m4!1m3!1i6!2i31!3i23!1m4!1m3!1i6!2i28!3i24!1m4!1m3!1i6!2i28!3i25!1m4!1m3!1i6!2i29!3i24!1m4!1m3!1i6!2i29!3i25!1m4!1m3!1i6!2i30!3i24!1m4!1m3!1i6!2i30!3i25!1m4!1m3!1i6!2i31!3i24!1m4!1m3!1i6!2i31!3i25!1m4!1m3!1i6!2i32!3i23!1m4!1m3!1i6!2i33!3i23!1m4!1m3!1i6!2i32!3i24!1m4!1m3!1i6!2i32!3i25!1m4!1m3!1i6!2i33!3i24!1m4!1m3!1i6!2i33!3i25!2m3!1e0!2sm!3i421121940!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e3!12m1!5b1!23i1301875&callback=_xdc_._1mx5du&token=74433"),
            http("request_67")
			.get(uri1 + "/maps/api/js/AuthenticationService.Authenticate?1shttp%3A%2F%2F192.168.99.100%3A8082%2Fdashboard&4sAIzaSyCwARKHHxXQPny7hJNwu1xxJKoUP-l6O7Q&callback=_xdc_._xpb2t8&token=92761"),
            http("request_68")
			.get(uri1 + "/maps-api-v3/api/js/32/13/intl/es_ALL/controls.js"),
            http("request_69")
			.get(uri8 + "?family=Roboto:300,400,500,700")
			.headers(headers_69)))

	setUp(scn.inject(atOnceUsers(500))).protocols(httpProtocol)
}