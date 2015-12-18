<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Spring MVC Autocomplete with JQuery &amp; JSON example</title>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

</head>

<body>
<h2>Autocomplete Search</h2>
<form action="/ElasticSearch_Autocomplete/result" method="GET">
Company Name: <input type="text" id="name" name="name">
<input type="submit" value="Search" />
</form>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {

							$("#name")
									.autocomplete(
											{
												source : '${pageContext. request. contextPath}/searchnames'
											});

						});
	</script>

</body>
</html>