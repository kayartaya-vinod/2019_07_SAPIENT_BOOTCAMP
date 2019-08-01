<%@ include file="./header.txt" %>

	<%!
		public void jspInit() {
		
		}
	
	%>
	<%
		// response.setContentType("text/plain");
		String name = "Vinod Kumar Kayartaya";
		out.println("<p>By <em>" + name + "</em></p>");
		
		String []cities = {"Delhi", "Mumbai", "Bangalore", "Mysore", "Shimoga" };
	%>
	
	<h3>The cities are: </h3>
	<ul>
		<%
			for(String city: cities) {
		%>
		<li> <%= city %> </li>
		<%
			}
		%>
	</ul>
</body>
</html>











