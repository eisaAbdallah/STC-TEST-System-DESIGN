package com.example.stc.test.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Loader;

@Entity
@Table(name="files")
@NoArgsConstructor
@Getter
@Setter
public class Files {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="file")
    @Lob
    byte[] file;
    @OneToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    Item item;

}
