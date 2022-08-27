package br.com.api.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_category")
    private String productCategory;


	@OneToOne
	//@JoinColumn(name = "SSD_ID")
	private Ssd ssd;

	@OneToOne
	//@JoinColumn(name = "RAM_ID")
	private Ram ram;



}