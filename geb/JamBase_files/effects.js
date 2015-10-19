$(document).ready(function() {
	
     $("a.loginBtn").click(
        function () {
           $("a.loginBtn").attr("style", "background:none;");
           $("a.loginBtn").html("<span style='color:white;'>.....</span>");
    });
    
	//Enter as click for search
	$(".searchtextbox").keydown(SearchClick);	
	
	// JMS: Added to handle enter key on login form.
	// Since we added a Facebook button, the form will no longer submit
	// by default when enter is pressed.
	$('.passWordField').keypress(function(event) {
      if (event.which == '13') {
         $('#ctl00_MainContent_btnLogin').click();
       }
    });
    	
	$(".showFilter").keydown(AjaxClick);
	
	//Enter as click for many buttons on several pages
	$("fieldset.frmEventAdd").find("input").keydown(EnterClick);
	
	// Will allow only numeric input in text fields with this class.
	$("input.numeric").numeric();
    
    
	$("a.othersNav_login").click(
		function () {
			this.blur();
			$(".moduleLogin").slideDown("fast");
			CreateBodyOverlay(CloseLogin);
			return false;
		});
		
	var CloseLogin = function() {
		$("#popup_overlay").remove();
		$(".moduleLogin>.error").hide();
		$(".moduleLogin").slideUp("fast");
		return false;
	}
	
	$("a.showHeaderlink").click(
		function() {
			this.blur();
			$('dl.showlist').css("overflow", "hidden");
			$("ul.zipSearch").slideDown("fast");
			CreateBodyOverlay(CloseZipSearch);
			return false;
		});
		
	var CloseZipSearch = function() {		
		$("#popup_overlay").remove();
		$('dl.showlist').css("overflow", "auto");
		$("ul.zipSearch").slideUp("fast");
		return false;
	}
	
	$("input.zipSearchfield").keydown(
		function(e) {
			if (e.keyCode == 13)
			{
				CloseZipSearch();
				var location = $(this).val();
				var args = '<args context="near"><location>' + location + '</location></args>';
				$('dl.showlist').html('<dt class="loading"><img src="http://www.jambase.com/img/icons/loading.gif"> Loading Shows...</dt>');
				GetShowList(args, 'near');
				return false;
			}
			else if (e.keyCode == 9)
				e.preventDefault();
		});

		
	$("a.playing_today").click(
		function() {
			CloseZipSearch();
			var args = '<args context="today"/>';
			$('dl.showlist').html('<dt class="loading"><img src="http://www.jambase.com/img/icons/loading.gif"> Loading Shows...</dt>');
			GetShowList(args, 'today');
			return false;
		});
		
	$("a.getShowList").click(
		function () {
			this.blur();
			var args = '<args context="' + $("select.slcFetchEventsBy").val() + '">';
			var optLocation;
			
			$('input[@name=optLocation]').each(
				function () {
					if (this.checked)
					{
						optLocation = $(this).val();
						return;
					}
				});
			
			if (optLocation == 'mileradius')
			{
				if ($('input.cityNamebox').val() == '' || $('input.mileRadiusbox').val() == '')
				{
					ReceiveMyShowListHTML('<li class="error">Invalid search. Please either select "Everywhere" or specify a City, State and radius to search above.</li>', '');
					return false;
				}	
				else
					args += '<location>' + $('input.cityNamebox').val() + '</location><radius>' + $('input.mileRadiusbox').val() + '</radius>';
			}
				
			args += '</args>';
			$('#myshowList').html('<li class="loading"><img src="http://www.jambase.com/img/icons/loading.gif"> Loading shows...</li>');
			GetMyShowList(args, 'fetch');
			return false;
		});
		
	$("input.fileUpload").change(
		function() {
			var src = $("img.btnUpload").attr("src");
			src = src.replace("_disabled", "");
			if ($(this).val() == '')
			{
				$("img.btnUpload").attr("src", src.replace(".gif", "_disabled.gif"));
			}
			else
			{
				$("img.btnUpload").attr("src", src);
			}
		});
    
   
	$("a.btnUpload").click(
		function () {
			this.blur();
			if ($("input.fileUpload").val() != '')
				$(".divUploading").show();
			return $("input.fileUpload").val() != '';
		});
		
	$("a.btnNext").click(
		function() {
			if (typeof(ValidatorOnSubmit) == 'function' && !ValidatorOnSubmit())
				return false;
		});
		
	$("a.hideArticleComment").toggle(
		function() {
			this.blur();
			$(this).parents("div.commentAuthor").next("div.commentContent").slideDown("fast");
			$(this).html("Hide");
		},
		function() {
			this.blur();
			$(this).parents("div.commentAuthor").next("div.commentContent").slideUp("fast");
			$(this).html("Show");
		});
		
	$("a.calendar_link").click(
	    function(e) {
            var leftPos = e.pageX;
            var topPos = e.pageY - 50;       
			this.blur();
			var eventID = '#' + $(this).attr('eventID');
            $(eventID).css("z-index","2000").css("position","absolute").css("top",topPos+"px");
			/* $(eventID).attr("style", "z-index:2000; clear:both; position:absolute; top:" + topPos + "px"); */
			$(eventID).slideDown("fast");
			CreateBodyOverlay(HideCalendarPopup);
			return false;
		});
		
	$("a.close_calendar").click(
		function() {
			this.blur();
			HideCalendarPopup();
			return false;
		});	

	$("input.update_calendar").click(
		function() {
			HideCalendarPopup();
			return true;
		});
		
	$("a.remove_artists").click(
		function() {
			var i = 0;
			$("select.selectedArtists>option:selected").each(
				function() {
					i++;
				});
				
			if (i == 0)
				return false;
				
			var confirmText = "Are you sure you want to remove the selected artist";
			confirmText += (i == 1 ? "?" : "s?");
			
			return confirm(confirmText);
		});
			
	/*
	$(".slcShareVal").change(
		function() {
			HideCalendarPopup();
			return true;
		});
	*/
	
	$(".userNameField").keydown(LoginClick);
	$(".passWordField").keydown(LoginClick);
	$(".cbRememberMeField").keydown(LoginClick);
	
	$("a.btnLoginAjax").click(
		function() {
			this.blur();
			var username = $(".userNameField").val();
			var password = $(".passWordField").val();
			var args = '<args username="' + username + '" password="' + password + '"/>';
			CheckLogin(args, 'login');
			return false;
		});
	
	$("a.homeSearchDatesClick").click(
	    function() {
	        $(".homeSearchDates").slideDown("slow");
	        $(".homeSearchDatesClick").hide();
	    });
	    
    $("a.btnSaveToCalendar_header").click(
	    function() {
            CreateBodyOverlay(HideCalendarList_Header);
            $(".SaveToCalendarList_Header").show();
        });
        
    $(".myjb_arrow").click(
        function() {
            $(".moreOptions_myjambase").show();
            $(".newslist").attr("style", "overflow:hidden;");
            CreateBodyOverlay(HideMyJamBase_MoreOptions);
        });
        
    $(".faq_arrow").click(
        function() {
            $(".moreOptions_faqs").show();
            $(".newslist").attr("style", "overflow:hidden;");
            CreateBodyOverlay(HideFAQ_MoreOptions);
        });
    
    $("a.ShowFinder_Advanced").click(
		function () {
			$("#advancedSearch").slideDown("fast");
			$(".searchSection").attr("style","height:50px;");
			return false;
		});
        
        
});

