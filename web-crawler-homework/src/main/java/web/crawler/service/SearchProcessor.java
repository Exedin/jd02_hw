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
    public static final Integer DEFAULT_LINK_DEEPS=1;
    public static final Integer MAX_VISITED_PAGES_LIMIT=10000;

    private final HttpLoader httpLoader = new HttpLoader();

    public ResultDto search(SearchDto searchDto) {
        int deepLevel=0;
        //load string content by search URL
        String url=searchDto.getSeed();
        String content = httpLoader.get(searchDto.getSeed());

        //TODO: Parse string and count terms and find other URLs, calculate deep level, page URL count
        ResultDto resultDto=new ResultDto();

        //TODO: Repeat parse to max 8 level
        final ResultItemDto resultItemDto;
        resultItemDto= parse(url, content, searchDto.getTerms());
        resultItemDto.setDeepLevel(deepLevel);
        resultDto.getResultItemDtoList().add(resultItemDto);
        final Set<String> href = resultItemDto.getHref();
//        if (deepLevel<DEFAULT_LINK_DEEPS) {
//            for (String s : href) {
//            final ResultItemDto resultItemDto1 = parse(s, httpLoader.get(s), searchDto.getTerms());
//            resultItemDto1.setDeepLevel(deepLevel+1);
//            resultDto.getResultItemDtoList().add(resultItemDto1);
//            }
//        }
        deepLevel++;
            for (String s : href) {
                searchDto.setSeed(s);
                search(searchDto, deepLevel, resultDto);
            }

        return resultDto;

    }

    public ResultDto search(SearchDto searchDto, int deepLevel, ResultDto resultDto) {
        //load string content by search URL
        String url=searchDto.getSeed();
        String content = httpLoader.get(searchDto.getSeed());

        //TODO: Repeat parse to max 8 level
        ResultItemDto resultItemDto = parse(url, content, searchDto.getTerms());
        resultItemDto.setDeepLevel(deepLevel);
        resultDto.getResultItemDtoList().add(resultItemDto);
        if (deepLevel<DEFAULT_LINK_DEEPS) {
            final Set<String> href = resultItemDto.getHref();
            deepLevel++;
            for (String s : href) {
                searchDto.setSeed(s);
                search(searchDto, deepLevel, resultDto);
            }
        }
        // take recursion with parameter deep level
//        final Set<String> href = resultItemDto.getHref();
//        if (deepLevel<DEFAULT_LINK_DEEPS) {
//            for (String s : href) {
//            final ResultItemDto resultItemDto1 = parse(s, httpLoader.get(s), searchDto.getTerms());
//            resultItemDto1.setDeepLevel(deepLevel+1);
//            resultDto.getResultItemDtoList().add(resultItemDto1);
//            }
//        }





//        if (deepLevel<DEFAULT_LINK_DEEPS) {
//            final Set<String> href = resultItemDto.getHref();
//            for (String s : href) {
//                searchDto.setSeed(s);
//                deepLevel++;
//                resultDto = search(searchDto, deepLevel, resultDto);
//            final ResultItemDto resultItemDto1 = parseWithHref(s, httpLoader.get(s), searchDto.getTerms());
//            resultItemDto1.setDeepLevel(deepLevel+1);
//            resultDto.getResultItemDtoList().add(resultItemDto1);
//            }
//        }
        return resultDto;

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
                Set<String> href = getHref(url);
        resultItemDto.setHref(href);

        return resultItemDto;
    }

    private Set<String> getHref(String url) {
        Document document = null; // Can also take an URL.
        Set<String> href = new HashSet<>();
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Element element : document.getElementsByTag("a")) {
            if ((element.attr("href").contains("http")
                    ||element.attr("href").contains("https"))
                    &&href.size()<5){
                href.add(element.attr("href"));
            }
        }

        return href;
    }
}

