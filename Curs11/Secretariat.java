import java.io.*;
import java.util.*;
import java.text.*;

class An implements Serializable{
	private String name;
	private Grupa[] grupe;
	
	public An(String name, Grupa[] grupe){
		this.name = name;
		this.grupe = grupe;
	}
	
	public void setNAME(String name){
		this.name = name;
	}
	
	public void setGRUPE(Grupa[] grupe){
		this.grupe = grupe;
	}
	
	public String getNAME(){
		return name;
	}
	
	public Grupa[] getGRUPE(){
		return grupe;
	}
	
	public String toString(){
		String info = "ANUL: "+ name + "\n\n";
		for(int i = 0; i < grupe.length && grupe[i] != null; i++)
			info += grupe[i].toString();
		return info;
	}
}

class Grupa implements Serializable{
	private String name;
	private Vector students;
	
	public Grupa(String name, Vector students){
		this.name = name;
		this.students = students;
	}
	
	public void setNAME(String name){
		this.name = name;
	}
	
	public void setSTUDENTS(Vector students){
		this.students = students;
	}
	
	public String getNAME(){
		return name;
	}
	
	public Vector getSTUDENTS(){
		return students;
	}
	
	public void addStudent(Student student){
		students.addElement(student);
	}
	
	public void removeStudent(Student student){
		students.remove(student);
	}
	
	public void removeAllStudents(){
		students.removeAllElements();
	}
	
	public Student getStudent(int index){
		return (Student)students.elementAt(index);
	}
	
	public int getStudentsCount(){
		return students.size();
	}
	
	public String toString(){
		String info = "GRUPA: " + name + "\n\n";
		for(int i = 0; i < students.size(); i++)
			info += getStudent(i).toString();
		return info;
	}
}

class Student implements Serializable{
	public static final String[] M = {"ianuarie", "februarie", "martie", "aprilie", "mai", "iunie", "iulie", "august", "septembrie", "octombrie", "noiembrie", "decembrie"};
	public static final String[] Q = {"student", "sef de grupa", "sef de an", "responsabil studenti"};
	
	private String name;
	private int id;
	private Date dob;		//data nasterii
	private boolean status = true; //false - restantier , true - integralist
	private int quality; // 0 - student , 1 - sef de grupa , 2 - sef de an , 3 - responsabil studenti
	private Grupa grupa; // va stoca grupa subordonata in cazul sefului de grupa
	private Grupa[] grupe; // va stoca grupele subordonate in cazul sefului de an
	private An[] ani; // va stoca anii subordonati in cazul responsabilului cu studentii
	
	public Student(String name, int id, String dob, int quality, boolean status) throws ParseException{
		//dob este un string de forma "d/M/yy"
		this.name = name;
		this.id = id;
		this.dob = (new SimpleDateFormat("d/M/yy")).parse(dob);
		this.quality = quality;
		this.status = status;
	}
	
	public void setNAME(String name){
		this.name = name;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setDOB(String dob) throws ParseException{
		this.dob = (new SimpleDateFormat("d/M/yy")).parse(dob);
	}
	
	public void setQUALITY(int quality){
		this.quality = quality;
	}
	
	public void setSTATUS(boolean status){
		this.status = status;
	}
	
	public void setGRUPA(Grupa grupa){
		if(quality == 1)
			this.grupa = grupa;
	}
	
	public void setGRUPE(Grupa[] grupe){
		if(quality == 2)
			this.grupe = grupe;
	}
	
	public void setANI(An[] ani){
		if(quality == 3)
			this.ani = ani;
	}
	
	public String getNAME(){
		return name;
	}
	
	public int getID(){
		return id;
	}
	
	public Date getDOB(){
		return dob;
	}
	
	public int getQUALITY(){
		return quality;
	}
	
	public boolean getSTATUS(){
		return status;
	}
	
	public Grupa getGRUPA(){
		return grupa;
	}
	
	public Grupa[] getGRUPE(){
		return grupe;
	}
	
	public An[] getANI(){
		return ani;
	}
	
	public String toString(){
		String info = name + " / ";
		info += "ID: " + id + " / ";
		info += "DOB: " + dob.getDate() + " " + Student.M[dob.getMonth()] + " " + dob.getYear() + " / "; // +1 la getMonth()
		info += Student.Q[quality] + " / ";
		info += status ? "Integralist" : "Restantier" + " / ";
		info += "\n";
		return info;
	}
}

public class Secretariat{
	public static void main(String[] args) throws Exception{
		Grupa grupa = new Grupa("M534", new Vector());
		Student student = new Student("Ionescu Paul", 101, "22/3/2004", 1, true);
		student.getGRUPA();
		grupa.addStudent(new Student("Zvonia Raluca", 104, "10/3/2004", 0, true));
		grupa.addStudent(new Student("Tudorescu Lorena", 108, "12/12/2004", 0, true));
		grupa.addStudent(new Student("Popescu Ana Maria", 109, "1/2/2004", 0, false));
		System.out.println(student.getGRUPA());
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studenti"));
		
		oos.writeObject(grupa);
		
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studenti"));
		
		grupa = (Grupa)ois.readObject();
		
		System.out.println(grupa);
		
		ois.close();
	}
}