<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="/resources/core/jquery.1.10.2.min.js"></script>
<script type="text/javascript" src="/resources/core/jquery.autocomplete.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/core/main.css" type="text/css">

<script type="text/javascript">
$(document).ready(function() {
	
	$('#employeeName').autocomplete({
		source: '${pageContext.request.contextPath}/searchnames'
	});
});


</script>
</head>
<body>
	<h2>Spring MVC + jQuery + Autocomplete example</h2>

	<div>
		<input type="text"  id="employeeName">
		<span>
			<button id="w-button-search" type="button">Search</button>
		</span>
	</div>
	
</body>
</html>