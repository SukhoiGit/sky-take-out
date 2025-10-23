package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DishService {

    /**
     * 菜品分页查询
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查菜品和对应的口味数据
     */
    DishVO getByIdWithFlavour(Long id);

    /**
     * 根据id修改菜品基本信息和对应的口味信息
     */
    void updateWithFlavor(DishDTO dishDTO);

    /**
     * 新增菜品
     */
    void saveWithFlavor(DishDTO dishDTO);

    /**
     * 根据分类id查询菜品
     */
    List<Dish> list(Long categoryId);

    /**
     * 起售或停售套餐
     */
    void startOrStop(Integer status, Long id);
}
