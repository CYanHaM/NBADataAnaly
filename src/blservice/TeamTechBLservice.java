package blservice;

import java.util.ArrayList;

import TypeEnum.TeamTechEnum;
import VO.TeamTechVO;

public interface TeamTechBLservice {
    public ArrayList<TeamTechVO> AscendAll(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 升序
     * */
    
    public ArrayList<TeamTechVO> DescendAll(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按赛季总数据排序
	 * 降序
     * */
    
    public ArrayList<TeamTechVO> AscendAve(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按场均数据排序
	 * 升序
     * */
    
    public ArrayList<TeamTechVO> DescendAve(TeamTechEnum DataType);
	/* 传入排序的类型
	 * 按场均数据排序
	 * 降序
     * */
}
