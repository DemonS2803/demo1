package com.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "buckets")
public class Bucket {
    private static final String SEQ_NAME = "bucket_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private BigDecimal totalPrice;
    @ManyToMany
    @JoinTable(name = "buckets_products",
               joinColumns = @JoinColumn(name = "bucket_id"),
               inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productList;
}
