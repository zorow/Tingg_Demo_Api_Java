package org.example;

import com.google.gson.Gson;
import okhttp3.*;
import org.requests.Root;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Main {





    public static void main(String[] args)  {

        TinggApiModel tinggTest = new TinggApiModel();
        tinggTest.setAPI_USER_NAME("sandboxUser");
        tinggTest.setAPI_USER_PASSWORD("sandboxPassword!");
        tinggTest.setSERVICE_CODE("KE-GOTV");
        tinggTest.setCOUNTRY_CODE("KE");
        tinggTest.setCURRENCY_CODE("KES");
        tinggTest.setMSISDN("254790399490");
        tinggTest.setACCOUNT_NUMBER("7023571051");
        tinggTest.setCUSTOMER_NAME("JOHN DOE");
        tinggTest.setAMOUNT(10);
        tinggTest.setDATE_PAYMENT_RECEIVED("2022-11-19 17:38:00");
        tinggTest.setPAYMENT_MODE("MOBILE");
        tinggTest.setNARRATION("GO TV PAYMENT TEST");
        tinggTest.setPAYER_TRANSACTION_ID(Utills.generateRandomNumber(9999999, 1111111) + "_tingg");
        tinggTest.setEXTRA_DATA("{\\\"callbackUrl\\\":\\\"https:\\/\\/7c82-217-21-116-219.in.ngrok.io\\/tingg\\/callback.php\\\"}");
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

           System.out.println(root.getAuthStatus().getAuthStatusCode() + " "+root.getAuthStatus().getAuthStatusDescription() + " "+root.getResults().get(0).getStatusDescription());



            //response.body().




           // System.out.print(responseBody.string() + responseBody.contentLength() + responseBody.contentType().toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());

           // throw new RuntimeException(e);

        }


        //System.out.println("Hello world!");


        //String test = "{\n\t\"countryCode\": \""+tinggTest.getCOUNTRY_CODE()+"\",\n\t\"function\": \"BEEP.postPayment\",\n\t\"payload\": {\n\t\t\"credentials\": {\n\t\t\t\"username\": \""+tinggTest.getAPI_USER_NAME()+"\",\n\t\t\t\"password\": \""+tinggTest.getAPI_USER_PASSWORD()+"\"\n\t\t},\n\t\t\"packet\": [{\n\t\t\t\"serviceCode\": \""+tinggTest.getSERVICE_CODE()+"\",\n\t\t\t\"MSISDN\": \""+tinggTest.getMSISDN()+"\",\n\t\t\t\"invoiceNumber\": \""+tinggTest.getINVOICE_NUMBER()+"\",\n\t\t\t\"accountNumber\": \""+tinggTest.getACCOUNT_NUMBER()+"\",\n\t\t\t\"payerTransactionID\": \""+tinggTest.getPAYER_TRANSACTION_ID()+"\",\n\t\t\t\"amount\": "+tinggTest.getAMOUNT()+",\n\t\t\t\"hubID\": \""+tinggTest.getHUB_ID()+"\",\n\t\t\t\"narration\": \""+tinggTest.getNARRATION()+"\",\n\t\t\t\"datePaymentReceived\": \""+tinggTest.getDATE_PAYMENT_RECEIVED()+"\",\n\t\t\t\"extraData\": \""+tinggTest.getEXTRA_DATA()+"\",\n\t\t\t\"currencyCode\": \""+tinggTest.getCURRENCY_CODE()+"\",\n\t\t\t\"customerNames\": \""+tinggTest.getCUSTOMER_NAME()+"\",\n\t\t\t\"paymentMode\": \"Online Payment\"\n\t\t}]\n\t}\n}";
        //System.out.print(test);
    }
}