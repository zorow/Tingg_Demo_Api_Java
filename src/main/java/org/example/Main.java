package org.example;

import com.google.gson.Gson;
import okhttp3.*;
import org.paymentstatusrequests.Credentials;
import org.paymentstatusrequests.Packet;
import org.paymentstatusrequests.Payload;
import org.requests.Root;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {





    public static void main(String[] args)  {

        LocalDateTime billDate = LocalDateTime.now(ZoneId.of("Africa/Nairobi"));




        String dateFormatPattern = "yyyy-MM-dd hh:mm:ss";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormatPattern);

        String dateTime = billDate.format(dateTimeFormatter);


        TinggApiModel tinggTest = new TinggApiModel();
        tinggTest.setAPI_USER_NAME("sandboxUser");
        tinggTest.setAPI_USER_PASSWORD("sandboxPassword!");
        tinggTest.setSERVICE_CODE("KE-GOTV");
        tinggTest.setCOUNTRY_CODE("KE");
        tinggTest.setCURRENCY_CODE("KES");
        tinggTest.setMSISDN("254722000000");
        tinggTest.setACCOUNT_NUMBER("7023571052");
        tinggTest.setCUSTOMER_NAME("");
        tinggTest.setAMOUNT(10);
        tinggTest.setDATE_PAYMENT_RECEIVED(dateTime);
        tinggTest.setPAYMENT_MODE("MOBILE");
        tinggTest.setNARRATION("GO TV PAYMENT TEST");
        tinggTest.setPAYER_TRANSACTION_ID(Utills.generateRandomNumber(9999999, 1111111) + "_tingg");
        tinggTest.setEXTRA_DATA("");
        //tinggTest.setEXTRA_DATA("{\\\"callbackUrl\\\":\\\"https:\\/\\/ec2b-196-201-231-254.eu.ngrok.io\\/tingg\\/callback.php\\\"}");
        tinggTest.setHUB_ID(Utills.generateRandomNumber(9999999, 1111111) + "_tingg");


        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };

        try {

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

        OkHttpClient client = new OkHttpClient().newBuilder().sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0]).hostnameVerifier((s, sslSession) -> true)
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"countryCode\": \""+tinggTest.getCOUNTRY_CODE()+"\",\n\t\"function\": \"BEEP.postPayment\",\n\t\"payload\": {\n\t\t\"credentials\": {\n\t\t\t\"username\": \""+tinggTest.getAPI_USER_NAME()+"\",\n\t\t\t\"password\": \""+tinggTest.getAPI_USER_PASSWORD()+"\"\n\t\t},\n\t\t\"packet\": [{\n\t\t\t\"serviceCode\": \""+tinggTest.getSERVICE_CODE()+"\",\n\t\t\t\"MSISDN\": \""+tinggTest.getMSISDN()+"\",\n\t\t\t\"invoiceNumber\": \""+tinggTest.getINVOICE_NUMBER()+"\",\n\t\t\t\"accountNumber\": \""+tinggTest.getACCOUNT_NUMBER()+"\",\n\t\t\t\"payerTransactionID\": \""+tinggTest.getPAYER_TRANSACTION_ID()+"\",\n\t\t\t\"amount\": "+tinggTest.getAMOUNT()+",\n\t\t\t\"hubID\": \""+tinggTest.getHUB_ID()+"\",\n\t\t\t\"narration\": \""+tinggTest.getNARRATION()+"\",\n\t\t\t\"datePaymentReceived\": \""+tinggTest.getDATE_PAYMENT_RECEIVED()+"\",\n\t\t\t\"extraData\": \""+tinggTest.getEXTRA_DATA()+"\",\n\t\t\t\"currencyCode\": \""+tinggTest.getCURRENCY_CODE()+"\",\n\t\t\t\"customerNames\": \""+tinggTest.getCUSTOMER_NAME()+"\",\n\t\t\t\"paymentMode\": \"Online Payment\"\n\t\t}]\n\t}\n}");
        Request request = new Request.Builder()
                .url("https://beep2.cellulant.com:9001/paymentRouter/JSONV2/")
                .method("POST", body)
                .addHeader("Content-Type", "text/plain")
                .build();

            ResponseBody responseBody = client.newCall(request).execute().body();

            String got_response = responseBody.string();

            Gson gson = new Gson();

            Root root = gson.fromJson(got_response, Root.class);

          // System.out.println(gson.toJson(root));

            org.paymentstatusrequests.Root root1 = new org.paymentstatusrequests.Root();
            root1.setFunction("BEEP.queryPaymentStatus");
            root1.setCountryCode("KE");
            Payload payload = new Payload();
            Credentials credentials = new Credentials();
            credentials.setUsername("sandboxUser");
            credentials.setPassword("sandboxPassword!");
            Packet packet = new Packet();
            packet.setPayerTransactionID(tinggTest.getPAYER_TRANSACTION_ID());
            packet.setBeepTransactionID("");
            ArrayList<Packet>packetArrayList = new ArrayList<>();
            packetArrayList.add(packet);
            payload.setPacket(packetArrayList);
            payload.setCredentials(credentials);
            root1.setPayload(payload);

            String payment_status_request_json = gson.toJson(root1);
            //System.out.println(payment_status_request_json);

            OkHttpClient client2 = new OkHttpClient().newBuilder().sslSocketFactory(sslContext.getSocketFactory(), (X509TrustManager) trustAllCerts[0]).hostnameVerifier((s, sslSession) -> true)
                    .build();
            MediaType mediaType2 = MediaType.parse("application/json");
            RequestBody body2 = RequestBody.create(mediaType2, payment_status_request_json);
            Request request2 = new Request.Builder()
                    .url("https://beep2.cellulant.africa:9001/paymentRouter/JSON/")
                    .method("POST", body2)
                    .addHeader("Content-Type", "application/json")
                    .build();


            ResponseBody responseBody2 = client2.newCall(request2).execute().body();

            String got_response_2 = responseBody2.string();

            System.out.println(got_response_2);

            org.paymentstatusresponses.Root root2 = gson.fromJson(got_response_2, org.paymentstatusresponses.Root.class);




           //get payment response from api


        } catch (Exception e) {
            System.out.println(e.getMessage());

           // throw new RuntimeException(e);

        }


        //System.out.println("Hello world!");


       // String test = "{\n\t\"countryCode\": \""+tinggTest.getCOUNTRY_CODE()+"\",\n\t\"function\": \"BEEP.postPayment\",\n\t\"payload\": {\n\t\t\"credentials\": {\n\t\t\t\"username\": \""+tinggTest.getAPI_USER_NAME()+"\",\n\t\t\t\"password\": \""+tinggTest.getAPI_USER_PASSWORD()+"\"\n\t\t},\n\t\t\"packet\": [{\n\t\t\t\"serviceCode\": \""+tinggTest.getSERVICE_CODE()+"\",\n\t\t\t\"MSISDN\": \""+tinggTest.getMSISDN()+"\",\n\t\t\t\"invoiceNumber\": \""+tinggTest.getINVOICE_NUMBER()+"\",\n\t\t\t\"accountNumber\": \""+tinggTest.getACCOUNT_NUMBER()+"\",\n\t\t\t\"payerTransactionID\": \""+tinggTest.getPAYER_TRANSACTION_ID()+"\",\n\t\t\t\"amount\": "+tinggTest.getAMOUNT()+",\n\t\t\t\"hubID\": \""+tinggTest.getHUB_ID()+"\",\n\t\t\t\"narration\": \""+tinggTest.getNARRATION()+"\",\n\t\t\t\"datePaymentReceived\": \""+tinggTest.getDATE_PAYMENT_RECEIVED()+"\",\n\t\t\t\"extraData\": \""+tinggTest.getEXTRA_DATA()+"\",\n\t\t\t\"currencyCode\": \""+tinggTest.getCURRENCY_CODE()+"\",\n\t\t\t\"customerNames\": \""+tinggTest.getCUSTOMER_NAME()+"\",\n\t\t\t\"paymentMode\": \"Online Payment\"\n\t\t}]\n\t}\n}";
        //System.out.print(test);
    }
}