package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "autor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Autor extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name = "biografia", length=1500)
    private String biografia;
}