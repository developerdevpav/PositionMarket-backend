package by.psu.model.postgres;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(
        name = "string_values"
)
@Table(
        name = "string_values"
)
@Getter @Setter
@AllArgsConstructor
public class StringValue extends BasicEntity {

    @Column(name = "language", nullable = false, length = 120)
    private UUID language;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "id_translate")
    private Translate translate;

}
