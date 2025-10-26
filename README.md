# 金苹果烘培

#### 介绍
金苹果烘焙是一家专注于高品质烘焙食品的现代化品牌，致力于为顾客带来美味与幸福并存的烘焙体验。

#### 技术亮点
## 阿里云 OSS - 对象存储

**用途：** 存储所有图片资源。

**应用场景：**
- 商品主图、详情图
- 用户评价的图片
- 广告横幅图
- 用户头像

**后端实现：**
- 后端不存储图片文件本身，而是存储文件的OSS URL
- 提供一个上传接口，前端上传文件后，后端调用OSS SDK生成一个预签名URL，后端服务接收文件后转发至OSS
- 成功后，将文件的URL返回并保存到数据库

---

## Redis - 缓存与会话存储

**用途一：缓存热点数据 (配合 Spring Cache)**

**应用场景：**
- **商品信息：** 将频繁访问的商品详情页数据缓存起来，减轻MySQL压力。`@Cacheable(key="'product:' + #id")`
- **商品分类：** 几乎不变的数据，非常适合缓存

**实现：** 使用Spring Cache注解（如 `@Cacheable`, `@CacheEvict`）来透明地操作Redis。当商品信息更新时，使用 `@CacheEvict` 清除缓存，保证数据一致性。

**用途二：购物车**

**应用场景：** 用户未登录时或将商品添加到购物车时

**数据结构：** 使用 `Hash`。Key: `"cart:userId"`， Field: `productId`， Value: 商品数量、选中状态等JSON信息

**优势：** 读写速度快，与用户会话绑定，比存在数据库或前端本地更灵活

---

## MySQL - 核心数据持久化

---

## RabbitMQ - 异步处理与解耦

**核心应用：订单超时自动取消**

**业务流程：**
1. 用户创建订单，状态为 **"待付款"**
2. 订单服务向RabbitMQ的 **"order.delay.queue"** （一个延迟队列）发送一条消息，消息体为订单ID，并设置TTL（例如30分钟）
3. 30分钟后，消息死亡，被自动转发到 **"order.release.queue"** （一个死信队列）
4. 订单服务的消费者监听 `order.release.queue`
5. 消费者收到消息后，检查订单状态
   - 如果订单仍是 **"待付款"**，则执行取消逻辑：修改订单状态为 **"已取消"**，并恢复商品库存
   - 如果订单已支付，则直接确认消息，什么都不做

**优势：**
- **异步化：** 主下单流程不阻塞
- **可靠：** 即使服务重启，消息仍在队列中
- **解耦：** 订单服务与库存服务等解耦

---

## Spring Cache - 声明式缓存

**用途：** 简化缓存操作，通过注解即可实现

**配置示例：**
```java
@Configuration
@EnableCaching
public class CacheConfig {
    // 配置CacheManager，通常使用RedisCacheManager
}

@Service  
public class ProductServiceImpl implements ProductService {
    
    @Cacheable(value = "product", key = "#id")
    public Product getProductById(Long id) {
        // 从数据库查询
        return productMapper.selectById(id);
    }
    
    @CacheEvict(value = "product", key = "#product.id")
    public void updateProduct(Product product) {
        // 更新数据库
        productMapper.updateById(product);
        // 更新后自动清除缓存，下次查询时再加载最新数据
    }
}
```

#### 软件架构
软件架构说明


#### 使用说明

1.  使用git拉取下来之后启动程序
2.  输入网址localhost:8082/

