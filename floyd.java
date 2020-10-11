package floyd;
import places.*;
public class floyd
{
	public static int min(int a,int b)
	{
		if(a<b)
			return a;
		return b;
	}

	public static int floyds(int graph[][],int a,int b,int vertices)
	{
		for(int k=0;k<vertices;k++)
		{
			for(int j=0;j<vertices;j++)
			{
				for(int i=0;i<vertices-1;i++)
					graph[i][j]=min(graph[i][j],(graph[i][k]+graph[k][j]));
			}
		}
		return graph[a][b];
	}
}
