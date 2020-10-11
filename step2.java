package money;
import kruskal.*;
import java.util.*;
public class project2 extends kruskal
{
	public int[][] money;
	int vertices;
	public project2()
	{}
	public project2(int vertices)
	{
		this.vertices=vertices;
		money=new int[vertices][vertices];
	}
	public void set()
	{
		Calendar cal=Calendar.getInstance();
		Random r=new Random();
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{		
				if(i==j)
					money[i][j]=99999;
				else
					money[i][j]=r.nextInt((6000-3000)+1)+3000;
			}
		}
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				if((cal.get(Calendar.MONTH)>=3 )&& (cal.get(Calendar.MONTH)<=5))
					money[i][j]=(int)(money[i][j]*1.2);	
				else if((cal.get(Calendar.MONTH)>=6 )&& (cal.get(Calendar.MONTH)<=8))
					money[i][j]=(int)(money[i][j]*1.5);		
				else if((cal.get(Calendar.MONTH)>=9 )&& (cal.get(Calendar.MONTH)<=11))
					money[i][j]=money[i][j]*2;
			}
		}
	}
	public int[][] retmoney()
	{
		return money;
	}
}
