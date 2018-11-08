package com.basung.ecommerce.wares.spec;

import com.basung.ecommerce.common.entity.AutoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

/**
 * 商品规格 eg: 颜色、尺码
 * <p>
 * Date: 2018-10-19-上午10:45
 */

@Entity
@Table(name = "BSS_WARES_SPEC")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Spec extends AutoEntity {

    /**
     * 商品规格名称
     */
    @Column(name = "spec_name", length = 128)
    private String specName;

    /**
     * 规格备注
     */
    @Column(name = "spec_remark", length = 128)
    private String specRemark;

    /**
     * 是否开启规格图片
     */
    @ApiModelProperty(value = "是否可用")
    @Column(name = "is_spec_image")
    private Integer isSpecImage = 0;

    /**
     * 商品规格值
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "spec_id", referencedColumnName = "id")
    private List<SpecItem> specItems;

}
