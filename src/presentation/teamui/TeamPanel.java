package presentation.teamui;

import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import VO.TeamVO;
import presentation.Preset.PlayerPre;

public class TeamPanel extends JPanel implements ActionListener{
	/**
	 * ��ʾ��ӻ�����Ϣ�Ľ���
	 * @author blisscry
	 * @date 2015��4��1��16:10:12
	 * @version 1.0
	 */
	private static final long serialVersionUID = 1L;

	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//�����Ե͸���հ�����߽��С����λpx
	public static int e_space=10;
	//����ճ�λ�ô�С
	private static int space=35;
	//�����С
	private static int TABLEWIDTH=765;
	private static int TABLEHEIGHT=275;
	//�����и�
	private static int ROWHEIGHT=35;
	//�����п�
	private static int[] COLUMNWIDTH={120,60,60,200,200,200,60,60,250};
	//���ñ�������
	private JTable playertable;
	private Object[][] playerinfo;
	private JScrollPane players;
	private String[] columnName={
			"����","���º���","λ��","����(Ӣ��-Ӣ��)","����(��)","����(�� ��,��)","����","����","��ҵѧУ"};
	
	private JLabel fullName;            //���ȫ��
	private JLabel abbreviation;        //��д
	private JLabel location;            //���ڵ�
	private JLabel location_con;
	private JLabel division;            //����
	private JLabel division_con;
	private JLabel partition;           //����
	private JLabel partition_con;
	private JLabel homeCourt;           //����
	private JLabel homeCourt_con;
	private JLabel time;                //����ʱ��
	private JLabel time_con;
	private JLabel line;//ˮƽ��

	//�������ť
	private JButton TeamTech;
	private JButton PlayerTech;
	private JButton TeamData;
	private JButton PlayerData;
	
	ImportTeam importdata;
	public PlayerPre PPre;
	public JFrame Frame;
	public TeamVO teamvo;
	public TeamPanel(TeamVO tvo,JFrame frame){
		teamvo=new TeamVO();
		teamvo.fullName="Adsj csacsaw";
		teamvo.abbreviation="ADS";
		teamvo.location="Losangles";
		teamvo.division="north";
		teamvo.partition="cewvdv";
		teamvo.homeCourt="csaacs";
		teamvo.time="1992/2/1";
		
		Frame=frame;
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		//������ɫԤ�����
		PPre=new PlayerPre();
//		importdata=new ImportTeam();
//		teamvo=importdata.getTeamVO(tvo);
		
		playerinfo=new Object[20][columnName.length];
		scrollpane_config();
		table_config();
		players.setViewportView(playertable);
		
		addbutton();
		addlabel();
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
		
		PlayerTech=new JButton(new ImageIcon("images/buttons/playertech/PlayerTech_selected.png"));
		PlayerTech.setBounds(26, 185, 148, 40);
		PlayerTech.setBorderPainted(false);
		PlayerTech.setContentAreaFilled(false);
		PlayerTech.setFocusPainted(false);
		PlayerTech.setRolloverIcon(new ImageIcon("images/buttons/playertech/PlayerTech_rollover.png"));
		PlayerTech.setPressedIcon(new ImageIcon("images/buttons/playertech/PlayerTech_pressed.png"));
		PlayerTech.addActionListener(this);
		
		TeamData=new JButton(new ImageIcon("images/buttons/team/Team_initial.png"));
		TeamData.setBounds(26, 225, 148, 40);
		TeamData.setBorderPainted(false);
		TeamData.setContentAreaFilled(false);
		TeamData.setFocusPainted(false);
		
		this.add(TeamTech);
		this.add(PlayerTech);
		this.add(TeamData);
		this.repaint();
	}
	
