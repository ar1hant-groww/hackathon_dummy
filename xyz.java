package com.example;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class xyz {
  public static void main(String[] args) {
    int numberOfPolls = 2;

    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      for (int i = 0; i < numberOfPolls; i++) {
        apiCall();

//        callModel();

        // Sleep for a specified time (e.g., 5 seconds) before the next poll
        Thread.sleep(5000); // Adjust the sleep duration as needed
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void apiCall() {
    // API endpoint URL with query parameters
    String apiUrl = "https://www.nseindia.com/api/corporate-announcements?index=equities";

    // Create an HTTP GET request with headers
    HttpGet httpGet = new HttpGet(apiUrl);
    httpGet.addHeader("authority", "www.nseindia.com");
    httpGet.addHeader("accept", "*/*");
    httpGet.addHeader("accept-language", "en-US,en;q=0.9");
    httpGet.addHeader("cookie", "nsit=3bcoaQWqUNlXdby5travZs6A; AKA_A2=A; defaultLang=en; _ga=GA1.1.1556159684.1694593201; ak_bmsc=84E64676C14DC25F1D1FAF9808E8CCDF~000000000000000000000000000000~YAAQNtcLF24OYIaKAQAAGTKgjRW2IGzg63ZoiY7fpl224CT78RxSCtQdQHqoFG/uutN09rlDsHKh8Z0uc2h16d7q1sCnfN2zbSdlE+V3+qBD+Fmyw1rG5ZRNb23LPVlH/Q30C0AfDdseIBZsSMuDW6MgNbJ/w7gOA6CFE9DD8TxuyxUOHhiQrp9JJVNXrxINl81efJ6qFX4Gvoy/HYKX26xIv2fOWC3E+W16bf2EaNSHs36LNsI5cO+PLwv9GVIL5EiI8LvELAbueb/gaEm/yZeFZnLbEejaYuHMSeslZJ9el5vWuhcE6pf81kaRePA/cUGsPdBTUfJ9d5AtRKW35X3X1uKpU5T37UiX6fTn4SreA33rZCFEP0ufKLXrrUwdMV1QiRoeyZoe4B9BHK40M8hxD0Fumyh+O00OCiDPgtek3Exhwl3VqXwft4kGhI4qS2yjFEWz32PQhK/4I0x0htjnrSsI6DYGlaVK84AdDzPxKdBkIxFw7Y7DgXm+WUJZIp0=; nseappid=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJhcGkubnNlIiwiYXVkIjoiYXBpLm5zZSIsImlhdCI6MTY5NDU5MzIyMywiZXhwIjoxNjk0NjAwNDIzfQ.LLjlm_jU_qaSLwyL133kRphWSlxMoh7ZpfipCEmIyvc; RT=\"z=1&dm=nseindia.com&si=c353ee32-67cc-43d6-acfa-a1513ab27434&ss=lmhh1brp&sl=5&se=8c&tt=4fy&bcn=%2F%2F684d0d42.akstat.io%2F\"; _ga_PJSKY6CFJH=GS1.1.1694593200.1.1.1694593224.36.0.0; bm_sv=B841D72505BC424071D01A704CBDED8B~YAAQBNcLFzAG70yKAQAAEJCgjRVZj8Qqt8hkNoQm7CxZgE/j+8cEZJJiUEItNx8Prc6uZOrWC+suKUY9ZJPhj/4QLz9ZgGY7Lkr7P5a+U8ErygpKWBjrM0aHIhu24KKygD3AC/ghbLGBdCAXSchTTOLWO0Fe8cj4sLb7WdSAkfezERHWAz65PBVWt9L3vNG8qGd5TizjGGEQ1mZ2MpL/uxpGoUPuNi2v0BXIIl02tng+oJaiH4l/cpn3Z9RySxViwyAV~1");
    httpGet.addHeader("referer", "https://w...content-available-to-author-only...a.com/companies-listing/corporate-filings-announcements");
    httpGet.addHeader("sec-ch-ua", "\"Not/A)Brand\";v=\"99\", \"Google Chrome\";v=\"115\", \"Chromium\";v=\"115\"");
    httpGet.addHeader("sec-ch-ua-mobile", "?0");
    httpGet.addHeader("sec-ch-ua-platform", "\"macOS\"");
    httpGet.addHeader("sec-fetch-dest", "empty");
    httpGet.addHeader("sec-fetch-mode", "cors");
    httpGet.addHeader("sec-fetch-site", "same-origin");
    httpGet.addHeader("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

    // Create an HTTP client
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      // Execute the request and get the response
      try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
        // Check the response status code (e.g., 200 for success)
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
          // Read and process the response content
          String responseBody = EntityUtils.toString(response.getEntity());
          System.out.println("API Response: " + responseBody);
        } else {
          System.out.println("API Request failed with status code: " + statusCode);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void callModel(){
    return;
  }
}
