package com.data.parser.interfaces;

import com.data.parser.vo.OutputDataVo;

import java.util.List;
import java.util.concurrent.Callable;

public interface DataParserInterface extends Callable {
    @Override
    public default Object call() throws Exception {
        return parseFileAndConvertToVo();
    }

    public List<OutputDataVo> parseFileAndConvertToVo();

}
