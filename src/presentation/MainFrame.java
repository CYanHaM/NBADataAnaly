package presentation;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

import com.sun.awt.AWTUtilities;

public class MainFrame extends JFrame{

	//��������ܴ�С
	public final int LGFRAME_WIDTH=870;
	public final int LGFRAME_HEIGHT=590;
	//�����������λ��
	int X;
	int Y;
	//�ж��Ƿ����϶�����
	boolean isDraging;

	public MainFrame(){
		//�������������С
		this.setLayout(null);
		this.setTitle("CYan HaM");
		this.setSize(LGFRAME_WIDTH, LGFRAME_HEIGHT);
		this.setResizable(false);
		//����ʾwindows�Դ��߿�
		this.setUndecorated(true);
		//���ô������
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		//����͸�����˴�������com.sun.awt.AWTUtilities����������
		AWTUtilities.setWindowOpaque(this, false);

		//����¼������ڻ�ȡ����϶���λ��
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				X= e.getX();
				Y= e.getY();
			}
			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}});
		//����ƶ��¼������ڻ�ȡ�ƶ���·������
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) { 
					//��ȡ��ǰ��ܵ�λ������
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
