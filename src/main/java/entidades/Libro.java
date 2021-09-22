package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Audited
public class Libro extends Base{

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private int fecha;

    @Column(name = "genero")
    private String genero;

    @Column(name = "paginas")
    private int paginas;

    @Column(name = "autor")
    private String autor;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
    		name = "libro_autor",
    		joinColumns = @JoinColumn(name = "libro_id"),
    		inverseJoinColumns = @JoinColumn(name = "autor_id")
    		)
    private List<Autor> autores = new ArrayList<Autor>();
}
