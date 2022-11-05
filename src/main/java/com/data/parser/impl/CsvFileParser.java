package com.data.parser.impl;

import com.data.parser.interfaces.DataParserInterface;
import com.data.parser.vo.OutputDataVo;
import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileParser implements DataParserInterface {

    String fileName;

    public CsvFileParser(String fileName){
        this.fileName=fileName;
    }

    public List<OutputDataVo> parseFileAndConvertToVo() {
        List<OutputDataVo> outputDataVoList=new ArrayList<>();
        String fileNameTemp = "src/main/resources/" + fileName;
        try (CSVReader reader = new CSVReader(new FileReader(fileNameTemp))) {

            String[] row;
            int count = 0;
            try {
                while ((row = reader.readNext()) != null) {
                    OutputDataVo outputDataVo = new OutputDataVo();
                    if (count != 0) {
                        try {
                            outputDataVo.setLine(count);
                            outputDataVo.setFilename(fileName);
                            outputDataVo.setId(Integer.valueOf(row[0]));
                            outputDataVo.setOrderId(Integer.valueOf(row[0]));
                            outputDataVo.setAmount(Float.valueOf(row[1]));
                            outputDataVo.setCurrency(row[2]);
                            outputDataVo.setComment(row[3]);
                            outputDataVo.setResult("OK");

                        }catch (Exception e) {
                            outputDataVo.setResult("error");
                           // e.printStackTrace();
                        }
                        outputDataVoList.add(outputDataVo);
                    }

                    count++;
                }


            } catch (Exception e) {
               // e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
           // e.printStackTrace();
        } catch (IOException e) {
           // e.printStackTrace();
        }
        return outputDataVoList;
    }

}
