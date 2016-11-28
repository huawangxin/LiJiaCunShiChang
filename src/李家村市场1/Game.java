package 李家村市场1;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	LiJiaCun panel1;
	LiJiaCunShiChang panel2;
	
	
	
	//static 可以直接引用（方法是单一时可标为这个）
	//场景尺寸
	public static final int GAME_WIDTH=800;
	public static final int GAME_HEIGHT=600;
	//动画间隔（毫秒）
	public static final int INTERVAL=10;
	/***
	 *启动游戏 
	 */
	public Game(){
		System.out.println("初始化游戏");
		
		panel1=new LiJiaCun();
		panel1.setBackground(Color.BLACK);
		panel2=new LiJiaCunShiChang();
		panel2.setBackground(Color.RED);
		
		this.add(panel1);
//		this.add(panel2);
//		this.remove(panel);
		
		//------------初始化窗体数据---------------
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/***
	 * 游戏初始化
	 */
	public void start(){
		System.out.println("启动游戏");
		new Thread(this).start();
	}
	/***
	 * 绘制界面
	 */
//	public void paint(Graphics g){
//		
//		System.out.println("绘制界面");
//		
//	}
	boolean flag=false;
	/***
	 * 键盘控制
	 */
	public void processKeyEvent(KeyEvent e){
		
		System.out.println("键盘控制");
		if(e.getID()==401){
			int code=e.getKeyCode();
			if(code==e.VK_UP||
					code==e.VK_DOWN||
					code==e.VK_RIGHT||
					code==e.VK_LEFT){
				panel1.move(code);
				panel2.move(code);
			}else if(code==e.VK_SPACE){
				if(e.getID()==401){
				flag=!flag;
				if(flag){
				this.remove(panel1);
				this.add(panel2);
			}else{
				this.remove(panel2);
				this.add(panel1);
			} }
			}
		}
		
		
		
		
		
//		if(e.getID()==401){
//			flag=!flag;
//			if(flag){
//			this.remove(panel1);
//			this.add(panel2);
//		}else{
//			this.remove(panel2);
//			this.add(panel1);
//		} }
		
	}
	/***
	 * 动画
	 */
	public void run(){
		System.out.println("开启动画线程");
		while(true){
			//每秒动画重画100毫秒
			try {
				this.repaint();
				this.validate();
				Thread.sleep(INTERVAL);
			} catch (Exception e) {
				e.printStackTrace();			}
		}
		
		
	}
	public static void main(String args[]){
		new Game().start();
	}

}