function mouseX(evt) {
	if (evt.pageX) return evt.pageX;
	else if (evt.clientX)
	   return evt.clientX + (document.documentElement.scrollLeft ?
	   document.documentElement.scrollLeft :
	   document.body.scrollLeft);
	else return null;
}
function mouseY(evt) {
	if (evt.pageY) return evt.pageY;
	else if (evt.clientY)
	   return evt.clientY + (document.documentElement.scrollTop ?
	   document.documentElement.scrollTop :
	   document.body.scrollTop);
	else return null;
}

function CheckLoginCallback(args, context)
{
	if (args == '1')
	{
		$("a.btnLoginHidden").click();
	}
	else
	{
		$(".moduleLogin").css("height", "145px");
		$(".moduleLogin>.error").show();
		$("a.loginBtn").html("Login");
		$("a.loginBtn").attr("style", "background:url(../img/btns/btn_login_off.gif) no-repeat 0px 5px;");	
	}
}

function HideCalendarPopup()
{	
	$("#popup_overlay").remove();
	
	$(".showPopup").each(
		function() {
			if ($(this).css("display") == "block")
				$(this).slideUp("fast");
		});
}

function SetupDiggCallback(vote, linkID, commentID)
{
	var args = "<args context='" + vote + "' commentID='" + commentID + "'/>";
	DoDiggCallback(args, vote + "|" + linkID);
}

function imposeMaxLength(Object, MaxLen)
{
  return (Object.value.length <= MaxLen);
}

