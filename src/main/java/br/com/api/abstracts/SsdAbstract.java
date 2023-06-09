package br.com.api.abstracts;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import br.com.api.entity.Category;
import br.com.api.entity.Client;
import br.com.api.entity.Cpu;
import br.com.api.entity.File;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SSD")
@Entity
public abstract class SsdAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SSD_ID")
    private Long id;

    @Column(name = "brand")
    @NotNull
    private String brand;

    @Column(name = "serial_number", length = 17)
    @NotNull
    private String serialNumber;

    @NotNull
    @Column(name = "size_storage", length = 4)
    private String size;

    @NotNull
    @Column(name = "purchase_price")
    private String purchasePrice;

    @NotNull
    @Column(name = "purchase_date")
    private String purchaseDate;

    @NotNull
    @Column(name = "sale_value")
    private float saleValue;

    @Column(name = "arrival_date")
    private String arrivalDate;

    @Column(name = "url")
    private String url;

    @Column(name = "amount")
    private int amount;

    @NotNull
    @Column(name = "model")
    private String model;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSD_ID")
    private File image;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSD_ID")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CPU_ID")
    private Cpu cpu;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SSD_ID")
    private Client client;
}