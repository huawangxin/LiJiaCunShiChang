package ��Ҵ��г�1;
import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
	LiJiaCun panel1;
	LiJiaCunShiChang panel2;
	
	
	
	//static ����ֱ�����ã������ǵ�һʱ�ɱ�Ϊ�����
	//�����ߴ�
	public static final int GAME_WIDTH=800;
	public static final int GAME_HEIGHT=600;
	//������������룩
	public static final int INTERVAL=10;
	/***
	 *������Ϸ 
	 */
	public Game(){
		System.out.println("��ʼ����Ϸ");
		
		panel1=new LiJiaCun();
		panel1.setBackground(Color.BLACK);
		panel2=new LiJiaCunShiChang();
		panel2.setBackground(Color.RED);
		
		this.add(panel1);
//		this.add(panel2);
//		this.remove(panel);
		
		//------------��ʼ����������---------------
		this.setSize(GAME_WIDTH,GAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/***
	 * ��Ϸ��ʼ��
	 */
	public void start(){
		System.out.println("������Ϸ");
		new Thread(this).start();
	}
	/***
	 * ���ƽ���
	 */
//	public void paint(Graphics g){
//		
//		System.out.println("���ƽ���");
//		
//	}
	boolean flag=false;
	/***
	 * ���̿���
	 */
	public void processKeyEvent(KeyEvent e){
		
		System.out.println("���̿���");
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
	 * ����
	 */
	public void run(){
		System.out.println("���������߳�");
		while(true){
			//ÿ�붯���ػ�100����
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
