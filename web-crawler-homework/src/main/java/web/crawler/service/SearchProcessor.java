package web.crawler.service;

import org.jsoup.Jsoup;
import web.crawler.model.ResultDto;
import web.crawler.model.ResultItemDto;
import web.crawler.model.SearchDto;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class SearchProcessor {
    public static final Integer DEFAULT_LINK_DEEPS=4;
    public static final Integer MAX_VISITED_PAGES_LIMIT=50;

    private final HttpLoader httpLoader = new HttpLoader();
    private int visitedCounter;

    public ResultDto search(SearchDto searchDto) {
        int deepLevel=0;
        visitedCounter=1;
        //load string content by search URL
        String url=searchDto.getSeed();
        String content = httpLoader.get(searchDto.getSeed());

        //TODO: Parse string and count terms and find other URLs, calculate deep level, page URL count
        ResultDto resultDto=new ResultDto();

        //TODO: Repeat parse to max 8 level
        ResultItemDto resultItemDto;
        resultItemDto= parse(url, content, searchDto.getTerms());
        resultItemDto.setDeepLevel(deepLevel);
        isAdd(resultDto, resultItemDto);
        Set<String> href = resultItemDto.getHref();
        deepLevel++;
            for (String s : href) {
                searchDto.setSeed(s);
                search(searchDto, deepLevel, resultDto);
                visitedCounter++;
                if (visitedCounter>MAX_VISITED_PAGES_LIMIT) break;
            }

        return resultDto;

    }

    private void isAdd(ResultDto resultDto, ResultItemDto resultItemDto) {
//        synchronized (resultDto){
            resultDto.getResultItemDtoList().add(resultItemDto);
//        }
    }

    public void search(SearchDto searchDto, int deepLevel, ResultDto resultDto) {
        //load string content by search URL
        String url=searchDto.getSeed();
        String content = httpLoader.get(searchDto.getSeed());

        //TODO: Repeat parse to max 8 level
        ResultItemDto resultItemDto = parse(url, content, searchDto.getTerms());
        resultItemDto.setDeepLevel(deepLevel);
        isAdd(resultDto, resultItemDto);
        if (deepLevel<DEFAULT_LINK_DEEPS) {
            Set<String> href = resultItemDto.getHref();
            deepLevel++;
            for (String s : href) {
                searchDto.setSeed(s);
                search(searchDto, deepLevel, resultDto);
                visitedCounter++;
                if (visitedCounter>MAX_VISITED_PAGES_LIMIT) break;
            }
        }

    }

    private ResultItemDto parse(String url, String sContent, List<String> terms) {
        ResultItemDto resultItemDto=new ResultItemDto();
        String content = sContent.toLowerCase();
        resultItemDto.setSearchUrl(url);
        for (String term:terms){
            Pattern pattern=Pattern.compile(term);
            Matcher matcher = pattern.matcher(content);
            int count=0;
            while (matcher.find()){
                count++;
            }
            resultItemDto.getTermCountMap().put(term, count);
        }
        if (url!=null){
            Set<String> href = getHref(url);
            resultItemDto.setHref(href);
        }


        return resultItemDto;
    }

    private Set<String> getHref(String url) {
        Document document; // Can also take an URL.
        Set<String> href = new HashSet<>();
        try {
            document = Jsoup.connect(url).get();
            for (Element element : document.getElementsByTag("a")) {
                if ((element.attr("href").contains("http")
                        ||element.attr("href").contains("https"))
                        &&href.size()<5){
                    href.add(element.attr("href"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return href;
    }
}

