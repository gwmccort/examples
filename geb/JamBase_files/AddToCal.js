var xmlhttp;
/*@cc_on @*/
/*@if (@_jscript_version >= 5)
// JScript gives us Conditional compilation, we can cope with old IE versions.
// and security blocked creation of the objects.
 try {
   xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
 } catch (e) {
    try {
      xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    } 
    catch (E) {
	  xmlhttp = false;
    }
 }
@else
 xmlhttp=false;
@end @*/
if (!xmlhttp && typeof XMLHttpRequest!='undefined') {
	try {
		xmlhttp = new XMLHttpRequest();
	} catch (e) {
		xmlhttp=false;
	}
}
if (!xmlhttp && window.createRequest) {
	try {
		xmlhttp = window.createRequest();
	} catch (e) {
		xmlhttp=false;
	}
}

function AddToCal_Bubb(eventID, ancID, imgID, btnID)
{
	xmlhttp.open("POST", $('#AddToCalPostUrl').val() + "?&ms=" + new Date().getTime(), true);
	xmlhttp.setRequestHeader('Content-Type', 'application/x-www-urlencoded');
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4)
		{
			var answer = xmlhttp.responseText;
			if (answer == "false|Not logged in.")
			{
				location.href = $('#LoginUrl').val();
				return false;
			}
			var success = answer.substring(0, answer.indexOf('|'));
			if (success.toLowerCase() == 'true')
			{
				$('#'+ancID).attr('href', $('#MyCalUrl').val());
				$('#'+ancID).attr('title', 'Go to My Calendar');
				$('#'+ancID).attr('class', 'imGoingIcon');
				$('#'+ancID).html("I'm Going!");
				ShowAdded(imgID, btnID);
			}
			else
				alert('Oops! We ran into a problem, please refresh the page and try again.');
		}
	}
	xmlhttp.send("eventID=" + eventID);
}
 
function AddToCal(eventID, imgID, btnID)
{
	xmlhttp.open("POST", $('#AddToCalPostUrl').val() + "?&ms=" + new Date().getTime(), true);
	xmlhttp.setRequestHeader('Content-Type', 'application/x-www-urlencoded');
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4)
		{
			var answer = xmlhttp.responseText;
			if (answer == "false|Not logged in.")
			{
				location.href = $('#LoginUrl').val();
				return false;
			}
			var success = answer.substring(0, answer.indexOf('|'));
			if (success.toLowerCase() == 'true')
				ShowAdded(imgID, btnID);
			else
				alert('Oops! We ran into a problem, please refresh the page and try again.');
		}
	}
	xmlhttp.send("eventID=" + eventID);
}

function RemoveFromCal(eventID, liRowID)
{
	if (confirm('Are you sure you want to remove this show from your calendar?'))
	{
		xmlhttp.open("POST", $('#RemoveFromCalPostUrl').val() + "?&ms=" + new Date().getTime(), true);
		xmlhttp.setRequestHeader('Content-Type', 'application/x-www-urlencoded');
		xmlhttp.onreadystatechange = function() {
			if(xmlhttp.readyState == 4)
			{
				var answer = xmlhttp.responseText;
				if (answer == "false|Not logged in.")
				{
					location.href = $('#LoginUrl').val();
					return false;
				}
				var success = answer.substring(0, answer.indexOf('|'));
				if (success.toLowerCase() == 'true')
					ShowRemoved(liRowID);
				else
					alert('Oops! We ran into a problem, please refresh the page and try again.');
			}
		}
		xmlhttp.send("eventID=" + eventID);
	}
}

function ShowRemoved(rowID)
{
	var liEventRow = $('#'+rowID);
	liEventRow.fadeOut('slow');
}

function ShowAdded(imgID, btnID)
{
	var img = $('#'+imgID);
	var btn = $('#'+btnID);
	var hsrc = img.attr('hsrc');
	img.attr('src', hsrc);
	img.parent().parent().parent().attr('class', 'myCalRow');

	btn.attr('onclick', 'return true;');
	btn.attr('href', $('#MyCalUrl').val());
}