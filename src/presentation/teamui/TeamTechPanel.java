package presentation.teamui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import VO.TeamTechVO;
import presentation.Preset.TeamTechPre;


public class TeamTechPanel extends JPanel implements ActionListener{
	/**
	 * ���ͳ�����ݽ���
	 * @author blisscry
	 * @date 2015��3��21��16:35:28
	 * @version 1.6
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------���泣��-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//�����Ե͸���հ�����߽��С����λpx
	public static int e_space=10;
	//����ճ�λ�ô�С
	private static int space=20;
	//���������������
	private static int TEAMNUM=30;
	
	//����С
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
	//����и�
	private static int ROWHEIGHT=28;
	//����п�
	private static int[] COLUMNWIDTH={50,170,60,80,80,80,80,80,80,80,80,60,60,60,60,60,60,80,80,80,80,80,80,80,80,80};

	//�������С
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------�������--------------------
	//���ñ������
	private JTable teamtable;
	private Object[][] teaminfo;
	private JScrollPane teams;
	private String[] columnName={
			"����","�������","��������","Ͷ��������","Ͷ�����ִ���","����������",
			"���ֳ�����","����������","���������","����������","����������",
			"������","������","������","��ñ��","ʧ����","������","�����÷�",
			"Ͷ��������","����������","����������","ʤ��","�����غ�",
			"����Ч��","����Ч��","����Ч��","����Ч��","����Ч��"};
	//	
	//	private String[] columnName={"","","","","","","","","","","","","","","","",""};
	//�������볡�������л�������
	private JComboBox<String> switchbox;
	
	private JLabel icon;
	private JButton a;

	//----------------------------------------------------
	public TeamTechPre TTPre;
	public ImportData importdata;
	public ArrayList<TeamTechVO> initial_data;

	public int HeaderColumn=0;

	public TeamTechPanel(){
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		//������ɫԤ�����
		TTPre=new TeamTechPre();
		//		importdata=new ImportData();
		//		initial_data=importdata.getTeamTechAscend(TeamTechEnum.name);

		//teaminfo=new Object[initial_data.size()][columnName.length];
		teaminfo=new Object[TEAMNUM][columnName.length];
		//���س�ʼ�����ʾ����������
		//		handleTotalData(initial_data);

		table_config(teaminfo);

		//���������Ϣ
		teams=new JScrollPane(teamtable);
		teams.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space,TABLEWIDTH,TABLEHEIGHT);
		//���ػ����������
		scrollpane_config();

		
//		icon=new JLabel(new ImageIcon("images/1.gif"));
//		icon.setBounds(40, 487, 400	,300);
		
		//������
		switchbox=new JComboBox<String>();
		switchbox.setBackground(TTPre.LineSelected);
		switchbox.addItem("����������");
		switchbox.addItem("��������");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(TTPre.switchbox);
		switchbox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if(switchbox.getSelectedItem().equals("����������")){
						System.out.println("����������");
						handleTotalData(initial_data);
					}
					if(switchbox.getSelectedItem().equals("��������")){
						System.out.println("��������");
						handleAverageData(initial_data);
					}
				}
			}
		});

		a=new JButton(new ImageIcon("images/2.gif"));
		a.setBounds(40, 487, 32, 32);
		a.setBorderPainted(false);
		a.setContentAreaFilled(false);
		a.setFocusPainted(false);
//		a.setRolloverIcon(new ImageIcon("images/2.gif"));
		this.add(switchbox);
		this.add(teams);
//		this.add(icon);
		this.repaint();
	}

	private void handleTotalData(ArrayList<TeamTechVO> totaldata){
		int a=0;
		for(TeamTechVO i:totaldata){
			teaminfo[a][1]=i.name;
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=i.shotInNum;
			teaminfo[a][4]=i.shotNum;
			teaminfo[a][5]=i.threeShotInNum;
			teaminfo[a][6]=i.threeShotNum;
			teaminfo[a][7]=i.penaltyShotInNum;
			teaminfo[a][8]=i.penaltyShotNum;
			teaminfo[a][9]=i.offensiveRebound;
			teaminfo[a][10]=i.defensiveRebound;
			teaminfo[a][11]=i.rebound;
			teaminfo[a][12]=i.secondaryAttack;
			teaminfo[a][13]=i.steal;
			teaminfo[a][14]=i.blockShot;
			teaminfo[a][15]=i.fault;
			teaminfo[a][16]=i.foul;
			teaminfo[a][17]=i.score;
			teaminfo[a][18]=i.shotInRate;
			teaminfo[a][19]=i.threeShotInRate;
			teaminfo[a][20]=i.penaltyShotInRate;
			teaminfo[a][21]=i.winningRate;
			teaminfo[a][22]=i.offensiveRound;
			teaminfo[a][23]=i.offensiveEfficiency;
			teaminfo[a][24]=i.defensiveEfficiency;
			teaminfo[a][25]=i.reboundEfficiency;
			teaminfo[a][26]=i.stealEfficiency;
			teaminfo[a][27]=i.secondaryAttackEfficiency;
			a++;
		}
		table_config(teaminfo);
		teams.setViewportView(teamtable);
		this.repaint();
	}


	private void handleAverageData(ArrayList<TeamTechVO> averagedata){
		int a=0;
		for(TeamTechVO i:averagedata){
			teaminfo[a][1]=i.name;
			teaminfo[a][2]=i.gameNum;
			teaminfo[a][3]=i.shotInNumave;
			teaminfo[a][4]=i.shotNumave;
			teaminfo[a][5]=i.threeShotInNumave;
			teaminfo[a][6]=i.threeShotNumave;
			teaminfo[a][7]=i.penaltyShotInNumave;
			teaminfo[a][8]=i.penaltyShotNumave;
			teaminfo[a][9]=i.offensiveReboundave;
			teaminfo[a][10]=i.defensiveReboundave;
			teaminfo[a][11]=i.reboundave;
			teaminfo[a][12]=i.secondaryAttackave;
			teaminfo[a][13]=i.stealave;
			teaminfo[a][14]=i.blockShotave;
			teaminfo[a][15]=i.faultave;
			teaminfo[a][16]=i.foulave;
			teaminfo[a][17]=i.scoreave;
			teaminfo[a][18]=i.shotInRate;
			teaminfo[a][19]=i.threeShotInRate;
			teaminfo[a][20]=i.penaltyShotInRate;
			teaminfo[a][21]=i.winningRate;
			teaminfo[a][22]=i.offensiveRoundave;
			teaminfo[a][23]=i.offensiveEfficiency;
			teaminfo[a][24]=i.defensiveEfficiency;
			teaminfo[a][25]=i.reboundEfficiency;
			teaminfo[a][26]=i.stealEfficiency;
			teaminfo[a][27]=i.secondaryAttackEfficiency;
			a++;
		}
		table_config(teaminfo);
		teams.setViewportView(teamtable);
		this.repaint();
	}


	//�������
	public void table_config(Object[][] teamtech){
		//------------------------------����������--------------------------
		for(int i=0;i<TEAMNUM;i++){
			teamtech[i][0]=i+1;
		}
		//�����������
		teamtable=new JTable(teamtech, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//������Ŀ���Զ������п�
		teamtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//���ñ���в����ƶ�
		teamtable.getTableHeader().setReorderingAllowed(false);
		//������������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) teamtable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//���ñ�����ݼ���ͷ�����ֺ�
		teamtable.setFont(TTPre.CellFont);
		teamtable.setForeground(TTPre.CellFg);
		teamtable.getTableHeader().setFont(TTPre.HeaderFont);
		teamtable.getTableHeader().setForeground(TTPre.TableFg);
		teamtable.getTableHeader().setOpaque(false);
		teamtable.getTableHeader().setBackground(TTPre.TableBg);
		//ȥ���߿�
		teamtable.setBorder(null);

		//�����޸ı�񱳾�
		TableColumnModel model = teamtable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//����ʾ��Ԫ��߿���
		teamtable.setShowHorizontalLines(false);
		teamtable.setShowVerticalLines(false);
		//����ѡ����ɫ
		teamtable.setSelectionBackground(TTPre.LineSelected);
		
		//�����и�
		teamtable.setRowHeight(ROWHEIGHT);
		//�����п�
		for(int i=0;i<COLUMNWIDTH.length;i++){
		teamtable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		
		//-----------------------------------------------------------------


		//���table��ͷ����¼�
		teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=teamtable.columnAtPoint(e.getPoint());
				
				
				//teamtable.getTableHeader().setBackground(TTPre.getTableSelBg());
				//teamtable.setColumnSelectionAllowed(true);
				//teamtable.setRowSelectionAllowed(false);
				//teamtable.setColumnSelectionInterval(HeaderColumn, HeaderColumn);
				//TableColumn column=teamtable.getTableHeader().getColumnModel().getColumn(HeaderColumn);
				//column.setHeaderRenderer();
				//setTableHeaderColor(teamtable, HeaderColumn, TTPre.getTableSelBg());
			}
		});

		//����ʾ��ͷ
		//teamtable.getTableHeader().setVisible(false);
		//DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();  
		//renderer.setPreferredSize(new Dimension(0, 0));  
		//teamtable.getTableHeader().setDefaultRenderer(renderer);  


	}


	/*
	 * private void setTableHeaderColor(JTable table, int columnIndex, final Color c)

    {
        TableColumn column = table.getTableHeader().getColumnModel().getColumn(columnIndex);
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer(){
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)  
            {
                JComponent comp = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                comp.setBackground(c);
                comp.setBorder(null);   
                comp.setOpaque(false);
                comp.setForeground(TTPre.getOddTableLine());
                return comp;
            }
        };
        column.setHeaderRenderer(cellRenderer);
    }
	 */

	//�����������
	public void scrollpane_config(){
		teams.setHorizontalScrollBarPolicy( 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		teams.setVerticalScrollBarPolicy( 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		teams.setVisible(true);
		teams.setOpaque(false);
		teams.getViewport().setOpaque(false);
		teams.setBorder(null);

		if (teams.getCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, TTPre.LineSelected,
							bounds.width, bounds.height, TTPre.LineSelected);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			teams.setCorner(ScrollPaneConstants.LOWER_RIGHT_CORNER, component);
		}

		if (teams.getCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER) == null) {
			Component component = new JLabel("") {
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					Graphics2D g2 = (Graphics2D) g;
					Paint oldPaint = g2.getPaint();
					Rectangle bounds = getBounds();
					Paint backgroupRectPaint = new GradientPaint(0, 0, TTPre.TableBg,
							bounds.width, bounds.height, TTPre.TableBg);
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			teams.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,component);
		}
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
				setBackground(TTPre.EvenTableLine);
			else
				setBackground(TTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//�����������ݽ��汳��
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