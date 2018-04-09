
package usaco;

import java.io.IOException;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.util.StringTokenizer;
// import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class pos
{
	int x;
	int y;

	public pos(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

public class multimoo
{
	public static int[][] map;
	public static boolean[][] visited;
	public static HashMap<Integer, ArrayList<pos>> regionNexts = new HashMap<>();
	public static HashMap<Integer, HashSet<pos>> region = new HashMap<>();
	public static HashMap<Integer, Integer> idOfRegion = new HashMap<>();

	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("multimoo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("multimoo.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int size = Integer.parseInt(st.nextToken());
		map = new int[size][size];
		visited = new boolean[size][size];
		HashMap<Integer, Integer> ids = new HashMap<>();
		int count = 0;
		for (int i = 0; i < size; i++)
		{
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < size; j++)
			{
				int id = Integer.parseInt(st.nextToken());
				if (ids.containsKey(id))
					map[i][j] = ids.get(id);
				else
				{
					ids.put(id, count);
					map[i][j] = count;
					count++;
				}
			}
		}

		int max = 0;
		count = 0;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (!visited[i][j])
				{
					regionNexts.put(count, new ArrayList<>());
					region.put(count, new HashSet<>());
					idOfRegion.put(count, map[i][j]);
					max = Math.max(max, ff(i, j, count));
					count++;
				}
		out.println(max);

		max = 0;
		for (int i = 0; i < regionNexts.size(); i++)
			max = Math.max(max, ff1(i, new boolean[regionNexts.size()]));
		out.println(max);
		out.close();
		f.close();
	}

	public static int ff1(int regioncount, boolean[] visited)
	{
		int max = 0;
		visited[regioncount] = true;
		LinkedList<Integer> q = new LinkedList<>();
		q.add(regioncount);// loop through regions next to region
		int id1;
		return max;
	}

	public static int ff(int x, int y, int count)
	{
		int[] dx =
			{ 0, 0, 1, -1 };
		int[] dy =
			{ 1, -1, 0, 0 };
		LinkedList<pos> q = new LinkedList<>();
		visited[x][y] = true;
		int id = map[x][y];
		q.add(new pos(x, y));
		region.get(count).add(new pos(x, y));
		while (!q.isEmpty())
		{
			pos curr = q.poll();
			for (int i = 0; i < 4; i++)
				if (curr.x + dx[i] > -1 && curr.x + dx[i] < map.length && curr.y + dy[i] > -1
						&& curr.y + dy[i] < map.length && !visited[curr.x + dx[i]][curr.y + dy[i]])
				{
					if (map[curr.x + dx[i]][curr.y + dy[i]] == id)
					{
						q.add(new pos(curr.x + dx[i], curr.y + dy[i]));
						visited[curr.x + dx[i]][curr.y + dy[i]] = true;
						region.get(count).add(new pos(curr.x + dx[i], curr.y + dy[i]));
					}
					else
						regionNexts.get(count).add(new pos(curr.x + dx[i], curr.y + dy[i]));
				}
		}
		return region.get(count).size();
	}
}
