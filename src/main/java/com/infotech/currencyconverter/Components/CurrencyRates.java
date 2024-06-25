package com.infotech.currencyconverter.Components;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TimeZone;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

public class CurrencyRates {
    private HashMap<String, Number> currencyRates;
    private String previousUpdate;
    private final File storedData;
    private final URL apiURL;
    
    public CurrencyRates() throws MalformedURLException{
       currencyRates = new HashMap<>();
       currencyRates.put("USD",1.00);
       currencyRates.put("PHP",50.00);
       storedData = new File("data.txt");
       apiURL = new URL("https://v6.exchangerate-api.com/v6/0055baa5d8d28b1ce7a3f00c/latest/USD");
       loadLocalData();
    }
    
    public boolean synchronizeData(){
        try{
            HttpURLConnection conn = (HttpURLConnection) apiURL.openConnection();
            conn.setRequestMethod("GET");
            if(conn.getResponseCode()!=200) return false;
            String output = "";
            Scanner sc = new Scanner(apiURL.openStream());
            while(sc.hasNext()){
                output+=sc.nextLine();
            }
            sc.close();
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject)parse.parse(output);
            JSONObject obj = (JSONObject) data_obj.get("conversion_rates");
            previousUpdate = unixToDate(Integer.parseInt(data_obj.get("time_last_update_unix").toString()));
            currencyRates = obj;
            saveLocalData(data_obj);
            return true;
        } catch (Exception e){
           return false;
        }
    
    }
    public void deleteLocalData(){
        storedData.delete();
    }
    public void saveLocalData(JSONObject obj){
        try{
            storedData.createNewFile();
            FileWriter dataWriter = new FileWriter(storedData);
            dataWriter.write(obj.toString());
            dataWriter.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Cannot save data locally! "+e.getMessage());
        }
    }
    public boolean loadLocalData(){
        try{
            FileReader dataReader = new FileReader(storedData);
            Scanner sc = new Scanner(dataReader);
            String output = "";
            while(sc.hasNext()){
                output+=sc.nextLine();
            }
            JSONParser parse = new JSONParser();
            JSONObject data_obj = (JSONObject)parse.parse(output);
            JSONObject obj = (JSONObject) data_obj.get("conversion_rates");
            previousUpdate = unixToDate(Integer.parseInt(data_obj.get("time_last_update_unix").toString()));
            currencyRates = obj;
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public double getRates(String fromCur, String toCur, double amount){
        try{
            return amount*(currencyRates.get(toCur).doubleValue()/currencyRates.get(fromCur).doubleValue());
        } catch (Exception e){
            return -1;
        }
    }
    public String getPreviousUpdate(){
        return previousUpdate;
    }
    public ArrayList<String> getCurrencyList(){
        ArrayList<String> currencyList = new ArrayList<>(currencyRates.keySet());
        Collections.sort(currencyList);
        return currencyList;
    }
    private String unixToDate(int unix){
        Date date = new Date(unix*1000L);
        SimpleDateFormat jdf = new SimpleDateFormat("yyyy-MM-dd HH:mm z");
        jdf.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return jdf.format(date);

    }
}
