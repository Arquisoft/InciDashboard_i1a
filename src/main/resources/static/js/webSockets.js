function connect(){
	var socket = new SockJS("/dashboard");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){		
		console.log("Connected: " + frame);

		stompClient.subscribe("/incident", function (data) {			
			var incident = JSON.parse(data.body); 
	        updateTable(incident);
		});		
	});
}

$(document).ready(function () {
    connect();
});

function updateTable(incident){
	$("#incidentsTable").append(
		"<tr>"
		+ "<td>" + incident.idautogenerado + "<td>"
		+ "<td>" + incident.agent.name + "<td>"
		+ "<td>" + incident.incidentName + "<td>"
		+ "<td><a href='http://maps.google.com/maps?q=" + incident.location.lat + "," + incident.location.lng + "'</a><td>"
		+ "<td>" + incident.date + "<td>"
		+ "<td>" + incident.topic + "<td>"
		+ "<td>" + incident.operator.username + "<td>"
		+ "<td>" + incident.status + "<td>"
		+ "<td><div id ='options' class='btn-group' role='group' aria-label='Options'>"
			+ "<a class='btn btn-secondary' role='button' href='/incident/details/" + incident.idautogenerado + "'>Details</a>"
		+ "</div></td></tr>"
	);
	
	if (incident.operator.username == loggedUser) {
		$("#options").append(
				"<a class='btn btn-secondary' role='button' href='/incident/edit/" + incident.idautogenerado + "'>Change status</a>"
		);
	}
}