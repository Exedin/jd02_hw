package web.crawler.service;

import web.crawler.model.ResultDto;
import web.crawler.model.SearchDto;

public class ThreadClass extends Thread{
    private SearchDto searchDto;
    private ResultDto resultDto;
    private int deepLevel;

    public ThreadClass(SearchDto searchDto, int deepLevel, ResultDto resultDto) {
        this.searchDto = searchDto;
        this.resultDto = resultDto;
        this.deepLevel = deepLevel;
    }

    @Override
    public void run() {
        new SearchProcessor().search(searchDto, deepLevel, resultDto);
    }
}
