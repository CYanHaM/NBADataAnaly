package bussinesslogic.LoginBL;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import blservice.LoginBLservice;
import Rmi.LinkTeamTechService;
import TypeEnum.ResultMessage;

public class Login implements LoginBLservice{
	LinkTeamTechService ltts;
	public Login(){
	}
	
	public void login(String url) {
		setURL(url);
		ltts=new LinkTeamTechService();
	}
	
	
	public void setURL(String url){
		ArrayList<String> urllist=new ArrayList<String>();
		urllist=read();
		if(urllist.size()>0){
		urllist.set(0, url);
		write(urllist);
		}else{
			urllist.set(0, url);
			write(urllist);
		}
	}

	public String getURL(){
		ArrayList<String> urllist=new ArrayList<String>();
		urllist=read();
		if(urllist.size()>0){
			return urllist.get(0);
		}else{
			return "本地无IP记录";
		}
	}

	
	File file=new File("reference/ServerURL.txt");
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

}
