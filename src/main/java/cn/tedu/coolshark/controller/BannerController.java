package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.dto.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/banner/")
public class BannerController {
    @Autowired(required = false)
    BannerMapper mapper;
    @RequestMapping("select")
    public List<Banner> select() {
        return mapper.select();
    }

    @RequestMapping("insert")
    public void insert(String url) {
        mapper.insert(url);
    }

    @RequestMapping("delete")
    public void deleteById(int id) {
        //通过轮播图id查询到url
        String url = mapper.selectUrlById(id);
        new File("d:/files" + url).delete();
        //删除数据库里面的数据
        mapper.deleteById(id);
    }

    @RequestMapping("selectById")
    public Banner selectById(int id) {
        return mapper.selectById(id);
    }

    @RequestMapping("update")
    public List<Banner> update(@RequestBody Banner banner) {
         mapper.update(banner);
        return  mapper.select();
    }




}
