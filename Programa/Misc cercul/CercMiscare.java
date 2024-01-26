import java.awt.*;
import java.awt.event.*;

public class CercMiscare extends Frame implements MouseListener, MouseMotionListener{
	
	public Cerc cerc;
	public Image im;
	public Graphics img;
	
	Toolkit tool;
	
	int ww, hh;
	
	public static void main(String[] args){
		new CercMiscare();
	}
	
	public CercMiscare(){
		tool = getToolkit();
		Dimension res = tool.getScreenSize();
		ww = (int)(res.width / 2);
		hh = (int)(res.height / 2);
		setResizable(false);
		setBackground(Color.white);
		setTitle("pl");
		setLayout(null);
		resize(ww, hh);
		move(0, 0);
		show();
		im = createImage(ww, hh);
		img = im.getGraphics();
		
		cerc = new Cerc(50, (int)(ww / 2), (int)(hh / 2));
		
		addMouseListener(this);
		addMouseMotionListener(this); 
	}
	
	public void paint(Graphics g){ 
		update(g);
	}
	
	public void update(Graphics g){ 
		img.setColor(Color.white);
		img.fillRect(0, 0, ww, hh);
		
		img.setColor(Color.black);
		img.drawOval(cerc.x, cerc.y, cerc.raza, cerc.raza);
		
		g.drawImage(im, 0, 0, this);
	}
	
	public void mouseMoved(MouseEvent e){
		cerc.x = e.getX();
		cerc.y = e.getY();
		repaint();
	} 
	
	public void mouseExited(MouseEvent e){
		System.out.println("a iesit ba");
	}
	public void mouseEntered(MouseEvent e){ 
		System.out.println("a intrat");
	}
	public void mouseClicked(MouseEvent e){ 
	}
	public void mousePressed(MouseEvent e){ 
	}
	public void mouseReleased(MouseEvent e){ 
	}
	public void mouseDragged(MouseEvent e){ 
	}
	
}

class Cerc{
	int raza;
	int x, y;
	
	public Cerc(int raza, int x, int y){
		this.raza = raza;
		this.x = x;
		this.y = y;
	}
}