package 李家村市场2;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Game extends JFrame {
	public static final int GAME_WIDTH = 600;
	public static final int GAME_HEIGHT = 600;
	Base[] bases = new Base[2]; // 面板数组
	int mapNum = 0;

	/**
	 * 初始化游戏数据
	 */
	public Game() {
		// 初始化窗体1
		bases[0] = new LiJiaCun();
		bases[1] = new LiJiaCunShiChang();
		this.add(bases[0]);
		// 初始化窗体数据
		this.setSize(GAME_WIDTH, GAME_WIDTH);
		this.setDefaultCloseOperation(3);
	}

	/**
	 * 启动游戏
	 */
	public void start() {
		this.setVisible(true);
		System.out.println("123123");
	}

	/**
	 * 键盘控制
	 */
	public void processKeyEvent(KeyEvent e) {

		if (e.getID() == KeyEvent.KEY_PRESSED) {
			int code = e.getKeyCode();
			if (code == e.VK_UP || code == e.VK_DOWN || code == e.VK_LEFT
					|| code == e.VK_RIGHT) {
				if (mapNum == 0) {
					this.getContentPane().removeAll();

					this.add(bases[mapNum]);
//					bases[mapNum].move(code);
					mapNum = bases[mapNum].move(code);
				} else if (mapNum == 1) {
					this.getContentPane().removeAll();
					this.add(bases[mapNum]);
//					bases[mapNum].move(code);
					mapNum = bases[mapNum].move(code);
				}

			}

		}
		this.repaint();
		this.validate();
	}

	/**
	 * 启动程序
	 */
	public static void main(String args[]) {
		new Game().start();
	}
}



/**
 * 子类可以无条件转化为父类，父类不一定可以转化为子类
 */
