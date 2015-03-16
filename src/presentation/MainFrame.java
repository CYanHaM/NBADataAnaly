package presentation;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

import com.sun.awt.AWTUtilities;

public class MainFrame extends JFrame{

	//定义主框架大小
	public final int LGFRAME_WIDTH=870;
	public final int LGFRAME_HEIGHT=590;
	//定义鼠标坐标位置
	int X;
	int Y;
	//判断是否在拖动界面
	boolean isDraging;

	public MainFrame(){
		//定义整个界面大小
		this.setLayout(null);
		this.setTitle("CYan HaM");
		this.setSize(LGFRAME_WIDTH, LGFRAME_HEIGHT);
		this.setResizable(false);
		//不显示windows自带边框
		this.setUndecorated(true);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		//窗体透明（此处引用了com.sun.awt.AWTUtilities，需引包）
		AWTUtilities.setWindowOpaque(this, false);

		//鼠标事件，用于获取鼠标拖动的位置
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				X= e.getX();
				Y= e.getY();
			}
			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}});
		//鼠标移动事件，用于获取移动的路径长度
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) { 
					//获取当前框架的位置坐标
					int frame_x= getLocation().x;
					int frame_y= getLocation().y;
					setLocation(frame_x+e.getX()-X, frame_y+e.getY()-Y);
				}
			}});
		
	}


	public static void main(String[] args){
		new MainFrame();
	}
	
}
