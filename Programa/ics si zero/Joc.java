import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Joc extends Frame implements MouseListener, MouseMotionListener, KeyListener{
	
	public Pune pune;
	public Image im;
	public Graphics img;
	
	
	Toolkit tool;
	
	int ww, hh;
	
	public static void main(String[] args){
		new Joc();
	}
	
	public Joc(){
		
		tool = getToolkit();
		Dimension res = tool.getScreenSize();
		ww = (int)(res.width / 2);
		hh = (int)(res.height / 2);
		setResizable(false);
		setBackground(Color.white);
		setTitle("X si 0");
		setLayout(null);
		resize(ww, hh);
		move(0, 0);
		show();
		
		im = createImage(ww, hh);
		img = im.getGraphics();
		
        img.setColor(Color.white);
        img.fillRect(0, 0, ww, hh);
		pune = new Pune(50,50);
		
		addMouseListener(this);
		addMouseMotionListener(this); 
		addKeyListener(this);
		
	}
	
	public void paint(Graphics g){
		update(g);
	}
	
	public void update(Graphics g){
		
		img.setColor(Color.white);
		img.fillRect(0, 0, ww, hh);
		
		img.setColor(Color.black);
		drawTable(img);
		
		if(tastaApasata == '0') {
			
			draw0(pune.x,pune.y);
		
		}
		else if (tastaApasata == 'X' || tastaApasata == 'x') {
			drawX(img);
		}
		
		g.drawImage(im, 0 , 0, this);
	}
	
	public void drawTable(Graphics img){
		img.drawLine(100,100,100,200);
		img.drawLine(150,100,150,200);
		img.drawLine(50,130,200,130);
		img.drawLine(50,160,200,160);
	}
	
	public void drawX(Graphics img){
		img.drawLine(pune.x, pune.y, pune.x + 40, pune.y + 40);
		img.drawLine(pune.x + 40, pune.y, pune.x, pune.y+40);
	}
	
	public void draw0(int x, int y){
		
		img.setColor(Color.RED);
		img.drawOval(x, y, 30, 30);
		
	}
	private char tastaApasata ='\0';
	
	public void keyPressed(KeyEvent e){
		
		char tasta = e.getKeyChar();
		if(tasta == 'X' || tasta == 'x'|| tasta == '0'){
			tastaApasata = tasta;
			repaint();//redesenez imaginea
		}
	}
	
	public void mouseMoved(MouseEvent e){
		pune.x = e.getX();
		pune.y = e.getY();
		repaint();
	} 
	
	@Override
	public void mouseClicked(MouseEvent e){
		
		int x = e.getX();
		int y = e.getY();
		if(tastaApasata == 'x' || tastaApasata == 'X') drawX(img);
		else if(tastaApasata == '0') draw0(x,y);
		repaint();
		
	}
	public void mouseExited(MouseEvent e){
		System.out.println("a iesit ba");
	}
	public void mouseEntered(MouseEvent e){ 
		System.out.println("a intrat");
	}
	public void mousePressed(MouseEvent e){ 
	}
	public void mouseReleased(MouseEvent e){ 
	}
	public void mouseDragged(MouseEvent e){ 
	}
	
	@Override
    public void keyReleased(KeyEvent e) {
        // Implementare pentru keyReleased
    }

    @Override
    public void keyTyped(KeyEvent e) {}
	
}
class Pune{
		int x, y;
		public Pune(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
