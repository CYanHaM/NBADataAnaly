package presentation.teamui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TeamdataPanel extends JPanel implements ActionListener{
	/**
	 * ����������ݽ���
	 * @author blisscry
	 * @date 2015��3��18��18:45:49
	 * @version 1
	 */
	private static final long serialVersionUID = 1L;

	public TeamdataPanel(){
		this.setSize(1020,670);
		this.setLayout(null);
		
	}

	
	//����������ݽ��汳��
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/main_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}