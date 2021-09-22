package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "localidad")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Localidad extends Base{

    @Column(name = "denominacion")
    private String denominacion;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Domicilio> domicilios = new ArrayList<Domicilio>();
}