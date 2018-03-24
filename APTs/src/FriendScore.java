import java.util.ArrayList;
import java.util.HashSet;

public class FriendScore
{
	public int highestScore(String[] friends)
	{
		ArrayList<HashSet<Integer>> friendsList = new ArrayList<>();

		// Loop through the friends array
		// Create a set of direct friends for each friend
		for (int i = 0; i < friends.length; i++)
		{
			friendsList.add(new HashSet<Integer>());
			String[] arr = friends[i].split("");
			for (int j = 0; j < arr.length; j++)
			{
				if (arr[j].equals("Y"))
					friendsList.get(i).add(j);
			}
		}

		int[] count = new int[friends.length];

		// count number of 2 friends and
		// count number of friends per person in friends[]
		for (int i = 0; i < friendsList.size(); i++)
		{
			// hashset for counting friends and not double counting anybody
			HashSet<Integer> twoFriend = new HashSet<>();
			// count yourself
			twoFriend.add(i);

			// loop through friends of i
			for (int friendnum : friendsList.get(i))
			{
				// add friendself
				twoFriend.add(friendnum);
				// add 2friends
				twoFriend.addAll(friendsList.get(friendnum));
			}
			// make count[i] size of hashset-yourself
			count[i] = twoFriend.size() - 1;
		}

		// find max
		int max = 0;
		for (int i = 0; i < count.length; i++)
			max = Math.max(max, count[i]);

		return max;
	}
}
