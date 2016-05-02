<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
 	<link rel="stylesheet" href="lib/jquerybsgrid/1.37/merged/bsgrid.all.min.css"/>
    <script type="text/javascript" src="lib/jquery/1.11.2/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="lib/jquerybsgrid/1.37/js/lang/grid.zh-CN.min.js"></script>
    <script type="text/javascript" src="lib/jquerybsgrid/1.37/merged/bsgrid.all.min.js"></script>
    
  </head>
  
  <body>
    <table id="searchTable">
        <tr>
            <th w_index="XH" width="5%;">XH</th>
            <th w_index="ID" width="5%;">ID</th>
            <th w_index="CHAR" w_align="left" width="15%;">CHAR</th>
            <th w_index="TEXT" w_align="left" width="30%;">TEXT</th>
            <th w_index="DATE" width="15%;">DATE</th>
            <th w_index="TIME" width="15%;">TIME</th>
            <th w_index="NUM" width="5%;">NUM</th>
            <th w_render="operate" width="10%;">Operate</th>
        </tr>
    </table>
    
	<script type="text/javascript">
		var data = [
				{"XH": 1,"ID": 100,"CHAR": "char_0","TEXT": "TEXT_TEXT_TEXT_TEXT_0","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 0},
				{"XH": 2,"ID": 99,"CHAR": "char_1","TEXT": "TEXT_TEXT_TEXT_TEXT_1","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 10},
				{"XH": 3,"ID": 98,"CHAR": "char_2","TEXT": "TEXT_TEXT_TEXT_TEXT_2","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 20},
				{"XH": 4,"ID": 97,"CHAR": "char_3","TEXT": "TEXT_TEXT_TEXT_TEXT_3","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 30},
				{"XH": 5,"ID": 96,"CHAR": "char_4","TEXT": "TEXT_TEXT_TEXT_TEXT_4","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 40},
				{"XH": 6,"ID": 95,"CHAR": "char_5","TEXT": "TEXT_TEXT_TEXT_TEXT_5","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 50},
				{"XH": 7,"ID": 94,"CHAR": "char_6","TEXT": "TEXT_TEXT_TEXT_TEXT_6","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 60},
				{"XH": 8,"ID": 93,"CHAR": "char_7","TEXT": "TEXT_TEXT_TEXT_TEXT_7","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 70},
				{"XH": 9,"ID": 92,"CHAR": "char_8","TEXT": "TEXT_TEXT_TEXT_TEXT_8","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 80},
				{"XH": 10,"ID": 91,"CHAR": "char_9","TEXT": "TEXT_TEXT_TEXT_TEXT_9","DATE": "2012-12-12 15:01:01","TIME": "15:01:01","NUM": 90}
			];
			
        var gridObj;
        $(function () {
            gridObj = $.fn.bsgrid.init('searchTable', {
                //url: 'data/json.jsp',
                localData:data,
                // autoLoad: false,
                pageSizeSelect: true,
                pageSize: 4
            });
        });

        function operate(record, rowIndex, colIndex, options) {
            return '<a href="#" onclick="alert(\'ID=' + gridObj.getRecordIndexValue(record, 'ID') + '\');">Operate</a>';
        }
    </script>
  </body>
</html>