package com.lcwd.user.service.entities;

import jakarta.persistence.*;
import lombok.*;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.ArrayList;
//import java.util.List;
import java.util.Objects;

// creating entity of the database
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {

    //properties or attributes
    @Id
    @Column(name = "ID")
    private String userId;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String  about;

//    @Transient   // Don't want to save in MySQL Database, Therefore @Transient means JPA will ignore this
//    private List<Rating> ratings = new ArrayList<>();


    //add toString method for
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

//    User user1 = new User("1", "John", "john@email.com", "About John");
//    User user2 = new User("2", "Milind", "Milind@gmail.com", "About Milind");

}
