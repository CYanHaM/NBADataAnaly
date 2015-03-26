package blservice;


public interface LoginBLservice {
	/**
	 * 界面层调用bl层的login接口，实现IP地址的写入和验证
	 *@author blisscry
	 *@date 2015年3月26日17:48:41
	 *@version 1.0
	 */
    public boolean login(String url);
	
//	public void logoff(String type);
	
	public void setURL(String url);
	
	public String getURL();
}
