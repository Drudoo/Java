import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class RandomUserForm extends javax.swing.JFrame implements Observer {
	public RandomUserForm {
		initComponents();
		RandomUserForm.addObserver(this);
	}
	
}