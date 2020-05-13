import javax.swing.JFrame;

public class Frame {
		
			public Frame() {
	    	JFrame f = new JFrame();
	    	f.setSize(415,480);
			f.setVisible(true);
			f.setTitle("                                 Game of Life");
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Panel p = new Panel();

			f.getContentPane().add(p);
	    
		}
	}