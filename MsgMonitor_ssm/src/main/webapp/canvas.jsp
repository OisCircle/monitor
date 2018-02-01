<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'canvas.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<body>

<!-- 添加canvas标签，并加上红色边框以便于在页面上查看 -->
<canvas id="myCanvas" width="400px" height="300px" style="border: 1px solid red;">
您的浏览器不支持canvas标签。
</canvas>

<script type="text/javascript">
//获取Canvas对象(画布)
var canvas = document.getElementById("myCanvas");
//简单地检测当前浏览器是否支持Canvas对象，以免在一些不支持html5的浏览器中提示语法错误
if(canvas.getContext){  
    //获取对应的CanvasRenderingContext2D对象(画笔)
    var ctx = canvas.getContext("2d");  
    
    //开始一个新的绘制路径
    ctx.beginPath();
    //设置弧线的颜色为蓝色
    ctx.strokeStyle = "blue";
    var circle = {
        x : 100,    //圆心的x轴坐标值
        y : 100,    //圆心的y轴坐标值
        r : 50      //圆的半径
    };
    //沿着坐标点(100,100)为圆心、半径为50px的圆的顺时针方向绘制弧线
    ctx.arc(circle.x, circle.y, circle.r, 0, Math.PI / 2, false);    
    //按照指定的路径绘制弧线
    ctx.stroke();
}
</script>
</body>
</html>
