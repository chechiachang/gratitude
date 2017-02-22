package com.ccc.system;

import java.util.concurrent.Future;

import com.ccc.system.domain.GithubUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner{

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GithubLookupService githubLookupService;

    public AppRunner(GithubLookupService githubLookupService) {
        this.githubLookupService = githubLookupService;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        Future<GithubUser> page1 = githubLookupService.findUser("pivotalSoftware");
        Future<GithubUser> page2 = githubLookupService.findUser("chechiachang");
        Future<GithubUser> page3 = githubLookupService.findUser("CloudFoundry");
        Future<GithubUser> page4 = githubLookupService.findUser("Spring-Projects");

        while (!(page1.isDone()
                && page2.isDone()
                && page3.isDone()
                && page4.isDone())){
            Thread.sleep(10);
        }

        logger.info("Elapsed time: {}", System.currentTimeMillis() - start);
        logger.info("--> {}", page1.get());
        logger.info("--> {}", page2.get());
        logger.info("--> {}", page3.get());
        logger.info("--> {}", page4.get());
    }
}
