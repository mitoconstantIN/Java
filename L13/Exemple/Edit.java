import java.awt.*;

public class Edit extends Frame{
	Exemple ex;
	TextArea ta;

public Edit(Exemple ex){
       this.ex = ex;
       setTitle("Edit");
       setIconImage(ex.ico);
       ta = new TextArea();
       add("Center", ta);
       ta.requestFocus();
       Toolkit tool=getToolkit();
       Dimension res=tool.getScreenSize();
       reshape((int)((res.width-400)/2+100),(int)((res.height-400)/2+100), 400, 400);
}

public boolean handleEvent(Event e){
       if(e.id==Event.WINDOW_DESTROY){
       	 dispose();
       	 return true;
       }else return false;	
}

}