<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<h2>Login Page</h2>
</head>
<body bgcolor="powderblue">

	<form action="/home" method="post">
	<table align="center" border=1 style="margin-top:50px ">
		<tr>
			<td> User :</td>
			<td> <input type ="text" name="user"> </input> </td>
		</tr>
		<tr>
		<td> Password :</td> 
		<td> <input type="password"  name="password"> </input> </td>
	</tr>
	<tr>
	
		<td><input type="submit" value="login"> </input> </td>
		<td><input type="reset" value="Reset"> </input> </td>
	</tr>
	<tr>
		<td>
			<a href="/sign-up"> New User Sign-up</a>
			<a href="/forget"> Forget Password</a>
		</td>
	</tr>
	</table>
	</form>

</body>
</html>