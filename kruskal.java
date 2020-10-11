package kruskal;
import floyd.*;
import places.*;
public class kruskal extends floyd
{
	int[][] input;
public int vertices;
public int[][] output;

	public kruskal()
	{}
	public kruskal(int[][] input,int ver)
	{
		this.input=new int[vertices][vertices];
		this.input=input;
		vertices=ver;
		output=new int[vertices][vertices];
		for(int i=0;i<vertices;i++)
		{
			for(int j=0;j<vertices;j++)
				output[i][j]=99999;
		}
	}

	public int retpar(int parent[],int u)
	{
		if(parent[u]==u)
			return u;
		return retpar(parent,parent[u]);
	}

	public int kruskals(int a,int b,int flag)
	{
		int parent[]=new int[vertices];
		int count=0,cost=0,mincost=0;
		for(int i=0;i<vertices;i++)
			parent[i]=i;
		while(count!=vertices-1)
		{
			for(int i=0;i<vertices;i++)
			{
				for(int j=0;j<vertices;j++)
				{
					int u=retpar(parent,i);
					int v=retpar(parent,j);
					if(u!=v)
					{
						output[count][j]=input[i][j];
						count+=1;
						parent[j]=i;
						mincost=mincost+input[i][j]; 
					}
				}
			}
		}
		if(flag==1)
		{
			cost=floyd.floyds(output,a,b,vertices);
			return cost;
		}
		return mincost;
	}
}