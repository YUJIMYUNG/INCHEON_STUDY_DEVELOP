package day65.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
@Getter @Setter @Builder @ToString
@AllArgsConstructor @NoArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String mid;

    @Column(columnDefinition = "varchar(50)")
    private  String mpwd;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL)
    @Builder.Default
    List<BoardEntity> boardEntityList = new ArrayList<>();
}
