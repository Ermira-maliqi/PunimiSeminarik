import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Panel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	int size = 20;
	int xPanel = 400, yPanel = 400;
	public int xwidth =xPanel/size;
	public int yheight = yPanel/size;
	public int[][] life = new int[xwidth][yheight];
	int[][] beforeLife = new int[xwidth][yheight];
	boolean start = true;

	Panel(){
		
		new Timer(1500,this).start();
	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		grid(g);
		cells(g);
		display(g);
	}

	
	private void grid(Graphics g) {
		
		g.setColor(Color.gray);
		g.fillRect(0, 0, 1500, 1000);
		g.setColor(Color.black);
		g.drawString("Nje shembull i lojes Game of Life", 100, 425);
		g.setColor(Color.DARK_GRAY);
		
		for(int i = 0; i<life.length+1; i++) {
			
			g.drawLine(0, i*size, xPanel, i*size); //row
			g.drawLine(i*size,0,i*size, yPanel); //column

		}
	
	}
	 private void cells(Graphics g) {
			
		 if(start) {
				beforeLife[5][3]=1;
				beforeLife[6][4]=1;
				beforeLife[4][5]=1;
				beforeLife[5][5]=1;
				beforeLife[6][5]=1;
				beforeLife[10][5]=1;
				beforeLife[11][5]=1;
				beforeLife[12][5]=1;

		 	}
		 start = false;
	 }
		
	 private void display(Graphics g) {
		 
		g.setColor(Color.black);
		
		 copyArray();

		for(int x=0;x<life.length;x++) {
			for(int y =0;y<yPanel/size;y++) {
			if(life[x][y]==1) {	
			g.fillRect(x*size+1, y*size+1, size-1, size-1);
				}
			}
		 }
	 }
	 
	 private void copyArray() {
			for(int x=0;x<life.length;x++) {
				for(int y =0;y<yPanel/size;y++) {
				
				life[x][y]=beforeLife[x][y];
				
					}
			}
	 }
	 int check(int x, int y) {
		 int alive =0;
		 alive += life[(x-1+xwidth)%(xwidth)][(y-1+yheight)%yheight];
		 alive += life[(x-1+xwidth)%xwidth][(y+yheight)%yheight];
		 alive += life[(x-1+xwidth)%xwidth][(y+1+yheight)%yheight];
		 alive += life[(x+xwidth)%xwidth][(y-1+yheight)%yheight];
		 alive += life[(x+xwidth)%xwidth][(y+1+yheight)%yheight];
		 alive += life[(x+1+xwidth)%xwidth][(y+yheight)%yheight];
		 alive += life[(x+1+xwidth)%xwidth][(y-1+yheight)%yheight];
		 alive += life[(x+1+xwidth)%xwidth][(y+1+yheight)%yheight];
		 return alive;
	 }

	 public void actionPerformed(ActionEvent e) {
			
			int alive;
			for(int x=0;x<(life.length);x++) {
				for(int y =0;y<(yPanel/size);y++) {
					
					alive = check(x,y);
					
					if(alive==3) {	

						beforeLife[x][y]=1;				
					}
					else
						if(alive == 2 && life[x][y]==1){
						beforeLife[x][y]=1;	
					}
						else {
						beforeLife[x][y]=0;
					}
				}
			 }
			repaint();					
		}
}
