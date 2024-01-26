import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class PanouAutentificare extends Frame implements ActionListener {
    private TextField utilizatorField;
    private TextField parolaField;
    private Button autentificareButton;
	
	

    public PanouAutentificare() {
		//String caleFisier = "C:\java\Laboratoare\Programa\Panou autentificare\nume.txt"
		
        setTitle("Autentificare");
        setSize(300, 150);
        setLayout(new GridLayout(3, 2));
        add(new Label("Utilizator:"));
        utilizatorField = new TextField();
        add(utilizatorField);
        add(new Label("Parola:"));
        parolaField = new TextField();
        parolaField.setEchoChar('*'); // Pentru a masca parola cu '*'
        add(parolaField);
        autentificareButton = new Button("Autentificare");
        autentificareButton.addActionListener(this);
        add(autentificareButton);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Închide fereastra
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == autentificareButton) {
            String utilizator = utilizatorField.getText();
            String parola = parolaField.getText();
			
			ArrayList<String> utilizatorCorect = citireNumeDinFisier();
			ArrayList<String> parolaCorecta = citireParolaDinFisier();
          
		  for(int i = 0; i<= utilizatorCorect.size(); i++){
			String numeDeLaPozitiaI = utilizatorCorect.get(i);
			String parolaDeLaPozitiaI = parolaCorecta.get(i);
			
		  // Verificare utilizator si parola simpla
            if (utilizator.equals(numeDeLaPozitiaI) && parola.equals(parolaDeLaPozitiaI)) {
                System.out.println("Autentificare reusita!");
                return;
            } else {
                System.out.println("Autentificare esuata. Utilizator sau parola incorecte.");
            }
		  }
        }
    }
	
	public static ArrayList<String> citireNumeDinFisier(){
		
		String calea = "C:\\java\\Laboratoare\\Programa\\PanouAutentificare\\nume.txt";
		ArrayList<String> nume = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(calea))){
			String linie;
			while((linie =  reader.readLine()) != null){
				nume.add(linie);
			}
		}
		catch(IOException e){
			System.out.println("Eroare la citirea fisierului");
		}
		
		return nume;
	}
	
	public static ArrayList<String> citireParolaDinFisier(){
		String calea = "C:\\java\\Laboratoare\\Programa\\PanouAutentificare\\parole.txt";
		ArrayList<String> parola = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(calea))){
			String linie;
			while((linie =  reader.readLine()) != null){
				parola.add(linie);
			}
		}
		catch(IOException e){
			System.out.println("Eroare la citirea fisierului");
		}
		return parola;
	}

    public static void main(String[] args) {
        new PanouAutentificare();
    }
}