function ReceiveDiggCallback(args, context)
{
	var arr = context.split("|");
	var vote = arr[0];
	var linkID = arr[1];
	var link = $("#" + linkID);

	link.parents("span.voteLink").hide();
	link.parents("div.headerRight").find("span.voted").show();
	link.parents("div.headerRight").find("span.diggCount").html(args + " Votes");

	if (vote == 'down')
	{
		link.parents("div.headerRight").find("span.hideComment").show();
		link.parents("div.commentAuthor").next("div.commentContent").slideUp("fast");
	}
}

function ReceiveAddToCalendar(args, context)
{   
    var img = $('#' + context);
    var hsrc = img.attr('hsrc');
    img.attr('src', hsrc);        
    img.attr('onclick', 'return true');
    
    // for some reason, when you run this img.parent.parent.parent it assigns img to be the tr, 
    // so you then just reference it directly. go figure! -ag
    if (img.parent().parent().parent().is('tr') == true)
        img.attr('class', 'myCalRow');
    else
        img.attr('class', 'myCalRow');
}

// Displays an AJAX callback on the home page.
function ReceiveShowListHTML(args, context)
{
	if (args == '')
		args = '<dt>Sorry, no shows were found.</dt>';
		
	$("dl.showlist").html(args);
	switch (context)
	{
		case "near":
			$("a.showHeaderlink").html("Playing Near");
			break;
		case "today":
			$("a.showHeaderlink").html("Playing Today");
			break;
	}
}

function ReceiveMyShowListHTML(args, context)
{
	if (args == '')
	{
		args = '<li class="error">Sorry, no shows were found. Try changing your search options above.</li>';
		$("#myshowList").html(args);
	}
	else
	{
	    $("#myshowList").html(args);
    	
    	if (context != '')
    	{
	        if ($(".slcFetchEventsBy").val() == 'showList')
	        {
		        var optLocation;
        		
		        $('input[@name=optLocation]').each(
			        function () {
				        if (this.checked)
				        {
					        optLocation = $(this).val();
					        return;
				        }
			        });
        			
		        if (optLocation == 'mileradius')
		        {
			        var city = '';
			        var state = '';
			        var zip = '';
			        if (($(".cityNamebox").val().length == 5))
			        {
				        zip = $(".cityNamebox").val()
			        }
			        else
			        {
				        city = $(".cityNamebox").val().split(', ')[0];
				        state = $(".cityNamebox").val().split(', ')[1];
			        }
			        $("#myshowList").append('<li class=\"moreShows\"><span class=\"iconCol\"></span><span><b><a href=\"http://www.jambase.com/Shows/Shows.aspx?city=' + city + '&state=' + state + '&zip=' + zip + '&radius=' + $(".mileRadiusbox").val() + '">All Shows near ' + $(".cityNamebox").val() + ' >></a></b></span></li>');
		        }
		        else
		        {
			        $("#myshowList").append('<li class=\"moreShows\"><span class=\"iconCol\"></span><span><b>Want more? Use the single-search at the top or <a href=\"http://www.jambase.com/Shows/\">the show search on Shows Home. >></a></b></span></li>');
		        }
	        }
        }
    }
}

function CreateBodyOverlay(onClickFunction, tagName){
	tagName = tagName || 'popup_overlay';
	
	$("body").append('<div id="' + tagName + '"/>');
	$("#" + tagName).click(onClickFunction);
	
	// This handles if the page extends below the window.
    if (window.innerHeight && window.scrollMaxY) {  
      yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight){ // all but Explorer Mac
      yScroll = document.body.scrollHeight;
    } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
      yScroll = document.body.offsetHeight;
      }    
    $("#" + tagName).css("height",yScroll +"px");
}


function SearchClick (e) {
	 if (e.keyCode == 13)
	 {
		var lnk = $("a.btnGo");
	 	e.preventDefault();
	 	lnk.focus();
	 	lnk.click();
	 	return false;
	 }
}

function AjaxClick (e) {
	 if (e.keyCode == 13)
	 {
		var lnk = $("a.btnAjaxGo");
	 	e.preventDefault();
	 	lnk.focus();
	 	lnk.click();
	 	return false;
	 }
}

function EnterClick (e) {
	if (e.keyCode == 13)
	{
		var lnk = $(".enterKey");
		IGNORE_UNLOAD = true;
		e.preventDefault();
		lnk.focus();
		lnk.click();
		return false;
	}
}

function LoginClick (e) {
	 if (e.keyCode == 13)
	 {
		var lnk = $(this).parents(".loginForm").find("a.loginBtn");
	 	e.preventDefault();
	 	lnk.focus();
	 	lnk.click();
	 	return false;
	 }
}

function activateAddArtistButton() {
    var addBtn = $(".btnAdd");
    addBtn.attr('class', 'btnAddOn');
}

