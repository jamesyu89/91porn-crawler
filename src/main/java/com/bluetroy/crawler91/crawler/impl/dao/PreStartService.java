package com.bluetroy.crawler91.crawler.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: heyixin
 * Date: 2018-07-09
 * Time: 下午7:49
 */
@Component
@Order(1)
public class PreStartService implements CommandLineRunner {
    @Autowired
    Repository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.init();
    }
}