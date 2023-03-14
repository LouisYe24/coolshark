package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.ProductMapper;
import cn.tedu.coolshark.pojo.dto.ProductDTO;
import cn.tedu.coolshark.pojo.dto.ProductUpdateDTO;
import cn.tedu.coolshark.pojo.entity.Product;
import cn.tedu.coolshark.pojo.vo.ProductAdminVo;
import cn.tedu.coolshark.pojo.vo.ProductIndexVO;
import cn.tedu.coolshark.pojo.vo.ProductTopVO;
import cn.tedu.coolshark.pojo.vo.ProductUpdateVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.Date;
import java.util.List;

//商品控制器
@RestController
@RequestMapping("/product/")
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;




    @RequestMapping("insert")
    public void insert(@RequestBody ProductDTO productDTO){
        System.out.println("productDTO="+productDTO);
        Product p = new Product();
        BeanUtils.copyProperties(productDTO,p);
        p.setCreated(new Date());
        mapper.insert(p);
    }
//加载页面生成商品数据查询
    @RequestMapping("selectAdmin")
    public List<ProductAdminVo> selectAdmin(){
        return mapper.selectAdmin();
    }
    @RequestMapping("delete")
    public void delete(int id){
        //删除本地的图片
      String url= mapper.selectUrlById(id);
      new File("d:/files"+url).delete();
      //删除数据库的数据
        mapper.deleteById(id);
    }
    /*
    商品修改业务查询原来数据
     */
    @RequestMapping("selectUpdateById")
    public ProductUpdateVo selectUpdateById(int id){
        return mapper.selectUpdateById(id);
    }
/*
修改商品
 */
    @RequestMapping("update")
    public void update(@RequestBody ProductUpdateDTO productUpdateDTO){
        System.out.println("productUpdateDTO"+productUpdateDTO);
        //原来图片路径
        String url = mapper.selectUrlById(productUpdateDTO.getId());
        //判断新路径和原来路径的图片地址是否相同，不同就删除原来路径
        if (!url.equals(productUpdateDTO.getUrl())){
            new File("d:/files"+url).delete();
        }
        Product product = new Product();
        BeanUtils.copyProperties(productUpdateDTO,product);

        //最好动态sql修改，降低耦合

        mapper.update(product);
    }

    @RequestMapping("selectTop")
    public List<ProductTopVO> selectTop(){
        return mapper.selectTop();
    }
    @RequestMapping("selectIndex")
    public List<ProductIndexVO> selectIndex(){
        return mapper.selectIndex();
    }


}
