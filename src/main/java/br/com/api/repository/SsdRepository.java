package br.com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.entity.Ssd;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SsdRepository extends JpaRepository<Ssd, Long> {


//    @Query(value = "SELECT s FROM Ssd s inner join category (category.id = ssd.id) inner join image (image.id = ssd.id)",nativeQuery = true)
//    public List<Ssd> teste();

    //ESSA NAO DÁ ERRO,SÓ TÁ VINDO VAZIA
//    @Query("SELECT x FROM Ssd s JOIN s.category x JOIN s.image x")
//    public List<Ssd> teste();

    //    @Query("SELECT x FROM Ssd x JOIN x.category c JOIN x.img i")
//    public List<Ssd> teste();


//    @Query("SELECT x FROM Ssd x INNER JOIN Category c ON x.id = c.id INNER JOIN Img i ON x.id = i.id")
//    public List<Ssd> a();

//    @Query(value = "SELECT s FROM Ssd inner join category, inner join img", nativeQuery = true)
//    public List<Ssd> testee();


    @Query("SELECT p.arrivalDate FROM Ssd p")
    public List<String> dataDeVenda();

}
