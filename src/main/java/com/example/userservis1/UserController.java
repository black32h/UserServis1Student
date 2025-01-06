package com.example.userservis1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController  // Вказуємо, що цей клас є контролером для обробки HTTP запитів
@RequestMapping("/users")  // Визначаємо базовий шлях для всіх запитів до користувачів
public class UserController {

    // Впроваджуємо сервіс для обробки бізнес-логіки
    @Autowired
    private UserService userService;

    // Створення нового користувача
    @PostMapping  // Використовуємо POST запит для створення користувача
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        // Створюємо користувача та повертаємо його з відповідним статусом 201 (Created)
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    // Отримання користувача за ID
    @GetMapping("/{id}")  // Використовуємо GET запит для отримання користувача
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        try {
            // Пошук користувача за ID
            User user = userService.getUserById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);  // Якщо знайдено, повертаємо статус 200 (OK)
        } catch (RuntimeException e) {
            // Якщо користувач не знайдений, повертаємо статус 404 (Not Found)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Оновлення інформації про користувача
    @PutMapping("/{id}")  // Використовуємо PUT запит для оновлення користувача
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        try {
            // Оновлюємо користувача за ID
            User updatedUser = userService.updateUser(id, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);  // Якщо оновлення успішне, повертаємо статус 200 (OK)
        } catch (RuntimeException e) {
            // Якщо користувач не знайдений, повертаємо статус 404 (Not Found)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Видалення користувача
    @DeleteMapping("/{id}")  // Використовуємо DELETE запит для видалення користувача
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            // Видаляємо користувача за ID
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);  // Якщо видалено, повертаємо статус 204 (No Content)
        } catch (RuntimeException e) {
            // Якщо користувач не знайдений, повертаємо статус 404 (Not Found)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
