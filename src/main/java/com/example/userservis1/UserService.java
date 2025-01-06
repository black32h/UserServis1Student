package com.example.userservis1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Впроваджуємо репозиторій для доступу до даних користувача
    @Autowired
    private UserRepository userRepository;

    // Створення нового користувача в базі даних
    public User createUser(User user) {
        // Для поля id не треба використовувати setId, оскільки воно генерується автоматично.
        return userRepository.save(user);  // Зберігаємо нового користувача в базі даних
    }

    // Отримання користувача за його ID
    public User getUserById(Long userId) {
        // Якщо користувач не знайдений, повертаємо null
        return userRepository.findById(userId).orElse(null); 
    }

    // Оновлення інформації про користувача за його ID
    public User updateUser(Long userId, User user) {
        // Знаходимо існуючого користувача за ID
        User existingUser = getUserById(userId);
        if (existingUser != null) {
            // Оновлюємо дані користувача
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            // Зберігаємо оновленого користувача
            return userRepository.save(existingUser);
        }
        return null; // Якщо користувач не знайдений
    }

    // Видалення користувача за ID
    public void deleteUser(Long userId) {
        // Видаляємо користувача з бази даних
        userRepository.deleteById(userId);
    }
}
