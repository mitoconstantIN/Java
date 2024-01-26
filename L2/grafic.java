import java.awt.*;
import java.applet.Applet;

public class grafic extends Applet{
	Image bkg;
	int ww, hh;
	double a, b, c;
	Color colAxe = Color.black, colGrafic = Color.red;
	boolean deseneaza = true;


public void init(){
	ww = size().width;
	hh = size().height;
	String s = getParameter("background");
	if(s!=null) loadImages(s);
	s = getParameter("a");
	if(s!=null) a = Double.valueOf(s).doubleValue(); else deseneaza = false;
	s = getParameter("b");
	if(s!=null) b = Double.valueOf(s).doubleValue(); else deseneaza = false;
	s = getParameter("c");
	if(s!=null) c = Double.valueOf(s).doubleValue(); else deseneaza = false;
	repaint();
}

public void update(Graphics g){
	if(bkg!=null)
		for(int i = 0; i<= (int)(ww/bkg.getWidth(this)); i++)
			for(int j = 0; j<= (int)(hh/bkg.getHeight(this)); j++)
				g.drawImage(bkg, i*bkg.getWidth(this), j*bkg.getHeight(this), this);
	if(deseneaza){axe(g); trace(g);}
}

public void paint(Graphics g) {update(g);}

void loadImages(String nume){
	MediaTracker  mt = new MediaTracker(this);
	bkg = getImage(getDocumentBase(), nume);
	mt.addImage(bkg, 0);
	try{mt.waitForAll();}
	catch(InterruptedException e){}
}

public void axe(Graphics g){
	g.setColor(colAxe);
	g.drawLine(10, hh/2, ww-10, hh/2);
	g.drawLine(ww/2, 10, ww/2, hh-10);
	for(int i=20; i<ww-20; i+=10)g.drawLine(i, hh/2-2, i, hh/2+2);
	for(int j=20; j<hh-20; j+=10)g.drawLine(ww/2-2, j,ww/2+2, j);
}

public void trace(Graphics g){
	g.setColor(colGrafic);
	for (int x=20; x<ww-20;x++)
		g.drawLine(x, (int)functie(x-ww/2) + hh/2, x+1, (int)functie(x-ww/2+1) + hh/2);
	
	int x = (int)(-b/(2*a));
	int y = (int)functie(x);
	g.setColor(Color.blue);
	g.drawLine(x+ww/2, hh/2, x+ww/2, y+hh/2);
	g.drawLine(ww/2, y+hh/2, x+ww/2, y+hh/2);
}

double functie(double x) {return -(a*x*x + b*x + c);}

}