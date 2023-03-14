package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.pojo.dto.Banner;

import java.util.List;

public interface BannerMapper {
    List<Banner> select();

    void deleteById(int id);

    void insert(String url);

    String selectUrlById(int id);
    

    int update(Banner banner);

    Banner selectById(int id);
}
