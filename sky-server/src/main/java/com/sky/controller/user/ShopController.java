package com.sky.controller.user;

import com.sky.result.Result;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺相关接口
 */
@RestController("userShopController")
@RequestMapping("/user/shop")
@RequiredArgsConstructor
@Slf4j
public class ShopController {

    public static final String KEY = "SHOP_STATUS";

    private final RedisTemplate redisTemplate;

    /**
     * 获取店铺营业状态
     */
    @GetMapping("/status")
    public Result<Integer> getStatus() {
        Integer status = (Integer) redisTemplate.opsForValue().get(KEY);
        log.info("获取到店铺的营业状态为：{}", status == 1 ? "营业中" : "打烊中");
        return Result.success(status);
    }
}
