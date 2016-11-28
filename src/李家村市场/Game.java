package ��Ҵ��г�;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Game extends JFrame {
	public static final int GAME_WIDTH=800;
	public static final int GAME_HEIGHT=600;

	LiJiaCun ljc;
	LiJiaCunShiChang ljcsc;

	/***
	 * ��ʼ����Ϸ����
	 */
	public Game() {

		// ��ʼ������
		ljc=new LiJiaCun();
		this.add(ljc);
//		ljcsc=new LiJiaCunShiChang();
//		this.add(ljcsc);
		// ��ʼ����������
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/***
	 * ������Ϸ
	 */
	public void start(){
		this.setVisible(true);
	}

	/***
	 * ���̿���
	 */
	public void processKeyEvent(KeyEvent e){
		if(e.getID()==e.KEY_PRESSED){
			int code=e.getKeyCode();
			if(code==e.VK_UP||
				code==e.VK_DOWN||
				code==e.VK_RIGHT||
				code==e.VK_LEFT){
				ljc.move(code);
			}
		}
		this.repaint();
		this.validate();
	}

}
