package com.basung.ecommerce.wares.goods;

import com.basung.ecommerce.common.entity.AutoEntity;
import com.basung.ecommerce.wares.goodsImage.GoodsImage;
import com.basung.ecommerce.wares.goodsSku.GoodsSKU;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Date: 2018-10-19-上午10:57
 */

@Entity
@Table(name = "BSS_WEARS_GOODS")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Goods extends AutoEntity {


    //商品状态: 未上架商品
    public static final int STATUS_NEW = 0;
    //商品状态: 已上架商品
    public static final int STATUS_ON_SALE = 1;
    //商品状态: 已下架商品
    public static final int STATUS_OFF_SALE = 2;

    //规格类型：统一规格
    public static final int SPEC_TYPE_COMMON = 1;
    //规格类型：多规格
    public static final int SPEC_TYPE_MULTI = 3;

    //商品类型: 实体商品
    public static final int PHYSICAL_GOODS = 1;
    //商品类型: 虚拟商品
    public static final int VIRTUAL_GOODS =2;

    /**
     * 商品名称
     */
    @Column( name = "name", length = 128 )
    private String name;


    /**
     * 商品主图
     */
    @Column( name = "goods_default_image" )
    private String goodsDefaultImage;

    /**
     * 商品编码
     */
    @Column(name = "code")
    private String code;

    /**
     * 商品类型
     */
    @Column(name = "goods_type")
    private int goods_type = PHYSICAL_GOODS;

    /**
     * 商品状态 - 0 - 未上架  1 - 上架  2 - 下架
     */
    @Column(name = "status")
    private int status = STATUS_NEW;


    /**
     * 规格类型：统一规格，多规格
     */
    @Column(name = "spec_type")
    private int specType = SPEC_TYPE_COMMON;

    /**
     * 商品买点
     */
    @Column(name = "buying_point", length = 512)
    private String buyingPoint;

    /**
     * 商品关键词
     */
    @Column(name = "goods_keyword", length = 512)
    private String goodsKeyword;

    /**
     * 商品简介
     */
    @Column(name = "brief", length = 512)
    private String brief;

    /**
     * 详细信息
     */
    @Lob
    @Column(name = "details")
    private String details;

    /**
     * 货号
     */
    @Column(name = "product_number", length = 128)
    private String productNumber;

    /**
     * 生产厂家
     */
    @Column(name = "manufacturer", length = 64)
    private String manufacturer;


    /**
     * 价格,单位为元，如果为统一规则，那么价格字段为必填，否则可以为空
     */
    @Column(name = "sale_price")
    private double salePrice;

    /**
     * 市场价格,单位为元
     */
    @Column(name = "market_price")
    private double marketPrice;

    /**
     * 成本价格,单位为元
     */
    @Column(name = "cost_price")
    private double costPrice;

    /**
     * 库存，  如果为统一规则，那么库存字段为必填，否则可以为空
     */
    @Column(name = "stock_num")
    private long stockNum;

    /**
     * 商品重量: 单位为千克
     */
    @Column(name = "goods_weight")
    private long goodsWeight;

    /**
     * 长度,单位为厘米
     */
    @Column(name = "goods_length")
    private float goods_Length;

    /**
     * 宽度,单位为厘米
     */
    @Column(name = "goods_width")
    private float goodsWidth;

    /**
     * 高度,单位为厘米
     */
    @Column(name = "goods_height")
    private float goodsHeight;

    /**
     * 上架时间
     */
    @Column(name = "sale_up_date")
    private Date saleUpDate;

    /**
     * 下架时间
     */
    @Column(name = "sale_down_date")
    private Date saleDownDate;

    /**
     * 商品积分
     */
    @Column(name = "goods_score")
    private int goodsScore;

    /**
     * 商品单位
     */
    @Column(name = "goods_unit")
    private int goodsUnit;

    /**
     * 商品品论次数
     */
    @Column(name = "comments_count")
    private int commentsCount;

    /**
     * 商品周浏览次数
     */
    @Column(name = "view_week_count")
    private int viewWeekCount;

    /**
     * 浏览次数
     */
    @Column(name = "view_count")
    private int viewCount;

    /**
     * 周购买次数
     */
    @Column(name = "buy_week_count")
    private int buyWeekCount;

    /**
     * 购买次数
     */
    @Column(name = "buy_count")
    private int buyCount;

    /**
     * 起定量
     */
    @Column(name = "min_buy")
    private int minBuy;


    /********************************
     *
     * 商品关联属性
     * eg: 分类、品牌
     *
     * *******************************/

    /**
     * 商品分类标识
     */
    @Column(name = "category_id", nullable = false)
    private String categoryId;

    /**
     * 商品分类名称
     */
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    /**
     * 商品品牌标识
     */
    @Column(name = "brand_id", nullable = false)
    private String brandId;

    /**
     * 商品品牌名称
     */
    @Column(name = "brand_name", nullable = false)
    private String brandName;


    /**
     * 商品图片，在不使用sku的时候使用
     */
    @Transient
    private List<GoodsImage> imageList;

    /**
     * SKU信息
     */
    @Transient
    private List<GoodsSKU> skuList;

//
//    /**
//     * 运费信息
//     */
//    @Transient
//    private Carriage carriage;




}
