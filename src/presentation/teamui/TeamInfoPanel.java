package presentation.teamui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import VO.TeamVO;
import presentation.playerui.PlayerTechPanel;

public class TeamInfoPanel extends JPanel implements ActionListener{
	/**
	 * ��Ա��Ϣ��ʾ����
	 * @author blisscry
	 * @date 2015��4��1��00:55:39
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	
	private static int locx=201;
	private static int locy=232;
	private static int Button_width=113;
	private static int Button_height=61;
	
	private JButton ATL;
	private JButton CHA;
	private JButton MIA;
	private JButton ORL;
	private JButton WAS;
	
	private JButton CHI;
	private JButton CLE;
	private JButton DET;
	private JButton IND;
	private JButton MIL;
	
	private JButton BOS;
	private JButton BKN;
	private JButton NYK;
	private JButton PHI;
	private JButton TOR;
	
	private JButton GSW;
	private JButton LAC;
	private JButton LAL;
	private JButton PHX;
	private JButton SAC;
	
	private JButton DEN;
	private JButton MIN;
	private JButton OKC;
	private JButton POR;
	private JButton UTA;
	
	private JButton DAL;
	private JButton HOU;
	private JButton MEM;
	private JButton NOP;
	private JButton SAS;
	
	//�������ť
	private JButton TeamTech;
	private JButton PlayerTech;
	private JButton TeamData;
	private JButton PlayerData;
	
	public JFrame Frame;
	public TeamInfoPanel(JFrame frame){
		Frame=frame;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		this.setOpaque(false);
		
		addbutton();
		addteamsbutton();
		
	}

	private void addbutton(){
		TeamTech=new JButton(new ImageIcon("images/buttons/teamtech/TeamTech_initial.png"));
		TeamTech.setBounds(26, 145, 148, 40);
		TeamTech.setBorderPainted(false);
		TeamTech.setContentAreaFilled(false);
		TeamTech.setFocusPainted(false);
		TeamTech.setRolloverIcon(new ImageIcon("images/buttons/teamtech/TeamTech_rollover.png"));
		TeamTech.setPressedIcon(new ImageIcon("images/buttons/teamtech/TeamTech_pressed.png"));
		TeamTech.addActionListener(this);
		
		PlayerTech=new JButton(new ImageIcon("images/buttons/playertech/PlayerTech_initial.png"));
		PlayerTech.setBounds(26, 185, 148, 40);
		PlayerTech.setBorderPainted(false);
		PlayerTech.setContentAreaFilled(false);
		PlayerTech.setFocusPainted(false);
		PlayerTech.setRolloverIcon(new ImageIcon("images/buttons/playertech/PlayerTech_rollover.png"));
		PlayerTech.setPressedIcon(new ImageIcon("images/buttons/playertech/PlayerTech_pressed.png"));
		PlayerTech.addActionListener(this);
		
		TeamData=new JButton(new ImageIcon("images/buttons/team/Team_selected.png"));
		TeamData.setBounds(26, 225, 148, 40);
		TeamData.setBorderPainted(false);
		TeamData.setContentAreaFilled(false);
		TeamData.setFocusPainted(false);
		
		this.add(TeamTech);
		this.add(PlayerTech);
		this.add(TeamData);
	}
	
	public void addteamsbutton(){
		
		ATL=new JButton("��ӥ");
		ATL.setBounds(locx, locy, Button_width, Button_height);
		button_config(ATL);
		CHA=new JButton("�Ʒ�");
		CHA.setBounds(locx, locy+13+Button_height, Button_width, Button_height);
		button_config(CHA);
		MIA=new JButton("�Ȼ�");
		MIA.setBounds(locx, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(MIA);
		ORL=new JButton("ħ��");
		ORL.setBounds(locx, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(ORL);
		WAS=new JButton("���");
		WAS.setBounds(locx, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(WAS);
		
		CHI=new JButton("��ţ");
		CHI.setBounds(locx+20+Button_width, locy, Button_width, Button_height);
		button_config(CHI);
		CLE=new JButton("��ʿ");
		CLE.setBounds(locx+20+Button_width, locy+13+Button_height, Button_width, Button_height);
		button_config(CLE);
		DET=new JButton("����");
		DET.setBounds(locx+20+Button_width, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(DET);
		IND=new JButton("������");
		IND.setBounds(locx+20+Button_width, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(IND);
		MIL=new JButton("��¹");
		MIL.setBounds(locx+20+Button_width, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(MIL);
		
		BOS=new JButton("��������");
		BOS.setBounds(locx+(20+Button_width)*2, locy, Button_width, Button_height);
		button_config(BOS);
		BKN=new JButton("����");
		BKN.setBounds(locx+(20+Button_width)*2, locy+13+Button_height, Button_width, Button_height);
		button_config(BKN);
		NYK=new JButton("���˹");
		NYK.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(NYK);
		PHI=new JButton("76��");
		PHI.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(PHI);
		TOR=new JButton("����");
		TOR.setBounds(locx+(20+Button_width)*2, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(TOR);
		
		GSW=new JButton("��ʿ");
		GSW.setBounds(locx+(20+Button_width)*3, locy, Button_width, Button_height);
		button_config(GSW);
		LAC=new JButton("�촬");
		LAC.setBounds(locx+(20+Button_width)*3, locy+13+Button_height, Button_width, Button_height);
		button_config(LAC);
		LAL=new JButton("����");
		LAL.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(LAL);
		PHX=new JButton("̫��");
		PHX.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(PHX);
		SAC=new JButton("����");
		SAC.setBounds(locx+(20+Button_width)*3, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(SAC);
		
		DEN=new JButton("���");
		DEN.setBounds(locx+(20+Button_width)*4, locy, Button_width, Button_height);
		button_config(DEN);
		MIN=new JButton("ɭ����");
		MIN.setBounds(locx+(20+Button_width)*4, locy+13+Button_height, Button_width, Button_height);
		button_config(MIN);
		OKC=new JButton("����");
		OKC.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(OKC);
		POR=new JButton("������");
		POR.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(POR);
		UTA=new JButton("��ʿ");
		UTA.setBounds(locx+(20+Button_width)*4, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(UTA);
		
		DAL=new JButton("Сţ");
		DAL.setBounds(locx+(20+Button_width)*5, locy, Button_width, Button_height);
		button_config(DAL);
		HOU=new JButton("���");
		HOU.setBounds(locx+(20+Button_width)*5, locy+13+Button_height, Button_width, Button_height);
		button_config(HOU);
		MEM=new JButton("����");
		MEM.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*2, Button_width, Button_height);
		button_config(MEM);
		NOP=new JButton("����");
		NOP.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*3, Button_width, Button_height);
		button_config(NOP);
		SAS=new JButton("����");
		SAS.setBounds(locx+(20+Button_width)*5, locy+(13+Button_height)*4, Button_width, Button_height);
		button_config(SAS);
	}
	
	public void button_config(JButton button){
		this.add(button);
		button.addActionListener(this);
	}
	//�����������ݽ��汳��
	public void paintComponent(Graphics g){
		super.paintComponents(g);
		ImageIcon im1=new ImageIcon("images/system_img/teams_bg.png");
		g.drawImage(im1.getImage(),0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==TeamTech){
			Frame.remove(this);
			TeamTechPanel ttp=new TeamTechPanel(Frame);
			Frame.add(ttp);
			Frame.repaint();
		}
		if(arg0.getSource()==PlayerTech){
			Frame.remove(this);
			PlayerTechPanel ptp=new PlayerTechPanel(Frame);
			Frame.add(ptp);
			Frame.repaint();
		}
		if(arg0.getSource()==ATL){
			Frame.remove(this);
			TeamVO tvo=new TeamVO();
			tvo.abbreviation="ATL";
			TeamPanel tp=new TeamPanel(tvo,Frame);
			Frame.add(tp);
			Frame.repaint();
		}
	}
}