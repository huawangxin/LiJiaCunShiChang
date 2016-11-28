package 李家村市场;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Scene extends JPanel{
	BufferedImage mapImage ;
	int mapX ;
	int mapY ;
	
	BufferedImage lxyImage ;
	int lxyX = 500;
	int lxyY = 500;
	
	public Scene( String mapFile , String lxyFile ){
		try{
			mapImage = ImageIO.read( new File(mapFile) ) ;
			lxyImage = ImageIO.read( new File(lxyFile) ) ;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g){
		BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB) ;
		Graphics graphics = image.getGraphics() ;
		mapX = (this.getWidth() - lxyImage.getWidth()) / 2 - lxyX ;
		mapY = (this.getHeight() - lxyImage.getHeight()) / 2 - lxyY ;
		graphics.drawImage( mapImage , mapX , mapY , null ) ;
		graphics.drawImage( lxyImage , lxyX + mapX , lxyY + mapY , null ) ;
		
		graphics.dispose();
		g.drawImage( image , 0 , 0 , null ) ;
	}
	
	public void move( int direction ){
		if( direction == 37 ){
			lxyX =lxyX-5 ;
		}else if( direction == 38 ){
			lxyY =lxyY-5 ;
		}else if( direction == 39 ){
			lxyX =lxyX+5 ;
		}else if( direction == 40 ){
			lxyY =lxyY+5 ;
		}
	}
}
