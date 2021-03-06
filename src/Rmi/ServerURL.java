package Rmi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import TypeEnum.ResultMessage;

public class ServerURL {
	/**
	 * @author 小乌龟
	 * @mender blisscry
	 * @date 2015年3月26日17:01:27
	 * @version 1.2
	 */
	//服务器地址，随着主机以及网络的变化随时会改变
	String Host;
	//所有service对应端口号，一般情况下不会修改
	String PlayerPort="5000";
	String TeamPort="5001";
	String PlayerTechPort="5002";
	String TeamTechPort="5003";

	//定义ServerURL文件路径和临时存放服务器URL的数据
	File file=new File("reference/ServerURL.txt");
	ArrayList<String> URL=new ArrayList<String>();

	public ServerURL(){
		URL=read();
		Host=URL.get(0);
	}

	//文件的序列化读写
	public ResultMessage write(ArrayList<String> list){
		try{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			oos.flush();
			return ResultMessage.Success;
		}catch(IOException e){
			e.printStackTrace();
			return ResultMessage.Fail;
		}
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> read(){
		ArrayList<String> result = new ArrayList<String>();
		try{
			FileInputStream fis = new FileInputStream("reference/ServerURL.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			result.clear();
			result = (ArrayList<String>)ois.readObject();
			ois.close();
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
	}
	//-----------------------------------------------------------

//	public void test(String url){
//		ArrayList<String> urllist=new ArrayList<String>();
//		urllist.add(url);
//		write(urllist);
//	}

	public String getHost() {
		return Host;
	}
	public String getPlayerPort(){
		return PlayerPort;
	}
	public String getPlayerTechPort(){
		return PlayerTechPort;
	}
	public String getTeamPort(){
		return TeamPort;
	}
	public String getTeamTechPort(){
		return TeamTechPort;
	}
}
