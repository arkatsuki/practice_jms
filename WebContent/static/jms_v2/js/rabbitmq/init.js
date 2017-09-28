
$('#sendToBroker').click(function(){
	ajaxSend("/practice_jms/rabbitmq/sendToBroker");
});

function ajaxSend(url){
	var paramObj = new Object();
	paramObj['exchange'] = $('#exchange').val();
	paramObj['routingKey'] = $('#routingKey').val();
	paramObj['message'] = $('#message').val();
	$.ajax({
		async: false,
		type: "POST",
		url: url,
		data: paramObj ,
		success: function(rs){
			if(rs.success){
				$('#output').append(rs.message).append('<br/>');
			}
	   }
	});
}
