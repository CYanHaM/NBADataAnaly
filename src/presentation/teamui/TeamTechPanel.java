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
	 * 球队统计数据界面
	 * @author blisscry
	 * @date 2015年3月21日16:35:28
	 * @version 1.6
	 */
	private static final long serialVersionUID = 1L;

	//-------------------------界面常量-------------------
	public static int WIDTH=1020;
	public static int HEIGHT=670;
	//定义边缘透明空白区域边界大小，单位px
	public static int e_space=10;
	//定义空出位置大小
	private static int space=20;
	//设置球队总数常量
	private static int TEAMNUM=30;
	
	//表格大小
	private static int TABLEWIDTH=800;
	private static int TABLEHEIGHT=450;
	//表格行高
	private static int ROWHEIGHT=28;
	//表格列宽
	private static int[] COLUMNWIDTH={50,170,60,80,80,80,80,80,80,80,80,60,60,60,60,60,60,80,80,80,80,80,80,80,80,80};

	//下拉框大小
	private static int BOXWIDTH=160;
	private static int BOXHEIGHT=30;
	//----------------------------------------------------

	//-------------------------界面组件--------------------
	//设置表格属性
	private JTable teamtable;
	private Object[][] teaminfo;
	private JScrollPane teams;
	private String[] columnName={
			"排名","球队名称","比赛场数","投篮命中数","投篮出手次数","三分命中数",
			"三分出手数","罚球命中数","罚球出手数","进攻篮板数","防守篮板数",
			"篮板数","助攻数","抢断数","盖帽数","失误数","犯规数","比赛得分",
			"投篮命中率","三分命中率","罚球命中率","胜率","进攻回合",
			"进攻效率","防守效率","篮板效率","抢断效率","助攻效率"};
	//	
	//	private String[] columnName={"","","","","","","","","","","","","","","","",""};
	//总数据与场均数据切换下拉框
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
		//创建颜色预设对象
		TTPre=new TeamTechPre();
		//		importdata=new ImportData();
		//		initial_data=importdata.getTeamTechAscend(TeamTechEnum.name);

		//teaminfo=new Object[initial_data.size()][columnName.length];
		teaminfo=new Object[TEAMNUM][columnName.length];
		//加载初始表格，显示队伍总数据
		//		handleTotalData(initial_data);

		table_config(teaminfo);

		//滑动面板信息
		teams=new JScrollPane(teamtable);
		teams.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space,TABLEWIDTH,TABLEHEIGHT);
		//加载滑动面板配置
		scrollpane_config();

		
//		icon=new JLabel(new ImageIcon("images/1.gif"));
//		icon.setBounds(40, 487, 400	,300);
		
		//下拉框
		switchbox=new JComboBox<String>();
		switchbox.setBackground(TTPre.LineSelected);
		switchbox.addItem("赛季总数据");
		switchbox.addItem("场均数据");
		switchbox.setBounds(WIDTH-TABLEWIDTH-e_space-space,HEIGHT-TABLEHEIGHT-e_space-space-50,BOXWIDTH,BOXHEIGHT);
		switchbox.setFont(TTPre.switchbox);
		switchbox.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getStateChange()==ItemEvent.SELECTED){
					if(switchbox.getSelectedItem().equals("赛季总数据")){
						System.out.println("赛季总数据");
						handleTotalData(initial_data);
					}
					if(switchbox.getSelectedItem().equals("场均数据")){
						System.out.println("场均数据");
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


	//表格配置
	public void table_config(Object[][] teamtech){
		//------------------------------表格基本属性--------------------------
		for(int i=0;i<TEAMNUM;i++){
			teamtech[i][0]=i+1;
		}
		//表格属性设置
		teamtable=new JTable(teamtech, columnName){
			private static final long serialVersionUID = 1L;
			public boolean isCellEditable(int row, int column) { 
				return false;
			}
		};
		//根据条目名自动调整列宽
		teamtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		//设置表格列不可移动
		teamtable.getTableHeader().setReorderingAllowed(false);
		//设置列名居中
		DefaultTableCellRenderer hr = (DefaultTableCellRenderer) teamtable.getTableHeader() .getDefaultRenderer();  
		hr.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		//设置表格数据及表头字体字号
		teamtable.setFont(TTPre.CellFont);
		teamtable.setForeground(TTPre.CellFg);
		teamtable.getTableHeader().setFont(TTPre.HeaderFont);
		teamtable.getTableHeader().setForeground(TTPre.TableFg);
		teamtable.getTableHeader().setOpaque(false);
		teamtable.getTableHeader().setBackground(TTPre.TableBg);
		//去除边框
		teamtable.setBorder(null);

		//按行修改表格背景
		TableColumnModel model = teamtable.getColumnModel();
		for (int i = 0, n = model.getColumnCount(); i < n; i++) 
		{
			TableColumn column = model.getColumn(i);
			column.setCellRenderer(new RowRenderer());
		}

		//不显示单元格边框线
		teamtable.setShowHorizontalLines(false);
		teamtable.setShowVerticalLines(false);
		//设置选中颜色
		teamtable.setSelectionBackground(TTPre.LineSelected);
		
		//设置行高
		teamtable.setRowHeight(ROWHEIGHT);
		//设置列宽
		for(int i=0;i<COLUMNWIDTH.length;i++){
		teamtable.getColumnModel().getColumn(i).setPreferredWidth(COLUMNWIDTH[i]);
		}
		
		//-----------------------------------------------------------------


		//添加table表头点击事件
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

		//不显示表头
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

	//滑动面板配置
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

	//重载单元格标准类,用于改变单元格背景颜色
	private class RowRenderer extends DefaultTableCellRenderer 
	{
		private static final long serialVersionUID = 1L;

		public Component getTableCellRendererComponent(JTable t, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) 
		{
			//单元格居中
			setHorizontalAlignment(JLabel.CENTER);
			//设置奇偶行的背景色
			if (row % 2 == 0)
				setBackground(TTPre.EvenTableLine);
			else
				setBackground(TTPre.OddTableLine);
			return super.getTableCellRendererComponent(t, value, isSelected,
					hasFocus, row, column);
		}
	}

	//绘制赛季数据界面背景
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