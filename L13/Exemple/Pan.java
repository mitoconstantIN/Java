import java.awt.*;


public class Pan extends Panels {

   public Font f=new Font("Helvetica", 1, 18);
   FontMetrics fm = getFontMetrics(f);
   public String s="";
   private int tip;

    public Pan() {
    	super(); 
    }
    
    public Pan(int tip) {
    	this(); 
    	this.tip = tip;
    }    

    public void setText(String s){
    	this.s=s;
    	repaint();
    }
    
    public String getText(){
	return s;
    }    

    public void paint(Graphics g) {
    	super.paint(g);	
	g.setFont(f); 
	
	if(tip==1){
		g.setColor(Color.white);
		g.drawString(s, size().width-fm.stringWidth(s)-6, 20);	
	}else{
		g.setColor(Color.black);
		g.drawString(s, 10, 20);
	}
    }		
     

}
