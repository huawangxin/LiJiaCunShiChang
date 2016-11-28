package 李家村市场1;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class LiJiaCun extends JPanel {
	
	BufferedImage mapImage;
	BufferedImage lxyUpImage[]=new BufferedImage[8];
	BufferedImage lxyLeftImage[]=new BufferedImage[8];
	BufferedImage lxyRightImage[]=new BufferedImage[8];
	BufferedImage lxyDownImage[]=new BufferedImage[8];
	BufferedImage lxyImage;
	int mapX=-300;
	int mapY=-300;
	int lxyX=800;
	int lxyY=600;
	int lxyIndex=0;
	
	public LiJiaCun(){
		try {
			mapImage=ImageIO.read(new File("e:/ftp/map.png"));
			for(int i=0;i<8;i++){
				lxyUpImage[i]=ImageIO.read(new File("e:/ftp/李逍遥/李逍遥上/"+i+".png"));
				lxyDownImage[i]=ImageIO.read(new File("e:/ftp/李逍遥/李逍遥下/"+i+".png"));
				lxyLeftImage[i]=ImageIO.read(new File("e:/ftp/李逍遥/李逍遥左/"+i+".png"));
				lxyRightImage[i]=ImageIO.read(new File("e:/ftp/李逍遥/李逍遥右/"+i+".png"));
			}
		} catch (Exception e) {
			e.printStackTrace();		
			}lxyImage=lxyDownImage[0];
	}
	
	public void paint(Graphics g){
		BufferedImage bufferedImage=new BufferedImage(this.getWidth(), this.getHeight(), 2);
		
		Graphics bufferG=bufferedImage.getGraphics();
		mapX=(this.getWidth()-lxyImage.getWidth())/2-lxyX;
		mapY=(this.getHeight()-lxyImage.getHeight())/2-lxyY;
		bufferG.drawImage(mapImage,  mapX, mapY,null);
		bufferG.drawImage(lxyImage, lxyX+mapX, lxyY+mapY, null);
		bufferG.dispose();
		
		g.drawImage(bufferedImage, 0, 0, null);
	}
	public void move(int direction){
		lxyIndex++;
		if(lxyIndex==8){
			lxyIndex=0;
		}
		if(direction==KeyEvent.VK_UP){
			lxyY--;
			lxyImage=lxyUpImage[lxyIndex];
		}else if(direction==KeyEvent.VK_DOWN){
			lxyY++;
			lxyImage=lxyDownImage[lxyIndex];
		}else if(direction==KeyEvent.VK_LEFT){
			lxyX--;
			lxyImage=lxyLeftImage[lxyIndex];
		}else if(direction==KeyEvent.VK_RIGHT){
			lxyX++;
			lxyImage=lxyRightImage[lxyIndex];
		}
	}

}
