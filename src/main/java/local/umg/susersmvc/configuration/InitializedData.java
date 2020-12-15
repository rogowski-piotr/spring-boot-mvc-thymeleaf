package local.umg.susersmvc.configuration;

import local.umg.susersmvc.model.User;
import local.umg.susersmvc.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializedData {

    private UserService service;

    public InitializedData(UserService service) {
        this.service = service;
    }

    @PostConstruct
    private synchronized void init() {
        User user1 = User.builder()
                .firstName("John")
                .lastName("Smith")
                .country("USA")
                .email("john@example.com")
                .uniquePersonNumber(3849927L)
                .build();

        User user2 = User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .country("PL")
                .email("jan@example.com")
                .uniquePersonNumber(4894656L)
                .build();

        service.create(user1);
        service.create(user2);
    }

}
