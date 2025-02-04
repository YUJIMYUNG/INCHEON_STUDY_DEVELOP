package korweb.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class CategoryEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno; // 카테고리 번호

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String cname; // 카테고리 이름



}
