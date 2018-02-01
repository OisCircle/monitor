<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

int x=900;
int y=300;
int r=250;
int pr=2;
List<Integer> a=new ArrayList<Integer>();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><title></title></head>
<svg xmlns="http://www.w3.org/2000/svg" version="1.1">
  <circle cx=<%= x %> cy=<%= y %> r=<%= r %> stroke="#FAEBD7" stroke-width="2" fill="#FAEBD7"/>
  <circle cx=<%= x %> cy=<%= y %> r=<%= pr %> stroke="#8A2BE2" stroke-width="0" fill="#8A2BE2"/>
</svg>
</html>
