package com.data.parser.impl;

import com.data.parser.interfaces.DataParserInterface;
import com.data.parser.vo.OutputDataVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileParser implements DataParserInterface {

    String fileName;

    public JsonFileParser(String fileName){
        this.fileName=fileName;
    }

    public List<OutputDataVo> parseFileAndConvertToVo() {
        List<OutputDataVo> outputDataVoList=new ArrayList<>();
        String fileNameTemp = "src/main/resources/" + fileName;
        try {
            Object obj = new JSONParser().parse(new FileReader(fileNameTemp));
            if(obj instanceof JSONObject){
                JSONObject jsonObject=(JSONObject)obj;
                addObjectToList(outputDataVoList,jsonObject,1);
            }else if(obj instanceof JSONArray){
                JSONArray jsonArray=(JSONArray)obj;
                for (int i = 0; i < jsonArray.size(); i++) {

                    JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                    addObjectToList(outputDataVoList,jsonObject,i+1);
                }
            }

        } catch (IOException e) {
           // e.printStackTrace();
        } catch (ParseException e) {
           // e.printStackTrace();
        }
        return outputDataVoList;


    }

    private void addObjectToList(List<OutputDataVo> outputDataVoList,
                                 JSONObject jsonObject,int count){
        OutputDataVo outputDataVo = new OutputDataVo();
        /*
        {"orderId":4, "amount":1.24, "currency": "EUR", "comment": "order payment"}
         */
        try {
            outputDataVo.setLine(count);
            outputDataVo.setFilename(fileName);
            outputDataVo.setId(Integer.valueOf(jsonObject.get("orderId").toString()));
            outputDataVo.setOrderId(Integer.valueOf(jsonObject.get("orderId").toString()));
            outputDataVo.setAmount(Float.valueOf(jsonObject.get("amount").toString()));
            outputDataVo.setCurrency(jsonObject.get("currency").toString());
            outputDataVo.setComment(jsonObject.get("comment").toString());
            outputDataVo.setResult("OK");

        }catch (Exception e) {
            outputDataVo.setResult("error");
           // e.printStackTrace();
        }

        outputDataVoList.add(outputDataVo);
    }

}
