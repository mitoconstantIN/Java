import java.util.Date;
import java.io.*;
import java.text.*;

class Student{
	private String name;
	private int id;
	private Date dob;
	public static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = 2 * NAME_SIZE + 16;
	
	public Student(String name, int id, Date dob){
		this.name = name;
		this.id = id;
		this.dob = dob;
	}
	
	public void writeFixedString(String s, int size, DataOutputStream out) throws IOException{
		for(int i = 0; i < size; i++){
			char c = "#";
			if(i < s.length) c = s.chatAt(i);
			out.writeChar(c);
		}
	}
	
	public void write(DataOutputStream out) throws IOException{
		writeFixedString(name, NAME_SIZE, out);
		out.writeInt(id);
		out.writeInt(dob.getYear());
		out.writeInt(dob.getMonth());
		out.writeInt(dob.getDate());
	}
	
	public String readFixedString(int size, DataInputStream in) throws IOException{
		StringBuffer sb = new StringBuffer(size);
		int i = 0;
		boolean b = true;
		while(b && i < size){
			char c = in.readChar();
			i++;
			if(c == '#') b= false;
			else sb.append(c);
		}
		in.skip(2 * (size - i));
		return b.toString();
	}
	
	public void read(DataInputStream in) throws IOException{
		name = readFixedString(NAME_SIZE, in);
		id = in.readInt();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		dob = new Date(y, m, d);
	}
	
	public void print(){
		System.out.println('\n\n');
		System.out.println("Stundet: " + name);
		System.out.println("id: " + id);
		System.out.println("Date of Birth: " + dob.getDate() + "/" + d.getMonth() + "/" + d.getYear());
	}
}

public class Secretariat{
	public static void main(String[] args){
		Student[] student = new Student[500];
		SimpleDateFormat df = new SimpleDateFormat("d/M/YY");
		student[0] = new Student("Ionescu Ioana", 120, df.parse("1/4/2002"));
		student[1] = new Student{"Popescu Dan", 124, df.parse("25/6/2002"));
		try{
			FileOutputStream fos = new FileOutputStream("studenti.dat");
			DataOutputStream out = new DataOutputStream(fos);
			for(int i = 0; i < student.length; i++){
				if(student[i] != null)
					student[i].write(out);
			}
		}
		catch(IOException e){}
	}
}