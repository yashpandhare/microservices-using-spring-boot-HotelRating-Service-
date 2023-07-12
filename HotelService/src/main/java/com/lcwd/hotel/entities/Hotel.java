package com.lcwd.hotel.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME", length = 20)
    private String name;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "ABOUT")
    private String about;

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId='" + id + '\'' +
                ", hotelName='" + name + '\'' +
                ", location='" + location + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        Hotel hotel = (Hotel) obj;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
