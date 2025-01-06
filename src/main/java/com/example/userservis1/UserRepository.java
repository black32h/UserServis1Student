package com.example.userservis1;

import org.springframework.data.jpa.repository.JpaRepository;

// Інтерфейс для роботи з таблицею користувачів в базі даних
// JpaRepository надає стандартні методи для виконання CRUD операцій
public interface UserRepository extends JpaRepository<User, Long> {

    // JpaRepository автоматично надає методи для:
    // - збереження користувача (save)
    // - знаходження користувача за ID (findById)
    // - видалення користувача (delete)
    // - перевірки існування користувача (existsById) та інші
    // Не потрібно вручну писати ці методи, Spring Data JPA робить це за нас
}
