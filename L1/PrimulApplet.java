import java.applet.Applet;
import java.awt.*;

public class PrimulApplet extends Applet{
	int ww, hh;
	
	public void init(){
		ww = this.size().width;
		hh = this.size().height;
		repaint();
	}
	
	public void paint(Graphics g){
		g.drawString("Applet de dimensiunea " + ww + "x" + hh, ww/2 - 100, hh/2 - 10);
	}
}