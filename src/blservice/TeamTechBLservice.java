package blservice;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLservice {
    public ArrayList<TeamTechVO> AscendAll(TeamTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> DescendAll(TeamTechEnum DataType);
	/* �������������
	 * ����������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> AscendAve(TeamTechEnum DataType);
	/* �������������
	 * ��������������
	 * ����
     * */
    
    public ArrayList<TeamTechVO> DescendAve(TeamTechEnum DataType);
	/* �������������
	 * ��������������
	 * ����
     * */
}
