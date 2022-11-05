package com.data.parser;

import com.data.parser.impl.CsvFileParser;
import com.data.parser.impl.JsonFileParser;
import com.data.parser.interfaces.DataParserInterface;
import com.data.parser.vo.OutputDataVo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@SpringBootApplication
public class DataParserMainClass {

    public static void main(String[] args) {

        FutureTask[] randomNumberTasks = new FutureTask[args.length];

        for(int i=0;i<args.length;i++) {
            if(args[i].contains(".csv")) {
                DataParserInterface csvfileParser=new CsvFileParser(args[i]);
                randomNumberTasks[i] = new FutureTask(csvfileParser);
            }else if(args[i].contains(".json")){
                DataParserInterface jsonFileParser=new JsonFileParser(args[i]);
                randomNumberTasks[i] = new FutureTask(jsonFileParser);
            }
            // As it implements Runnable, create Thread
            // with FutureTask
            Thread t = new Thread(randomNumberTasks[i]);
            t.start();
        }

        ObjectMapper objectMapper=new ObjectMapper();
        for (int i = 0; i < args.length; i++)
        {
            // As it implements Future, we can call get()
            try {
                List<OutputDataVo> outputDataVoList= (List<OutputDataVo>)randomNumberTasks[i].get();
                for(OutputDataVo outputDataVo:outputDataVoList) {
                    try {
                        System.out.print(objectMapper.writeValueAsString(outputDataVo));
                        System.out.print("\n");
                    } catch (Exception e) {
                       // e.printStackTrace();
                    }
                }
            } catch (InterruptedException e) {
               // e.printStackTrace();
            } catch (ExecutionException e) {
               // e.printStackTrace();
            }

        }


    }
}
