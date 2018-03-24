import java.util.ArrayList;
import java.util.Collections;

public class MemberCheck
{
	public String[] whosDishonest(String[] club1, String[] club2, String[] club3)
	{
		ArrayList<String> dishonestPeoples = new ArrayList<String>();
		String[] peoplesNames = new String[club1.length + club2.length + club3.length];

		for (int i = 0; i < club1.length + club2.length + club3.length; i++)
			peoplesNames[i] = i < club1.length ? club1[i]
					: i - club1.length < club2.length ? club2[i - club1.length]
							: club3[i - club1.length - club2.length];

		for (int i = 0; i < club1.length; i++)
			for (int j = club1.length; j < peoplesNames.length; j++)
				if (club1[i].equals(peoplesNames[j]))
					dishonestPeoples.add(club1[i]);
		for (int i = 0; i < club2.length; i++)
			for (int j = club2.length + club1.length; j < peoplesNames.length; j++)
				if (club2[i].equals(peoplesNames[j]))
					dishonestPeoples.add(club2[i]);

		Collections.sort(dishonestPeoples);
		for (int i = 0; i < dishonestPeoples.size() - 1; i++)
			if (dishonestPeoples.get(i).equals(dishonestPeoples.get(i + 1)))
			{
				dishonestPeoples.remove(i);
				i--;
			}

		String[] dishonest = new String[dishonestPeoples.size()];
		for (int i = 0; i < dishonestPeoples.size(); i++)
			dishonest[i] = dishonestPeoples.get(i);

		return dishonest;
	}
	// public static void main(String args[])
	// {
	// String[] club1={"AHHOZY","AHHAPLL","ASNV"};
	//
	// String[]
	// club2={"AHDLTOE","AHUKPJ","AHDENCTPP","AHDENCJ","AHDLNZC","AHDLTOGG","AHHAPMBG",
	// "ALE","AHBHA","AHUKP","AHDQMILLP","AHDENEDY","AHDENEE","AHHOHVCX","AHISK",
	// "AHW","AQDB","AHUP","AQDBNPU","AGWZUV","AHHOSUW","AHXS","AHDENCP","AHDQM",
	// "AHDLTURV","AHBHVV","AHDQMILL","AHDQMD","AHH","AHDLTU","AHISFNO","AHURF",
	// "AH","AHHAPNQ","AQPL","AHDXL","AHDLTUGX","AHDLT","AHUKRC","AHDLTUGX",
	// "AQDTXYX","AGWZS"};
	//
	// String[]
	// club3={"AHHAPMFF","AHURA","AHHOZ","AHISKH","AHUPR","AHHAPM","AHUKRHIN","AHHAP",
	// "AHDLTMO","AHDLTUJ","AHDQY","AHUK","AHDENEDY","AHWK","AHHOZGJJ","AHXS",
	// "AHDLTUREL","AHHOZQNL","AHHOSUWOS"};
	//
	// String[] ans=whosDishonest(club1,club2,club3);
	// System.out.println(ans.length);
	// for(int i=0;i<ans.length;i++)
	// System.out.println(ans[i]);
	// }
}
