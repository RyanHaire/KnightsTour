<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Knights Tour</title>
</head>
<body>
	<div style="width: 450px; margin: 0 auto; text-align: center;">
		<form action="KnightsTourServlet" method="GET" style="text-align: left; margin-top: 5rem;">
		<label for="method">Method: </label>
		<select id="method" name="method" required>
			<option selected>Select Method</option>
			<option>Heuristic Method</option>
			<option>Non Intelligent Method</option>
		</select>
		<br/>
		<p>
			Knight Starting Position (default is random if values are -1):  <br/>
			<label for="knightRow">Row Number:</label>
			<input id="knightRow" type="number" min="-1" name="knightRow" value="-1"/>
			<br/>
			<label for="knightCol">Column Number:</label>
			<input id="knightCol" type="number" min="-1" name="knightCol" value="-1"/>
		</p>
		<label for="numOfTours">Number of Knight Tours: </label>
		<input id="numOfTours" type="number" min="1" name="numOfTours" value="1"/>
		<br/>
		<p>
			What is your computer username? (For writing file to desktop)<br/>
			<input type="text" name="userName" placeholder="Enter username" required/>
		</p>
		<p>
			<input type="submit" value="Start Knights Tour(s)"/>
		</p>
	</form>
	</div>
</body>
</html>
