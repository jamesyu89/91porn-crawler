package com.bluetroy.crawler91.crawler.impl.filter.impl.filter;

import com.bluetroy.crawler91.crawler.impl.dao.Repository;
import com.bluetroy.crawler91.crawler.impl.filter.Filter;
import com.bluetroy.crawler91.crawler.impl.utils.ApplicationContextProvider;
import lombok.ToString;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author heyixin
 */
@ToString
public class TitleFilter implements Filter {
    @ToString.Exclude
    private Repository repository;
    private String keyword;

    public TitleFilter(String keyword) {
        this.keyword = keyword;
        repository = ApplicationContextProvider.getBean("repository", Repository.class);
    }

    private TitleFilter() {
    }

    @Override
    public void doFilter(ConcurrentHashMap<String, Boolean> tobeFilter) {
        tobeFilter.forEach(5, (k, v) -> {
            if (repository.getMovieData().get(k).getTitle().contains(keyword)) {
                return;
            }
            tobeFilter.remove(k);
        });
    }

}