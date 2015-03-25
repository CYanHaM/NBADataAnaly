package presentation.ColorPreset;


import java.awt.Color;

public class TeamDataPre{
	
	Color OddTableLine;//��������ɫ
	Color EvenTableLine;//ż������ɫ
	Color LineSelected;//��Ԫ��ѡ����ɫ
	Color TableFg;//��������������ɫ
	Color TableBg;//��������������ɫ
	Color TableSelBg;//��������ѡ�б���

	public TeamDataPre(){
		//ż���л���ɫRGB 211,221,240
		OddTableLine=new Color(255,255,255);
		//�����а�ɫRGB 255,255,255
		EvenTableLine=new Color(211,221,240);
		//ѡ����Ϊ��ɫRGB 210,210,210
		LineSelected=new Color(210,210,210);
		//������������ɫ��ɫRGB 255,255,255
		TableFg=new Color(255,255,255);
		//������������ɫ�Һ�ɫRGB 135,138,143
		TableBg=new Color(135,138,143);
		//������ѡ�б�����ɫ�Ұ�ɫRGB 
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
