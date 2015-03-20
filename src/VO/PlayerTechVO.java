package VO;

public class PlayerTechVO {
	public String name;                            //球员名称
	public String season;                          //赛季
	public String team;                            //所属球队
	public int gameNum;                         //参赛场数
	public int startingNum;                     //先发场数
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public double efficiency;                        //效率
	public double GmScEfficiency;                    //GmSc效率值
	public double trueShotInRate;                  //真实命中率
	public double shootingEfficiency;                //投篮效率
	public double reboundRate;                     //篮板率
	public double offensiveReboundRate;            //进攻篮板率
	public double defensiveReboundRate;            //防守篮板率
	public double secondaryAttackRate;             //助攻数
	public double stealRate;                       //抢断数
	public double blockShotRate;                   //盖帽数
	public double faultRate;                       //失误数	
	public double usageRate;                       //使用率
	
	//以下是赛季总数据
	
	public int offensiveNum;                    //进攻数
	public int defensiveNum;                    //防守数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //得分
	public int rebound;                         //篮板数
	public int secondaryAttack;                 //助攻数
	public int time;                            //在场时间
	
	//以下是场均数据
	
	public double offensiveNumave;                    //进攻数
	public double defensiveNumave;                    //防守数
	public double stealave;                           //抢断数
	public double blockShotave;                       //盖帽数
	public double faultave;                           //失误数
	public double foulave;                            //犯规数
	public double scoreave;                           //得分
	public double reboundave;                         //篮板数
	public double secondaryAttackave;                 //助攻数
	public double timeave;                            //在场时间
}
