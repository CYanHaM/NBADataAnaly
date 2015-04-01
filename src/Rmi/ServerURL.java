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
	 * @author С�ڹ�
	 * @mender blisscry
	 * @date 2015��3��26��17:01:27
	 * @version 1.2
	 */
	//��������ַ�����������Լ�����ı仯��ʱ��ı�
	String Host;
	//����service��Ӧ�˿ںţ�һ������²����޸�
	String PlayerPort="5000";
	String TeamPort="5001";
	String PlayerTechPort="5002";
	String TeamTechPort="5003";

	//����ServerURL�ļ�·������ʱ��ŷ�����URL������
	File file=new File("reference/ServerURL.txt");
	ArrayList<String> URL=new ArrayList<String>();

	public ServerURL(){
		URL=read();
		Host=URL.get(0);
	}

	//�ļ������л���д
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