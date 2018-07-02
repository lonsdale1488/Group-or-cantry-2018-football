package S.Murashev;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.text.GapContent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logict a = new Logict();
       a.disableSSL();
        ArrayList<String> as= new ArrayList<>();

        try {
            String response = a.getMatchesToday();
            JSONArray arrayrespons = new JSONArray(response);

            Scanner sc = new Scanner(System.in);
            String word = sc.nextLine();
            for (int i = 0; i < arrayrespons.length(); i++)//
            {
                JSONObject obj = arrayrespons.getJSONObject(i);


                JSONArray groupStatistik = obj.getJSONArray("ordered_teams");
                for (int j = 0; j < groupStatistik.length() ;j++) //
                {

                   JSONObject countryStatistik = groupStatistik.getJSONObject(j);
                   String group = countryStatistik.getString("group_letter");

                   String countryInGroup = countryStatistik.getString("country");
                   Integer points = countryStatistik.getInt("points");
                    if (word.equalsIgnoreCase(group))
                    {
                        System.out.println(countryInGroup + " " + points);
                    }
                    else if (word.equalsIgnoreCase(countryInGroup))
                    {
                        System.out.println(countryInGroup + " " + points);
                    }

                }



            }






            //  System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
