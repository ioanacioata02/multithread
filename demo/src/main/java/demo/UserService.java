package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

@Service
public class UserService {
    Logger logger = LoggerFactory.getLogger(UserService.class);
    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(1, "Ioana", 20));
        userList.add(new User(2, "Maria", 18));
    }

    @Async
    public CompletableFuture<List<User>> getAll(){
        logger.info("Thread working " + Thread.currentThread().getName());
        try {
            sleep(15000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return CompletableFuture.completedFuture(userList);
    }
}