function swapVideos(prev, next, total) {
    var currVideo = $("#video" + prev);
    var nextVideo = $("#video" + next);
    
    currVideo.hide("fast");
    nextVideo.show("fast");
    var nextone = next+1;
    if (nextone == total) 
        nextone=0;
    $(".nextVideo").attr("onclick", "swapVideos(" + next + ", " + nextone + ", " + total + ")");
}

function HideCalendarList_Header() {
    $("#popup_overlay").remove();
    $(".SaveToCalendarList_Header").hide();
}

function HideCalendarConfirm() {
    $(".addtocal_confirm").fadeOut('slow');
}

function HideFavBandConfirm() {
    $(".addfavband_confirm").fadeOut('slow');
}

function clearInput(obj, theText) {
	if (obj.value == "") 
		{obj.value = theText;}
	else
		{obj.value = "";}
}

function HideMyJamBase_MoreOptions() {
    $("#popup_overlay").remove();
    $(".moreOptions_myjambase").hide();
    $(".newslist").attr("style", "overflow:auto;");
}

function HideFAQ_MoreOptions() {
    $("#popup_overlay").remove();
    $(".moreOptions_faqs").hide();
    $(".newslist").attr("style", "overflow:auto;");
}

function ToggleFAQanswer(obj) {
	var answer = $("#" + obj);
	if (answer.css("display") == "none")
		answer.slideDown("fast");
	else
		answer.slideUp("fast");
}
function AjaxFriendBubble(event, eventID, rowImgID, rowBtnID)
{
	var xPos = mouseX(event);
	var yPos = mouseY(event);
	CloseBubble();
	xmlhttp.open("POST", $("#FriendsGoingUrl").val() + "?&ms=" + new Date().getTime(), true);
	xmlhttp.setRequestHeader('Content-Type', 'application/x-www-urlencoded');
	xmlhttp.onreadystatechange = function() {
		if(xmlhttp.readyState == 4)
		{
			var answer = xmlhttp.responseText;
			var success = answer.substring(0, answer.indexOf('|'));
			if (success.toLowerCase() == 'true' || success.toLowerCase() == 'false') {
				var pop = answer.substring(answer.indexOf('|')+1, answer.length);
				$('#tempLoad').remove();
				CreateBodyOverlay(myClicker);
				$("body").append('<div id="testID"/>');
				$('#testID').html(pop);
				$('#testID').css("z-index","2000");
				$('#testID').css('position','absolute');
				var height = $('#testID').height();
				var top = (yPos - height);
				$('#testID').css('top',top);
				$('#testID').css('left',xPos-38);
			}
			else {
				$('#tempLoad').remove();
				alert('Oops! We ran into a problem, please refresh the page and try again.');
			}
		}
	}
	xmlhttp.send("eventID=" + eventID + "&btnID=" + rowBtnID + "&imgID=" + rowImgID); 
	var tTop = (yPos - 115);
	var tLeft = (xPos - 38);
	$("body").append('<div id="tempLoad">'+ jsHTMLDecoder($('#LoadingBubble').val()) +'</div>');
	$('#tempLoad').css("z-index","2000");
	$('#tempLoad').css('left',tLeft);
	$('#tempLoad').css('top',tTop);
	$('#tempLoad').css('position','absolute');
}

function jsHTMLDecoder(strHTML){
    var rtn=null;
    rtn=strHTML.toString();
    rtn=rtn.replace(/&quot;/g,'"');
    rtn=rtn.replace(/&lt;/g,"<");
    rtn=rtn.replace(/&gt;/g,">");
    rtn=rtn.replace(/&amp;/g, "&");
    return rtn;
}

function ReportAbuse(typeID, itemID)
{
	$.ajax({
	  type: "POST",
	  url: $("#AbuseUrl").val() + "?&ms=" + new Date().getTime(),
	  data: "typeID="+typeID+"&itemID="+itemID,
	  success: function(msg) {
		if (msg.toLowerCase() == "false|not logged in.") {
			location.href = $('#LoginUrl').val();
			return false;
		}
		var success = msg.substring(0, msg.indexOf('|'));
		if (success.toLowerCase() == 'true') {
			if (typeID == 1) {	//forum-msg type
				$('#msg'+itemID).html("[<i>Thanks! We'll review the message.</i>]");
			}
		}
		else 
			alert('Oops! We ran into a problem, please refresh the page and try again.');
	  }
	});
}
var myClicker = function()
{ CloseBubble(); }
function CloseBubble() {
    $("#popup_overlay").remove();
    $("#testID").slideUp('fast');
    $("#testID").remove();
    return false;
}