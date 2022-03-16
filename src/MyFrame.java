import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{
    public static File file;
	JButton button;
	
	// MyFrame(){		
	// 	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	this.setLayout(new FlowLayout());
		
	// 	button = new JButton("Seleziona il file");
	// 	button.addActionListener(this);
		
	// 	this.add(button);
	// 	this.pack();
	// 	this.setVisible(true);
	// }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==button) {
			
			JFileChooser fileChooser = new JFileChooser();
			
			fileChooser.setCurrentDirectory(new File("."));

			int response = fileChooser.showOpenDialog(null); 
			
			if(response == JFileChooser.APPROVE_OPTION) {
	            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                
			}
		}
	}
}
