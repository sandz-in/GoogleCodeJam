/**
 * https://code.google.com/codejam/contest/dashboard?c=32003#s=p0
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AlienNumber
{
	static String inputFile = "";
	static String outputFile = "";

	static
	{
		inputFile = "A.in";
		outputFile = "/home/sandeep/A.out";
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = null;
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

		br = new BufferedReader(new FileReader("/home/sandeep/Downloads/A-large-practice.in"));
		int testCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCases; i++)
		{
			String row = br.readLine();
			String[] cols = row.split(" ");
			String target = cols[0];
			String base1 = cols[1];
			String base2 = cols[2];
			int base1Length = base1.length();
			int base2Length = base2.length();
			Map<String, Integer> map1 = new HashMap<String, Integer>();

			for (Integer j = 0; j < base1Length; j++)
			{
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("");
				stringBuilder.append(base1.charAt(j));
				map1.put(stringBuilder.toString(), j);
			}

			Map<Integer, String> map2 = new HashMap<Integer, String>();
			for (Integer j = 0; j < base2Length; j++)
			{
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("");
				stringBuilder.append(base2.charAt(j));
				map2.put(j, stringBuilder.toString());
			}

			long targetDecimal = 0;
			for (int j = target.length() - 1, z = 0; j >= 0; j--, z++)
			{
				char x = target.charAt(z);
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append("");
				stringBuilder.append(x);
				int value = map1.get(stringBuilder.toString());
				targetDecimal = (long) (targetDecimal + (Math.pow(base1Length, j) * value));
			}

			String converted = "";
			while (targetDecimal > 0)
			{
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(map2.get((int) (targetDecimal % base2Length)));
				stringBuilder.append(converted);
				converted = stringBuilder.toString();
				targetDecimal = targetDecimal / base2Length;
			}

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Case #");
			stringBuilder.append((i + 1));
			stringBuilder.append(": ");
			stringBuilder.append(converted);
			stringBuilder.append("\n");
			out.write(stringBuilder.toString());
		}
		out.flush();

	}

}
