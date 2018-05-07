function connect(){
	var socket = new SockJS("/dashboard");
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame){		
		console.log("Connected: " + frame);

		stompClient.subscribe("/incident", function (data) {			
			var incident = JSON.parse(data.body); 
	        updateTable();
	        updateCharts();
		});		
	});
}

$(document).ready(function () {
    connect();
});

function updateTable(){
	$("#tableInci").load("/dashboard/updateTable");
}

function updateCharts(){
	$("#barChartFragment").load("/dashboard/updateBarChart");
	$("#pieChartFragment").load("/dashboard/updatePieChart");
}

