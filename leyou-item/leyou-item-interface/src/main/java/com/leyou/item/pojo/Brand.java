package com.leyou.item.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author DillonXie
 * @version 1.0
 * @date 10/23/2019 7:37 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_brand")
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //品牌名称
    private String name;
    //品牌图片
    private String image;
    private Character letter;
}
