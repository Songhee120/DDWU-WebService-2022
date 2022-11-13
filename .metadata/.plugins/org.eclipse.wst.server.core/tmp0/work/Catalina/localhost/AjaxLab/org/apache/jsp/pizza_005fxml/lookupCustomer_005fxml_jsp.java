/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.63
 * Generated at: 2022-06-06 02:31:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pizza_005fxml;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import example.ajax.pizza.*;
import java.util.*;

public final class lookupCustomer_005fxml_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

 @SuppressWarnings("unchecked") 
  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("example.ajax.pizza");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;


Customer[] customers = new Customer[4];

// Set up some addresses to use
customers[0] = new Customer("Doug Henderson", new Address("7804 Jumping Hill Lane", "Dallas", "Texas", "75218"),
		"010-111-1111", "no recent order");
customers[1] = new Customer("Mary Jenkins", new Address("7081 Teakwood #24C", "Dallas", "Texas", "75182"),
		"010-222-2222", "no recent order");
customers[2] = new Customer("John Jacobs", new Address("234 East Rutherford Drive", "Topeka", "Kansas", "66608"),
		"010-333-3333", "no recent order");
customers[3] = new Customer("Happy Traum", new Address("876 Links Circle", "Topeka", "Kansas", "66608"),
		"010-444-4444", "no recent order");

//application에서 "custMap" 객체 검색
Map<String, Customer> custMap = (Map<String, Customer>)application.getAttribute("custMap");

//custMap 못찾으면 생성
if(custMap == null){
	custMap = new HashMap<String, Customer>();
	for(Customer c : customers){
		custMap.put(c.getPhone(), c);
	}
	application.setAttribute("custMap", custMap);
}

String phone = request.getParameter("phone");
System.out.println("phone number: " + phone);

Customer c = custMap.get(phone);
if(c != null) {

      out.write("<result> <name>");
      out.print(c.getName() );
      out.write("</name>\n");
      out.write("<address>\n");
      out.write("	<street>");
      out.print(c.getAddress().getStreet() );
      out.write("</street>\n");
      out.write("	<city>");
      out.print(c.getAddress().getCity() );
      out.write("</city>\n");
      out.write("	<state>");
      out.print(c.getAddress().getState() );
      out.write("</state>\n");
      out.write("	<zipCode>");
      out.print(c.getAddress().getZipCode() );
      out.write("</zipCode>\n");
      out.write("</address>\n");
      out.write("<recentOrder>");
      out.print(c.getRecentOrder() );
      out.write("</recentOrder>\n");
      out.write("</result>\n");
	
} else {
	response.setStatus(400);
	response.addHeader("Status", "Unregisterd customer");
}

// Pick a customer
//int i = (int) (Math.random() * 4);
//Customer c = customers[i];
//String result = c.getName() + "\n" + c.getAddress();
//
//System.out.println("result: " + result);
//out.print(result);

    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}