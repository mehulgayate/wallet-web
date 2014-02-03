<!DOCTYPE html>
<html>
<head>
	<title>Page Title</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="stylesheet" href="jquery.mobile-1.4.0.min.css" />
	<script src="jquery-2.1.0.min.js"></script>
	<script src="jquery.mobile-1.4.0.min.js"></script>
</head>
<body>

<div data-role="page">

	<div data-role="header">
		<h1>Expenses</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<label for="text-basic">Start Date</label>
		<input type="date" name="text-basic" id="startDate" value="">
		<label for="text-basic">End Date</label>
		<input type="date" name="text-basic" id="endDate" value="">
		<button class="ui-shadow ui-btn ui-corner-all" id="getExpensesButton">Submit</button>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Click On submit to get Expenses</h4>
	</div><!-- /footer -->
</div><!-- /page -->


<div data-role="page" id="showExpenses">
	<div data-role="header">
		<h1>Page Title</h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		<ul data-role="listview" class="ui-listview-outer" data-inset="true" id="expenseList">
  <li data-role="collapsible" data-iconpos="right" data-shadow="false" data-corners="false">
    <h2>Birds</h2>
    <ul data-role="listview" data-shadow="false" data-inset="true" data-corners="false">
      <li>Condor</li>
      <li><a href="#">Eagle</a></li>
      <li>Sparrow</li>
    </ul>
  </li>
  <li><a href="#">Humans</a></li>
  <li data-role="collapsible" data-iconpos="right" data-shadow="false" data-corners="false">
    <h2>Fish</h2>
    <ul data-role="listview" data-shadow="false" data-inset="true" data-corners="false">
      <li><a href="#">Salmon</a></li>
      <li>Pollock</li>
      <li>Trout</li>
    </ul>
  </li>
  <li data-role="collapsible" data-iconpos="right" data-shadow="false" data-corners="false">
    <h2>Choose your preference</h2>
    <form>
      <fieldset data-role="controlgroup" data-type="horizontal">
        <label>Birds<input type="checkbox" id="choose-birds-regular"></label>
        <label>Humans<input type="checkbox" id="choose-humans-regular"></label>
        <label>Fish<input type="checkbox" id="choose-fish-regular"></label>
      </fieldset>
    </form>
  </li>
</ul>
	</div><!-- /content -->

	<div data-role="footer">
		<h4>Page Footer</h4>
	</div><!-- /footer -->
</div><!-- /page -->

<script type="text/javascript">

$(function(){
	
	$("#getExpensesButton").click(function(){
		
		$.ajax({
			url : "http://localhost:8080/expense/get.json",
			type : "post",
			data : "startDate="+$("#startDate").val()+"&endDate="+$("#endDate").val()+"&id=1",
			dataType : "json",
			success : function(data) {
				alert("succ");
				$.each( data, function( key, value ) {
					  alert( key + ": " + value );
					
				$("#expenseList").append('<li data-role="collapsible" data-iconpos="right" data-shadow="false" data-corners="false">'+
					    '<h2>'+value.date+'</h2>'+
					    '<ul data-role="listview" data-shadow="false" data-inset="true" data-corners="false">'+
					      '<li>'+value.type+'</li>'+
					     ' <li>'+value.amount+'</li>'+
					   ' </ul>'+
					  '</li>')
				});
				
				$.mobile.changePage('#showExpenses');
			},
			error : function() {
				

			}
		});
	});
	
	
});

</script>


</body>
</html>