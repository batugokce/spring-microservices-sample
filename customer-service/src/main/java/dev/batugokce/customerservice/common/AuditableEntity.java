package dev.batugokce.customerservice.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity extends BaseEntity {

    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdDate;

}
