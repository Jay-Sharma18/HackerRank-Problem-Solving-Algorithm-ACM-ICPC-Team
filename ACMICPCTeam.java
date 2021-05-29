package JavaAlgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
    // Write your code here
    
    //count of max. subjects known to a team
    int countof1max=0;
    //count of Teams that know maximum  subjects
    int countOfTeams=0;
    //loop to compare each team with another to see which team knows max subjects 
    for(int i=0, j=topic.size()-1;j>=0;j--)
    {
        int countof1=0;
        if(i!=j)
        {   
            //loop to find how many subjects are known to 2 teams
            for(int z=0;z<topic.get(i).length();z++)
            {
                if(topic.get(i).charAt(z)=='1' || topic.get(j).charAt(z)=='1')
                {
                    countof1++;
                }
            }
        }
        //find max subjects known to a team. also initialize count of such teams with              max subjects known
        if(countof1>countof1max)
        {
            countof1max=countof1;
            countOfTeams=2;
        }
        //if other teams know max subjects, increment the counter
        else if(countof1==countof1max)
        {
            countOfTeams++;
        }
        
        if(j==0)
        {
            i++;
            j=topic.size();
        }
        if(i==topic.size()) break;
    }
    
    List<Integer> answer=new ArrayList<Integer>();
    answer.add(countof1max);
    answer.add(countOfTeams/2); // since each team is counted twice, divide count by 2
    return answer;

    }

}

public class ACMICPCTeam {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Jay\\Desktop\\Selenium,Drivers and Cucumber\\test.txt"));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]); 

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<String> topic = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> result = Result.acmTeam(topic);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
	        );

	        bufferedReader.close();
	        bufferedWriter.close();
	    }
	}


