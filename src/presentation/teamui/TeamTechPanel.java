package presentation.teamui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;
import presentation.ColorPreset.TeamDataPre;


public class TeamTechPanel extends JPanel implements ActionListener{
	/**
	 * ���ͳ�����ݽ���
	 * @author blisscry
	 * @date 2015��3��21��16:35:28
	 * @version 1.6
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------���泣��-------------------
	//�����Ե͸���հ�����߽��С����λpx
	public static int e_space=10;
	//����ճ�λ�ô�С
	private static int space=20;
	//���������������
	private static int TEAMNUM=30;
	//����и�
	private static int LINEHEIGHT=28;
	//����С
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
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
			"�������","��������","Ͷ��������","Ͷ�����ִ���","����������",
			"���ֳ�����","����������","���������","����������","����������",
			"������","������","������","��ñ��","ʧ����","������","�����÷�",
			"Ͷ��������","����������","����������","ʤ��","�����غ�",
			"����Ч��","����Ч��","����Ч��","����Ч��","����Ч��"};
//	
//	private String[] columnName={"","","","","","","","","","","","","","","",""};
	//�������볡�������л�������
	private JComboBox<String> switchbox;

	//----------------------------------------------------
	public TeamDataPre TDPre;
	public ImportData importdata;
	public ArrayList<TeamTechVO> initial_data;
	
	public int HeaderColumn=0;

	public TeamTechPanel(int WIDTH,int HEIGHT){
		this.setSize(WIDTH,HEIGHT);
		this.setLayout(null);
		//������ɫԤ�����
		TDPre=new TeamDataPre();
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

		//������
		switchbox=new JComboBox<String>();
		switchbox.setBackground(TDPre.getLineSelected());
		switchbox.addItem("����������");
		switchbox.addItem("��������");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(new Font("��Բ",0,12));
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

		this.add(switchbox);
		this.add(teams);
	}

	private void handleTotalData(ArrayList<TeamTechVO> totaldata){
		int a=0;
		for(TeamTechVO i:totaldata){
			teaminfo[a][0]=i.name;
			teaminfo[a][1]=i.gameNum;
			teaminfo[a][2]=i.shotInNum;
			teaminfo[a][3]=i.shotNum;
			teaminfo[a][4]=i.threeShotInNum;
			teaminfo[a][5]=i.threeShotNum;
			teaminfo[a][6]=i.penaltyShotInNum;
			teaminfo[a][7]=i.penaltyShotNum;
			teaminfo[a][8]=i.offensiveRebound;
			teaminfo[a][9]=i.defensiveRebound;
			teaminfo[a][10]=i.rebound;
			teaminfo[a][11]=i.secondaryAttack;
			teaminfo[a][12]=i.steal;
			teaminfo[a][13]=i.blockShot;
			teaminfo[a][14]=i.fault;
			teaminfo[a][15]=i.foul;
			teaminfo[a][16]=i.score;
			teaminfo[a][17]=i.shotInRate;
			teaminfo[a][18]=i.threeShotInRate;
			teaminfo[a][19]=i.penaltyShotInRate;
			teaminfo[a][20]=i.winningRate;
			teaminfo[a][21]=i.offensiveRound;
			teaminfo[a][22]=i.offensiveEfficiency;
			teaminfo[a][23]=i.defensiveEfficiency;
			teaminfo[a][24]=i.reboundEfficiency;
			teaminfo[a][25]=i.stealEfficiency;
			teaminfo[a][26]=i.secondaryAttackEfficiency;
			a++;
		}
		table_config(teaminfo);
		teams.setViewportView(teamtable);
		this.repaint();
	}


	private void handleAverageData(ArrayList<TeamTechVO> averagedata){
		int a=0;
		for(TeamTechVO i:averagedata){
			teaminfo[a][0]=i.name;
			teaminfo[a][1]=i.gameNum;
			teaminfo[a][2]=i.shotInNumave;
			teaminfo[a][3]=i.shotNumave;
			teaminfo[a][4]=i.threeShotInNumave;
			teaminfo[a][5]=i.threeShotNumave;
			teaminfo[a][6]=i.penaltyShotInNumave;
			teaminfo[a][7]=i.penaltyShotNumave;
			teaminfo[a][8]=i.offensiveReboundave;
			teaminfo[a][9]=i.defensiveReboundave;
			teaminfo[a][10]=i.reboundave;
			teaminfo[a][11]=i.secondaryAttackave;
			teaminfo[a][12]=i.stealave;
			teaminfo[a][13]=i.blockShotave;
			teaminfo[a][14]=i.faultave;
			teaminfo[a][15]=i.foulave;
			teaminfo[a][16]=i.scoreave;
			teaminfo[a][17]=i.shotInRate;
			teaminfo[a][18]=i.threeShotInRate;
			teaminfo[a][19]=i.penaltyShotInRate;
			teaminfo[a][20]=i.winningRate;
			teaminfo[a][21]=i.offensiveRoundave;
			teaminfo[a][22]=i.offensiveEfficiency;
			teaminfo[a][23]=i.defensiveEfficiency;
			teaminfo[a][24]=i.reboundEfficiency;
			teaminfo[a][25]=i.stealEfficiency;
			teaminfo[a][26]=i.secondaryAttackEfficiency;
			a++;
		}
		table_config(teaminfo);
		teams.setViewportView(teamtable);
		this.repaint();
	}


	//�������
	public void table_config(Object[][] teamtech){
		//------------------------------����������--------------------------
		//�����������
		teamtable=new JTable(teamtech, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//������Ŀ���Զ������п�
		teamtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//��Ԫ�����
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER);
		teamtable.setDefaultRenderer(Object.class,r);
		//���ñ���в����ƶ�
		teamtable.getTableHeader().setReorderingAllowed(false);
		//������������
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) teamtable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//���ñ�����ݼ���ͷ�����ֺ�
		teamtable.setFont(new Font("����",0,10));
		teamtable.getTableHeader().setFont(new Font("����",0,10));
		teamtable.getTableHeader().setForeground(TDPre.getTableFg());
		teamtable.getTableHeader().setOpaque(false);
		teamtable.getTableHeader().setBackground(TDPre.getTableBg());
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
		//�����и�
		teamtable.setRowHeight(LINEHEIGHT);
		//����ѡ����ɫ
		teamtable.setSelectionBackground(TDPre.getLineSelected());
		//-----------------------------------------------------------------
		
		
		//���table��ͷ����¼�
		teamtable.getTableHeader().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				HeaderColumn=teamtable.columnAtPoint(e.getPoint());
//				teamtable.getTableHeader().setBackground(TDPre.getTableSelBg());
//				teamtable.setColumnSelectionAllowed(true);
//                teamtable.setRowSelectionAllowed(false);
                teamtable.setColumnSelectionInterval(HeaderColumn, HeaderColumn);
//				TableColumn column=teamtable.getTableHeader().getColumnModel().getColumn(HeaderColumn);
//				column.setHeaderRenderer();
//				setTableHeaderColor(teamtable, HeaderColumn, TDPre.getTableSelBg());
			}
		});
		
		teamtable.getTableHeader().setVisible(false);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();  
        renderer.setPreferredSize(new Dimension(0, 0));  
        teamtable.getTableHeader().setDefaultRenderer(renderer);  

	}
	
	
	private void setTableHeaderColor(JTable table, int columnIndex, final Color c)
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
                comp.setForeground(TDPre.getOddTableLine());
                return comp;
            }
        };
        column.setHeaderRenderer(cellRenderer);
    }

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
					Paint backgroupRectPaint = new GradientPaint(0, 0, TDPre.getLineSelected(),
							bounds.width, bounds.height, TDPre.getLineSelected());
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
					Paint backgroupRectPaint = new GradientPaint(0, 0, TDPre.getTableBg(),
							bounds.width, bounds.height, TDPre.getTableBg());
					g2.setPaint(backgroupRectPaint);
					g2.fillRect(0, 0, bounds.width, bounds.height);
					g2.setPaint(oldPaint);
				}
			};
			teams.setCorner(ScrollPaneConstants.UPPER_RIGHT_CORNER,component);
		}
	}

	//���ص�Ԫ���׼��
	private class RowRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) 
		{
			//������ż�еı���ɫ
			if (row % 2 == 0)
				setBackground(TDPre.getEvenTableLine());
			else
				setBackground(TDPre.getOddTableLine());
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