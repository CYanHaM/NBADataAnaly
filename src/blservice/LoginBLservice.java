package blservice;


public interface LoginBLservice {
	/**
	 * ��������bl���login�ӿڣ�ʵ��IP��ַ��д�����֤
	 *@author blisscry
	 *@date 2015��3��26��17:48:41
	 *@version 1.0
	 */
    public void login(String url);
	
//	public void logoff(String type);
	
	public String getURL();
	
	public void setURL(String url);
}
