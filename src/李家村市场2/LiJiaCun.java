package 李家村市场2;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class LiJiaCun extends Base{
	int mapData[][] ;
	BufferedImage mapImage ;
	BufferedImage mapdata;
	BufferedImage zgwImage;
	int mapX = -300 ;
	int mapY = -300 ;
	BufferedImage lxyLeftImage[] = new BufferedImage[8] ;
	BufferedImage lxyUpImage[] = new BufferedImage[8] ;
	BufferedImage lxyRightImage[] = new BufferedImage[8] ;
	BufferedImage lxyDownImage[] = new BufferedImage[8] ;
	BufferedImage lxyImage ;
	int lxyIndex ;
	int lxyX = 1600 ;
	int lxyY = 600 ;
	Rectangle rect = new Rectangle(1880 , 610 , 40 , 160) ;
	/**
	 * 初始化场景数据
	 */
	public LiJiaCun(){
		try{
			mapImage = ImageIO.read( new File("E:/ftp/map.png") ) ;
			mapdata=ImageIO.read(new File("e:/ftp/mapdata.png"));
			zgwImage=ImageIO.read(new File("e:/ftp/zgw.png"));
			for( int i = 0 ; i < 8 ; i ++ ){
				lxyUpImage[i] = ImageIO.read( new File("E:/ftp/李逍遥/李逍遥上/"+i+".png") ) ;
				lxyDownImage[i] = ImageIO.read( new File("E:/ftp/李逍遥/李逍遥下/"+i+".png") ) ;
				lxyLeftImage[i] = ImageIO.read( new File("E:/ftp/李逍遥/李逍遥左/"+i+".png") ) ;
				lxyRightImage[i] = ImageIO.read( new File("E:/ftp/李逍遥/李逍遥右/"+i+".png") ) ;
			}
		}catch( Exception e ){
			e.printStackTrace() ;
		}
		mapData= new int[mapImage.getWidth()][mapImage.getHeight()] ;
		lxyImage = lxyDownImage[0] ;
		for( int x = rect.x ; x < rect.x + rect.width ; x ++ ){
			for( int y = rect.y ; y < rect.y + rect.height ; y ++  ){
				mapData[x][y] = 1 ;
			}
		}
	}
	public void paint(Graphics g){
		BufferedImage bufferedImage = new BufferedImage( this.getWidth() , this.getHeight() , 2 ) ;
		Graphics bufferG = bufferedImage.getGraphics() ;
		
		mapX = ( this.getWidth() - lxyImage.getWidth() ) / 2 - lxyX ;
		mapY = ( this.getHeight() - lxyImage.getHeight() ) / 2 - lxyY ;
		

		if( mapX > 0 )
			mapX = 0 ;
		if( mapY > 0 )
			mapY = 0 ;
		if( mapX < this.getWidth() - mapImage.getWidth() )
			mapX = this.getWidth() - mapImage.getWidth() ;
		if( mapY < this.getHeight() - mapImage.getHeight() )
			mapY = this.getHeight() - mapImage.getHeight() ;
		bufferG.drawImage( mapImage , mapX , mapY , null ) ;  
		bufferG.drawImage( lxyImage , lxyX + mapX , lxyY + mapY , null ) ;
		

		bufferG.drawImage(zgwImage,mapX,mapY,null);
		
		
		bufferG.dispose() ; //，删除画笔，释放资源
		g.drawImage( bufferedImage , 0 , 0 , null ) ;
	}
	public int move( int direction ){
	 mapNum = 0 ;
		lxyIndex ++ ;
		if( lxyIndex == 8 ) 
			lxyIndex = 0 ;
		if( direction == KeyEvent.VK_UP ){
			lxyImage = lxyUpImage[lxyIndex] ;
			lxyY -- ;
			for( int x = lxyX ; x < lxyX + lxyImage.getWidth() ; x ++ ){
				if( mapData[x][lxyY + lxyImage.getHeight() - 10] == 1 ){
					mapNum = 1 ;
					break ;
				}	
			}
			for(int x=lxyX;x<lxyX+lxyImage.getWidth();x++){
				int color=mapdata.getRGB(x, lxyY+90);
				if(color==-16777216){
					lxyY++;
				}
			}
		}else if( direction == KeyEvent.VK_DOWN ){
			lxyImage = lxyDownImage[lxyIndex] ;
			lxyY ++ ;
			for( int x = lxyX ; x < lxyX + lxyImage.getWidth() ; x ++ ){
				if( mapData[x][lxyY + lxyImage.getHeight()] == 1 ){
					mapNum = 1 ;
					break ;
				}
			}
			for(int x=lxyX;x<lxyX+lxyImage.getWidth();x++){
				int color=mapdata.getRGB(x, lxyY+lxyImage.getHeight());
				if(color==-16777216){
					lxyY--;
				}
			}
		}else if( direction == KeyEvent.VK_LEFT ){
			lxyImage = lxyLeftImage[lxyIndex] ;
			lxyX -- ;
			for( int y = lxyY + lxyImage.getHeight() - 10 ; y < lxyY + lxyImage.getHeight() ; y ++ ){
				if( mapData[lxyX][y] == 1 ){
					mapNum = 1 ;
					break ;
				}
			}
			for(int y=lxyY+90;y<lxyY+lxyImage.getWidth();y++){
				int color=mapdata.getRGB(lxyX, y);
				if(color==-16777216){
					lxyX++;
				}
			}
		}else if( direction == KeyEvent.VK_RIGHT ){
			lxyImage = lxyRightImage[lxyIndex] ;
			lxyX ++ ;
			for( int y = lxyY + lxyImage.getHeight() - 10 ; y < lxyY + lxyImage.getHeight() ; y ++ ){
				if( mapData[lxyX + lxyImage.getWidth()][y] == 1 ){
					mapNum = 1 ;
					break ;
				}
			}
			for(int y=lxyY+90;y<lxyY+lxyImage.getHeight();y++){
				int color=mapdata.getRGB(lxyX+lxyImage.getWidth(), y);
				if(color==-16777216){
					lxyX--;
				}
			}
		}
		return mapNum ;
	}
}
