package presentation.teamui;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TeamdataPanel extends JPanel implements ActionListener{
	/**
	 * 球队赛季数据界面
	 * @author blisscry
	 * @date 2015年3月18日18:45:49
	 * @version 1
	 */
	private static final long serialVersionUID = 1L;

	public TeamdataPanel(){
		this.setSize(1020,670);
		this.setLayout(null);
		
	}

	
	//描绘赛季数据界面背景
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