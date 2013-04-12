function fetchUpdates() {
	$.getJSON("/n/s3/chat/log", function(data) {
		updateMessages(data);
	});
}

function updateMessages(messages) {
	$(".messages").empty();
	
	for (var idx in messages) {
		var message = messages[idx];
		
		var content = message.content;
		var from = message.from == null ? "" : message.from.nickname;
		
		var messageDiv = $("<div>").addClass("message").append(
				$("<span>").addClass("from").append(from)
		).append(": ").append(
				$("<span>").addClass("content").append(content)
		);
		
		messageDiv.appendTo(".messages");
	}
}

setInterval(function() {
	fetchUpdates();
}, 1500);

$(document).ready(function() {
});
