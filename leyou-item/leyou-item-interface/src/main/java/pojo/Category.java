package pojo;

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
 * @date 2019/10/19 15:51
 * @feature: 商品分类对应的实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tb_category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    /**
     * 排序指数，越小越靠前
     */
    private Integer sort;
}
