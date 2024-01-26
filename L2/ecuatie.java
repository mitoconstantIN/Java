public class ecuatie{
	static double a, b, c, delta, centru;
	String x1, x2;


public static void main(String[]args){
	try{a = Double.valueOf(args[0]).doubleValue();}
	catch(Exception e){return;}
	try{b = Double.valueOf(args[1]).doubleValue();}
	catch(Exception e){return;}
	try{c = Double.valueOf(args[2]).doubleValue();}
	catch(Exception e){return;}
	new ecuatie(a, b, c);
}

public ecuatie(double a, double b, double c){
	delta = b*b - 4*a*c;
	centru = -b/(2*a);
	double d = 0;
	if(delta >= 0){
		d = Math.sqrt(delta)/(2*a);
		x1 = "" + (float)(centru - d);
		x2 = "" + (float)(centru + d);
	}else{
		d = Math.sqrt(-delta)/(2*a);
		x1 = (float)centru + " - i" + (float)d;
		x2 = (float)centru + " + i" + (float)d;
	}
	write(a, b, c);
}

public void write(double a, double b, double c){
	System.out.println("<HTML>");
	System.out.println("<HEAD><TITLE>Exemplu de export HTML</TITLE></HEAD>");
	System.out.println("<BODY BACKGROUND=\"bkg.jpg\" BGPROPERTIES=\"fixed\">");
	System.out.println("<CENTER>");
	System.out.println("<H2>Ecua&#355;ia de gradul II</H2>");
	System.out.println("<HR>");
	System.out.println("A&#355;i introdus parametrii: a = " + a + ", b = " + b + ", c = " + c);
	System.out.println("<BR>");
	String b1, c1;
	if(b<0) b1 = "- " + (-b); else b1 = "+ " + b;
	if(c<0) c1 = "- " + (-c); else c1 = "+ " + c;
	System.out.println("Ecua&#355;ia este: " + a + "X<SUP>2</SUP> " + b1 + "X " + c1 + " =0");
	System.out.println("<HR>");
	System.out.println("<TABLE WIDTH=100%>");
	System.out.println("<THEAD>");
	System.out.println("<TR ALIGN=center>");
	System.out.println("<TH> </TH>");
	System.out.println("<TH>Grafic</TH>");
	System.out.println("</TR>");
	System.out.println("</THEAD>");
	System.out.println("<TBODY>");
	System.out.println("<TR>");
	System.out.println("<TD>");
	System.out.println("<TABLE BORDER=1>");
	System.out.println("<CAPTION ALIGN=center><B>Rezolvare</B></CAPTION>");
	System.out.println("<TR>");
	System.out.println("<TD ALIGN=center>DELTA</TD>");
	System.out.println("<TD>" + (float)delta + "</TD>");
	System.out.println("</TR>");
	System.out.println("<TD ALIGN=center>CENTRU</TD>");
	System.out.println("<TD>" + (float)centru + "</TD>");
	System.out.println("<TR>");
	System.out.println("<TD ALIGN=center>X<SUB>1</SUB></TD>");
	System.out.println("<TD>" + x1 + "</TD>");
	System.out.println("</TR>");
	System.out.println("<TR>");
	System.out.println("<TD ALIGN=center>X<SUB>2</SUB></TD>");
	System.out.println("<TD>" + x2 + "</TD>");
	System.out.println("</TR>");
	System.out.println("</TABLE>");
	System.out.println("</TD>");
	System.out.println("<TD ALIGN=center>");
	System.out.println("<APPLET CODE=\"grafic.class\" WIDTH=600 HEIGHT=700");
	System.out.println("<PARAM NAME=\"background\" VALUE=\"bkg.jpg\">");
	System.out.println("<PARAM NAME=\"a\" VALUE=" + a + ">");
	System.out.println("<PARAM NAME=\"b\" VALUE=" + b + ">");
	System.out.println("<PARAM NAME=\"c\" VALUE=" + c + ">");
	System.out.println("</APPLET>");
	System.out.println("</TD>");
	System.out.println("</TR>");
	System.out.println("</TBODY>");
	System.out.println("</TABLE>");
	System.out.println("</BODY>");
	System.out.println("</HTML>");
}
}