if (typeof window.Dingleberries !== 'object') {
	window.Dingleberries = {
		trackView : function(url) {
			var xhr = new XMLHttpRequest();
			xhr.open("GET", url, true);
			xhr.send();
		}
	};
}