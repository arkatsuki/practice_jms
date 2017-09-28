
$('#sendToBroker').click(function(){
	ajaxSend("/practice_jms/activemq/sendToBroker");
});

function ajaxSend(url){
	var paramObj = new Object();
	paramObj['message'] = $('#message').val();
	paramObj['destination'] = $('#destination').val();
//	var param = JSON.stringify(paramObj);
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
