package org.example.javalibrary.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
@Table(name = "topic_library")
public class Question {

    @Id
    @Column(name = "topic_library_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Lob
    @Column(name = "content")
    private String content;

    @Enumerated(EnumType.STRING) // Сохраняем Enum как строку в базе данных
    @Column(name = "topic_area")
    private TopicArea topicArea;


    public Question() {
    }
}