import java.awt.*;

public class Bezier extends Frame{
	Point[] cp;    // pct de control
	int numpoints;  // numarul de pct de control
	Image im;
	Graphics img;
	double k = .025;
	int moveflag = 5;
	Button restart;
	int w = 1000, h = 1000;
	
	public static void main(String args[]){
		new Bezier();
	}
	
	Bezier(){
		Dimension res = getToolkit().getScreenSize();
		setBackground(Color.white);
		setResizable(false);
		setTitle("Deseneaza o curba Bezier");
		setLayout(null);
		restart = new Button("Restart");
		restart.setBounds(50, 50, 50, 25);
		add(restart);
		resize(w, h);
		move((int)((res.width - w)/2), (int)((res.height - h)/2));
		show();
		im = createImage(w, h);
		img = im.getGraphics();
		cp = new Point[4];
	}
	
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		setBackground(Color.white);
		img.setColor(Color.black);
		img.clearRect(0, 0, size().width, size().height);
		//deseneaza pct de control si poligonul de control
		for(int i = 0; i < numpoints; i++){
			img.setColor(Color.red);
			img.fillOval(cp[i].x - 2, cp[i].y - 2, 4, 4);
			img.setColor(Color.blue);
			if(numpoints > 1 && i < (numpoints - 1))
				img.drawLine(cp[i].x, cp[i].y, cp[i+1].x, cp[i+1].y);
		}
		//calculeaza si deseneaza curba Bezier
		if(numpoints == 4){
			int x = cp[0].x, y = cp[0].y;
			img.setColor(Color.black);
			for(double t = k; t <= 1; t += k){
				Point p = Bernstein(cp[0], cp[1], cp[2], cp[3], t);
				img.drawLine(x, y, p.x, p.y);
				x = p.x;
				y = p.y;
			}
		}
		g.drawImage(im, 0, 0, this);
	}
	
	public Point Bernstein(Point p1, Point p2, Point p3, Point p4, double t){
		double x = (1-t)*(1-t)*(1-t)*p1.x + (3*t)*(1-t)*(1-t)*p2.x + (3*t*t)*(1-t)*p3.x + t*t*t*p4.x;
		double y = (1-t)*(1-t)*(1-t)*p1.y + (3*t)*(1-t)*(1-t)*p2.y + (3*t*t)*(1-t)*p3.y + t*t*t*p4.y;
		return new Point((int)Math.round(x), (int)Math.round(y));
	}
	
	public boolean action(Event e, Object o){
		if(e.target == restart){
			numpoints = 0;
			repaint();
			return true;
		}
		return false;
	}
	
	public boolean mouseDown(Event evt, int x, int y){
		Point point = new Point(x, y);
		if(numpoints < 4){
			cp[numpoints] = point;
			numpoints++;
			repaint();
		}else{
			for(int i = 0; i < numpoints; i++)
				for(int j = -2; j < 3; j++)
					for(int l = -2; l < 3; l++)
						if(point.equals(new Point(cp[i].x + j, cp[i].y + 1)))
							moveflag = i;
		}
		return true;
	}
	
	public boolean mouseDrag(Event evt, int x, int y){
		if(moveflag < numpoints){
			cp[moveflag].move(x, y);
			repaint();
		}
		return true;
	}
	
	public boolean mouseUp(Event evt, int x, int y){
		moveflag = 5;
		return true;
	}
	
	public boolean handleEvent(Event e){
		if(e.id == Event.WINDOW_DESTROY){ System.exit(0);}
		return super.handleEvent(e);
	}
	
}