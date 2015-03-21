package bussinesslogic.TeamTech;

public class TeamTechLineItem {
	public String name;                            //球队名称
	public String season;                          //赛季
	public int gameNum;                         //比赛场数
	public double shotInRate;                      //投篮命中率
	public double threeShotInRate;                 //三分命中率
	public double penaltyShotInRate;               //罚球命中率
	public double winningRate;                     //胜率
	public double offensiveEfficiency;               //进攻效率
	public double defensiveEfficiency;               //防守效率
	public double reboundEfficiency;                 //篮板效率
	public double stealEfficiency;                   //抢断效率
	public double secondaryAttackEfficiency;         //助攻效率
	public int winningNum;                      //胜场数
	
	//以下是总数据
	
	public int shotInNum;                       //投篮命中数
	public int shotNum;                         //投篮出手数
	public int threeShotInNum;                  //三分命中数
	public int threeShotNum;                    //三分出手数
	public int penaltyShotInNum;                //罚球命中数
	public int penaltyShotNum;                  //发球出手数
	public int offensiveRebound;                //前场篮板数
	public int defensiveRebound;                //后场篮板数
	public int rebound;                         //总篮板数
	public int secondaryAttack;                 //助攻数
	public int steal;                           //抢断数
	public int blockShot;                       //盖帽数
	public int fault;                           //失误数
	public int foul;                            //犯规数
	public int score;                           //比赛得分
	public double offensiveRound;                  //进攻回合
	
	//以下是场均数据
	
	public double shotInNumave;                       //投篮命中数
	public double shotNumave;                         //投篮出手数
	public double threeShotInNumave;                  //三分命中数
	public double threeShotNumave;                    //三分出手数
	public double penaltyShotInNumave;                //罚球命中数
	public double penaltyShotNumave;                  //发球出手数
	public double offensiveReboundave;                //前场篮板数
	public double defensiveReboundave;                //后场篮板数
	public double reboundave;                         //总篮板数
	public double secondaryAttackave;                 //助攻数
	public double stealave;                           //抢断数
	public double blockShotave;                       //盖帽数
	public double faultave;                           //失误数
	public double foulave;                            //犯规数
	public double scoreave;                           //比赛得分
	public double offensiveRoundave;                  //进攻回合
}
