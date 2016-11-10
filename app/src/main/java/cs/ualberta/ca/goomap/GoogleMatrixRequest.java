package cs.ualberta.ca.goomap;

/**
 * Created by Nolan on 11/8/2016.
 *
 * requires compile 'com.squareup.okhttp:okhttp:2.1.0' in dependencies
 *
 */

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class GoogleMatrixRequest {
    //do not share or modify this key
    private static final String API_KEY = "AIzaSyBRQRviRjYMvP-SqsrHNtJmAUtwLQW9jRo";

    OkHttpClient client = new OkHttpClient();
    //not tested
    public int OriginToDest(String Origin, String Destination) throws IOException {
        //create A to B url to traverse
        GoogleMatrixRequest request = new GoogleMatrixRequest();
        //create url out of our A to B request
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + Origin
                +"&destinations=" + Destination + "&mode=driving&language=fr-FR&key=" + API_KEY;
        //run this url and return the component
        String response = request.run(url);
        //prints Json format response
        System.out.println(response);
        //return will return response's distance component
        return 0;
    }

    public String run(String url) throws IOException {

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        GoogleMatrixRequest request = new GoogleMatrixRequest();
        //origin= and destination= need to be modded to be inputted geocodes
        String url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Vancouver+BC%7CSeattle&destinations=San+Francisco%7CVictoria+BC&mode=bicycling&language=fr-FR&key=" + API_KEY;
        String response = request.run(url_request);
        System.out.println(response);
    }
}