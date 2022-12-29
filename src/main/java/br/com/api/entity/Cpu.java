package br.com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@Data
@Entity
@Table(name = "CPU")
@NoArgsConstructor
public class Cpu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CPU_ID")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "serial_number")
    private String serialNumber;

    @Column(name = "model")
    private String model;

    @Column(name = "purchase_price")
    private float purchasePrice;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    @Column(name = "sale_value")
    private float saleValue;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @Column(name = "core")
    private int core;

    @Column(name = "threads")
    private int threads;

    @Column(name = "clock")
    private float clock;

    @Column(name = "overclock")
    private boolean overclock;

    @Column(name = "url")
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CPU_ID")
    private File image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "CPU_ID")
    private Category category;


}
