package blservice;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLservice {
    public ArrayList<TeamTechVO> Ascend(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 升序
     * */
    
    public ArrayList<TeamTechVO> Descend(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 降序
     * */
    
}
