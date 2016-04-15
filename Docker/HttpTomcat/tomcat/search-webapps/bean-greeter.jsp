<jsp:useBean id="greeter" class="org.gradle.sample.Greeter" />

<html>

<head>
<title>Been Greeter</title>
</head>

<body>
	<h1>Greeting from bean</h1>

	<p>from org..Greeter: ${greeter.greeting}</p>
	<p>from org...Greeter.hello: ${greeter.hello}</p>
</body>

</html>