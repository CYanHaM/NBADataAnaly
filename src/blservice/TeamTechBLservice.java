package blservice;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLservice {
    public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
}
