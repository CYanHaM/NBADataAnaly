package presentation.ColorPreset;


import java.awt.Color;

public class TeamDataPre{
	
	Color OddTableLine;//奇数行颜色
	Color EvenTableLine;//偶数行颜色
	Color LineSelected;//单元行选中颜色
	Color TableFg;//表格标题栏字体颜色
	Color TableBg;//表格标题栏背景颜色
	Color TableSelBg;//表格标题栏选中背景

	public TeamDataPre(){
		//偶数行灰蓝色RGB 211,221,240
		OddTableLine=new Color(255,255,255);
		//奇数行白色RGB 255,255,255
		EvenTableLine=new Color(211,221,240);
		//选中行为灰色RGB 210,210,210
		LineSelected=new Color(210,210,210);
		//标题栏字体颜色白色RGB 255,255,255
		TableFg=new Color(255,255,255);
		//标题栏背景颜色灰黑色RGB 135,138,143
		TableBg=new Color(135,138,143);
		//标题栏选中背景颜色灰白色RGB 
		TableSelBg=new Color(153,153,153);
	}
	
	public Color getTableSelBg() {
		return TableSelBg;
	}

	public Color getOddTableLine() {
		return OddTableLine;
	}

	public Color getEvenTableLine() {
		return EvenTableLine;
	}

	public Color getLineSelected() {
		return LineSelected;
	}

	public Color getTableFg() {
		return TableFg;
	}

	public Color getTableBg() {
		return TableBg;
	}
	
	
}
