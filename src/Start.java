import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) throws Exception {

    String result;
    URL url = new URL("http://xyzett.com/sportplaces/");

    // Verbindungsaufbau
    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    try {
      InputStream in = url.openStream();
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String line = reader.readLine();
      result = line;
      while ((line = reader.readLine()) != null) {
        result += line;
      }
    } finally {
      urlConnection.disconnect();
    }

    // Jan's Kommentar rausschneiden
    String[] jsonResultArray = result.split(">");

    String json1 = jsonResultArray[1];

    System.out.println("Unser JSON String: " + json1);

    // Wir bauen uns ein JSON Array
    JsonElement json = new JsonParser().parse(json1);
    JsonArray array = json.getAsJsonArray();

    @SuppressWarnings("rawtypes")
    Iterator iterator = array.iterator();

    // Unsere Liste an Sportplatzergebnissen
    List<MyJsonRepresentation> sportplaetze = new ArrayList<MyJsonRepresentation>();

    while (iterator.hasNext()) {
      JsonElement json2 = (JsonElement) iterator.next();
      Gson gson = new Gson();
      MyJsonRepresentation platz = gson.fromJson(json2, MyJsonRepresentation.class);

      // Ausgabe zur Kontrolle
      System.out.println(""); // now you have a real java object
      System.out.println("Die ID: " + platz.getId());
      System.out.println("Die Sportart: " + platz.getSportart());
      System.out.println("Longitude: " + platz.getLongitude());
      System.out.println("Latitude: " + platz.getLatitude());

      // und rein damit in unsere Liste
      sportplaetze.add(platz);
    }

    System.out.println("");
    System.out.println("Anzahl der Sportplaetze: " + sportplaetze.size());
  }
}
