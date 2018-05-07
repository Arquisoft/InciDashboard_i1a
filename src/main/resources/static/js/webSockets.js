function connect(){
	var socket = new SockJS("/dashboard");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){		
		console.log("Connected: " + frame);

		stompClient.subscribe("/incident", function (data) {			
			var incident = JSON.parse(data.body); 
	        updateTable();
	        updateBarChart();
	        updatePieChart();
	        locations.push(incident.location);
	        nombres.push(incident.incidentName);
	        descripciones.push(incident.description);
	        initMap();
		});		
	});
}

$(document).ready(function () {
    connect();
});

function updateTable(){
	$("#tableInci").load("/dashboard/updateTable");
}

function updateBarChart(){
	$("#barChartFragment").load("/dashboard/updateBarChart");
}

function updatePieChart(){
	$("#pieChartFragment").load("/dashboard/updatePieChart");
}

