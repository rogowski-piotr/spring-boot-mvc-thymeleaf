package local.umg.susersmvc.service;

import local.umg.susersmvc.model.User;
import local.umg.susersmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public List<User> findAllSortById() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public List<User> findAllSortByFirstName() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
    }

    public List<User> findAllSortByLastName() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    public List<User> findAllSortByEmail() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "email"));
    }

    public List<User> findAllSortByUniquePersonNumber() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "uniquePersonNumber"));
    }

    public List<User> findAllSortByCountry() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "country"));
    }

    public Optional<User> find(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void create(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(User user) {
        repository.save(user);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
