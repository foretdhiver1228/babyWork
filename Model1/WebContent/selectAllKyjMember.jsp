<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="bitcamp.java142.ch5.kyjjf.dao.KyjMemberDAOImpl" %>
<%@ page import="bitcamp.java142.ch5.kyjjf.dao.KyjMemberDAO" %> 
<%@ page import="bitcamp.java142.ch5.kyjjf.vo.KyjMemberVO" %> 

<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
		<title>Insert title here</title>

	</head>
	<body>
		<% 
			// KyjMemberDAO kdao = null;
			KyjMemberDAO kdao = new KyjMemberDAOImpl();
			ArrayList<KyjMemberVO> aList = kdao.selectKyjMember();
			
			if(aList.size()==0){
		%>
		
		<table border="1">
			<tr>
				<td>NO DATA</td>
			</tr>
		</table>
		<% 
			}else{ 
		%>
		<table border="1">
			<tr>
				<td colspan="12" align="center"><h3>ȸ������</h3></td>
			</tr>
			<tr>
				<td align="center">ȸ����ȣ</td>
				<td align="center">���̵�</td>
				<td align="center">��й�ȣ</td>
				<td align="center">�̸�</td>
				<td align="center">�������</td>
				<td align="center">�޴�����ȣ</td>
				<td align="center">�̸���</td>
				<td align="center">������ȣ</td>
				<td align="center">���θ��ּ�</td>
				<td align="center">��������</td>
				<td align="center">�Է���</td>
				<td align="center">������</td>
			</tr>
		<% 
			for(int i=0;i<aList.size();i++){
				KyjMemberVO kvo = aList.get(i);
		%>
			<tr>
				<td><%=kvo.getKnumm() %></td>
				<td><%=kvo.getKid() %></td>
				<td><%=kvo.getKpw() %></td>
				<td><%=kvo.getKname() %></td>
				<td><%=kvo.getKbirth() %></td>
				<td><%=kvo.getKhp() %></td>
				<td><%=kvo.getKemail() %></td>
				<td><%=kvo.getKpostno() %></td>
				<td><%=kvo.getKjuso() %></td>
				<td align="center"><%=kvo.getKdeleteyn() %></td>
				<td><%=kvo.getKinsertdate() %></td>
				<td><%=kvo.getKupdatedate() %></td>
			</tr>
		<%
				}
			}
		%>
			
		</table>
	</body>
</html>