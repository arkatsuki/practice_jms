
var rootPath = '/practice_jms/';

console.log('window.location.host:' + window.location.host);

$('#activeMqInit').click(function(){
	window.location.href = rootPath + 'activemq/init';
});

$('#rabbitMqInit').click(function(){
	window.location.href = rootPath + 'rabbitmq/init';
});

$('#websocketInit').click(function(){
	window.location.href = rootPath + 'websocket/init';
});


