import java.util.Scanner;

public class Spieler {
	public boolean chance = true;
    public char element;
    public boolean isComputer;
    Scanner scanner = new Scanner(System.in);
    
    public Spieler(char element){
    	this.element = element;
    	try {
			if (isValidElement(this.element)) {
			    
			    System.out.println("Element accepted");
			}else {
				throw new IllegalArgumentException();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error beim initialiserung des Spielers, nochmals versuchen:");
			char temp= scanner.next().charAt(0);
			
			if(isValidElement(temp)) {
				this.element = temp;
			}else {
				throw new IllegalArgumentException("Falsche Eingabe");
			}
						
		}
        
    }
    public boolean isValidElement(char element){
        char[] valid_elements = {'X', 'O', 'x', 'o'};
        for (int i = 0; i < valid_elements.length; i++) {
            if (element == valid_elements[i]){
                return true;
            }
        }
        return false;
    }
	public void moveElement(Spielbrett spielbrett, Spieler gegner) {
		// TODO Auto-generated method stub
		
	}
    
}
