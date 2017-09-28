
// 如何取消某个地址的订阅???

var rootPath = '/practice_jms/';

function getMsgInput(){
	return $('#message').val();
}

/********************************/
console.log('window.location.host:' + window.location.host);
//var sock = new SockJS([[@{/firstWebsocket}]]);
var sock = new WebSocket('ws://'+ window.location.host + rootPath + 'firstStompEndpoint');
var stomp = Stomp.over(sock);

// websocket自带的消息代理的用户名密码是guest:guest ？？？
stomp.connect('guest', 'guest', function(frame) {
  console.log('*****  Connected  *****');
  stomp.subscribe("/jms_v2/sendToBrowserQueue", handleSubscribe);
  stomp.subscribe("/jms_v2/messageMappingRerurn", handleMessageMappingRerurn);
});

function handleSubscribe(message) {
	/*
	 * 返回的是个封装的帧，内容如下：
	ack
	:
	ƒ (headers)
	body
	:
	"sendTopicMsg, from server"
	command
	:
	"MESSAGE"
	headers
	:
	{content-length: "25", message-id: "3-3", subscription: "sub-1", content-type: "text/plain;charset=UTF-8", destination: "/topic/marco"}
	nack
	:
	ƒ (headers)
	__proto__
	:
	Object
	*/
  console.log('Received: ', message);
  $('#output').append("<b>receive subscribe info: " + message.body + "</b><br/>")
}

function handleMessageMappingRerurn(message) {
  console.log('Received111: ', message);
  $('#output').append("<b>handleMessageMappingRerurn receive subscribe info: " + message.body + "</b><br/>")
}

/**
 * 给服务器发送消息
 * @param url
 * @param msg
 */
function sendToServer(url, msg) {
  console.log('sendToServer:' + msg);
  //第二个参数啥意思???
  stomp.send(url, {}, msg);
  $('#output').append('<b>sendToServer end: ' + msg + '</b><br/>')
}

$('#stopConnection').click(function(){
	sock.close();
});

$('#sendToServer').click(function(){
//	var url = '/app/receiveMsgFromBrowser';
	var url = '/app/receiveMsgFromBrowserReturn';
	var msgObj = {};
	msgObj['message'] = getMsgInput();
	
	sendToServer(url, JSON.stringify(msgObj));
})

$('#triggerServerSendToBrowser').click(function() {
	var addr = '/jms_v2/sendToBrowserQueue';
	$.ajax({
		type : "GET",
		url : "sendToBrowser?addr=" + encodeURIComponent(addr) + "&msg=" + getMsgInput(),
		dataType : "json", 
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		error : function(request) {
			console.log("sendTopicMsg, return error");
		},
		success : function(rs) {
			console.log("sendTopicMsg, return success, message:" + rs['message']);
		}
	});
});


/********************************/
