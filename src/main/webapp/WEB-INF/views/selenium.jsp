<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>

<title>Start Spring MVC</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#site").change(function () {
            if ($(this).val() == "PTC") {
                $("#dvPassport").show();
            } else {
                $("#dvPassport").hide();
            }
        });
    });
</script>

</head>
<body>
	<form action="two" method="get">
		

			<select id="site" onchange="changeStatus()" name="sites">
				<option value="inneo">Inneo</option>
				<option value="PTC">PTC</option>
				<option value="boundary">boundarysys</option>
				<option value="concurrent">concurrent</option>
				<option value="pdvision">PDVision</option>
				<option value="tristar">Tristar</option>
				
			</select>
			<input type="submit" value="Submit" />

	<div id="dvPassport" style="display: none">
			<input type="text" name="start">start
			<input type="text" name="end">end
	
	</div>
	</form>
</body>
</html>