package by.psu.model.postgres;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(
        name = "images"
)
@Table(
        name = "images"
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = "url")
public class Image extends BasicEntity {

    @Column(name = "url", nullable = false)
    public String url;

}
