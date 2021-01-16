package web.crawler.model;

import java.util.*;

public class ResultItemDto {

    private int deepLevel=0;
    private Set<String> href=new HashSet<>();
    private String searchUrl;
    private Map <String, Integer> termCountMap= new HashMap<>();

    @Override
    public String toString() {
        return "ResultItemDto{" +
                "deepLevel=" + deepLevel +
                ", href=" + href +
                ", searchUrl='" + searchUrl + '\'' +
                ", termCountMap=" + termCountMap +
                '}';
    }

    public void setHref(Set<String> href) {
        this.href = href;
    }

    public Set<String> getHref() {
        return href;
    }

    public void setDeepLevel(int deepLevel) {
        this.deepLevel = deepLevel;
    }

    public int getDeepLevel() {
        return deepLevel;
    }

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public void setTermCountMap(Map<String, Integer> termCountMap) {
        this.termCountMap = termCountMap;
    }

    public String getSearchUrl() {
        return searchUrl;
    }

    public Map<String, Integer> getTermCountMap() {
        return termCountMap;
    }
}
