package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.ProductAdminVo;
import cn.tedu.coolshark.pojo.vo.ProductIndexVO;
import cn.tedu.coolshark.pojo.vo.ProductTopVO;
import cn.tedu.coolshark.pojo.vo.ProductUpdateVo;

import java.util.List;

public interface ProductMapper {
    void insert(Product product);

    List<ProductAdminVo> selectAdmin();

    String selectUrlById(int id);

    void deleteById(int id);

    ProductUpdateVo selectUpdateById(int id);

    void update(Product product);

    List<ProductTopVO> selectTop();

    List<ProductIndexVO> selectIndex();
}
