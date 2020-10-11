package time;
import java.util.*;
import kruskal.*;
import places.*;
public class project1 extends kruskal
{
 public int[][] time;
	int vertices;
	public project1()
	{}
	public project1(int vertices)
	{
		this.vertices=vertices;
		time=new int[vertices][vertices];
	}
	public void set()
	{
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
			{
				if(i==j)
					time[i][j]=99999;
				else
				{
					Random r=new Random();
					time[i][j]= r.nextInt((360 - 60)+1)+60;
				}
			}
		}
	}
	public int[][] rettime()
	{
		return time;
	}
}
