package br.com.api.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ssd")
public class Ssd {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "brand")
	@NotNull
	private String brand;

	@Column(name = "serial_number", length = 17)
	@NotNull
	private int serialNumber;

	@NotNull
	@Column(name = "size_storage", length = 4)
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

	@Column(name = "arrival_date")
	private Date arrivalDate;

	@NotNull
	@Column(name = "model")
	private String model;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "name")
	private Image image;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category")
	private Category category;

}
