package hu.elte.alkfejl.issuetracker.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Created by ViktoriaGecse on 21/09/2017
 */

@Data //lombok generates setters, getters, equals, hashcode
@MappedSuperclass // we won't use this as a individual entity, just use it for other entities
public class BaseEntity {
    @Id // this field will identify the entities
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    // if more than one person modifies the data
    @Version
    private int version;
}