	private void addlabel(){
		fullName=new JLabel(teamvo.fullName);
		fullName.setBounds(543, 145, 200, 20);
		fullName.setForeground(PPre.label);
		fullName.setFont(PPre.fullName);            //�˴�������Ҫ�޸ģ���
		
		line=new JLabel();
		line.setBounds(543, 200, 155, 5);
		line.setIcon(new ImageIcon("images/teams/line.png"));
		
		abbreviation=new JLabel(teamvo.abbreviation);
		abbreviation.setBounds(545, 170, 200, 15);
		abbreviation.setForeground(PPre.label);
		abbreviation.setFont(PPre.abbreviation);        //�˴�������Ҫ�޸ģ���
		
		location=new JLabel("���ڵ�:");
		location.setBounds(545, 190, 200, 15);
		location.setForeground(PPre.label);
		location.setFont(PPre.message);
		location_con=new JLabel(teamvo.location);
		location_con.setBounds(598, 190, 200, 15);
		location_con.setForeground(PPre.label);
		location_con.setFont(PPre.location);
		
		division=new JLabel("����:");
		division.setBounds(545, 215, 200, 15);
		division.setForeground(PPre.label);
		division.setFont(PPre.message);
		division_con=new JLabel(teamvo.division);
		division_con.setBounds(585, 215, 200, 15);
		division_con.setForeground(PPre.label);
		division_con.setFont(PPre.division);
		
		partition=new JLabel("����:");
		partition.setBounds(545, 240, 200, 15);
		partition.setForeground(PPre.label);
		partition.setFont(PPre.message);
		partition_con=new JLabel(teamvo.partition);
		partition_con.setBounds(585, 240, 200, 15);
		partition_con.setForeground(PPre.label);
		partition_con.setFont(PPre.partition);
		
		homeCourt=new JLabel("����:");
		homeCourt.setBounds(545, 265, 200, 15);
		homeCourt.setForeground(PPre.label);
		homeCourt.setFont(PPre.message);
		homeCourt_con=new JLabel(teamvo.homeCourt);
		homeCourt_con.setBounds(585, 265, 200, 15);
		homeCourt_con.setForeground(PPre.label);
		homeCourt_con.setFont(PPre.homeCourt);
		
		time=new JLabel("����ʱ��:");
		time.setBounds(545, 290, 200, 15);
		time.setForeground(PPre.label);
		time.setFont(PPre.message);
		time_con=new JLabel(teamvo.time);
		time_con.setBounds(615, 290, 200, 15);
		time_con.setForeground(PPre.label);
		time_con.setFont(PPre.time);
		
		this.add(fullName);
		this.add(abbreviation);
		this.add(location);
		this.add(location_con);
		this.add(division);
		this.add(division_con);
		this.add(partition);
		this.add(partition_con);
		this.add(homeCourt);
		this.add(homeCourt_con);
		this.add(time);
		this.add(time_con);
		
		this.add(line);
		
	}
	//��������
	public void table_config(){
		//------------------------------�����������--------------------------
		//������������
		playertable=new JTable(playerinfo, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//������Ŀ���Զ������п�
		playertable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//���ñ����в����ƶ�
		playertable.getTableHeader().setReorderingAllowed(false);
		//������������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) playertable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//���ñ������ݼ���ͷ�����ֺ�
		playertable.setFont(PPre.CellFont);
		playertable.setForeground(PPre.CellFg);
		playertable.getTableHeader().setFont(PPre.HeaderFont);
		playertable.getTableHeader().setForeground(PPre.TableFg);
		playertable.getTableHeader().setOpaque(false);
		playertable.getTableHeader().setBackground(PPre.TableBg);
		//ȥ���߿�
		playertable.setBorder(null);

		//�����޸ı��񱳾�
		TableColumnModel model = playertable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//����ʾ��Ԫ��߿���
		playertable.setShowHorizontalLines(false);
		playertable.setShowVerticalLines(false);
		//����ѡ����ɫ
		playertable.setSelectionBackground(PPre.LineSelected);

		//�����и�
		playertable.setRowHeight(ROWHEIGHT);
		//�����п�
		for(int i=0;i<COLUMNWIDTH.length;i++){
			playertable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}


	}

	//�����������
	public void scrollpane_config(){
		//���������Ϣ
		players=new JScrollPane(playertable);
		players.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space,TABLEWIDTH,TABLEHEIGHT);
		players.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		players.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		players.setVisible(true);
		players.setOpaque(false);
		players.getViewport().setOpaque(false);
		players.setBorder(null);

		if (players.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, PPre.LineSelected,
							bounds.width, bounds.height, PPre.LineSelected);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			players.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
		}

		if (players.getCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, PPre.TableBg,
							bounds.width, bounds.height, PPre.TableBg);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			players.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,component);
		}

		this.add(players);
	}

	//���ص�Ԫ���׼��,���ڸı䵥Ԫ�񱳾���ɫ
	private class RowRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) 
		{
			//��Ԫ�����
			setHorizontalAlignment(JLabel.CENTER);
			//������ż�еı���ɫ
			if (row % 2 == 0)
				setBackground(PPre.EvenTableLine);
			else
				setBackground(PPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//���ƽ��汳��
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