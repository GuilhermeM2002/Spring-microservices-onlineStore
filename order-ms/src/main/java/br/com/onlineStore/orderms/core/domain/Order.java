package br.com.onlineStore.orderms.core.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.OffsetDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "order")
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private OffsetDateTime dateTime;
    @NotNull
    private double value;
    @NotBlank
    private String TrackingCode;
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Status status;
}
