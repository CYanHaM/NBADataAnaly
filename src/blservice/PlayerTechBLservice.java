package blservice;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;
import VO.PlayerVO;

public interface PlayerTechBLservice {
    public ArrayList<PlayerTechVO> Ascend(PlayerTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<PlayerTechVO> Descend(PlayerTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<PlayerTechVO> sift(String position, String division, PlayerTechVO ptvo);
	/* ��������ɸѡ������
	 * ������ɸѡ�������У���Աλ�ã���Ա����
	 * �����������������У���Ա���ƣ�������ӣ������������ȷ������������������������ڳ�ʱ�䣬Ͷ�������ʣ����������ʣ����������ʣ���������������������������ñ����ʧ���������������÷֣�Ч�ʣ�GmScЧ��ֵ����ʵ�����ʣ�Ͷ��Ч�ʣ������ʣ����������ʣ����������ʣ������ʣ������ʣ���ñ�ʣ�ʧ���ʣ�ʹ����
	 * ɸѡ������Ϊ�ض����Դ���ptpo
	 * ����������Ϊ�������Է�0
	 * */
}
