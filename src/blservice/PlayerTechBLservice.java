package blservice;

import java.util.ArrayList;

import TypeEnum.PlayerTechEnum;
import VO.PlayerTechVO;

public interface PlayerTechBLservice {
    public ArrayList<PlayerTechVO> AscendAll(PlayerTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<PlayerTechVO> DescendAll(PlayerTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<PlayerTechVO> AscendAve(PlayerTechEnum DataType);
	/* �������������
	 * ��������������
	 * ����
     * */
    
    public ArrayList<PlayerTechVO> DescendAve(PlayerTechEnum DataType);
	/* �������������
	 * ��������������
	 * ����
     * */
}
