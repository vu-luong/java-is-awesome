package com.vuluong;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class WebCrawlerMultithreaded {
    private interface HtmlParser {
        List<String> getUrls(String url);
    }
    
    private static class Solution {
        private final Set<String> set = ConcurrentHashMap.newKeySet();
        private String startHost;
        
        class CrawlTask extends ForkJoinTask<String> {
            private final String url;
            private final HtmlParser htmlParser;
            
            public CrawlTask(String url, HtmlParser htmlParser) {
                this.url        = url;
                this.htmlParser = htmlParser;
            }
            
            @Override
            public String getRawResult() {
                return null;
            }
            
            @Override
            protected void setRawResult(String s) {}
            
            @Override
            protected boolean exec() {
                List<CrawlTask> crawlTasks = new ArrayList<>();
                List<String> newUrls = htmlParser.getUrls(url);
                if (newUrls != null) {
                    newUrls.forEach(newUrl -> {
                        String newHost = getHost(newUrl);
                        if (newHost.equalsIgnoreCase(startHost)) {
                            if (set.add(newUrl)) {
                                crawlTasks.add(new CrawlTask(newUrl, htmlParser));
                            }
                        }
                    });
                }
                
                invokeAll(crawlTasks);
                return true;
            }
        }
        
        public List<String> crawl(String startUrl, HtmlParser htmlParser) {
            startHost = getHost(startUrl);
            set.add(startUrl);
            ForkJoinPool.commonPool().invoke(new CrawlTask(startUrl, htmlParser));
            return new ArrayList<>(set);
        }
        
        public String getHost(String url) {
            int idx = url.indexOf('/', 7);
            return (idx != -1) ? url.substring(0, idx) : url;
        }
    }
}
