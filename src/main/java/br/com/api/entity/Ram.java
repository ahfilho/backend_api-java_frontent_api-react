package br.com.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "ram")
public class Ram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand")
    @NotNull
    private String brand;

    @Column(name = "mhz")
    @NotNull
    private int mhz;

    @Column(name = "size", length = 4)
    @NotNull
    private int size;

    @NotNull
    @Column(name = "purchase_price")
    private float purchasePrice;

    @NotNull
    @Column(name = "purchase_date")
    private Date purchaseDate;

    @NotNull
    @Column(name = "sale_value")
    private float saleValue;

    @NotNull
    @Column(name = "arrival_date")
    private Date arrivalDate;

    @NotNull
    @Column(name = "model")
    private String model;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ram_id")
    private Image image;

    //TODO DEPOIS VER O NAME DESSA JOINCOLUMN
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ra_id")
    private Category category;

}

