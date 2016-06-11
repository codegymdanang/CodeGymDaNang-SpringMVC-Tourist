<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title>Jerry</title>
</head>
 
<body>
   <table width="100%">
       <tr>
           <td colspan="2"><tiles:insertAttribute name="header" /></td>
       </tr>
       <tr>
           <td width="20%" nowrap="nowrap"><tiles:insertAttribute name="menu" /></td>
           <td width="80%"><tiles:insertAttribute name="body" /></td>
       </tr>
       <tr>
           <td colspan="2"><tiles:insertAttribute name="footer" /></td>
       </tr>
   </table>
</body>
</html>