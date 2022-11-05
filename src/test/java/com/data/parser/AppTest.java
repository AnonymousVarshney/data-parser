package com.data.parser;

import com.data.parser.impl.CsvFileParser;
import com.data.parser.impl.JsonFileParser;
import com.data.parser.interfaces.DataParserInterface;
import com.data.parser.vo.OutputDataVo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Unit test.
 */
public class AppTest
{
    @Test
    public void testCsv() {
          DataParserInterface csvfileParser=new CsvFileParser("orders.csv");
        List<OutputDataVo> outputDataVoList =csvfileParser.parseFileAndConvertToVo();

        Assert.assertEquals(outputDataVoList.get(0).getResult(),"OK");
        Assert.assertEquals(outputDataVoList.get(1).getResult(),"OK");
        Assert.assertEquals(outputDataVoList.get(2).getResult(),"error");



    }

    @Test
    public void testJson() {
        DataParserInterface csvfileParser=new JsonFileParser("orders.json");
        List<OutputDataVo> outputDataVoList =csvfileParser.parseFileAndConvertToVo();

        Assert.assertEquals(outputDataVoList.get(0).getResult(),"error");



    }


}
