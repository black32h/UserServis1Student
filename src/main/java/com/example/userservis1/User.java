package com.example.userservis1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")  // Оголошуємо, що цей клас є сутністю, яка відображатиметься на таблицю "users" в базі даних
public class User {

    @Id  // Вказуємо, що це поле є первинним ключем таблиці в базі даних
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Вказуємо, що значення первинного ключа буде автоматично генеруватися базою даних (наприклад, через автоінкремент)
    private Long id;

    private String name;  // Поле для збереження імені користувача
    private String email;  // Поле для збереження електронної пошти користувача
    private String role;  // Поле для збереження ролі користувача (наприклад, "ADMIN", "USER" тощо)

    // Геттери та сеттери для кожного поля

    public Long getId() {
        return id;  // Геттер для отримання значення id
    }

    public void setId(Long id) {
        this.id = id;  // Сеттер для встановлення значення id
    }

    public String getName() {
        return name;  // Геттер для отримання імені користувача
    }

    public void setName(String name) {
        this.name = name;  // Сеттер для встановлення імені користувача
    }

    public String getEmail() {
        return email;  // Геттер для отримання електронної пошти користувача
    }

    public void setEmail(String email) {
        this.email = email;  // Сеттер для встановлення електронної пошти користувача
    }

    public String getRole() {
        return role;  // Геттер для отримання ролі користувача
    }

    public void setRole(String role) {
        this.role = role;  // Сеттер для встановлення ролі користувача
    }
}
