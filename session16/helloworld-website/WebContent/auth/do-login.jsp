<jsp:useBean id="loginBean" class="karans.s16.auth.LoginBean" />
<jsp:setProperty name="loginBean" property="*" />
Username
<%=loginBean.getUsername()%>
<br />
Password
<%=loginBean.getPassword()%>
<br />